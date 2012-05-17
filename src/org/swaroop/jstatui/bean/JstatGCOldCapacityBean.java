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
 * This class corresponds to jstat_gcoldcapacaty table and -gcoldcapacity output
 * option of jstat
 * 
 * @author Swaroop Patra
 * 
 */
@Table(name = "jstat_gcoldcapacity")
public class JstatGCOldCapacityBean implements Serializable,
    Comparable<JstatGCOldCapacityBean>, JstatOptionBean {

  private static final long serialVersionUID = 1L;

  private static final String STAT_COLUMN_SCHEMA = "timeElasped::OGCMN::OGCMX::OGC::OC::YGC::FGC::FGCT::GCT";

  @Column(name = "id", isPrimary = true)
  private int id;

  @Column(name = "host_id")
  private int hostID;

  @Column(name = "time_elasped")
  private float timeElasped;

  @Column(name = "OGCMN")
  private float OGCMN;

  @Column(name = "OGCMX")
  private float OGCMX;

  @Column(name = "OGC")
  private float OGC;

  @Column(name = "OC")
  private float OC;

  @Column(name = "YGC")
  private int YGC;

  @Column(name = "FGC")
  private int FGC;

  @Column(name = "FGCT")
  private float FGCT;

  @Column(name = "GCT")
  private float GCT;

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
   * @return the oGCMN
   */
  public float getOGCMN() {
    return OGCMN;
  }

  /**
   * @param oGCMN
   *          the oGCMN to set
   */
  public void setOGCMN(float oGCMN) {
    OGCMN = oGCMN;
  }

  /**
   * @return the oGCMX
   */
  public float getOGCMX() {
    return OGCMX;
  }

  /**
   * @param oGCMX
   *          the oGCMX to set
   */
  public void setOGCMX(float oGCMX) {
    OGCMX = oGCMX;
  }

  /**
   * @return the oGC
   */
  public float getOGC() {
    return OGC;
  }

  /**
   * @param oGC
   *          the oGC to set
   */
  public void setOGC(float oGC) {
    OGC = oGC;
  }

  /**
   * @return the oC
   */
  public float getOC() {
    return OC;
  }

  /**
   * @param oC
   *          the oC to set
   */
  public void setOC(float oC) {
    OC = oC;
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

  /**
   * @return the fGCT
   */
  public float getFGCT() {
    return FGCT;
  }

  /**
   * @param fGCT
   *          the fGCT to set
   */
  public void setFGCT(float fGCT) {
    FGCT = fGCT;
  }

  /**
   * @return the gCT
   */
  public float getGCT() {
    return GCT;
  }

  /**
   * @param gCT
   *          the gCT to set
   */
  public void setGCT(float gCT) {
    GCT = gCT;
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
    JstatGCOldCapacityBean other = (JstatGCOldCapacityBean) obj;
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
    buffer.append("[");
    buffer.append(timeElasped);
    buffer.append(",");
    buffer.append(OGCMN);
    buffer.append(",");
    buffer.append(OGCMX);
    buffer.append(",");
    buffer.append(OGC);
    buffer.append(",");
    buffer.append(OC);
    buffer.append(",");
    buffer.append(YGC);
    buffer.append(",");
    buffer.append(FGC);
    buffer.append(",");
    buffer.append(FGCT);
    buffer.append(",");
    buffer.append(GCT);
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
    // TODO Auto-generated method stub
    return null;
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
    JstatGCOldCapacityBean bean = new JstatGCOldCapacityBean();
    String[] stats = stat.trim().split("[\\s\\t]+");
    String[] columns = STAT_COLUMN_SCHEMA.split("::");
    Map<String, String> columnValueMap = new HashMap<String, String>();
    if (stats.length == columns.length) {
      for (int i = 0; i < columns.length; i++) {
        columnValueMap.put(columns[i], stats[i]);
      }
      bean.setTimeElasped(Float.parseFloat(columnValueMap.get("timeElasped")));
      // OGCMN OGCMX OGC OC YGC FGC FGCT GCT
      bean.setOGCMN(Float.parseFloat(columnValueMap.get("OGCMN")));
      bean.setOGCMX(Float.parseFloat(columnValueMap.get("OGCMX")));
      bean.setOGC(Float.parseFloat(columnValueMap.get("OGC")));
      bean.setOC(Float.parseFloat(columnValueMap.get("OC")));
      bean.setYGC(Integer.parseInt(columnValueMap.get("YGC")));
      bean.setFGC(Integer.parseInt(columnValueMap.get("FGC")));
      bean.setFGCT(Float.parseFloat(columnValueMap.get("FGCT")));
      bean.setGCT(Float.parseFloat(columnValueMap.get("GCT")));
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
  public int compareTo(JstatGCOldCapacityBean o) {
    return id - o.id;
  }

}
