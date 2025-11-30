
package com.wyzy.hospital.admin.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyzy.hospital.admin.api.dto.online.OnlineInquiryRecordDTO;
import com.wyzy.hospital.admin.api.dto.online.PcOnlineInquiryRecordDTO;
import com.wyzy.hospital.admin.api.entity.OnlineInquiryRecord;
import com.wyzy.hospital.admin.mapper.OnlineInquiryRecordMapper;
import com.wyzy.hospital.admin.service.OnlineInquiryRecordService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 在线问诊记录
 *
 * @author aqie
 * @date 2021-04-26 15:27:43
 */
@Service
public class OnlineInquiryRecordServiceImpl extends ServiceImpl<OnlineInquiryRecordMapper, OnlineInquiryRecord> implements OnlineInquiryRecordService {

    /**
     * 根据问诊状态查询在线问诊记录
     * @param memberId 会员ID
     * @param status 问诊状态
     * @return
     */
    @Override
    public List<OnlineInquiryRecordDTO> getPojoByStatus(Long memberId,Integer status) {
        return baseMapper.selectPojoByStatus(memberId,status);
    }

    /**
    * @Description: 分页获取在线咨询列表
    * @Param: [page, pcOnlineInquiryRecordDTO]
    * @return: java.util.List<com.wyzy.hospital.admin.api.dto.online.PcOnlineInquiryRecordDTO>
    * @Author: songM
    * @Date: 2021/6/10
    */
    @Override
    public List<PcOnlineInquiryRecordDTO> getInquiryListPage(IPage<PcOnlineInquiryRecordDTO> page, PcOnlineInquiryRecordDTO pcOnlineInquiryRecordDTO) {
        List<PcOnlineInquiryRecordDTO> inquiryListPage = baseMapper.getInquiryListPage(page, pcOnlineInquiryRecordDTO);
        return inquiryListPage;
    }
}
