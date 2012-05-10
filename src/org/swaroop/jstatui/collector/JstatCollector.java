/**
 * Created on May 9, 2012
 */
package org.swaroop.jstatui.collector;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.Callable;

import org.apache.log4j.Logger;
import org.swaroop.jstatui.bean.JstatHostBean;
import org.swaroop.jstatui.error.JstatUIError;

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

  public JstatCollector(JstatHostBean hostBean, JStatsOptions statType) {
    this.host = hostBean.getHost();
    this.PID = hostBean.getJvmProcessId();
    this.statType = statType.getStatType();
  }

  @Override
  public JstatCollector call() throws Exception {
    String jstat = jstatCMD + " -" + statType + " -t rmi://" + PID + "@" + host
        + ":" + 2222 + " " + SAMPLE_INTERVAL;
    startCollection(jstat);
    return null;
  }

  /**
   * Starts stat collection
   * 
   * @param command
   */
  public void startCollection(String command) {
    try {
      Process jstatProc = Runtime.getRuntime().exec(command);
      BufferedReader br = new BufferedReader(new InputStreamReader(
          jstatProc.getInputStream()));
      String line = br.readLine();
      while ((line = br.readLine()) != null) {
        
      }
    } catch (IOException e) {
      log.error(e, e);
      JstatUIError.addErrors(603, "Error in jstat command execution");
    }
  }

}
