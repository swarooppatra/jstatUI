/**
 * Created on May 3, 2012
 */
package org.swaroop.jstatui.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.log4j.Logger;
import org.swaroop.jstatui.error.JstatUIError;

/**
 * This is a util class for a process in OS
 * 
 * @author Swaroop Patra
 * 
 */
public class ProcessUtil {

  private static final Logger log = Logger.getLogger("jstatui");

  /**
   * Returns underlying OS name
   * 
   * @return Returns underlying OS name
   */
  public static String getOS() {
    log.info("Underlying OS : " + System.getProperty("os.name"));
    return System.getProperty("os.name");
  }

  /**
   * Returns start time of a process
   * 
   * @param host
   *          Host name
   * @param processID
   *          process ID
   * @return Start time of supplied process on supplied host
   */
  public static String getProcessStartDateTime(String host, int processID) {
    log.info("Fetching Process start time");
    String startDateTime = "";
    if (processID < 0 || host == null || "".equals(host)) {
      log.error("Invalid Process ID/Host name supplied");
      JstatUIError.addErrors(600, "Invalid Process ID/Host name supplied");
      return startDateTime;
    }
    String os = getOS();
    if (!"".equals("")) {
      os = os.trim().toLowerCase();
      if (os.contains("windows")) {
        return getProcessStartDateTimeOnWindows(host, processID);
      } else if (os.contains("linux")) {
        return getProcessStartDateTimeOnLinux(host, processID);
      } else {
        log.error(os + " not yet supported");
        JstatUIError.addErrors(609, os + " not yet supported");
      }
    }
    return startDateTime;
  }

  /**
   * Returns start time of a process specific to Linux OS
   * 
   * @param host
   *          Host name
   * @param processID
   *          process ID
   * @return Start time of supplied process on supplied host
   */
  private static String getProcessStartDateTimeOnWindows(String host,
      int processID) {
    String startDateTime = "";
    String command = "tasklist /V /FI \"PID eq " + processID + "\" /FO CSV";
    try {
      Process sshProc = Runtime.getRuntime().exec(command);

      BufferedReader br = new BufferedReader(new InputStreamReader(
          sshProc.getInputStream()));
      String cmdOutput = br.readLine();
      if (cmdOutput == null || "".equals(cmdOutput)) {
        log.error("No such process running");
        JstatUIError.addErrors(602, "No such process running");
        return startDateTime;
      } else {
        // TODO : start time
        // startDateTime = cmdOutput.trim().split(",")[5].replaceAll("::", " ");
        return startDateTime;
      }
    } catch (IOException e) {
      log.error("Error in I/O stream Operation", e);
      JstatUIError.addErrors(603, "Error in I/O stream Operation");
    }
    return startDateTime;
  }

  /**
   * Returns start time of a process specific to Linux OS
   * 
   * @param host
   *          Host name
   * @param processID
   *          process ID
   * @return Start time of supplied process on supplied host
   */
  private static String getProcessStartDateTimeOnLinux(String host,
      int processID) {
    String startDateTime = "";
    String sshCommand = "ssh " + host
        + " ls -ld --time-style=+%Y-%m-%d::%H:%M:%S /proc/" + processID;
    try {
      Process sshProc = Runtime.getRuntime().exec(sshCommand);
      BufferedReader br = new BufferedReader(new InputStreamReader(
          sshProc.getInputStream()));
      String cmdOutput = br.readLine();
      if (cmdOutput == null || "".equals(cmdOutput)) {
        log.error("No such process running");
        JstatUIError.addErrors(602, "No such process running");
        return startDateTime;
      } else {
        startDateTime = cmdOutput.trim().split(" ")[5].replaceAll("::", " ");
        return startDateTime;
      }
    } catch (IOException e) {
      log.error("Error in I/O stream Operation", e);
      JstatUIError.addErrors(603, "Error in I/O stream Operation");
    }
    return startDateTime;
  }

  /**
   * Check if the process is running or not
   * 
   * @param host
   *          Host name
   * @param processID
   *          Process ID
   * @return Return true if process is running otherwise false
   */
  public static boolean checkProcessStatus(String host, int processID) {
    log.info("Process status check");
    boolean running = false;
    String os = getOS();
    if (!"".equals(os)) {
      os = os.trim().toLowerCase();
      if (os.contains("windows")) {
        return checkProcessStatusOnWindows(host, processID);
      } else if (os.contains("linux")) {
        return checkProcessStatusOnLinux(host, processID);
      } else {
        log.error(os + " not yet supported");
        JstatUIError.addErrors(609, os + " not yet supported");
      }
    }
    return running;
  }

  /**
   * Check if the process is running or not on Windows
   * 
   * @param host
   *          Host name
   * @param processID
   *          Process ID
   * @return Return true if process is running otherwise false
   */
  private static boolean checkProcessStatusOnWindows(String host, int processID) {
    log.info("Checking process status for PID : "+processID+" on windows");
    boolean running = false;
    String command = "tasklist /V /FI \"PID eq " + processID + "\" /FO CSV";
    try {
      Process sshProc = Runtime.getRuntime().exec(command);
      BufferedReader br = new BufferedReader(new InputStreamReader(
          sshProc.getInputStream()));
      String cmdOutput = br.readLine();
      cmdOutput = br.readLine();
      if (cmdOutput == null || "".equals(cmdOutput)) {
        log.error("No such process running");
        JstatUIError.addErrors(602, "No such running process");
        running = false;
      } else {
        running = true;
      }
    } catch (IOException e) {
      log.error("Error in I/O stream Operation", e);
      JstatUIError.addErrors(603, "Error in I/O stream Operation");
    }
    return running;
  }

  /**
   * Check if the process is running or not on Linux
   * 
   * @param host
   *          Host name
   * @param processID
   *          Process ID
   * @return Return true if process is running otherwise false
   */
  private static boolean checkProcessStatusOnLinux(String host, int processID) {
    log.info("Checking process status for PID : "+processID+" on windows");
    boolean running = false;
    String sshCommand = "ssh " + host
        + " ls -ld --time-style=+%Y-%m-%d::%H:%M:%S /proc/" + processID;
    try {
      Process sshProc = Runtime.getRuntime().exec(sshCommand);
      BufferedReader br = new BufferedReader(new InputStreamReader(
          sshProc.getInputStream()));
      String cmdOutput = br.readLine();
      if (cmdOutput == null || "".equals(cmdOutput)) {
        log.error("No such process running");
        JstatUIError.addErrors(602, "No such process running");
        running = false;
      } else {
        running = true;
      }
    } catch (IOException e) {
      log.error("Error in I/O stream Operation", e);
      JstatUIError.addErrors(603, "Error in I/O stream Operation");
    }
    return running;
  }

  public static void main(String args[]) {
    // System.setProperty("sockProxyHost", "localhost");
    // System.setProperty("sockProxyPort", "65534");

    System.out.println(getOS());
  }
}
