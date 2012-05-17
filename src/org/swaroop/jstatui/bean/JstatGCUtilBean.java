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
 * This class corresponds to jstat_gcutil table and -gcutil output option of
 * jstat
 * 
 * @author Swaroop Patra
 * 
 */
@Table(name="jstat_gcutil")
public class JstatGCUtilBean implements Serializable,
    Comparable<JstatGCUtilBean>, JstatOptionBean {

  private static final long serialVersionUID = 1L;

  private static final String STAT_COLUMN_SCHEMA = "timeElasped::S0::S1::E::O::P::YGC::YGCT::FGC::FGCT::GCT";

  @Column(name = "id", isPrimary = true)
  private int id;

  @Column(name = "host_id")
  private int hostID;

  @Column(name = "time_elasped")
  private float timeElasped;

  @Column(name = "S0")
  private float S0;

  @Column(name = "S1")
  private float S1;

  @Column(name = "E")
  private float E;

  @Column(name = "O")
  private float O;

  @Column(name = "P")
  private float P;

  @Column(name = "YGC")
  private int YGC;

  @Column(name = "YGCT")
  private float YGCT;

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
   * @return the s0
   */
  public float getS0() {
    return S0;
  }

  /**
   * @param s0
   *          the s0 to set
   */
  public void setS0(float s0) {
    S0 = s0;
  }

  /**
   * @return the s1
   */
  public float getS1() {
    return S1;
  }

  /**
   * @param s1
   *          the s1 to set
   */
  public void setS1(float s1) {
    S1 = s1;
  }

  /**
   * @return the e
   */
  public float getE() {
    return E;
  }

  /**
   * @param e
   *          the e to set
   */
  public void setE(float e) {
    E = e;
  }

  /**
   * @return the o
   */
  public float getO() {
    return O;
  }

  /**
   * @param o
   *          the o to set
   */
  public void setO(float o) {
    O = o;
  }

  /**
   * @return the p
   */
  public float getP() {
    return P;
  }

  /**
   * @param p
   *          the p to set
   */
  public void setP(float p) {
    P = p;
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
   * @return the yGCT
   */
  public float getYGCT() {
    return YGCT;
  }

  /**
   * @param yGCT
   *          the yGCT to set
   */
  public void setYGCT(float yGCT) {
    YGCT = yGCT;
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
    JstatGCUtilBean other = (JstatGCUtilBean) obj;
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
    builder.append("JstatGCUtilBean [id=");
    builder.append(id);
    builder.append(", hostID=");
    builder.append(hostID);
    builder.append(", timeElasped=");
    builder.append(timeElasped);
    builder.append(", S0=");
    builder.append(S0);
    builder.append(", S1=");
    builder.append(S1);
    builder.append(", E=");
    builder.append(E);
    builder.append(", O=");
    builder.append(O);
    builder.append(", P=");
    builder.append(P);
    builder.append(", YGC=");
    builder.append(YGC);
    builder.append(", YGCT=");
    builder.append(YGCT);
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
    JstatGCUtilBean bean = new JstatGCUtilBean();
    String[] stats = stat.trim().split("[\\s\\t]+");
    String[] columns = STAT_COLUMN_SCHEMA.split("::");
    Map<String, String> columnValueMap = new HashMap<String, String>();
    if (stats.length == columns.length) {
      for (int i = 0; i < columns.length; i++) {
        columnValueMap.put(columns[i], stats[i]);
      }
      bean.setTimeElasped(Float.parseFloat(columnValueMap.get("timeElasped")));
      bean.setS0(Float.parseFloat(columnValueMap.get("S0")));
      bean.setS1(Float.parseFloat(columnValueMap.get("S1")));
      bean.setE(Float.parseFloat(columnValueMap.get("E")));
      bean.setO(Float.parseFloat(columnValueMap.get("O")));
      bean.setP(Float.parseFloat(columnValueMap.get("P")));
      bean.setYGC(Integer.parseInt(columnValueMap.get("YGC")));
      bean.setYGCT(Float.parseFloat(columnValueMap.get("YGCT")));
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
  public int compareTo(JstatGCUtilBean o) {
    return id - o.id;
  }

}
