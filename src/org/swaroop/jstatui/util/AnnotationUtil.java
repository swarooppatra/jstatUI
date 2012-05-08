/**
 * Created on May 6, 2012
 */
package org.swaroop.jstatui.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.swaroop.jstatui.annotations.Column;
import org.swaroop.jstatui.annotations.Table;
import org.swaroop.jstatui.bean.JstatOptionBean;

/**
 * This utility class helps in processing annotation related functions
 * 
 * @author Swaroop Patra
 * 
 */
public class AnnotationUtil {

  private static final Logger log = Logger.getLogger("jstatui");

  /**
   * Returns an array of Fields of Class in parameter which are annotated with
   * Column annotation
   * 
   * @param className
   *          Class object
   * @return An array of Column annotated Fields
   */
  public static List<Field> getColumnAnnotatedFields(
      Class<? extends JstatOptionBean> className) {
    log.info("Fetching annotated Fields");
    List<Field> fields = new ArrayList<Field>();
    Field[] declaredFields = className.getDeclaredFields();
    for (Field field : declaredFields) {
      field.setAccessible(true);
      Annotation fieldAnnotation = field.getAnnotation(Column.class);
      if (fieldAnnotation instanceof Column) {
        fields.add(field);
      }
    }
    return fields;
  }

  /**
   * Returns annotated table name
   * 
   * @param className
   *          Class object for which table name need to determined
   * @return Annotated table name
   */
  public static String getAnnotatedTable(
      Class<? extends JstatOptionBean> className) {
    log.info("Fetching annotated Table name");
    String tableName = "";
    Annotation classAnnotation = className.getAnnotation(Table.class);
    if (classAnnotation instanceof Table) {
      Table tableAnnotation = (Table) classAnnotation;
      tableName = tableAnnotation.name();
    }
    log.info("Annotated table : " + tableName);
    return tableName;
  }
}
