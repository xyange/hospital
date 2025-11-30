

package com.wyzy.hospital.common.core.util;

import com.wyzy.hospital.common.core.constant.CommonConstants;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 响应信息主体
 *
 * @param <T>
 * @author wyzy
 */
@Builder
@ToString
@AllArgsConstructor
@Accessors(chain = true)
@ApiModel(value = "响应信息主体")
public class R<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	@Getter
	@Setter
	@ApiModelProperty(value = "返回标记：成功标记=0，失败标记=1")
	private int code;

	@Getter
	@Setter
	@ApiModelProperty(value = "返回信息")
	private String msg;

	@Getter
	@Setter
	@ApiModelProperty(value = "数据")
	private T data;

	public static <T> R<T> ok() {
		return restResult(null, CommonConstants.SUCCESS, null);
	}

	public static <T> R<T> ok(T data) {
		return restResult(data, CommonConstants.SUCCESS, null);
	}

	public static <T> R<T> ok(T data,int code) {
		return restResult(data, code, "");
	}

	public static <T> R<T> ok(T data, String msg) {
		return restResult(data, CommonConstants.SUCCESS, msg);
	}

	public static <T> R<T> failed() {
		return restResult(null, CommonConstants.FAIL, null);
	}

	public static <T> R<T> failed(String msg) {
		return restResult(null, CommonConstants.FAIL, msg);
	}

	public static <T> R<T> failed(T data) {
		return restResult(data, CommonConstants.FAIL, null);
	}

	public static <T> R<T> error(CodeMsg codeMsg){
		return new R<T>(codeMsg);
	}

	public static <T> R<T> error(CodeMsg codeMsg, T data){
		return new R<T>(codeMsg, data);
	}

	public static <T> R<T> failed(T data, String msg) {
		return restResult(data, CommonConstants.FAIL, msg);
	}

	private static <T> R<T> restResult(T data, int code, String msg) {
		R<T> apiResult = new R<>();
		apiResult.setCode(code);
		apiResult.setData(data);
		apiResult.setMsg(msg);
		return apiResult;
	}

	public R() {
		code = 0;
		msg = "ok";
	}

	public R(T result) {
		this();
		this.data = result;
	}

	public R(String msg){
		code = 0;
		this.msg = msg;
	}

	private R(CodeMsg codeMsg){
		if (codeMsg == null) {
			return;
		}
		this.code = codeMsg.getCode();
		this.msg = codeMsg.getMsg();
	}

	private R(CodeMsg codeMsg, T data){
		if (codeMsg == null) {
			return;
		}
		this.code = codeMsg.getCode();
		this.msg = codeMsg.getMsg();
		this.data = data;
	}

	public boolean success() {
		return code == CommonConstants.SUCCESS;
	}

}
