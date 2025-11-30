package com.wyzy.hospital.admin.api.dto.huanxin;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author aqie
 * Date on 2021/5/17  15:28
 * @Function:
 */
@NoArgsConstructor
@Data
public class HuanxinTokenResponse {

    private String application;
    private String access_token;
    private int expires_in;
}
