<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
		<title>JVM statistics - JStatUI</title>
		<style type="text/css">
			.graph{width:900px; height:500px;border-bottom:20px;}
		</style>
		<script type="text/javascript" src="http://localhost:8080/JstatUI/js/dygraph-combined.js"></script>
		
	</head>
	<body>
		<h1>JVM statistics</h1>
		<form name="t" action="#">
			<button  type="button" onclick="connect()">Connect</button>
			<button  type="button" onclick="sendData()">Send Data</button>
			<button  type="button" onclick="disconnect()">Disconnect</button>
			<button  type="button" onclick="drawGraph()">Draw Graph</button>
		</form>
		<div id="class" class="graph"></div>
		<div id="compiler" class="graph"></div>
		<div id="gc" class="graph"></div>
		<div id="gc_capacity" class="graph"></div>
		<div id="gc_cause" class="graph"></div>
		<div id="gc_new" class="graph"></div>
		<div id="gc_new_capacity" class="graph"></div>
		<div id="gc_old" class="graph"></div>
		<div id="gc_old_capacity" class="graph"></div>
		<div id="gc_perm_capacity" class="graph"></div>
		<div id="gc_util" class="graph"></div>
		<div id="print_compilation" class="graph"></div>
		<script type="text/javascript">
			var graphWS = null;
			var wsURL = "ws://localhost:8080/JstatUI/websocket/graph";
			
			function connect(){
				
				if(wsURL == ''){
					return;
				}
				if('MozWebSocket' in window){
					try{
					graphWS = new MozWebSocket(wsURL);
					} catch(err){
						console.log("WebSocket is not supported");
					}
				}else if('WebSocket' in window){
					try{
						graphWS =  new WebSocket(wsURL);
					} catch(err){
						console.log("WebSocket is not supported");
					}
				}else{
					console.log("WebSocket is not supported");
					alert("WebSocket is not supported");
					return;
				}
				graphWS.onopen = function(){
					console.log("Ready state :O: "+graphWS.readyState);
					console.log("Opening...");
				}
				graphWS.onmessage = function(event){
					console.log("Ready state :M: "+graphWS.readyState);
					graphWS.send("1");
					drawGraph(event.data);
				}
				graphWS.onclose = function () {
					console.log("Ready state :C: "+graphWS.readyState);
					console.log("closing");
				}
				graphWS.onerror = function(err){					
					console.log("Error :E: "+err);
					console.log("Ready state :E: "+graphWS.readyState);
				};	
				
			}
			
			function disconnect() {
				if (graphWS != null) {
					graphWS.send("disconnect");
					console.log('Disconnecting');
					graphWS.close();
					graphWS = null;
				} else {
					alert('WebSocket connection not established, please connect.');
				}
			}
			function sendData(){
				if (graphWS != null) {
					try{
						console.log('Sent: R u there???');
						graphWS.send("R u there???");
					} catch(err){
						console.log(err.message);
					}
				} else {
					alert('WebSocket connection not established, please connect.');
				}
			}
			function drawGraph(data){
				var la = "";
				var plotData = data.split("::");
				var pt = plotData[0];
				var plot = plotData[1];
				if(pt==='class'){
					la = new Array("Time Elasped", "Loaded Classes", "Loaded Bytes", "Unloaded Classes", "Unloaded Bytes", "Time Consumed");
				} else if(pt==='compiler'){
					la = new Array("Time Elasped", "Compiled", "Failed", "Invalid", "Time Spent", "Failed Type");
				} else if(pt==='gc'){
					la = new Array("Time Elasped", "S0C", "S1C", "S0U", "S1U", "EC", "EU", "OC", "OU", "PC", "PU", "YGC", "YGCT", "FGC", "FGCT", "GCT");
				} else if(pt==='gc_capacity'){
					la = new Array("Time Elasped", "NGCMN", "NGCMX", "NGC", "S0C", "S1C", "EC", "OGCMN", "OGCMX", "OGC", "OC", "PGCMN", "PGCMX", "PGC", "PC", "YGC", "FGC");
				} else if(pt==='gc_cause'){
					la = new Array("Time Elasped", "S0", "S1", "E", "O", "P", "YGC", "YGCT", "FGC", "FGCT", "GCT");
				} else if(pt==='gc_new'){
					la = new Array("Time Elasped", "S0C", "S1C", "S0U", "S1U", "TT", "MTT", "DSS", "EC", "EU", "YGC", "YGCT");
				} else if(pt==='gc_new_capacity'){
					la = new Array("Time Elasped", "NGCMN", "NGCMX", "NGC", "S0CMX", "S0C", "S1CMX", "S1C", "ECMX", "EC", "YGC", "FGC");
				} else if(pt==='gc_old'){
					la = new Array("Time Elasped", "PC", "PU", "OC", "OU", "YGC", "FGC", "FGCT", "GCT");
				} else if(pt==='gc_old_capacity'){
					la = new Array("Time Elasped", "OGCMN", "OGCMX", "OGC", "OC", "YGC", "FGC", "FGCT", "GCT");
				} else if(pt==='gc_perm_capacity'){
					la = new Array("Time Elasped", "PGCMN", "PGCMX", "PGC", "PC", "YGC", "FGC", "FGCT", "GCT");
				} else if(pt==='gc_util'){
					la = new Array("Time Elasped", "S0", "S1", "E", "O", "P", "YGC", "YGCT", "FGC", "FGCT", "GCT");
				} else if(pt==='print_compilation'){
					la = new Array("Time Elasped", "Compiled", "Size", "Type");
				}
				plot = plot.replace(/\],\[/g,"\n");
				plot = plot.replace(/\[/g,"");
				plot = plot.replace(/\]/g,"");
				new Dygraph(document.getElementById(plotData[0]),plot,
				    {
						labels: la,
						labelsDivStyles: { border: '1px solid black' },
					    title: plotData[0]+' Graph',
					    xlabel: 'Time',
					    ylabel: 'Marks',
						strokeWidth: 2,
						highlightCircleSize: 4
					}
				);
				plot = null;
			}
			
		</script>
	</body>	
</html>