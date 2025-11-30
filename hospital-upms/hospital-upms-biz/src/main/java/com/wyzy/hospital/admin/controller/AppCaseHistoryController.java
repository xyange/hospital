package com.wyzy.hospital.admin.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wyzy.hospital.admin.api.dto.CaseHistoryDTO;
import com.wyzy.hospital.admin.api.dto.PatientCardDTO;
import com.wyzy.hospital.admin.api.entity.CaseHistory;
import com.wyzy.hospital.admin.service.CaseHistoryService;
import com.wyzy.hospital.common.core.constant.CommonConstants;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.common.security.service.HospitalUser;
import com.wyzy.hospital.common.security.util.SecurityUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author aqie
 * Date on 2021/4/27  14:29
 * @Function:
 */
@RestController
@AllArgsConstructor
@RequestMapping("/app/casehistory" )
@Api(value = "appCasehistory", tags = "app病历表管理")
public class AppCaseHistoryController {
    private final CaseHistoryService caseHistoryService;

    private HospitalUser getUser(){
        return  SecurityUtils.getUser();
    }
    /**
     * 分页查询
     * @param page 分页对象
     * @param caseHistory 病历表
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    @PreAuthorize("@pms.hasPermission('app')" )
    public R getCaseHistoryPage(Page page, CaseHistory caseHistory) {
        return R.ok(caseHistoryService.page(page, Wrappers.query(caseHistory)));
    }


    /**
     * 通过id查询病历表
     * @param caseHistoryId id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{caseHistoryId}" )
    @PreAuthorize("@pms.hasPermission('admin_casehistory_view')" )
    public R getById(@PathVariable("caseHistoryId" ) Long caseHistoryId) {
        return R.ok(caseHistoryService.getById(caseHistoryId));
    }


    /**
    * @Description: 根据会员id查询就诊人
    * @Param: []
    * @return: com.wyzy.hospital.common.core.util.R<java.util.List<com.wyzy.hospital.admin.api.dto.PatientCardDTO>>
    * @Author: songM
    * @Date: 2021/6/18
    */
    @ApiOperation(value = "根据会员id查询就诊人 ", notes = "根据会员id查询就诊人")
    @GetMapping("selectPatientNameByMemberId" )
    @PreAuthorize("@pms.hasPermission("+ CommonConstants.PATIENT_APP+")")
    public R<List<PatientCardDTO>> selectPatientNameByMemberId( Long cardId ) {

            Long memberId = getUser().getMemberId();
            System.out.println(memberId);
            return R.ok(caseHistoryService.selectPatientNameByMemberId(memberId,cardId));
    }
    /**
    * @Description: 根据就诊卡id查询病例信息
    * @Param: []
    * @return: com.wyzy.hospital.common.core.util.R<java.util.List<com.wyzy.hospital.admin.api.dto.PatientCardDTO>>
    * @Author: songM
    * @Date: 2021/6/18
    */
    @ApiOperation(value = "根据就诊卡id查询病例列表 ", notes = "根据就诊卡id查询病例列表")
    @GetMapping("selectCaseHistoryByCardId" )
    @PreAuthorize("@pms.hasPermission("+ CommonConstants.PATIENT_APP+")")
    public R<List<CaseHistoryDTO>> selectCaseHistoryByCardId(Long cardId) {
        return R.ok(caseHistoryService.selectCaseHistoryByCardId(cardId));
    }

}
