
package com.wyzy.hospital.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyzy.hospital.admin.api.entity.ConsultatRoom;
import com.wyzy.hospital.admin.mapper.ConsultatRoomMapper;
import com.wyzy.hospital.admin.service.ConsultatRoomService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 诊室表
 *
 * @author hospital code generator
 * @date 2021-04-17 08:47:10
 */
@Service
public class ConsultatRoomServiceImpl extends ServiceImpl<ConsultatRoomMapper, ConsultatRoom> implements ConsultatRoomService {

    /**
     * 通过医院科室ID查询诊室表
     * @param
     * @return R
     */
    @Override
    public List<ConsultatRoom> getConsultatRoomByhosdepdetailId(Long hosdepdetailId) {
        return baseMapper.selectConsultatRoomByhosdepdetailId(hosdepdetailId);
    }

}
