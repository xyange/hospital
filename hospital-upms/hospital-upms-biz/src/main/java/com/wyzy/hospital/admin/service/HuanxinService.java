package com.wyzy.hospital.admin.service;

import com.wyzy.hospital.admin.api.dto.huanxin.HuanxinAccount;

/**
 * @Author aqie
 * Date on 2021/5/17  8:19
 * @Function:
 */
public interface HuanxinService {




    String HUANXIN_TOKEN_REDIS = "HUANXIN_TOKEN_REDIS";

    String REGISTER = "users";

    String TOKEN = "token";

    /**
     * 网络请求获取token
     */
    String getTokenFromNet();

    /**
     * 获取环信 token
     * @return
     */
    String getToken();

    /**
     * 注册环信用户
     * @param account
     */
    public Boolean registerHuanxin(HuanxinAccount account);
}
