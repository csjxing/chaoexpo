package com.doucome.chaoexpo.web.chao.action.ajax;

import org.springframework.beans.factory.annotation.Autowired;

import com.doucome.chaoexpo.biz.common.utils.IDUtils;
import com.doucome.chaoexpo.biz.core.bo.ChaoNewsBO;
import com.doucome.chaoexpo.biz.core.model.ChaoNewsCategoryDTO;
import com.doucome.chaoexpo.biz.core.model.ChaoNewsDTO;
import com.doucome.chaoexpo.biz.core.model.param.ResultModel;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoNewsCategoryService;
import com.doucome.chaoexpo.biz.core.service.chao.ChaoNewsService;
import com.doucome.chaoexpo.web.chao.ChaoBasicAction;
import com.doucome.chaoexpo.web.common.model.JsonModel;

/**
 * 新闻详情
 * @author langben 2013-5-21
 *
 */
public class QueryNewsDetailAction extends ChaoBasicAction {
	
	private static final long serialVersionUID = 1L;

	private JsonModel<ChaoNewsDTO> json = new JsonModel<ChaoNewsDTO>() ;
	
	private Long id;
	@Autowired
	private ChaoNewsBO chaoNewsBO;
	
	@Override
	public String execute() throws Exception {
		if(IDUtils.isNotCorrect(id)) {
			json.setFail("id.invalid");
			return SUCCESS ;
		}
		ResultModel<ChaoNewsDTO> result = chaoNewsBO.getNewsDetail(id);
		if (result.isSucc()) {
			json.setSuccess(result.getData());
		} else {
			json.setFail(result.getDetail());
		}
		return SUCCESS ;
	}

	
	public JsonModel<ChaoNewsDTO> getJson() {
		return json;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
