/**
 * Created on May 8, 2012
 */
package org.swaroop.jstatui.dao;

import org.apache.log4j.PropertyConfigurator;
import org.swaroop.jstatui.bean.JstatHostBean;

/**
 * Tests for JstatHostDAO operations
 * 
 * @author Swaroop Patra
 * 
 */
public class JstatHostDAOTest {
  public static void main(String args[]) {
    PropertyConfigurator
        .configure("C:\\Users\\m1012257\\git\\jstatUI\\src\\org\\swaroop\\jstatui\\resource\\log4j.properties");
    JstatHostBean bean = new JstatHostBean();
    bean.setHost("r113");
    bean.setJvmProcessId(123412);
    bean.setJvmStartTime("2012-05-01 03:00:00");
    bean.setPort(7777);
    JstatHostDAO dao = new JstatHostDAO();
    dao.insertHost(bean);
  }
}
