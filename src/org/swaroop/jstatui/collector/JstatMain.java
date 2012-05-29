/**
 * Created on May 3, 2012
 */
package org.swaroop.jstatui.collector;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.swaroop.jstatui.bean.JstatHostBean;
import org.swaroop.jstatui.error.JstatUIError;
import org.swaroop.jstatui.util.ProcessUtil;

/**
 * @author Swaroop Patra
 * 
 */
public class JstatMain {

  static final Logger log = Logger.getLogger("jstatui");

  public static ExecutorService service = null;

  /**
   * Start the collection process by spawning new thread for each kind of jstat
   * collection
   * 
   * @param host
   *          A {@link org.swaroop.jstatui.bean.JstatHostBean JstatHostBean}
   * 
   */
  public void start(JstatHostBean host) {
    log.info("Spawning thread to start stat collection");
    JStatOptions[] options = JStatOptions.values();
    service = Executors.newCachedThreadPool();
    for (JStatOptions option : options) {
      JstatCollector collector = new JstatCollector(host, option);
      FutureTask<JstatCollector> ft = new FutureTask<JstatCollector>(collector);
      service.submit(ft);
    }
  }

  /**
   * Shutdowns the ExecutorService pool
   * 
   * @param pool
   *          Executor service to stop
   */
  public static void shutdownAndAwaitTermination(ExecutorService pool) {
    log.info("Stopping executor service...");
    pool.shutdown(); // Disable new tasks from being submitted
    try {
      // Wait a while for existing tasks to terminate
      if (!pool.awaitTermination(60, TimeUnit.SECONDS)) {
        pool.shutdownNow(); // Cancel currently executing tasks
        // Wait a while for tasks to respond to being cancelled
        if (!pool.awaitTermination(60, TimeUnit.SECONDS))
          log.error("Pool did not terminate");
      }
    } catch (InterruptedException ie) {
      log.error(ie, ie);
      // (Re-)Cancel if current thread also interrupted
      pool.shutdownNow();
      // Preserve interrupt status
      Thread.currentThread().interrupt();
    }
  }

  public static void main(String args[]) {
    log.info("Starting start collection");
    PropertyConfigurator
        .configure("C:\\Users\\m1012257\\git\\jstatUI\\src\\org\\swaroop\\jstatui\\resource\\log4j.properties");
    JstatMain main = new JstatMain();
    JstatHostBean host = new JstatHostBean();
    host.setActive((short) 1);
    host.setHost("localhost");
    host.setId(1);
    host.setJvmProcessId(8928);
    host.setJvmStartTime("2012-05-15 01:00:00");
    host.setPort(1099);
    boolean running = ProcessUtil.checkProcessStatus("localhost",
        host.getJvmProcessId());
    if (running) {
      log.info("Process " + host.getJvmProcessId() + " is running");
      main.start(host);
    }
    log.info("Total # errors : " + JstatUIError.getErroCounts());
    log.info("Error : " + JstatUIError.getErrors());
  }
}
