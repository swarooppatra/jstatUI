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
 * This class corresponds to jstat_gcnewcapacity and -gcnewcapacity output
 * option of jstat
 * 
 * @author Swaroop Patra
 * 
 */
@Table(name = "jstat_gcnewcapacity")
public class JstatGCNewCapacityBean implements Serializable,
    Comparable<JstatGCNewCapacityBean>, JstatOptionBean {

  private static final long serialVersionUID = 1L;

  private static final String STAT_COLUMN_SCHEMA = "timeElasped::NGCMN::NGCMX::NGC::S0CMX::S0C::S1CMX::S1C::ECMX::EC::YGC::FGC";

  @Column(name = "id", isPrimary = true)
  private int id;

  @Column(name = "host_id")
  private int hostID;

  @Column(name = "time_elasped")
  private float timeElasped;

  @Column(name = "NGCMN")
  private float NGCMN;

  @Column(name = "NGCMX")
  private float NGCMX;

  @Column(name = "NGC")
  private float NGC;

  @Column(name = "S0CMX")
  private float S0CMX;

  @Column(name = "S0C")
  private float S0C;

  @Column(name = "S1CMX")
  private float S1CMX;

  @Column(name = "S1C")
  private float S1C;

  @Column(name = "ECMX")
  private float ECMX;

  @Column(name = "EC")
  private float EC;

  @Column(name = "YGC")
  private int YGC;

  @Column(name = "FGC")
  private int FGC;

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
   * @return the nGCMN
   */
  public float getNGCMN() {
    return NGCMN;
  }

  /**
   * @param nGCMN
   *          the nGCMN to set
   */
  public void setNGCMN(float nGCMN) {
    NGCMN = nGCMN;
  }

  /**
   * @return the nGCMX
   */
  public float getNGCMX() {
    return NGCMX;
  }

  /**
   * @param nGCMX
   *          the nGCMX to set
   */
  public void setNGCMX(float nGCMX) {
    NGCMX = nGCMX;
  }

  /**
   * @return the nGC
   */
  public float getNGC() {
    return NGC;
  }

  /**
   * @param nGC
   *          the nGC to set
   */
  public void setNGC(float nGC) {
    NGC = nGC;
  }

  /**
   * @return the s0CMX
   */
  public float getS0CMX() {
    return S0CMX;
  }

  /**
   * @param s0cmx
   *          the s0CMX to set
   */
  public void setS0CMX(float s0cmx) {
    S0CMX = s0cmx;
  }

  /**
   * @return the s0C
   */
  public float getS0C() {
    return S0C;
  }

  /**
   * @param s0c
   *          the s0C to set
   */
  public void setS0C(float s0c) {
    S0C = s0c;
  }

  /**
   * @return the s1CMX
   */
  public float getS1CMX() {
    return S1CMX;
  }

  /**
   * @param s1cmx
   *          the s1CMX to set
   */
  public void setS1CMX(float s1cmx) {
    S1CMX = s1cmx;
  }

  /**
   * @return the s1C
   */
  public float getS1C() {
    return S1C;
  }

  /**
   * @param s1c
   *          the s1C to set
   */
  public void setS1C(float s1c) {
    S1C = s1c;
  }

  /**
   * @return the eCMX
   */
  public float getECMX() {
    return ECMX;
  }

  /**
   * @param eCMX
   *          the eCMX to set
   */
  public void setECMX(float eCMX) {
    ECMX = eCMX;
  }

  /**
   * @return the eC
   */
  public float getEC() {
    return EC;
  }

  /**
   * @param eC
   *          the eC to set
   */
  public void setEC(float eC) {
    EC = eC;
  }

  /**
   * @return the yGC
   */
  public int getYGC() {
    return YGC;
  }

  /**
   * @param yGC
   *          the yGC to set
   */
  public void setYGC(int yGC) {
    YGC = yGC;
  }

  /**
   * @return the fGC
   */
  public int getFGC() {
    return FGC;
  }

  /**
   * @param fGC
   *          the fGC to set
   */
  public void setFGC(int fGC) {
    FGC = fGC;
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
    JstatGCNewCapacityBean other = (JstatGCNewCapacityBean) obj;
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
    StringBuffer buffer = new StringBuffer();
    buffer.append("JstatGCNewCapacityBean [id=");
    buffer.append(id);
    buffer.append(", hostID=");
    buffer.append(hostID);
    buffer.append(", timeElasped=");
    buffer.append(timeElasped);
    buffer.append(", NGCMN=");
    buffer.append(NGCMN);
    buffer.append(", NGCMX=");
    buffer.append(NGCMX);
    buffer.append(", NGC=");
    buffer.append(NGC);
    buffer.append(", S0CMX=");
    buffer.append(S0CMX);
    buffer.append(", S0C=");
    buffer.append(S0C);
    buffer.append(", S1CMX=");
    buffer.append(S1CMX);
    buffer.append(", S1C=");
    buffer.append(S1C);
    buffer.append(", ECMX=");
    buffer.append(ECMX);
    buffer.append(", EC=");
    buffer.append(EC);
    buffer.append(", YGC=");
    buffer.append(YGC);
    buffer.append(", FGC=");
    buffer.append(FGC);
    buffer.append("]");
    return buffer.toString();
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.swaroop.jstatui.bean.JstatOptionBean#toJsonString()
   */
  @Override
  public String toJsonString() {
    StringBuffer buffer = new StringBuffer();
    buffer.append("[");
    buffer.append(timeElasped);
    buffer.append(",");
    buffer.append(NGCMN);
    buffer.append(",");
    buffer.append(NGCMX);
    buffer.append(",");
    buffer.append(NGC);
    buffer.append(",");
    buffer.append(S0CMX);
    buffer.append(",");
    buffer.append(S0C);
    buffer.append(",");
    buffer.append(S1CMX);
    buffer.append(",");
    buffer.append(S1C);
    buffer.append(",");
    buffer.append(ECMX);
    buffer.append(",");
    buffer.append(EC);
    buffer.append(",");
    buffer.append(YGC);
    buffer.append(",");
    buffer.append(FGC);
    buffer.append("]");
    return buffer.toString();
  }

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
    JstatGCNewCapacityBean bean = new JstatGCNewCapacityBean();
    String[] stats = stat.trim().split("[\\s\\t]+");
    String[] columns = STAT_COLUMN_SCHEMA.split("::");
    Map<String, String> columnValueMap = new HashMap<String, String>();
    if (stats.length == columns.length) {
      for (int i = 0; i < columns.length; i++) {
        columnValueMap.put(columns[i], stats[i]);
      }
      bean.setTimeElasped(Float.parseFloat(columnValueMap.get("timeElasped")));
      // NGCMN NGCMX NGC S0CMX S0C S1CMX S1C ECMX EC YGC FGC
      bean.setNGCMN(Float.parseFloat(columnValueMap.get("NGCMN")));
      bean.setNGCMX(Float.parseFloat(columnValueMap.get("NGCMX")));
      bean.setNGC(Float.parseFloat(columnValueMap.get("NGC")));
      bean.setS0CMX(Float.parseFloat(columnValueMap.get("S0CMX")));
      bean.setS0C(Float.parseFloat(columnValueMap.get("S0C")));
      bean.setS1CMX(Float.parseFloat(columnValueMap.get("S1CMX")));
      bean.setS1C(Float.parseFloat(columnValueMap.get("S1C")));
      bean.setECMX(Float.parseFloat(columnValueMap.get("ECMX")));
      bean.setEC(Float.parseFloat(columnValueMap.get("EC")));
      bean.setYGC(Integer.parseInt(columnValueMap.get("YGC")));
      bean.setFGC(Integer.parseInt(columnValueMap.get("FGC")));
    } else {
      log.error("Error in parsing stats");
      JstatUIError.addErrors(608, "Error in parsing stats");
    }
    return bean;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Comparable#compareTo(java.lang.Object)
   */
  @Override
  public int compareTo(JstatGCNewCapacityBean o) {
    return id - o.id;
  }

}
