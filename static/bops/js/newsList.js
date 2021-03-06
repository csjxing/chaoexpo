﻿!(function($){
	$.namespace("DD.NewsList");
	
	var self = DD.NewsList;
	
	var bopsRoot = $("#bopsRoot").val() ;
	
	$.extend(DD.NewsList, {
		
		init:function(){
		    self._initEvent();
		},
		
		_initEvent: function() {
		    $("#newsTable ul.btn-list").mouseleave(function() {
			    $(this).addClass("dd-hide");
			});
		    $("#newsTable .lbl-btn").click(function() {
			    var _this = $(this);
				var _btnList = _this.closest(".btn-box").find(".btn-list");
				$("#newsTable .btn-box .btn-list").addClass("dd-hide");
				_btnList.toggleClass("dd-hide");
			});
		    $("select[name='isTop']").change(function() {
			    var _this = $(this);
				var top = _this.children("option:selected").val();
				var id = _this.closest("tr").attr("data-id");
				if (id == undefined || isNaN(id)) {
				    alert("新闻id有误:" + id);
					return ;
				}
				$.ajax({
				    url: bopsRoot + '/bops/remote/reset_news_top.htm',
					type: "post",
					data: {id: id, top: top},
					success: function(result) {
					    var json = result.json;
						if (json.success) {
						    window.location.reload();
						} else {
						    var detail = json.detail;
							if (detail == 'param.error') {
							    alert('参数有误, id：'　+ id + ", top: " + top);
							} else if (detail == 'news.not.exist') {
							    alert('新闻id不存在, id：'　+ id);
							} else {
							    alert('未知错误');
							}
						}
					},
					error: function(error) {
					    alert("新闻置顶失败: " + error);
					}
				})
			});
			$('#newsTable .move-first-btn').click(function() {
			    var _this = $(this);
				var id = _this.closest("tr").attr("data-id");
				if (id == undefined || isNaN(id)) {
				    alert("新闻id有误:" + id);
					return ;
				}
				$.ajax({
				    url: bopsRoot + '/bops/remote/reset_news_display_order.htm',
					type: "post",
					data: {id: id},
					success: function(result) {
					    var json = result.json;
						if (json.success) {
						    window.location.reload();
						} else {
						    var detail = json.detail;
							if (detail == 'param.error') {
							    alert('参数有误, id：'　+ id);
							} else if (detail == 'news.not.exist') {
							    alert('新闻id不存在, id：'　+ id);
							} else {
							    alert('未知错误');
							}
						}
					},
					error: function(error) {
					    alert("新闻置顶失败: " + error);
					}
				})
			});
			$("#newsTable .delete-btn").click(function() {
			    var _this = $(this);
				var id = _this.data('id');
				var status = _this.data('status');
				if (status == 'N') {
					if(!confirm('是否启用新闻？')){
						return ;
					}
				} else {
				    if(!confirm('是否删除新闻？')){
						return ;
					}
				}
				if (id == undefined || isNaN(parseInt(id))) {
				    alert('ID有误，请刷新页面后再试。');
					return ;
				}
				$.ajax({
					url: bopsRoot + '/bops/remote/reset_news_status.htm',
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
					    alert("删除新闻失败: " + error);
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
