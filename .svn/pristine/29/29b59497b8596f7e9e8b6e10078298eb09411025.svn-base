/**
 * This jQuery plugin displays pagination links inside the selected elements.
 *
 * @author Gabriel Birke (birke *at* d-scribe *dot* de)
 * @version 1.2
 * @param {int} total Number of entries to paginate
 * @param {Object} params Several params (see README for documentation)
 * @return {Object} jQuery Object
 * 
 * 参数名	描述	参数值
 * maxentries	总条目数	必选参数，整数
 * pageSize	每页显示的条目数	可选参数，默认是10
 * paginationBarCount	连续分页主体部分显示的分页条目数	可选参数，默认是10
 * currentPage	当前选中的页面	可选参数，默认是0，表示第1页
 * sidePageCount	两侧显示的首尾分页的条目数	可选参数，默认是0
 * link_to	分页的链接	字符串，可选参数，默认是"#"
 * prev_text	“前一页”分页按钮上显示的文字	字符串参数，可选，默认是"Prev"
 * next_text	“下一页”分页按钮上显示的文字	字符串参数，可选，默认是"Next"
 * ignore_text	省略的页数用什么文字表示	可选字符串参数，默认是"..."
 * alwaysShowPrev	是否显示“前一页”分页按钮	布尔型，可选参数，默认为true，即显示“前一页”按钮
 * alwaysShowNext	是否显示“下一页”分页按钮	布尔型，可选参数，默认为true，即显示“下一页”按钮
 * callback	回调函数	默认无执行效果
 */
/*
 *  codeZ  2018-03-27
 *  下面的版本是大修改之前的版本,,最初版本请百度jquery.pagination下载之后进行查看,此版本页面传过来的currentPage其实减了1
 */
jQuery.fn.pagination = function(total, params){
	params = jQuery.extend({
		pageSize:10,
		paginationBarCount:10,
		currentPage:1,
		sidePageCount:0,
		link_to:"#",
		prev_text:"Prev",
		next_text:"Next",
		ignore_text:"...",
		alwaysShowPrev:true,
		alwaysShowNext:true,
		callback:function(){return false;}
	},params||{});
	
	return this.each(function() {
		 //计算最大分页显示数目
		function numPages() {
			return Math.ceil(total/params.pageSize);
		}	
		 //* 极端分页的起始和结束点，这取决于currentPage 和 paginationBarCount.
		// * @返回 {数组(Array)}
		function getInterval()  {
			var ne_half = Math.ceil(params.paginationBarCount/2);
			var np = numPages();
			var upper_limit = np-params.paginationBarCount;
			var start = currentPage>ne_half?Math.max(Math.min(currentPage-ne_half, upper_limit), 0):0;
			var end = currentPage>ne_half?Math.min(currentPage+ne_half, np):Math.min(params.paginationBarCount, np);
			return [start,end];
		}
		
		 //* 分页链接事件处理函数
		// * @参数 {int} pageNum 为新页码
		function pageSelected(pageNum, evt){
			currentPage = pageNum;
			drawLinks();
			var continuePropagation = params.callback(pageNum + 1, panel);
			if (!continuePropagation) {
				if (evt.stopPropagation) {
					evt.stopPropagation();
				}
				else {
					evt.cancelBubble = true;
				}
			}
			return continuePropagation;
		}
		
		function drawLinks() {
			panel.empty();
			var interval = getInterval();
			var np = numPages();
			// 这个辅助函数返回一个处理函数调用有着正确pageNum的pageSelected。
			var getClickHandler = function(pageNum) {
				return function(evt){ return pageSelected(pageNum,evt); }
			}
			//辅助函数用来产生一个单链接(如果不是当前页则产生span标签)
			var appendItem = function(pageNum, appendparams){
				pageNum = pageNum<0?0:(pageNum<np?pageNum:np-1); // 规范page id值
				appendparams = jQuery.extend({text:pageNum+1, classes:""}, appendparams||{});
				if(pageNum == currentPage){
					var lnk = jQuery("<span class='current'>"+(appendparams.text)+"</span>");
				}else{
					var lnk = jQuery("<a>"+(appendparams.text)+"</a>")
						.bind("click", getClickHandler(pageNum))
						.attr('href', params.link_to.replace(/__id__/,pageNum));		
				}
				if(appendparams.classes){lnk.addClass(appendparams.classes);}
				panel.append(lnk);
			}
			// 产生"Previous"-链接
			if(params.prev_text && (currentPage > 0 || params.alwaysShowPrev)){
				appendItem(currentPage-1,{text:params.prev_text, classes:"prev"});
			}
			// 产生起始点
			if (interval[0] > 0 && params.sidePageCount > 0)
			{
				var end = Math.min(params.sidePageCount, interval[0]);
				for(var i=0; i<end; i++) {
					appendItem(i);
				}
				if(params.sidePageCount < interval[0] && params.ignore_text)
				{
					jQuery("<span>"+params.ignore_text+"</span>").appendTo(panel);
				}
			}
			// 产生内部的些链接
			for(var i=interval[0]; i<interval[1]; i++) {
				appendItem(i);
			}
			// 产生结束点
			if (interval[1] < np && params.sidePageCount > 0)
			{
				if(np-params.sidePageCount > interval[1]&& params.ignore_text)
				{
					jQuery("<span>"+params.ignore_text+"</span>").appendTo(panel);
				}
				var begin = Math.max(np-params.sidePageCount, interval[1]);
				for(var i=begin; i<np; i++) {
					appendItem(i);
				}
				
			}
			// 产生 "Next"-链接
			if(params.next_text && (currentPage < np-1 || params.alwaysShowNext)){
				appendItem(currentPage+1,{text:params.next_text, classes:"next"});
			}
		}
		
		//从选项中提取currentPage
		var currentPage = params.currentPage;
		//创建一个显示条数和每页显示条数值
		total = (!total || total < 0)?1:total;
		params.pageSize = (!params.pageSize || params.pageSize < 0)?1:params.pageSize;
		//存储DOM元素，以方便从所有的内部结构中获取
		var panel = jQuery(this);
		// 获得附加功能的元素
		this.selectPage = function(pageNum){ pageSelected(pageNum);}
		this.prevPage = function(){
			if (currentPage > 0) {
				pageSelected(currentPage - 1);
				return true;
			}
			else {
				return false;
			}
		}
		this.nextPage = function(){ 
			if(currentPage < numPages()-1) {
				pageSelected(currentPage+1);
				return true;
			}
			else {
				return false;
			}
		}
		// 所有初始化完成，绘制链接
		drawLinks();
        // 回调函数
        //params.callback(currentPage + 1, this);
	});
}