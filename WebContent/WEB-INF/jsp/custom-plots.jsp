<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Custom Stats</title>
		<style type="text/css">
			@CHARSET "UTF-8";
			/* Browser Reset */
			body, div, dl, dt, dd, ul, ol, li, h1, h2, h3, h4, h5, h6, pre, form, fieldset, input, textarea, p, blockquote, th, td, select {margin:0pt; padding:0pt;}
			a {color:#027FB5;text-decoration:none;}
			a:hover {text-decoration:underline;}
			ul {list-style-type:none;padding:0;margin:0;}
			h1,h2,h3,h4,h5,h6{font-size:100%;font-weight:normal;}

			body{margin:.5em 2.5em;font:14px verdana,arial,helvetica,sans-serif;}
			h1{font-size:2em;font-weight:bold;margin-bottom:1em;}
			.addgph, .addopt{background-image:url("./images/add.jpg");display:block;height:16px;width:16px;float:left;cursor:pointer;}
			.removegph, .removeopt{background-image:url("./images/remove.jpg");display:block;height:16px;width:16px;float:left;cursor:pointer;}
			.invi{display:none;}
			.vi{display:inline;}
			#pltopt{margin:0.9em;padding:0.9em;width:55%;padding:0.9em important!}
		</style>
		<script type="text/javascript" src="http://localhost:8080/JstatUI/js/dygraph-combined.js"></script>
		<script type="text/javascript">
			var d;
			function showopts(){
				if(d){
					document.getElementById(""+d).className="invi";
				}else{
					document.getElementById("class").className="invi";
				}
				var opt = document.getElementById("statsid").options[document.getElementById("statsid").selectedIndex].value;
				if(opt==='class'){document.getElementById("class").className="vi";d='class';}
				else if(opt==='compiler'){document.getElementById("compiler").className="vi";d='compiler';}
				else if(opt==='gc'){document.getElementById("gc").className="vi";d='gc';}
				else if(opt==='gc_capacity'){document.getElementById("gc_capacity").className="vi";d='gc_capacity';}
				else if(opt==='gc_cause'){document.getElementById("gc_cause").className="vi";d='gc_cause';}
				else if(opt==='gc_new'){document.getElementById("gc_new").className="vi";d='';d='gc_new';}
				else if(opt==='gc_new_capacity'){document.getElementById("gc_new_capacity").className="vi";d='gc_new_capacity';}
				else if(opt==='gc_old'){document.getElementById("gc_old").className="vi";d='';d='gc_old';}
				else if(opt==='gc_old_capacity'){document.getElementById("gc_old_capacity").className="vi";d='gc_old_capacity';}
				else if(opt==='gc_perm_capacity'){document.getElementById("gc_perm_capacity").className="vi";d='gc_perm_capacity';}
				else if(opt==='gc_util'){document.getElementById("gc_util").className="vi";d='gc_util';}
				else if(opt==='print_compilation'){document.getElementById("print_compilation").className="vi";d='print_compilation';}
			}
			function sopt(){
				document.getElementById("pltopt").className="vi";
			}
			function ropt(){
				document.getElementById("pltopt").className="invi";
			}
		</script>
	</head>
	<body>
		<h1>JVM Statistics</h1>
		<form action="custom">
			Plot Name : <input type="text" name="plotname"/>
			<div id="addGraph"><span class="addgph" onclick="sopt()"></span>&nbsp;&nbsp;Add a Graph</div>
			<div id='removegph'></div>
			<fieldset class="invi" id="pltopt">
				<legend><span class="removegph" onclick="ropt()"></span>&nbsp;&nbsp;Graph Options</legend>
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
				<select name="class" id="class" class="vi">
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
		</form>
	</body>
</html>