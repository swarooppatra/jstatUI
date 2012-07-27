/**
 * Created on Jul 27, 2012
 */
package org.swaroop.jstatui.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;
import org.swaroop.jstatui.bean.JstatCustomPlotBean;
import org.swaroop.jstatui.db.DBConnection;
import org.swaroop.jstatui.error.JstatUIError;

/**
 * DAO implementation for jstat_custom_plot table
 * 
 * @author Swaroop Patra
 * 
 */
public class JstatCustomPlotDAO {

  private static final Logger log = Logger.getLogger("jstatui");

  private DBConnection dbConn = new DBConnection();

  public JstatCustomPlotBean getCustomPlotBeanByPlotName(String plotName) {
    log.info("Fetching records from jstat_sutom_plot table");
    JstatCustomPlotBean bean = new JstatCustomPlotBean();
    if (plotName == null || "".equals(plotName)) {
      log.error("Invalid parameter supplied");
      JstatUIError
          .addErrors(600, "Invalid value passed to a method/costructor");
      return bean;
    }
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    try {
      String sql = "SELECT id, plot_name, type_and_param FROM jstat_custom_plot WHERE plot_name='"
          + plotName + "'";
      conn = dbConn.getConnection();
      stmt = conn.createStatement();
      rs = stmt.executeQuery(sql);
      log.info("Executed QUERY :: " + sql);
      if (rs.next()) {
        bean.setId(rs.getInt("id"));
        bean.setPlotName(rs.getString("plot_name"));
        bean.setTypeAndParam(rs.getString("type_and_param"));
      }
      return bean;
    } catch (SQLException e) {
      for (Throwable t : e) {
        log.error("Database Error", t);
      }
      JstatUIError.addErrors(606, "Database operation error");
    }
    return bean;
  }
}
