

package com.wyzy.hospital.admin.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wyzy.hospital.admin.api.dto.consult.ConsultOrderDTO;
import com.wyzy.hospital.admin.api.entity.ConsultOrder;

import java.util.List;

/**
 * 远程会诊预约表
 *
 * @author hospital code generator
 * @date 2021-06-15 11:44:57
 */
public interface ConsultOrderService extends IService<ConsultOrder> {

    /**
     * 新增远程会诊预约表
     * @param consultOrder 远程会诊预约表
     * @return R
     */
    boolean saveConsultOrder(ConsultOrder consultOrder);

    /**
     * 分页查询
     * @return
     */
    IPage<ConsultOrder> pageConsultOrder(IPage<ConsultOrder> page, Long memberId);

    /**
     * 查询会诊订单
     * @param page
     * @param consultOrder
     * @return
     */
    List<ConsultOrderDTO> selectConsultOrderListByMemberId(IPage<ConsultOrderDTO> page, ConsultOrderDTO consultOrder);
}
