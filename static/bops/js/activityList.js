﻿!(function($){
	$.namespace("DD.NewsList");
	
	var self = DD.NewsList;
	
	var bopsRoot = $("#bopsRoot").val() ;
	
	$.extend(DD.NewsList, {
		
		init:function(){
		    self._initEvent();
		},
		
		_initEvent: function() {
			$("#activityTable .delete-btn").click(function() {
			    if(!confirm('是否删除记录？')){
					return ;
				}
			    var _this = $(this);
				var id = _this.data('id');
				var status = _this.data('status');
				if (id == undefined || isNaN(parseInt(id))) {
				    alert('ID有误，请刷新页面后再试。');
					return ;
				}
				$.ajax({
					url: bopsRoot + '/bops/remote/reset_activity_status.htm',
					type: "post",
					data: {id: id, status: status},
					success: function(result) {
					var json = result.json;
						if (json.success) {
						    window.location.reload();
						} else {
						    var detail = json.detail;
							if (detail == 'param.error') {
							    alert('参数有误，请刷新页面后再试');
							} else {
							    alert('未知错误');
							}
						}
					},
					error: function(error) {
					    alert("删除活动失败: " + error);
					}
				});
			});
		},
		
		end:0
	});
})(jQuery);

jQuery(document).ready(function(){
	DD.NewsList.init();
});
