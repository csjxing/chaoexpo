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
			    var _this = $(this);
				var conClassName = _this.attr("data-container-class");
				var fieldName = _this.attr("data-field-name");
				if (conClassName == undefined || conClassName == ''
				    || fieldName == undefined || conClassName == '') {
				    alert('请设置缩略图<ul>元素的class name');
				}
			    _picUploadLayer.find(".confirm-btn").attr("container-class", conClassName);
				_picUploadLayer.find(".confirm-btn").attr("field-name", fieldName);
			    _picUploadLayer.removeClass("dd-hide");
			});
			$(".del-btn").click(function() {
			    var _curLi = $(this).closest("li");
				if (_curLi.size () == 0) {
				    return;
				}
				var picUrl;
				var _picBox = _curLi.closest(".pic-box");
				var _nextLi = _curLi.next();
				if (_nextLi.size() > 0 && _nextLi.find(":hidden").size() > 0) {
				    picUrl = _nextLi.find(":hidden").val();
				} else {
				    _nextLi = _curLi.prev();
					if (_nextLi.size() > 0 && _nextLi.find(":hidden").size() > 0) {
					    picUrl = _nextLi.find(":hidden").val();
					} else {
				        _curLi.remove();
						var _picInput = _picBox.find("input[type='hidden']:first");
						if (_picInput.size() > 0) {
						    _picInput.closest("li").addClass("active");
						    picUrl = _picInput.val();
						}
					}
				}
				_curLi.remove();
				var _bigImg = _picBox.find(".picture img");
				if (picUrl == undefined) {
					_bigImg.remove();
				} else {
				    picUrl = picUrl.startsWith("http://")? picUrl: pictureRoot + picUrl;
				    _bigImg.attr("src", picUrl);
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
				_container.prepend('<li class="sum-pic"><a class="small-picture" href="javascript:;"><img src="' + picUrl + '"/></a>'
							          + '<input type="hidden" name="' + fieldName + '" value="' + picUrl + '"/></li>');
				if ($(".picture img").size() == 0) {
				   $(".picture").append('<img src="' + picUrl + '"/>');
				}
				$(".picture img").attr("src", picUrl);
				_container.find("li.active").removeClass("active");
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
		
		_showPicture: function(_selectLi) {
			_selectLi.closest(".sum-pics").find('li').removeClass("active");
			_selectLi.addClass("active");
			var picUrl = _selectLi.find("input").val();
			if (picUrl == undefined) {
			    return;
			}
			if (!picUrl.startsWith("http://")) {
				picUrl = pictureRoot + picUrl;
			}
			var _picture = _selectLi.closest(".pic-box").find(".picture");
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
