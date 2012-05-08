/**
 * Created on May 6, 2012
 */
package org.swaroop.jstatui.orm;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.apache.log4j.Logger;
import org.swaroop.jstatui.annotations.Column;
import org.swaroop.jstatui.bean.JstatOptionBean;
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

  private static DBConnection dbConn = new DBConnection();

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
  public static boolean insertABean(JstatOptionBean bean) {
    log.info("Staring ORM operations");
    boolean inserted = false;
    if (bean == null) {
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
    System.out.println("QUERY :: " + SQL.toString());

    Connection conn = null;
    Statement stmt = null;
    conn = dbConn.getConnection();
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
}
