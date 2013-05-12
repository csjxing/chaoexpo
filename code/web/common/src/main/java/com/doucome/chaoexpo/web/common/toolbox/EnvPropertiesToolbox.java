package com.doucome.chaoexpo.web.common.toolbox;



import org.apache.commons.lang.StringUtils;

import com.doucome.chaoexpo.biz.core.constant.EnvConstant;
import com.doucome.chaoexpo.biz.core.constant.URIConstant;
import com.doucome.chaoexpo.biz.core.service.impl.DefaultUriService;
import com.doucome.chaoexpo.biz.core.utils.EnvPropertiesUtil;


/**
 * EnvPropertiesToolbox velocity toolbox
 * @author langben 2011-12-23
 *
 */
public class EnvPropertiesToolbox {
	
	/**
	 * getProperty
	 * @param key
	 * @return
	 */
	public String getProperty(String key){
		return EnvPropertiesUtil.getProperty(key) ;
	}
	
	public String getProp(String key){
		return getProperty(key) ;
	}
	
	public boolean isProduction(){
		String production = EnvPropertiesUtil.getProperty(EnvConstant.CHAOEXPO_PRODUCTION) ;
		if(StringUtils.equals(production, "true")){
			return true ;
		}
		return false ;
	}
	
	/**
	 * 豆蔻URL
	 * @return
	 */
	public String getRoot(){
		return DefaultUriService.getFactoryURI(URIConstant.DCOME_SERVER) ;
	}
	
	/**
	 * 豆蔻静态URL
	 * @return
	 */
	public String getStaticroot(){
		return DefaultUriService.getFactoryURI(URIConstant.STATIC_SERVER) ;
	}
	
	public String getPicUploadedRoot(){
		return DefaultUriService.getFactoryURI(URIConstant.DCOME_PIC_UPLOADED_SERVER) ;
	}
	
	public String getItemUploadedRoot(){
		return DefaultUriService.getFactoryURI(URIConstant.DCOME_ITEM_UPLOADED_SERVER) ;
	}
	
	/**
	 * 点点折URL
	 * @return
	 */
	public String getDdzRoot(){
		return DefaultUriService.getFactoryURI(URIConstant.DDZ_SERVER) ;
	}
	
	public String getDdzTuanRoot(){
		return DefaultUriService.getFactoryURI(URIConstant.DDZ_TUAN_SERVER) ;
	}
	
	/**
	 * 点点折静态URL
	 * @return
	 */
	public String getDdzStaticroot(){
		return DefaultUriService.getFactoryURI(URIConstant.DDZ_STATIC_SERVER) ;
	}
	
	public String getDdzHelproot(){
		return DefaultUriService.getFactoryURI(URIConstant.DDZ_HELP_SERVER) ;
	}
	
	public String getSurlRoot(){
		return DefaultUriService.getFactoryURI(URIConstant.SURL_SERVER) ;
	}
	
	public String getBopsRoot(){
		return DefaultUriService.getFactoryURI(URIConstant.BOPS_SERVER) ;
	}
	
	public String getHsRoot() {
		return DefaultUriService.getFactoryURI(URIConstant.HS_SERVER);
	}
	
	public String getHsStaticRoot() {
		return DefaultUriService.getFactoryURI(URIConstant.HS_STATIC_SERVER);
	}
	
	public String getWryneckRoot(){
		return DefaultUriService.getFactoryURI(URIConstant.WRYNECK_SERVER);
	}
	
	public String getNamefateRoot(){
		return DefaultUriService.getFactoryURI(URIConstant.NAMEFATE_SERVER);
	}
	
	public String getQtestRoot(){
		return DefaultUriService.getFactoryURI(URIConstant.QTEST_SERVER);
	}
}
