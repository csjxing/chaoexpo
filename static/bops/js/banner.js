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
			String.prototype.trim = function() {
				return this.replace(/^\s+/g,"").replace(/\s+$/g,"");
			}
			
		    self._initFormSubmit();
			self._initPicEvent();
		},
		_validateForm: function() {
		    return $("#bannerForm").validate({
			    onsubmit: false,
			    rules: {
				    bannerId: {required: true, maxlength: 32},
					memo: {required: true, maxlength:1000}
				},
				messages: {
				    bannerId: {required: '*', maxlength:'太长'},
					memo: {maxlength:'太长'}
				}
			}).form();
		},
		
		_initFormSubmit: function() {
		    $("#bannerForm").submit(function() {
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
		
		_initPicEvent: function() {
		    var _picDetailBox = $(".banner-box .pic-detail-box");
		    var _picConfigLayer = $("#picConfigLayer");
			_picConfigLayer.find(".close-btn").click(function() {
			    _picConfigLayer.find(".picture-url").val("");
				_picConfigLayer.find(".click-url").val("");
				_picConfigLayer.find(".error").html("");
				_picConfigLayer.addClass("dd-hide")
			});
			_picConfigLayer.find("form").submit(function() {
			    var _this = $(this);
				var picPath;
				if (_this.find(":file").size() > 0) {
				    picPath = _this.find(":file").val();
				} else {
				    picPath = _this.find(":text").val();
				}
				if (picPath == undefined || !self._isValidPicture(picPath)) {
				    _this.find(".error").html("请选择jpg/jpeg/gif/png/bmp类型的图片");
					return false;
				}
				var clickUrl = _this.find(".click-url").val();
				clickUrl = clickUrl.trim().toLowerCase();
				if (clickUrl != '' && !self._isValidLink(clickUrl)) {
				    _this.find(".error").html("链接无效，必须以http://开头");
					return false;
				}
				
				_this.ajaxSubmit(function(result) {
				    var json = result.json;
					var _picBox = $(".pic-detail-box");
					_this.find(".error").html('');
					if (json.success) {
					    var data = json.data;
						if (clickUrl != '') {
						    _picBox.find(".picture").html('<a href="' + clickUrl + '" target="_blank"><img src="' + data.url + '" /></a>'
					    	  + '<div class="url-box"><span>跳转链接：</span><input type="text" class="click-url" value="' + clickUrl + '" />'
					    	  + '<a class="mod-click-url-btn" href="javascript:;" >确认修改</a></div>');
						} else {
						    _picBox.find(".picture").html('<a href="javascript:;"><img src="' + data.url + '" /></a>'
					    	  + '<div class="url-box"><span>跳转链接：</span><input type="text" class="click-url" value="" />'
					    	  + '<a class="mod-click-url-btn" href="javascript:;" >确认修改</a></div>');
						}
						var _container = _picBox.find(".pictures1");
						var _picConfig = new Object();
						_picConfig.picPath = data.path;
						_picConfig.clickUrl = clickUrl;
						var configJson = JSON.stringify(_picConfig);
						_container.prepend('<li class="sum-banner-pic" data-pic-url="' + data.url + '" data-click-url="'
						    + clickUrl + '"><a href="javascript:;" class="small-pic"><img src="' + data.sum100x000 + '" width="40" height="40"/></a>'
							+ '<a class="del-btn del-icon" href="javascript:;" title="删除"></a>'
							+ '<input type="hidden" name="picConfigs" value=\'' + configJson + '\'/></li>')
						_container.find("li").removeClass("active");
						_container.find("li:first").addClass("active");
						_picConfigLayer.find(".close-btn").trigger("click");
					} else {
					    if (json.detail == 'file.null') {
						    _this.find(".error").html('上传失败：未选择有效文件');
						} else if (json.detail == 'file.ext.reject') {
						    _this.find(".error").html('上传失败：只能上传jpg/jpeg/gif/png/bmp类型的图片');
						} else if (json.detail == 'file.ext.reject') {
						    _this.find(".error").html('上传失败：只能上传jpg/jpeg/gif/png/bmp类型的图片');
						}  else if (json.detail == 'file.size.over') {
						    _this.find(".error").html('上传失败：只能上传5M以内的图片');
						}  else if (json.detail == 'file.upload.exception') {
						    _this.find(".error").html('上传失败：系统异常，请联系管理员');
						}  else {
						    _this.find(".error").html('上传失败：未知错误，请联系管理员');
						}
					}
				});
				return false;
			});
			_picDetailBox.find(".picture .click-url").blur(function() {
			    var _this = $(this);
				
			});
			_picDetailBox.find(".del-pic-config-btn").click(function() {
			    var _curLi = $(this).closest("li");
				if (_curLi.size () == 0) {
				    return;
				}
				var _nextLi = _curLi.next();
				if (_nextLi.size() == 0 || !_nextLi.hasClass("sum-banner-pic")) {
				    _nextLi = _curLi.prev();
				}
				if (_nextLi.size() > 0 && _nextLi.hasClass("sum-banner-pic")) {
				    var picUrl = _nextLi.data("pic-url");
					var clickUrl = _nextLi.data("click-url");
					if (!picUrl.startsWith("http://")) {
						picUrl = pictureRoot + picUrl;
					}
					if (clickUrl != '') {
						$(".pic-detail-box .picture").html('<a href="' + clickUrl + '" target="_blank"><img src="' + picUrl + '" /></a>'
						  + '<div class="url-box"><span>跳转链接：</span><input type="text" class="click-url" value="' + clickUrl + '" />'
						  + '<a class="mod-click-url-btn" href="javascript:;" >确认修改</a></div>');
					} else {
						$(".pic-detail-box .picture").html('<a href="javascript:;"><img src="' + picUrl + '" /></a>'
						  + '<div class="url-box"><span>跳转链接：</span><input type="text" class="click-url" value="" />'
						  + '<a class="mod-click-url-btn" href="javascript:;" >确认修改</a></div>');
					}
					_nextLi.addClass("active");
				} else {
				    _picDetailBox.find(".picture").html('');
				}
				_curLi.remove();
			});
			_picDetailBox.find("li.sum-banner-pic").live("hover", function(event) {
			    var _this = $(this);
				$(".pic-detail-box .sum-pics").find("li.active").removeClass("active");
				var picUrl = _this.data("pic-url");
				var clickUrl = _this.data("click-url");
				if (!picUrl.startsWith("http://")) {
				    picUrl = pictureRoot + picUrl;
				}
				if (clickUrl != '') {
					$(".pic-detail-box .picture").html('<a href="' + clickUrl + '" target="_blank"><img src="' + picUrl + '" /></a>'
					  + '<div class="url-box"><span>跳转链接：</span><input type="text" class="click-url" value="' + clickUrl + '" />'
					  + '<a class="mod-click-url-btn" href="javascript:;" >确认修改</a></div>');
				} else {
					$(".pic-detail-box .picture").html('<a href="javascript:;"><img src="' + picUrl + '" /></a>'
					  + '<div class="url-box"><span>跳转链接：</span><input type="text" class="click-url" value="" />'
					  + '<a class="mod-click-url-btn" href="javascript:;" >确认修改</a></div>');
				}
				_this.addClass('active') ;
			});
		    _picDetailBox.find(".add-banner-pic-btn").click(function() {
			    _picConfigLayer.removeClass("dd-hide");
			});
		},
		
		_isValidPicture: function(picUrl) {
		    if (picUrl == undefined) {
			    return false;
			}
		    var temp = picUrl.toString().toLowerCase();
		    return temp.endsWith("jpg") || temp.endsWith("jpeg") || temp.endsWith("gif")
			          ||temp.endsWith("png") || temp.endsWith("bmp");
		},
		
		_isValidLink: function(link) {
		    if (link == undefined) {
			    return false;
			}
		    var temp = link.trim().toLowerCase();
		    return temp.startsWith("http://");
		},
		
		end:0
	});
})(jQuery);

jQuery(document).ready(function(){
	DD.subject.init();
});
