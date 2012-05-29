/**
 * Created on May 6, 2012
 */
package org.swaroop.jstatui.orm;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.swaroop.jstatui.annotations.Column;
import org.swaroop.jstatui.bean.JstatClassBean;
import org.swaroop.jstatui.bean.JstatCompilerBean;
import org.swaroop.jstatui.bean.JstatGCBean;
import org.swaroop.jstatui.bean.JstatGCCapacityBean;
import org.swaroop.jstatui.bean.JstatGCCauseBean;
import org.swaroop.jstatui.bean.JstatGCNewBean;
import org.swaroop.jstatui.bean.JstatGCNewCapacityBean;
import org.swaroop.jstatui.bean.JstatGCOldBean;
import org.swaroop.jstatui.bean.JstatGCOldCapacityBean;
import org.swaroop.jstatui.bean.JstatGCPermCapacityBean;
import org.swaroop.jstatui.bean.JstatGCUtilBean;
import org.swaroop.jstatui.bean.JstatHostBean;
import org.swaroop.jstatui.bean.JstatOptionBean;
import org.swaroop.jstatui.bean.JstatPrintCompilationBean;
import org.swaroop.jstatui.collector.JStatOptions;
import org.swaroop.jstatui.db.DBConnection;
import org.swaroop.jstatui.error.JstatUIError;
import org.swaroop.jstatui.util.AnnotationUtil;

/**
 * This class processes objects using reflection and annotations to persist the
 * object state to DB
 * 
 * @author Swaroop Patra
 * 
 */
public abstract class ORMProcessor {

  private static final Logger log = Logger.getLogger("jstatui");

  private static final char WHITE_SPACE = ' ';

  private static final char CHAR_COMMA = ',';

  private static final char CHAR_QUOTE = '"';

  private static final char CHAR_OPEN_BRACKET = '(';

  private static final char CHAR_CLOSE_BRACKET = ')';

  /**
   * Persists the state of a bean of type JstatOptionBean using the query
   * provided
   * 
   * @param bean
   *          An object of type JstatOptionBean
   * @return A boolean indicating a record was inserted successfully or not
   */
  // TODO : if bean doesn't contains proper value then stop fire query
  public static boolean insertABean(JstatOptionBean bean, Connection conn) {
    log.info("Staring ORM operations");
    boolean inserted = false;
    if (bean == null || conn == null) {
      log.error("Invalid bean value passed");
      JstatUIError.addErrors(600, "Invalid bean value passed");
      return inserted;
    }
    StringBuffer SQL = new StringBuffer("INSERT INTO ");
    StringBuffer columnNames = new StringBuffer();
    StringBuffer columnValues = new StringBuffer();
    String tableName = AnnotationUtil.getAnnotatedTable(bean.getClass());
    List<Field> annotatedFields = AnnotationUtil.getColumnAnnotatedFields(bean
        .getClass());
    for (Field field : annotatedFields) {
      Class<?> fieldType = field.getType();
      if (!field.getAnnotation(Column.class).isPrimary()) {
        try {
          columnNames.append(field.getAnnotation(Column.class).name());
          columnNames.append(CHAR_COMMA);
          if (fieldType.getSimpleName().equals("String")) {
            columnValues.append(CHAR_QUOTE);
            columnValues.append(((String) field.get(bean)).trim().replace("\"",
                "\\\""));
            columnValues.append(CHAR_QUOTE);
            columnValues.append(CHAR_COMMA);
          } else {
            columnValues.append(field.get(bean));
            columnValues.append(CHAR_COMMA);
          }
        } catch (IllegalArgumentException e) {
          log.error("Invalid argument in annotaion fetching", e);
          JstatUIError.addErrors(601, "Invalid argument in annotaion fetching");
        } catch (IllegalAccessException e) {
          log.error("Trying to access restricted block", e);
          JstatUIError.addErrors(601, "Trying to access restricted block");
        }
      }
    }
    columnNames.deleteCharAt(columnNames.lastIndexOf(","));
    columnValues.deleteCharAt(columnValues.lastIndexOf(","));
    SQL.append(tableName);
    SQL.append(WHITE_SPACE);
    SQL.append(CHAR_OPEN_BRACKET);
    SQL.append(columnNames.toString());
    SQL.append(CHAR_CLOSE_BRACKET);
    SQL.append(WHITE_SPACE);
    SQL.append("VALUES");
    SQL.append(CHAR_OPEN_BRACKET);
    SQL.append(columnValues);
    SQL.append(CHAR_CLOSE_BRACKET);
    log.info("QUERY :: " + SQL.toString());

    Statement stmt = null;
    try {
      stmt = conn.createStatement();
      stmt.execute(SQL.toString());
      inserted = true;
      log.info("Record inseted to DB");
    } catch (SQLException e) {
      log.error("Error in DB operaions", e);
      JstatUIError.addErrors(606, "Cannot insert to table");
    }
    return inserted;
  }

  /**
   * Get the latest Max 100 records for for a bean type
   * 
   * @param host
   *          An object of {@link org.swaroop.jstatui.bean.JstatHostBean
   *          JstatHostBean}
   * @param type
   *          Stats type
   * @param conn
   *          A DB connection object
   * @return A List of latest max 100 stats
   */
  @SuppressWarnings({ "unchecked", "rawtypes" })
  public static List<? extends JstatOptionBean> getLatestRecordsByCount(
      JstatHostBean host, JStatOptions type, Connection conn, int count) {
    log.info("Fetching latest 100 records for stat " + type.name()
        + " for host " + host);
    Class<? extends JstatOptionBean> optionBean = null;
    List records = new ArrayList<JstatOptionBean>();
    if (host == null || host.getId() == 0 || type == null || conn == null) {
      log.error("Invalid value passed");
      JstatUIError.addErrors(600, "Invalid value passed to method");
    }
    switch (type) {
    case CLASS:
      records = new ArrayList<JstatClassBean>(100);
      optionBean = JstatClassBean.class;
      break;
    case COMPILER:
      records = new ArrayList<JstatCompilerBean>();
      optionBean = JstatCompilerBean.class;
      break;
    case GC:
      records = new ArrayList<JstatGCBean>();
      optionBean = JstatGCBean.class;
      break;
    case GC_CAPACITY:
      records = new ArrayList<JstatGCCapacityBean>();
      optionBean = JstatGCCapacityBean.class;
      break;
    case GC_CAUSE:
      records = new ArrayList<JstatGCCauseBean>();
      optionBean = JstatGCCauseBean.class;
      break;
    case GC_NEW:
      records = new ArrayList<JstatGCNewBean>();
      optionBean = JstatGCNewBean.class;
      break;
    case GC_NEW_CAPACITY:
      records = new ArrayList<JstatGCNewCapacityBean>();
      optionBean = JstatGCNewCapacityBean.class;
      break;
    case GC_OLD:
      records = new ArrayList<JstatGCOldBean>();
      optionBean = JstatGCOldBean.class;
      break;
    case GC_OLD_CAPACITY:
      records = new ArrayList<JstatGCOldCapacityBean>();
      optionBean = JstatGCOldCapacityBean.class;
      break;
    case GC_PERM_CAPACITY:
      records = new ArrayList<JstatGCPermCapacityBean>();
      optionBean = JstatGCPermCapacityBean.class;
      break;
    case GC_UTIL:
      records = new ArrayList<JstatGCUtilBean>();
      optionBean = JstatGCUtilBean.class;
      break;
    case PRINT_COMPILATION:
      records = new ArrayList<JstatPrintCompilationBean>();
      optionBean = JstatPrintCompilationBean.class;
      break;
    default:
      log.error(type + " processing not yet implemented");
      JstatUIError.addErrors(611, type + " processing not yet implemented");
    }
    StringBuffer SQL = new StringBuffer("SELECT ");
    String tableName = AnnotationUtil.getAnnotatedTable(optionBean);
    List<Field> annotatedFields = AnnotationUtil
        .getColumnAnnotatedFields(optionBean);
    for (Field field : annotatedFields) {
      SQL.append(field.getAnnotation(Column.class).name());
      SQL.append(CHAR_COMMA);
    }
    SQL.deleteCharAt(SQL.lastIndexOf(","));
    SQL.append(" FROM ");
    SQL.append(tableName);
    SQL.append(" WHERE host_id=");
    SQL.append(host.getId());
    SQL.append(" ORDER BY id DESC LIMIT ");
    SQL.append(count);
    log.info("QUERY : " + SQL.toString());
    Statement stmt = null;
    ResultSet rs = null;
    try {
      stmt = conn.createStatement();
      rs = stmt.executeQuery(SQL.toString());
      while (rs.next()) {
        JstatOptionBean bean = optionBean.newInstance();
        for (Field field : annotatedFields) {
          String colName = field.getAnnotation(Column.class).name();
          String fieldType = field.getType().getSimpleName();
          if (fieldType.equals("boolean")) {
            field.setBoolean(bean, rs.getBoolean(colName));
          } else if (fieldType.equals("byte")) {
            field.setByte(bean, rs.getByte(colName));
          } else if (fieldType.equals("char")) {
            // FIXME : Need to fix it
            field.setChar(bean, (char) rs.getInt(colName));
          } else if (fieldType.equals("double")) {
            field.setDouble(bean, rs.getDouble(colName));
          } else if (fieldType.equals("float")) {
            field.setFloat(bean, rs.getFloat(colName));
          } else if (fieldType.equals("int")) {
            field.setInt(bean, rs.getInt(colName));
          } else if (fieldType.equals("long")) {
            field.setLong(bean, rs.getLong(colName));
          } else if (fieldType.equals("short")) {
            field.setShort(bean, rs.getShort(colName));
          } else {
            field.set(bean, rs.getString(colName));
          }
        }
        records.add(bean);
      }
      Collections.sort(records);
      log.info("Retrived " + records.size() + " stats");
    } catch (SQLException e) {
      log.error("Database error", e);
      JstatUIError.addErrors(606, "Error in database operation");
    } catch (InstantiationException e) {
      log.error("Reflection Error", e);
      JstatUIError.addErrors(610, "Reflection Error");
    } catch (IllegalAccessException e) {
      log.error("Reflection Error", e);
      JstatUIError.addErrors(610, "Reflection Error");
    }

    return records;
  }

  public static void main(String args[]) {
    JstatHostBean bean = new JstatHostBean();
    bean.setId(1);
    DBConnection conn = new DBConnection();
    List<? extends JstatOptionBean> l = getLatestRecordsByCount(bean,
        JStatOptions.GC, conn.getConnection(), 20);
    for (JstatOptionBean b : l) {
      System.out.println(b);
    }

  }
}
