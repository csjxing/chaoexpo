!(function($){
	$.namespace("DD.activity");
	
	var self = DD.activity;
	
	var bopsRoot = $("#bopsRoot").val() ;
	var pictureRoot = $("#pictureRoot").val() ;
	$.extend(DD.activity,{
		
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
		    return $("#activityForm").validate({
			    rules: {
				    name: {required: true, maxlength:60},
					gmtActivityStart: {required: true},
					gmtActivityEnd: {required: true},
					contactName: {required: true, maxlength: 16},
					contactPhone: {maxlength: 32}
				},
				messages: {
				    name: {required: '*', maxlength: '太长'},
					gmtActivityStart: {required: '*'},
					gmtActivityEnd: {required: '*'},
					contactName: {required: '*', maxlength: '太长'},
					contactPhone: {maxlength: '太长'}
				}
			}).form();
		},
		
		_initFormSubmit: function() {
		    $("#activityForm").submit(function() {
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
	DD.activity.init();
});
