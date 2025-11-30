package com.wyzy.hospital.admin.api.feign;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wyzy.hospital.admin.api.vo.hospital.AppHospitalVO;
import com.wyzy.hospital.common.core.constant.ServiceNameConstants;
import com.wyzy.hospital.common.core.util.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author aqie
 * Date on 2021/5/20  10:44
 * @Function:
 */
@FeignClient(contextId = "remoteHospitalService", value = ServiceNameConstants.UPMS_SERVICE)
public interface RemoteHospitalService {
    @GetMapping("/app/hospitals/getHospitalList")
    R<Page<AppHospitalVO>> getHospitalList(@RequestParam(value = "current")Integer current,
                                           @RequestParam(value = "size")Integer size,
                                           @RequestParam(value = "hospitalName")String hospitalName);
}
