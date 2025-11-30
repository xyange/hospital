package com.wyzy.hospital.communication.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author aqie
 */
@Getter
@Setter
@NoArgsConstructor
public class DataContent implements Serializable {
    private static final long serialVersionUID = 8021381444738260454L;

    private Integer action;		// 动作类型
    private ChatMsg chatMsg;	// 用户的聊天内容entity
    private String extend;		// 扩展字段
}
