/**
 * Created on May 7, 2012
 */
package org.swaroop.jstatui.error;

import java.util.HashMap;
import java.util.Map;

/**
 * There should be single object of this class per session. It holds all the
 * errors that got generated during a single Session.
 * 
 * @author Swaroop Patra
 * 
 */
public class JstatUIError {

  // TODO : reconsider to use some other error storage.
  private static Map<Integer, String> errors = new HashMap<Integer, String>();

  private final String SESSION_ID;

  public JstatUIError(String sessionID) {
    SESSION_ID = sessionID;
  }

  /**
   * Returns errors
   * 
   * @return Map of error code and error message
   */
  public static Map<Integer, String> getErrors() {
    return errors;
  }

  /**
   * Add an error to global error object
   * 
   * @param errorCode
   *          User provided error code
   * @param messgae
   *          User provided error message
   */
  public static void addErrors(int errorCode, String messgae) {
    errors.put(errorCode, messgae);
  }

  /**
   * Returns total number of errors present in current session
   * 
   * @return Number of errors
   */
  public static int getErroCounts() {
    return errors.size();
  }

  /**
   * Returns SESSION ID for this object
   * 
   * @return Request SESSION ID
   */
  public String getSessionID() {
    return SESSION_ID;
  }
}
