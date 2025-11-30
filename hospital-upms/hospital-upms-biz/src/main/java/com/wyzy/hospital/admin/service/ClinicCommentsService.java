

package com.wyzy.hospital.admin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wyzy.hospital.admin.api.dto.ClinicCommentsDTO;
import com.wyzy.hospital.admin.api.entity.ClinicComments;

import java.util.List;


/**
 * 诊所评论表
 *
 * @author songM
 * @date 2021-06-09 16:26:56
 */
public interface ClinicCommentsService extends IService<ClinicComments> {
    
    /**
    * @Description: 根据诊所id 查所有评论
    * @Param: [page, clinicId]
    * @return: java.util.List<com.wyzy.hospital.admin.api.entity.ClinicComments>
    * @Author: songM
    * @Date: 2021/6/9
    */
    List<ClinicCommentsDTO> getCommentsListByClinicId(IPage<ClinicCommentsDTO> page, Long clinicId);
    /**
    * @Description: 获取好的服务环境
    * @Param: [page, clinicId]
    * @return: java.util.List<com.wyzy.hospital.admin.api.dto.ClinicCommentsDTO>
    * @Author: songM
    * @Date: 2021/6/9
    */
    List<ClinicCommentsDTO> getGoodenvironmentByClinicId(IPage<ClinicCommentsDTO> page, Long clinicId);
    /**
    * @Description: 查询服务好的评论
    * @Param: [page, clinicId]
    * @return: java.util.List<com.wyzy.hospital.admin.api.dto.ClinicCommentsDTO>
    * @Author: songM
    * @Date: 2021/6/9
    */
    List<ClinicCommentsDTO> getGoodServiceByClinicId(IPage<ClinicCommentsDTO> page, Long clinicId);
    /**
    * @Description: 查询医生棒的评论
    * @Param: [page, clinicId]
    * @return: java.util.List<com.wyzy.hospital.admin.api.dto.ClinicCommentsDTO>
    * @Author: songM
    * @Date: 2021/6/9
    */
    List<ClinicCommentsDTO> getGoodDoctorByClinicId(IPage<ClinicCommentsDTO> page, Long clinicId);
}
