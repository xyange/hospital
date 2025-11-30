

package com.wyzy.hospital.cyclopedia.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wyzy.hospital.common.data.datascope.HospitalBaseMapper;
import com.wyzy.hospital.cyclopedia.dto.CyDiseasesDTO;
import com.wyzy.hospital.cyclopedia.entity.CyDiseases;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 疾病表
 *
 * @author hospital code generator
 * @date 2021-05-08 14:37:31
 */
@Mapper
public interface CyDiseasesMapper extends HospitalBaseMapper<CyDiseases> {
/*	//根据疾病查其详细内容并查询相关的疾病文章

	CyDiseases selectDiseasesAndArticlesByName(String diseaseName);*/

	//随机查询九个疾病

	List<CyDiseasesDTO> selectRandDiseases();

	//查疾病数量

	Integer selectNumberEnDiseases();

	//疾病百科审核

	List<CyDiseasesDTO>selectCheckDiseases(IPage<CyDiseasesDTO> page);

//疾病百科审核（查询）

	List<CyDiseasesDTO> byConditionDiseasesBackstage(IPage<CyDiseasesDTO> page, @Param("minTime") LocalDateTime minTime,
													 @Param("maxTime") LocalDateTime maxTime,
													 @Param("disName") String disName,
													 @Param("uploadAdmin") String uploadAdmin);
	//疾病百科列表

	List<CyDiseasesDTO>selectCyDiseasesTable(IPage<CyDiseasesDTO> page);

   //疾病百科列表（查询）

	List<CyDiseasesDTO> byConditionDiseasesTable(IPage<CyDiseasesDTO> page,@Param("minTime") LocalDateTime minTime,
													 @Param("maxTime") LocalDateTime maxTime,
													 @Param("disName") String disName,
													 @Param("disCheckAdmin") String disCheckAdmin);

	//疾病百科审核列表（查询）

	List<CyDiseasesDTO> theCondDisBackTable(IPage<CyDiseasesDTO> page,@Param("minTime") LocalDateTime minTime,
											@Param("maxTime") LocalDateTime maxTime,
											@Param("disName") String disName,
											@Param("uploadAdmin") String uploadAdmin);



	//疾病百科审核列表

	List<CyDiseasesDTO>selectCyDiseasesCheckTable(IPage<CyDiseasesDTO> page);

	//根据疾病disId查详情

	List<CyDiseasesDTO>queryCyDiseasesById(Long disId);

	//后台疾病审核

	Boolean updateDiseasesCheckStruts(@Param("cyDiseasesDTO") CyDiseasesDTO cyDiseasesDTO);

	//重新提交

	void ReSubmitDiseasesCheckStruts(@Param("disId")Long disId, @Param("disCheckStruts")String disCheckStruts);


	//上线下线

	void updateDisExistStruts(@Param("disId")Long disId, @Param("disExistStruts")String disExistStruts);


	//根据疾病查id

	CyDiseases getNameById(String disName);

	//根据疾病查疾病

	String getBydisName(String disName);


}
