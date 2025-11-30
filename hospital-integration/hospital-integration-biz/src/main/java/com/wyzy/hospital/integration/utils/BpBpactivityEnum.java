package com.wyzy.hospital.integration.utils;

/**
 * 积分活动表enum
 *
 * @author hospital code generator
 * @date 2021-05-08 16:09:33
 */
public enum BpBpactivityEnum {

	/**
	 * 积分总量
	 */
	doctor(1,"医生端APP"),
	/**
	 * 使用积分
	 */
	patient(2, "患者端APP");

	// 成员变量
	private int index;
	private String name;

	// 构造方法
	private BpBpactivityEnum(int index, String name) {
		this.index = index;
		this.name = name;
	}

	public static String getName(int index) {

		for (BpBpactivityEnum bpBpactivityEnum : BpBpactivityEnum.values()) {
			if (bpBpactivityEnum.getIndex() == index) {
				return bpBpactivityEnum.name;
			}
		}
		return null;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
