

package com.wyzy.hospital.admin.mapper;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wyzy.hospital.admin.api.dto.ClinicCommentsDTO;
import com.wyzy.hospital.admin.api.entity.ClinicComments;
import com.wyzy.hospital.common.data.datascope.HospitalBaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 诊所评论表
 *
 * @author songM
 * @date 2021-06-09 16:26:56
 */
@Mapper
public interface ClinicCommentsMapper extends HospitalBaseMapper<ClinicComments> {
    /**
    * @Description: 根据诊所id查所有评论
    * @Param: [page, clinicId]
    * @return: java.util.List<com.wyzy.hospital.admin.api.entity.ClinicComments>
    * @Author: songM
    * @Date: 2021/6/9
    */
    List<ClinicCommentsDTO> getCommentsListByClinicId(@Param("page") IPage<ClinicCommentsDTO> page, @Param("clinicId") Long clinicId);
    /**
    * @Description: 获取好的服务环境
    * @Param: [page, clinicId]
    * @return: java.util.List<com.wyzy.hospital.admin.api.dto.ClinicCommentsDTO>
    * @Author: songM
    * @Date: 2021/6/9
    */
    List<ClinicCommentsDTO> getGoodenvironmentByClinicId(@Param("page") IPage<ClinicCommentsDTO> page, @Param("clinicId") Long clinicId);
    /**
    * @Description: 查询服务好的评论
    * @Param: [page, clinicId]
    * @return: java.util.List<com.wyzy.hospital.admin.api.dto.ClinicCommentsDTO>
    * @Author: songM
    * @Date: 2021/6/9
    */
    List<ClinicCommentsDTO> getGoodServiceByClinicId(@Param("page") IPage<ClinicCommentsDTO> page, @Param("clinicId") Long clinicId);
    
    /**
    * @Description: 查询医生棒的评论
    * @Param: [page, clinicId]
    * @return: java.util.List<com.wyzy.hospital.admin.api.dto.ClinicCommentsDTO>
    * @Author: songM
    * @Date: 2021/6/9
    */
    List<ClinicCommentsDTO> getGoodDoctorByClinicId(@Param("page") IPage<ClinicCommentsDTO> page, @Param("clinicId") Long clinicId);
}
