/**
 * Created on May 6, 2012
 */
package org.swaroop.jstatui.orm;

import org.swaroop.jstatui.bean.JstatOptionBean;

/**
 * This class processes objects using reflection and annotations to persist the
 * object state to DB
 * 
 * @author Swaroop Patra
 * 
 */
public abstract class ORMProcessor {

	/**
	 * Persists the state of a bean of type JstatOptionBean using the query
	 * provided
	 * 
	 * @param bean
	 *            An object of type JstatOptionBean
	 * @param query
	 *            SQL Query to be used to persists the state
	 * @return A boolean indicating a record was inserted successfully or not
	 */
	public static boolean insertABean(JstatOptionBean bean, String query) {
		
		return false;
	}
}
