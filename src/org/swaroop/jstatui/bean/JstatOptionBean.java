/**
 * Created on May 6, 2012
 */
package org.swaroop.jstatui.bean;

import org.apache.log4j.Logger;

/**
 * This is a marker interface. All bean classes which has to be stored using ORM
 * model has to implement this interface
 * 
 * @author Swaroop Patra
 * 
 */
public interface JstatOptionBean {
  static final Logger log = Logger.getLogger("jstatui");

  JstatOptionBean parseStat(String stat);
  String toJsonString();
}
