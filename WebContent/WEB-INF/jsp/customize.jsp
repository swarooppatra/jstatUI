<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
		<title>Customize Plotting</title>
		<link rel="stylesheet" type="text/css" href="./css/jstatui.css"/>
		<script type="text/javascript" src="./js/dygraph-combined.js"></script>
		<script type="text/javascript" src="./js/jquery-1.7.2.min.js"></script>
		<script type="text/javascript">
			var d;
			var gcnt = 3;
			var gos = '<p class="gphnm"><input type="text" name="plotnamegno" value="Graph Name"/></p><table class="gphtbl"><tbody><tr><td></td><td></td><td class="invi"></td><td class="invi"></td><td class="invi"></td><td class="clr"></td></tr><tr><td></td><td></td><td class="invi"></td><td class="invi"></td><td class="invi"></td><td class="clr"></td></tr><tr><td></td><td></td><td class="invi"></td><td class="invi"></td><td class="invi"></td><td class="clr"></td></tr></tbody></table>';
			var stse = '<select name="stats" class="selst"><option value="-">--select--</option><option value="class">Class</option><option value="compiler">Compiler</option><option value="gc">GC</option><option value="gc_capacity">GC Capacity</option><option value="gc_cause">GC Cause</option><option value="gc_new">GC New</option><option value="gc_new_capacity">GC New Capacity</option><option value="gc_old">GC Old</option><option value="gc_old_capacity">GC Old Capacity</option><option value="gc_perm_capacity">GC Perm Capacity</option><option value="gc_util">GC Util</option><option value="print_compilation">Print Compilation</option></select>';
			var coop = '<select name="compiler" class="op"><option value="-">--select--</option><option value="Compiled">Compiled</option><option value="Failed">Failed</option><option value="Invalid">Invalid</option><option value="Time Spent">Time Spent</option><option value="Failed Type">Failed Type</option></select>';
			var gccauop = '<select name="gc_cause" class="op"><option value="-">--select--</option><option value="S0">S0</option><option value="S1">S1</option><option value="E">E</option><option value="O">O</option><option value="P">P</option><option value="YGC">YGC</option><option value="YGCT">YGCT</option><option value="FGC">FGC</option><option value="FGCT">FGCT</option><option value="GCT">GCT</option></select>';
			var gcnop = '<select name="gc_new" class="op"><option value="-">--select--</option><option value="S0C">S0C</option><option value="S1C">S1C</option><option value="S0U">S0U</option><option value="S1U">S1U</option><option value="TT">TT</option><option value="MTT">MTT</option><option value="DSS">DSS</option><option value="EC">EC</option><option value="EU">EU</option><option value="YGC">YGC</option><option value="YGCT">YGCT</option></select>';
			var gcoop = '<select name="gc_old" class="op"><option value="-">--select--</option><option value="PC">PC</option><option value="PU">PU</option><option value="OC">OC</option><option value="OU">OU</option><option value="YGC">YGC</option><option value="FGC">FGC</option><option value="FGCT">FGCT</option><option value="GCT">GCT</option></select>';
			var gcocop = '<select name="gc_old_capacity" class="op"><option value="-">--select--</option><option value="OGCMN">OGCMN</option><option value="OGCMX">OGCMX</option><option value="OGC">OGC</option><option value="OC">OC</option><option value="YGC">YGC</option><option value="FGC">FGC</option><option value="FGCT">FGCT</option><option value="GCT">GCT</option></select>';
			var gcpcop = '<select name="gc_perm_capacity" class="op"><option value="-">--select--</option><option value="PGCMN">PGCMN</option><option value="PGCMX">PGCMX</option><option value="PGC">PGC</option><option value="PC">PC</option><option value="YGC">YGC</option><option value="FGC">FGC</option><option value="FGCT">FGCT</option><option value="GCT">GCT</option></select>';
			var gcuop = '<select name="gc_util" class="op"><option value="-">--select--</option><option value="S0">S0</option><option value="S1">S1</option><option value="E">E</option><option value="O">O</option><option value="P">P</option><option value="YGC">YGC</option><option value="YGCT">YGCT</option><option value="FGC">FGC</option><option value="FGCT">FGCT</option><option value="GCT">GCT</option></select>';
			var pcop = '<select name="print_compilation" class="op"><option value="-">--select--</option><option value="Compiled">Compiled</option><option value="Size">Size</option><option value="Type">Type</option></select>';
			var gcncop = '<select name="gc_new_capacity" class="op"><option value="-">--select--</option><option value="NGCMN">NGCMN</option><option value="NGCMX">NGCMX</option><option value="NGC">NGC</option><option value="S0CMX">S0CMX</option><option value="S0C">S0C</option><option value="S1CMX">S1CMX</option><option value="S1C">S1C</option><option value="ECMX">ECMX</option><option value="EC">EC</option><option value="YGC">YGC</option><option value="FGC">FGC</option></select>';
			var clop = '<select name="class" class="op"><option value="-">--select--</option><option value="Loaded Classes">Loaded Classes</option><option value="Loaded Bytes">Loaded Bytes</option><option value="Unloaded Classes">Unloaded Classes</option><option value="Unloaded Bytes">Unloaded Bytes</option><option value="Time Consumed">Time Consumed</option></select>';
			var gcop = '<select name="gc" class="op"><option value="-">--select--</option><option value="S0C">S0C</option><option value="S1C">S1C</option><option value="S0U">S0U</option><option value="S1U">S1U</option><option value="EC">EC</option><option value="EU">EU</option><option value="OC">OC</option><option value="OU">OU</option><option value="PC">PC</option><option value="PU">PU</option><option value="YGC">YGC</option><option value="YGCT">YGCT</option><option value="FGC">FGC</option><option value="FGCT">FGCT</option><option value="GCT">GCT</option></select>';
			var gccop = '<select name="gc_capacity" class="op"><option value="-">--select--</option><option value="NGCMN">NGCMN</option><option value="NGCMX">NGCMX</option><option value="NGC">NGC</option><option value="S0C">S0C</option><option value="S1C">S1C</option><option value="EC">EC</option><option value="OGCMN">OGCMN</option><option value="OGCMX">OGCMX</option><option value="OGC">OGC</option><option value="OC">OC</option><option value="PGCMN">PGCMN</option><option value="PGCMX">PGCMX</option><option value="PGC">PGC</option><option value="PC">PC</option><option value="YGC">YGC</option><option value="FGC">FGC</option></select>';
			$(document).ready(function(){
				drawGraph(1);drawGraph(2);drawGraph(3);
				$(document).on("focus", ".gphnm input", (function(e){
					if($(e.target).val() === "Graph Name"){
						$(e.target).val("");
					}
				}));
				$(document).on("blur", ".gphnm input", (function(e){
					if($(e.target).val() === ""){
						$(e.target).val("Graph Name");
					}
				}));
				$(document).on("change", ".gphnm input", (function(e){
					var c = true;
					var gcntd = gcnt;
					$(".gphnm input").each(function(e){
						if($(this).val() === "Graph Name"){
							c = false && c;
						}
					});
					if(c){
						drawGraph(++gcnt);
					}
				}));
				$(document).on("click", "td:first-child", (function(e){
					/*var tdop = $(e.target).text();
					if(tdop.indexOf("select") == -1 && tdop != "g"){
						$(e.target).html(stse);
						var $opts = $("option", ".selst");
						$opts.each(function() {
							if ($(this).text() === tdop){
								console.log($(this).val());
								$(".selst").val($(this).val());
							}
						});
					}*/
					$(e.target).html(stse);
					$(".selst").focus();
				}));
				$(document).on("click", "td:first-child", (function(e){
				    var chg = true;
					if(e.target.nodeName === "TD"){
						$(e.target).parent().siblings().each(function(){
							var tdv = $(this).children("td:first-child").html();
							if(tdv === "g" || tdv === ""){
								chg = false && chg;
							}
						});
						if(chg){
							$(e.target).parent().parent().append('<tr><td></td><td></td><td class="invi"></td><td class="invi"></td><td class="invi"></td><td class="clr"></td></tr>');
						}
					}
				}));
				$(document).on("change", ".selst", (function(e){
					var v1 = $(e.target).find("option:selected").text();
					var v2 = $(e.target).val();
					var t = $(e.target).parent().html(v1);
					$(t).siblings("td:nth-child(3)").html(v2);
					$(t).siblings("td:nth-child(5)").html(v1);
					showopts(t, v2);
				}));
				$(document).on("blur", ".selst", (function(e){
					$(e.target).parent().siblings("td:nth-child(2)").html($(e.target).parent().siblings("td:nth-child(4)").html());
					$(e.target).parent().html($(e.target).parent().siblings("td:nth-child(5)").html());
				}));
				$(document).on("change", ".op", (function(e){
				    $(e.target).parent().siblings("td:nth-child(4)").html($(e.target).val());
					$(e.target).parent().html($(e.target).val());
					
				}));
				$(document).on("blur", ".op", (function(e){
				    $(e.target).parent().html($(e.target).parent().siblings("td:nth-child(4)").html());
				}));
				$(document).on("click", "td:nth-child(2)", (function(e){
					showopts($(e.target).siblings("td:first-child"), $(e.target).siblings("td:nth-child(3)").text());
					$(".op").focus();
				}));
				$(document).on("click", ".clr", (function(e){
					if($(e.target).parent().siblings().length > 2){
						$(e.target).parent().remove();
					}else{
						$(e.target).siblings().html("");
					}
				}));
				$("#subbtn").click(function(e){
					var gcnt = 0;
					var d = "";
					$("#custfrm").children().each(function(){
						if(this.nodeName === "P"){
							var tv = $(this).children("input").val();
							if(tv != "" && tv != "Graph Name"){
								if(gcnt > 0){d=d+"&";}
								gcnt++;
								d = d+"graph"+gcnt+"="+encodeURI(tv);
							}
						}else if(this.nodeName === "TABLE"){
							var scnt = 1;
							$(this).children("tbody").children("tr").each(function(){
								var sv = $(this).children("td:nth-child(3)").html();
								if(sv != ""){
									d = d+"&stat"+gcnt+scnt+"1="+encodeURI(sv);
									d = d+"&statopt"+gcnt+scnt+"2="+encodeURI($(this).children("td:nth-child(2)").html());
									scnt++;
								}
							});
						}
					});
					$.ajax({
						type: "GET",
						url: "./save",
						async: true,
						data: d,
						success: function(html){
							$("#noti").html("Data submitted");
							$("#noti").css("visibility","visible");
							$("input:text").val("Graph Name");
							$("td:nth-child(1), td:nth-child(2), td:nth-child(3), td:nth-child(4), td:nth-child(5)").html("");
							setTimeout("$('#noti').css('visibility','hidden');", 3000);
						}
					});
				});
			});
			function drawGraph(gn){
				var gosr = gos.replace(/gno/g,gn);
				$("#custfrm").append(gosr);
			}
			function showopts(ele, opt){
				if(opt==='class'){$(ele).siblings("td:nth-child(2)").html(clop);}
				else if(opt==='compiler'){$(ele).siblings("td:nth-child(2)").html(coop);}
				else if(opt==='gc'){$(ele).siblings("td:nth-child(2)").html(gcop);}
				else if(opt==='gc_capacity'){$(ele).siblings("td:nth-child(2)").html(gccop);}
				else if(opt==='gc_cause'){$(ele).siblings("td:nth-child(2)").html(gccauop);}
				else if(opt==='gc_new'){$(ele).siblings("td:nth-child(2)").html(gcnop);}
				else if(opt==='gc_new_capacity'){$(ele).siblings("td:nth-child(2)").html(gcncop);}
				else if(opt==='gc_old'){$(ele).siblings("td:nth-child(2)").html(gcoop);}
				else if(opt==='gc_old_capacity'){$(ele).siblings("td:nth-child(2)").html(gcocop);}
				else if(opt==='gc_perm_capacity'){$(ele).siblings("td:nth-child(2)").html(gcpcop);}
				else if(opt==='gc_util'){$(ele).siblings("td:nth-child(2)").html(gcuop);}
				else if(opt==='print_compilation'){$(ele).siblings("td:nth-child(2)").html(pcop);}
			}
		</script>
	</head>
	<body>
		<jsp:include page="./page-header.html"></jsp:include>
		<h2>Customize your plots</h2>
		<p id="noti"></p>
		<form id="custfrm" action="#" method="get">
		</form>
		<a href="#" id="subbtn">Submit</a>
	</body>
</html>