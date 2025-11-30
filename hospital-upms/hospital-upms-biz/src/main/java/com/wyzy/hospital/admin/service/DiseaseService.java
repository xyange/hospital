

package com.wyzy.hospital.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wyzy.hospital.admin.api.entity.Disease;
import com.wyzy.hospital.admin.api.vo.AppDiseaseVO;

import java.util.List;

/**
 * 疾病表
 *
 * @author hospital code generator
 * @date 2021-04-19 13:45:04
 */
public interface DiseaseService extends IService<Disease> {

    /**
     * 查常见疾病 按排序码排序 在患者端医生页显示
     * @author wrk
     * @date 2021/05/10 11:34
     * @return java.util.List<com.wyzy.hospital.admin.api.entity.Disease>
     */
    List<Disease> appListCommonDiseaseOnDoctor();

    /**
     * 查常见疾病 按排序码排序  在app患者端本地附近显示
     * @author wrk
     * @date 2021/05/10 11:34
     * @return java.util.List<com.wyzy.hospital.admin.api.entity.Disease>
     */
    List<AppDiseaseVO> appListCommonDiseaseOnNeighborhood();

}
