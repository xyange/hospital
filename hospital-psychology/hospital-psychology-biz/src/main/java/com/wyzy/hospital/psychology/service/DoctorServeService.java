

package com.wyzy.hospital.psychology.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wyzy.hospital.psychology.api.entity.DoctorServe;

import java.util.List;

/**
 * 心理医生服务关系表
 *
 * @author hospital code generator
 * @date 2021-06-11 09:54:02
 */
public interface DoctorServeService extends IService<DoctorServe> {


    List<DoctorServe> selectDoctorServeByServeId(Long serveId);
}
