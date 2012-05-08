/**
 * Created on Aug 25, 2011
 */
package org.swaroop.jstatui.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.PropertyConfigurator;

/**
 * Servlet implementation class Log4jInit. This class initiates Log4j logger.
 */
public class Log4jInit extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void init() throws ServletException {
    String prefix = getServletContext().getRealPath("/");
    String file = getInitParameter("log4j-init-file");
    if (file != null) {
      PropertyConfigurator.configure(prefix + file);
    }
  }

}
