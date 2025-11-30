package com.wyzy.hospital.cyclopedia.dto;


import com.wyzy.hospital.cyclopedia.entity.Effect;
import lombok.Data;

import java.util.List;

/**
 * @Author ZhangZhiPeng
 * Date on 2021/4/20  15:46
 */
@Data
public class EffectDTO extends Effect {
private List<TagDTO>tagDTOList;
private List<FoodDetailsDTO>foodDetailsDTOList;
}
