package org.swaroop.jstatui.servlet;

import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.swaroop.jstatui.bean.JstatCustomPlotBean;
import org.swaroop.jstatui.db.DBConnection;
import org.swaroop.jstatui.orm.ORMProcessor;

/**
 * This servlet parse custom graph preference input and insert in database
 * 
 * @author Swaroop Patra
 */
public class SaveCustomGraphs extends HttpServlet {
  private static final long serialVersionUID = 1L;

  DBConnection dbConn = new DBConnection();

  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    int graphCount = 0;
    Map<String, String[]> params = request.getParameterMap();
    Set<String> names = new TreeSet<String>(params.keySet());
    for (String paramName : names) {
      if (paramName.startsWith("graph")) {
        graphCount++;
      }
    }
    for (int i = 1; i <= graphCount; i++) {
      int statCnt = 1;
      String statOptStr = "";
      while (true) {
        if (params.containsKey("stat" + i + statCnt + "" + 1)) {
          if (statCnt > 1) {
            statOptStr = statOptStr + ";";
          }
          statOptStr = statOptStr
              + params.get("stat" + i + statCnt + "" + 1)[0] + "::"
              + params.get("statopt" + i + statCnt + "" + 2)[0];
          statCnt++;
        } else {
          JstatCustomPlotBean bean = new JstatCustomPlotBean();
          bean.setPlotName(params.get("graph" + i)[0]);
          bean.setTypeAndParam(statOptStr);
          ORMProcessor.insertABean(bean, dbConn.getConnection());
          break;
        }
      }
    }
  }

  public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doGet(request, response);
  }

}
