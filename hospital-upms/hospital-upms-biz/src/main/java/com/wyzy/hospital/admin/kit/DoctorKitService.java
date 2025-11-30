package com.wyzy.hospital.admin.kit;

import com.wyzy.hospital.admin.api.dto.PcDoctorDTO;
import com.wyzy.hospital.common.core.util.R;

/**
 * 此层用来做复杂的逻辑处理，
 * 只要需要用到service层接口并进行逻辑处理的业务均放入此层
 *
 * @author Wrk
 */
public interface DoctorKitService {
    /**
     * 添加医生
     *
     * @param doctor 医生信息
     * @return java.lang.Boolean
     * @author
     * @date 2021/04/28 16:17
     */
    R<Boolean> addDoctor(PcDoctorDTO doctor);

    /**
     * 医生信息修改
     *
     * @param doctor 医生
     * @return java.lang.Boolean
     * @author wrk
     * @date 2021/04/29 16:43
     */
    Boolean editDoctorById(PcDoctorDTO doctor);
}
