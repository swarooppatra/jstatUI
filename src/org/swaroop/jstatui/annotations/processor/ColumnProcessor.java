/**
 * Created on May 8, 2012
 */
package org.swaroop.jstatui.annotations.processor;

import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.TypeElement;

/**
 * This annotation processor class processes bean classes with
 * {@link org.swaroop.jstatui.annotations.Column Column} Annotation
 * 
 * @author Swaroop Patra
 * 
 */
@SupportedAnnotationTypes("org.swaroop.jstatui.annotations.Column")
@SupportedSourceVersion(SourceVersion.RELEASE_6)
public class ColumnProcessor extends AbstractProcessor {

	@Override
	public boolean process(Set<? extends TypeElement> annotations,
			RoundEnvironment arg1) {
		for (TypeElement element : annotations) {
			System.out.println("Name : " + element.getQualifiedName());
		}
		return true;
	}

}
