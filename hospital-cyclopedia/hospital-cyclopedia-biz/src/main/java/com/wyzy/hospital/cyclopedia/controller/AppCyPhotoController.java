

package com.wyzy.hospital.cyclopedia.controller;

import com.wyzy.hospital.common.core.constant.CommonConstants;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.cyclopedia.dto.CyPhotoDTO;
import com.wyzy.hospital.cyclopedia.service.CyPhotoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * 轮播图表
 *
 * @author hospital code generator
 * @date 2021-06-07 11:09:07
 */
@RestController
@AllArgsConstructor
@RequestMapping("app/cyphoto" )
@Api(value = "cyphoto", tags = "App轮播图表管理")
public class AppCyPhotoController {

    private final  CyPhotoService cyPhotoService;


    /**
     * 通过imageCode查询轮播图表
     * @param imageCode imageCode
     * @return R
     */
    @ApiOperation(value = "百科轮播图", notes = "百科轮播图")
    @GetMapping("/queryCyclopedia/{imageCode}" )
	@PreAuthorize("@pms.hasPermission("+ CommonConstants.PATIENT_APP+")")
    public R<List<CyPhotoDTO>> queryCyclopediaImage(@PathVariable("imageCode" )Long imageCode) {
        return R.ok(cyPhotoService.queryCyclopediaImage(imageCode));
    }

}
