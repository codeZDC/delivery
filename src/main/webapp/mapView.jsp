<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!-- 读取配置文件 -->
<fmt:setBundle basename="config" var="config" />
<fmt:message key="arcgis.api.ip" var="arcgisApiIp" bundle="${config}" />
<!-- arcgis 依赖库 ip-->
<fmt:message key="arcgis.server.ip" var="arcgisServerIp"
	bundle="${config}" />
<!-- arcgis 服务器 ip -->

<!-- 弹出全屏的空间  用于显示地图 -->
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
<title>地图查询</title>
<!-- arcgis styles  arcgis styles -->
<link rel="stylesheet" type="text/css"
	href="http://${arcgisApiIp}/arcgis_js_api/3.9/js/dojo/dijit/themes/tundra/tundra.css" />
<link rel="stylesheet" type="text/css"
	href="http://${arcgisApiIp}/arcgis_js_api/3.9/js/esri/css/esri.css" />
<script type="text/javascript"
	src="http://${arcgisApiIp}/arcgis_js_api/3.9/init.js"></script>
	
<script src="${contextPath }/static/jquery/1.9.1/jquery.min.js"></script>
</head>
<body>
	<div id='mainpanel' style='margin: 0 auto;width:1200px;'>

		<!-- 地图 -->
		<div class="content_box slgg_con" style="height: 700px;" id="map"></div>

		<!-- 比例尺 -->
		<div id="navgation"
			style="position: relative; float: right; top: -650px; width: 73px; height: 242px;">
			<div id="zoomUp" title="放大"
				style="background-image: url(&quot;${contextPath}/static/imgs/mapNav2.png&quot;); background-position: 0px -266px; width: 20px; height: 20px; position: absolute; overflow: hidden; left: 16px; top: 53px; user-select: none; cursor: pointer; z-index: 10;"></div>
			<div id="zoomDown" title="缩小"
				style="background-image: url(&quot;${contextPath}/static/imgs/mapNav2.png&quot;); background-position: 0px -291px; width: 20px; height: 20px; position: absolute; overflow: hidden; left: 16px; top: 217px; user-select: none; cursor: pointer; z-index: 10;"></div>
			<div title=""
				style="background-image: url(&quot;${contextPath}/static/imgs/mapNav2.png&quot;); background-position: 0px 0px; width: 48px; height: 48px; position: absolute; overflow: hidden; left: 2px; top: 0px; user-select: none; cursor: pointer;">
				<div id="panLeft" class="panmap" title="左移"
					style="width: 13px; height: 26px; position: absolute; overflow: hidden; left: 0px; top: 13px; user-select: none; cursor: pointer;"></div>
				<div id="panTop" class="panmap" title="上移"
					style="width: 26px; height: 13px; position: absolute; overflow: hidden; left: 12px; top: 0px; user-select: none; cursor: pointer;"></div>
				<div id="panRight" class="panmap" title="右移"
					style="width: 13px; height: 26px; position: absolute; overflow: hidden; left: 34px; top: 11px; user-select: none; cursor: pointer;"></div>
				<div id="panBottom" class="panmap" title="下移"
					style="width: 26px; height: 13px; position: absolute; overflow: hidden; left: 12px; top: 32px; user-select: none; cursor: pointer;"></div>
			</div>
			<div id="silder" class="navgationsilder"
				style="position: absolute; left: 23px; top: 71px; z-index: 1; background-image: url(&quot;${contextPath}/static/imgs/mapNav2.png&quot;); background-position: -57px -99px; background-repeat: no-repeat; width: 6px; height: 145px; user-select: none;">
				<div id="sildermove" isselfmove="false" title=""
					style="background-image: url(&quot;${contextPath}/static/imgs/mapNav2.png&quot;); background-position: -57px -76px; width: 20px; height: 11px; position: absolute; overflow: hidden; left: -7px; top: 65px; user-select: none; cursor: pointer;"></div>
			</div>
			<div id="silderlength" class="navgationsilder"
				style="position: absolute; left: 23px; top: 147px; background: url(&quot;${contextPath}/static/imgs/mapNav2.png&quot;) -68px bottom/auto no-repeat scroll padding-box border-box transparent; z-index: 5; width: 6px; height: 83px; user-select: none;"></div>
			<div
				style="position: absolute; left: 20px; top: 48px; width: 50px; height: 180px; display: none;">
				<div
					style="position: absolute; left: 0px; top: 0px; width: 100%; height: 100%;"></div>
				<div
					style="position: absolute; left: 18px; top: 30px; cursor: pointer; width: 29px; height: 17px; overflow: hidden; background: url(&amp;quot;${contextPath}/static/imgs/mapNav2.png&amp;quot;) -51px 0px/auto no-repeat scroll padding-box border-box transparent;"></div>
				<div
					style="position: absolute; left: 18px; top: 72px; cursor: pointer; width: 29px; height: 17px; overflow: hidden; background: url(&amp;quot;${contextPath}/static/imgs/mapNav2.png&amp;quot;) -51px -19px/auto no-repeat scroll padding-box border-box transparent;"></div>
				<div
					style="position: absolute; left: 18px; top: 100px; cursor: pointer; width: 29px; height: 17px; overflow: hidden; background: url(&amp;quot;${contextPath}/static/imgs/mapNav2.png&amp;quot;) -51px -38px/auto no-repeat scroll padding-box border-box transparent;"></div>
				<div
					style="position: absolute; left: 18px; top: 128px; cursor: pointer; width: 29px; height: 17px; overflow: hidden; background: url(&amp;quot;${contextPath}/static/imgs/mapNav2.png&amp;quot;) -51px -57px/auto no-repeat scroll padding-box border-box transparent;"></div>
			</div>
		</div>
		<div style="float: clearn"></div>

		<!-- 颜色说明 -->
		<div id="img_color"
			style="position: relative; float: right; top: -350px; right: -50px;">
			<img src="${contextPath}/static/imgs/color.jpg" width="160px" height="300px" />
		</div>

	</div>

	<script type="text/javascript">
		/**********引用arcgis_for_js 文件*******/
		dojo.require("esri.map");
		dojo.require("esri.graphic");
		dojo.require("esri.toolbars.draw");
		dojo.require("esri.SpatialReference");
		dojo.require("esri.layers.GraphicsLayer");
		dojo.require("esri.InfoTemplate");

		dojo.require("dojo.number");
		dojo.require("dojo.domReady!");

		dojo.require("esri.geometry.Point");
		dojo.require("esri.geometry.Circle");
		dojo.require("esri.geometry.Polygon");

		dojo.require("esri.tasks.geometry");
		dojo.require("esri.tasks.LengthsParameters");
		dojo.require("esri.tasks.AreasAndLengthsParameters");
		dojo.require("esri.tasks.GeometryService");
		dojo.require("esri.tasks.QueryTask");
		dojo.require("esri.tasks.query");

		dojo.require("esri.symbols.SimpleLineSymbol");
		dojo.require("esri.symbols.SimpleFillSymbol");
		dojo.require("esri.symbols.TextSymbol");
		dojo.require("esri.symbols.PictureMarkerSymbol");

		dojo.require("tdlib.TDTLayer");
		dojo.require("tdlib.TDTAnnoLayer");
		dojo.require("tdlib.TDTYXLayer");
		dojo.require("tdlib.TDTYXAnnoLayer");
		/**********引用arcgis_for_js 文件结束*******/

		$(function(){
			//初始化地图
			initMapData();
		});
		

		function initMapData() {
			var data;
			
			dojo.addOnLoad(initMap(buildData()));
			
		}
		
		/**
		 根据查询显示点 和 面
		*/
		function showDeliveries(mapData){
			console.log(mapData);
			//清空地图 
			$('#map').empty();
			//构造对象
			var area = $(mapData).attr('area');
			var xmmc = $(mapData).attr('xmmc');
			var type = $(mapData).attr('type');
			var unitName = $(mapData).attr('unitname');
			var endTime = $(mapData).attr('endtime');
			var data = new Array();
			data[0] = new Object();
			//设置属性 
			data[0].TYPE = type;
			data[0].xmmc = xmmc;
			data[0].unitName = unitName;
			data[0].endTime = endTime;
			if(area.indexOf("MULTIPOLYGON:") > -1){
				//面
				data[0].isMian = true;
				data[0].FW = area.split("MULTIPOLYGON:");
				var fw = new Array();
				for(var i in data[0].FW){
					if(!data[0].FW[i] == ''){
						fw.push(eval("([[" + data[0].FW[i] + "]])"));
					}
				}
				data[0].FW = fw;
			}else{
				//点
				data[0].isMian = false;
				data[0].FW = area;
			}
			//console.log(data);
			initMap(data);
		}
		
		/**
		*构造参数 从parent取值
		*/
		function buildData(){
			var data = new Array();
			data[0] = new Object();
			
			if(top.mapArea){
				if(top.mapArea.indexOf("MULTIPOLYGON:") > -1){
					//面
					data[0].isMian = true;
					data[0].FW = top.mapArea.split("MULTIPOLYGON:");
					var fw = new Array();
					for(var i in data[0].FW){
						if(!data[0].FW[i] == ''){
							fw.push(eval("([[" + data[0].FW[i] + "]])"));
						}
					}
					data[0].FW = fw;
				}else{
					//点
					data[0].isMian = false;
					data[0].FW = top.mapArea;
				}
				data[0].TYPE = top.mapType;
			}
			console.log(data);
			
			return data;
		}

		function initMap(data) {
			try {
				//去除esri的logo
				var options = {
					logo : false,
					slider : false
				};
				var mianIndex = 0;//面的计数器
				var dianIndex = 0;//面的计数器

				//初始化地图
				var myMap = new esri.Map("map", options);
				var wmsLayer = new esri.layers.ArcGISTiledMapServiceLayer(
						"${arcgisServerIp}");
				wmsLayer.id = "wmsLayer";
				myMap.addLayer(wmsLayer);
				

				//地图放大连动
				dojo.connect(myMap, "onZoomEnd", function() {
					if ($("#sildermove").attr("isselfmove") == "false") {
						var top = (19 - myMap.getLevel()) * 7 + 2;

						$("#sildermove").css({
							"top" : top
						});
						$("#silderlength").css({
							"top" : top + 82,
							"height" : 145 - top
						});
					}
					$("#sildermove").attr("isselfmove", "false");
				});

				$("#sildermove").on("mousedown", function() {
					$(".navgationsilder").on("mousemove", function(e) {
						var top = e.pageY - $("#silder").offset().top - 6;
						if (top >= 2 && top <= 135) {
							$("#sildermove").css({
								"top" : top
							});
							$("#silderlength").css({
								"top" : top + 82,
								"height" : 145 - top
							});
						}
					});
				});

				$(".navgationsilder")
						.on(
								"mouseup",
								function() {
									var topstr = $("#sildermove").css("top");
									var tempnum = parseInt(topstr.substring(0,
											topstr.indexOf("px")));
									var finaltop;
									if ((tempnum - 2) % 7 != 0) {
										if ((tempnum - 2) % 7 < 3) {
											finaltop = Math
													.floor((tempnum - 2) / 7) * 7 + 2;
										} else {
											finaltop = Math
													.ceil((tempnum - 2) / 7) * 7 + 2;
										}
									} else {
										finaltop = tempnum;
									}
									var level = 19 - (finaltop - 2) / 7;
									myMap.setLevel(level);
									$("#sildermove").attr("isselfmove", "true");
									$("#sildermove").css({
										"top" : finaltop
									});
									$("#silderlength").css({
										"top" : finaltop + 82,
										"height" : 145 - finaltop
									});
									$(".navgationsilder").unbind("mousemove");
								});

				//上下左右平移
				$(".panmap").hover(function() {
					var title = $(this).attr("title");
					if (title == "上移") {
						$(this).parent().css({
							"background-position" : "0px -53px"
						});
					} else if (title == "下移") {
						$(this).parent().css({
							"background-position" : "0px -159px"
						});
					} else if (title == "左移") {
						$(this).parent().css({
							"background-position" : "0px -212px"
						});
					} else if (title == "右移") {
						$(this).parent().css({
							"background-position" : "0px -106px"
						});
					}
				}, function() {
					$(this).parent().css({
						"background-position" : "0px 0px"
					});
				});
				$(".panmap").on("click", function() {
					var title = $(this).attr("title");
					if (title == "上移") {
						myMap.panUp();
					} else if (title == "下移") {
						myMap.panDown();
					} else if (title == "左移") {
						myMap.panLeft();
					} else if (title == "右移") {
						myMap.panRight();
					}
				});

				//放大缩小
				$("#zoomUp").hover(function() {
					$(this).css({
						"background-position" : "-22px -266px"
					});
				}, function() {
					$(this).css({
						"background-position" : "0px -266px"
					});
				});
				$("#zoomUp").on("click", function() {
					myMap.setLevel(myMap.getLevel() + 1);
				});
				$("#zoomDown").hover(function() {
					$(this).css({
						"background-position" : "-22px -291px"
					});
				}, function() {
					$(this).css({
						"background-position" : "0px -291px"
					});
				});
				$("#zoomDown").on("click", function() {
					myMap.setLevel(myMap.getLevel() - 1);
				});

				//定义颜色值
				var array = new Array([ 245, 46, 1 ], [ 45, 72, 255 ], [ 212,
						101, 255 ], [ 98, 75, 197 ], [ 126, 0, 0 ],
						[ 3, 0, 76 ], [ 255, 244, 92 ], [ 0, 255, 0 ], [ 0, 86,
								31 ], [ 164, 0, 53 ], [ 80, 255, 198 ], [ 153,
								108, 51 ]);
				var index = 0;

				//查询后的数据集
				for (var i = 0; i < data.length; i++) {
					var type = data[i].TYPE;

					switch (type) {
					case "gps":
						index = 0;
						break;
					case "szw":
						index = 1;
						break;
					case "wxyx":
						index = 2;
						break;
					case "hsyx":
						index = 3;
						break;
					case "mndt":
						index = 4;
						break;
					case "szdt":
						index = 5;
						break;
					case "zych":
						index = 6;
						break;
					case "gccl":
						index = 7;
						break;
					case "btdt":
						index = 8;
						break;
					case "zytz":
						index = 9;
						break;
					case "dlxx":
						index = 10;
						break;
					case "yqjy":
						index = 11;
						break;
					}

					//绘制面
					if (data[i].isMian) {
						var fws = data[i].FW;
						for (var j = 0; j < fws.length; j++) {
							var fwStr = "范围:<br/>" + fws[j];
							if(data[i].xmmc != ''){
								fwStr = "项目名称: "+data[i].xmmc+"<br/>单位名称:"+data[i].unitName+"<br/>完成时间:"+data[i].endTime+"<br/>";
							}
							var myPolygon = {
								"geometry" : {
									"rings" : fws[j],
									"spatialReference" : {
										"wkid" : 4490
									}
								},
								"symbol" : {
									"color" : array[index], //颜色值
									"type" : "esriSFS",
									"style" : "esriSFSSolid"
								},
								"infoTemplate" : {
									"title" : "详细信息",
									"content" : fwStr
								}
							};
							var gra = new esri.Graphic(myPolygon);
							var pointLayer = new esri.layers.GraphicsLayer({
								opacity : 0.6
							});//opacity设置绘制图像的透明度
							var pointLayerId = "pointLayerM" + mianIndex;
							pointLayer.id = pointLayerId;
							myMap.addLayer(pointLayer);
							pointLayer.show();
							pointLayer.add(gra);

							mianIndex++;
						}
					} else {
						//绘制点
						var fwArray = data[i].FW.split(",");
						for (var j = 0; j < fwArray.length; j++) {
							var point = fwArray[j];
							var jwDu = point.split(" ");
							var x = jwDu[0].trim();
							var y = jwDu[1];
							var fwStr = "经度:" + x + "<br/> 纬度:" + y;
							if(data[i].xmmc != ''){
								fwStr = "项目名称: "+data[i].xmmc+"<br/>单位名称:"+data[i].unitName+"<br/>完成时间:"+data[i].endTime+"<br/>";
							}
							var myPoint = {
								"geometry" : {
									"x" : x, //经度
									"y" : y, //纬度
									"spatialReference" : {
										"wkid" : 4490
									// wkid：贵州的编码
									}
								},
								"infoTemplate" : {
									"title" : "详细信息",
									"content" : fwStr
								}
							};

							var gra = new esri.Graphic(myPoint);
							var pointLayer = new esri.layers.GraphicsLayer();
							var pointLayerId = "pointLayer" + dianIndex;
							pointLayer.id = pointLayerId;
							myMap.addLayer(pointLayer);
							pointLayer.show();

							var pictureMarkerSymbol = new esri.symbol.PictureMarkerSymbol(
									"${contextPath}/static/imgs/" + index + ".png", 25, 25);
							gra.setSymbol(pictureMarkerSymbol);
							pointLayer.add(gra);

							dianIndex++;
						}
					}
				}

				if (gpsPos == true) {
					callBackPagination(10, 10, data.len, data); //分页数据
				}

			} catch (e) {
			}
		};
	</script>
</body>
</html>



