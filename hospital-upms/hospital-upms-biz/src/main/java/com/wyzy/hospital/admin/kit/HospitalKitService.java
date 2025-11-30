package com.wyzy.hospital.admin.kit;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wyzy.hospital.admin.api.dto.hospital.AppHospitalDTO;
import com.wyzy.hospital.admin.api.dto.hospital.HospitalDetailDTO;
import com.wyzy.hospital.admin.api.dto.hospital.HospitalsDTO;
import com.wyzy.hospital.admin.api.vo.hospital.AppHospitalVO;

/**
 * @Author aqie
 * Date on 2021/4/17  11:35
 * @Function:
 */
public interface HospitalKitService {
    /**
     * 后台新增医院
     * @param hospitalsDTO
     * @return
     */
    public int save(HospitalsDTO hospitalsDTO);
    /**
     * 分页查询医院列表
     * @param page
     * @param hospitals
     * @return
     */
    IPage<HospitalsDTO> getHospitalsPage(IPage<HospitalsDTO> page, HospitalsDTO hospitals);

    /**
     * 根据科室获取医院列表
     * @param page
     * @param hospitalsDTO
     * @return
     */
    IPage<AppHospitalVO> getHospitalList(IPage<AppHospitalVO> page, AppHospitalDTO hospitalsDTO);

    /**
     * app 医院详情
     * @param userId
     * @param hospitalId
     * @return
     */
    HospitalDetailDTO detail(Long userId, Long hospitalId);
}
