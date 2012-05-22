/**
 * Created on May 22, 2012
 */
package org.swaroop.jstatui.servlet.ws;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;

import org.apache.catalina.websocket.MessageInbound;
import org.apache.catalina.websocket.WsOutbound;
import org.apache.log4j.Logger;
import org.swaroop.jstatui.error.JstatUIError;

import sun.security.action.GetBooleanAction;

/**
 * This class responds to all message related request from WebSocket
 * {@link org.swaroop.jstatui.servlet.ws.GraphWebSocket GraphWebSocket}
 * 
 * @author Swaroop Patra
 * 
 */
public class GraphMessage extends MessageInbound {

  private static final Logger log = Logger.getLogger("jstatui");

  @Override
  protected void onClose(int status) {
    super.onClose(status);
    log.info("Closing");
  }

  @Override
  protected void onOpen(WsOutbound outbound) {
    super.onOpen(outbound);
    log.info("Opening");
  }

  @Override
  public void onUpgradeComplete() {
    super.onUpgradeComplete();
    log.info("Upgrade complete");
  }

  @Override
  protected void onBinaryMessage(ByteBuffer bBuf) throws IOException {
    log.info("onBinaryMessage");
    // broadCast(bBuf.toString());
    getWsOutbound().writeBinaryMessage((ByteBuffer.wrap("Hello".getBytes())));
    getWsOutbound().flush();
    getWsOutbound().close(1, ByteBuffer.wrap("Closed".getBytes()));
  }

  @Override
  protected void onTextMessage(CharBuffer cBuf) throws IOException {
    log.info("onTextMessage");
    // broadCast(cBuf.toString());
    getWsOutbound().writeTextMessage(CharBuffer.wrap("Testing"));
    getWsOutbound().flush();
    getWsOutbound().close(1, ByteBuffer.wrap("Closed".getBytes()));
  }

  private void broadCast(String str) {
    log.info("broadCast");
    try {
      WsOutbound out = getWsOutbound();
      out.writeTextMessage(CharBuffer.wrap("Testing"));
      Thread.sleep(10000);
    } catch (InterruptedException e) {
      log.error(e, e);
      JstatUIError.addErrors(600, "Unable to send graph data");
    } catch (IOException e) {
      log.error(e, e);
      JstatUIError.addErrors(611, "Unable to send graph data");
    }
  }

}
