package com.wyzy.hospital.pharmacy.dto;

import lombok.Data;

/**
 * @Author ZhangZhiPeng
 * Date on 2021/6/4  9:52
 */
@Data
public class MemberUserDTO {

	//会员id

	private Long memberId ;

	 //积分

	private Long integration;

	//昵称

	 private  String nickName;

	 //手机号

	 private  String phone;

	 //身份证号

	 private  String idCard;

	 //关联用户id

	private Long userId;

}
