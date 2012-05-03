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
 * This annotates a class to a table to which it corresponds
 * 
 * @author Swaroop Patra
 *
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Table {
	String name();
}
