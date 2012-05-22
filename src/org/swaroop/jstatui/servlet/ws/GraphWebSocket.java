package org.swaroop.jstatui.servlet.ws;

import org.apache.catalina.websocket.StreamInbound;
import org.apache.catalina.websocket.WebSocketServlet;

/**
 * WebSocket implementation for plotting graph on UI pages
 * 
 * @author Swaroop Patra
 */
public class GraphWebSocket extends WebSocketServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected StreamInbound createWebSocketInbound(String arg0) {    
    return new GraphMessage();
  }

}
