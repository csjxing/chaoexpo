!(function($){
	$.namespace("DD.Bops");
	
	var self = DD.Bops;
	
	var bopsRoot = $("#bopsRoot").val() ;
	
	$.extend(DD.Bops,{
		
		init:function(){
		    self._initFormSubmit();
		},
		_validateForm: function() {
		    return $("#categoryForm").validate({
			    rules: {
				    catName: {required: true, maxlength: 15}
				},
				messages: {
				    catName: {required: '*', maxlength: '太长'}
				}
			}).form();
		},
		
		_initFormSubmit: function() {
		    $("#categoryForm").submit(function() {
			    if (!self._validateForm()) {
				    return false;
				}
			    var _submitBtn = $(this).find("input[type='submit']");
				var isSubmiting = _submitBtn.attr("data-sub");
				if (isSubmiting == 'y') {
				    return false;
				}
				_submitBtn.attr("data-sub", 'y');
				return true;
			});
		},	
		end:0
	});
})(jQuery);

jQuery(document).ready(function(){
	DD.Bops.init();
});
