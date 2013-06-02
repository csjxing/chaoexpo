!(function($){
	$.namespace("DD.Bops");
	
	var self = DD.Bops;
	
	var bopsRoot = $("#bopsRoot").val() ;
	
	$.extend(DD.Bops,{
		
		init:function(){
		
		},
				
		end:0
	});
})(jQuery);

jQuery(document).ready(function(){
	DD.Bops.init();
});
