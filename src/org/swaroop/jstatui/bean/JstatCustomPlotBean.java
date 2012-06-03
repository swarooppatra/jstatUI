/**
 * Created on Jun 3, 2012
 */
package org.swaroop.jstatui.bean;

import java.io.Serializable;

import org.swaroop.jstatui.annotations.Column;
import org.swaroop.jstatui.annotations.Table;

/**
 * This bean corresponds to jstat_custom_plot table
 * 
 * @author Swaroop Patra
 * 
 */
@Table(name = "jstat_custom_plot")
public class JstatCustomPlotBean implements JstatOptionBean, Serializable,
		Comparable<JstatCustomPlotBean> {

	private static final long serialVersionUID = 1L;

	@Column(name = "id", isPrimary = true)
	private int id;

	@Column(name = "plot_name")
	private String plotName;

	@Column(name = "type_and_param")
	private String typeAndParam;

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
	 * @return the plotName
	 */
	public String getPlotName() {
		return plotName;
	}

	/**
	 * @param plotName
	 *            the plotName to set
	 */
	public void setPlotName(String plotName) {
		this.plotName = plotName;
	}

	/**
	 * @return the typeAndParam
	 */
	public String getTypeAndParam() {
		return typeAndParam;
	}

	/**
	 * @param typeAndParam
	 *            the typeAndParam to set
	 */
	public void setTypeAndParam(String typeAndParam) {
		this.typeAndParam = typeAndParam;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JstatCustomPlotBean other = (JstatCustomPlotBean) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("JstatCustomPlotBean [id=");
		buffer.append(id);
		buffer.append(", plotName=");
		buffer.append(plotName);
		buffer.append(", typeAndParam=");
		buffer.append(typeAndParam);
		buffer.append("]");
		return buffer.toString();
	}

	@Override
	public int compareTo(JstatCustomPlotBean o) {
		return id - o.id;
	}

	@Override
	public JstatOptionBean parseStat(String stat) {
		throw new IllegalAccessError();
	}

	@Override
	public String toJsonString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("[");
		buffer.append(id);
		buffer.append(",");
		buffer.append(plotName);
		buffer.append(",");
		buffer.append(typeAndParam);
		buffer.append("]");
		return buffer.toString();
	}

}
