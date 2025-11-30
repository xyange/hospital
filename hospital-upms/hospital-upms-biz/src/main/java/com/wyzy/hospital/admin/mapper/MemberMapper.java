

package com.wyzy.hospital.admin.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wyzy.hospital.admin.api.dto.member.MemberDTO;
import com.wyzy.hospital.admin.api.entity.Member;
import com.wyzy.hospital.common.data.datascope.HospitalBaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * 会员表
 *
 * @author aqie
 * @date 2021-04-26 14:56:59
 */
@Mapper
public interface MemberMapper extends HospitalBaseMapper<Member> {
    /**
     * 会员详情
     * @param memberId
     * @return
     */
    MemberDTO detail(@Param("memberId") Long memberId);

    /**
     * 会员列表
     * @param memberDTO
     * @return
     */
    IPage<MemberDTO> page(IPage<MemberDTO> page, @Param("member") MemberDTO memberDTO);

    @Select("select member_id from wyzy_member where user_id=#{userId}")
    Long getMemberIdByUserId(Long userId);

    @Select("select member_id,nickname,phone from wyzy_member where member_id=#{memberId}")
    Member getMember(Long memberId);
}
