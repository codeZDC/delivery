var deliveryType = $("#deliveryType").val(); // 获取汇交类型(12个中的一个)
var deliverySubmit = false; // 防止重复提交
jQuery(function($) {
	
	$("#viewMap").attr("disabled",true);//不让点击地图
	$("#viewImgs").attr("disabled",true);//不让点击查看图片
	
	// 更改页面头名字
	$("#headerTitle").html(templateName[deliveryType]);
	// 初始化下拉菜单的选项
	$("select").each(
			function() {
				var select = $(this);
				if (select.attr('type')) {// 如果有type这个属性
					var options = dropArr[select.attr('type')];
					for ( var i in options) {
						select.append("<option value='"
								+ (options[i] == '请选择' ? "" : options[i])
								+ "'>" + options[i] + "</option>");
					}

					// 给自定义按钮添加事件
					select.on('change', function() {
						if (select.val() == '自定义') {
							// 把旁边的input按钮显示出来
							select.next().removeClass('hide').val('');
						} else {
							var input = select.next();
							input.addClass('hide');
							// 清空input的值
							input.val(select.val());
						}
					});
				}
			});

	// 添加鼠标上移弹出提示功能
	$('[data-rel=popover]').popover({
		container : 'body'
	});

	// 文件上传 控件

	$('#shpFile').ace_file_input({
		style : 'well',
		btn_choose : '点这里选择文件  或者拖放文件到这里 只接受.shp文件',
		btn_change : null,
		no_icon : 'ace-icon fa fa-cloud-upload',
		droppable : true,
		// maxSize: 110000,//文件允许的最大值 bytes
		allowExt : [ "shp" ],// 允许的后缀名
		// allowMime: ["image/jpg", "image/jpeg", "image/png", "image/gif"],
		thumbnail : 'small'// large | fit
		// ,icon_remove:null//set null, to hide remove/reset button
		/**
		 * ,before_change:function(files, dropped) { //Check an example below
		 * //or examples/file-upload.html return true; }
		 */
		/**
		 * ,before_remove : function() { return true; }
		 */
		,
		preview_error : function(filename, error_code) {
			// name of the file that failed
			// error_code values
			// 1 = 'FILE_LOAD_FAILED',
			// 2 = 'IMAGE_LOAD_FAILED',
			// 3 = 'THUMBNAIL_FAILED'
			// alert(error_code);
		}

	}).on('change', function() {
		// console.log($(this).data);
		 //console.log($(this).data('ace_input_method'));
		 uploadShp(this);
	}).on('file.error.ace', function(ev, info) {
		if (info.error_count['ext'])
			alert('文件格式不允许，请选择一个.shp文件');
		// if(info.error_count['size']) alert('文件过大，超过了 100KB');
	});
	
	//上传并解析shp文件
	function uploadShp(obj){
		var form = $(obj).parents('form').first();
		
		form.attr('method','POST').attr('enctype','multipart/form-data');//设置表单提交属性和方法
		$.ajax({
			type : 'POST',
			url : contextPath + 'delivery/parseShp',
			cache: false,
			processData: false,
			contentType: false,
			dataType:'text', 
			data : new FormData(form[0]),
			success : function(res){
				//把返回值写到输入框
				$("input[name='area']").val(res);
				$("#viewMap").removeAttr("disabled");//让查看地图按钮能点击
			},
			error : function(e){
				alert('shp文件解析失败');
			}
		});
	}
	
	

	$('#qualityFile').ace_file_input({
		style : 'well',
		btn_choose : '点这里选择文件  或者拖放文件到这里 只接受.png或者jpg文件',
		btn_change : null,
		no_icon : 'ace-icon fa fa-cloud-upload',
		droppable : true,
		// maxSize: 110000,//文件允许的最大值 bytes
		allowExt : [ "png", "jpg" ],// 允许的后缀名
		allowMime : [ "image/jpg", "image/jpeg", "image/png", "image/gif" ],
		thumbnail : 'small'// large | fit
		,
		preview_error : function(filename, error_code) {
		}

	}).on('change', function() {
		uploadImgs(this);
	}).on('file.error.ace', function(ev, info) {
		if (info.error_count['ext'] || info.error_count['mime'])
			alert('文件格式不允许，请选择一个允许的图片,png或者jpg');
		// if(info.error_count['size']) alert('文件过大，超过了 100KB');
	});
	
	//上传保存图片
	function uploadImgs(obj){
		var form = $(obj).parents('form').first();
		form.attr('method','POST').attr('enctype','multipart/form-data');//设置表单提交属性和方法
		$.ajax({
			type : 'POST',
			url : contextPath + 'delivery/saveImgs',
			cache: false,
			processData: false,
			contentType: false,
			dataType:'json', 
			data : new FormData(form[0]),
			success : function(res){
				if(res.success){
					$("#viewImgs").removeAttr("disabled");//让查看地图按钮能点击
					$("input[name='zlzk']").val(res.msg);
					console.log($("input[name='zlzk']").val());
					showImgs(res.msg);
				}
			},
			error : function(e){
				alert('上传图片失败');
			}
		});
	}
	

	/**
	 * 添加点击查看弹出地图界面
	 */
	$("#viewMap").on('click', function() {
		var type = $("input[name='type']").val();
		var area = $("input[name='area']").val();
		top.viewMap(type,area);// 显示地图
	});
	/**
	 * 查看图片按钮
	 */
	$("#viewImgs").on('click', function() {
		top.viewImg();// 显示图片
	});

	// 提交表单
	$('.submitForm').click(function() {
		// 验证表单
		if(!validateForm()){
			return;
		}
		// 验证成功后进行提交
		var handle = $('#handle').val();
		var url = contextPath + deliveryType + '/' +handle;
		if(handle == 'edit') {
			$('form select').each(function(){
				$(this).removeAttr('name');
			});
		}
		
		if (!deliverySubmit) {
			deliverySubmit = true;
			$.post(url, $(this).parents('form').serialize(), function(res) {
				if (res.success) {
					alert(res.message);
					deliverySubmit = false;
					location = contextPath + 'page/deliver/mainView';
				} else {
					alert('网络错误,请联系管理员!');
				}
			}, 'json');
		} else {
			alert('正在提交中...');
		}
	});
	
	// 重置表单
	$('.resetForm').click(function() {
		if($('#handle').val() == 'edit')
			loadEditForm();
		else
			$(this).parents('form')[0].reset();
	});

});
/**
 * 显示图片
 */
function showImgs(res){
	var imgsPanel = $("#imgsPanel",top.document); 
	var type = $("input[name='type']").val();
	var imgs = res.split(",");
	
	//清空图片
	imgsPanel.find('li').remove();
	for(var i in imgs){
		console.log(i);
		var imgStr = '<li><a href="'+ contextPath   + 'uploaded/' + type +'/'+ imgs[i] + '"\
			data-rel="colorbox" class="cboxElement"> <img width="150" height="150" alt="150x150"\
				src="'+ contextPath   + 'uploaded/' + type +'/'+ imgs[i] + '">\
				<div class="text"><div class="inner">点击查看大图</div></div></a></li>'
		
		imgsPanel.append(imgStr);
	}
	
}


//验证表单
function validateForm(){
	//把所有带required class的input拿到
	var flag = true;
	$(".required:input").each(function(){
		if(this.value == ''){
			alert('请填写此项');
			this.focus();
			flag = false;
			return false;
		}
	});
	if(!flag)return ;//停止方法执行
	$(".number").each(function(){
		var reg = /^[1-9]\d*$/;
		if(!reg.test(this.value)){
			alert('只能填写数字 	');
			this.focus();
			flag = false;
			return false;
		}
	});
	if(!flag)return ;//停止方法执行
	$("select").each(function(){
		if(this.value == ''){
			alert('请填写此项');
			this.focus();
			flag = false;
			return false;
		}
	});
	if(!flag)return ;//停止方法执行
	if(!checkDate($("#dateBegin").val() , $("#dateEnd").val())){
		alert("开始施测日期  不能大于  结束施测日期");
		$("#dateBegin")[0].focus();
		flag = false;
	}
	return flag;
}

function checkDate(start,end){
	var start = new Date(start.replace("-","/").replace("-","/"));
	var end = new Date(end.replace("-","/").replace("-","/"));;
	if(start >= end){
		return false;
	}
	return true;
}

