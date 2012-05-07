/**
 * Created on May 7, 2012
 */
package org.swaroop.jstatui.dao;

import org.apache.log4j.Logger;
import org.swaroop.jstatui.bean.JstatHostBean;
import org.swaroop.jstatui.orm.ORMProcessor;

import com.mysql.jdbc.interceptors.SessionAssociationInterceptor;

/**
 * This DAO corresponds to jstatui.jstat_host table and JstatHostBean
 * 
 * @author Swaroop Patra
 * 
 */
public class JstatHostDAO {
	
	private static final Logger log = Logger.getLogger("jstatui");

  public JstatHostDAO() {
  }

  public boolean insertHost(JstatHostBean bean) {
    boolean inserted = false;
    if (bean == null) {
      // TODO : replace with reporting/logging process
      log.error("Invalid JstatHostBean object");
     
      return inserted;
    }
    inserted = ORMProcessor.insertABean(bean);
    return inserted;
  }
}
