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

	private static Map<Integer, String> errors = new HashMap<Integer, String>();

	public JstatUIError(int errorCode, String messgae) {
		errors.put(errorCode, messgae);
	}

	public static Map<Integer, String> getErrors() {
		return errors;
	}

	public static int getErroCounts() {
		return errors.size();
	}

}
