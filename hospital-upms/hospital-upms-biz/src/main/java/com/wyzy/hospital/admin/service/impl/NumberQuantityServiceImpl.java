package com.wyzy.hospital.admin.service.impl;

import com.wyzy.hospital.admin.api.dto.doctor.DoctorServeDTO;
import com.wyzy.hospital.admin.api.dto.numberquantity.NumberQuantityDTO;
import com.wyzy.hospital.admin.api.dto.numberquantity.NumberQuantityDetailsDTO;
import com.wyzy.hospital.admin.mapper.NumberQuantityMapper;
import com.wyzy.hospital.admin.service.NumberQuantityService;
import com.wyzy.hospital.common.core.util.DayUtil;
import com.wyzy.hospital.common.core.util.R;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * 号源情况
 *
 * @author wrk
 * @date 2021/05/12 16:58
 **/
@Service
public class NumberQuantityServiceImpl implements NumberQuantityService {
    @Resource
    private NumberQuantityMapper numberQuantityMapper;
    @Override
    public List<NumberQuantityDTO> getNumberQuantity(Long hospitalId,String hospitalName, Long deportmentId,String deportmentName, Integer nearDays) {
       LocalDate nowDate= LocalDate.now();
        List<NumberQuantityDTO> finalList=new ArrayList<>();
        List<NumberQuantityDTO> list=numberQuantityMapper.getNumberQuantity(hospitalId,hospitalName,deportmentId,deportmentName,nearDays);
        String hospitalNameDba=hospitalName;
        String deportmentNameDba=deportmentName;
        if(list.size()>0){
            hospitalNameDba=list.get(0).getHospitalName();
            deportmentNameDba=list.get(0).getDepartmentName();
        }

        for(long i=0;i<nearDays;i++){
            Boolean isHave=false;
            NumberQuantityDTO numQuaDTO=new NumberQuantityDTO();
            for(NumberQuantityDTO num:list){
                if(nowDate.equals(num.getOrderDate())){
                    isHave=true;
                    numQuaDTO=num;
                }
            }
            if(isHave){
                numQuaDTO.setWeek(DayUtil.getWeek(numQuaDTO.getOrderDate().toString()));
                finalList.add(numQuaDTO);
            }else{
                NumberQuantityDTO num=new NumberQuantityDTO();
                num.setHospitalId(hospitalId);
                num.setHospitalName(hospitalNameDba);
                num.setDepartmentName(deportmentNameDba);
                num.setDeportmentId(deportmentId);
                num.setTotalQuantity(0);
                num.setSurplusQuantity(0);
                num.setOrderDate(nowDate);
                num.setWeek(DayUtil.getWeek(num.getOrderDate().toString()));
                finalList.add(num);
            }
            nowDate= nowDate.plusDays(1L);
        }
        return finalList;
    }

    @Override
    public List<NumberQuantityDetailsDTO> getNumberQuantityDetail(Long hospitalId, String hospitalName, Long deportmentId, String deportmentName, LocalDate registrationDate) {
        List<NumberQuantityDetailsDTO> list=numberQuantityMapper.getNumberQuantityDetail(hospitalId,hospitalName, deportmentId, deportmentName,registrationDate);
        return list;
    }

    @Override
    public Boolean minusDateNumberQuantity(Long hospitalId, Long deportmentId, Long doctorId, LocalDate date, Integer timeSlot) {
        return numberQuantityMapper.minusDateNumberQuantity(hospitalId, deportmentId, doctorId, date, timeSlot)==1?true:false;
    }

    @Override
    public Integer getDetailNumberQuantity(Long hospitalId, Long deportmentId, Long doctorId, LocalDate date, Integer timeSlot){
        return numberQuantityMapper.getDetailNumberQuantity(hospitalId, deportmentId, doctorId, date, timeSlot);
    }
}
