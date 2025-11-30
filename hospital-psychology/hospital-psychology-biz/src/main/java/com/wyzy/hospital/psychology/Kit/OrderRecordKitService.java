

package com.wyzy.hospital.psychology.Kit;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wyzy.hospital.psychology.api.entity.OrderRecord;

/**
 * 预约记录表
 *
 * @author hospital code generator
 * @date 2021-06-08 08:43:43
 */
public interface OrderRecordKitService{

    /**
     * 新增预约记录表
     * @param memberId 会员ID
     * @param orderId 预约ID
     * @return
     */
    boolean saveorderRecord(Long memberId, Long orderId);
}
