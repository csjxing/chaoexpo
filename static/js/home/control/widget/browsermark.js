(function(_window, _document) {
    var curHost = window.location.host;
    if(curHost.indexOf("taobao") == -1 && curHost.indexOf("tmall") == -1) {
	    return alert('亲，只有在淘宝商品页面才能查返利哦');
	}
	//解析商品id
    function _parseItemId(name, itemUrl){
	    var index = itemUrl.indexOf("?");
		if (index == -1 || index+1 == itemUrl.length) {
		    return undefined;
		}
	    var params = itemUrl.substring(index+1, itemUrl.length).split("&");
	    var keyValues = {};
	    for (i = 0; i < params.length; i++){
	        index = params[i].indexOf("=");
	        var key = params[i].substring(0, index).toLowerCase();
		    var value = params[i].substring(index+1, params[i].length);
		    keyValues[key] = value;
	    }
	    return keyValues[name.toLowerCase()];
    }
    function _ddzGoto(){
        var curUrl = window.location.href;
	    var itemId = _parseItemId('id', curUrl);
		if (!itemId){
		    itemId = _parseItemId('item_id', curUrl);
		}
		if (!itemId){
		    itemId = _parseItemId('itemid', curUrl);
		}
		if (!itemId){
		    itemId = _parseItemId('itemId', curUrl);
		}
		if (!itemId){
		    itemId = _parseItemId('default_item_id', curUrl);
		}
		if (!itemId){
		    itemId = _parseItemId('mallstitemid', curUrl);
		}
		if (!itemId){
		    itemId = _parseItemId('mallstItemId', curUrl);
		}
	    if (itemId){
		    document.location.href = 'http://diandianzhe.com/zhe/item/' + itemId + '?spm=a.browsermark&domain=' + curHost;
	    } else if (curUrl.indexOf("meal_id") != -1) {
			return alert('亲，套餐商品是不能返利的哦~~~');
		} else {
		    return alert('亲，只有在淘宝商品页面才能查返利哦');
		}
    }
    _ddzGoto();
})(window, document);