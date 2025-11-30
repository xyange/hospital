package com.wyzy.hospital.admin.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Author aqie
 * Date on 2021/5/17  16:47
 * @Function:
 */
@Data
@ConfigurationProperties(prefix = "huanxin")
public class HuanxinConfiguration {
    private String url;

    private String appName;

    private String orgName;

    private String clientId;

    private String clientSecret;
}
