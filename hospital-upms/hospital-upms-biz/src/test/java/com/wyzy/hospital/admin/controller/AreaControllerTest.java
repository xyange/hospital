package com.wyzy.hospital.admin.controller;

import com.wyzy.hospital.admin.api.dto.doctor.AppDoctorDTO;
import com.wyzy.hospital.admin.service.AppDoctorService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

import java.util.List;

/**
 * @Author aqie
 * Date on 2021/4/15  17:46
 * @Function:
 */
@Component
@Slf4j
@SpringBootTest
public class AreaControllerTest{
    @Resource
    private AppDoctorService appDoctorService;

    @Test
    public void ListAll(){
        List<AppDoctorDTO> list=appDoctorService.listDoctorByHospital(null,null,3L);
       int i=0;
    }



}