

package com.wyzy.hospital.admin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wyzy.hospital.admin.api.entity.ClinicComment;

import java.util.List;


/**
 * 诊所评论表
 *
 * @author songM
 * @date 2021-06-07 11:01:27
 */
public interface ClinicCommentService extends IService<ClinicComment> {

    /**
    * @Description: 查询诊所评列表论通过诊所id
    * @Param: [page, clinicId]
    * @return: com.baomidou.mybatisplus.core.metadata.IPage<com.wyzy.hospital.admin.api.entity.ClinicComment>
    * @Author: songM
    * @Date: 2021/6/7
    */
    List<ClinicComment> getCommentListByClinicId(IPage<ClinicComment> page, Long clinicId,Long diagnosisId);

}
