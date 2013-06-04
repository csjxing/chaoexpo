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
			self._initFieldRequird();
		    self._initPictureDisplay();
		    self._initPictureUpload();
			self._initFormSubmit();
		},
		_initFieldRequird: function() {
		    $("#activityForm").validate({
			    rules: {
				    name: {required: true},
					gmtActivity: {required: true},
					contactName: {required: true},
					contactPhone: {required: true, number: true, rangelength: [11,11]}
				},
				messages: {
				    name: {required: '*'},
					gmtActivity: {required: '*'},
					contactName: {required: '*'},
					contactPhone: {required: '*', number: '无效号码', rangelength:'无效号码'}
				}
			});
		},
		_initPictureDisplay: function() {
		    $(document).delegate(".small-picture", "hover", function() {
			    alert("test");
			    var _this = $(this);
				_this.closest(".pic-box").find('li').removeClass("active");
				_this.closest("li").addClass("active");
				var picUrl = _this.closest("li").find("input").val();
				if (!picUrl.startsWith("http://")) {
				    picUrl = pictureRoot + picUrl;
				}
				var _picture = _this.closest(".pic-box").find(".picture");
				if (_picture.find("img").size() > 0) {
				    _picture.find("img").attr("src", picUrl);
				} else {
				    _picture.append('<img src=' + picUrl + '/>')
				}
			});
		},
		
		_initPictureUpload: function() {
		    var _picUploadLayer = $("#pictureUploadLayer");
		    $(".add-pic-btn").click(function() {
			    _picUploadLayer.find(".confirm-btn").attr("container-class", 'pics');
				_picUploadLayer.find(".confirm-btn").attr("field-name", 'picUrlList');
			    _picUploadLayer.removeClass("dd-hide");
			});
			$(".add-stand-pic-btn").click(function() {
			    _picUploadLayer.find(".confirm-btn").attr("container-class", 'stand-pics');
				_picUploadLayer.find(".confirm-btn").attr("field-name", 'standPicUrlList');
			    _picUploadLayer.removeClass("dd-hide");
			});
			_picUploadLayer.find(".close-btn").click(function(){
			    _picUploadLayer.find(".error").html('');
				_picUploadLayer.find(".picture-url").val('');
			    _picUploadLayer.addClass("dd-hide");
			});
			_picUploadLayer.find(".confirm-btn").click(function() {
			    var _this = $(this);
				var picUrl = $(".picture-url").val();
				if (!self._isLegalPicUrl(picUrl)) {
				    _picUploadLayer.find(".error").html("图片链接有误，或图片类型不是[jpg,jpeg,png,gif,bmp]");
					return ;
				}
				var containerClass = _this.attr('container-class');
				var fieldName = _this.attr("field-name")
				var _container = $("." + containerClass);
				_container.prepend('<li class=""><a class="small-picture" href="javascript:;"><img src="' + picUrl + '"/></a>'
							          + '<input type="hidden" name="' + fieldName + '" value="' + picUrl + '"/></li>');
				if ($(".picture img").size() == 0) {
				   $(".picture").append('<img src="' + picUrl + '"/>');
				}
				$(".picture img").attr("src", picUrl);
				$(".pictures li").removeClass("active");
				_container.find("li:first").addClass("active");
				_picUploadLayer.find(".close-btn").trigger("click");
			});
		},
		_initFormSubmit: function() {
		    $("#activityForm").submit(function() {
			    var isHidden = true;
			    $("#activityForm").find("label.error").each(function() {
				    isHidden = isHidden && $(this).is(":hidden");
				});
				if (!isHidden) {
				    return false;
				}
			    var submitBtn = $("#activityForm").find("input[type='submit']");
				var isSubmiting = submitBtn.attr("data-sub");
				if (isSubmiting == 'y') {
				    return false;
				}
				submitBtn.attr("data-sub", 'y');
				return true;
			});
		},
		_isLegalPicUrl: function(picUrl) {
		    var temp = picUrl.toString();
		    return temp.startsWith("http://") && (temp.endsWith("jpg") || temp.endsWith("jpeg")
			          ||temp.endsWith("png") || temp.endsWith("bmp"));
		},
		end:0
	});
})(jQuery);

jQuery(document).ready(function(){
	DD.activity.init();
});
