package com.wyzy.hospital.admin.service.impl;

import com.wyzy.hospital.admin.api.dto.doctor.AppDoctorDetail;
import com.wyzy.hospital.admin.api.dto.doctor.DoctorServeDTO;
import com.wyzy.hospital.admin.api.dto.doctor.PrivateDoctorServeDTO;
import com.wyzy.hospital.admin.api.vo.AppDoctorDetailVO;
import com.wyzy.hospital.admin.service.AppDoctorKitService;
import com.wyzy.hospital.admin.service.AppDoctorService;
import com.wyzy.hospital.admin.service.RegisterRecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * AppDoctorKitService
 *
 * @author wrk
 * @date 2021/05/26 10:33
 **/
@Service
public class AppDoctorKitServiceImpl implements AppDoctorKitService {
    private static final Integer PRIVATE_DOCTOR=125;
    @Resource
    private AppDoctorService appDoctorService;
    @Resource
    private RegisterRecordService registerRecordService;

    @Override
    public AppDoctorDetailVO appDoctorDetailVo(Long id, Long userId) {
        AppDoctorDetail appDoctorDetail=new AppDoctorDetail();
        appDoctorDetail= appDoctorService.appDoctorDetail(id,userId);
        List<Object> servesObject=new ArrayList<>();
        List<DoctorServeDTO> serves=appDoctorDetail.getDoctorServe();
        Map<String,Object> mapData= registerRecordService.getPrivateDoctorDetail(null,id);
        for(DoctorServeDTO s:serves){
            if(PRIVATE_DOCTOR.equals(s.getServiceId())){
                PrivateDoctorServeDTO pd= s.createPrivateDoctorServeDTO(s);
                pd.setPrivateDoctor(mapData);
                servesObject.add(pd);
            }else{
                servesObject.add(s);
            }
        }
        AppDoctorDetailVO vo=appDoctorDetail.transfer();
        vo.setDoctorServe(servesObject);
        return vo;
    }
}
