package com.wyzy.hospital.admin.controller;

import com.wyzy.hospital.admin.api.entity.Member;
import com.wyzy.hospital.admin.service.MemberService;
import com.wyzy.hospital.common.core.util.R;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author aqie
 * Date on 2021/4/27  9:19
 * @Function: 个人中心相关接口
 */
@RestController
@AllArgsConstructor
@RequestMapping("/app/member" )
@Api(value = "member", tags = "app会员表管理")
public class AppMemberController {

    private MemberService memberService;

    @GetMapping("/getMember/{id}")
    public R<Member> getMember(@PathVariable("id") Long memberId){
        Member member = memberService.getMember(memberId);
        return R.ok(member);
    }
}
