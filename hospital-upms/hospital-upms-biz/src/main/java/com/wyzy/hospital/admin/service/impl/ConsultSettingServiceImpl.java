
package com.wyzy.hospital.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyzy.hospital.admin.api.dto.ConsultSettingDTO;
import com.wyzy.hospital.admin.api.entity.ConsultSetting;
import com.wyzy.hospital.admin.mapper.ConsultSettingMapper;
import com.wyzy.hospital.admin.service.ConsultSettingService;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 远程会诊预约配置表
 *
 * @author hospital code generator
 * @date 2021-06-15 11:44:52
 */
@Service
public class ConsultSettingServiceImpl extends ServiceImpl<ConsultSettingMapper, ConsultSetting> implements ConsultSettingService {

    /**
     * 根据doctorId查看预约时间
     * @param doctorId 医生id
     * @return R
     */
    @Override
    public List<ConsultSettingDTO> getTimeByDoctorId(Long doctorId) {
        /**
         * 查看医生可预约时间
         */
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String three_days_after = sdf.format(new Date());
        //系统当前时间
        LocalDateTime localDateTime = LocalDateTime.parse(three_days_after, df);
        String localTime = df.format(localDateTime);
        String substring = localTime.substring(0,10);

        List<ConsultSettingDTO> localDateTimeList = baseMapper.getTimeByDoctorId(doctorId,substring);
        List<ConsultSettingDTO> list = new ArrayList<>();

        for (ConsultSettingDTO consultSetting : localDateTimeList) {
            String dateTime = consultSetting.getDateTime() + " " + consultSetting.getOrderTime()+":00";
            //表时间
            LocalDateTime ldt = LocalDateTime.parse(dateTime, df);
            Duration duration = Duration.between(localDateTime,ldt);
            long l = duration.toMinutes();
            if (l>0){
                consultSetting.setHour(l);
                consultSetting.setTime(ldt+":00");
                list.add(consultSetting);
            }
        }
        return list;
    }

    @Override
    public boolean saveConsultSetting(ConsultSetting consultSetting) {
        ConsultSetting pojo = new ConsultSetting();
        /**
         * 根据医生ID和预约时间查询
         */
        pojo.setDoctorId(consultSetting.getDoctorId());
        pojo.setDateTime(consultSetting.getDateTime());
        pojo.setOrderTime(consultSetting.getOrderTime());
        ConsultSetting setting = baseMapper.selectConsultSettingByPojo(pojo);
        if (setting == null){
            int insert = baseMapper.insert(consultSetting);
            if (insert>0){
                return true;
            }
        }
        return false;
    }
}
