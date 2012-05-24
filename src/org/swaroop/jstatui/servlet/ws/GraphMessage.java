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

/**
 * This class responds to all message related request from WebSocket
 * {@link org.swaroop.jstatui.servlet.ws.GraphWebSocket GraphWebSocket}
 * 
 * @author Swaroop Patra
 * 
 */
public class GraphMessage extends MessageInbound {

  private static final Logger log = Logger.getLogger("jstatui");

  public GraphMessage() {
    setByteBufferMaxSize(3000);
    setCharBufferMaxSize(3000);
  }

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
    if (bBuf.toString().equals("disconnect")) {
      bThread.interrupt();
      onClose(1);
    } else {
      broadCast(bBuf.toString());
    }
  }

  @Override
  protected void onTextMessage(CharBuffer cBuf) throws IOException {
    log.info("onTextMessage");
    if (cBuf.toString().equals("disconnect")) {
      bThread.interrupt();
      onClose(1);
    } else {
      broadCast(cBuf.toString());
    }
  }

  private void broadCast(String str) {
    log.info("broadCast");
    WsOutbound out = getWsOutbound();
    BroadCastThread bt = new BroadCastThread(out);
    bThread = new Thread(bt);
    bThread.start();
  }

  Thread bThread = null;

  private class BroadCastThread implements Runnable {

    private WsOutbound outBound = null;

    public BroadCastThread(WsOutbound outBound) {
      this.outBound = outBound;
    }

    @Override
    public void run() {
      while (true) {
        if (outBound != null) {
          try {
            outBound.writeTextMessage(CharBuffer.wrap("Testing"));
            System.out.println("Testing");
            outBound.flush();
            Thread.sleep(1000);
          } catch (IOException e) {
            log.error(e, e);
            break;
          } catch (Exception e) {
            log.error(e, e);
            break;
          }
        } else {
          break;
        }
      }
    }

  }

}
