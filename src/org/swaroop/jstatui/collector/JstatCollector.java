/**
 * Created on May 9, 2012
 */
package org.swaroop.jstatui.collector;

import java.util.concurrent.Callable;

/**
 * Core stat collector thread
 * 
 * @author Swaroop Patra
 * 
 */
public class JstatCollector implements Callable<JstatCollector> {

  // jstat -class -t -h<hdr_repeat> <pid> <interval> <sample>
  private String statType = "";

  private final int PID = 0;

  private static final int SAMPLE_INTERVAL = 500;

  private String jstatCMD = "jstat";
  
  private String finalCMD = "";
  
  public JstatCollector(int pid, String statType){
    this.PID = pid;
    this.statType = statType;
  }

  @Override
  public JstatCollector call() throws Exception {

    return null;
  }

}
