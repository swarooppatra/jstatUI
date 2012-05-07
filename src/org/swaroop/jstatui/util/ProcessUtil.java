/**
 * Created on May 3, 2012
 */
package org.swaroop.jstatui.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * This is a util class for a process in OS
 * 
 * @author Swaroop Patra
 * 
 */
public class ProcessUtil {

  // TODO : For windows > tasklist /FI "PID eq <pid>" /FO CSV /NH /V
  public static String getProcessStartDateTime(String host, int processID) {
    String startDateTime = "";
    if (processID < 0 || host == null || "".equals(host)) {
      // TODO : replace with reporting/logging process
      System.out.println("Invalid Process ID/Host name supplied");
      return startDateTime;
    }
    String sshCommand = "ssh " + host
        + " ls -ld --time-style=+%Y-%m-%d::%H:%M:%S /proc/" + processID;
    try {
      Process sshProc = Runtime.getRuntime().exec(sshCommand);
      BufferedReader br = new BufferedReader(new InputStreamReader(
          sshProc.getInputStream()));
      String cmdOutput = br.readLine();
      if (cmdOutput == null || "".equals(cmdOutput)) {
        // TODO : replace with reporting/logging process
        System.out.println("No such process running");
        return startDateTime;
      } else {
        startDateTime = cmdOutput.trim().split(" ")[5].replaceAll("::", " ");
        return startDateTime;
      }
    } catch (IOException e) {
      // TODO : replace with reporting/logging process
      e.printStackTrace();
    }
    return startDateTime;
  }

  public static void main(String args[]) {
    // System.setProperty("sockProxyHost", "localhost");
    // System.setProperty("sockProxyPort", "65534");

    String startDate = getProcessStartDateTime("h09.fatlens.com", 15098);
    System.out.println("startDate :: " + startDate);
  }
}
