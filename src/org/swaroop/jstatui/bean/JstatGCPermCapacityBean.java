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
 * This class corresponds to jstat_gcpermcapacity and -gcpermcapacity optput
 * option of jstat
 * 
 * @author Swaroop Patra
 * 
 */
@Table(name = "jstat_gcpermcapacity")
public class JstatGCPermCapacityBean implements Serializable,
    Comparable<JstatGCPermCapacityBean>, JstatOptionBean {

  private static final long serialVersionUID = 1L;

  private static final String STAT_COLUMN_SCHEMA = "timeElasped::PGCMN::PGCMX::PGC::PC::YGC::FGC::FGCT::GCT";

  @Column(name = "id", isPrimary = true)
  private int id;

  @Column(name = "host_id")
  private int hostID;

  @Column(name = "time_elasped")
  private float timeElasped;

  @Column(name = "PGCMN")
  private float PGCMN;

  @Column(name = "PGCMX")
  private float PGCMX;

  @Column(name = "PGC")
  private float PGC;

  @Column(name = "PC")
  private float PC;

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
   * @return the pGCMN
   */
  public float getPGCMN() {
    return PGCMN;
  }

  /**
   * @param pGCMN
   *          the pGCMN to set
   */
  public void setPGCMN(float pGCMN) {
    PGCMN = pGCMN;
  }

  /**
   * @return the pGCMX
   */
  public float getPGCMX() {
    return PGCMX;
  }

  /**
   * @param pGCMX
   *          the pGCMX to set
   */
  public void setPGCMX(float pGCMX) {
    PGCMX = pGCMX;
  }

  /**
   * @return the pGC
   */
  public float getPGC() {
    return PGC;
  }

  /**
   * @param pGC
   *          the pGC to set
   */
  public void setPGC(float pGC) {
    PGC = pGC;
  }

  /**
   * @return the pC
   */
  public float getPC() {
    return PC;
  }

  /**
   * @param pC
   *          the pC to set
   */
  public void setPC(float pC) {
    PC = pC;
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
    JstatGCPermCapacityBean other = (JstatGCPermCapacityBean) obj;
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
    builder.append("JstatGCPermCapacityBean [id=");
    builder.append(id);
    builder.append(", hostID=");
    builder.append(hostID);
    builder.append(", timeElasped=");
    builder.append(timeElasped);
    builder.append(", PGCMN=");
    builder.append(PGCMN);
    builder.append(", PGCMX=");
    builder.append(PGCMX);
    builder.append(", PGC=");
    builder.append(PGC);
    builder.append(", PC=");
    builder.append(PC);
    builder.append(", YGC=");
    builder.append(YGC);
    builder.append(", FGC=");
    builder.append(FGC);
    builder.append(", FGCT=");
    builder.append(FGCT);
    builder.append(", GCT=");
    builder.append(GCT);
    builder.append("]");
    return builder.toString();
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
    JstatGCPermCapacityBean bean = new JstatGCPermCapacityBean();
    String[] stats = stat.trim().split("[\\s\\t]+");
    String[] columns = STAT_COLUMN_SCHEMA.split("::");
    Map<String, String> columnValueMap = new HashMap<String, String>();
    if (stats.length == columns.length) {
      for (int i = 0; i < columns.length; i++) {
        columnValueMap.put(columns[i], stats[i]);
      }
      bean.setTimeElasped(Float.parseFloat(columnValueMap.get("timeElasped")));
      // PGCMN PGCMX PGC PC YGC FGC FGCT GCT
      bean.setPGCMN(Float.parseFloat(columnValueMap.get("PGCMN")));
      bean.setPGCMX(Float.parseFloat(columnValueMap.get("PGCMX")));
      bean.setPGC(Float.parseFloat(columnValueMap.get("PGC")));
      bean.setPC(Float.parseFloat(columnValueMap.get("PC")));
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
  public int compareTo(JstatGCPermCapacityBean o) {
    return id - o.id;
  }

}
