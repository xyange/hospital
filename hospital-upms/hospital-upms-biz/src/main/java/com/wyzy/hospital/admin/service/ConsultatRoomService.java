

package com.wyzy.hospital.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wyzy.hospital.admin.api.entity.ConsultatRoom;

import java.util.List;

/**
 * 诊室表
 *
 * @author hospital code generator
 * @date 2021-04-17 08:47:10
 */
public interface ConsultatRoomService extends IService<ConsultatRoom> {

    /**
     * 通过医院科室ID查询诊室表
     * @param
     * @return R
     */
    List<ConsultatRoom> getConsultatRoomByhosdepdetailId(Long hosdepdetailId);

}
