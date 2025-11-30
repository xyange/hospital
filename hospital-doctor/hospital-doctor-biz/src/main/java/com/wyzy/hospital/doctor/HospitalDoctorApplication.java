package com.wyzy.hospital.doctor;

import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.common.feign.annotation.EnableHospitalFeignClients;
import com.wyzy.hospital.common.security.annotation.EnableHospitalResourceServer;
import com.wyzy.hospital.common.swagger.annotation.EnableHospitalSwagger2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Hospital archetype
 * <p>
 * 项目启动类
 */
@EnableHospitalSwagger2
@EnableHospitalFeignClients
@EnableDiscoveryClient
@EnableHospitalResourceServer
@SpringBootApplication
public class HospitalDoctorApplication {
    public static void main(String[] args) {
        SpringApplication.run(HospitalDoctorApplication.class, args);
    }


}
