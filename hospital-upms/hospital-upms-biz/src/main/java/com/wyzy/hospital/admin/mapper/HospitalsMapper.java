

package com.wyzy.hospital.admin.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wyzy.hospital.admin.api.dto.HospitalNeighborhoodDTO;
import com.wyzy.hospital.admin.api.dto.hospital.AppHospitalDTO;
import com.wyzy.hospital.admin.api.dto.hospital.HospitalDetailDTO;
import com.wyzy.hospital.admin.api.entity.Hospitals;
import com.wyzy.hospital.admin.api.vo.hospital.AppHospitalVO;
import com.wyzy.hospital.common.core.util.MinMaxLngLat;
import com.wyzy.hospital.common.data.datascope.HospitalBaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 医院表
 *
 * @author aqie
 * @date 2021-04-15 15:42:23
 */
@Mapper
public interface HospitalsMapper extends HospitalBaseMapper<Hospitals> {

    /**
     * 查询医院列表
     * @param hospitalsDTO
     * @return
     */
    List<AppHospitalDTO> getHospitalList(IPage<AppHospitalVO> page, @Param("param1") AppHospitalDTO hospitalsDTO);

    /**
     * 查询app医院详情
     * @param
     * @return
     */
    HospitalDetailDTO appDetail(long  hospitalId);

    /**
    * @Description: app 多条件筛选医院（本地附近）
    * @Param: [geoCode, deportmentId, diseaseId, area, keyWord, minMaxLngLat]
    * @return: java.util.List<com.wyzy.hospital.admin.api.dto.ClinicNeighborhoodDTO>
    * @Author: songM
    * @Date: 2021/6/3
    */
    List<HospitalNeighborhoodDTO> getNeighborhoodHospitals(@Param("deportmentId") Long deportmentId, @Param("diseaseId") Long diseaseId, @Param("area") String area, @Param("keyWord") String keyWord, @Param("minMaxLngLat") MinMaxLngLat minMaxLngLat);
}
