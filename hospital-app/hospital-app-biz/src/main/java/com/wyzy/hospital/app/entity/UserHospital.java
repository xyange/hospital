package com.wyzy.hospital.app.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;


/**
 * @Author aqie
 * Date on 2021/6/4  17:21
 * @Function: 用户收藏医院表
 */
@Data
@Document
public class UserHospital {
	@Id
	private String id;

	@Indexed
	private Long memberId;

	private String nickname;

	private String phone;

	@Indexed
	private Long hospitalId;

	private String hospitalName;

	private String hospitalImage;

	private Date createTime;
}
