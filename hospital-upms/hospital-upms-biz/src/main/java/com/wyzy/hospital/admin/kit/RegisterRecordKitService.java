package com.wyzy.hospital.admin.kit;

import com.wyzy.hospital.admin.api.entity.RegisterRecord;
import com.wyzy.hospital.common.core.util.R;

/**
 * @author wrk
 */
public interface RegisterRecordKitService {
    /**
     * 添加挂号记录
     *
     * @param registerRecord
     * @return java.lang.Boolean
     * @author wrk
     * @date 2021/05/13 14:53
     */
    R addRegisterRecord(RegisterRecord registerRecord);
}
