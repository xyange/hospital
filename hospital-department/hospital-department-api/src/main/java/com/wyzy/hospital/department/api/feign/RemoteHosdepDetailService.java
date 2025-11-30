package com.wyzy.hospital.department.api.feign;

import com.wyzy.hospital.common.core.constant.ServiceNameConstants;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 科室信息远程调用
 * @author wrk
 */
@FeignClient(contextId = "remoteHosdepDetailService", value = ServiceNameConstants.DEPARTMENT_HOSPITAL)
public interface RemoteHosdepDetailService {
}
