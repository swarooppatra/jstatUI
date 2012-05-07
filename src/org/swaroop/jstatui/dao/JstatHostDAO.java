/**
 * Created on May 7, 2012
 */
package org.swaroop.jstatui.dao;

import org.swaroop.jstatui.bean.JstatHostBean;
import org.swaroop.jstatui.orm.ORMProcessor;

/**
 * This DAO corresponds to jstatui.jstat_host table and JstatHostBean
 * 
 * @author Swaroop Patra
 * 
 */
public class JstatHostDAO {

  public JstatHostDAO() {
  }

  public boolean insertHost(JstatHostBean bean) {
    boolean inserted = false;
    if (bean == null) {
      // TODO : replace with reporting/logging process
      System.out.println("Invalid JstatHostBean object");
      return inserted;
    }
    inserted = ORMProcessor.insertABean(bean);
    return inserted;
  }
}
