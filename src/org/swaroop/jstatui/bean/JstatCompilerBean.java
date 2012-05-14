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
 * This bean class corresponds to jstat_compiler table and -compiler o/p option
 * of jstat
 * 
 * @author Swaroop Patra
 * 
 */
@Table(name = "jstat_compiler")
public class JstatCompilerBean implements Serializable,
		Comparable<JstatCompilerBean>, JstatOptionBean {

	private static final long serialVersionUID = 1L;

	private static final String STAT_COLUMN_SCHEMA = "timeElasped::Compiled::Faile::Invalid::Time::FailedType::FailedMethod";

	@Column(name = "id", isPrimary = true)
	private int id;

	@Column(name = "host_id")
	private int hostID;

	@Column(name = "time_elasped")
	private float timeElasped;

	@Column(name = "compiled")
	private int compiled;

	@Column(name = "failed")
	private int failed;

	@Column(name = "invalid")
	private int invalid;

	@Column(name = "time_spent")
	private float timeSpent;

	@Column(name = "failed_type")
	private int failedType;

	@Column(name = "failed_method")
	private String failedMethod;

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
	 * @return the compiled
	 */
	public int getCompiled() {
		return compiled;
	}

	/**
	 * @param compiled
	 *            the compiled to set
	 */
	public void setCompiled(int compiled) {
		this.compiled = compiled;
	}

	/**
	 * @return the failed
	 */
	public int getFailed() {
		return failed;
	}

	/**
	 * @param failed
	 *            the failed to set
	 */
	public void setFailed(int failed) {
		this.failed = failed;
	}

	/**
	 * @return the invalid
	 */
	public int getInvalid() {
		return invalid;
	}

	/**
	 * @param invalid
	 *            the invalid to set
	 */
	public void setInvalid(int invalid) {
		this.invalid = invalid;
	}

	/**
	 * @return the timeSpent
	 */
	public float getTimeSpent() {
		return timeSpent;
	}

	/**
	 * @param timeSpent
	 *            the timeSpent to set
	 */
	public void setTimeSpent(float timeSpent) {
		this.timeSpent = timeSpent;
	}

	/**
	 * @return the failedTyep
	 */
	public int getFailedType() {
		return failedType;
	}

	/**
	 * @param failedTyep
	 *            the failedTyep to set
	 */
	public void setFailedType(int failedType) {
		this.failedType = failedType;
	}

	/**
	 * @return the failedMethod
	 */
	public String getFailedMethod() {
		return failedMethod;
	}

	/**
	 * @param failedMethod
	 *            the failedMethod to set
	 */
	public void setFailedMethod(String failedMethod) {
		this.failedMethod = failedMethod;
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
		JstatCompilerBean other = (JstatCompilerBean) obj;
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
		builder.append("JstatCompilerBean [id=");
		builder.append(id);
		builder.append(", hostID=");
		builder.append(hostID);
		builder.append(", timeElasped=");
		builder.append(timeElasped);
		builder.append(", compiled=");
		builder.append(compiled);
		builder.append(", failed=");
		builder.append(failed);
		builder.append(", invalid=");
		builder.append(invalid);
		builder.append(", timeSpent=");
		builder.append(timeSpent);
		builder.append(", failedType=");
		builder.append(failedType);
		builder.append(", failedMethod=");
		builder.append(failedMethod);
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
		JstatCompilerBean bean = new JstatCompilerBean();
		String[] stats = stat.trim().split("[\\s\\t]+");
		String[] columns = STAT_COLUMN_SCHEMA.split("::");
		Map<String, String> columnValueMap = new HashMap<String, String>();
		if (stats.length == columns.length) {
			for (int i = 0; i < columns.length; i++) {
				columnValueMap.put(columns[i], stats[i]);
			}
			bean.setTimeElasped(Float.parseFloat(columnValueMap
					.get("timeElasped")));
			bean.setCompiled(Integer.parseInt(columnValueMap.get("Compiled")));
			bean.setFailed(Integer.parseInt(columnValueMap.get("Failed")));
			bean.setInvalid(Integer.parseInt(columnValueMap.get("Invalid")));
			bean.setTimeSpent(Float.parseFloat(columnValueMap.get("Time")));
			bean.setFailedType(Integer.parseInt(columnValueMap
					.get("FailedType")));
			bean.setFailedMethod(columnValueMap.get("FailedMethod"));
		} else {
			log.error("Error in parsing stats");
			JstatUIError.addErrors(608, "Error in parsing stats");
		}
		return bean;
	}

	@Override
	public int compareTo(JstatCompilerBean o) {
		return id - o.id;
	}

}
