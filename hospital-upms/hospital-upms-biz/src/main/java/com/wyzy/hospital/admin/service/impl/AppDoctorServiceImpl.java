package com.wyzy.hospital.admin.service.impl;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.PageUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.excel.util.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wyzy.hospital.admin.api.dto.ClinicNeighborhoodDTO;
import com.wyzy.hospital.admin.api.dto.doctor.AppDoctorDTO;
import com.wyzy.hospital.admin.api.dto.doctor.AppDoctorDetail;
import com.wyzy.hospital.admin.mapper.AppDoctorMapper;
import com.wyzy.hospital.admin.service.AppDoctorService;
import com.wyzy.hospital.common.core.util.AMapUtils;
import com.wyzy.hospital.common.core.util.MinMaxLngLat;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.common.mybatis.support.Query;
import com.wyzy.hospital.common.security.util.SecurityUtils;
import org.locationtech.spatial4j.context.SpatialContext;
import org.locationtech.spatial4j.distance.DistanceUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/**
 * AppDoctorService实现类
 *
 * @author wrk
 * @date 2021/04/16 16:40
 **/
@Service
public class AppDoctorServiceImpl implements AppDoctorService {
    @Resource
    private AppDoctorMapper appDoctorMapper;

    @Override
    public List<AppDoctorDTO> listAllDoctorBy(String keyWord, String area, Long departmentId, String sortCode, Long serviceId, Integer priceBegin, Integer priceEnd, Long professionalTitleId, Page page) {
        Integer pageBegin = PageUtil.getStart((int) (page.getCurrent() - 1), (int) page.getSize());
        Integer pageSize = ((Long) page.getSize()).intValue();
        String ids = appDoctorMapper.listDoctorIdByDisease(keyWord);
        if (ids == null || ids == "") {
            return null;
        }
        return appDoctorMapper.listAllDoctorBy(keyWord, ids, area, departmentId, sortCode, serviceId, priceBegin, priceEnd, professionalTitleId, pageBegin, pageSize);
    }

    @Override
    public List<AppDoctorDTO> listDoctorByHospital(Long beginNum, Integer pageSize, Long hospitalId) {
        return appDoctorMapper.listDoctorByHospital(beginNum, pageSize, hospitalId);
    }

    @Override
    public List<AppDoctorDTO> getCollectedDoctors() {
        return appDoctorMapper.getCollectedDoctors(SecurityUtils.getUser().getId().longValue());
    }

    @Override
    public R<Boolean> collectedDoctor(Long sysUserId, Long doctorId) {
        //查是否收藏
        Map<String, Object> map = appDoctorMapper.isCollect(doctorId, sysUserId);
        Boolean flag = false;
        if (map == null) {
            //收藏操作
            flag = (appDoctorMapper.collectDoctor(doctorId, sysUserId) > 0) ? true : false;
            if (flag) {
                return R.ok(flag, "收藏成功");
            }
            return R.ok(flag, "收藏失败");
        } else {
            //取消收藏操作
            flag = (appDoctorMapper.cancelCollectDoctor(doctorId, sysUserId) > 0) ? true : false;
            if (flag) {
                return R.ok(flag, "取消收藏成功");
            }
            return R.ok(flag, "取消收藏失败");
        }

    }

    @Override
    public List<AppDoctorDTO> appDoctorRecommend(Long deportmentId, Long doctorId, String deportmentName, String doctorName) {
        return appDoctorMapper.appDoctorRecommend(deportmentId, doctorId, deportmentName, doctorName);
    }

    @Override
    public AppDoctorDetail appDoctorDetail(Long id, Long userId) {
        return appDoctorMapper.appDoctorDetail(id, userId);
    }

    @Override
    public List<AppDoctorDTO> getDoctorByFilter(String lng, String lat, Double distance, Query query,
                                                String area, Long diseaseId, String diseaseName,
                                                Long deportmentId, String doctorName, String sortCode,
                                                Long serveId, Integer priceBegin, Integer priceEnd,
                                                Long professionalTitleId,Integer wellKnown) {
        Integer pageBegin = query.getCurrent();
        Integer pageSize = query.getSize();
        MinMaxLngLat minMaxLngLat = null;
        Double latDou = 0.0;
        Double lonDou = 0.0;
        if (!StrUtil.isBlank(lng) && !StrUtil.isBlank(lat) && distance!=null) {
            latDou = Convert.convert(Double.class, lat);
            lonDou = Convert.convert(Double.class, lng);
            minMaxLngLat = AMapUtils.calculateLonLat(lonDou, latDou, distance);
        }

        String ids = appDoctorMapper.getDoctorIdByFilter(minMaxLngLat, pageBegin, pageSize, area, diseaseId, diseaseName, deportmentId, doctorName, serveId, priceBegin, priceEnd, professionalTitleId,wellKnown);
        if (StringUtils.isEmpty(ids)) {
            return null;
        }
        List<AppDoctorDTO> list = appDoctorMapper.getDoctorByFilter(sortCode, ids);
        if (!StrUtil.isBlank(lng) && !StrUtil.isBlank(lat) && distance!=null) {
            SpatialContext geo = SpatialContext.GEO;
            for (AppDoctorDTO doc : list) {
                Double lonDouTwo = doc.getLongitude();
                Double latDouTwo = doc.getLatitude();
                double goDistance = geo.calcDistance(geo.makePoint(lonDou, latDou), geo.makePoint(lonDouTwo, latDouTwo))
                        * DistanceUtils.DEG_TO_KM;
                doc.setDistance(goDistance);
            }
            Collections.sort(list, new Comparator<AppDoctorDTO>() {
                @Override
                public int compare(AppDoctorDTO o1, AppDoctorDTO o2) {
                    return ((int) (o1.getDistance() * 1000000) - (int) (o2.getDistance() * 1000000));
                }
            });
        }
        return list;
    }
}
