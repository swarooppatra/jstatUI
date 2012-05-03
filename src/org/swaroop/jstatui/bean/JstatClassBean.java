/**
 * Created on May 3, 2012
 */
package org.swaroop.jstatui.bean;

import java.io.Serializable;

import org.swaroop.jstatui.annotations.Column;
import org.swaroop.jstatui.annotations.Table;

/**
 * @author Swaroop Patra
 * 
 */
@Table(name = "jstat_class")
public class JstatClassBean implements Serializable, Comparable<JstatClassBean> {

	private static final long serialVersionUID = 1L;

	@Column(name = "id", isPrimary = true)
	private int id;

	@Column(name = "host_id")
	private int hostID;

	@Column(name = "time_elasped")
	private long timeElasped;

	@Column(name = "loaded_classes")
	private long loadedClasses;

	@Column(name = "loaded_bytes")
	private long loadedBytes;

	@Column(name = "unloaded_classes")
	private long unloadedClasses;

	@Column(name = "unloaded_bytes")
	private long unloadedBytes;

	@Column(name = "time_consumed")
	private long timeConsumed;

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
	public long getTimeElasped() {
		return timeElasped;
	}

	/**
	 * @param timeElasped
	 *            the timeElasped to set
	 */
	public void setTimeElasped(long timeElasped) {
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
	public long getLoadedBytes() {
		return loadedBytes;
	}

	/**
	 * @param loadedBytes
	 *            the loadedBytes to set
	 */
	public void setLoadedBytes(long loadedBytes) {
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
	public long getUnloadedBytes() {
		return unloadedBytes;
	}

	/**
	 * @param unloadedBytes
	 *            the unloadedBytes to set
	 */
	public void setUnloadedBytes(long unloadedBytes) {
		this.unloadedBytes = unloadedBytes;
	}

	/**
	 * @return the timeConsumed
	 */
	public long getTimeConsumed() {
		return timeConsumed;
	}

	/**
	 * @param timeConsumed
	 *            the timeConsumed to set
	 */
	public void setTimeConsumed(long timeConsumed) {
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

}