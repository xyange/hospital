

package com.wyzy.hospital.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wyzy.hospital.admin.api.dto.member.MemberDTO;
import com.wyzy.hospital.admin.api.entity.Member;
import com.wyzy.hospital.admin.service.MemberService;
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
 * 会员表
 *
 * @author aqie
 * @date 2021-04-26 14:56:59
 */
@RestController
@AllArgsConstructor
@RequestMapping("/member" )
@Api(value = "member", tags = "会员表管理")
public class MemberController {

    private final  MemberService memberService;

    /**
     * 分页查询
     * @param query 分页对象
     * @param memberDTO 会员表
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    @PreAuthorize("@pms.hasPermission('admin_member_view')" )
    public R<IPage<MemberDTO>> getMemberPage(Query query, MemberDTO memberDTO) {
        return R.ok(memberService.page(Condition.getPage(query),memberDTO));
    }


    /**
     * 通过id查询会员表
     * @param memberId id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{memberId}" )
    @PreAuthorize("@pms.hasPermission('admin_member_view')" )
    public R<MemberDTO> getById(@PathVariable("memberId" ) Long memberId) {
        return R.ok(memberService.getById(memberId));
    }

    /**
     * 新增会员表
     * @param member 会员表
     * @return R
     */
    @ApiOperation(value = "新增会员表", notes = "新增会员表")
    @SysLog("新增会员表" )
    @PostMapping
    @PreAuthorize("@pms.hasPermission('admin_member_add')" )
    public R save(@RequestBody Member member) {
        return R.ok(memberService.save(member));
    }

    /**
     * 修改会员表
     * @param member 会员表
     * @return R
     */
    @ApiOperation(value = "修改会员表", notes = "修改会员表")
    @SysLog("修改会员表" )
    @PutMapping
    @PreAuthorize("@pms.hasPermission('admin_member_edit')" )
    public R updateById(@RequestBody Member member) {
        return R.ok(memberService.updateById(member));
    }

    /**
     * 通过id删除会员表
     * @param memberId id
     * @return R
     */
    @ApiOperation(value = "通过id删除会员表", notes = "通过id删除会员表")
    @SysLog("通过id删除会员表" )
    @DeleteMapping("/{memberId}" )
    @PreAuthorize("@pms.hasPermission('admin_member_del')" )
    public R removeById(@PathVariable Long memberId) {
        return R.ok(memberService.removeById(memberId));
    }

}
