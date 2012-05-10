/**
 * Created on May 8, 2012
 */
package org.swaroop.jstatui.annotations.processor;

import java.io.IOException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;

import org.apache.log4j.Logger;
import org.swaroop.jstatui.annotations.Column;
import org.swaroop.jstatui.bean.JstatOptionBean;
import org.swaroop.jstatui.error.JstatUIError;
import org.swaroop.jstatui.util.AnnotationUtil;

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

  private static final Logger log = Logger.getLogger("jstatui");

  @Override
  public boolean process(Set<? extends TypeElement> annotations,
      RoundEnvironment environment) {
    for (TypeElement element : annotations) {
      Set<? extends Element> elements = environment
          .getElementsAnnotatedWith(element);
      generateFullBeanClass(processingEnv.getFiler(), elements);
    }
    return true;
  }

  /**
   * Generates complete bean class
   * 
   * @param filer
   *          An object of {@link javax.annotation.processing.Filer Filer} to
   *          write out the Bean class
   * @param elements
   *          All elements in the class annotated with
   *          {@link org.swaroop.jstatui.annotations.Column Column}
   */
  @SuppressWarnings("unchecked")
  private void generateFullBeanClass(Filer filer,
      Set<? extends Element> elements) {
    String className = "";
    for (Element e : elements) {
      className = e.getEnclosingElement().toString();
      break;
    }
    try {
      String primaryField = "";
      Class<? extends JstatOptionBean> beanClass = (Class<? extends JstatOptionBean>) Class
          .forName(className);
      String tableName = AnnotationUtil.getAnnotatedTable(beanClass);
      SimpleDateFormat sf = new SimpleDateFormat("MMM d, yyyy");
      String cls = beanClass.getSimpleName();
      String pkgName = beanClass.getPackage().toString();
      Writer writer = filer.createClassFile(className).openWriter();
      writer.write("/**\n * Created on " + sf.format(new Date()) + "\n */\n");
      writer.write(pkgName + ";\n\n");
      writer.write("import java.io.Serializable;\n\n");
      writer.write("import org.swaroop.jstatui.annotations.Column;\n");
      writer.write("import org.swaroop.jstatui.annotations.Table;\n\n");
      writer.write("/**\n  * This bean corresponds to " + tableName
          + " table\n  *\n  ");
      writer
          .write("* @author {@link org.swaroop.jstatui.annotations.processor.ColumnProcessor ColumnProcessor}\n");
      writer.write("  *\n  */\n");
      writer.write("@Table(name = \"" + tableName + "\")\n");
      writer.write("public class " + cls
          + " implements Serializable, Comparable<" + cls
          + ">,JstatOptionBean{\n\n");
      writer.write("\tprivate static final long serialVersionUID = 1L;\n\n");
      for (Element e : elements) {
        boolean isPrimary = e.getAnnotation(Column.class).isPrimary();
        writer.write("\t@Column(name = \"" + e.getSimpleName().toString()
            + "\"");
        if (isPrimary) {
          primaryField = e.getSimpleName().toString();
          writer.write(", isPrimary = true");
        }
        writer.write(")\n");
        writer.write("\tprivate " + e.asType().toString() + " "
            + e.getSimpleName().toString() + ";\n");
      }
      writer.write("\n");
      for (Element e : elements) {
        String fieldName = e.getSimpleName().toString();
        String methodName = fieldName.substring(0, 1).toUpperCase()
            + fieldName.substring(1);
        writer.write("\t/**\n");
        writer.write("\t * @return the " + fieldName + "\n");
        writer.write("\t */\n");
        writer.write("\tpublic " + e.asType().toString() + " get" + methodName
            + "() {\n");
        writer.write("\t\treturn " + fieldName + ";\n");
        writer.write("\t}\n\n");
        writer.write("\t/**\n");
        writer.write("\t * @param " + fieldName + "\n");
        writer.write("\t *\t\t\t the " + fieldName + " to set\n");
        writer.write("\t */\n");
        writer.write("\tpublic void set" + methodName + "("
            + e.asType().toString() + " " + fieldName + ") {\n");
        writer.write("\t\tthis." + fieldName + " = " + fieldName + ";\n");
        writer.write("\t}\n\n");
      }
      writer.write("\t@Override\n");
      writer.write("\tpublic int hashCode() {\n");
      writer.write("\t\tfinal int prime = 31;\n");
      writer.write("\t\tint result = 1;\n");
      writer.write("\t\tresult = prime * result + " + primaryField + ";\n");
      writer.write("\t\treturn result;\n");
      writer.write("\t}\n\n");
      writer.write("\t@Override\n");
      writer.write("\tpublic boolean equals(Object obj) {\n");
      writer.write("\t\tif (this == obj)\n");
      writer.write("\t\t\treturn true;\n");
      writer.write("\t\tif (obj == null)\n");
      writer.write("\t\t\treturn false;\n");
      writer.write("\t\tif (getClass() != obj.getClass())\n");
      writer.write("\t\t\treturn false;\n");
      writer.write("\t\t" + cls + " other = (" + cls + ") obj;\n");
      writer.write("\t\tif (" + primaryField + " != other." + primaryField
          + ")\n");
      writer.write("\t\t\treturn false;\n");
      writer.write("\t\treturn true;\n");
      writer.write("\t}\n\n");
      writer.write("\t@Override\n");
      writer.write("\tpublic String toString() {\n");
      writer.write("\t\tStringBuilder builder = new StringBuilder();\n");
      writer.write("\t\tbuilder.append(\"JstatHostBean [");
      int counter = 0;
      for (Element e : elements) {
        if (counter > 0) {
          writer.write("\t\tbuilder.append(\", ");
        }
        writer.write(e.getSimpleName().toString() + "=\");\n");
        writer.write("\t\tbuilder.append(" + e.getSimpleName().toString()
            + ");\n");
        counter++;
      }
      writer.write("\t\tbuilder.append(\"]\");\n");
      writer.write("\t\treturn builder.toString();\n");
      writer.write("\t}\n");
      writer.write("\t@Override\n");
      writer.write("\tpublic int compareTo(" + cls + " o) {\n");
      writer.write("\t\treturn " + primaryField + " - o." + primaryField
          + ";\n");
      writer.write("\t}\n");
      writer.write("}");
      writer.flush();
      writer.close();
    } catch (IOException e) {
      log.error("File I/O error", e);
      JstatUIError.addErrors(603, "Error in I/O operation");
    } catch (ClassNotFoundException e) {
      log.error("Class not found", e);
      JstatUIError.addErrors(607, "Class not found");
    }

  }
}
