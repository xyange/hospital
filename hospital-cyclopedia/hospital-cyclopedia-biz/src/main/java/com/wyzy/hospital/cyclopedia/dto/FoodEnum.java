package com.wyzy.hospital.cyclopedia.dto;

/**
 * @Author ZhangZhiPeng
 * Date on 2021/4/26  10:39
 */
	public enum FoodEnum {
	    foodHeat("101","food_heat"),
	    foodFat("102", "food_fat"),
	    foodCarbohydrates("103","food_carbohydrates"),
	    foodCholesterol("103","food_cholesterol"),
	    foodProtein("104","food_protein"),
	    dietaryFiber("105","dietary_fiber"),
	    foodIron("106","food_iron"),
	    foodCalcium("107","food_calcium"),
	    foodPotassium("108","food_potassium"),
	    foodMagnesium("109","food_magnesium"),
	    foodAcid("110","food_acid"),
	    foodZinc("111","food_zinc"),
	    foodPurine("112","food_purine"),
	    foodSodium("113","food_sodium"),
	    foodSaturatedFat("114","food_saturated_fat"),
	    foodGi("115","food_GI"),
	    foodGl("116","food_GL"),
		asc("1","ASC"),
		desc("2","DESC");


	private String code;
	private String field;

	FoodEnum(String code, String field) {
		this.code = code;
		this.field = field;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public static FoodEnum getFields(String code) {

		for (FoodEnum foodTypeEnum : values()) {
			if (foodTypeEnum.getCode().equals(code)) {
				return foodTypeEnum;
			}
		}
		return null;

	}


}
