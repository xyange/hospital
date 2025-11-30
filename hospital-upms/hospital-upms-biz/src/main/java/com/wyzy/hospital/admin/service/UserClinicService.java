

package com.wyzy.hospital.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wyzy.hospital.admin.api.entity.UserClinic;

/**
 * 用户诊所关系表
 *
 * @author songM
 * @date 2021-05-17 16:26:18
 */
public interface UserClinicService extends IService<UserClinic> {
    /**
    * @Description: 诊所收藏/取消收藏
    * @Param: [id, clinicId] 用户id 诊所id
    * @return: java.lang.Integer
    * @Author: songM
    * @Date: 2021/5/17
    */
    Integer collectClinic(Long id, Long clinicId);
}
