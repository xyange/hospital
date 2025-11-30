
package com.wyzy.hospital.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sun.media.jfxmediaimpl.HostUtils;
import com.wyzy.hospital.admin.api.dto.RegisterRecordDTO;
import com.wyzy.hospital.admin.api.entity.RegisterRecord;
import com.wyzy.hospital.admin.mapper.RegisterRecordMapper;
import com.wyzy.hospital.admin.service.RegisterRecordService;
import com.wyzy.hospital.common.security.service.HospitalUser;
import com.wyzy.hospital.common.security.util.SecurityUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.List;

/**
 * 挂号记录
 *
 * @author aqie
 * @date 2021-04-26 15:27:25
 */
@Service
public class RegisterRecordServiceImpl extends ServiceImpl<RegisterRecordMapper, RegisterRecord> implements RegisterRecordService {

    @Override
    public Map<String, Object> getPrivateDoctorDetail(String doctorName, Long doctorId) {
        Map<String, Object> mapData = baseMapper.getPrivateDoctorDetail(doctorName, doctorId);
       if(mapData==null){
           return null;
       }
        String priceDayNumbers = mapData.get("priceDayNumbers").toString();
        String[] dayNumber = priceDayNumbers.split(",");
        List<Map<String, Object>> list = new ArrayList<>();
        for (String s : dayNumber) {
            String[] dayNumber2 = s.split("，");
            for (String s2 : dayNumber2) {
                Map<String, Object> oneMap = new HashMap<>(16);
                oneMap.put("price", s2.split("_")[0]);
                oneMap.put("dayNumber", s2.split("_")[1]);
                list.add(oneMap);
            }
        }
        mapData.put("priceDayNumbers",list);
        return mapData;
    }
    /**
     * 通过就诊卡ID查询挂号记录
     * @param cardId 就诊卡ID
     * @return R
     */
    @Override
    public List<RegisterRecordDTO> getPojoByCardId(Long cardId) {
        Long userId=null;
        if(cardId==null){
             userId = SecurityUtils.getUser().getId();
        }
        return baseMapper.selectPojoByCardId(cardId,userId);
    }
}