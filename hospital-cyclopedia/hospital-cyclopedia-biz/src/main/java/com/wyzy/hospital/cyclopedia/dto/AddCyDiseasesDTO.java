package com.wyzy.hospital.cyclopedia.dto;

import com.wyzy.hospital.cyclopedia.entity.CyDiseases;
import com.wyzy.hospital.cyclopedia.entity.DepartDiseases;
import lombok.Data;

/**
 * @Author ZhangZhiPeng
 * Date on 2021/5/22  9:12
 */
@Data
public class AddCyDiseasesDTO {



	private CyDiseases cyDiseases;

	private DepartDiseases departDiseases;

}
