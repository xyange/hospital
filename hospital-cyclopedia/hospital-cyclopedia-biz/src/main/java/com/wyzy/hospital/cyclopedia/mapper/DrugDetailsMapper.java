

package com.wyzy.hospital.cyclopedia.mapper;

import com.wyzy.hospital.common.data.datascope.HospitalBaseMapper;
import com.wyzy.hospital.cyclopedia.dto.DrugDetailsDTO;
import com.wyzy.hospital.cyclopedia.entity.DrugDetails;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 药品详情表
 *
 * @author hospital code generator
 * @date 2021-05-15 19:54:56
 */
@Mapper
public interface DrugDetailsMapper extends HospitalBaseMapper<DrugDetails> {

	List<DrugDetailsDTO>selectDrugType(Long drugId);


	Integer selectDrugTypeNumber(Long did);


}
