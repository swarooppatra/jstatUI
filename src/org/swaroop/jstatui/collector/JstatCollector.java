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
import org.swaroop.jstatui.bean.JstatCompilerBean;
import org.swaroop.jstatui.bean.JstatGCBean;
import org.swaroop.jstatui.bean.JstatGCCapacityBean;
import org.swaroop.jstatui.bean.JstatGCCauseBean;
import org.swaroop.jstatui.bean.JstatGCNewBean;
import org.swaroop.jstatui.bean.JstatGCNewCapacityBean;
import org.swaroop.jstatui.bean.JstatGCOldBean;
import org.swaroop.jstatui.bean.JstatGCOldCapacityBean;
import org.swaroop.jstatui.bean.JstatGCPermCapacityBean;
import org.swaroop.jstatui.bean.JstatGCUtilBean;
import org.swaroop.jstatui.bean.JstatHostBean;
import org.swaroop.jstatui.bean.JstatOptionBean;
import org.swaroop.jstatui.bean.JstatPrintCompilatinBean;
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

  private final String host;

  private final JStatOptions statType;

  private final String statTypeName;

  private final int PID;

  private static final int SAMPLE_INTERVAL = 500;

  private String jstatCMD = "jstat";

  JstatOptionBean bean = null;

  private int hostID = 0;

  public JstatCollector(JstatHostBean hostBean, JStatOptions statType) {
    this.host = hostBean.getHost();
    this.PID = hostBean.getJvmProcessId();
    this.statType = statType;
    this.statTypeName = statType.getStatType();
    this.hostID = hostBean.getId();
    switch (statType) {
    case CLASS:
      bean = new JstatClassBean();
      break;
    case COMPILER:
      bean = new JstatCompilerBean();
      break;
    case GC:
      bean = new JstatGCBean();
      break;
    case GC_CAPACITY:
      bean = new JstatGCCapacityBean();
      break;
    case GC_CAUSE:
      bean = new JstatGCCauseBean();
      break;
    case GC_NEW:
      bean = new JstatGCNewBean();
      break;
    case GC_NEW_CAPACITY:
      bean = new JstatGCNewCapacityBean();
      break;
    case GC_OLD:
      bean = new JstatGCOldBean();
      break;
    case GC_OLD_CAPACITY:
      bean = new JstatGCOldCapacityBean();
      break;
    case GC_PERM_CAPACITY:
      bean = new JstatGCPermCapacityBean();
      break;
    case GC_UTIL:
      bean = new JstatGCUtilBean();
      break;
    case PRINT_COMPILATION:
      bean = new JstatPrintCompilatinBean();
      break;
    default:
      log.error("Invalid Option. HOW???");
      JstatUIError.addErrors(600, "Invalid option. HOW???");
    }
  }

  @Override
  public JstatCollector call() throws Exception {
    log.info("New collection thread created");
    String jstat = jstatCMD + " -" + statTypeName + " -t rmi://" + PID + "@"
        + host + ":" + 1099 + " " + SAMPLE_INTERVAL;
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
          JstatOptionBean optionBean = bean.parseStat(stat);
          switch (statType) {
          case CLASS:
            ((JstatClassBean) optionBean).setHostID(hostID);
            break;
          case COMPILER:
            ((JstatCompilerBean) optionBean).setHostID(hostID);
            break;
          case GC:
            ((JstatGCBean) optionBean).setHostID(hostID);
            break;
          case GC_CAPACITY:
            ((JstatGCCapacityBean) optionBean).setHostID(hostID);
            break;
          case GC_CAUSE:
            ((JstatGCCauseBean) optionBean).setHostID(hostID);
            break;
          case GC_NEW:
            ((JstatGCNewBean) optionBean).setHostID(hostID);
            break;
          case GC_NEW_CAPACITY:
            ((JstatGCNewCapacityBean) optionBean).setHostID(hostID);
            break;
          case GC_OLD:
            ((JstatGCOldBean) optionBean).setHostID(hostID);
            break;
          case GC_OLD_CAPACITY:
            ((JstatGCOldCapacityBean) optionBean).setHostID(hostID);
            break;
          case GC_PERM_CAPACITY:
            ((JstatGCPermCapacityBean) optionBean).setHostID(hostID);
            break;
          case GC_UTIL:
            ((JstatGCUtilBean) optionBean).setHostID(hostID);
            break;
          case PRINT_COMPILATION:
            ((JstatPrintCompilatinBean) optionBean).setHostID(hostID);
            break;
          default:
            log.error("Invalid Option. HOW???");
            JstatUIError.addErrors(600, "Invalid option. HOW???");
          }
          System.out.println(optionBean.getClass() + "\nstat" + stat + "\n bean" + optionBean);
          boolean inserted = ORMProcessor.insertABean(optionBean, conn);
          Thread.sleep(1000 * 60 * 15);
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
