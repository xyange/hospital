

package com.wyzy.hospital.admin.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wyzy.hospital.admin.api.dto.hospital.AppHospitalDTO;
import com.wyzy.hospital.admin.api.dto.hospital.HospitalDetailDTO;
import com.wyzy.hospital.admin.api.dto.hospital.HospitalsDTO;
import com.wyzy.hospital.admin.api.dto.HospitalNeighborhoodDTO;
import com.wyzy.hospital.admin.api.entity.Hospitals;
import com.wyzy.hospital.admin.api.vo.hospital.AppHospitalVO;

import java.util.List;

/**
 * 医院表
 *
 * @author aqie
 * @date 2021-04-15 15:42:23
 */
public interface HospitalsService extends IService<Hospitals> {
    /**
     * 新增医院
     * @param hospitalsDTO
     * @return
     */
    public int save(HospitalsDTO hospitalsDTO);


    /**
     * 根据查询条件 查询医院列表
     * @param
     * @return
     */
    public IPage<HospitalsDTO> selectList(IPage page, LambdaQueryWrapper<Hospitals> queryWrapper);

    /**
     * app 查询医院列表
     * @param
     * @return
     */
    List<AppHospitalDTO> getHospitalList(IPage<AppHospitalVO> page, AppHospitalDTO hospitalsDT);

    /**
     * 医院详情
     * @param
     * @return
     */
    HospitalDetailDTO detail(long hospitalId);

    /**
    * @Description: app 多条件筛选医院（本地附近）
    * @Param: [distance, lon, lat, deportmentId, diseaseId, area, keyWord]
    * @return: java.util.List<com.wyzy.hospital.admin.api.dto.HospitalNeighborhoodDTO>
    * @Author: songM
    * @Date: 2021/6/3
    */
    List<HospitalNeighborhoodDTO> getNeighborhoodHospitals(Double distance, String lon, String lat, Long deportmentId, Long diseaseId, String area, String keyWord);

}
