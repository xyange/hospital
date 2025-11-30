package com.wyzy.hospital.tcm.utils;

/**
 * ClassName: TcmEnum<br/>
 * Description: <br/>
 * date: 2021/6/3 8:55<br/>
 *
 * @author Administrator<br />
 * @since JDK 1.8
 */
public enum TcmEnum {

	/**
	 * 经络分类
	 */
	meridians(1,"经络分类"),
	/**
	 * 中药分类
	 */
	 cm(2, "中药分类"),
	/**
	 * 内科分类
	 */
	internal(3,"内科分类");

	// 成员变量
	private int index;
	private String name;

	// 构造方法
	private TcmEnum(int index, String name) {
		this.index = index;
		this.name = name;
	}

	public static String getName(int index) {

		for (TcmEnum integrationEnum : TcmEnum.values()) {
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
