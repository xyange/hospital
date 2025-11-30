

package com.wyzy.hospital.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wyzy.hospital.admin.api.dto.hospital.AppHospitalDTO;
import com.wyzy.hospital.admin.api.dto.hospital.HospitalDetailDTO;
import com.wyzy.hospital.admin.api.vo.hospital.AppHospitalVO;
import com.wyzy.hospital.admin.kit.HospitalKitService;
import com.wyzy.hospital.admin.service.UserHospitalService;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.common.mybatis.support.Condition;
import com.wyzy.hospital.common.mybatis.support.Query;
import com.wyzy.hospital.common.security.service.HospitalUser;
import com.wyzy.hospital.common.security.util.SecurityUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


/**
 * 医院表
 *
 * @author aqie
 * @date 2021-04-15 15:42:23
 */
@RestController
@AllArgsConstructor
@RequestMapping("/app/hospitals" )
@Api(value = "hospitals", tags = "App医院接口")
public class AppHospitalsController {

    private final HospitalKitService hospitalsKitService;


    private final UserHospitalService userHospitalService;


    /**
     * 通过id查询医院表
     * @param hospitalId
     * @return R
     */
    @ApiOperation(value = "医院详情", notes = "医院详情")
    @GetMapping("/{id}" )
    @PreAuthorize("@pms.hasPermission('app_hospitals_view')" )
    public R<HospitalDetailDTO> getById(@PathVariable("id" ) Long hospitalId) {
        HospitalUser user = SecurityUtils.getUser();
        return R.ok(hospitalsKitService.detail(user.getId(), hospitalId));
    }

    /**
     * 医院收藏/取消收藏
     */
    @ApiOperation(value = "医院收藏/取消收藏", notes = "1、收藏 0、取消收藏")
    @PostMapping("collectHospital/{id}")
    public R<Integer> collectHospital(@PathVariable("id") Long hospitalId){
        HospitalUser user = SecurityUtils.getUser();
        Integer i = userHospitalService.collectHospital(user.getId(), hospitalId);
        return R.ok(i);
    }

    /**
     * 分页查询医院
     * todo 咨询人数
     */
    @ApiOperation(value = "根据科室id/医院名称 分页查询医院")
    @GetMapping("getHospitalList")
    @PreAuthorize("@pms.hasPermission('app_hospitals_view')" )
    public R<IPage<AppHospitalVO>> getHospitalList(Query query, AppHospitalDTO hospitalsDTO){
        IPage<AppHospitalVO> hospitalsPage = hospitalsKitService.getHospitalList(Condition.getPage(query), hospitalsDTO);
        return R.ok(hospitalsPage);
    }
}
