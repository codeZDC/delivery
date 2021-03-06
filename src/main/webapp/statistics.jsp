<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }/"></c:set>

<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta charset="utf-8" />
<title>图形统计</title>

<meta name="description" content="overview &amp; stats" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

<!-- bootstrap & fontawesome -->
<link rel="stylesheet" href="static/ace/assets/css/bootstrap.css" />
<link rel="stylesheet" href="static/ace/assets/css/font-awesome.css" />



<!-- text fonts -->
<link rel="stylesheet" href="static/ace/assets/css/ace-fonts.css" />
<!-- ace styles -->
<link rel="stylesheet" href="static/ace/assets/css/ace.css"
	class="ace-main-stylesheet" id="main-ace-style" />

<style>
</style>

</head>

<body class="no-skin">
	<div class="main-container">

		<div id="navbar"
			class="navbar navbar-default    navbar-collapse       h-navbar">
			<script type="text/javascript">
				try{ace.settings.check('navbar' , 'fixed')}catch(e){}
			</script>

			<div class="navbar-container" id="navbar-container">
				<div class="navbar-header pull-left">
					<a href="#" class="navbar-brand"> <small> <i
							class="fa fa-leaf"></i> 贵州测绘成果目录汇交系统
					</small>
					</a>
				</div>



				<!-- /section:basics/navbar.dropdown -->
				<nav role="navigation"
					class="navbar-menu pull-left collapse navbar-collapse">
					<!-- #section:basics/navbar.nav -->
					<ul class="nav navbar-nav">
						<li><a href="homePage.jsp" class="dropdown-toggle"> <i
								class="ace-icon fa fa-home"></i> 首页
						</a></li>

						<li><a href="javascript:;"> <i
								class="ace-icon fa fa-signal"></i> 图形统计
						</a></li>
						<li><a href="deliverySearch.jsp"> <i
								class="ace-icon fa fa-map-marker"></i> 成果查询
						</a></li>
					</ul>

				</nav>
				<div class="pull-right">
					<ul class="nav navbar-nav">
						<li><a href="login.jsp" class="dropdown-toggle"> <i
								class="ace-icon fa fa-sign-in"></i> 登录
						</a></li>

					</ul>
				</div>

			</div>
			<!-- /.navbar-container -->
		</div>

		<div class="page-content" style="width: 80%; margin: 0px auto">
			<div class="row">
				<div class="col-sm-12 center">
					<h4 class="header smaller lighter blue">图形统计</h4>
					<p>
						<select class="" id="typeSelect">
							<option value="0">十二类</option>
							<option value="1">市</option>
						</select> <select class="" id="yearSelect">
							<option value="2018">2018</option>
							<option value="2019">2019</option>
						</select>
						<button class="btn btn-white btn-default btn-round"
							id="searchButton">
							<i class="ace-icon fa fa-search red2"></i> 查看
						</button>
					</p>

					<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
					<div id="projectType" style="height: 400px"></div>
					<div id="projectValue" style="height: 400px"></div>

				</div>


			</div>

		</div>




	</div>


	<!--[if !IE]> -->
	<script type="text/javascript">
		window.jQuery
				|| document
						.write("<script src='static/ace/assets/js/jquery.js'>"
								+ "<"+"/script>");
	</script>

	<!-- <![endif]-->

	<script src="static/jquery/1.9.1/jquery.min.js"></script>

	<script src="static/ace/assets/js/bootstrap.js"></script>


	<!-- ace scripts -->
	<script src="static/ace/assets/js/ace/ace.js"></script>

	<!-- echart scripts -->

	<script src="static/echarts-2.2.7/build/dist/echarts.js"></script>
	<script type="text/javascript">
	  // 路径配置
    require.config({
        paths: {
            echarts: 'static/echarts-2.2.7/build/dist'
        }
    });
	  
    var templateName =  {
    		gps:'天文、三角、GPS、导线锁网成果',
    		szw:'水准网',
    		wxyx:'卫星影像',
    		hsyx:'航摄影像',
    		mndt:'模拟地图',
    		szdt:'数字地图',
    		zych:'专业测绘类',
    		gccl:'工程测量类',
    		ptdt:'普通地图编制类',
    		zytz:'专业与特种地图编制类',
    		dlxx:'地理信息类',
    		yqjy:'仪器检校类'
    		};

    
    // 使用
    require(
        [
            'echarts',
            'echarts/chart/bar' // 使用柱状图就加载bar模块，按需加载
        ],
        function (ec) {
            // 基于准备好的dom，初始化echarts图表
            var projectType = ec.init($("#projectType")[0]); 
            var projectValue = ec.init($("#projectValue")[0]); 
            
            var projectTypeOption = {
            	title : {
            		        text: '项目类型'
            		    },
                tooltip: {
                    show: true
                },
                legend: {
                    data:['项目总数(个)']
                },
                xAxis : [
                    {
                        type : 'category',
                        data : ["衬衫","羊毛衫","雪纺衫","裤子","高跟鞋","袜子"],
	                    axisLabel:{  
	                        interval:0,//横轴信息全部显示  
	                        rotate:-30,//-30度角倾斜显示  
	                   }  
                    }
                ],
                grid: {  
                                    y2: 140  
                                }, 
                yAxis : [
                    {
                        type : 'value'
                    }
                ],
                series : [
                    {
                        "name":"项目总数(个)",
                        "type":"bar",
                        "data":[5, 20, 40, 10, 10, 20]
                    }
                ]
            };
            
            var projectValueOption = {
                	title : {
                		        text: '项目价值'
                		    },
                    tooltip: {
                        show: true
                    },
                    legend: {
                        data:['项目价值(万元)']
                    },
                    xAxis : [
                        {
                            type : 'category',
                            data : ["衬衫","羊毛衫","雪纺衫","裤子","高跟鞋","袜子"],
	                        axisLabel:{  
	                            interval:0,//横轴信息全部显示  
	                            rotate:-30,//-30度角倾斜显示  
	                       }  
                        }
                    ],
                    grid: {  
                        y2: 140  
                    }, 
                    yAxis : [
                        {
                            type : 'value'
                        }
                    ],
                    series : [
                        {
                            "name":"项目价值(万元)",
                            "type":"bar",
                            "data":[5, 20, 40, 10, 10, 20]
                        }
                    ]
                };
    
            function getDelivery(year,type){
            	$.getJSON('${contextPath}delivery/getDeliveryByParam',{
            		year: year,
            		type:type
            		
            	},function(res){
            		if(res.success){
            			console.log(res); //组装数据
            			var data = res.data;
            			var arrtype = new Array();//数量图表
            			var arrCount = new Array();
            			var arrVal = new Array();
            			for(var i in data){
            				
            				if(type == 0){//12类
            					var name = templateName[data[i].type].split("");
            					arrtype.push(templateName[data[i].type]);
                				arrCount.push(data[i].counts);
                				arrVal.push(data[i].valuesSum);
                			}else{//市级别
                				arrtype.push(data[i].zoneName);
                				arrCount.push(data[i].counts);
                				arrVal.push(data[i].valuesSum);
                			}
            				
            				
            			}
            			console.log(arrtype);
            			console.log(arrVal);
            			
            			projectTypeOption.xAxis[0].data = arrtype;//赋值
            			projectTypeOption.series[0].data = arrCount;
            			projectValueOption.xAxis[0].data = arrtype;//赋值
            			projectValueOption.series[0].data = arrVal;
            			
            			// 为echarts对象加载数据 
                        projectType.setOption(projectTypeOption,true); 
                        projectValue.setOption(projectValueOption,true); 
            		}
            	});
            }
            //初始化图表
            getDelivery(2018,0);
            
            $('#searchButton').on('click',function(){
            	//获取查询条件
            	var year = $('#yearSelect').val();
            	var type = $('#typeSelect').val();
            	// 获取汇交清单
            	getDelivery(year,type);
            });
        }
    );
    
	
	</script>




</body>
</html>
