

package com.wyzy.hospital.psychology.mapper;
import com.wyzy.hospital.common.data.datascope.HospitalBaseMapper;
import com.wyzy.hospital.psychology.api.entity.PsychologyCategory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 心理分类表
 *
 * @author hospital code generator
 * @date 2021-06-10 09:20:29
 */
@Mapper
public interface PsychologyCategoryMapper extends HospitalBaseMapper<PsychologyCategory> {

    /**
     * 新增心理分类表
     * @param psychologyCategory 心理分类表
     */
    Integer selectPsychologyCategoryByname(@Param("psychologyCategory") PsychologyCategory psychologyCategory);

    int insertPsychologyCategory(@Param("psychologyCategory") PsychologyCategory psychologyCategory);
}
