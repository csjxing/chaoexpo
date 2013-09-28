package com.doucome.chaoexpo.web.bops.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import com.doucome.chaoexpo.biz.core.enums.DevicePushViewtypeEnums;
import com.doucome.chaoexpo.biz.core.enums.OsTypeEnums;
import com.doucome.chaoexpo.biz.core.model.ChaoDeviceDTO;
import com.doucome.chaoexpo.biz.core.model.page.Pagination;
import com.doucome.chaoexpo.biz.core.model.page.QueryResult;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoDeviceService;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoPushLogService;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoUserPushService;
import com.doucome.chaoexpo.biz.core.utils.ArrayStringUtils;
import com.doucome.chaoexpo.biz.core.utils.ChaoDeviceUtils;
import com.doucome.chaoexpo.biz.core.utils.JacksonHelper;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoPushLogDO;
import com.doucome.chaoexpo.biz.dal.query.ChaoDeviceQuery;
import com.doucome.chaoexpo.web.common.utils.ServletContextUtils;

public class DevicePushAction extends BopsBasicAction {

	private List<String> pushGroup ;
	
	private String pushMessage ;
	
	private String viewType ;
	
	private String viewTypeId ;
	
	private QueryResult<ChaoDeviceDTO> queryResult ;
	
	private int successCount ;
	
	@Autowired
	private ChaoDeviceService chaoDeviceService ;
	
	@Autowired
	private ChaoUserPushService chaoUserPushService ;
	
	@Autowired
	private ChaoPushLogService chaoPushLogService ;
	
	@Override
	public String execute() throws Exception {
		return SUCCESS ;
	}
	
	public String step1() throws Exception {
		
		if(CollectionUtils.isEmpty(pushGroup)) {
			addActionError("chao.device.push.gourp.required") ;
			return INPUT ;
		}
				
		ChaoDeviceQuery query = new ChaoDeviceQuery() ;
		query.setOsTypes(pushGroup) ;
		
		queryResult = chaoDeviceService.getDeviceWithPagination(query, new Pagination(1,20)) ;
		
		if(CollectionUtils.isEmpty(queryResult.getItems())) {
			addActionError("chao.device.push.device.empty") ;
			return INPUT ;
		}
		
		return SUCCESS ;
	}
	
	public String submit() throws Exception {
		
		if(CollectionUtils.isEmpty(pushGroup)) {
			addActionError("chao.device.push.gourp.required") ;
			return "step0" ;
		}
		
		if(StringUtils.isEmpty(pushMessage)) {
			addActionError("chao.device.push.msg.required") ;
			ChaoDeviceQuery query = new ChaoDeviceQuery() ;
			query.setOsTypes(pushGroup) ;
			queryResult = chaoDeviceService.getDeviceWithPagination(query, new Pagination(1,20)) ;
			return INPUT ;
		}
		
		DevicePushViewtypeEnums viewTypeEnums = DevicePushViewtypeEnums.toEnum(viewType) ;
		if(viewTypeEnums == DevicePushViewtypeEnums.UNKNOW) {
			addActionError("chao.device.push.viewType.error") ;
			ChaoDeviceQuery query = new ChaoDeviceQuery() ;
			query.setOsTypes(pushGroup) ;
			queryResult = chaoDeviceService.getDeviceWithPagination(query, new Pagination(1,20)) ;
			return INPUT ;
		}
		
		int succCount = 0 ;
		Map<String,String> customParam = new HashMap<String,String>() ;
		customParam.put("viewtype", viewType) ;
		customParam.put("id", viewTypeId) ;
		for(String group : pushGroup) {
			if(OsTypeEnums.toEnum(group) == OsTypeEnums.IOS) { //只推送IOS
				ChaoDeviceQuery query = new ChaoDeviceQuery() ;
				query.setOsType(group) ;
				List<ChaoDeviceDTO> deviceList = chaoDeviceService.getDeviceNoPagination(query, Integer.MAX_VALUE ) ;
				String p12File = ServletContextUtils.getRealPath("/WEB-INF/ChaoPushDev.p12") ;
				List<String> deviceTokens = ChaoDeviceUtils.getDeviceTokens(deviceList) ;
				int subCount = chaoUserPushService.pushToIOS(deviceTokens, pushMessage, p12File , customParam) ;
				succCount += subCount ;
			}
		}
		
		//创建日志
		ChaoPushLogDO pushLog = new ChaoPushLogDO() ;
		pushLog.setMsg(pushMessage) ;
		pushLog.setSuccCount(succCount) ;
		pushLog.setPushGroup(ArrayStringUtils.toString(pushGroup)) ;
		pushLog.setViewType(viewType) ;
		pushLog.setPushParam(JacksonHelper.toJSON(customParam)) ;
		chaoPushLogService.createPushLog(pushLog) ;
		
		successCount = succCount ;
		
		return SUCCESS ;
	}

	public QueryResult<ChaoDeviceDTO> getQueryResult() {
		return queryResult;
	}

	public List<String> getPushGroup() {
		return pushGroup;
	}

	public void setPushGroup(List<String> pushGroup) {
		this.pushGroup = pushGroup;
	}

	public void setPushMessage(String pushMessage) {
		this.pushMessage = pushMessage;
	}

	public int getSuccessCount() {
		return successCount;
	}

	public void setSuccessCount(int successCount) {
		this.successCount = successCount;
	}

	public String getViewType() {
		return viewType;
	}

	public void setViewType(String viewType) {
		this.viewType = viewType;
	}

	public String getViewTypeId() {
		return viewTypeId;
	}

	public void setViewTypeId(String viewTypeId) {
		this.viewTypeId = viewTypeId;
	}
	
}
