$(function(){
	loadEditForm();
	
});

function loadEditForm(){
	var id  = $('#deliveryId').val();
	var type  = $('#deliveryType').val();
	$.getJSON(contextPath + type+'/get',{id:id},function(res){
		console.log(res);
		//给所有下拉框分配name属性
		$('form select').each(function(){
			$(this).attr('name',$(this).attr('type'));
			//隐藏下面的自定义框
			$(this).next('input').addClass('hide');
			//加入是自定义的内容需要添加一下内容
			if(!$(this).find('option[value='+res[$(this).attr('type')]+']')[0])
				$(this).find('option[value=自定义]')
				.before($('<option value="'+res[$(this).attr('type')]+'">').text(res[$(this).attr('type')]));
		});
		for (var key in res) {
			$('form :input[name='+key+']').val([res[key]]);
			if(key == 'area' && res[key] != null && res[key]!= ''){
				$("#viewMap").removeAttr("disabled",false);//打开查看地图按钮
			}
			if(key == 'zlzk' && res[key] != null && res[key]!= ''){
				$("#viewImgs").removeAttr("disabled",false);//打开查看图片按钮
				showImgs(res[key]);
			}
		}
		$('form [name=iscopy]').val()
	});
}