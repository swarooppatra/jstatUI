/**
 * Created on May 6, 2012
 */
package org.swaroop.jstatui.bean;

import org.swaroop.jstatui.annotations.Column;
import org.swaroop.jstatui.annotations.Table;

/**
 * This bean corresponds to jstat_host table
 * 
 * @author Swaroop Patra
 * 
 */
@Table(name = "jstat_host")
public class JstatHostBean {

	@Column(name = "id", isPrimary = true)
	private int id;
	@Column(name = "host")
	private String host;
	@Column(name = "port")
	private int port;
	@Column(name = "jvm_process_id")
	private int jvmProcessId;
	@Column(name = "jvm_start_time")
	private String jvmStartTime;

}
