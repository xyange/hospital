package com.wyzy.hospital.integration.utils;

public enum IntegrationEnum {

	/**
	 * 积分总量
	 */
	totalIntegral(101,"totalIntegral"),
	/**
	 * 使用积分
	 */
	usingIntegral(102, "usingIntegral"),
	/**
	 * 剩余积分
	 */
	residualintegral(103,"residualintegral"),
	/**
	 * 冻结积分
	 */
	frozenintegral(104,"frozenintegral"),

	/**
	 * 过期积分
	 */
	overdue(105,"overdue"),

	/**
	 * 签到
	 */
	signin(111,"签到"),
	/**
	 * 登录
	 */
	enroll(112, "登录"),
	/**
	 * 支付
	 */
	payment(113,"支付"),
	/**
	 * 分享
	 */
	share(114,"分享"),

	/**
	 * 咨询
	 */
	consult(113,"咨询"),
	/**
	 * 浏览APP
	 */
	browse(114,"浏览APP"),

	/**
	 * 升降序
	 */
	asc(1,"ASC"),
	desc(2,"DESC");

	// 成员变量
	private int index;
	private String name;

	// 构造方法
	private IntegrationEnum(int index, String name) {
		this.index = index;
		this.name = name;
	}

	public static String getName(int index) {

		for (IntegrationEnum integrationEnum : IntegrationEnum.values()) {
			if (integrationEnum.getIndex() == index) {
				return integrationEnum.name;
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
