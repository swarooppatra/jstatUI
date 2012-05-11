/**
 * Created on May 3, 2012
 */
package org.swaroop.jstatui.dao;

import org.apache.log4j.Logger;
import org.swaroop.jstatui.bean.JstatClassBean;
import org.swaroop.jstatui.error.JstatUIError;
import org.swaroop.jstatui.orm.ORMProcessor;

/**
 * @author Swaroop Patra
 * 
 */
public class JstatClassDAO {

  private static final Logger log = Logger.getLogger("jstatui");

  public JstatClassDAO() {
  }

  /**
   * Insert a record
   * 
   * @param bean
   *          An object of type JstatClassBean
   * @return A boolean value indicating a record a inserted in DB or not
   */
  public boolean insertHost(JstatClassBean bean) {
    log.info("Preapring insertion to table jstat_class table");
    boolean inserted = false;
    if (bean == null) {
      log.error("Invalid JstatClassBean object");
      JstatUIError.addErrors(600, "Invalid JstatHostBean object");
      return inserted;
    }
    //inserted = ORMProcessor.insertABean(bean);
    log.info("Insertion status : " + inserted);
    return inserted;
  }

}
