package com.wyzy.hospital.admin.kit.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wyzy.hospital.admin.api.dto.file.UploadFile;
import com.wyzy.hospital.admin.api.dto.online.OnlineInquiryRecordDTO;
import com.wyzy.hospital.admin.api.dto.online.PcOnlineInquiryRecordDTO;
import com.wyzy.hospital.admin.exception.GlobalException;
import com.wyzy.hospital.admin.kit.OnlineInquiryRecordKitService;
import com.wyzy.hospital.admin.service.OnlineInquiryRecordService;
import com.wyzy.hospital.admin.service.SysFileService;
import com.wyzy.hospital.common.core.util.CodeMsg;
import com.wyzy.hospital.common.core.util.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 实现类
 *
 * @author wrk
 * @date 2021/05/27 15:45
 **/
@Slf4j
@Service
public class OnlineInquiryRecordKitServiceImpl implements OnlineInquiryRecordKitService {
    @Resource
    private  OnlineInquiryRecordService onlineInquiryRecordService;
    @Resource
    private SysFileService sysFileService;
    @Override
    @Transactional(rollbackFor = Exception.class)
    public R addRecord(OnlineInquiryRecordDTO record, MultipartFile[] files) {
        //先将记录添加近数据库
       Boolean insertFlag= onlineInquiryRecordService.save(record);
       if(!insertFlag){
           return R.error(CodeMsg.MEDICAL_INFORMATION_SUBMIT_FAIL);
       }
        //在上传图片
        List<Integer> failList=new ArrayList();
        StringBuffer fileUrl=new StringBuffer();
        UploadFile uploadFile=new UploadFile();
        StringBuffer fileMsg=new StringBuffer();
        List<String> fileImgName=new ArrayList<>();

        for(int i=0;i<files.length;i++){
            try{
                uploadFile=sysFileService.uploadFile(files[i]);
            }catch (GlobalException e){
                log.error(e.getMessage(), e);
                fileImgName.add(uploadFile.getFileName());
                failList.add(i+1);
                fileMsg.append(i+1);
                if(i<files.length-1){
                    fileUrl.append("，");
                    fileMsg.append("，");
                }
                continue;
            }
            fileUrl.append(uploadFile.getUrl());
            if(i<files.length-1){
                fileUrl.append(",");
            }
        }
        if(failList.size()!=0){
            for(String name:fileImgName){
                sysFileService.removeFile(name);
            }
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return R.error(new CodeMsg(CodeMsg.IMG_UPLOAD_FAIL.getCode(),"第"+fileMsg+"张图片上传失败"),failList);
        }
        //修改数据库图片字段
        record.setDiseaseImg(fileUrl.toString());
        Boolean updateFlag=onlineInquiryRecordService.updateById(record);
        if(updateFlag){
            return R.ok(true,"就诊信息上传成功");
        }
        return R.error(CodeMsg.IMG_SAVE_FAIL);
    }


    @Override
    public IPage<PcOnlineInquiryRecordDTO> getInquiryListPage(IPage<PcOnlineInquiryRecordDTO> page, PcOnlineInquiryRecordDTO pcOnlineInquiryRecordDTO) {
        List<PcOnlineInquiryRecordDTO>   lineInquiryList = onlineInquiryRecordService.getInquiryListPage(page,pcOnlineInquiryRecordDTO);
        return page.setRecords(lineInquiryList);
    }
}
