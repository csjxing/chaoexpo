package com.doucome.chaoexpo.biz.core.model.param;

/**
 * 
 * @author ze2200
 * 
 */
public class ResultModel<T> {
	
	public static final String CODE_SUCC = "success";
	
	public static final String CODE_FAIL = "fail";
	
	public static final String CODE_EXCEPTION = "exception";
	
	private String code;
	
	private String detail;
	
	private T data;
	
	public boolean isSucc() {
		return CODE_SUCC.equals(getCode());
	}
	
	public void setSuccess(T data) {
		setSuccess(CODE_SUCC, data);
	}
	
	public void setFail(String detail) {
		setFail(CODE_FAIL, detail);
	}
	
	public void setSuccess(String code, T data) {
		setCode(code);
		setData(data);
	}
	
	public void setFail(String code, String detail) {
		setCode(code);
		setDetail(detail);
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}
