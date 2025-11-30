package com.wyzy.hospital.cyclopedia.dto;

import com.wyzy.hospital.cyclopedia.entity.FoodDetails;
import com.wyzy.hospital.cyclopedia.entity.FoodLevel;
import lombok.Data;

/**
 * @Author ZhangZhiPeng
 * Date on 2021/5/24  14:38
 */
@Data
public class AddFoodDTO {

private FoodDetails foodDetails;

private FoodLevel foodLevel;
}
