package com.wyzy.hospital.admin.kit;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wyzy.hospital.admin.api.dto.online.OnlineInquiryRecordDTO;
import com.wyzy.hospital.admin.api.dto.online.PcOnlineInquiryRecordDTO;
import com.wyzy.hospital.common.core.util.R;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author wrk
 */
public interface OnlineInquiryRecordKitService {
    /**
     * 添加就诊记录
     *
     * @param record
     * @param files
     * @return java.lang.Boolean
     * @author wrk
     * @date 2021/05/27 15:49
     */
    R addRecord(OnlineInquiryRecordDTO record, MultipartFile[] files);
    /**
    * @Description:
    * @Param: [page, query]
    * @return: com.wyzy.hospital.common.core.util.R<com.baomidou.mybatisplus.core.metadata.IPage<com.wyzy.hospital.admin.api.dto.online.PcOnlineInquiryRecordDTO>>
    * @Author: songM
    * @Date: 2021/6/10
    */
    IPage<PcOnlineInquiryRecordDTO> getInquiryListPage(IPage<PcOnlineInquiryRecordDTO> page, PcOnlineInquiryRecordDTO pcOnlineInquiryRecordDTO);
}
