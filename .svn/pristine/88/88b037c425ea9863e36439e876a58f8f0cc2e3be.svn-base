$(function(){
	loadViewForm();
});

function loadViewForm(){
	var id  = $('#deliverId').val();
	var type  = $('#type').val();
	$('#headerTitle').text(templateName[type]);
	$.getJSON(contextPath + type+'/get',{id:id},function(res){
		console.log(res);
		for (var key in res) {
			$('span[name='+key+']').text(res[key] == null ? '' : res[key]);
			$('input[name='+key+']').val(res[key] == null ? '' : res[key]);
			
			
			//当有数据的时候  打开按钮
			if(key == 'area' && res[key] != null && res[key]!= ''){
				$("#viewMap").removeAttr("disabled",false);//打开查看地图按钮
			}
			if(key == 'zlzk' && res[key] != null && res[key]!= ''){
				$("#viewImgs").removeAttr("disabled",false);//打开查看图片按钮
				showImgs(res[key]);
			}
		}
		$('span[name="iscopy"]').text(res.iscopy == 0 ? '是':'否');
		
	});
}