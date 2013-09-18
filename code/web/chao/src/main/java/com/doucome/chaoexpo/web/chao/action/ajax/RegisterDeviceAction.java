package com.doucome.chaoexpo.web.chao.action.ajax;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;

import com.doucome.chaoexpo.biz.core.enums.DevicePushParamKeyEnums;
import com.doucome.chaoexpo.biz.core.enums.OsTypeEnums;
import com.doucome.chaoexpo.biz.core.model.ChaoDeviceDTO;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoDeviceService;
import com.doucome.chaoexpo.biz.core.utils.JacksonHelper;
import com.doucome.chaoexpo.biz.dal.dataobject.ChaoDeviceDO;
import com.doucome.chaoexpo.web.chao.ChaoBasicAction;
import com.doucome.chaoexpo.web.chao.model.RegisterDeviceModel;
import com.doucome.chaoexpo.web.common.model.JsonModel;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 注册设备
 * @author langben 2013-9-18
 *
 */
public class RegisterDeviceAction extends ChaoBasicAction implements ModelDriven<RegisterDeviceModel>{
	
	private RegisterDeviceModel model = new RegisterDeviceModel() ;
	
	private JsonModel<Boolean> json = new JsonModel<Boolean>() ;
	
	@Autowired
	private ChaoDeviceService chaoDeviceService ;
	
	@Override
	public String execute() throws Exception {
		
		String imei = model.getImei() ;
		if(StringUtils.isBlank(imei)){
			json.setCode(JsonModel.CODE_ILL_ARGS) ;
			json.setDetail("chao.device.register.imei.required") ;
			return SUCCESS ;
		}
		
		OsTypeEnums osType = OsTypeEnums.toEnum(model.getOsType()) ;
		if(osType != OsTypeEnums.IOS) {
			json.setCode(JsonModel.CODE_ILL_ARGS) ;
			json.setDetail("chao.device.register.osType.error") ;
			return SUCCESS ;
		}
		
		if(osType == OsTypeEnums.IOS) {
			if(StringUtils.isBlank(model.getDeviceToken())) {
				json.setCode(JsonModel.CODE_ILL_ARGS) ;
				json.setDetail("chao.device.register.deviceToken.required") ;
				return SUCCESS ;
			}
		}
		
		ChaoDeviceDTO existsDevice = chaoDeviceService.getDeviceByIMEI(imei) ;
		if(existsDevice != null) {
			json.setCode(JsonModel.CODE_ILL_ARGS) ;
			json.setDetail("chao.device.register.device.duplicate") ;
			return SUCCESS ;
		}
		
		ChaoDeviceDO device = new ChaoDeviceDO() ;
		device.setImei(imei) ;
		device.setOsType(osType.getValue()) ;
		Map<String,String> map = new HashMap<String,String>() ;
		map.put(DevicePushParamKeyEnums.IOS_DEVICE_TOKEN.getValue(), model.getDeviceToken()) ;
		device.setPushParam(JacksonHelper.toJSON(map)) ;
		
		try {
			chaoDeviceService.createDevice(device) ;
			json.setCode(JsonModel.CODE_SUCCESS) ;
			json.setData(Boolean.TRUE) ;
			return SUCCESS ;
		} catch (DuplicateKeyException e) {
			json.setCode(JsonModel.CODE_ILL_ARGS) ;
			json.setDetail("chao.device.register.device.duplicate") ;
			return SUCCESS ;
		}
	}

	@Override
	public RegisterDeviceModel getModel() {
		return model ;
	}

	public JsonModel<Boolean> getJson() {
		return json;
	}
}
