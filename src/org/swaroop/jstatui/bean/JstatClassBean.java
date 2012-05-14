/**
 * Created on May 3, 2012
 */
package org.swaroop.jstatui.bean;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.swaroop.jstatui.annotations.Column;
import org.swaroop.jstatui.annotations.Table;
import org.swaroop.jstatui.error.JstatUIError;

/**
 * This bean corresponds to jstat_class table and -class o/p option of jstat
 * 
 * @author Swaroop Patra
 * 
 */
@Table(name = "jstat_class")
public class JstatClassBean implements JstatOptionBean, Serializable,
		Comparable<JstatClassBean> {

	private static final long serialVersionUID = 1L;

	private static final String STAT_COLUMN_SCHEMA = "timeElasped::loadedClasses::loadedBytes::unloadedClasses::unloadedBytes::timeConsumed";

	@Column(name = "id", isPrimary = true)
	private int id;

	@Column(name = "host_id")
	private int hostID;

	@Column(name = "time_elasped")
	private float timeElasped;

	@Column(name = "loaded_classes")
	private long loadedClasses;

	@Column(name = "loaded_bytes")
	private float loadedBytes;

	@Column(name = "unloaded_classes")
	private long unloadedClasses;

	@Column(name = "unloaded_bytes")
	private float unloadedBytes;

	@Column(name = "time_consumed")
	private float timeConsumed;

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
	 * @return the loadedClasses
	 */
	public long getLoadedClasses() {
		return loadedClasses;
	}

	/**
	 * @param loadedClasses
	 *            the loadedClasses to set
	 */
	public void setLoadedClasses(long loadedClasses) {
		this.loadedClasses = loadedClasses;
	}

	/**
	 * @return the loadedBytes
	 */
	public float getLoadedBytes() {
		return loadedBytes;
	}

	/**
	 * @param loadedBytes
	 *            the loadedBytes to set
	 */
	public void setLoadedBytes(float loadedBytes) {
		this.loadedBytes = loadedBytes;
	}

	/**
	 * @return the unloadedClasses
	 */
	public long getUnloadedClasses() {
		return unloadedClasses;
	}

	/**
	 * @param unloadedClasses
	 *            the unloadedClasses to set
	 */
	public void setUnloadedClasses(long unloadedClasses) {
		this.unloadedClasses = unloadedClasses;
	}

	/**
	 * @return the unloadedBytes
	 */
	public float getUnloadedBytes() {
		return unloadedBytes;
	}

	/**
	 * @param unloadedBytes
	 *            the unloadedBytes to set
	 */
	public void setUnloadedBytes(float unloadedBytes) {
		this.unloadedBytes = unloadedBytes;
	}

	/**
	 * @return the timeConsumed
	 */
	public float getTimeConsumed() {
		return timeConsumed;
	}

	/**
	 * @param timeConsumed
	 *            the timeConsumed to set
	 */
	public void setTimeConsumed(float timeConsumed) {
		this.timeConsumed = timeConsumed;
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
		JstatClassBean other = (JstatClassBean) obj;
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
		builder.append("JstatClassBean [id=");
		builder.append(id);
		builder.append(", hostID=");
		builder.append(hostID);
		builder.append(", timeElasped=");
		builder.append(timeElasped);
		builder.append(", loadedClasses=");
		builder.append(loadedClasses);
		builder.append(", loadedBytes=");
		builder.append(loadedBytes);
		builder.append(", unloadedClasses=");
		builder.append(unloadedClasses);
		builder.append(", unloadedBytes=");
		builder.append(unloadedBytes);
		builder.append(", timeConsumed=");
		builder.append(timeConsumed);
		builder.append("]");
		return builder.toString();
	}

	public int compareTo(JstatClassBean o) {
		return id - o.id;
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
		JstatClassBean bean = new JstatClassBean();
		String[] stats = stat.trim().split("[\\s\\t]+");
		String[] columns = STAT_COLUMN_SCHEMA.split("::");
		Map<String, String> columnValueMap = new HashMap<String, String>();
		if (stats.length == columns.length) {
			for (int i = 0; i < columns.length; i++) {
				columnValueMap.put(columns[i], stats[i]);
			}
			bean.setTimeElasped(Float.parseFloat(columnValueMap
					.get("timeElasped")));
			bean.setLoadedClasses(Long.parseLong(columnValueMap
					.get("loadedClasses")));
			bean.setLoadedBytes(Float.parseFloat(columnValueMap
					.get("loadedBytes")));
			bean.setUnloadedClasses(Long.parseLong(columnValueMap
					.get("unloadedClasses")));
			bean.setUnloadedBytes(Float.parseFloat(columnValueMap
					.get("unloadedBytes")));
			bean.setTimeConsumed(Float.parseFloat(columnValueMap
					.get("timeConsumed")));
		} else {
			log.error("Error in parsing stats");
			JstatUIError.addErrors(608, "Error in parsing stats");
		}
		return bean;
	}

}