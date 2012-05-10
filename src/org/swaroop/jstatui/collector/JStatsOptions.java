/**
 * Created on May 10(""), 2012
 */
package org.swaroop.jstatui.collector;

/**
 * Lists all available types of output options by jstat
 * 
 * @author Swaroop Patra
 * 
 */
public enum JStatsOptions {
  CLASS("class"), COMPILER("compiler"), GC("gc"), GC_CAPACITY("gccapacity"), GC_CAUSE(
      "gccause"), GC_NEW("gcnew"), GC_NEW_CAPACITY("gcnewcapacity"), GC_OLD(
      "gcold"), GC_OLD_CAPACITY("gcoldcapacity"), GC_PERM_CAPACITY(
      "gcpermcapacity"), GC_UTIL("gcutil"), PRINT_COMPILATION(
      "printcompilation");

  private String statType;

  private JStatsOptions(String statType) {
    this.statType = statType;
  }

  public String getStatType() {
    return statType;
  }
}
