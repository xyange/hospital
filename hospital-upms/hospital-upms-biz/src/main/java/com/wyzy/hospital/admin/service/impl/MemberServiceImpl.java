
package com.wyzy.hospital.admin.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyzy.hospital.admin.api.dto.member.MemberDTO;
import com.wyzy.hospital.admin.api.entity.Member;
import com.wyzy.hospital.admin.mapper.MemberMapper;
import com.wyzy.hospital.admin.service.MemberService;
import org.springframework.stereotype.Service;

/**
 * 会员表
 *
 * @author aqie
 * @date 2021-04-26 14:56:59
 */
@Service
public class MemberServiceImpl extends ServiceImpl<MemberMapper, Member> implements MemberService {

    @Override
    public Member getMember(Long memberId) {
        return baseMapper.getMember(memberId);
    }

    @Override
    public MemberDTO getById(Long memberId) {
        return baseMapper.detail(memberId);
    }

    @Override
    public IPage<MemberDTO> page(IPage<MemberDTO> page, MemberDTO memberDTO) {
        return baseMapper.page(page, memberDTO);
    }

    @Override
    public Long getMemberIdByUserId(Long userId) {
        return baseMapper.getMemberIdByUserId(userId);
    }
}
