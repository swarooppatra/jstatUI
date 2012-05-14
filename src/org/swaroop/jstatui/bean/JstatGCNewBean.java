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
 * This class corresponds to jstat_gcnew table and -gcnew output option of jstat
 * 
 * @author Swaroop Patra
 * 
 */
@Table(name = "jstat_gcnew")
public class JstatGCNewBean implements Serializable,
		Comparable<JstatGCNewBean>, JstatOptionBean {

	private static final long serialVersionUID = 1L;

	private static final String STAT_COLUMN_SCHEMA = "timeElasped::S0C::S1C::S0U::S1U::TT::MTT::DSS::EC::EU::YGC::YGCT";

	@Column(name = "id", isPrimary = true)
	private int id;

	@Column(name = "host_id")
	private int hostID;

	@Column(name = "time_elasped")
	private float timeElasped;

	@Column(name = "S0C")
	private float S0C;

	@Column(name = "S1C")
	private float S1C;

	@Column(name = "S0U")
	private float S0U;

	@Column(name = "S1U")
	private float S1U;

	@Column(name = "TT")
	private int TT;

	@Column(name = "MTT")
	private int MTT;

	@Column(name = "DSS")
	private float DSS;

	@Column(name = "EC")
	private float EC;

	@Column(name = "EU")
	private float EU;

	@Column(name = "YGC")
	private int YGC;

	@Column(name = "YGCT")
	private float YGCT;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
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
	 *            the hostID to set
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
	 *            the timeElasped to set
	 */
	public void setTimeElasped(float timeElasped) {
		this.timeElasped = timeElasped;
	}

	/**
	 * @return the s0C
	 */
	public float getS0C() {
		return S0C;
	}

	/**
	 * @param s0c
	 *            the s0C to set
	 */
	public void setS0C(float s0c) {
		S0C = s0c;
	}

	/**
	 * @return the s1C
	 */
	public float getS1C() {
		return S1C;
	}

	/**
	 * @param s1c
	 *            the s1C to set
	 */
	public void setS1C(float s1c) {
		S1C = s1c;
	}

	/**
	 * @return the s0U
	 */
	public float getS0U() {
		return S0U;
	}

	/**
	 * @param s0u
	 *            the s0U to set
	 */
	public void setS0U(float s0u) {
		S0U = s0u;
	}

	/**
	 * @return the s1U
	 */
	public float getS1U() {
		return S1U;
	}

	/**
	 * @param s1u
	 *            the s1U to set
	 */
	public void setS1U(float s1u) {
		S1U = s1u;
	}

	/**
	 * @return the tT
	 */
	public int getTT() {
		return TT;
	}

	/**
	 * @param tT
	 *            the tT to set
	 */
	public void setTT(int tT) {
		TT = tT;
	}

	/**
	 * @return the mTT
	 */
	public int getMTT() {
		return MTT;
	}

	/**
	 * @param mTT
	 *            the mTT to set
	 */
	public void setMTT(int mTT) {
		MTT = mTT;
	}

	/**
	 * @return the dSS
	 */
	public float getDSS() {
		return DSS;
	}

	/**
	 * @param dSS
	 *            the dSS to set
	 */
	public void setDSS(float dSS) {
		DSS = dSS;
	}

	/**
	 * @return the eC
	 */
	public float getEC() {
		return EC;
	}

	/**
	 * @param eC
	 *            the eC to set
	 */
	public void setEC(float eC) {
		EC = eC;
	}

	/**
	 * @return the eU
	 */
	public float getEU() {
		return EU;
	}

	/**
	 * @param eU
	 *            the eU to set
	 */
	public void setEU(float eU) {
		EU = eU;
	}

	/**
	 * @return the yGC
	 */
	public int getYGC() {
		return YGC;
	}

	/**
	 * @param yGC
	 *            the yGC to set
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
	 *            the yGCT to set
	 */
	public void setYGCT(float yGCT) {
		YGCT = yGCT;
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
		JstatGCNewBean other = (JstatGCNewBean) obj;
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
		builder.append("JstatGCNewBean [id=");
		builder.append(id);
		builder.append(", hostID=");
		builder.append(hostID);
		builder.append(", timeElasped=");
		builder.append(timeElasped);
		builder.append(", S0C=");
		builder.append(S0C);
		builder.append(", S1C=");
		builder.append(S1C);
		builder.append(", S0U=");
		builder.append(S0U);
		builder.append(", S1U=");
		builder.append(S1U);
		builder.append(", TT=");
		builder.append(TT);
		builder.append(", MTT=");
		builder.append(MTT);
		builder.append(", DSS=");
		builder.append(DSS);
		builder.append(", EC=");
		builder.append(EC);
		builder.append(", EU=");
		builder.append(EU);
		builder.append(", YGC=");
		builder.append(YGC);
		builder.append(", YGCT=");
		builder.append(YGCT);
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
		JstatGCNewBean bean = new JstatGCNewBean();
		String[] stats = stat.trim().split("[\\s\\t]+");
		String[] columns = STAT_COLUMN_SCHEMA.split("::");
		Map<String, String> columnValueMap = new HashMap<String, String>();
		if (stats.length == columns.length) {
			for (int i = 0; i < columns.length; i++) {
				columnValueMap.put(columns[i], stats[i]);
			}
			bean.setTimeElasped(Float.parseFloat(columnValueMap
					.get("timeElasped")));
			bean.setS0C(Float.parseFloat(columnValueMap.get("S0C")));
			bean.setS1C(Float.parseFloat(columnValueMap.get("SIC")));
			bean.setS0U(Float.parseFloat(columnValueMap.get("S0U")));
			bean.setS1U(Float.parseFloat(columnValueMap.get("S1U")));
			bean.setTT(Integer.parseInt(columnValueMap.get("TT")));
			bean.setMTT(Integer.parseInt(columnValueMap.get("MTT")));
			bean.setDSS(Float.parseFloat(columnValueMap.get("DSS")));
			bean.setEC(Float.parseFloat(columnValueMap.get("EC")));
			bean.setEU(Float.parseFloat(columnValueMap.get("EU")));
			bean.setYGC(Integer.parseInt(columnValueMap.get("YGC")));
			bean.setYGCT(Float.parseFloat(columnValueMap.get("YGCT")));
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
	public int compareTo(JstatGCNewBean o) {
		return id - o.id;
	}
}
