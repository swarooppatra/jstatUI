/**
 * Created on May 6, 2012
 */
package org.swaroop.jstatui.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.swaroop.jstatui.error.JstatUIError;

/**
 * Provides a database connection
 * 
 * @author Swaroop Patra
 * 
 */
public class DBConnection {

  private static final Logger log = Logger.getLogger("jstatui");

  private static DBConnection instance = null;

  private String strDbHost = null;

  private String strDbUser = null;

  private String strDbUrl = null;

  private String strDriverName = null;

  private String strDbPort = null;

  private String strDbName = null;

  private String strDbPwd = null;

  /**
   * DbConnection Constructor that reads all the configuration details like
   * url,username,password ,etc.,
   */
  public DBConnection() {
    ResourceBundle bundle = ResourceBundle
        .getBundle("org.swaroop.jstatui.resource.jstatui");
    strDbHost = bundle.getString("DbHost");
    strDbUser = bundle.getString("DbUser");
    strDbPort = bundle.getString("DbPort");
    strDbName = bundle.getString("DbName");
    strDbUrl = bundle.getString("dbUrl") + strDbHost + ":" + strDbPort + "/"
        + strDbName;
    strDriverName = bundle.getString("DbDriverName");
    strDbPwd = bundle.getString("DbPwd");
  }

  /**
   * DbConnection Constructor that reads all the configuration details like
   * url,username,password ,etc.,
   */
  public DBConnection(String configFilePath) {
    ResourceBundle bundle = ResourceBundle.getBundle(configFilePath);
    strDbHost = bundle.getString("DbHost");
    strDbUser = bundle.getString("DbUser");
    strDbPort = bundle.getString("DbPort");
    strDbName = bundle.getString("DbName");
    strDbUrl = bundle.getString("dbUrl") + strDbHost + ":" + strDbPort + "/"
        + strDbName;
    strDriverName = bundle.getString("DbDriverName");
    strDbPwd = bundle.getString("DbPwd");
  }

  public Connection getConnection() {
    log.info("Creating a DB connection");
    Connection con = null;
    try {
      Class.forName(strDriverName);
      con = DriverManager.getConnection(strDbUrl, strDbUser, strDbPwd);
    } catch (ClassNotFoundException ex) {
      log.error("Driver class not found", ex);
      JstatUIError.addErrors(605, "Driver class not found");
    } catch (SQLException ex) {
      log.error("Error in creating DB connection", ex);
      JstatUIError.addErrors(606, "Error in creating DB connection");
    }
    return con;

  }

  /** Uses JNDI and Datasource (preferred style). */
  public Connection getJNDIConnection() {
    log.info("Fetching a connnection from DataSource");
    String DATASOURCE_CONTEXT = "java:comp/env/jdbc/jstatui";

    Connection result = null;
    try {
      Context initialContext = new InitialContext();
      DataSource datasource = (DataSource) initialContext
          .lookup(DATASOURCE_CONTEXT);
      if (datasource != null) {
        result = datasource.getConnection();
      } else {
        System.out.println("Failed to lookup datasource.");
      }
    } catch (NamingException ex) {
      log.error("Unable to get JNDI resource", ex);
      JstatUIError.addErrors(604, "Unable to get JNDI resource");
    } catch (SQLException ex) {
      log.error("Error in creating DB connection", ex);
      JstatUIError.addErrors(606, "Error in creating DB connection");
    }
    return result;
  }

  public static DBConnection getInstance() {
    if (instance == null) {
      instance = new DBConnection();
    }
    return instance;
  }
}
