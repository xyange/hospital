

package com.wyzy.hospital.cyclopedia.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wyzy.hospital.cyclopedia.dto.CyDiseasesDTO;
import com.wyzy.hospital.cyclopedia.entity.CyDiseases;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 疾病表
 *
 * @author hospital code generator
 * @date 2021-05-08 14:37:31
 */
public interface CyDiseasesService extends IService<CyDiseases> {

/*
	CyDiseases queryDiseasesAndArticlesByName(String diseaseName);*/

	//随机查询九个疾病

	 List<CyDiseasesDTO> queryRandDiseases();

	//查疾病数量

	Integer queryNumberEnDiseases();

	//疾病百科审核

	List<CyDiseasesDTO>queryCheckDiseases(IPage<CyDiseasesDTO> page);

	//疾病百科审核（查询）

	List<CyDiseasesDTO> lookConditionDiseases(IPage<CyDiseasesDTO> page,LocalDateTime minTime, LocalDateTime maxTime, String disName, String uploadAdmin);


	//疾病百科列表

	List<CyDiseasesDTO>queryCyDiseasesTable(IPage<CyDiseasesDTO> page);

	//疾病百科列表（查询）

	List<CyDiseasesDTO> lookConditionDiseasesTable(IPage<CyDiseasesDTO> page,LocalDateTime minTime, LocalDateTime maxTime, String disName, String disCheckAdmin);


    //疾病百科审核列表（查询）

	List<CyDiseasesDTO> looktheCondDisBackTable(IPage<CyDiseasesDTO> page, LocalDateTime minTime, LocalDateTime maxTime, String disName, String uploadAdmin);

	//疾病百科审核列表

	List<CyDiseasesDTO>queryCyDiseasesCheckTable(IPage<CyDiseasesDTO> page);

	//根据疾病disId查详情

	List<CyDiseasesDTO>queryCyDiseasesById(Long disId);

	//后台疾病审核

	void alterDiseasesCheckStruts(Long disId, String disCheckStruts);

	//重新提交

	void alterSubmitDiseasesCheckStruts(Long disId,String disCheckStruts);


	//上线下线

	void alterDisExistStruts(Long disId,String disExistStruts);



	//根据疾病查id

	CyDiseases selectNameById(String disName);

	String selectBydisName(String disName);
}
