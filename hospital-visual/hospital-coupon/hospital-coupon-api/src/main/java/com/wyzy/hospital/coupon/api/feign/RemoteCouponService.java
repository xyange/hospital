package com.wyzy.hospital.coupon.api.feign;

import com.wyzy.hospital.common.core.constant.ServiceNameConstants;
import com.wyzy.hospital.common.core.util.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author aqie
 * Date on 2021/4/9  16:53
 * @Function: 服务远程调用
 */
@FeignClient(contextId = "remoteCouponService", value = ServiceNameConstants.DOCTOR_HOSPITAL)
public interface RemoteCouponService {
	@GetMapping("/test")
	R<String> testDoctor(@RequestParam("content") String content);
}
