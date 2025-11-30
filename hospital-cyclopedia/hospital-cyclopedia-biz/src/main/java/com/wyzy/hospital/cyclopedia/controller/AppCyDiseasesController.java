

package com.wyzy.hospital.cyclopedia.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wyzy.hospital.common.core.constant.CommonConstants;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.cyclopedia.dto.CyDiseasesDTO;
import com.wyzy.hospital.cyclopedia.entity.CyDiseases;
import com.wyzy.hospital.cyclopedia.kit.AddDiseasesKitService;
import com.wyzy.hospital.cyclopedia.service.CyDiseasesService;
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
 * 疾病表
 *
 * @author hospital code generator
 * @date 2021-05-08 14:37:31
 */
@RestController
@AllArgsConstructor
@RequestMapping("/app/cydiseases" )
@Api(value = "cydiseases", tags = "App百科疾病表")
public class AppCyDiseasesController {

    private final  CyDiseasesService cyDiseasesService;
    private final AddDiseasesKitService addDiseasesKitService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param cyDiseases 疾病表
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
	@PreAuthorize("@pms.hasPermission("+ CommonConstants.PATIENT_APP+")")
    public R getCyDiseasesPage(Page page, CyDiseases cyDiseases) {
        return R.ok(cyDiseasesService.page(page, Wrappers.query(cyDiseases)));
    }


	/**
	 * 随机查询9种疾病
	 * @return R
	 */
	@ApiOperation(value = "随机查询9种疾病", notes = "随机查询9种疾病")
	@GetMapping("/RandDiseases" )
	@PreAuthorize("@pms.hasPermission("+ CommonConstants.PATIENT_APP+")")
	public R<List<CyDiseasesDTO>> RandDiseases() {
		return R.ok(cyDiseasesService.queryRandDiseases());
	}

	/**
	 * 查询疾病数量
	 * @return R
	 */
	@ApiOperation(value = "查询疾病总数量", notes = "查询疾病数量")
	@GetMapping("/queryNumber" )
	@PreAuthorize("@pms.hasPermission("+ CommonConstants.PATIENT_APP+")")
	public R QueryNumber() {
		return R.ok(cyDiseasesService.queryNumberEnDiseases());
	}

	/**
	 * 通过disId查询疾病
	 * @param disId disId
	 * @return R
	 */
	@ApiOperation(value = "根据id查询疾病详情", notes = "通过disId查询疾病表")
	@GetMapping("/queryCyDiseasesById/{disId}" )
	@PreAuthorize("@pms.hasPermission("+ CommonConstants.PATIENT_APP+")")
	public R <List<CyDiseasesDTO>> queryCyDiseasesById(@PathVariable("disId" ) Long disId) {
		return R.ok(cyDiseasesService.queryCyDiseasesById(disId));
	}

}
