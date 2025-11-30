package com.wyzy.hospital.admin.api.feign;

import com.wyzy.hospital.admin.api.entity.Member;
import com.wyzy.hospital.common.core.constant.ServiceNameConstants;
import com.wyzy.hospital.common.core.util.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author aqie
 * Date on 2021/6/4  18:27
 * @Function:
 */
@FeignClient(contextId = "remoteMemberService", value = ServiceNameConstants.UPMS_SERVICE)
public interface RemoteMemberService {
    /**
     * @param memberId
     * @return
     */
    @GetMapping("/app/member/getMember/{id}")
    R<Member> getMember(@PathVariable("id") Long memberId);
}
