!(function($){
	$.namespace("DD.Login");
	
	$.extend(DD.Login,{
		init:function(){
			if ($.browser.msie && $.browser.version == '6.0') {
			    $('.tb-login-btn').hide();
			}
		},
		end:0
	});
})(jQuery);

jQuery(document).ready(function(){
	DD.Login.init();
});
