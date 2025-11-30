

package com.wyzy.hospital.cyclopedia.mapper;

import com.wyzy.hospital.common.data.datascope.HospitalBaseMapper;
import com.wyzy.hospital.cyclopedia.dto.DrugTypeCompanyDrugDTO;
import com.wyzy.hospital.cyclopedia.entity.DrugType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 药剂表
 *
 * @author hospital code generator
 * @date 2021-05-15 19:55:18
 */
@Mapper
public interface DrugTypeMapper extends HospitalBaseMapper<DrugType> {
    //根据试剂查公司药品及制药的公司

	List<DrugTypeCompanyDrugDTO>selectDrugTypeCompanyDrug(Long tid);
}
