

package com.wyzy.hospital.cyclopedia.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wyzy.hospital.cyclopedia.dto.DrugTypeCompanyDrugDTO;
import com.wyzy.hospital.cyclopedia.entity.DrugType;

import java.util.List;

/**
 * 药剂表
 *
 * @author hospital code generator
 * @date 2021-05-15 19:55:18
 */
public interface DrugTypeService extends IService<DrugType> {

	//根据试剂查公司药品及制药的公司

	List<DrugTypeCompanyDrugDTO> queryDrugTypeCompanyDrug(Long tid);
}
