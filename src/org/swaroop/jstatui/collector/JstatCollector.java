/**
 * Created on May 9, 2012
 */
package org.swaroop.jstatui.collector;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.util.Date;
import java.util.concurrent.Callable;

import org.apache.log4j.Logger;
import org.swaroop.jstatui.bean.JstatClassBean;
import org.swaroop.jstatui.bean.JstatHostBean;
import org.swaroop.jstatui.bean.JstatOptionBean;
import org.swaroop.jstatui.db.DBConnection;
import org.swaroop.jstatui.error.JstatUIError;
import org.swaroop.jstatui.orm.ORMProcessor;

/**
 * Core stat collector thread
 * 
 * @author Swaroop Patra
 * 
 */
public class JstatCollector implements Callable<JstatCollector> {

  private static final Logger log = Logger.getLogger("jstatui");

  private String host = "";

  // jstat -class -t -h<hdr_repeat> <pid> <interval> <sample>
  private String statType = "";

  private final int PID;

  private static final int SAMPLE_INTERVAL = 500;

  private String jstatCMD = "jstat";

  JstatOptionBean bean = null;

  private int hostID = 0;

  public JstatCollector(JstatHostBean hostBean, JStatsOptions statType) {
    this.host = hostBean.getHost();
    this.PID = hostBean.getJvmProcessId();
    this.statType = statType.getStatType();
    this.hostID = hostBean.getId();
    switch (statType) {
    case CLASS:
      bean = new JstatClassBean();
      break;
    // TODO : add rest of the stat type
    default:
      bean = new JstatClassBean();
    }
  }

  @Override
  public JstatCollector call() throws Exception {
    log.info("New collection thread created");
    String jstat = jstatCMD + " -" + statType + " -t rmi://" + PID + "@" + host
        + ":" + 1099 + " " + SAMPLE_INTERVAL;
    log.info("jstat COMMAND  ::  " + jstat);
    startCollection(jstat);
    return null;
  }

  /**
   * Start stat collection
   * 
   * @param command
   */
  public void startCollection(String command) {
    try {
      Process jstatProc = Runtime.getRuntime().exec(command);
      BufferedReader br = new BufferedReader(new InputStreamReader(
          jstatProc.getInputStream()));
      String stat = br.readLine();
      log.info("Fetching stats from jstat");
      DBConnection dbConn = new DBConnection();
      Connection conn = dbConn.getConnection();
      long date1 = new Date().getTime(), date2 = new Date().getTime();
      while (true) {
        stat = br.readLine();
        date1 = new Date().getTime();
        if (date1 - date2 > (30 * 1000)) {
          log.error("Exceded timeout. May be process is not running");
          log.info("#############################");
          log.info("Shuting down Executor service");
          log.info("#############################");
          JstatMain.shutdownAndAwaitTermination(JstatMain.service);
          break;
        }
        if (stat != null && !"".equals(stat)) {
          JstatClassBean optionBean = (JstatClassBean) bean.parseStat(stat);
          optionBean.setHostID(hostID);
          boolean inserted = ORMProcessor.insertABean(optionBean, conn);
          if (inserted) {
            date2 = new Date().getTime();
          }
        }
      }
    } catch (IOException e) {
      log.error(e, e);
      JstatUIError.addErrors(603, "Error in jstat command execution");
    } catch (Exception e) {
      log.error(e, e);
    }
  }
}
