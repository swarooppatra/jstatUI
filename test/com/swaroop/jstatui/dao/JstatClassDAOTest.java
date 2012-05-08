/**
 * Created on May 8, 2012
 */
package com.swaroop.jstatui.dao;

import org.apache.log4j.PropertyConfigurator;
import org.swaroop.jstatui.bean.JstatClassBean;
import org.swaroop.jstatui.dao.JstatClassDAO;

/**
 * Tests for JstatHostDAO operations
 * 
 * @author Swaroop Patra
 * 
 */
public class JstatClassDAOTest {
  public static void main(String args[]) {
    PropertyConfigurator
        .configure("C:\\Users\\m1012257\\git\\jstatUI\\src\\org\\swaroop\\jstatui\\resource\\log4j.properties");
    JstatClassBean bean = new JstatClassBean();
    bean.setHostID(1);
    bean.setLoadedBytes(232);
    bean.setLoadedClasses(3423);
    bean.setTimeConsumed(435);
    bean.setTimeElasped(34345);
    bean.setUnloadedBytes(43);
    bean.setUnloadedClasses(4543);
    JstatClassDAO dao = new JstatClassDAO();
    dao.insertHost(bean);
  }
}
