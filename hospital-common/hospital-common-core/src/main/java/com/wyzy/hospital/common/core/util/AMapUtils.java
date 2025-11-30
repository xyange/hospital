package com.wyzy.hospital.common.core.util;

import javafx.beans.property.Property;

import java.util.List;

import static java.lang.Math.asin;
import static java.lang.Math.sin;

/**
 * gaodedituutil
 *
 * @author wrk
 * @date 2021/05/18 17:01
 **/
public class AMapUtils {
    //地球半径  （km）
    private static final double EARTH_RADIUS = 6371;

    /**
     * 根据用户的起点和终点经纬度计算两点间距离，此距离为相对较短的距离，单位米。
     *
     * @param start 起点的坐标
     * @param end   终点的坐标
     * @return
     */
    public static double calculateLineDistance(LngLat start, LngLat end) {
        if ((start == null) || (end == null)) {
            throw new IllegalArgumentException("非法坐标值，不能为null");
        }
        double d1 = 0.01745329251994329D;
        double d2 = start.longitude;
        double d3 = start.latitude;
        double d4 = end.longitude;
        double d5 = end.latitude;
        d2 *= d1;
        d3 *= d1;
        d4 *= d1;
        d5 *= d1;
        double d6 = sin(d2);
        double d7 = sin(d3);
        double d8 = Math.cos(d2);
        double d9 = Math.cos(d3);
        double d10 = sin(d4);
        double d11 = sin(d5);
        double d12 = Math.cos(d4);
        double d13 = Math.cos(d5);
        double[] arrayOfDouble1 = new double[3];
        double[] arrayOfDouble2 = new double[3];
        arrayOfDouble1[0] = (d9 * d8);
        arrayOfDouble1[1] = (d9 * d6);
        arrayOfDouble1[2] = d7;
        arrayOfDouble2[0] = (d13 * d12);
        arrayOfDouble2[1] = (d13 * d10);
        arrayOfDouble2[2] = d11;
        double d14 = Math.sqrt((arrayOfDouble1[0] - arrayOfDouble2[0]) * (arrayOfDouble1[0] - arrayOfDouble2[0])
                + (arrayOfDouble1[1] - arrayOfDouble2[1]) * (arrayOfDouble1[1] - arrayOfDouble2[1])
                + (arrayOfDouble1[2] - arrayOfDouble2[2]) * (arrayOfDouble1[2] - arrayOfDouble2[2]));

        return (asin(d14 / 2.0D) * 12742001.579854401D);
    }

    /**
     * 计算经纬度范围
     *
     * @param longitude 经度
     * @param latitude  纬度
     * @param distance  距离
     * @return com.wyzy.hospital.common.core.util.MinMaxLngLat
     * @author wrk
     * @date 2021/05/19 16:24
     */
    public static  MinMaxLngLat calculateLonLat(double longitude, double latitude, double distance) {
        //先计算查询点的经纬度范围
        double dlng = 2 * Math.asin(Math.sin(distance / (2 * EARTH_RADIUS)) / Math.cos(latitude * Math.PI / 180));
        //角度转为弧度
        dlng = dlng * 180 / Math.PI;
        double dlat = distance / EARTH_RADIUS;
        dlat = dlat * 180 / Math.PI;
        double minlat = latitude - dlat;
        double maxlat = latitude + dlat;
        double minlng = longitude - dlng;
        double maxlng = longitude + dlng;
        return new MinMaxLngLat(minlng, maxlng, minlat, maxlat);
    }
}
