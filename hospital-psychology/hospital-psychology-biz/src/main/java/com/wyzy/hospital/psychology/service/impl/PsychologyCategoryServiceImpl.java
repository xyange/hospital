
package com.wyzy.hospital.psychology.service.impl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyzy.hospital.psychology.api.entity.PsychologyCategory;
import com.wyzy.hospital.psychology.mapper.DoctorAdeptMapper;
import com.wyzy.hospital.psychology.mapper.PsychologyCategoryMapper;
import com.wyzy.hospital.psychology.service.PsychologyCategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 心理分类表
 *
 * @author hospital code generator
 * @date 2021-06-10 09:20:29
 */
@Service
public class PsychologyCategoryServiceImpl extends ServiceImpl<PsychologyCategoryMapper, PsychologyCategory> implements PsychologyCategoryService {
    @Resource
    public  DoctorAdeptMapper doctorAdeptMapper;

    /**
     * 新增心理分类表
     * @param psychologyCategory 心理分类表
     */
    @Override
    public boolean savePsychologyCategory(PsychologyCategory psychologyCategory) {
        Integer integer = baseMapper.selectPsychologyCategoryByname(psychologyCategory);
        if (integer == 0){
            int insert = baseMapper.insertPsychologyCategory(psychologyCategory);
            if (insert>0){
                return true;
            }
        }
        return false;
    }

    /**
     * 通过id删除心理分类表
     * @param categoryId id
     */
    @Override
    public boolean removePsychologyCategoryById(Long categoryId) {
        Integer integer = doctorAdeptMapper.selectAdeptIdByCategoryId(categoryId);
        if (integer>0){
            return false;
        }
        int i = baseMapper.deleteById(categoryId);
        if (i>0){
            return true;
        }
        return false;
    }
}
