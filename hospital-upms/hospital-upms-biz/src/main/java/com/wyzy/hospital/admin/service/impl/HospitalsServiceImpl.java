
package com.wyzy.hospital.admin.service.impl;

import cn.hutool.core.convert.Convert;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyzy.hospital.admin.api.dto.HospitalNeighborhoodDTO;
import com.wyzy.hospital.admin.api.dto.hospital.AppHospitalDTO;
import com.wyzy.hospital.admin.api.dto.hospital.HospitalDetailDTO;
import com.wyzy.hospital.admin.api.dto.hospital.HospitalsDTO;
import com.wyzy.hospital.admin.api.entity.Hospitals;
import com.wyzy.hospital.admin.api.vo.hospital.AppHospitalVO;
import com.wyzy.hospital.admin.mapper.HospitalsMapper;
import com.wyzy.hospital.admin.service.HospitalsService;
import com.wyzy.hospital.common.core.util.AMapUtils;
import com.wyzy.hospital.common.core.util.MinMaxLngLat;
import org.locationtech.spatial4j.context.SpatialContext;
import org.locationtech.spatial4j.distance.DistanceUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 医院表
 *
 * @author aqie
 * @date 2021-04-15 15:42:23
 */
@Service
public class HospitalsServiceImpl extends ServiceImpl<HospitalsMapper, Hospitals> implements HospitalsService {

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int save(HospitalsDTO hospitalsDTO) {
        return baseMapper.insert(hospitalsDTO);
    }


    @Override
    public IPage<HospitalsDTO> selectList(IPage page, LambdaQueryWrapper<Hospitals> queryWrapper) {
        return baseMapper.selectPage(page, queryWrapper);
    }

    @Override
    public List<AppHospitalDTO> getHospitalList(IPage<AppHospitalVO> page, AppHospitalDTO hospitalsDTO) {
        return baseMapper.getHospitalList(page,hospitalsDTO);
    }

    @Override
    public HospitalDetailDTO detail(long  hospitalId) {
        return baseMapper.appDetail(hospitalId);
    }


    @Override
    public List<HospitalNeighborhoodDTO> getNeighborhoodHospitals(Double distance, String lon, String lat, Long deportmentId, Long diseaseId, String area, String keyWord) {

        Double latDou= Convert.convert(Double.class, lat);
        Double lonDou= Convert.convert(Double.class, lon);
        /*Integer geoHashLength=3;
        String geoCode=GeohashUtils.encodeLatLon(latDou,lonDou,geoHashLength);*/
//      String geoCode=null;
        MinMaxLngLat minMaxLngLat= AMapUtils.calculateLonLat(lonDou,latDou,distance);
        List<HospitalNeighborhoodDTO> list=baseMapper.getNeighborhoodHospitals(deportmentId,diseaseId,area,keyWord,minMaxLngLat);
        SpatialContext geo = SpatialContext.GEO;
        for(HospitalNeighborhoodDTO nei:list){
            Double lonDouTwo=nei.getLongitude();
            Double latDouTwo= nei.getLatitude();
            double goDistance = geo.calcDistance(geo.makePoint(lonDou, latDou), geo.makePoint(lonDouTwo, latDouTwo))
                    * DistanceUtils.DEG_TO_KM;
            nei.setDistance(goDistance);
        }
        Collections.sort(list, new Comparator<HospitalNeighborhoodDTO>() {
            @Override
            public int compare(HospitalNeighborhoodDTO o1, HospitalNeighborhoodDTO o2) {
                return  ((int)(o1.getDistance()*1000000)-(int)(o2.getDistance()*1000000));
            }
        });
        return list;
    }


}
