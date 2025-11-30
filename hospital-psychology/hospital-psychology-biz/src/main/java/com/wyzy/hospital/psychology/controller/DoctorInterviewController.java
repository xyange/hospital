

package com.wyzy.hospital.psychology.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wyzy.hospital.common.core.constant.CommonConstants;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.common.log.annotation.SysLog;
import com.wyzy.hospital.psychology.api.entity.DoctorInterview;
import com.wyzy.hospital.psychology.service.DoctorInterviewService;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * 心理咨询师访谈
 *
 * @author hospital code generator
 * @date 2021-06-11 09:52:56
 */
@RestController
@AllArgsConstructor
@RequestMapping("/doctorinterview" )
@Api(value = "doctorinterview", tags = "心理咨询师访谈管理")
public class DoctorInterviewController {

    private final  DoctorInterviewService doctorInterviewService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param doctorInterview 心理咨询师访谈
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    @PreAuthorize("@pms.hasPermission('psychology_doctorinterview_view')" )
    public R getDoctorInterviewPage(Page page, DoctorInterview doctorInterview) {
        return R.ok(doctorInterviewService.page(page, Wrappers.query(doctorInterview)));
    }


    /**
     * 通过id查询心理咨询师访谈
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{id}" )
    @PreAuthorize("@pms.hasPermission('psychology_doctorinterview_view')" )
    public R<DoctorInterview> getById(@PathVariable("id" ) Long id) {
        return R.ok(doctorInterviewService.getById(id));
    }

    /**
     * 新增心理咨询师访谈
     * @param doctorInterview 心理咨询师访谈
     * @return R
     */
    @ApiOperation(value = "新增心理咨询师访谈", notes = "新增心理咨询师访谈")
    @SysLog("新增心理咨询师访谈" )
    @PostMapping
    @PreAuthorize("@pms.hasPermission('psychology_doctorinterview_add')" )
    public R<Boolean> save(@RequestBody DoctorInterview doctorInterview) {
        return R.ok(doctorInterviewService.save(doctorInterview));
    }

    /**
     * 修改心理咨询师访谈
     * @param doctorInterview 心理咨询师访谈
     * @return R
     */
    @ApiOperation(value = "修改心理咨询师访谈", notes = "修改心理咨询师访谈")
    @SysLog("修改心理咨询师访谈" )
    @PutMapping
    @PreAuthorize("@pms.hasPermission('psychology_doctorinterview_edit')" )
    public R<Boolean> updateById(@RequestBody DoctorInterview doctorInterview) {
        return R.ok(doctorInterviewService.updateById(doctorInterview));
    }

    /**
     * 通过id删除心理咨询师访谈
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id删除心理咨询师访谈", notes = "通过id删除心理咨询师访谈")
    @SysLog("通过id删除心理咨询师访谈" )
    @DeleteMapping("/{id}" )
    @PreAuthorize("@pms.hasPermission('psychology_doctorinterview_del')" )
    public R<Boolean> removeById(@PathVariable Long id) {
        return R.ok(doctorInterviewService.removeById(id));
    }

}
