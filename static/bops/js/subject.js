!(function($){
	$.namespace("DD.subject");
	
	var self = DD.subject;
	
	var bopsRoot = $("#bopsRoot").val() ;
	var pictureRoot = $("#pictureRoot").val() ;
	$.extend(DD.subject,{
		
		init:function(){
		    String.prototype.startsWith = function(str) {
			    return this.indexOf(str) == 0;
			};
			String.prototype.endsWith = function(str) {
			    return this.indexOf(str) == (this.length - str.length);
			};
		    self._initFormSubmit();
		},
		_validateForm: function() {
		    return $("#subjectForm").validate({
			    onsubmit: false,
			    rules: {
				    name: {required: true, maxlength: 50},
					webUrl: {required: true, maxlength:256}
				},
				messages: {
				    name: {required: '*', maxlength:'太长'},
					webUrl: {maxlength:'太长'}
				}
			}).form();
		},
		
		_initFormSubmit: function() {
		    $("#subjectForm").submit(function() {
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
	DD.subject.init();
});
