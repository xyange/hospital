/*
 *
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright
 * notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution.
 * Neither the name of the wyzy.com developer nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 * Author:  wyzy
 */

package com.wyzy.hospital.common.security.exception;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wyzy.hospital.common.security.component.HospitalAuth2ExceptionSerializer;
import lombok.Getter;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;

/**
 * @author wyzy
 * @date 2018/7/8 自定义OAuth2Exception
 */
@JsonSerialize(using = HospitalAuth2ExceptionSerializer.class)
public class HospitalAuth2Exception extends OAuth2Exception {

	@Getter
	private String errorCode;

	public HospitalAuth2Exception(String msg) {
		super(msg);
	}

	public HospitalAuth2Exception(String msg, Throwable t) {
		super(msg, t);
	}

	public HospitalAuth2Exception(String msg, String errorCode) {
		super(msg);
		this.errorCode = errorCode;
	}

}
