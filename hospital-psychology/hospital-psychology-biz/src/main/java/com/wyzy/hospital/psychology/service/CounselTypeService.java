

package com.wyzy.hospital.psychology.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wyzy.hospital.psychology.api.entity.CounselType;

/**
 * 资讯类型表
 *
 * @author hospital code generator
 * @date 2021-06-11 14:40:23
 */
public interface CounselTypeService extends IService<CounselType> {

    /**
     * 通过id删除资讯类型表
     * @param counselId id
     * @return R
     */
    boolean removeCounselTypeById(Integer counselId);
}
