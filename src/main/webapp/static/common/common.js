var contextPath = parent.$('#contextPath').val();

//表单点击的时候给表单添加行样式,,使用bootstrap
$('tr[role=row]').click(function(){
	//$(this).toggleClass('success').siblings().removeClass('success');
});

//显示界面  参数 对象id
function showView(id){
	$("#"+id).addClass("hide");
}

//隐藏界面  参数 对象id
function hideView(id){
	$("#"+id).removeClass("hide");
}
//公共变量   12种模板变量的对应关系
//" 天文、三角、GPS、导线锁网成果","水准网","卫星影像","航摄影像","模拟地图","数字地图","专业测绘类","工程测量类","普通地图编制类","专业与特种地图编制类","地理信息类","仪器检校类" 
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

//定义下拉的字段
var dropArr={
     //坐标系统等[0]
	  zbxt :["请选择","1954年北京坐标系","1980西安坐标系","2000国家大地坐标系","自定义"],
     //高程系统等[1]
      gcxt :["请选择","1956年黄海高程系","1985国家高程基准","自定义"],
     //卫星种类等[2]
      wxzl :["请选择","TM","SPOT","资源卫星二号","IKONOS","QuickBird","Landsat","自定义"],
     //成图方法等[3]
      ctff :["请选择","白纸测图","航测成图","编绘成图","自定义"],
     //项目类别“界线测绘”、“地籍测绘”、“房产测绘”//测绘等[4]
      xmlb :["请选择","界线测绘","地籍测绘","房产测绘","自定义"],
      //幅面两全开”、“全开”、“对开”、“四开”、“八开”等[5]
      fm :["请选择","两全开","全开","对开","四开","八开","自定义"],
     //[6]采用的技术标准等《地理网格》（GB12409-1990）、《城市地理信息系统设计规范》（GB/T18578-2001）、《地下水资源分类分级标准》（GB/T15218-1994）等
      jsbz :["请选择","地理网格","城市地理信息系统设计规范","地下水资源分类分级标准","自定义"],
     //等级[7]
      level :["请选择","Ⅰ级","Ⅱ级","Ⅲ级","Ⅳ级","Ⅴ级","自定义"],
      gcclxmlb :["请选择","市政工程测量","水利工程测量","建筑工程测量","精密工程测量","自定义"]
}

$(function(){
	//时间控件 汉化
	$.fn.datepicker.dates['en'] = {
		    days: ["日", "一", "二", "三", "四", "五", "六", "日"],
		    daysShort: ["日", "一", "二", "三", "四", "五", "六", "日"],
		    daysMin: ["日", "一", "二", "三", "四", "五", "六", "日"],
		    months: ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"],
		    monthsShort: ["一", "二", "三", "四", "五", "六", "七", "八", "九", "十", "十一", "十二"],
		    today: "今天"
		};
	//时间控件
	$('.date-picker').datepicker({
		autoclose: true,
		todayHighlight: true
	});
	
})

//截取文字内容
function subStr(str,length){
	if(str&&str.length>(length||12))
		return str.substr(0,length||12)+'...';
	return str;
}
//格式化时间
function formatDate(time) {
	var year = time.getFullYear();
	month = time.getMonth() + 1;
	date = time.getDate();
	return year + "-" + month + "-" + date;
}

