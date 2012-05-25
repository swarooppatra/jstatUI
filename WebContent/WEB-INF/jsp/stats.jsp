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
			console.log("Test1");
			var graphWS = null;
			var wsURL = "ws://localhost:8080/JstatUI/websocket/graph";
			
			function connect(){
				console.log("Attemepting to conncet to WS");
				
				if(wsURL == ''){
					console.log("Invalid WS URL");
					return;
				}
				if('MozWebSocket' in window){
					console.log("moz");
					try{
					graphWS = new MozWebSocket(wsURL);
					} catch(err){
						console.log("WebSocket is not supported");
					}
					console.log(graphWS);
				}else if('WebSocket' in window){
					console.log("Non-moz");
					try{
						graphWS =  new WebSocket(wsURL);
					} catch(err){
						console.log("WebSocket is not supported");
					}
					console.log(graphWS);
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
				/*var plotData = data.split("::");
				console.log(plotData[0]);
				console.log(plotData[1]);*/
				data = data.replace("],[","\n").replace("[","").replace("]","");
				console.log(data);
				g = new Dygraph(document.getElementById("class"),data,
				    {
						labels: [ "X", "a", "b", "c", "d", "e"],
						labelsDivStyles: { border: '1px solid black' },
					    title: 'Class Graph',
					    xlabel: 'Time',
					    ylabel: 'Marks',
						strokeWidth: 2,
						highlightCircleSize: 4
					}
				);
			}
		</script>
	</body>	
</html>