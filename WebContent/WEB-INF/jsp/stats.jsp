<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
		<title>JVM statistics - JStatUI</title>
		<script type="text/javascript" src="http://localhost:8080/JstatUI/js/dygraph-combined.js"></script>
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
					graphWS = new MozWebSocket(wsURL);
				}else if('WebSocket' in window){
					console.log("Non-moz");
					graphWS =  new WebSocket(wsURL);
				}else{
					console.log("WebSocket is not supported");
					alert("WebSocket is not supported");
					return;
				}				
				graphWS.open = function(){
					console.log("Opening...");
					graphWS.send("R u there???");
				}
				graphWS.onmessage = function(event){
					console.log("Message : "+event.data);
					document.getElementById("test").innnerHTML = event.data; 
				}
				graphWS.onclose = function () {
					console.log("closing");
				};				
			}
			function sendData(){
				connect();
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
	</script>
	</head>
	<body>
		<h1>JVM statistics</h1>				
		<p id="test"></p>
		<button name="Start" title="Start" onclick="connect()"></button>
	</body>
	
</html>