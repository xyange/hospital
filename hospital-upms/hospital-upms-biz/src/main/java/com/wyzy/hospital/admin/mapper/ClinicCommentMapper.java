

package com.wyzy.hospital.admin.mapper;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wyzy.hospital.admin.api.entity.ClinicComment;
import com.wyzy.hospital.common.data.datascope.HospitalBaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 诊所评论表
 *
 * @author songM
 * @date 2021-06-07 11:01:27
 */
@Mapper
public interface ClinicCommentMapper extends HospitalBaseMapper<ClinicComment> {
    /**
    * @Description: 根据诊所id诊疗项目id查询所有评论
    * @Param: [page, clinicId, diagnosisId]
    * @return: java.util.List<com.wyzy.hospital.admin.api.entity.ClinicComment>
    * @Author: songM
    * @Date: 2021/6/8
    */
    List<ClinicComment> getCommentListByClinicId(@Param("page") IPage<ClinicComment> page, @Param("clinicId") Long clinicId,@Param("diagnosisId") Long diagnosisId);

}
