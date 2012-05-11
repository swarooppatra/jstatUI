/**
 * Created on May 7, 2012
 */
package org.swaroop.jstatui.dao;

import org.apache.log4j.Logger;
import org.swaroop.jstatui.bean.JstatHostBean;
import org.swaroop.jstatui.error.JstatUIError;

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

  /**
   * Insert a record
   * 
   * @param bean
   *          An object of type JstatHostBean
   * @return A boolean value indicating a record a inserted in DB or not
   */
  public boolean insertHost(JstatHostBean bean) {
    log.info("Preapring insertion to table jstat_host table");
    boolean inserted = false;
    if (bean == null) {
      log.error("Invalid JstatHostBean object");
      JstatUIError.addErrors(600, "Invalid JstatHostBean object");
      return inserted;
    }
    //inserted = ORMProcessor.insertABean(bean);
    log.info("Insertion status : " + inserted);
    return inserted;
  }
}
