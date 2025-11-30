package com.wyzy.hospital.admin.service.impl;

import com.wyzy.hospital.admin.BaseTest;
import com.wyzy.hospital.admin.api.dto.gaode.GeoResponse;
import com.wyzy.hospital.admin.service.GaodeService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author aqie
 * Date on 2021/5/17  18:27
 * @Function:
 */
@Slf4j
class GaodeServiceImplTest extends BaseTest {
    @Autowired
    private GaodeService gaodeService;

    @Test
    void test(){
        GeoResponse res = gaodeService.geo("北京市朝阳区阜通东大街6号");
        log.info("res {}", res);
        Assertions.assertEquals("110105", res.getGeocodes().get(0).getAdcode());
    }
}