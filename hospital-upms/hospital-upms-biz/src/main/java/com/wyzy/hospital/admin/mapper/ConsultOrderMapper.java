

package com.wyzy.hospital.admin.mapper;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wyzy.hospital.admin.api.dto.consult.ConsultOrderDTO;
import com.wyzy.hospital.admin.api.entity.ConsultOrder;
import com.wyzy.hospital.common.data.datascope.HospitalBaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 远程会诊预约表
 *
 * @author hospital code generator
 * @date 2021-06-15 11:44:57
 */
@Mapper
public interface ConsultOrderMapper extends HospitalBaseMapper<ConsultOrder> {

    /**
     * 查重
     * @param consultOrder
     * @return
     */
    ConsultOrder selectConsultOrderByconsultOrder(@Param("consultOrder") ConsultOrder consultOrder);

    /**
     * 查看会员ID下预约记录
     * @param memberId
     * @return
     */
    List<ConsultOrder> pageConsultOrder(@Param("memberId") Long memberId);

    /**
    * @Description: 查询会诊订单
    * @Param: [page, consultOrder]
    * @return: java.util.List<com.wyzy.hospital.admin.api.entity.ConsultOrder>
    * @Author: songM
    * @Date: 2021/6/16
    */
    List<ConsultOrderDTO> selectConsultOrderListByMemberId(@Param("page") IPage<ConsultOrderDTO> page, @Param("consultOrder") ConsultOrderDTO consultOrder);

    /**
     * 插入
     * @param consultOrder
     * @return
     */
    int insertConsultOrder(@Param("pojo") ConsultOrder consultOrder);
}
