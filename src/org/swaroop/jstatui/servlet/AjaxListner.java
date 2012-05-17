package org.swaroop.jstatui.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.swaroop.jstatui.bean.JstatHostBean;
import org.swaroop.jstatui.bean.JstatOptionBean;
import org.swaroop.jstatui.collector.JStatOptions;
import org.swaroop.jstatui.db.DBConnection;
import org.swaroop.jstatui.orm.ORMProcessor;
import org.swaroop.jstatui.util.JstatUtil;

/**
 * This servlet entertains all incoming ajax request
 * 
 * @author Swaroop Patra
 */
public class AjaxListner extends HttpServlet {

  private static final long serialVersionUID = 1L;

  private static final Logger log = Logger.getLogger("jstatui");

  private static DBConnection dbConn = new DBConnection();

  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    log.info("Forwarding GET request to POST method");
    doPost(request, response);
  }

  public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String host = request.getParameter("host");
    String processID = request.getParameter("processID");
    JstatHostBean hostBean = new JstatHostBean();
    // TODO : create an api in DAO/ORMProcessor to get the hostID
    hostBean.setId(1);
    hostBean.setHost(host);
    hostBean.setJvmProcessId(Integer.parseInt(processID));
    JStatOptions[] options = JStatOptions.values();
    for (JStatOptions option : options) {
      List<? extends JstatOptionBean> records = ORMProcessor
          .getLatestRecordsByCount(hostBean, option, dbConn.getConnection(),
              100);
      String ploatString = JstatUtil.getPlotString(records);
      System.out.println(option.name().toLowerCase() +" ::::::::::::::: "+ploatString);
      request.setAttribute(option.name().toLowerCase(), ploatString);
    }
    RequestDispatcher rd = request.getRequestDispatcher("/stats");
    rd.forward(request, response);
  }

}
