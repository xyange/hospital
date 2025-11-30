package com.wyzy.hospital.admin.service.impl;

import ch.hsr.geohash.GeoHash;
import cn.hutool.core.convert.Convert;
import com.wyzy.hospital.common.core.util.AMapUtils;
import com.wyzy.hospital.common.core.util.LngLat;
import org.junit.jupiter.api.Test;
import org.locationtech.spatial4j.context.SpatialContext;
import org.locationtech.spatial4j.distance.DistanceUtils;
import org.locationtech.spatial4j.io.GeohashUtils;
import org.locationtech.spatial4j.shape.Point;

import static org.junit.jupiter.api.Assertions.*;

class ClinicServiceImplTest {

    @Test
    void appGetClinicListBy() {
        // 艾特 115.682979,37.740753

        String lon = "115.682979";
        String lat = "37.740753";
        Double latDou = Convert.convert(Double.class, lat);
        Double lonDou = Convert.convert(Double.class, lon);
        // 衡水北站 115.675089,37.772833
        String lonTwo = "115.675089";
        String latTwo = "37.772833";
        Double latDouTwo = Convert.convert(Double.class, latTwo);
        Double lonDouTwo = Convert.convert(Double.class, lonTwo);


        LngLat lngLatOne=new LngLat(lonDou,latDou);
        LngLat lngLatTwo=new LngLat(lonDouTwo,latDouTwo);
        Double dis= AMapUtils.calculateLineDistance(lngLatOne,lngLatTwo);
        System.out.println("方法1------>");
        System.out.println(dis+" m");

        SpatialContext geo = SpatialContext.GEO;
        double distance = geo.calcDistance(geo.makePoint(lonDou, latDou), geo.makePoint(lonDouTwo, latDouTwo))
                * DistanceUtils.DEG_TO_KM;
        System.out.println("方法2------>");
        System.out.println(distance +" km");// KM

    }
}