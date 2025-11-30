
package com.wyzy.hospital.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyzy.hospital.admin.api.entity.UserClinic;
import com.wyzy.hospital.admin.mapper.UserClinicMapper;
import com.wyzy.hospital.admin.service.UserClinicService;
import com.wyzy.hospital.common.core.constant.CommonConstants;
import org.springframework.stereotype.Service;

/**
 * 用户诊所关系表
 *
 * @author songM
 * @date 2021-05-17 16:26:18
 */
@Service
public class UserClinicServiceImpl extends ServiceImpl<UserClinicMapper, UserClinic> implements UserClinicService {

    /**
    * @Description: 诊所收藏/取消收藏
    * @Param: [id, clinicId] 用户id 诊所id
    * @return: java.lang.Integer
    * @Author: songM
    * @Date: 2021/5/17
    */
    @Override
    public Integer collectClinic(Long id, Long clinicId) {
        // 1. 查询
        UserClinic one = baseMapper.selectOne(new LambdaQueryWrapper<UserClinic>()
                .eq(UserClinic::getClinicId, clinicId)
                .eq(UserClinic::getUserId, id)
        );
        if(one == null) {
            one = new UserClinic();
            one.setIsCollect(CommonConstants.TRUE);
            one.setClinicId(clinicId);
            one.setUserId(id);
            return baseMapper.insert(one);
        }
        // 2. 点赞/取消点赞
        one.setIsCollect(one.getIsCollect() ^ 1);
        return baseMapper.updateById(one);
    }
}
