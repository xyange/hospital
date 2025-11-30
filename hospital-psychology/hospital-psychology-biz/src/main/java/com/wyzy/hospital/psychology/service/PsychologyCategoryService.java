

package com.wyzy.hospital.psychology.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wyzy.hospital.psychology.api.entity.PsychologyCategory;

/**
 * 心理分类表
 *
 * @author hospital code generator
 * @date 2021-06-10 09:20:29
 */
public interface PsychologyCategoryService extends IService<PsychologyCategory> {

    /**
     * 新增心理分类表
     * @param psychologyCategory 心理分类表
     */
    boolean savePsychologyCategory(PsychologyCategory psychologyCategory);

    /**
     * 通过id删除心理分类表
     * @param categoryId id
     */
    boolean removePsychologyCategoryById(Long categoryId);
}
