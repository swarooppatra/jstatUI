/**
 * Created on May 22, 2012
 */
package org.swaroop.jstatui.servlet.ws;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.util.List;

import org.apache.catalina.websocket.MessageInbound;
import org.apache.catalina.websocket.WsOutbound;
import org.apache.log4j.Logger;
import org.swaroop.jstatui.bean.JstatHostBean;
import org.swaroop.jstatui.bean.JstatOptionBean;
import org.swaroop.jstatui.collector.JStatOptions;
import org.swaroop.jstatui.db.DBConnection;
import org.swaroop.jstatui.orm.ORMProcessor;
import org.swaroop.jstatui.util.JstatUtil;

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
    if (bBuf.toString().equals("disconnect")) {
      bThread.interrupt();
    } else if (bBuf.toString().equals("1")) {
    } else {
      log.info("onBinaryMessage");
      broadCast(bBuf.toString());
    }
  }

  @Override
  protected void onTextMessage(CharBuffer cBuf) throws IOException {
    if (cBuf.toString().equals("disconnect")) {
      bThread.interrupt();
    } else if (cBuf.toString().equals("1")) {
    } else {
      log.info("onTextMessage");
      broadCast(cBuf.toString());
    }
  }

  private void broadCast(String str) {
    log.info("broadCast");
    WsOutbound out = getWsOutbound();
    // TODO : replace empty strings with data
    BroadCastThread bt = new BroadCastThread(out, "r113", "123412");
    bThread = new Thread(bt);
    bThread.start();
  }

  Thread bThread = null;

  private class BroadCastThread implements Runnable {

    private WsOutbound outBound = null;

    private String host;

    private String processID;

    DBConnection dbConn = new DBConnection();

    public BroadCastThread(WsOutbound outBound, String host, String processID) {
      this.outBound = outBound;
      this.host = host;
      this.processID = processID;
    }

    @Override
    public void run() {
      while (true) {
        if (outBound != null) {
          try {
            JstatHostBean hostBean = new JstatHostBean();
            // TODO : create an api in DAO/ORMProcessor to get the hostID
            hostBean.setId(1);
            hostBean.setHost(host);
            hostBean.setJvmProcessId(Integer.parseInt(processID));
            JStatOptions[] options = JStatOptions.values();
            //for (JStatOptions option : options) {
              List<? extends JstatOptionBean> records = ORMProcessor
                  .getLatestRecordsByCount(hostBean, JStatOptions.CLASS,
                      dbConn.getConnection(), 100);
              String ploatString = JstatUtil.getPlotString(records);
              System.out.println(JStatOptions.CLASS.name().toLowerCase()
                  + " ::::::::::::::: " + ploatString);
              outBound.writeTextMessage(CharBuffer.wrap(ploatString));
            //}
            
            Thread.sleep(3000);
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
