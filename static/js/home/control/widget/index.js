!(function($){
	$.namespace("DD.Index");
	var taobaoRecommend = 'http://item.taobao.com/item.htm?id=20138548730' ; //淘宝推荐
	var self = DD.Index;

	$.extend(DD.Index,{
		Email_Regex : /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/,
		Mobile_Regex : /^1\d{10}$/,
		init:function(){
			self._initSearchEvent();
			self._initChangeAlipay();
			self._initSubmitAlipay() ;
			self._initDdzIndex() ;
			self._initNewGuide();
			self._initRegisterDoneGuide() ;
			self._initSaveDiandianzhe() ;
			//初始化 google track
			self._initGtrack();
			//查询促销价格
			self._initQueryPromotion();
			
			/**
			 * 提现规则修改通知
			 */
			self._initTixian();
			self._initVideoEvent() ;
			
			//self._initShareAwardTips();
			self._initDdDialog();
			self._initPlaceholder();
			self._init99();
			self._initMenu();
			self._initRedirectGo() ;
		},
		
		_initDdzIndex:function(){
			$('.ddz-index-main .item-list').find('li').hover(function(){
				$(this).addClass("on") ;
			} , function(){
				$(this).removeClass("on") ;
			}) ;
			
			$('.ddz-index-main .channels').find('li').hover(function(){
				$(this).addClass("on") ;
			} , function(){
				$(this).removeClass("on") ;
			}) ;
		} ,
		
		_initRedirectGo:function(){
			var alipayForm = $('.redirect-go #go_alipay_form') ;
			if(alipayForm.size() == 0){
				return ;
			}
			
			self.centerPoint($('.redirect-go .fancybox-wrap'))
			
			var errLayer = alipayForm.find('.alipay-err-layer') ;
			//我的点点折
			alipayForm.on('submit',function(e){
				var alipayId = alipayForm.find("input[name='alipayId']").val() ;
				var validateResult = self.validateAlipay(alipayId);
				if(validateResult == '') {
					
					var ddzRoot = $("#ddzRoot").val() ;
					//ajax提交支付宝
					$.ajax({
						url : ddzRoot + '/zhe/remote/rest/setAlipay.htm',
						data : {alipayId:alipayId} , 
						type : "POST" ,
						async : false ,
						success : function(data){
							
						} ,
						error : function(data){
							
						}
					}) ;
					
					return true ;
					
				} else if(validateResult == 'alipay.required') {
					errLayer.find('.err-msg').html('请输入接收返利的支付宝账号') ;
				} else if(validateResult == 'alipay.format.error') {
					errLayer.find('.err-msg').html('输入支付宝格式错误，请检查格式是否为邮箱地址或手机号') ;
				} else if(validateResult == 'alipay.notExists') {
					errLayer.find('.err-msg').html('您输入的支付宝不存在，请检查输入是否正确') ;
				} else {
					errLayer.find('.err-msg').html('输入支付宝格式错误，请检查格式是否为邮箱地址或手机号') ;
				}
				alipayForm.addClass('form-err') ;
				errLayer.show() ;
				return false ;
			});
			
			
			alipayForm.find('.alipay-submit').on('click',function(){
				//兼容IE6不支持a提交表单
				alipayForm.find("#hiddenSubmit").click() ;
				return false ;
			});
			
			//取得焦点时隐藏错误提示
			alipayForm.find("input[name='alipayId']").focus(function(){
				errLayer.hide() ;
				alipayForm.removeClass('form-err') ;
			});
		} ,
		
		/**
		 * alipay输入框
		 */
		_initAlipayInput:function(){
			$('.alipay-text-buy #alipayInput').keyup(function(){
				var _this = $(this) ;
				var alipayId = _this.val() ;
				if(alipayId.match(self.Email_Regex)){
					_this.closest(".ddz-index-alipay").find('.item-buy-url').removeClass('disable');
				} else {
					_this.closest(".ddz-index-alipay").find('.item-buy-url').addClass('disable');
				}
			}) ;
		} ,
		
		_initMenu:function(){
			$('.ddz .menu').find('li').hover(function(){
				$(this).addClass('active') ;
			} , function(){
				if(!$(this).hasClass('cur')) {
					$(this).removeClass('active') ;
				}
			}) ;
			
			$('.ddz .user-center').hover(function(){
				$(this).addClass('active') ;
			} , function(){
				if(!$(this).hasClass('cur')) {
					$(this).removeClass('active') ;
				}
			}) ;
			
			$('.ddz .top-cs').hover(function(){
				$(this).find('.cs-bg').removeClass('dd-hide') ;
				$(this).addClass('active') ;
			} , function(){
				$(this).find('.cs-bg').addClass('dd-hide') ;
				$(this).removeClass('active') ;
			}) ;
		} ,
		
		_init99:function(){
			$('.ddz .index-tuan').addClass('dd-hide') ;
		} ,
		
		/**
		 * 
		 */
		_initVideoEvent:function(){
			$('.ui-video-xbox .close-flash-xbox').click(function(){
				$(".ui-video-xbox").addClass('dd-hide') ;
				$("#shadow-overlay").addClass('dd-hide') ;
			}) ;
			
			//集分宝视频
			$(".dd-item-main .jfb-study-video").click(function(){
				$('.ui-video-xbox .flash-src').attr('src','https://hi.alipay.com/cms/huohaier/jfb_flash.swf');
				$('.ui-video-xbox .flash-src').attr('value','https://hi.alipay.com/cms/huohaier/jfb_flash.swf');
				$('.ui-video-xbox').removeClass('dd-hide');
				$('#shadow-overlay').removeClass('dd-hide');
			}) ;
		} ,
		
		/**
		 * 返利体现点这儿
		 */
		_initTixian:function(){			
			if($(".tuan-list").size() == 0){
				$(".menu .user-center").find('.tixian').delay(500)
					.animate({top:'-=4'},200, "linear").animate({top:'+=4'},200, "linear").animate({top:'-=4'},200, "linear").animate({top:'+=4'},200, "linear")
					.animate({top:'-=4'},200, "linear").animate({top:'+=4'},200, "linear");
			} 
		} ,
		
		
		/**
		 * 对话框
		 */
		_initDdDialog:function(){
			//对话框关闭事件
			$("[data-dialogClose]").click(function(){
				var dialog = $(this).attr("data-dialogClose");
				self.ddDialog(dialog,false) ;
			});
			
			$("#ddDialogOverlay").css("height",$(document).height());
		} ,
		
		ddDialog:function(id,isShow){
			if(isShow == false){
				$("#"+id).addClass("dd-hide") ;
				$("#ddDialogOverlay").addClass("dd-hide") ;
			}else{
				
				var winWidth = $("#"+id).width();
				var winHeight = $("#"+id).height() ;
				var clientWidth = $(window).width();
				var clientHeight = $(window).height();
				var top =  (clientHeight - winHeight)/2 + $(document).scrollTop() ;
				var left = (clientWidth - winWidth)/2 + $(document).scrollLeft() ;
				$("#"+id).css("top" , top < 0 ? 0 : top );
				$("#"+id).css("left", left < 0 ? 0 : left  );
				
				$("#"+id).removeClass("dd-hide") ;
				$("#ddDialogOverlay").removeClass("dd-hide") ;
				
			}
		},
		
		/**
		 * 查询促销价格
		 */
		_initQueryPromotion:function(){
			var domain = $("#domain").val() ;
			if(domain == "ju.taobao.com" || domain == "www.juhuasuan.com"){
				return ;
			}
			var itemId = $("#itemId").val() ;
			var userCommissionRate = $("#userCommissionRate").val() ;
			var ddzRoot = $("#ddzRoot").val() ;
			if(typeof(itemId) != 'undefined' && itemId != '' &&
					typeof(userCommissionRate) != 'undefined' && userCommissionRate != '' && ddzRoot != ''){
				$.ajax({
						url : ddzRoot + '/zhe/remote/rest/query_promotion.htm',
						data : {userCommissionRate:userCommissionRate,id:itemId} , 
						type : "POST" ,
						success : function(data){
							try {
								var code = data.json.code ;
								if(code == 'success'){
									var result = data.json.data ; 
									if(result.hasPromotion){
										$("[data-originPrice]").html(result.promotionPriceFormat) ;
										$("[data-userCommission]").html(result.userJfbByMoneyFormat);
										$(".item-price-view .rumour").hide() ;
									} else {
										//没有促销价
									}
								} else {
								    //$(".item-price-view").append('<div class="select-tips" style="opacity: 1; "><div class="content">购买价格以店铺价格为准哦~</div><div class="angle-top" style="top: -7px;left:140px;"></div></div>');
								}
							}catch(e){
								
							}
							
						} ,
						error : function(data){
							
						}
					});
			}
		} , 
		
		_initShareAwardTips:function(){
			if($('#userGuide').val() != "true") { //没有新手指导的时候
			  	$('#social_button_tips').fadeIn(1500).removeClass("dd-hide");
			}
			$("#item-price-discount-allowance-gift").hover(
					function(){
						$('#allowance_gift_tips').fadeIn(1000).removeClass("dd-hide");
					},
					function(){
						$('#allowance_gift_tips').hide();
					}
			);
		},
		_initChangeAlipay:function(){
			$("#change_alipay").on('click',function(){
				$(".alipay-area-ipt").removeClass('dd-hide') ;
				$(".alipay-area-view").addClass('dd-hide') ;
				
			}) ;
			
			$(".alipay-ipt-back-click").click(function(){
				$(".alipay-area-ipt").addClass('dd-hide') ;
				$(".alipay-area-view").removeClass('dd-hide') ;
				$(".alipay-err-layer").hide() ;
			}) ;
		},
		
		_initSubmitAlipay:function(){
			//我的点点折
			$('#alipay_form').on('submit',function(){
				var alipayId = $('#alipayInput').val() ;
				var validateResult = self.validateAlipay(alipayId);
				var errLayer = $('.alipay-err-layer') ;
				if(validateResult == '') {
					return true ;
				} else if(validateResult == 'alipay.required') {
					errLayer.find('.err-msg .msg').html('请输入接收返利的支付宝账号') ;
				} else if(validateResult == 'alipay.format.error') {
					errLayer.find('.err-msg .msg').html('输入支付宝格式错误，请检查是否为邮箱地址或手机号') ;
				} else if(validateResult == 'alipay.notExists') {
					errLayer.find('.err-msg .msg').html('您输入的支付宝不存在，请检查输入是否正确') ;
				} else {
					errLayer.find('.err-msg .msg').html('输入支付宝格式错误，请检查是否为邮箱地址或手机号') ;
				}
				$('#step3').hide() ;
				$('#step4').hide() ;
				$('.alipay-area-ipt form').addClass('form-err') ;
				errLayer.show() ;
				return false ;
			});
			
			
			$('#alipaySubmit').on('click',function(){
				//兼容IE6不支持a提交表单
				$('#alipay_form').find("#hiddenSubmit").click() ;
				return false ;
			});
			
			//取得焦点时隐藏错误提示
			$('#alipayInput').focus(function(){
				$('.alipay-err-layer').fadeOut(800) ;
				$('.alipay-area-ipt form').removeClass('form-err') ;
			});
		},
		
		_initSearchEvent:function(){
			
			var defaultText = $("#search_content").attr("placeholder") ;
			
			$('#search_form').on('submit',function(){
				var q = $("#search_content"),
					u = $("#submit").data("url"),
					wd = q.val() ;
				//输入为空
				if(wd == '' || wd == defaultText){
					alert('请粘贴你要购买的淘宝宝贝网址') ;
					return false ;
				}
				//检查URL格式
				wd = wd.toLowerCase() ;
				var isTaobaoUrl = false  ;
				var itemIdArray = ['id','itemid','item_id','mallstitemid','default_item_id'] ;
				if(wd.indexOf('taobao.com') != -1 ||
						wd.indexOf("tmall.com") != -1 ){
					
					for(var i = 0 ; i < itemIdArray.length ; i++){
						var id = itemIdArray[i] + '=';
						if(wd.indexOf(id) != -1){
							isTaobaoUrl = true ;
							break ;
						}
					}
					
				} 				
				
				if(!isTaobaoUrl){
					
					if($('#errurlPrompt').is(":visible")) {
						$('#errurlPrompt').trigger("click") ;
						return false ;
					}
					
					//显示错误淘宝URL指引
					$('#search_content').val(" ");
					$('#errurlPromptContainer .step-url').html("");
					$('#errurlPromptContainer .errurl-prompt').fadeIn(1000).append('<div class="step-url" id="step-url">' + taobaoRecommend + '</div>');//把推荐的商品显示在图片的URL中
					$('#item-show').addClass("dd-hide") ;//如果有商品结果显示则隐藏
					$('#newGuide').addClass("dd-hide") ;//隐藏新手引导按钮
					$('#step1').hide() ;//新手引导的图隐藏
					$('#errurlPromptContainer .mask').css({height:'150px'});
					
					self.hideIndexSegment() ; //首页segment隐藏
					$('#errurlPrompt').bind('click',function(){
						$('#step-url').animate({
						    left: '-=88',
						    top:'-=98'
						  }, 800, function() {
						  	$('#step-url').remove();
						  	$('#errurlPrompt').delay(500).animate({opacity:0},500,function(){
						  		$('#errurlPrompt').hide() ;//为了去掉display:block效果
						  		self._newGuideTwo();
						  	})
						  	$('#search_content').val(taobaoRecommend);

						    // Animation complete.
						  });
					});
					
					$('#errurlPrompt .go-taobao').find('a').click(function(e){
						e.stopPropagation();
					}) ;
					$('#search_form').append('<input type="hidden" name="userGuide" value="true" />') ;
					return false ;
				}
				
				return true ;
			}) ;
		},
		
		/**
		 * placeholder
		 */
		_initPlaceholder:function(){
			$("[dd-placeholder]").each(function(){
				var _this = $(this) ;
				var text = _this.attr("dd-placeholder");
				
				_this.on('focus',function(){
					if(_this.val() == text){
						_this.val("");
						_this.removeClass('placeholder') ;
					}
				});

				$(this).on('blur',function(){
					if(_this.val() === ""){
						_this.val(text);
						_this.addClass('placeholder') ;
					}
				});
				
				_this.val(text) ;
				_this.addClass('placeholder') ;
			});
		},
		
		_initSaveDiandianzhe:function(){
			if($(".diandianFavorite").length){
				$(".diandianFavorite").click(
						function(e) {
							e.stopPropagation() ;
							var ctrl = (navigator.userAgent.toLowerCase()).indexOf('mac') != -1 ? 'Command/Cmd' : 'Ctrl';
							if (document.all) {
								try {
									window.external.addFavorite( window.location, document.title);
								} catch (e) {
									try {
										window.sidebar.addPanel(document.title, window.location, '_self');
									} catch (e) {
										alert('您的浏览器收藏该页面没有成功，请尝试' + ctrl + '+D进行收藏');
									}
								}
							} else if (window.sidebar) {
								try {
									window.sidebar.addPanel(document.title, window.location, '_self');
								} catch (e) {
									alert('您的浏览器收藏该页面没有成功，请尝试' + ctrl + '+D进行收藏');
								}
							} else {
								alert('您的浏览器收藏该页面没有成功，请尝试' + ctrl + '+D进行收藏');
							}
							return false ;
						}
					)
					
//					$(".diandianFavorite").hover(function(){
//						if($.browser.mozilla || navigator.userAgent.toLowerCase().match(/chrome/) != null) {
//							$(this).find('.fav-arrow').removeClass('dd-hide');
//						}
//					} ,function(){
//						$(this).find('.fav-arrow').addClass('dd-hide');
//					});
			}
		},
		_initPaging:function(){
			if($('#pagination').length){
				$('#pagination a').on('click',function(){
					$('#page_num').val($(this).data('page'));
					$('#form_page').submit();
				});

				$('#jumpto').on('keyup',function(ev){
					if(ev.keyCode === 13){
						$('#form_page').submit();
					}
					var temp = $('#jumpto').val();
					if(temp.length){
						$('#jumpto').val(parseInt(temp));
						$('#page_num').val(parseInt(temp))
					}
				});
			}
		},
		
		/**
		 * google track
		 */
		_initGtrack:function(){
			
			$("[gtrack]").bind('click',function(){
				var gtrack = $(this).attr('gtrack') ;
				if(gtrack != null){
					//alert(gtrack) ;
					if(typeof(_gaq) != 'undefined'){
						_gaq.push(['_trackPageview',gtrack]); 
					}
				}
			}) ;
						
		},	
		
		/**
		 * 验证支付宝 ,正确支付宝 return ''
		 * errors:
		 * alipay.required
		 * alipay.format.error
		 */
		validateAlipay:function(alipayId) {
			alipayId = $.trim(alipayId) ;
			if(alipayId == ''){
				return 'alipay.required' ;
			}
			var isEmail = alipayId.match(self.Email_Regex) ;
			var isMobile = alipayId.match(self.Mobile_Regex) ;
			if(!isEmail && !isMobile){
				return 'alipay.format.error' ;
			}
			
			var ret = '' ;
			
			//检查支付宝有效性
			var ddzRoot = $("#ddzRoot").val() ;
			$.ajax({
				url : ddzRoot + '/zhe/remote/rest/alipayAcctStatusCheck.htm',
				data : {acctname:alipayId} , 
				async : false ,
				type : "POST" ,
				timeout : 500,
				success : function(data){
					try {
						var code = data.json.code ;
						if(code == 'success'){
							var acctType = data.json.data.acctType ;
							var statusModel = data.json.data ;
							var stat =  statusModel.stat ;
							if(stat == 'ok' && statusModel.info && statusModel.info.accStatus == 'available'){
								ret = 'alipay.notExists';
							}
						}
					}catch(e){
						
					}
					
				} ,
				error : function(data){
					
				}
			});
			
			return ret ;
		}  ,
		
		/**
		 * 注册结束引导
		 */
		_initRegisterDoneGuide:function(){
			//新账户
			if($('#isAccountNew').val() == 'true') {
				$("#buy_go_url").click(function(){
					var ddzRoot = $("#ddzRoot").val() ;
					$.ajax({
						url : ddzRoot + '/zhe/remote/rest/register_done_guide_ajax.htm',
						data : {} , 
						type : "POST" ,
						success : function(data){
							try {
								var code = data.json.code ;
								if(code == 'success'){
									var isGuide = (data.json.data == true) ;
									if(isGuide){
										//需要提示引导最后一步
										$("#guidedone").removeClass('dd-hide') ;
										$(".menu .user-center").find('.tixian').hide() ;
										setInterval(
											function(){
												$("#guidedone").animate({top:'-=4'},200, "linear").animate({top:'+=4'},200, "linear")
											}, 500) ;
									}
								}
							}catch(e){
								
							}
						} ,
						error : function(data){
							
						}
					});
				}) ;
			}
		} ,
		
		_initNewGuide:function(){
			
			if(typeof zAccount === 'undefined') { 
				return;
			}
			if(zAccount){
				
				$(".ddz-index-main .segment").delegate('#newGuide','click',function(e){
					if ($('#item-show').length>0) {
					    $('#item-show').addClass("dd-hide");
					}
					self.hideIndexSegment() ;
					self._newGuideOne();
					$('.ddz-index-main .segment').remove();
					$('#search_form').append('<input type="hidden" name="userGuide" value="true" />') ;
				});

				if($('#step3').length && $('#step4').length){
					$('#alipayInput').bind('focusin',function(){
						$('#step3').fadeOut(1000 , function(){
							$('.dd-tip-layer .arrow').removeClass('dd-hide') ;
						});
						//
					});
					
					$('#step3').slideDown(600,function(){
						$('#step4').slideDown(600);
					});
					
				}
			}
			
			
			if($('#step5').length && $('#step6').length && !zAccount){
				self._newGuideThree();
			}
		},
		_newGuideOne:function(){
		
			$('#search_content').val(" ");
			$('#step1').fadeIn(1000).append('<div class="step-url" id="step-url">' + taobaoRecommend + '</div>');
			$('#step1Container .mask').css({height:'150px'}) ;
			$('#step1').bind('click',function(){
				$('#step-url').animate({
				    left: '-=88',
				    top:'-=98'
				  }, 800, function() {
				  	$('#step-url').remove();
				  	$('#step1').delay(500).animate({opacity:0},500,function(){
				  		self._newGuideTwo();
				  	})
				  	$('#search_content').val(taobaoRecommend);

				    // Animation complete.
				  });
			});
			
			$('#step1 .go-taobao').find('a').click(function(e){
				e.stopPropagation();
			}) ;

			$(window).unload(function(){ 
			});
		},
		_newGuideTwo:function(){
			$('#step2').show('show').animate({top:'-=4'},200, "linear").animate({top:'+=4'},200, "linear");
		},
		_newGuideThree:function(){
			$('#step5').show('show').animate({top:'-=4'},200, "linear").animate({top:'+=4'},200, "linear");
			$("#buy_go_url").bind('click',function(){
				$('#step5').fadeOut(600); //隐藏tip				
				$("#buy_go_url").unbind('click') ;
				return  ;
			}) ;
			
		},
		
		hideIndexSegment:function(){
			$('.ddz-index-main .segment').addClass('dd-hide') ;
		} ,
		
		centerPoint:function(selector) {
			if(selector == null || selector == undefined){
				return  ;
			}
			
			var sWidth = selector.width() ;
			var sHeight = selector.height() ;
			var sLeft = selector.offset().left ;
			var sRight = selector.offset().right ;
			
			var clientWidth = $(document).width() ;
			var clientHeight = $(document).height() ;
			var scrollTop = $(document).scrollTop();
			var scrollLeft = $(document).scrollLeft();
			var left = scrollLeft + (clientWidth - sWidth)/2 ;
			var top = scrollTop + (clientHeight - sHeight)/2 - 30 ;
			if(top < 20) {
				top = 20 ;
			}
			selector.css({
				left:left,top:top
			}) ;
		} ,
		end:0
	});
})(jQuery);

jQuery(document).ready(function(){
	DD.Index.init();
});
