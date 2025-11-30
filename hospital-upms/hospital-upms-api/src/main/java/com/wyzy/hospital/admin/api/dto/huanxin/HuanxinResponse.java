package com.wyzy.hospital.admin.api.dto.huanxin;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author aqie
 * Date on 2021/5/17  8:36
 * @Function:
 */
@NoArgsConstructor
@Data
public class HuanxinResponse {

    private int statusCode;
    private String path;
    private String uri;
    private long timestamp;
    private String organization;
    private String application;
    private List<HuanxinUser> entities;
    private String action;
    private List<?> data;
    private int duration;
    private String applicationName;


}
