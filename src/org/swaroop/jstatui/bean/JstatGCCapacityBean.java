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
 * This bean corresponds to jstat_gccapacity table and -gccapacity option of
 * jstat
 * 
 * @author Swaroop Patra
 * 
 */
@Table(name = "jstat_gccapacity")
public class JstatGCCapacityBean implements Serializable,
		Comparable<JstatGCCapacityBean>, JstatOptionBean {

	private static final long serialVersionUID = 1L;

	private static final String STAT_COLUMN_SCHEMA = "timeElasped::NGCMN::NGCMX::NGC::S0C::S1C::EC::OGCMN::OGCMX::OGC::OC::PGCMN::PGCMX::PGC::PC::YGC::FGC";

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

	@Column(name = "S0C")
	private float S0C;

	@Column(name = "S1C")
	private float S1C;

	@Column(name = "EC")
	private float EC;

	@Column(name = "OGCMN")
	private float OGCMN;

	@Column(name = "OGCMX")
	private float OGCMX;

	@Column(name = "OGC")
	private float OGC;

	@Column(name = "OC")
	private float OC;

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
	 * @return the nGCMN
	 */
	public float getNGCMN() {
		return NGCMN;
	}

	/**
	 * @param nGCMN
	 *            the nGCMN to set
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
	 *            the nGCMX to set
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
	 *            the nGC to set
	 */
	public void setNGC(float nGC) {
		NGC = nGC;
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
	 * @return the oGCMN
	 */
	public float getOGCMN() {
		return OGCMN;
	}

	/**
	 * @param oGCMN
	 *            the oGCMN to set
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
	 *            the oGCMX to set
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
	 *            the oGC to set
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
	 *            the oC to set
	 */
	public void setOC(float oC) {
		OC = oC;
	}

	/**
	 * @return the pGCMN
	 */
	public float getPGCMN() {
		return PGCMN;
	}

	/**
	 * @param pGCMN
	 *            the pGCMN to set
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
	 *            the pGCMX to set
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
	 *            the pGC to set
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
	 *            the pC to set
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
	 *            the yGC to set
	 */
	public void setYGC(int yGC) {
		YGC = yGC;
	}

	/**
	 * @return the FGC
	 */
	public int getFGC() {
		return FGC;
	}

	/**
	 * @param fGc
	 *            the fG to set
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
		JstatGCCapacityBean other = (JstatGCCapacityBean) obj;
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
		builder.append("JstatGCCapacityBean [id=");
		builder.append(id);
		builder.append(", hostID=");
		builder.append(hostID);
		builder.append(", timeElasped=");
		builder.append(timeElasped);
		builder.append(", NGCMN=");
		builder.append(NGCMN);
		builder.append(", NGCMX=");
		builder.append(NGCMX);
		builder.append(", NGC=");
		builder.append(NGC);
		builder.append(", S0C=");
		builder.append(S0C);
		builder.append(", S1C=");
		builder.append(S1C);
		builder.append(", EC=");
		builder.append(EC);
		builder.append(", OGCMN=");
		builder.append(OGCMN);
		builder.append(", OGCMX=");
		builder.append(OGCMX);
		builder.append(", OGC=");
		builder.append(OGC);
		builder.append(", OC=");
		builder.append(OC);
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
		builder.append(", FG=");
		builder.append(FGC);
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
		JstatGCCapacityBean bean = new JstatGCCapacityBean();
		String[] stats = stat.trim().split("[\\s\\t]+");
		String[] columns = STAT_COLUMN_SCHEMA.split("::");
		Map<String, String> columnValueMap = new HashMap<String, String>();
		if (stats.length == columns.length) {
			for (int i = 0; i < columns.length; i++) {
				columnValueMap.put(columns[i], stats[i]);
			}
			bean.setTimeElasped(Float.parseFloat(columnValueMap
					.get("timeElasped")));
			bean.setNGCMN(Float.parseFloat(columnValueMap.get("NGCMN")));
			bean.setNGCMX(Float.parseFloat(columnValueMap.get("NGCMX")));
			bean.setNGC(Float.parseFloat(columnValueMap.get("NGC")));
			bean.setS0C(Float.parseFloat(columnValueMap.get("S0C")));
			bean.setS1C(Float.parseFloat(columnValueMap.get("S1C")));
			bean.setEC(Float.parseFloat(columnValueMap.get("EC")));
			bean.setOGCMN(Float.parseFloat(columnValueMap.get("OGCMN")));
			bean.setOGCMX(Float.parseFloat(columnValueMap.get("OGCMX")));
			bean.setOGC(Float.parseFloat(columnValueMap.get("OGC")));
			bean.setOC(Float.parseFloat(columnValueMap.get("OC")));
			bean.setPGCMN(Float.parseFloat(columnValueMap.get("PGCMN")));
			bean.setPGCMX(Float.parseFloat(columnValueMap.get("PGCMX")));
			bean.setPGC(Float.parseFloat(columnValueMap.get("PGC")));
			bean.setPC(Float.parseFloat(columnValueMap.get("PC")));
			bean.setYGC(Integer.parseInt(columnValueMap.get("YGC")));
			bean.setFGC(Integer.parseInt(columnValueMap.get("FGC")));
		} else {
			log.error("Error in parsing stats");
			JstatUIError.addErrors(608, "Error in parsing stats");
		}
		return bean;
	}

	@Override
	public int compareTo(JstatGCCapacityBean o) {
		return id - o.id;
	}

}
