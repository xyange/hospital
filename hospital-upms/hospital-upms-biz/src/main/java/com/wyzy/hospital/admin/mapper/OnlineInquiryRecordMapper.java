

package com.wyzy.hospital.admin.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wyzy.hospital.admin.api.dto.online.OnlineInquiryRecordDTO;
import com.wyzy.hospital.admin.api.dto.online.PcOnlineInquiryRecordDTO;
import com.wyzy.hospital.admin.api.entity.OnlineInquiryRecord;
import com.wyzy.hospital.common.data.datascope.HospitalBaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 在线问诊记录
 *
 * @author aqie
 * @date 2021-04-26 15:27:43
 */
@Mapper
public interface OnlineInquiryRecordMapper extends HospitalBaseMapper<OnlineInquiryRecord> {

    /**
     * 根据问诊状态查询在线问诊记录
     * @param memberId 会员ID
     * @param status 问诊状态
     * @return
     */
    List<OnlineInquiryRecordDTO> selectPojoByStatus(@Param("memberId") Long memberId,@Param("status") Integer status);

    /**
     * 分页获取问诊列表
     * @param page
     * @param pcOnlineInquiryRecordDTO
     * @return
     */
    List<PcOnlineInquiryRecordDTO> getInquiryListPage(@Param("page") IPage<PcOnlineInquiryRecordDTO> page, @Param("pcOnlineInquiryRecordDTO") PcOnlineInquiryRecordDTO pcOnlineInquiryRecordDTO);
}
