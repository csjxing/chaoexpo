!(function($){
	$.namespace("DD.Order");
	
	var self = DD.Order;
	
	var ddzRoot	= $("#ddzRoot").val() ;

	$.extend(DD.Order,{
		
		init:function(){
			String.prototype.trim = function(){
			    return this.replace(/(^\s*)|(\s*$)/g, "");
			}
			if (window.location.href.indexOf("order") == -1) {
			    return;
			}
			self._initTrade();
		},
		
		
		//订单查询
		_initTrade:function(){
			if($('#ddzPage').val() != 'trade' && $('#ddzPage').val() != 'order') {
				return ;
			}
			
			var form = $("#tradeForm") ;
			form.find(".submit").click(function(){
				var tradeId = form.find("input[name=tradeId]").val() ;
				tradeId = tradeId.trim();
				//没填写订单号，或订单号不为数字
				if(tradeId == '') {
					self.tradeErrorHint('trade.err.required') ;
					return ;
				}
				if(!tradeId.match(/^\d+$/)) {
					self.tradeErrorHint('trade.err.integer') ;
					return ;
				}
				var _searchBtn = form.find('#searchBtn');
				$("#xbox-overlay").removeClass('dd-hide');
				$("#loadingBox").removeClass("dd-hide");
				form.find("#searchBtn").click();
				return false;
			}) ;
			
			form.find("input[name=tradeId]").focus(function(){
				form.removeClass('form-err') ;
				$('.hint').removeClass('dd-hide') ;
				$('.err-hint').addClass('dd-hide') ;
			}) ;
			form.find("input[name=tradeId]").keypress(function(){
			    if (event.keyCode==13) {
				    form.find(".submit").click();
				    return false;
				}
			});
		},
		//订单输入错误提示
		tradeErrorHint:function(errCode) {
			var form = $("#tradeForm") ;
			$('.hint').addClass('dd-hide') ;
			$('.err-hint').removeClass('dd-hide') ;
			form.addClass('form-err') ;
			if('trade.err.required' == errCode) {
				$('.err-hint').find('.err-msg').html('请输入要查询的订单编号');
			} else if('trade.err.integer' == errCode) {
				$('.err-hint').find('.err-msg').html('正确的订单编号是一串数字');
			} else {
				$('.err-hint').find('.err-msg').html('您输入的订单编号不正确');
			}
			
		},
		end:0
	});
})(jQuery);

jQuery(document).ready(function(){
	DD.Order.init();
});