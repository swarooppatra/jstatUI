<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Custom Stats</title>
		<style type="text/css">
			.addgph{background-image:url("../images/ui-icons_228ef1_256x240.png"); background-position:-30px -127px;display:block;height:16px;width:16px;float:left;cursor:pointer;}
			.removegph{background-image:url("../images/ui-icons_228ef1_256x240.png"); background-position:-46px -127px;display:block;height:16px;width:16px;float:left;cursor:pointer;}
			.invi{display:none;}
			.vi{display:block;}
		</style>
		<script type="text/javascript" src="http://localhost:8080/JstatUI/js/dygraph-combined.js"></script>
		<script type="text/javascript">
			function showopts(){
				var d;
				var opt = document.getElementById("statsid").options[document.getElementById("statsid").selectedIndex].value;
				if(opt==='class'){document.getElementById("class").className="vi";d=opt;}
				else if(opt==='compiler'){document.getElementById("compiler").className="vi";}
				else if(opt==='gc'){document.getElementById("gc").className="vi";}
				else if(opt==='gc_capacity'){document.getElementById("gc_capacity").className="vi";}
				else if(opt==='gc_cause'){document.getElementById("gc_cause").className="vi";}
				else if(opt==='gc_new'){document.getElementById("gc_new").className="vi";}
				else if(opt==='gc_new_capacity'){document.getElementById("gc_new_capacity").className="vi";}
				else if(opt==='gc_old'){document.getElementById("gc_old").className="vi";}
				else if(opt==='gc_old_capacity'){document.getElementById("gc_old_capacity").className="vi";}
				else if(opt==='gc_perm_capacity'){document.getElementById("gc_perm_capacity").className="vi";}
				else if(opt==='gc_util'){document.getElementById("gc_util").className="vi";}
				else if(opt==='print_compilation'){document.getElementById("print_compilation").className="vi";}
			}
		</script>
	</head>
	<body>
		<h1>JVM Statistics</h1>
		<form action="custom">
			Plot Name : <input type="text" name="plotname"/>
			<fieldset class="pltopt">
				<legend>Graph Options</legend>
				Stats Type : 
				<select name="stats" onchange="showopts()" id="statsid">
					<option value="class">Class</option>
					<option value="compiler">Compiler</option>
					<option value="gc">GC</option>
					<option value="gc_capacity">GC Capacity</option>
					<option value="gc_cause">GC Cause</option>
					<option value="gc_new">GC New</option>
					<option value="gc_new_capacity">GC New Capacity</option>
					<option value="gc_old">GC Old</option>
					<option value="gc_old_capacity">GC Old Capacity</option>
					<option value="gc_perm_capacity">GC Perm Capacity</option>
					<option value="gc_util">GC Util</option>
					<option value="print_compilation">Print Compilation</option>	
				</select>
				Options :
				<select name="compiler" id="compiler" class="invi">
				    <option value="Compiled">Compiled</option>
				    <option value="Failed">Failed</option>
				    <option value="Invalid">Invalid</option>
				    <option value="Time Spent">Time Spent</option>
				    <option value="Failed Type">Failed Type</option>
				</select>
				<select name="gc_cause" id="gc_cause" class="invi">
				    <option value="S0">S0</option>
				    <option value="S1">S1</option>
				    <option value="E">E</option>
				    <option value="O">O</option>
				    <option value="P">P</option>
				    <option value="YGC">YGC</option>
				    <option value="YGCT">YGCT</option>
				    <option value="FGC">FGC</option>
				    <option value="FGCT">FGCT</option>
				    <option value="GCT">GCT</option>
				</select>
				<select name="gc_new" id="gc_new" class="invi">
				    <option value="S0C">S0C</option>
				    <option value="S1C">S1C</option>
				    <option value="S0U">S0U</option>
				    <option value="S1U">S1U</option>
				    <option value="TT">TT</option>
				    <option value="MTT">MTT</option>
				    <option value="DSS">DSS</option>
				    <option value="EC">EC</option>
				    <option value="EU">EU</option>
				    <option value="YGC">YGC</option>
				    <option value="YGCT">YGCT</option>
				</select>
				<select name="gc_old" id="gc_old" class="invi">
				    <option value="PC">PC</option>
				    <option value="PU">PU</option>
				    <option value="OC">OC</option>
				    <option value="OU">OU</option>
				    <option value="YGC">YGC</option>
				    <option value="FGC">FGC</option>
				    <option value="FGCT">FGCT</option>
				    <option value="GCT">GCT</option>
				</select>
				<select name="gc_old_capacity" id="gc_old_capacity" class="invi">
				    <option value="OGCMN">OGCMN</option>
				    <option value="OGCMX">OGCMX</option>
				    <option value="OGC">OGC</option>
				    <option value="OC">OC</option>
				    <option value="YGC">YGC</option>
				    <option value="FGC">FGC</option>
				    <option value="FGCT">FGCT</option>
				    <option value="GCT">GCT</option>
				</select>
				<select name="gc_perm_capacity" id="gc_perm_capacity" class="invi">
				    <option value="PGCMN">PGCMN</option>
				    <option value="PGCMX">PGCMX</option>
				    <option value="PGC">PGC</option>
				    <option value="PC">PC</option>
				    <option value="YGC">YGC</option>
				    <option value="FGC">FGC</option>
				    <option value="FGCT">FGCT</option>
				    <option value="GCT">GCT</option>
				</select>
				<select name="gc_util" id="gc_util" class="invi">
				    <option value="S0">S0</option>
				    <option value="S1">S1</option>
				    <option value="E">E</option>
				    <option value="O">O</option>
				    <option value="P">P</option>
				    <option value="YGC">YGC</option>
				    <option value="YGCT">YGCT</option>
				    <option value="FGC">FGC</option>
				    <option value="FGCT">FGCT</option>
				    <option value="GCT">GCT</option>
				</select>
				<select name="print_compilation" id="print_compilation" class="invi">
				    <option value="Compiled">Compiled</option>
				    <option value="Size">Size</option>
				    <option value="Type">Type</option>
				</select>
				<select name="gc_new_capacity" id="gc_new_capacity" class="invi">
				    <option value="NGCMN">NGCMN</option>
				    <option value="NGCMX">NGCMX</option>
				    <option value="NGC">NGC</option>
				    <option value="S0CMX">S0CMX</option>
				    <option value="S0C">S0C</option>
				    <option value="S1CMX">S1CMX</option>
				    <option value="S1C">S1C</option>
				    <option value="ECMX">ECMX</option>
				    <option value="EC">EC</option>
				    <option value="YGC">YGC</option>
				    <option value="FGC">FGC</option>
				</select>
				<select name="class" id="class" class="invi">
				    <option value="Loaded Classes">Loaded Classes</option>
				    <option value="Loaded Bytes">Loaded Bytes</option>
				    <option value="Unloaded Classes">Unloaded Classes</option>
				    <option value="Unloaded Bytes">Unloaded Bytes</option>
				    <option value="Time Consumed">Time Consumed</option>
				</select>
				<select name="gc" id="gc" class="invi">
				    <option value="S0C">S0C</option>
				    <option value="S1C">S1C</option>
				    <option value="S0U">S0U</option>
				    <option value="S1U">S1U</option>
				    <option value="EC">EC</option>
				    <option value="EU">EU</option>
				    <option value="OC">OC</option>
				    <option value="OU">OU</option>
				    <option value="PC">PC</option>
				    <option value="PU">PU</option>
				    <option value="YGC">YGC</option>
				    <option value="YGCT">YGCT</option>
				    <option value="FGC">FGC</option>
				    <option value="FGCT">FGCT</option>
				    <option value="GCT">GCT</option>
				</select>
				<select name="gc_capacity" id="gc_capacity" class="invi">
				    <option value="NGCMN">NGCMN</option>
				    <option value="NGCMX">NGCMX</option>
				    <option value="NGC">NGC</option>
				    <option value="S0C">S0C</option>
				    <option value="S1C">S1C</option>
				    <option value="EC">EC</option>
				    <option value="OGCMN">OGCMN</option>
				    <option value="OGCMX">OGCMX</option>
				    <option value="OGC">OGC</option>
				    <option value="OC">OC</option>
				    <option value="PGCMN">PGCMN</option>
				    <option value="PGCMX">PGCMX</option>
				    <option value="PGC">PGC</option>
				    <option value="PC">PC</option>
				    <option value="YGC">YGC</option>
				    <option value="FGC">FGC</option>
				</select>
				<div id="addOption"><span class="addopt"></span>&nbsp;&nbsp;Add another command</div>
				<div id='removeopt'></div>
			</fieldset>
			<div id="addGraph"><span class="addgph"></span>&nbsp;&nbsp;Add a Graph</div>
			<div id='removegph'></div>
		</form>
	</body>
</html>