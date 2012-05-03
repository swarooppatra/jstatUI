/**
 * Created on May 3, 2012
 */
package org.swaroop.jstatui.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This annotates a bean property to a table column to which it corresponds
 * 
 * @author Swaroop Patra
 * 
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Column {
	String name();

	boolean isPrimary() default false;
}
