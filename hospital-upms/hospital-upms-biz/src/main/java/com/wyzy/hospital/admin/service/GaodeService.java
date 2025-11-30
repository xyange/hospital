package com.wyzy.hospital.admin.service;

import com.wyzy.hospital.admin.api.dto.gaode.GeoResponse;

/**
 * @Author aqie
 * Date on 2021/5/17  18:12
 * @Function: 高德地图相关
 */
public interface GaodeService {
    /**
     * 地理编码API
     */
    String geoUrl = "https://restapi.amap.com/v3/geocode/geo";

    /**
     * 路径规划
     */
    String distance = "https://restapi.amap.com/v3/direction/driving?origin=116.45925,39.910031&destination=116.587922,40.081577&key=<用户的key>";

    /**
     * web 服务 地理编码API
     * 结构化地址举例：北京市朝阳区阜通东大街6号转换后经纬度：116.480881,39.989410
     * 地标性建筑举例：天安门转换后经纬度：116.397499,39.908722
     * @param address
     * @return
     */
    GeoResponse geo(String address);

}
