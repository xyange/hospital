package com.wyzy.hospital.admin.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wyzy.hospital.admin.config.HuanxinConfiguration;
import com.wyzy.hospital.admin.api.dto.huanxin.HuanxinAccount;
import com.wyzy.hospital.admin.api.dto.huanxin.HuanxinError;
import com.wyzy.hospital.admin.api.dto.huanxin.HuanxinResponse;
import com.wyzy.hospital.admin.api.dto.huanxin.HuanxinTokenResponse;
import com.wyzy.hospital.admin.service.HuanxinService;
import com.wyzy.hospital.common.core.util.Func;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;

import static com.wyzy.hospital.common.core.constant.CommonConstants.SUCCESS_CODE;
import static org.springframework.http.MediaType.APPLICATION_JSON;

/**
 * @Author aqie
 * Date on 2021/5/17  8:19
 * @Function:
 */
@Service
@Slf4j
@EnableConfigurationProperties(HuanxinConfiguration.class)
public class HuanxinServiceImpl implements HuanxinService {

    @Autowired
    private HuanxinConfiguration config;

    @Autowired
    @Qualifier("restTemplate")
    private RestTemplate restTemplate;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    private HuanxinConfiguration huanxinConfiguration;

    private final String grantType = "client_credentials";


    @Override
    public String getTokenFromNet() {
        String tokenUrl = "http://"+config.getUrl()+"/"+config.getOrgName()+"/"+config.getAppName()+"/" + TOKEN;
        JSONObject json = new JSONObject();
        json.put("grant_type", grantType);
        json.put("client_id", huanxinConfiguration.getClientId());
        json.put("client_secret", huanxinConfiguration.getClientSecret());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(APPLICATION_JSON);
        HttpEntity<String> requestEntity = new HttpEntity<>(json.toString(), headers);


        HttpMethod method = HttpMethod.POST;
        ResponseEntity<HuanxinTokenResponse> response = restTemplate.exchange(tokenUrl, method, requestEntity, HuanxinTokenResponse.class);
        if (SUCCESS_CODE == response.getStatusCode().value()) {
            if(Func.isNotEmpty(response.getBody())){
                log.info("从网络获取token : {}", response.getBody().getAccess_token());
                redisTemplate.opsForValue().set(HUANXIN_TOKEN_REDIS, response.getBody().getAccess_token(), response.getBody().getExpires_in(), TimeUnit.SECONDS);
                return response.getBody().getAccess_token();
            }

        }
        return null;
    }

    @Override
    public String getToken() {
        String s = redisTemplate.opsForValue().get(HUANXIN_TOKEN_REDIS);
        if(Func.isNotBlank(s)){
            log.info("从缓存获取token : {}", s);
            return s;
        }
        return getTokenFromNet();
    }

    @Override
    public Boolean registerHuanxin(HuanxinAccount account) {
        String registerUrl = "http://"+config.getUrl()+"/"+config.getOrgName()+"/"+config.getAppName()+"/" + REGISTER;
        JSONObject json = new JSONObject();
        json.put("username", account.getUsername());
        json.put("password", account.getPassword());
        json.put("nickname", account.getNickname());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(APPLICATION_JSON);
        headers.add("Authorization", "Bearer " + getToken());
        HttpEntity<String> requestEntity = new HttpEntity<>(json.toString(), headers);


        HttpMethod method = HttpMethod.POST;
        try {
            ResponseEntity<HuanxinResponse> response = restTemplate.exchange(registerUrl, method, requestEntity, HuanxinResponse.class);
            log.info("response: {}", response);
            return true;
        } catch (HttpClientErrorException e) {
            String responseBodyAsString = e.getResponseBodyAsString();
            HuanxinError huanxinError = JSON.parseObject(responseBodyAsString, HuanxinError.class);
            log.error("error", huanxinError.getError());
            return false;
        }

    }
}
