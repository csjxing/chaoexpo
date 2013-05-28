package com.doucome.chaoexpo.biz.core.exception;

/**
 * 豆蔻违反唯一性约束异常类.
 * @author langben 2013-5-27
 *
 */
public class ChaoDuplicateKeyException extends RuntimeException {

	public ChaoDuplicateKeyException() {
		super();
	}
	
	public ChaoDuplicateKeyException(String message) {
		super(message);
	}
	
	public ChaoDuplicateKeyException(Exception e) {
		super(e);
	}
	
	public ChaoDuplicateKeyException(String message, Exception e) {
		super(message, e);
	}
	
}
