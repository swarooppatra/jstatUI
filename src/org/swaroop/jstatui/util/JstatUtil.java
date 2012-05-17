/**
 * Created on May 17, 2012
 */
package org.swaroop.jstatui.util;

import java.util.List;

import org.apache.log4j.Logger;
import org.swaroop.jstatui.bean.JstatOptionBean;
import org.swaroop.jstatui.error.JstatUIError;

/**
 * A utility class
 * 
 * @author Swaroop Patra
 * 
 */
public class JstatUtil {

  public static final Logger log = Logger.getLogger("jstatui");

  public static String getPlotString(List<? extends JstatOptionBean> list) {
    StringBuffer plotString = new StringBuffer("[");
    if (list == null || list.size() == 0) {
      log.error("Invalid input supplied");
      JstatUIError.addErrors(600, "Invalid input supplied");
    }
    for (JstatOptionBean bean : list) {
      plotString.append(bean.toJsonString());
      plotString.append(",");
    }
    plotString.deleteCharAt(plotString.lastIndexOf(","));
    plotString.append("]");
    return plotString.toString();
  }
}
