/**
 * Created on May 6, 2012
 */
package org.swaroop.jstatui.orm;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.Statement;

import org.swaroop.jstatui.annotations.Column;
import org.swaroop.jstatui.bean.JstatOptionBean;
import org.swaroop.jstatui.db.DBConnection;
import org.swaroop.jstatui.util.AnnotationUtil;

/**
 * This class processes objects using reflection and annotations to persist the
 * object state to DB
 * 
 * @author Swaroop Patra
 * 
 */
public abstract class ORMProcessor {

  private static DBConnection dbConn = new DBConnection();

  private static final char WHITE_SPACE = ' ';

  private static final char CHAR_COMMA = ',';

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
    boolean inserted = false;
    StringBuffer SQL = new StringBuffer("INSERT INTO ");
    StringBuffer columnNames = new StringBuffer();
    StringBuffer columnValues = new StringBuffer();
    if (bean == null) {
      // TODO : replace with reporting/logging process
      System.out.println("Invalid bean value passed");
      return inserted;
    }
    String tableName = AnnotationUtil.getAnnotatedTable(bean.getClass());
    Field[] annotatedFields = AnnotationUtil.getColumnAnnotatedFields(bean
        .getClass());
    for (Field field : annotatedFields) {
      columnNames.append(field.getAnnotation(Column.class).name());
      columnNames.append(CHAR_COMMA);
      try {
        columnValues.append(field.get(bean));
        columnNames.append(CHAR_COMMA);
      } catch (IllegalArgumentException e) {
        // TODO : replace with reporting/logging process
        e.printStackTrace();
      } catch (IllegalAccessException e) {
        // TODO : replace with reporting/logging process
        e.printStackTrace();
      }
    }
    columnNames.deleteCharAt(columnNames.lastIndexOf(","));
    columnValues.deleteCharAt(columnNames.lastIndexOf(","));
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
    // TODO : DB operation
    
    return inserted;
  }
}
