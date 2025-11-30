

package com.wyzy.hospital.psychology.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.wyzy.hospital.psychology.api.entity.Serve;

/**
 * 心理医生服务表
 *
 * @author hospital code generator
 * @date 2021-06-11 09:54:07
 */
public interface ServeService extends IService<Serve> {

    /**
     * 通过id删除心理医生服务表
     * @param serveId id
     * @return R
     */
    boolean removeServeById(Long serveId);

    /**
     * 新增心理医生服务表
     * @param serve 心理医生服务表
     * @return R
     */
    boolean saveServe(Serve serve);
}
