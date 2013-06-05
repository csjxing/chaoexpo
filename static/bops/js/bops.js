!(function($){
	$.namespace("DD.Bops");
	
	var self = DD.Bops;
	
	var bopsRoot = $("#bopsRoot").val() ;
	
	$.extend(DD.Bops,{
		init:function(){
		    self._initShowContentDetail();
		    self._initLeftMenu() ;
		},
		
		_initLeftMenu:function() {
			var pathname = window.location.pathname ; 
			var index = pathname.lastIndexOf('/') ;
			var key = pathname.substring(index+1 , pathname.length-4) ;
			
			$('.left_menu .more').each(function(){
				var _this = $(this) ;
				var hasCur = _this.find('#' + key).size() > 0 ;
				if(hasCur) {
					_this.find('.more-btn').addClass('dd-hide') ;
				} else {
					_this.find('li').addClass('dd-hide') ;
					_this.find('.more-btn').removeClass('dd-hide') ;
				}
			}) ;
						
			$('.left_menu li').find('#' + key).addClass('cur') ;
			
			$('.left_menu .more').find('.more-btn').click(function(){
				var _this = $(this) ;
				_this.closest('.more').find('li').removeClass('dd-hide') ;
				_this.addClass('dd-hide') ;
			}) ;
		} ,
		
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
