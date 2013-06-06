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
		    self._initShowContentDetail();
			self._initCategoryData();
			self._initSubjectData();
			self._initSumPics() ;
		},
		
		/**
		 * 
		 */
		_initSumPics:function(){
			$(".sum-pics li.sum-pic").live("hover", function(event) {
				var _this = $(this);
				$(".pic-box .sum-pics").find("li.active").removeClass("active");
				var picUrl = _this.find(":hidden").val();
				if (!picUrl.startsWith("http://")) {
				    picUrl = pictureRoot + picUrl;
				}
				$(".pic-box .big-pic").find('img').attr('src', picUrl) ;
				_this.addClass('active') ;
			});
		} ,
		
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
		
		end:0
	});
})(jQuery);

jQuery(document).ready(function(){
	DD.Bops.init();
});
