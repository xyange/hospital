
package com.wyzy.hospital.admin.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyzy.hospital.admin.api.dto.consult.ConsultOrderDTO;
import com.wyzy.hospital.admin.api.entity.ConsultOrder;
import com.wyzy.hospital.admin.mapper.ConsultOrderMapper;
import com.wyzy.hospital.admin.mapper.ConsultSettingMapper;
import com.wyzy.hospital.admin.service.ConsultOrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.List;

/**
 * 远程会诊预约表
 *
 * @author hospital code generator
 * @date 2021-06-15 11:44:57
 */
@Service
public class ConsultOrderServiceImpl extends ServiceImpl<ConsultOrderMapper, ConsultOrder> implements ConsultOrderService {
    @Resource
    ConsultSettingMapper consultSettingMapper;

    @Override
    @Transactional(rollbackFor=Exception.class)
    public boolean saveConsultOrder(ConsultOrder consultOrder) {
        /**
         * 查重
         */
        ConsultOrder order = baseMapper.selectConsultOrderByconsultOrder(consultOrder);
        if (order == null){
            int insert = baseMapper.insert(consultOrder);
            if (insert>0){
                boolean updateAlreadyById = consultSettingMapper.updateAlreadyById(consultOrder.getOrderId());
                if (updateAlreadyById){
                    return true;
                }
            }
        }
        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        return false;
    }

    /**
     * 分页查询
     * @return
     */
    @Override
    public IPage<ConsultOrder> pageConsultOrder(IPage<ConsultOrder> page, Long memberId) {
        /**
         * 查看会员ID下预约记录
         * @param memberId
         * @return
         */
        List<ConsultOrder> consultOrderList = baseMapper.pageConsultOrder(memberId);
        IPage<ConsultOrder> consultOrderIPage = page.setRecords(consultOrderList);
        return consultOrderIPage;
    }

    /**
    * @Description: 查询会诊订单
    * @Param: [page, consultOrder]
    * @return: java.util.List<com.wyzy.hospital.admin.api.entity.ConsultOrder>
    * @Author: songM
    * @Date: 2021/6/16
    */
    @Override
    public List<ConsultOrderDTO> selectConsultOrderListByMemberId(IPage<ConsultOrderDTO> page, ConsultOrderDTO consultOrder) {
        return baseMapper.selectConsultOrderListByMemberId(page,consultOrder);
    }
}
