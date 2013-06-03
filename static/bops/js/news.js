!(function($){
	$.namespace("DD.news");
	
	var self = DD.news;
	
	var bopsRoot = $("#bopsRoot").val() ;
	
	$.extend(DD.news,{
		
		init:function(){
		
		},
		_initPictureUpload: function() {
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
		end:0
	});
})(jQuery);

jQuery(document).ready(function(){
	DD.news.init();
});
