package com.wyzy.hospital.admin.api.dto.huanxin;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author aqie
 * Date on 2021/5/17  16:24
 * @Function: 环信错误
 */
@NoArgsConstructor
@Data
public class HuanxinError {

    private String error;
    private String exception;
    private long timestamp;
    private int duration;
    private String error_description;
}
