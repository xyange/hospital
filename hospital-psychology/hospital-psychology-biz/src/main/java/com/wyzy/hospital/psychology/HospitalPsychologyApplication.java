package com.wyzy.hospital.psychology;

import com.wyzy.hospital.common.feign.annotation.EnableHospitalFeignClients;
import com.wyzy.hospital.common.security.annotation.EnableHospitalResourceServer;
import com.wyzy.hospital.common.swagger.annotation.EnableHospitalSwagger2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author Hospital archetype
 * <p>
 * 项目启动类
 */
@EnableHospitalSwagger2
@EnableHospitalFeignClients
/*开启feign*/
@EnableDiscoveryClient
@EnableHospitalResourceServer
@SpringBootApplication
@ServletComponentScan
public class HospitalPsychologyApplication {
    public static void main(String[] args) {
        SpringApplication.run(HospitalPsychologyApplication.class, args);
    }


}
