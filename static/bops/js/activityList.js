!(function($){
	$.namespace("DD.NewsList");
	
	var self = DD.NewsList;
	
	var bopsRoot = $("#bopsRoot").val() ;
	
	$.extend(DD.NewsList, {
		
		init:function(){
		    self._initEvent();
		},
		
		_initEvent: function() {
		    $("#activityTable .can-signup").click(function() {
			    selectedIndex = $(this).get(0).selectedIndex;
			});
			$("#activityTable .can-signup").change(function() {
			    var _this = $(this);
				var value = _this.children("option:selected").val();
				if(value == 'N' && !confirm("修改将导致原活动参与数据失效，是否继续？")) {
				    _this.get(0).selectedIndex = selectedIndex;
				    return;
				}
				var id = _this.data('id');
				if (id == undefined || isNaN(parseInt(id))) {
				    alert('ID有误，请刷新页面后再试。');
					return ;
				}
				$.ajax({
					url: bopsRoot + '/bops/remote/reset_activity_can_signup.htm',
					type: "post",
					data: {id: id, canSignup: value},
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
			$("#activityTable .delete-btn").click(function() {
			    var _this = $(this);
				var id = _this.data('id');
				var status = _this.data('status');
				if (status == 'N') {
					if(!confirm('是否启用记录？')){
						return ;
					}
				} else {
				    if(!confirm('是否删除记录？')){
						return ;
					}
				}
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
			$("#activityTable .oper-btn").click(function() {
			    $("#activityTable .btn-list").addClass('dd-hide');
			    $(this).closest('.oper-box').find('.btn-list').removeClass('dd-hide');
			});
			$("#activityTable .btn-list").mouseleave(function() {
			    $(this).addClass('dd-hide');
			});
			
			$("#activityTable .top-btn").click(function(){
				var _this = $(this);
				var id = _this.data('id');
				var top = _this.data('top');
				if (top == 'T') {
					if(!confirm('是否置顶记录？')){
						return ;
					}
				} else {
				    if(!confirm('是否取消置顶？')){
						return ;
					}
				}
				
				$.ajax({
					url: bopsRoot + '/bops/remote/update_activity_top_ajax.htm',
					type: "post",
					data: {id: id, top: top},
					success: function(result) {
						var json = result ;
						if (json.success) {
							if(confirm('操作成功，是否刷新页面？')) {
								window.location.reload();
							}
						} else {
						    var detail = json.detail;
							if (detail == 'param.error') {
							    alert('参数有误，请刷新页面后再试');
							} else {
							    alert('操作出现错误！');
							}
						}
					},
					error: function(error) {
					    alert("操作出现错误: " + error);
					}
				}) ;
			}) ;
		},
		
		end:0
	});
})(jQuery);

jQuery(document).ready(function(){
	DD.NewsList.init();
});
