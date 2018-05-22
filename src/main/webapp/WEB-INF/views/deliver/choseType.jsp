<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="row">
	<div class="col-sm-12" id="chose-type">
		<h3 class="row header smaller lighter blue">
			<span class="col-sm-6"> 草稿类型 </span>
			<!-- /.col -->
			<!-- /.col -->
		</h3>

		<!-- #section:elements.a -->
		<!-- 天文、三角、GPS、导线锁网成果","水准网","卫星影像","航摄影像","模拟地图","数字地图","专业测绘类","工程测量类","普通地图编制类","专业与特种地图编制类","地理信息类","仪器检校类" -->
		<p>	
			<a href="${contextPath }/page/12templates/mainView?type=gps" class="btn" >天文、三角、GPS、导线锁网成果</a>
			<a href="${contextPath }/page/12templates/mainView?type=szw" class="btn btn-primary">水准网</a>
			<a href="${contextPath }/page/12templates/mainView?type=wxyx" class="btn btn-info">卫星影像</a>
			<a href="${contextPath }/page/12templates/mainView?type=hsyx" class="btn btn-success">航摄影像</a>
		</p>

		<p>
			<a href="${contextPath }/page/12templates/mainView?type=mndt" class="btn btn-warning">模拟地图</a>
			<a href="${contextPath }/page/12templates/mainView?type=szdt" class="btn btn-danger">数字地图</a>
			<a href="${contextPath }/page/12templates/mainView?type=zych" class="btn btn-inverse">专业测绘类</a>
			<a href="${contextPath }/page/12templates/mainView?type=gccl" class="btn btn-pink">工程测量类</a>
		</p>

		<p>
			<a href="${contextPath }/page/12templates/mainView?type=ptdt" class="btn btn-purple">普通地图编制类</a>
			<a href="${contextPath }/page/12templates/mainView?type=zytz" class="btn btn-yellow">专业与特种地图编制类</a>
			<a href="${contextPath }/page/12templates/mainView?type=dlxx" class="btn btn-grey">地理信息类</a>
			<a href="${contextPath }/page/12templates/mainView?type=yqjy" class="btn btn-light">仪器检校类</a>
		</p>

		
	</div>
</div>

