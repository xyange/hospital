

package com.wyzy.hospital.admin.mapper;

import com.wyzy.hospital.admin.api.entity.Disease;
import com.wyzy.hospital.admin.api.vo.AppDiseaseVO;
import com.wyzy.hospital.common.data.datascope.HospitalBaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 疾病表
 *
 * @author hospital code generator
 * @date 2021-04-19 13:45:04
 */
@Mapper
public interface DiseaseMapper extends HospitalBaseMapper<Disease> {
    /**
     * app患者端 显示在医生页 查常见疾病
     * @author
     * @date 2021/05/10 11:41
     * @return java.util.List<com.wyzy.hospital.admin.api.entity.Disease>
     */
    List<Disease> appListCommonDiseaseOnDoctor();

    /**
     * app患者端 显示在本地附近页 查常见疾病
     * @author
     * @date 2021/05/10 11:41
     * @return java.util.List<com.wyzy.hospital.admin.api.entity.Disease>
     */
    List<AppDiseaseVO>appListCommonDiseaseOnNeighborhood();

}
