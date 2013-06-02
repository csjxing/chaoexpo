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
		    self._initPictureDisplay();
		    self._initPictureUpload();
		},
		_initPictureDisplay: function() {
		    $(".pic-box").delegate(".small-picture", "hover", function() {
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
				    _picUploadLayer.find(".error").html("图片地址有误，或图片不是[jpg,jpeg,png,gif,bmp]");
					return ;
				}
				var containerClass = _this.attr('container-class');
				var fieldName = _this.attr("field-name")
				var _container = $("." + containerClass);
				_container.prepend('<li class=""><a class="small-picture" href="javascript:;"></a>'
							          + '<input type="hidden" name="' + fieldName + '" value="' + picUrl + '"/></li>');
				_container.find(".small-picture:first").trigger("hover");
				_picUploadLayer.find(".close-btn").trigger("click");
			});
		    $("#urlPicUploadForm").on("submit", function() {
			    $("#urlPicUploadForm").ajaxSubmit(function(message) {
				    var result = message.result;
					if (result.code=="success") {
					    var pictureRoot = $("#pictureRoot").val();
					    
						disablePopup();
					} else {
						alert("上传失败");
					}
				});
				return false;
			});
			$("#localPicUploadForm").on("submit", function() {
			    $("#localPicUploadForm").ajaxSubmit(function(message) {
				    var result = message.result;
					if (result.code=="success") {
					    var pictureRoot = $("#pictureRoot").val();
					    
						disablePopup();
					} else {
						alert("上传失败");
					}
				});
				return false;
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
