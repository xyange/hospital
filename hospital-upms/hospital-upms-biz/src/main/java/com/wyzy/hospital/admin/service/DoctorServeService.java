

package com.wyzy.hospital.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import com.wyzy.hospital.admin.api.entity.DoctorServe;

/**
 * 医生服务关系表
 *
 * @author wrk
 * @date 2021-04-12 16:51:41
 */
public interface DoctorServeService extends IService<DoctorServe> {


    /**
     * 保存
     *
     * @param entity
     * @return boolean
     * @author wrk
     * @date 2021/06/01 15:33
     */
    @Override
    boolean save(DoctorServe entity);

}
