

package com.wyzy.hospital.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wyzy.hospital.admin.api.entity.SysDic;
import com.wyzy.hospital.admin.api.entity.SysDicItem;
import com.wyzy.hospital.admin.service.SysDicItemService;
import com.wyzy.hospital.admin.service.SysDicService;
import com.wyzy.hospital.common.core.constant.CacheConstants;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.common.log.annotation.SysLog;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @description: 系统字典
 * @author wrk
 * @date  日期
 * @version 1.0
 */
@RestController
@AllArgsConstructor
@RequestMapping("/dic")
@Api(value = "dic", tags = "系统字典管理模块")
public class SysDicController {

    private final SysDicService sysDicService;

    private final SysDicItemService sysDicItemService;

    /**
     * 通过ID查询字典信息
     * @param id ID
     * @return 字典信息
     */
    @GetMapping("/{id}")
    public R getById(@PathVariable Integer id) {
        return R.ok(sysDicService.getById(id));
    }

    /**
     * 分页查询字典信息
     * @param page 分页对象
     * @return 分页对象
     */
    @GetMapping("/page")
    public R<IPage> getDicPage(Page page, SysDic sysDic) {
        return R.ok(sysDicService.page(page, Wrappers.query(sysDic)));
    }

    /**
     * 通过字典类型查找字典
     * @param type 类型
     * @return 同类型字典
     */
    @GetMapping("/type/{type}")
    @Cacheable(value = CacheConstants.DIC_DETAILS, key = "#type", unless = "#result.data.isEmpty()")
    public R getDicByType(@PathVariable String type) {
        return R.ok(sysDicItemService.list(Wrappers.<SysDicItem>query().lambda().eq(SysDicItem::getType, type)));
    }

    /**
     * 添加字典
     * @param sysDic 字典信息
     * @return success、false
     */
    @SysLog("添加字典")
    @PostMapping
    @PreAuthorize("@pms.hasPermission('sys_dic_add')")
    public R save(@Valid @RequestBody SysDic sysDic) {
        return R.ok(sysDicService.save(sysDic));
    }

    /**
     * 删除字典，并且清除字典缓存
     * @param id ID
     * @return R
     */
    @SysLog("删除字典")
    @DeleteMapping("/{id}")
    @PreAuthorize("@pms.hasPermission('sys_dic_del')")
    public R removeById(@PathVariable Integer id) {
        return sysDicService.removeDic(id);
    }

    /**
     * 修改字典
     * @param sysDic 字典信息
     * @return success/false
     */
    @PutMapping
    @SysLog("修改字典")
    @PreAuthorize("@pms.hasPermission('sys_dic_edit')")
    public R updateById(@Valid @RequestBody SysDic sysDic) {
        return sysDicService.updateDic(sysDic);
    }

    /**
     * 分页查询
     * @param page 分页对象
     * @param sysDicItem 字典项
     * @return
     */
    @GetMapping("/item/page")
    public R getSysDicItemPage(Page page, SysDicItem sysDicItem) {
        return R.ok(sysDicItemService.page(page, Wrappers.query(sysDicItem)));
    }

    /**
     * 通过id查询字典项
     * @param id id
     * @return R
     */
    @GetMapping("/item/{id}")
    public R getDicItemById(@PathVariable("id") Integer id) {
        return R.ok(sysDicItemService.getById(id));
    }

    /**
     * 新增字典项
     * @param sysDicItem 字典项
     * @return R
     */
    @SysLog("新增字典项")
    @PostMapping("/item")
    @CacheEvict(value = CacheConstants.DIC_DETAILS, allEntries = true)
    public R save(@RequestBody SysDicItem sysDicItem) {
        return R.ok(sysDicItemService.save(sysDicItem));
    }

    /**
     * 修改字典项
     * @param sysDicItem 字典项
     * @return R
     */
    @SysLog("修改字典项")
    @PutMapping("/item")
    public R updateById(@RequestBody SysDicItem sysDicItem) {
        return sysDicItemService.updateDicItem(sysDicItem);
    }

    /**
     * 通过id删除字典项
     * @param id id
     * @return R
     */
    @SysLog("删除字典项")
    @DeleteMapping("/item/{id}")
    public R removeDicItemById(@PathVariable Integer id) {
        return sysDicItemService.removeDicItem(id);
    }



    /**
     * 查询医生类型
     * @return R
     */
    @GetMapping("/item/getAllDoctorType")
    public R getAllDoctorType(){
       return sysDicItemService.getAllDoctorType();
    }


    /**
     * 查询所有诊疗模式-远程会诊
     * @return R
     */
    @GetMapping("/item/getAllConsultationType")
    public R getAllConsultationType(){
        return sysDicItemService.getAllConsultationType();
    }
}
