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
 * This class corresponds to jstat_gcold table and -gcold output option of jstat
 * 
 * @author Swaroop Patra
 * 
 */
@Table(name = "jstat_gcold")
public class JstatGCOldBean implements Serializable,
    Comparable<JstatGCOldBean>, JstatOptionBean {

  private static final long serialVersionUID = 1L;

  private static final String STAT_COLUMN_SCHEMA = "timeElasped::PC::PU::OC::OU::YGC::FGC::FGCT::GCT";

  @Column(name = "id", isPrimary = true)
  private int id;

  @Column(name = "host_id")
  private int hostID;

  @Column(name = "time_elasped")
  private float timeElasped;

  @Column(name = "PC")
  private float PC;

  @Column(name = "PU")
  private float PU;

  @Column(name = "OC")
  private float OC;

  @Column(name = "OU")
  private float OU;

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
   * @return the pU
   */
  public float getPU() {
    return PU;
  }

  /**
   * @param pU
   *          the pU to set
   */
  public void setPU(float pU) {
    PU = pU;
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
   * @return the oU
   */
  public float getOU() {
    return OU;
  }

  /**
   * @param oU
   *          the oU to set
   */
  public void setOU(float oU) {
    OU = oU;
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
    JstatGCOldBean other = (JstatGCOldBean) obj;
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
    builder.append("JstatGCOldBean [id=");
    builder.append(id);
    builder.append(", hostID=");
    builder.append(hostID);
    builder.append(", timeElasped=");
    builder.append(timeElasped);
    builder.append(", PC=");
    builder.append(PC);
    builder.append(", PU=");
    builder.append(PU);
    builder.append(", OC=");
    builder.append(OC);
    builder.append(", OU=");
    builder.append(OU);
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
    JstatGCOldBean bean = new JstatGCOldBean();
    String[] stats = stat.trim().split("[\\s\\t]+");
    String[] columns = STAT_COLUMN_SCHEMA.split("::");
    Map<String, String> columnValueMap = new HashMap<String, String>();
    if (stats.length == columns.length) {
      for (int i = 0; i < columns.length; i++) {
        columnValueMap.put(columns[i], stats[i]);
      }
      bean.setTimeElasped(Float.parseFloat(columnValueMap.get("timeElasped")));
      bean.setPC(Float.parseFloat(columnValueMap.get("PC")));
      bean.setPU(Float.parseFloat(columnValueMap.get("PU")));
      bean.setOC(Float.parseFloat(columnValueMap.get("OC")));
      bean.setOU(Float.parseFloat(columnValueMap.get("OU")));
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
  public int compareTo(JstatGCOldBean o) {
    return id - o.id;
  }

}
