/**
 * Created on May 6, 2012
 */
package org.swaroop.jstatui.bean;

import java.io.Serializable;

import org.swaroop.jstatui.annotations.Column;
import org.swaroop.jstatui.annotations.Table;

/**
 * This bean corresponds to jstat_host table
 * 
 * @author Swaroop Patra
 * 
 */
@Table(name = "jstat_host")
public class JstatHostBean implements Serializable, Comparable<JstatHostBean>,
    JstatOptionBean {

  private static final long serialVersionUID = 1L;

  @Column(name = "id", isPrimary = true)
  private int id;

  @Column(name = "host")
  private String host;

  @Column(name = "port")
  private int port;

  @Column(name = "jvm_process_id")
  private int jvmProcessId;

  @Column(name = "jvm_start_time")
  private String jvmStartTime;

  @Column(name = "active")
  private String active;

  /**
   * @return the id
   */
  public int getId() {
    return id;
  }

  /**
   * @param id
   *          the id to set
   */
  public void setId(int id) {
    this.id = id;
  }

  /**
   * @return the host
   */
  public String getHost() {
    return host;
  }

  /**
   * @param host
   *          the host to set
   */
  public void setHost(String host) {
    this.host = host;
  }

  /**
   * @return the port
   */
  public int getPort() {
    return port;
  }

  /**
   * @param port
   *          the port to set
   */
  public void setPort(int port) {
    this.port = port;
  }

  /**
   * @return the jvmProcessId
   */
  public int getJvmProcessId() {
    return jvmProcessId;
  }

  /**
   * @param jvmProcessId
   *          the jvmProcessId to set
   */
  public void setJvmProcessId(int jvmProcessId) {
    this.jvmProcessId = jvmProcessId;
  }

  /**
   * @return the jvmStartTime
   */
  public String getJvmStartTime() {
    return jvmStartTime;
  }

  /**
   * @param jvmStartTime
   *          the jvmStartTime to set
   */
  public void setJvmStartTime(String jvmStartTime) {
    this.jvmStartTime = jvmStartTime;
  }

  /**
   * @return the active
   */
  public String getActive() {
    return active;
  }

  /**
   * @param active
   *          the active to set
   */
  public void setActive(String active) {
    this.active = active;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + id;
    return result;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    JstatHostBean other = (JstatHostBean) obj;
    if (id != other.id)
      return false;
    return true;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("JstatHostBean [id=");
    builder.append(id);
    builder.append(", host=");
    builder.append(host);
    builder.append(", port=");
    builder.append(port);
    builder.append(", jvmProcessId=");
    builder.append(jvmProcessId);
    builder.append(", jvmStartTime=");
    builder.append(jvmStartTime);
    builder.append("]");
    return builder.toString();
  }

  @Override
  public int compareTo(JstatHostBean o) {
    return id - o.id;
  }

  @Override
  public JstatOptionBean parseStat(String stat) {
    // Implementation not needed
    return null;
  }

}
