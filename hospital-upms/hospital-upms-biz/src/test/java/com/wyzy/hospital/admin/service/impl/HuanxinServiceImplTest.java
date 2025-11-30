package com.wyzy.hospital.admin.service.impl;

import com.wyzy.hospital.admin.BaseTest;
import com.wyzy.hospital.admin.config.HuanxinConfiguration;
import com.wyzy.hospital.admin.api.dto.huanxin.HuanxinAccount;
import com.wyzy.hospital.admin.service.HuanxinService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * @Author aqie
 * Date on 2021/5/17  8:40
 * @Function:
 */
@Slf4j
@SpringBootTest
@EnableConfigurationProperties(HuanxinConfiguration.class)
class HuanxinServiceImplTest extends BaseTest {

    private MockMvc mvc;

    @Autowired
    private WebApplicationContext applicationContext; // 注入WebApplicationContext

    @BeforeEach
    public void setUp() {
        this.mvc = MockMvcBuilders.webAppContextSetup(applicationContext).build();
    }
    
    @Autowired
    private HuanxinService huanxinService;

    @Autowired
    private HuanxinConfiguration configuration;

    @Test
    void registerHuanxin() {
        HuanxinAccount account = HuanxinAccount.builder()
                .username("17732563923").password("123456").nickname("17732563921").build();
        Boolean b = huanxinService.registerHuanxin(account);
        Assertions.assertEquals(true, b);
    }

    @Test
    void testHuanxin() {
        String appName = configuration.getAppName();
        log.info("appName {}", appName);
        Assertions.assertEquals("hospital", appName);
    }

    public static void main(String[] args) {
        System.out.println("YWMtkFpa5rbfEeu3ExtrUXT_-gAAAAAAAAAAAAAAAAAAAAFJXm9-k5NDX5jRwbf0y9cVAgMAAAF5eS1iiQBPGgA1o8Ski59cpW4upuzfVGHjvg95aAwuAwg0EF4UtqR1TQ".length());
    }
}