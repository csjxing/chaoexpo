package com.doucome.chaoexpo.web.bops.action.ajax;

import org.springframework.beans.factory.annotation.Autowired;

import com.doucome.chaoexpo.biz.core.bo.ChaoNewsBO;
import com.doucome.chaoexpo.biz.core.enums.YesNoEnum;
import com.doucome.chaoexpo.biz.core.model.param.ResultModel;
import com.doucome.chaoexpo.web.bops.action.BopsBasicAction;
import com.doucome.chaoexpo.web.common.model.JsonModel;

@SuppressWarnings("serial")
public class BNewsOrderAction extends BopsBasicAction {
	
	private JsonModel<Integer> json = new JsonModel<Integer>();
	
	private Long id;
	
	private String top;
	
	@Autowired
	private ChaoNewsBO chaNewsBO;
	
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public String resetNewsTop() {
		YesNoEnum topEnum = YesNoEnum.toEnum(top);
		ResultModel<Integer> result = chaNewsBO.resetNewsToTop(id, topEnum);
		if (result.isSucc()) {
			json.setSuccess(result.getData());
		} else {
			json.setFail(result.getDetail());
		}
		return SUCCESS ;
	}
	
	/**
	 * 
	 * @return
	 */
	public String resetNewsDisplayOrder() {
		ResultModel<Integer> result = chaNewsBO.moveNewsToFirst(id);
		if (result.isSucc()) {
			json.setSuccess(result.getData());
		} else {
			json.setFail(result.getDetail());
		}
		return SUCCESS ;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setTop(String top) {
		this.top = top;
	}

	public JsonModel<Integer> getJson() {
		return json;
	}
}
