package com.doucome.chaoexpo.biz.core.exception;

/**
 * 缓存失败异常.
 * @author ze2200
 *
 */
public class CacheFailedException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public CacheFailedException(Exception e) {
		super(e);
	}
	
	public CacheFailedException(String message, Exception e) {
		super(message, e);
	}
}
