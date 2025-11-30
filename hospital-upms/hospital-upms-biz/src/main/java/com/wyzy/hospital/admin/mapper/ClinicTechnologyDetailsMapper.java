

package com.wyzy.hospital.admin.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wyzy.hospital.admin.api.dto.ClinicDTO;
import com.wyzy.hospital.admin.api.entity.ClinicDiagnosis;
import com.wyzy.hospital.admin.api.entity.ClinicTechnologyDetails;
import com.wyzy.hospital.common.data.datascope.HospitalBaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 诊所诊疗技术详情表
 *
 * @author songM
 * @date 2021-05-15 11:33:37
 */
@Mapper
public interface ClinicTechnologyDetailsMapper extends HospitalBaseMapper<ClinicTechnologyDetails> {
    /**
    * @Description:  根据诊所Id查所有的诊疗方案
    * @Param: [clinicId] 诊所id
    * @return: java.util.List<com.wyzy.hospital.admin.api.dto.ClinicDiagnosisTechnologyDTO>
    * @Author: songM
    * @Date: 2021/5/17
    */
    List<ClinicDiagnosis> getDiagnosisByClinicId(@Param("clinicDTO") ClinicDTO clinicDTO);
    /**
    * @Description: 通过技术id查询诊疗技术
    * @Param: [technologyId] 诊疗技术id
    * @return: com.wyzy.hospital.admin.api.entity.ClinicTechnologyDetails
    * @Author: songM
    * @Date: 2021/5/17
    */
    ClinicTechnologyDetails getClinicTechnologyByTechnologyId(@Param("technologyId") Integer technologyId);
    /**
    * @Description: 获取诊疗技术通过诊所id
    * @Param: [clinicDTO]
    * @return: java.util.List com.wyzy.hospital.admin.api.entity.ClinicTechnologyDetails>
    * @Author: songM
    * @Date: 2021/5/29
    */
    List<ClinicTechnologyDetails> getClinicTechnologyByClinicId(@Param("clinicDTO") ClinicDTO clinicDTO);
    /**
    * @Description: 根据诊疗项目id查诊疗技术列表
    * @Param: [page, clinicDTO]
    * @return: java.util.List<com.wyzy.hospital.admin.api.entity.ClinicDiagnosis>
    * @Author: songM
    * @Date: 2021/5/31
    */
    List<ClinicTechnologyDetails> getTechnologyListByDiagnosisId(@Param("page")IPage<ClinicTechnologyDetails> page,@Param("clinicDTO") ClinicDTO clinicDTO);
}
