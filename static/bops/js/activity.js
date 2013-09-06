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
			self._initCommonEvent();
			self._initFormSubmit();
		},
		_validateForm: function() {
		    return $("#activityForm").validate({
			    rules: {
				    name: {required: true, maxlength:60},
					gmtActivityStart: {required: true},
					gmtActivityEnd: {required: true},
					contactName: {maxlength: 16},
					contactPhone: {maxlength: 32}
				},
				messages: {
				    name: {required: '*', maxlength: '太长'},
					gmtActivityStart: {required: '*'},
					gmtActivityEnd: {required: '*'},
					contactName: {maxlength: '太长'},
					contactPhone: {maxlength: '太长'}
				}
			}).form();
		},
		_initCommonEvent: function() {
			var selectedIndex;
			$("#activityForm").find('select.can-signup').click(function() {
			    selectedIndex = $(this).get(0).selectedIndex;
			});
		    $("#activityForm").find('select.can-signup').change(function() {
		        var id = $("#activityForm").find('input[name="id"]').val();
		        if (id == undefined || isNaN(parseInt(id))) {
		            return;
		        }
		        var _this = $(this);
				var value = _this.children("option:selected").val();
				if(value == 'N' && !confirm("此修改最终将导致原活动参与数据失效，确定修改？")) {
				    _this.get(0).selectedIndex = selectedIndex;
				    return;
				}
		    });
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
