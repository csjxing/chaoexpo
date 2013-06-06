!(function($){
	$.namespace("DD.news");
	var self = DD.news;
	var bopsRoot = $("#bopsRoot").val() ;
	var pictureRoot = $("#pictureRoot").val() ;
	
	$.extend(DD.news,{
		
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
		    //校验页面输入
		    return $("#newsForm").validate({
			    rules: {
				    name: {required: true, maxlength: 60},
					gmtPublish: {required: true},
					source: {required: true, maxlength: 60},
					content: {required: true}
				},
				messages: {
				    name: {required: '*', maxlength: '̫��'},
					gmtPublish: {required: '*'},
					source: {required: '*', maxlength: '̫��'},
					content: {required: '*'}
				}
			}).form();
		},
		
		_initFormSubmit: function() {
		    $("#newsForm").submit(function() {
			    if (!self._validateForm()) {
				    return false;
				}
			    var _submitBtn = $("#newsForm").find("input[type='submit']");
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
	DD.news.init();
});
