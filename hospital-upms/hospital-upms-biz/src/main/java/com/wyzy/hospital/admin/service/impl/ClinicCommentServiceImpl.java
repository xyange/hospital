
package com.wyzy.hospital.admin.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyzy.hospital.admin.api.entity.ClinicComment;
import com.wyzy.hospital.admin.mapper.ClinicCommentMapper;
import com.wyzy.hospital.admin.service.ClinicCommentService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 诊所评论表
 *
 * @author songM
 * @date 2021-06-07 11:01:27
 */
@Service
public class ClinicCommentServiceImpl extends ServiceImpl<ClinicCommentMapper, ClinicComment> implements ClinicCommentService {
  /**
  * @Description: 根据诊所id诊疗项目id查询所有评论
  * @Param: [page, clinicId, diagnosisId]
  * @return: java.util.List<com.wyzy.hospital.admin.api.entity.ClinicComment>
  * @Author: songM
  * @Date: 2021/6/8
  */
    @Override
    public List<ClinicComment> getCommentListByClinicId(IPage<ClinicComment> page, Long clinicId, Long diagnosisId) {
        return baseMapper.getCommentListByClinicId(page,clinicId,diagnosisId);
    }


}
