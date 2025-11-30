

package com.wyzy.hospital.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wyzy.hospital.admin.api.dto.online.PcOnlineInquiryRecordDTO;
import com.wyzy.hospital.admin.api.entity.OnlineInquiryRecord;
import com.wyzy.hospital.admin.kit.OnlineInquiryRecordKitService;
import com.wyzy.hospital.admin.service.OnlineInquiryRecordService;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.common.log.annotation.SysLog;
import com.wyzy.hospital.common.mybatis.support.Condition;
import com.wyzy.hospital.common.mybatis.support.Query;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


/**
 * 在线问诊记录
 *
 * @author aqie
 * @date 2021-04-26 15:27:43
 */
@RestController
@AllArgsConstructor
@RequestMapping("/onlineinquiryrecord" )
@Api(value = "onlineinquiryrecord", tags = "在线问诊记录管理")
public class OnlineInquiryRecordController {

    private final  OnlineInquiryRecordService onlineInquiryRecordService;

    private final  OnlineInquiryRecordKitService onlineInquiryRecordKitService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param onlineInquiryRecord 在线问诊记录
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    @PreAuthorize("@pms.hasPermission('admin_onlineinquiryrecord_view')" )
    public R getOnlineInquiryRecordPage(Page page, OnlineInquiryRecord onlineInquiryRecord) {
        return R.ok(onlineInquiryRecordService.page(page, Wrappers.query(onlineInquiryRecord)));
    }


    /**
     * 通过id查询在线问诊记录
     * @param inquiryId id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{inquiryId}" )
    @PreAuthorize("@pms.hasPermission('admin_onlineinquiryrecord_view')" )
    public R getById(@PathVariable("inquiryId" ) Long inquiryId) {
        return R.ok(onlineInquiryRecordService.getById(inquiryId));
    }

    /**
     * 新增在线问诊记录
     * @param onlineInquiryRecord 在线问诊记录
     * @return R
     */
    @ApiOperation(value = "新增在线问诊记录", notes = "新增在线问诊记录")
    @SysLog("新增在线问诊记录" )
    @PostMapping
    @PreAuthorize("@pms.hasPermission('admin_onlineinquiryrecord_add')" )
    public R save(@RequestBody OnlineInquiryRecord onlineInquiryRecord) {
        return R.ok(onlineInquiryRecordService.save(onlineInquiryRecord));
    }

    /**
     * 修改在线问诊记录
     * @param onlineInquiryRecord 在线问诊记录
     * @return R
     */
    @ApiOperation(value = "修改在线问诊记录", notes = "修改在线问诊记录")
    @SysLog("修改在线问诊记录" )
    @PutMapping
    @PreAuthorize("@pms.hasPermission('admin_onlineinquiryrecord_edit')" )
    public R updateById(@RequestBody OnlineInquiryRecord onlineInquiryRecord) {
        return R.ok(onlineInquiryRecordService.updateById(onlineInquiryRecord));
    }

    /**
     * 通过id删除在线问诊记录
     * @param inquiryId id
     * @return R
     */
    @ApiOperation(value = "通过id删除在线问诊记录", notes = "通过id删除在线问诊记录")
    @SysLog("通过id删除在线问诊记录" )
    @DeleteMapping("/{inquiryId}" )
    @PreAuthorize("@pms.hasPermission('admin_onlineinquiryrecord_del')" )
    public R removeById(@PathVariable Long inquiryId) {
        return R.ok(onlineInquiryRecordService.removeById(inquiryId));
    }



    /**
    * @Description: PC  获取在线沟通列表
    * @Param: [page, onlineInquiryRecord]
    * @return: com.wyzy.hospital.common.core.util.R
    * @Author: songM
    * @Date: 2021/6/10
    */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/getInquiryListPage" )
    @PreAuthorize("@pms.hasPermission('admin_onlineinquiryrecord_view')" )
    public R<IPage<PcOnlineInquiryRecordDTO>> getInquiryListPage(Query query, PcOnlineInquiryRecordDTO pcOnlineInquiryRecordDTO) {
        return R.ok(onlineInquiryRecordKitService.getInquiryListPage(Condition.getPage(query), pcOnlineInquiryRecordDTO));
    }


}
