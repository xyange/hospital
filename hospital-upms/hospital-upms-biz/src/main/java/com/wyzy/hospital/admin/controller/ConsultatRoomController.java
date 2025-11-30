

package com.wyzy.hospital.admin.controller;

import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.common.log.annotation.SysLog;
import com.wyzy.hospital.admin.api.entity.ConsultatRoom;
import com.wyzy.hospital.admin.service.ConsultatRoomService;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 诊室表
 *
 * @author hospital code generator
 * @date 2021-04-17 08:47:10
 */
@RestController
@AllArgsConstructor
@RequestMapping("/consultatroom" )
@Api(value = "consultatroom", tags = "诊室表管理")
public class ConsultatRoomController {

    private final  ConsultatRoomService consultatRoomService;


    /**
     * 指定医院二级科室新增诊室表
     * @param consultatRoom 诊室表
     * @return R
     */
    @ApiOperation(value = "新增诊室表", notes = "新增诊室表")
    @SysLog("新增诊室表" )
    @PostMapping
    @PreAuthorize("@pms.hasPermission('admin_consultatroom_add')" )
    public R save(@RequestBody ConsultatRoom consultatRoom) {
        return R.ok(consultatRoomService.save(consultatRoom));
    }

    /**
     * 修改指定医院二级科室诊室表
     * @param consultatRoom 诊室表
     * @return R
     */
    @ApiOperation(value = "修改诊室表", notes = "修改诊室表")
    @SysLog("修改诊室表" )
    @PutMapping
    @PreAuthorize("@pms.hasPermission('admin_consultatroom_edit')" )
    public R updateById(@RequestBody ConsultatRoom consultatRoom) {
        return R.ok(consultatRoomService.updateById(consultatRoom));
    }

    /**
     * 通过医院科室ID查询诊室表
     * @param
     * @return R
     */
    @ApiOperation(value = "通过医院科室ID查询诊室表", notes = "通过医院科室ID查询诊室表")
    @GetMapping("/departmentsId" )
    @PreAuthorize("@pms.hasPermission('admin_consultatroom_view')" )
    public R<List<ConsultatRoom>> getConsultatRoomByhosdepdetailId(Long hosdepdetailId) {
        return R.ok(consultatRoomService.getConsultatRoomByhosdepdetailId(hosdepdetailId));
    }

    /**
     * 通过诊室ID删除诊室表 伪删除
     * @param --id id
     * @return R
     */
    @ApiOperation(value = "通过诊室ID删除诊室表", notes = "通过诊室ID删除诊室表")
    @SysLog("通过诊室ID删除诊室表" )
    @DeleteMapping("/{id}" )
    @PreAuthorize("@pms.hasPermission('admin_consultatroom_del')" )
    public R removeById(@PathVariable Long id) {
        return R.ok(consultatRoomService.removeById(id));
    }
}
