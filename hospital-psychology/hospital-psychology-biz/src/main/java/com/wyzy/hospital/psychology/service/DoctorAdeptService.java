

package com.wyzy.hospital.psychology.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wyzy.hospital.psychology.api.dto.DoctorAdeptDTO;
import com.wyzy.hospital.psychology.api.entity.DoctorAdept;

/**
 * 心理医生擅长表
 *
 * @author hospital code generator
 * @date 2021-06-10 09:20:14
 */
public interface DoctorAdeptService extends IService<DoctorAdept> {

    /**
     * 分页查询
     * @return
     */
    IPage<DoctorAdeptDTO> pageDoctorAdept(IPage<DoctorAdeptDTO> page);

    /**
     * 新增心理医生擅长表
     * @param doctorAdept 心理医生擅长表
     * @return R
     */
    boolean saveDoctorAdept(DoctorAdept doctorAdept);
}
