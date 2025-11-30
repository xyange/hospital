package com.wyzy.hospital.common.gateway.exception;

/**
 * @author wyzy
 * @date 2020/11/19
 */
public class RouteCheckException extends RuntimeException {

	public RouteCheckException() {
	}

	public RouteCheckException(String message) {
		super(message);
	}

	public RouteCheckException(String message, Throwable cause) {
		super(message, cause);
	}

	public RouteCheckException(Throwable cause) {
		super(cause);
	}

	public RouteCheckException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
