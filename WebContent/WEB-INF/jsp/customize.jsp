<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
		<title>Customize Plotting</title>
		<style type="text/css">
			@CHARSET "UTF-8";
			/* Browser Reset */
			body, div, dl, dt, dd, ul, ol, li, h1, h2, h3, h4, h5, h6, pre, form, fieldset, input, textarea, p, blockquote, th, td, select {margin:0pt; padding:0pt}
			a {color:#027FB5;text-decoration:none}
			a:hover {text-decoration:underline}
			ul {list-style-type:none;padding:0;margin:0}
			h1,h2,h3,h4,h5,h6{font-size:100%;font-weight:normal}

			body{margin:.5em 2.5em;font:14px verdana,arial,helvetica,sans-serif}
			h1{font-size:2em;font-weight:bold;margin-bottom:1em}
			#custfrm{border-style:solid;height:100%;margin-left:17em;padding:1em;width:55%;border-radius:15px}
			.gphnm{background-color:orange;padding:0.5em}
			input[name="plotname"]{color:gray;padding:0.25em}
			.gphtbl{border-style:dotted;border-width:0.1em;margin:1em 0 1em 11em;width:55%}
			.gphtbl tr{height:1.5em}
			.gphtbl tr:nth-child(even){background:#CCC}
			.gphtbl tr:nth-child(odd){background:#C1D2E7}
		</style>
		<script type="text/javascript" src="./js/dygraph-combined.js"></script>
		<script type="text/javascript" src="./js/jquery-1.7.2.min.js"></script>
		<script type="text/javascript">
		
		</script>
	</head>
	<body>
		<h1>Customize your plots</h1>
		<form id="custfrm" action="#" method="get">
			<p class="gphnm"><input type="text" name="plotname" value="Graph Name"/></p>
			<table id="g1" class="gphtbl">
				<tbody>
					<tr><td id="g110">g</td><td id="g111">g</td></tr>
					<tr><td id="g120">g</td><td id="g121">g</td></tr>
					<tr><td id="g130">g</td><td id="g131">g</td></tr>
				</tbody>
			</table>
			<p class="gphnm"><input type="text" name="plotname" value="Graph Name"/></p>
			<table id="g2" class="gphtbl">
				<tbody>
					<tr><td id="g210">g</td><td id="g211">g</td></tr>
					<tr><td id="g220">g</td><td id="g221">g</td></tr>
					<tr><td id="g230">g</td><td id="g231">g</td></tr>
				</tbody>
			</table>
			<p class="gphnm"><input type="text" name="plotname" value="Graph Name"/></p>
			<table id="g3" class="gphtbl">
				<tbody>
					<tr><td id="g310">g</td><td id="g311">g</td></tr>
					<tr><td id="g320">g</td><td id="g321">g</td></tr>
					<tr><td id="g330">g</td><td id="g331">g</td></tr>
				</tbody>
			</table>
		</form>
	</body>
</html>