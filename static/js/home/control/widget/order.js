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
		
		
		//������ѯ
		_initTrade:function(){
			if($('#ddzPage').val() != 'trade' && $('#ddzPage').val() != 'order') {
				return ;
			}
			
			var form = $("#tradeForm") ;
			form.find(".submit").click(function(){
				var tradeId = form.find("input[name=tradeId]").val() ;
				tradeId = tradeId.trim();
				//û��д�����ţ��򶩵��Ų�Ϊ����
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
		//�������������ʾ
		tradeErrorHint:function(errCode) {
			var form = $("#tradeForm") ;
			$('.hint').addClass('dd-hide') ;
			$('.err-hint').removeClass('dd-hide') ;
			form.addClass('form-err') ;
			if('trade.err.required' == errCode) {
				$('.err-hint').find('.err-msg').html('������Ҫ��ѯ�Ķ������');
			} else if('trade.err.integer' == errCode) {
				$('.err-hint').find('.err-msg').html('��ȷ�Ķ��������һ������');
			} else {
				$('.err-hint').find('.err-msg').html('������Ķ�����Ų���ȷ');
			}
			
		},
		end:0
	});
})(jQuery);

jQuery(document).ready(function(){
	DD.Order.init();
});