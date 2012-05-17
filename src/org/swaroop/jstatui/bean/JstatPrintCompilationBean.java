/**
 * Created on May 15, 2012
 */
package org.swaroop.jstatui.bean;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.swaroop.jstatui.annotations.Column;
import org.swaroop.jstatui.annotations.Table;
import org.swaroop.jstatui.error.JstatUIError;

/**
 * This class corresponds to jstat_printcompilation table and -printcompilation
 * output option of jstat
 * 
 * @author Swaroop Patra
 * 
 */
@Table(name = "jstat_printcompilation")
public class JstatPrintCompilationBean implements Serializable,
    Comparable<JstatPrintCompilationBean>, JstatOptionBean {

  private static final long serialVersionUID = 1L;

  private static final String STAT_COLUMN_SCHEMA = "timeElasped::Compiled::Size::Type::Method";

  @Column(name = "id", isPrimary = true)
  private int id;

  @Column(name = "host_id")
  private int hostID;

  @Column(name = "time_elasped")
  private float timeElasped;

  @Column(name = "compiled")
  private int compiled;

  @Column(name = "size")
  private int size;

  @Column(name = "type")
  private int type;

  @Column(name = "method")
  private String method;

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
   * @return the hostID
   */
  public int getHostID() {
    return hostID;
  }

  /**
   * @param hostID
   *          the hostID to set
   */
  public void setHostID(int hostID) {
    this.hostID = hostID;
  }

  /**
   * @return the timeElasped
   */
  public float getTimeElasped() {
    return timeElasped;
  }

  /**
   * @param timeElasped
   *          the timeElasped to set
   */
  public void setTimeElasped(float timeElasped) {
    this.timeElasped = timeElasped;
  }

  /**
   * @return the compiled
   */
  public int getCompiled() {
    return compiled;
  }

  /**
   * @param compiled
   *          the compiled to set
   */
  public void setCompiled(int compiled) {
    this.compiled = compiled;
  }

  /**
   * @return the size
   */
  public int getSize() {
    return size;
  }

  /**
   * @param size
   *          the size to set
   */
  public void setSize(int size) {
    this.size = size;
  }

  /**
   * @return the type
   */
  public int getType() {
    return type;
  }

  /**
   * @param type
   *          the type to set
   */
  public void setType(int type) {
    this.type = type;
  }

  /**
   * @return the method
   */
  public String getMethod() {
    return method;
  }

  /**
   * @param method
   *          the method to set
   */
  public void setMethod(String method) {
    this.method = method;
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
    JstatPrintCompilationBean other = (JstatPrintCompilationBean) obj;
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
    builder.append("JstatPrintCompilationBean [id=");
    builder.append(id);
    builder.append(", hostID=");
    builder.append(hostID);
    builder.append(", timeElasped=");
    builder.append(timeElasped);
    builder.append(", compiled=");
    builder.append(compiled);
    builder.append(", size=");
    builder.append(size);
    builder.append(", type=");
    builder.append(type);
    builder.append(", method=");
    builder.append(method);
    builder.append("]");
    return builder.toString();
  }

  // Compiled Size Type Method
  /*
   * (non-Javadoc)
   * 
   * @see org.swaroop.jstatui.bean.JstatOptionBean#parseStat(java.lang.String)
   */
  @Override
  public JstatOptionBean parseStat(String stat) {
    log.info("Parsing collected stats");
    if (stat == null || "".equals(stat) || "null".equals(stat)) {
      log.error("Stat is not available. Check if the process is running");
      JstatUIError.addErrors(600, "Invalid value for stat is supplied");
      // TODO : need to change to a bean object
      return null;
    }
    JstatPrintCompilationBean bean = new JstatPrintCompilationBean();
    String[] stats = stat.trim().split("[\\s\\t]+");
    String[] columns = STAT_COLUMN_SCHEMA.split("::");
    Map<String, String> columnValueMap = new HashMap<String, String>();
    for (int i = 0; i < columns.length; i++) {
      if (i == 4) {
        columnValueMap.put(columns[i], stats[i] + " " + stats[i + 1]);
      } else {
        columnValueMap.put(columns[i], stats[i]);
      }
    }
    bean.setTimeElasped(Float.parseFloat(columnValueMap.get("timeElasped")));
    bean.setCompiled(Integer.parseInt(columnValueMap.get("Compiled")));
    bean.setSize(Integer.parseInt(columnValueMap.get("Size")));
    bean.setType(Integer.parseInt(columnValueMap.get("Type")));
    bean.setMethod(columnValueMap.get("Method"));
    return bean;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Comparable#compareTo(java.lang.Object)
   */
  @Override
  public int compareTo(JstatPrintCompilationBean o) {
    return id - o.id;
  }

}
