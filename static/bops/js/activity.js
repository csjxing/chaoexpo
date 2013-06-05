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
				    name: {required: true, maxlength:60},
					gmtActivity: {required: true},
					contactName: {required: true, maxlength: 16},
					contactPhone: {required: true, number: true, rangelength: [11,11]}
				},
				messages: {
				    name: {required: '*', maxlength: '太长'},
					gmtActivity: {required: '*'},
					contactName: {required: '*', maxlength: '太长'},
					contactPhone: {required: '*', number: '无效号码', rangelength:'无效号码'}
				}
			});
		},
		
		_initPictureDisplay: function() {
		    $(".pictures .small-picture").hover(function() {
			    var _this = $(this);
				self._showPicture(_this.closest("li"));
			}, function() {});
		},
		
		_initPictureUpload: function() {
		    var _picUploadLayer = $("#pictureUploadLayer");
		    $(".add-pic-btn").click(function() {
			    _picUploadLayer.find(".confirm-btn").attr("container-class", 'bottom-pics');
				_picUploadLayer.find(".confirm-btn").attr("field-name", 'picUrlList');
			    _picUploadLayer.removeClass("dd-hide");
			});
			$(".add-stand-pic-btn").click(function() {
			    _picUploadLayer.find(".confirm-btn").attr("container-class", 'right-pics');
				_picUploadLayer.find(".confirm-btn").attr("field-name", 'standPicUrlList');
			    _picUploadLayer.removeClass("dd-hide");
			});
			$(".delete-pic-btn").click(function() {
			    var _activeLi = $(".pictures").find("active");
				if (_activeLi.size() == 0) {
				    return;
				}
				var _preLi = _activeLi.prev();
				if (_preLi.size() == 1) {
				    _preLi.addClass("active");
				}
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
				var _newLi = _container.find("li:first");
				_newLi.addClass("active");
				_newLi.hover(function() {
					self._showPicture(_newLi);
				}, function() {});
				self._showPicture(_newLi);
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
		
		_showPicture: function(_selectLi) {
			var _this = $(this);
			$(".pictures").find('li').removeClass("active");
			_selectLi.addClass("active");
			var picUrl = _selectLi.find("input").val();
			if (!picUrl.startsWith("http://")) {
				picUrl = pictureRoot + picUrl;
			}
			var _picture = $(".pic-box .picture");
			if (_picture.find("img").size() > 0) {
				_picture.find("img").attr("src", picUrl);
			} else {
				_picture.append('<img src=' + picUrl + '/>')
			}
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
