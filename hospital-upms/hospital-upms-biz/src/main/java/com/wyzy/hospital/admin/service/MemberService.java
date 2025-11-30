

package com.wyzy.hospital.admin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wyzy.hospital.admin.api.dto.member.MemberDTO;
import com.wyzy.hospital.admin.api.entity.Member;

/**
 * 会员表
 *
 * @author aqie
 * @date 2021-04-26 14:56:59
 */
public interface MemberService extends IService<Member> {
    /**
     * 查询会员
     * @param memberId
     * @return
     */
    Member getMember(Long memberId);
    /**
     * 查询会员详情
     * @param memberId
     * @return
     */
    MemberDTO getById(Long memberId);

    /**
     * 分页查询会员列表
     * @param page
     * @param memberDTO
     * @return
     */
    IPage<MemberDTO>  page(IPage<MemberDTO> page, MemberDTO memberDTO);

    /**
     * 根据用户id 获取memberID
     * @param userId
     * @return
     */
    Long getMemberIdByUserId(Long userId);
}
