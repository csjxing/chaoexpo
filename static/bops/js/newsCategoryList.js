!(function($){
	$.namespace("DD.NewsList");
	
	var self = DD.NewsList;
	
	var bopsRoot = $("#bopsRoot").val() ;
	
	$.extend(DD.NewsList, {
		
		init:function(){
		    self._initEvent();
		},
		
		_initEvent: function() {
		    $("select[name='status']").change(function() {
			    var _this = $(this);
				var status = _this.children("option:selected").val();
				var id = _this.closest("tr").attr("data-id");
				if (id == undefined || isNaN(id)) {
				    alert("新闻id有误:" + id);
					return ;
				}
				$.ajax({
				    url: bopsRoot + '/bops/remote/reset_news_category_status.htm',
					type: "post",
					data: {id: id, status: status},
					success: function(result) {
					    var json = result.json;
						if (json.success) {
						    window.location.reload();
						} else {
						    var detail = json.detail;
							if (detail == 'param.error') {
							    alert('参数有误, id：'　+ id + ", top: " + top);
							} else if (detail == 'category.not.exist') {
							    alert("分类id不存在, id："　+ id);
							} else {
							    alert('未知错误');
							}
						}
					},
					error: function(error) {
					    alert("分类置顶失败: " + error);
					}
				})
			});
		},
		
		end:0
	});
})(jQuery);

jQuery(document).ready(function(){
	DD.NewsList.init();
});
