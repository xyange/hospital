
package com.wyzy.hospital.admin.service.impl;

import cn.hutool.core.convert.Convert;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyzy.hospital.admin.api.entity.UserHospital;
import com.wyzy.hospital.admin.api.vo.hospital.HospitalsCollectVO;
import com.wyzy.hospital.admin.mapper.UserHospitalMapper;
import com.wyzy.hospital.admin.service.UserHospitalService;
import com.wyzy.hospital.common.core.constant.CommonConstants;
import com.wyzy.hospital.common.security.util.SecurityUtils;
import org.locationtech.spatial4j.context.SpatialContext;
import org.locationtech.spatial4j.distance.DistanceUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户医院收藏中间表
 *
 * @author aqie
 * @date 2021-04-17 14:48:05
 */
@Service
public class UserHospitalServiceImpl extends ServiceImpl<UserHospitalMapper, UserHospital> implements UserHospitalService {

    @Override
    public int collectHospital(Long userId, Long hospitalId) {
        // 1. 查询
        UserHospital one = baseMapper.selectOne(new LambdaQueryWrapper<UserHospital>()
                .eq(UserHospital::getHospitalId, hospitalId)
                .eq(UserHospital::getUserId, userId)
        );
        if(one == null) {
            one = new UserHospital();
            one.setIsCollect(CommonConstants.TRUE);
            one.setHospitalId(hospitalId);
            one.setUserId(userId);
            return baseMapper.insert(one);
        }
        // 2. 点赞/取消点赞
        one.setIsCollect(one.getIsCollect() ^ 1);
        return baseMapper.updateById(one);
    }

    @Override
    public Integer isCollect(Long hospitalId, Long userId) {
        return baseMapper.isCollect(hospitalId, userId).orElse(CommonConstants.FALSE);
    }

    @Override
    public IPage<HospitalsCollectVO> getCollectedHospital(IPage page, String longitude, String latitude) {
        List<HospitalsCollectVO> list= baseMapper.getCollectedHospital(SecurityUtils.getUser().getId().longValue());
        Double latDou= Convert.convert(Double.class, latitude);
        Double lonDou= Convert.convert(Double.class, longitude);

        for(HospitalsCollectVO hVO:list){
            SpatialContext geo = SpatialContext.GEO;
            Double latDouTwo= Convert.convert(Double.class, hVO.getLat());
            Double lonDouTwo= Convert.convert(Double.class, hVO.getLon());
            double goDistance = geo.calcDistance(geo.makePoint(lonDou, latDou), geo.makePoint(lonDouTwo, latDouTwo))
                    * DistanceUtils.DEG_TO_KM;
            hVO.setDistance(goDistance);
        }
        return page.setRecords(list);
    }
}
