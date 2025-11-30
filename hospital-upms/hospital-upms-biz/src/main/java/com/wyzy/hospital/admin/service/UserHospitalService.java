

package com.wyzy.hospital.admin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wyzy.hospital.admin.api.entity.UserHospital;
import com.wyzy.hospital.admin.api.vo.hospital.HospitalsCollectVO;
import com.wyzy.hospital.common.mybatis.support.Query;

import java.util.List;

/**
 * 用户医院收藏中间表
 *
 * @author aqie
 * @date 2021-04-17 14:48:05
 */
public interface UserHospitalService extends IService<UserHospital> {
    /**
     * 用户收藏/取消收藏医院
     *
     * @param userId
     * @param hospitalId
     * @return
     */
    public int collectHospital(Long userId, Long hospitalId);

    /**
     * 用户是否收藏医院
     *
     * @param hospitalId
     * @param userId
     * @return
     */
    Integer isCollect(Long hospitalId, Long userId);

    /**
     * 查收藏的医生
     *
     * @param longitude 经度
     * @param latitude 纬度
     * @param page 分页
     * @return java.util.List<com.wyzy.hospital.admin.api.dto.hospital.HospitalsDTO>
     * @author wrk
     * @date 2021/05/25 14:42
     */
     IPage<HospitalsCollectVO> getCollectedHospital(IPage page, String longitude, String latitude);
}
