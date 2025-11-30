package com.wyzy.hospital.integration.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wyzy.hospital.common.core.util.CodeMsg;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.common.log.annotation.SysLog;
import com.wyzy.hospital.common.mybatis.support.Condition;
import com.wyzy.hospital.common.mybatis.support.Query;
import com.wyzy.hospital.integration.dto.BpIntegralDTO;
import com.wyzy.hospital.integration.entity.BpIntegral;
import com.wyzy.hospital.integration.entity.BpIntegralrule;
import com.wyzy.hospital.integration.kit.BpIntegralKitService;
import com.wyzy.hospital.integration.service.BpIntegralService;
import com.wyzy.hospital.integration.service.BpIntegralruleService;
import com.wyzy.hospital.integration.vo.BpIntegralVO;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.sql.Array;
import java.util.List;


/**
 * 积分表
 *
 * @author hospital code generator
 * @date 2021-05-07 09:43:45
 */
@RestController
@AllArgsConstructor
@RequestMapping("/bpintegral" )
@Api(value = "bpintegral", tags = "积分表管理")
public class BpIntegralController {

    private final  BpIntegralService bpIntegralService;
	private final BpIntegralKitService bpIntegralKitService;
	private final BpIntegralruleService bpIntegralruleService;

	/**
	 * 冻结积分
	 * @param phone
	 * @param obtainIntegral
	 * @return R
	 */
	@ApiOperation(value = "冻结积分", notes = "冻结积分")
	@SysLog("冻结积分" )
	@PostMapping("/frozenIntegral")
	@PreAuthorize("@pms.hasPermission('integration_bpintegral_add')" )
	public R<Boolean> frozenIntegral(String phone,Integer obtainIntegral,Long memberId) {
		return R.ok(bpIntegralKitService.frozenIntegral(phone,obtainIntegral,memberId));
	}

	/**
	 * 消耗积分规则表
	 * @param phone 用户手机号
	 * @param obtainIntegral 消耗积分
	 * @param orderId 订单号
	 * @return R
	 */
	@ApiOperation(value = "消耗积分", notes = "消耗积分")
	@SysLog("消耗积分" )
	@PostMapping("/saveUseByPhone")
	@PreAuthorize("@pms.hasPermission('integration_bpintegral_add')" )
	public R<Boolean> saveUseByPhone(String phone,Integer obtainIntegral,String orderId,Long memberId) {
		return R.ok(bpIntegralKitService.saveUseByPhone(phone,obtainIntegral,orderId,memberId));
	}

	/**
	 * 释放冻结积分
	 * @param phone 释放冻结积分
	 * @return R
	 */
	@ApiOperation(value = "释放冻结积分", notes = "释放冻结积分")
	@SysLog("释放冻结积分" )
	@PutMapping("/releaseBpIntegral")
	@PreAuthorize("@pms.hasPermission('integration_bpintegral_edit')" )
	public R<Boolean> releaseBpIntegral(String phone,Integer obtainIntegral,Long memberId) {
		return R.ok(bpIntegralKitService.releaseBpIntegral(phone,obtainIntegral,memberId));
	}

    /**
     * 分页查询
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    @PreAuthorize("@pms.hasPermission('integration_bpintegral_view')" )
    public R<IPage<BpIntegralDTO>> getBpIntegralPage(Query query) {
		IPage<BpIntegralDTO> bpIntegralDTOIPage = bpIntegralService.getBpIntegralPage(Condition.getPage(query));
        return R.ok(bpIntegralDTOIPage);
    }

	/**
	 * 通过手机号和获取类别查询积分表
	 * @param typeName 类型名称
	 * @param phone 手机号
	 * @return R
	 */
	@ApiOperation(value = "积分变更记录:通过手机号和获取类别查询积分表", notes = "通过手机号和获取类别查询积分表")
	@GetMapping("/getByPhoneAndtypeId" )
	@PreAuthorize("@pms.hasPermission('integration_bpintegral_view')" )
	public R<IPage<BpIntegralDTO>> getByPhoneAndtypeId(Query query,String phone, String typeName) {
		IPage<BpIntegralDTO> byPhoneAndtypeId = bpIntegralService.getByPhoneAndtypeId(Condition.getPage(query), phone, typeName);
		return R.ok(byPhoneAndtypeId);
	}


	/**
	 *  增减积分
	 * @param phone
	 * @param obtainIntegral
	 * type 0增加 1扣除
	 * @return R
	 */
	@ApiOperation(value = "增减积分", notes = "增减积分")
	@SysLog("增减积分" )
	@PostMapping("/addAndSubtract")
	@PreAuthorize("@pms.hasPermission('integration_bpintegral_add')" )
	public R<Boolean> addAndSubtract(String phone,Integer obtainIntegral,Integer type,Long memberId) {
		return R.ok(bpIntegralKitService.addAndSubtract(phone,obtainIntegral,type,memberId));
	}

	/**
	 * 查询会员积分管理
	 * @param
	 * @return R
	 */
	@ApiOperation(value = "查询会员积分管理", notes = "查询会员积分管理")
	@GetMapping("/getBpIntegralGather" )
	@PreAuthorize("@pms.hasPermission('integration_bpintegral_view')" )
	public R<List<BpIntegralVO>> getBpIntegralGather(Integer minIntegral,Integer maxIntegral,String phone) {
		List<BpIntegralVO> bpIntegralGather = bpIntegralService.getBpIntegralGather(minIntegral, maxIntegral, phone);
		if (bpIntegralGather == null || bpIntegralGather.size() == 0){
			return R.error(CodeMsg.NO_DATA);
		}
		return R.ok(bpIntegralGather);
	}

	/**
	 * 查询会员积分字段排序
	 * @param
	 * @return R
	 */
	@ApiOperation(value = "查询会员积分字段排序", notes = "查询会员积分字段排序")
	@GetMapping("/querySort" )
	@PreAuthorize("@pms.hasPermission('integration_bpintegral_view')" )
	public R<List<BpIntegralVO>> querySort(Integer indexQuery, Integer indexSort, Integer minIntegral, Integer maxIntegral) {
		List<BpIntegralVO> bpIntegralVOList = bpIntegralService.querySort(indexQuery, indexSort, minIntegral, maxIntegral);
		if (bpIntegralVOList == null || bpIntegralVOList.size() == 0){
			return R.error(CodeMsg.NO_DATA);
		}
		return R.ok(bpIntegralVOList);
	}

	/**
	 * 通过id查询积分表
	 * @param id id
	 * @return R
	 */
	@ApiOperation(value = "通过id查询", notes = "通过id查询")
	@GetMapping("/{id}" )
	@PreAuthorize("@pms.hasPermission('integration_bpintegral_view')" )
	public R<BpIntegral> getById(@PathVariable("id" ) Long id) {
		BpIntegral byId = bpIntegralService.getById(id);
		if (byId == null){
			return R.error(CodeMsg.NO_DATA);
		}
		return R.ok(byId);
	}

	/**
	 * 获取积分类别名称
	 */
	@ApiOperation(value = "获取积分类别名称", notes = "获取积分类别名称")
	@GetMapping("/getByTypeName" )
	@PreAuthorize("@pms.hasPermission('integration_bpintegral_view')" )
	public R<List<String>> getByTypeName() {
		List<String> typeNameList = bpIntegralService.getTypeNameList();
		if (typeNameList == null || typeNameList.size() == 0){
			return R.error(CodeMsg.NO_DATA);
		}
		return R.ok(typeNameList);
	}

	/**
	 * 获取抵扣金
	 * @return R
	 */
	@ApiOperation(value = "获取抵扣金", notes = "获取抵扣金")
	@GetMapping("/DeductionByMemberId" )
	@PreAuthorize("@pms.hasPermission('integration_bpintegral_view')" )
	public R<Integer> getDeductionByMemberId(Long memberId) {
		//获取抵扣状态及抵扣配置
		BpIntegralrule integerList = bpIntegralruleService.selectNewestState();
		if (integerList.getDeduction() == 0){
			return null;
		}
		Integer integral = integerList.getIntegral();
		Integer money = integerList.getMoney();
		Integer byId = bpIntegralService.getDeductionByMemberId(memberId);
		if (byId == null){
			return R.error(CodeMsg.NO_DATA);
		}
		Integer integer = byId / integral * money;
		return R.ok(integer);
	}
}
