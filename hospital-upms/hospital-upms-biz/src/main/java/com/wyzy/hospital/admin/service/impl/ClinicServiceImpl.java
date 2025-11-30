
package com.wyzy.hospital.admin.service.impl;

import cn.hutool.core.convert.Convert;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyzy.hospital.admin.api.dto.*;
import com.wyzy.hospital.admin.api.entity.Clinic;
import com.wyzy.hospital.admin.mapper.ClinicMapper;
import com.wyzy.hospital.admin.service.ClinicService;
import com.wyzy.hospital.common.core.util.AMapUtils;
import com.wyzy.hospital.common.core.util.MinMaxLngLat;
import com.wyzy.hospital.common.security.util.SecurityUtils;
import org.locationtech.spatial4j.context.SpatialContext;
import org.locationtech.spatial4j.distance.DistanceUtils;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 * 门诊表
 *
 * @author songM
 * @date 2021-04-16 09:44:55
 */
@Service
public class ClinicServiceImpl extends ServiceImpl<ClinicMapper, Clinic> implements ClinicService {


    @Override
    public List<Clinic> selectList(LambdaQueryWrapper<Clinic> likeQuery) {
        return baseMapper.selectList(likeQuery);
    }

    @Override
    public Object delClinicById(Clinic clinic) {
        clinic.setDelFlag("1");
        return baseMapper.updateById(clinic);
    }

    @Override
    public List<ClinicDiagnosisServiceDto> getClinicPageList(ClinicDiagnosisDto clinicDiagnosisDto, IPage page) {
        return baseMapper.getClinicPageList(clinicDiagnosisDto,page);
    }

    /**
     *
     * @param clinic
     * @return
     */
    @Override
    public Object changeState(Clinic clinic) {
        return  baseMapper.updateById(clinic);
    }

    /**
     * 诊所审核(0-待审核，1-审核通过 2-审核拒绝)
     * @param clinic
     * @return
     */
    @Override
    public Object toExamine(Clinic clinic) {
        if (clinic.getApprove().equals(1)){
            clinic.setReviewDate(new Date());
        }
        return  baseMapper.updateById(clinic);
    }

    /**
     * 查询审核列表
     * @param clinicDiagnosisDto
     * @param page
     * @return
     */
    @Override
    public List<ClinicDiagnosisServiceDto> getReviewedList(ClinicDiagnosisDto clinicDiagnosisDto,IPage page) {
        return baseMapper.getReviewedList(clinicDiagnosisDto,page);
    }
    /**
    * @Description: 获取审核拒绝列表
    * @Param: [clinicDiagnosisDto, page]
    * @return: java.util.List<com.wyzy.hospital.admin.api.dto.ClinicDiagnosisServiceDto>
    * @Author: songM
    * @Date: 2021/6/7
    */
    @Override
    public List<ClinicDiagnosisServiceDto> getNoReviewedList(ClinicDiagnosisDto clinicDiagnosisDto, IPage page) {
        return baseMapper.getNoReviewedList(clinicDiagnosisDto,page);
    }
    /**
    * @Description: 查询诊所通过诊所id
    * @Param: [clinicId]
    * @return: com.wyzy.hospital.admin.api.entity.Clinic
    * @Author: songM
    * @Date: 2021/6/7
    */
    @Override
    public ClinicDiagnosisServiceDto selectClinicByClinicId(Long clinicId) {
        return baseMapper.selectClinicByClinicId(clinicId);
    }

    /**
    * @Description: 根据疾病id查诊所
    * @Param: [diseaseId] 疾病id
    * @return: com.wyzy.hospital.common.core.util.R<com.baomidou.mybatisplus.core.metadata.IPage<com.wyzy.hospital.admin.api.dto.ClinicDiagnosisServiceDto>>
    * @Author: songM
    * @Date: 2021/5/15
    */
    @Override
    public List<ClinicDTO> getClinicBydiseaseId(Integer diseaseId) {
        return baseMapper.getClinicBydiseaseId(diseaseId);
    }

    /**
     * 查询所有诊所
     * @param page
     * @param clinic
     * @return
     */
    @Override
    public List<ClinicDTO> getAllClinic(IPage<ClinicDTO> page, Clinic clinic) {
        return baseMapper.getAllClinic(page,clinic);
    }

    /**
    * @Description: 根据诊所id查询诊所信息
    * @Param: [clinicId] 诊所id
    * @return: com.wyzy.hospital.admin.api.dto.ClinicDiagnosisServiceDto
    * @Author: songM
    * @Date: 2021/5/18
    */
    @Override
    public ClinicDiagnosisBusinessDTO getClinicByClinicId(ClinicDTO clinicDTO) {
        return baseMapper.getClinicByClinicId(clinicDTO);

    }

    @Override
    public List<ClinicNeighborhoodDTO> getNeighborhoodClinics(Double distance,String lon, String lat, Long deportmentId, Long diseaseId, String area, String keyWord) {

        Double latDou= Convert.convert(Double.class, lat);
        Double lonDou= Convert.convert(Double.class, lon);
        /*Integer geoHashLength=3;
        String geoCode=GeohashUtils.encodeLatLon(latDou,lonDou,geoHashLength);*/
        String geoCode=null;
        MinMaxLngLat minMaxLngLat=AMapUtils.calculateLonLat(lonDou,latDou,distance);
        List<ClinicNeighborhoodDTO> list=baseMapper.getNeighborhoodClinics(geoCode,deportmentId,diseaseId,area,keyWord,minMaxLngLat);
        SpatialContext geo = SpatialContext.GEO;
        for(ClinicNeighborhoodDTO nei:list){
            Double lonDouTwo=nei.getLongitude();
            Double latDouTwo= nei.getLatitude();
            double goDistance = geo.calcDistance(geo.makePoint(lonDou, latDou), geo.makePoint(lonDouTwo, latDouTwo))
                    * DistanceUtils.DEG_TO_KM;
            nei.setDistance(goDistance);
        }
        Collections.sort(list, new Comparator<ClinicNeighborhoodDTO>() {
            @Override
            public int compare(ClinicNeighborhoodDTO o1, ClinicNeighborhoodDTO o2) {
                return  ((int)(o1.getDistance()*1000000)-(int)(o2.getDistance()*1000000));
            }
        });
        return list;
    }

    @Override
    public IPage<ClinicDiagnosisServiceDto> getCollectedClinic(IPage page, String lon, String lat) {
        Long userId= SecurityUtils.getUser().getId().longValue();
        List<ClinicDiagnosisServiceDto> list= baseMapper.getCollectedClinic(userId);
        Double latDou= Convert.convert(Double.class, lat);
        Double lonDou= Convert.convert(Double.class, lon);

        for(ClinicDiagnosisServiceDto cd:list){
            SpatialContext geo = SpatialContext.GEO;
            Double latDouTwo= Convert.convert(Double.class, cd.getLatitude());
            Double lonDouTwo= Convert.convert(Double.class, cd.getLongitude());
            double goDistance = geo.calcDistance(geo.makePoint(lonDou, latDou), geo.makePoint(lonDouTwo, latDouTwo))
                    * DistanceUtils.DEG_TO_KM;
            cd.setDistance(goDistance);
        }
        return page.setRecords(list);
    }
    
    /**
    * @Description: 通过诊疗项目id查诊所列表
    * @Param: [page, clinicDiagnosis]
    * @return: java.util.List<com.wyzy.hospital.admin.api.dto.ClinicDTO>
    * @Author: songM
    * @Date: 2021/5/27
    */
    @Override
    public List<ClinicDTO> getClinicByDiagnosisId(IPage<ClinicDTO> page, ClinicDTO clinicDTO) {
        return baseMapper.getClinicByDiagnosisId(page,clinicDTO);
    }

    /**
    * @Description: 根据科室id查询诊所列表
    * @Param: [page, clinic]
    * @return: java.util.List<com.wyzy.hospital.admin.api.dto.ClinicDTO>
    * @Author: songM
    * @Date: 2021/5/28
    */
    @Override
    public List<ClinicDTO> getClinicByDeptId(IPage<Object> page, ClinicDTO clinic) {
        return baseMapper.getClinicByDeptId(clinic);
    }

    /**
    * @Description: 根据商家名、医疗项目名查询本地诊所
    * @Param: [page, clinicDTO]
    * @return: com.baomidou.mybatisplus.core.metadata.IPage<com.wyzy.hospital.admin.api.dto.ClinicDTO>
    * @Author: songM
    * @Date: 2021/5/29
    */
    @Override
    public IPage<ClinicDTO> selectLocalClinicByKeyWord(IPage<Object> page, ClinicDTO clinicDTO) {
        return baseMapper.selectLocalClinicByKeyWord(page,clinicDTO);
    }

    /**
    * @Description: 查看诊所是否下线
    * @Param: [clinicId]
    * @return: java.lang.String
    * @Author: songM
    * @Date: 2021/6/7
    */
    @Override
    public String selectIfEndStatus(Long clinicId) {
       return baseMapper.selectIfEndStatus(clinicId);
    }


}
