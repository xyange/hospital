
package com.wyzy.hospital.admin.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyzy.hospital.admin.api.dto.ClinicCommentsDTO;
import com.wyzy.hospital.admin.api.entity.ClinicComments;
import com.wyzy.hospital.admin.mapper.ClinicCommentsMapper;
import com.wyzy.hospital.admin.service.ClinicCommentsService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 诊所评论表
 *
 * @author songM
 * @date 2021-06-09 16:26:56
 */
@Service
public class ClinicCommentsServiceImpl extends ServiceImpl<ClinicCommentsMapper, ClinicComments> implements ClinicCommentsService {
    /**
    * @Description: 根据诊所id 查所有评论
    * @Param: [page, clinicId]
    * @return: java.util.List<com.wyzy.hospital.admin.api.entity.ClinicComments>
    * @Author: songM
    * @Date: 2021/6/9
    */
    @Override
    public List<ClinicCommentsDTO> getCommentsListByClinicId(IPage<ClinicCommentsDTO> page, Long clinicId) {
        return baseMapper.getCommentsListByClinicId(page,clinicId);
    }

    /**
    * @Description: 获取好的服务环境评论
    * @Param: [page, clinicId]
    * @return: java.util.List<com.wyzy.hospital.admin.api.dto.ClinicCommentsDTO>
    * @Author: songM
    * @Date: 2021/6/9
    */
    @Override
    public List<ClinicCommentsDTO> getGoodenvironmentByClinicId(IPage<ClinicCommentsDTO> page, Long clinicId) {
        return baseMapper.getGoodenvironmentByClinicId(page,clinicId);
    }

    /**
    * @Description: 查询服务好的评论
    * @Param: [page, clinicId]
    * @return: java.util.List<com.wyzy.hospital.admin.api.dto.ClinicCommentsDTO>
    * @Author: songM
    * @Date: 2021/6/9
    */
    @Override
    public List<ClinicCommentsDTO> getGoodServiceByClinicId(IPage<ClinicCommentsDTO> page, Long clinicId) {
        return baseMapper.getGoodServiceByClinicId(page,clinicId);
    }

    /**
    * @Description: 查询医生棒的评论
    * @Param: [page, clinicId]
    * @return: java.util.List<com.wyzy.hospital.admin.api.dto.ClinicCommentsDTO>
    * @Author: songM
    * @Date: 2021/6/9
    */
    @Override
    public List<ClinicCommentsDTO> getGoodDoctorByClinicId(IPage<ClinicCommentsDTO> page, Long clinicId) {
        return baseMapper.getGoodDoctorByClinicId(page,clinicId);
    }
}
