

package com.wyzy.hospital.admin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wyzy.hospital.admin.api.dto.online.OnlineInquiryRecordDTO;
import com.wyzy.hospital.admin.api.dto.online.PcOnlineInquiryRecordDTO;
import com.wyzy.hospital.admin.api.entity.OnlineInquiryRecord;

import java.util.List;

/**
 * 在线问诊记录
 *
 * @author aqie
 * @date 2021-04-26 15:27:43
 */
public interface OnlineInquiryRecordService extends IService<OnlineInquiryRecord> {

    /**
     * 根据问诊状态查询在线问诊记录
     * @param memberId 会员ID
     * @param status 问诊状态
     * @return
     */
    List<OnlineInquiryRecordDTO> getPojoByStatus(Long memberId,Integer status);

    /**
     * 分页获取问诊列表
     * @param page
     * @param pcOnlineInquiryRecordDTO
     * @return
     */
    List<PcOnlineInquiryRecordDTO> getInquiryListPage(IPage<PcOnlineInquiryRecordDTO> page, PcOnlineInquiryRecordDTO pcOnlineInquiryRecordDTO);
}
