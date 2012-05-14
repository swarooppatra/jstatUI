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
 * This bean corresponds to jstat_gc table and -gc option of jstat
 * 
 * @author Swaroop Patra
 * 
 */
@Table(name="jstat_gc")
public class JstatGCBean implements Serializable, Comparable<JstatGCBean>,
		JstatOptionBean {

	private static final long serialVersionUID = 1L;

	private static final String STAT_COLUMN_SCHEMA = "timeElasped::S0C::S1C::S0U::S1U::EC::EU::OC::OU::PC::PU::YGC::YGCT::FGC::FGCT::GCT";

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

	@Column(name = "EC")
	private float EC;

	@Column(name = "EU")
	private float EU;

	@Column(name = "OC")
	private float OC;

	@Column(name = "OU")
	private float OU;

	@Column(name = "PC")
	private float PC;

	@Column(name = "PU")
	private float PU;

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
	 * @return the oC
	 */
	public float getOC() {
		return OC;
	}

	/**
	 * @param oC
	 *            the oC to set
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
	 *            the oU to set
	 */
	public void setOU(float oU) {
		OU = oU;
	}

	/**
	 * @return the pC
	 */
	public float getPC() {
		return PC;
	}

	/**
	 * @param pC
	 *            the pC to set
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
	 *            the pU to set
	 */
	public void setPU(float pU) {
		PU = pU;
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

	/**
	 * @return the fGC
	 */
	public int getFGC() {
		return FGC;
	}

	/**
	 * @param fGC
	 *            the fGC to set
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
	 *            the fGCT to set
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
	 *            the gCT to set
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
		JstatGCBean other = (JstatGCBean) obj;
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
		builder.append("JstatGCBean [id=");
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
		builder.append(", EC=");
		builder.append(EC);
		builder.append(", EU=");
		builder.append(EU);
		builder.append(", OC=");
		builder.append(OC);
		builder.append(", OU=");
		builder.append(OU);
		builder.append(", PC=");
		builder.append(PC);
		builder.append(", PU=");
		builder.append(PU);
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

	@Override
	public JstatOptionBean parseStat(String stat) {
		log.info("Parsing collected stats");
		if (stat == null || "".equals(stat) || "null".equals(stat)) {
			log.error("Stat is not available. Check if the process is running");
			JstatUIError.addErrors(600, "Invalid value for stat is supplied");
			// TODO : need to change to a bean object
			return null;
		}
		JstatGCBean bean = new JstatGCBean();
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
			bean.setS1C(Float.parseFloat(columnValueMap.get("S1C")));
			bean.setS0U(Float.parseFloat(columnValueMap.get("S0U")));
			bean.setS1U(Float.parseFloat(columnValueMap.get("S1U")));
			bean.setEC(Float.parseFloat(columnValueMap.get("EC")));
			bean.setEU(Float.parseFloat(columnValueMap.get("EU")));
			bean.setOC(Float.parseFloat(columnValueMap.get("OC")));
			bean.setOU(Float.parseFloat(columnValueMap.get("OU")));
			bean.setPC(Float.parseFloat(columnValueMap.get("PC")));
			bean.setPU(Float.parseFloat(columnValueMap.get("PU")));
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

	@Override
	public int compareTo(JstatGCBean o) {
		return id - o.id;
	}

}
