!(function($){
	$.namespace("DD.Bops");
	
	var self = DD.Bops;
	
	var bopsRoot = $("#bopsRoot").val() ;
	
	$.extend(DD.Bops,{
		init:function(){
		    self._initShowContentDetail();
		},
		_initShowContentDetail: function() {
		    $("table").find(".content-detail").hover(function() {
			    var _this = $(this);
				var content = _this.attr("data-content");
				if (content == undefined || content == '') {
				    return;
				}
				_td = _this.closest("td");
				_td.css({"position":"relative"});
				var _detailLayer = _td.find(".detail-layer");
				if (_detailLayer.size() == 0) {
				    _td.append('<div class="detail-layer dd-hide">' + content + '</div>');
					_detailLayer = _td.find(".detail-layer");
				}
				_detailLayer.css({top: (_td.height() - _detailLayer.height())/2, left: _td.width()});
				_detailLayer.removeClass("dd-hide");
			}, function() {
			    _td.find(".detail-layer").addClass("dd-hide");
			});
		},
		
		end:0
	});
})(jQuery);

jQuery(document).ready(function(){
	DD.Bops.init();
});
