package org.swaroop.jstatui.servlet.ws;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.websocket.StreamInbound;
import org.apache.catalina.websocket.WebSocketServlet;

/**
 * WebSocket implementation for plotting graph on UI pages
 * 
 * @author Swaroop Patra
 */
public class GraphWebSocket extends WebSocketServlet {
  private static final long serialVersionUID = 1L;
  
  private HttpServletRequest request;
  
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    super.doGet(req, resp);
    request = req;
  }



  @Override
  protected StreamInbound createWebSocketInbound(String arg0) {
    System.out.println("SubProtocol :: "+arg0);
    return new GraphMessage(request);
  }

}
