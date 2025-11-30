
package com.wyzy.hospital.common.security.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 用户类型枚举
 *
 * @author aqie
 */
@Getter
@AllArgsConstructor
public enum UserEnum {

	/**
	 * user
	 */
	USER("user", 0),

	/**
	 * admin
	 */
	ADMIN("admin", 1),


	DOCTOR("doctor", 2),

	HOSPITAL("hospital", 3),


	CLINIC("clinic", 4),
	/**
	 * pharmacy
	 */
	PHARMACY("pharmacy", 5),
	;

	final String name;
	final int category;

}
