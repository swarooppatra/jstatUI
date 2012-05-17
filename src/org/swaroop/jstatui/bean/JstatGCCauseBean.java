/**
 * Created on May 13, 2012
 */
package org.swaroop.jstatui.bean;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.swaroop.jstatui.annotations.Column;
import org.swaroop.jstatui.annotations.Table;
import org.swaroop.jstatui.error.JstatUIError;

/**
 * This class corresponds to jstat_gccause table and -gccause output option of
 * jstat
 * 
 * @author Swaroop Patra
 * 
 */
@Table(name = "jstat_gccause")
public class JstatGCCauseBean implements Comparable<JstatGCCauseBean>,
    JstatOptionBean, Serializable {

  private static final long serialVersionUID = 1L;

  private static final String STAT_COLUMN_SCHEMA = "timeElasped::S0::S1::E::O::P::YGC::YGCT::FGC::FGCT::GCT::LGCC::GCC";

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

  @Column(name = "LGCC")
  private String LGCC;

  @Column(name = "GCC")
  private String GCC;

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

  /**
   * @return the lGCC
   */
  public String getLGCC() {
    return LGCC;
  }

  /**
   * @param lGCC
   *          the lGCC to set
   */
  public void setLGCC(String lGCC) {
    LGCC = lGCC;
  }

  /**
   * @return the gCC
   */
  public String getGCC() {
    return GCC;
  }

  /**
   * @param gCC
   *          the gCC to set
   */
  public void setGCC(String gCC) {
    GCC = gCC;
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
    JstatGCCauseBean other = (JstatGCCauseBean) obj;
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
    buffer.append("JstatGCCauseBean [id=");
    buffer.append(id);
    buffer.append(", hostID=");
    buffer.append(hostID);
    buffer.append(", timeElasped=");
    buffer.append(timeElasped);
    buffer.append(", S0=");
    buffer.append(S0);
    buffer.append(", S1=");
    buffer.append(S1);
    buffer.append(", E=");
    buffer.append(E);
    buffer.append(", O=");
    buffer.append(O);
    buffer.append(", P=");
    buffer.append(P);
    buffer.append(", YGC=");
    buffer.append(YGC);
    buffer.append(", YGCT=");
    buffer.append(YGCT);
    buffer.append(", FGC=");
    buffer.append(FGC);
    buffer.append(", FGCT=");
    buffer.append(FGCT);
    buffer.append(", GCT=");
    buffer.append(GCT);
    buffer.append(", LGCC=");
    buffer.append(LGCC);
    buffer.append(", GCC=");
    buffer.append(GCC);
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
    buffer.append(S0);
    buffer.append(",");
    buffer.append(S1);
    buffer.append(",");
    buffer.append(E);
    buffer.append(",");
    buffer.append(O);
    buffer.append(",");
    buffer.append(P);
    buffer.append(",");
    buffer.append(YGC);
    buffer.append(",");
    buffer.append(YGCT);
    buffer.append(",");
    buffer.append(FGC);
    buffer.append(",");
    buffer.append(FGCT);
    buffer.append(",");
    buffer.append(GCT);
    buffer.append(",");
    buffer.append(LGCC);
    buffer.append(",");
    buffer.append(GCC);
    buffer.append("]");
    return buffer.toString();
  }

  @Override
  public JstatOptionBean parseStat(String stat) {
    log.info("Parsing collected stats");
    if (stat == null || "".equals(stat) || "null".equals(stat)) {
      log.error("Stat is not available. Check if the process is running");
      JstatUIError.addErrors(600, "Invalid value for stat is supplied");
      // TODO : need to change to a bean object
      return null;
    }
    JstatGCCauseBean bean = new JstatGCCauseBean();
    String[] stats = stat.trim().split("[\\s\\t]+");
    String[] columns = STAT_COLUMN_SCHEMA.split("::");
    Map<String, String> columnValueMap = new HashMap<String, String>();
    for (int i = 0; i < columns.length; i++) {
      if (i == 11) {
        columnValueMap.put(columns[i], stats[i] + " " + stats[i + 1]);
        continue;
      }
      if (i == 12) {
        columnValueMap.put(columns[i], stats[i + 1] + " " + stats[i + 2]);
        continue;
      }
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
    bean.setLGCC(columnValueMap.get("LGCC"));
    bean.setGCC(columnValueMap.get("GCC"));
    return bean;
  }

  @Override
  public int compareTo(JstatGCCauseBean o) {
    return id - o.id;
  }

}
