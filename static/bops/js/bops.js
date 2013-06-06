!(function($){
	$.namespace("DD.Bops");
	
	var self = DD.Bops;
	
	var bopsRoot = $("#bopsRoot").val() ;
	var pictureRoot = $("#pictureRoot").val() ;
	
	$.extend(DD.Bops,{
		init:function(){
		    String.prototype.startsWith = function(str) {
			    return this.indexOf(str) == 0;
			};
			String.prototype.endsWith = function(str) {
			    return this.indexOf(str) == (this.length - str.length);
			};
		    self._initLeftMenu();
			//self._registCommonEvent();
		    self._initShowContentDetail();
			self._initCategoryData();
			self._initSubjectData();
			//新增中，pic-detail-box.vm的事件.
			self._initCreateObjPictureEvent();
		},
		
		_initLeftMenu:function() {
			var pathname = window.location.pathname ; 
			var index = pathname.lastIndexOf('/') ;
			var key = pathname.substring(index+1 , pathname.length-4) ;
			
			$('.left_menu .more').each(function(){
				var _this = $(this) ;
				var hasCur = _this.find('#' + key).size() > 0 ;
				if(hasCur) {
					_this.find('.more-btn').addClass('dd-hide') ;
				} else {
					_this.find('li').addClass('dd-hide') ;
					_this.find('.more-btn').removeClass('dd-hide') ;
				}
			}) ;
						
			$('.left_menu li').find('#' + key).addClass('cur') ;
			
			$('.left_menu .more').find('.more-btn').click(function(){
				var _this = $(this) ;
				_this.closest('.more').find('li').removeClass('dd-hide') ;
				_this.addClass('dd-hide') ;
			}) ;
		} ,
		
		_registCommonEvent: function() {
		    var _picUploadLayer = $("#pictureUploadLayer");
		    $(document).bind("pictrueUpload", function() {
			    
			});
		},
		
		_initShowContentDetail: function() {
		    $("[detail-content]").hover(function() {
			    var _this = $(this);
				var content = _this.attr("detail-content");
				if (content == undefined || content == '') {
				    return;
				}
				_td = _this.closest("td");
				_td.css({"position":"relative"});
				var _detailLayer = _td.find(".detail-layer");
				if (_detailLayer.size() == 0) {
				    _td.append('<div class="detail-layer dd-hide">' + content + '</div>');
					_detailLayer = _td.find(".detail-layer");
				}
				_detailLayer.css({top: (_td.height() - _detailLayer.height())/2, left: _td.width()});
				_detailLayer.removeClass("dd-hide");
			}, function() {
			    _td.find(".detail-layer").addClass("dd-hide");
			});
		},
		_initCategoryData: function() {
		    var isInit = true;
		    $('[data-category-id]').each(function() {
				if ($(this).attr("data-init") != 'y') {
				    isInit = false;
				}
			});
			if (!isInit) {
			    $.ajax({
				    url: bopsRoot + '/bops/remote/query_categories.htm',
					type: "post",
					data: {},
					success: function(result) {
					    var json = result.json;
						if (!json.success || json.data.length == 0) {
						    return;
						}
						var data = json.data;
						$('[data-category-id]').each(function() {
							var _this = $(this);
							if (_this.attr("data-init") != 'y') {
								var categoryId = parseInt(_this.attr("data-category-id"));
								var tagName = _this.prop("tagName");
								if (tagName == 'SELECT') {
									for (var i = 0; i < data.length; i++) {
								        _this.append('<option value="0">无</option>');
									    if (data[i].id != categoryId) {
											_this.append('<option value="' + data[i].id + '">' + data[i].name + '</option>');
										} else {
										    _this.append('<option value="' + data[i].id + '" selected>' + data[i].name + '</option>');
										}
									}
									_this.attr('data-init', 'y');
								} else if(tagName == 'SPAN' || tagName == 'DIV') {
								    for (var i = 0; i < data.length; i++) {
									    if (categoryId == data[i].id) {
										    _this.html(data[i].name);
										}
									}
								}
							}
						});
					}
				});
			}
		},
		_initSubjectData: function() {
		    var isInit = true;
		    $('[data-subject-id]').each(function() {
				if ($(this).attr("data-init") != 'y') {
				    isInit = false;
				}
			});
			if (!isInit) {
			    $.ajax({
				    url: bopsRoot + '/bops/remote/query_subjects.htm',
					type: "post",
					data: {},
					success: function(result) {
					    var json = result.json;
						if (!json.success || json.data.length == 0) {
						    return;
						}
						var data = json.data;
						$('[data-subject-id]').each(function() {
							var _this = $(this);
							if (_this.attr("data-init") != 'y') {
								var subjectId = parseInt(_this.attr("data-subject-id"));
								var tagName = _this.prop("tagName");
								if (tagName == 'SELECT') {
								    _this.append('<option value="0">无</option>');
									for (var i = 0; i < data.length; i++) {
									    if (data[i].id != subjectId) {
											_this.append('<option value="' + data[i].id + '">' + data[i].name + '</option>');
										} else {
										    _this.append('<option value="' + data[i].id + '" selected>' + data[i].name + '</option>');
										}
									}
									_this.attr('data-init', 'y');
								} else if(tagName == 'SPAN' || tagName == 'DIV') {
								    for (var i = 0; i < data.length; i++) {
									    if (subjectId == data[i].id) {
										    _this.html(data[i].name);
										}
									}
								}
							}
						});
					}
				});
			}
		},
		_initCreateObjPictureEvent: function() {
		    //缩略图hover事件.
			$(".sum-pics li.sum-pic").live("hover", function(event) {
				var _this = $(this);
				$(".pic-detail-box .sum-pics").find("li.active").removeClass("active");
				var picUrl = _this.find(":hidden").val();
				if (!picUrl.startsWith("http://")) {
				    picUrl = pictureRoot + picUrl;
				}
				$(".pic-detail-box .big-pic").find('img').attr('src', picUrl) ;
				_this.addClass('active') ;
			});
		    var _picUploadLayer = $("#pictureUploadLayer");
			//添加图片事件.
		    $(".add-pic-btn").click(function() {
			    var _this = $(this);
				var conClassName = _this.attr("data-container-class");
				var fieldName = _this.attr("data-field-name");
				if (conClassName == undefined || conClassName == ''
				    || fieldName == undefined || conClassName == '') {
				    alert('请设置添加按钮的"data-container-class"和"data-field-name"属性');
					return;
				}
			    _picUploadLayer.find("form").attr("container-class", conClassName);
				_picUploadLayer.find("form").attr("field-name", fieldName);
			    _picUploadLayer.removeClass("dd-hide");
			});
			//删除图片事件.
			$(".del-btn").click(function() {
			    var _curLi = $(this).closest("li");
				if (_curLi.size () == 0) {
				    return;
				}
				var picUrl;
				var _picBox = _curLi.closest(".pic-detail-box");
				var _nextLi = _curLi.next();
				if (_nextLi.size() > 0 && _nextLi.find(":hidden").size() > 0) {
				    picUrl = _nextLi.find(":hidden").val();
					_nextLi.addClass("active");
				} else {
				    _nextLi = _curLi.prev();
					if (_nextLi.size() > 0 && _nextLi.find(":hidden").size() > 0) {
					    picUrl = _nextLi.find(":hidden").val();
						_nextLi.addClass("active");
					} else {
				        _curLi.remove();
						var _picInput = _picBox.find("input[type='hidden']:first");
						if (_picInput.size() > 0) {
						    _nextLi = _picInput.closest("li").addClass("active");
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
			_picUploadLayer.find("form").submit(function() {
			    var _this = $(this);
				var picPath;
				if (_this.find(":file").size() > 0) {
				    picPath = _this.find(":file").val();
				} else {
				    picPath = _this.find(":text").val();
				}
				var containerClass = _this.attr('container-class');
				var fieldName = _this.attr('field-name');
				if (containerClass == undefined || containerClass == '' ||
				    fieldName == undefined || fieldName == '') {
					_this.find(".error").html("请设置field-name和container-class");
					return false;
				}
				if (picPath == undefined || !self._isValidPicture(picPath)) {
				    _this.find(".error").html("请选择jpg/jpeg/gif/png/bmp类型的图片");
					return false;
				}
				_this.ajaxSubmit(function(result) {
				    var json = result.json;
					_this.find(".error").html('');
					if (json.success) {
					    var data = json.data;
						var _picBox = $(".pic-detail-box");
						var _container = _picBox.find("." + containerClass);
						_container.prepend('<li class="sum-pic"><a class="small-picture" href="javascript:;"><img src="' + data.sum100x000 + '"/></a>'
											  + '<input type="hidden" name="' + fieldName + '" value="' + data.path + '"/>'
											  + '<a class="del-btn del-icon" href="javascript:;" title="删除"></a></li>');
						if (_picBox.find(".picture img").size() == 0) {
						   _picBox.find(".picture").append('<img src="' + data.url + '"/>');
						}
						$(".picture img").attr("src", data.url);
						_container.closest(".sum-pics").find("li.active").removeClass("active");
						_container.find("li:first").addClass("active");
						_picUploadLayer.find(".close-btn").trigger("click");
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
			/**
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
							          + '<input type="hidden" name="' + fieldName + '" value="' + picUrl + '"/>'
									  + '<a class="del-btn del-icon" href="javascript:;" title="删除"></a></li>');
				if ($(".picture img").size() == 0) {
				   $(".picture").append('<img src="' + picUrl + '"/>');
				}
				$(".picture img").attr("src", picUrl);
				_container.closest(".sum-pics").find("li.active").removeClass("active");
				_container.find("li:first").addClass("active");
				_picUploadLayer.find(".close-btn").trigger("click");
			});
			**/
		},
		_isValidPicture: function(picUrl) {
		    var temp = picUrl.toString().toLowerCase();
		    return temp.endsWith("jpg") || temp.endsWith("jpeg") || temp.endsWith("gif")
			          ||temp.endsWith("png") || temp.endsWith("bmp");
		},
		
		end:0
	});
})(jQuery);

jQuery(document).ready(function(){
	DD.Bops.init();
});
