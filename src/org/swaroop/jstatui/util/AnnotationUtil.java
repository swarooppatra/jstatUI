/**
 * Created on May 6, 2012
 */
package org.swaroop.jstatui.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

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

	/**
	 * Returns an array of Fields of Class in parameter which are annotated with
	 * Column annotation
	 * 
	 * @param className
	 *            Class object
	 * @return An array of Column annotated Fields
	 */
	public static Field[] getColumnAnnotatedFields(
			Class<? extends JstatOptionBean> className) {
		List<Field> fields = new ArrayList<Field>();
		
		Field[] declaredFields = className.getDeclaredFields();
		for(Field field : declaredFields){
			field.setAccessible(true);
			Annotation fieldAnnotation = field.getAnnotation(Column.class);
			if(fieldAnnotation instanceof Column){
				fields.add(field);
			}
		}
		return (Field[])fields.toArray();
	}

	/**
	 * Returns annotated table name
	 * 
	 * @param className
	 *            Class object for which table name need to determined
	 * @return Annotated table name
	 */
	public static String getAnnotatedTable(
			Class<? extends JstatOptionBean> className) {
		String tableName = "";
		Annotation classAnnotation = className.getAnnotation(Table.class);
		if (classAnnotation instanceof Table) {
			Table tableAnnotation = (Table) classAnnotation;
			tableName = tableAnnotation.name();
		}
		return tableName;
	}
}
