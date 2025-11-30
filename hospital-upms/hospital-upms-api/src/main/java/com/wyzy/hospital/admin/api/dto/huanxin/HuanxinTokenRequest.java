package com.wyzy.hospital.admin.api.dto.huanxin;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author aqie
 * Date on 2021/5/17  15:30
 * @Function:
 */
@NoArgsConstructor
@Data
public class HuanxinTokenRequest {

    private String grant_type = "client_credentials";
    private String client_id = "YXA6SV5vfpOTQ1-Y0cG39MvXFQ";
    private String client_secret = "YXA63KJVA2W_JqwsIy_aiphqEXdFv_w";
}
