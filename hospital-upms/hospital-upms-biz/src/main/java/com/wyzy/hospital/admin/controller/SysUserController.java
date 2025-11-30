

package com.wyzy.hospital.admin.controller;

import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pig4cloud.aliyun.sms.SmsClient;
import com.pig4cloud.plugin.excel.annotation.ResponseExcel;
import com.wyzy.hospital.admin.api.dto.UserDTO;
import com.wyzy.hospital.admin.api.entity.SysUser;
import com.wyzy.hospital.admin.service.MemberService;
import com.wyzy.hospital.admin.service.SysUserService;
import com.wyzy.hospital.common.core.constant.CommonConstants;
import com.wyzy.hospital.common.core.constant.SecurityConstants;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.common.log.annotation.SysLog;
import com.wyzy.hospital.common.oss.service.OssTemplate;
import com.wyzy.hospital.common.security.annotation.Inner;
import com.wyzy.hospital.common.security.util.SecurityUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

/**
 * @author wyzy
 * @date 2018/12/16
 */
@RestController
@AllArgsConstructor
@RequestMapping("/user")
@Api(value = "user", tags = "用户管理模块")
public class SysUserController {

	private final SysUserService userService;

	private final MemberService memberService;

	private final OssTemplate template;

	/**
	 * 获取指定用户全部信息
	 * @return 用户信息
	 */
	@Inner
	@GetMapping("/info/{username}")
	public R info(@PathVariable String username) {
		SysUser user = userService.getOne(Wrappers.<SysUser>query().lambda().eq(SysUser::getUsername, username));
		if (user == null) {
			return R.failed(null, String.format("用户信息为空 %s", username));
		}
		Long memberId = memberService.getMemberIdByUserId(user.getUserId());
		return R.ok(userService.findUserInfoWithMemberId(user, memberId));
	}

	/**
	 * 获取当前用户全部信息
	 * @return 用户信息
	 */
	@GetMapping(value = { "/info" })
	public R info() {
		String username = SecurityUtils.getUser().getUsername();
		SysUser user = userService.getOne(Wrappers.<SysUser>query().lambda().eq(SysUser::getUsername, username));
		if (user == null) {
			return R.failed(null, "获取当前用户信息失败");
		}
		Long memberId = memberService.getMemberIdByUserId(user.getUserId());
		return R.ok(userService.findUserInfoWithMemberId(user, memberId));
	}

	/**
	 * 通过ID查询用户信息
	 * @param id ID
	 * @return 用户信息
	 */
	@GetMapping("/{id}")
	public R user(@PathVariable Long id) {
		return R.ok(userService.selectUserVoById(id));
	}

	/**
	 * 根据用户名查询用户信息
	 * @param username 用户名
	 * @return
	 */
	@GetMapping("/details/{username}")
	public R<SysUser> user(@PathVariable String username) {
		SysUser condition = new SysUser();
		condition.setUsername(username);
		SysUser one = userService.getOne(new QueryWrapper<>(condition));
		return R.ok(one);
	}

	/**
	 * 删除用户信息
	 * @param id ID
	 * @return R
	 */
	@SysLog("删除用户信息")
	@DeleteMapping("/{id}")
	@PreAuthorize("@pms.hasPermission('sys_user_del')")
	@ApiOperation(value = "删除用户", notes = "根据ID删除用户")
	@ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "int", paramType = "path")
	public R userDel(@PathVariable Long id) {
		SysUser sysUser = userService.getById(id);
		return R.ok(userService.deleteUserById(sysUser));
	}

	/**
	 * 添加用户
	 * @param userDto 用户信息
	 * @return success/false
	 */
	@SysLog("添加用户")
	@PostMapping
	@PreAuthorize("@pms.hasPermission('sys_user_add')")
	public R<Long> user(@RequestBody UserDTO userDto) {
		Long aBoolean = userService.saveUser(userDto);
		return R.ok(aBoolean);
	}

	/**
	 * 更新用户信息
	 * @param userDto 用户信息
	 * @return R
	 */
	@SysLog("更新用户信息")
	@PutMapping
	@PreAuthorize("@pms.hasPermission('sys_user_edit')")
	public R updateUser(@Valid @RequestBody UserDTO userDto) {
		return R.ok(userService.updateUser(userDto));
	}

	/**
	 * 分页查询用户
	 * @param page 参数集
	 * @param userDTO 查询参数列表
	 * @return 用户集合
	 */
	@GetMapping("/page")
	public R getUserPage(Page page, UserDTO userDTO) {
		return R.ok(userService.getUsersWithRolePage(page, userDTO));
	}

	/**
	 * 修改个人信息
	 * @param userDto userDto
	 * @return success/false
	 */
	@SysLog("修改个人信息")
	@PutMapping("/edit")
	public R updateUserInfo(@Valid @RequestBody UserDTO userDto) {
		return userService.updateUserInfo(userDto);
	}

	/**
	 * @param username 用户名称
	 * @return 上级部门用户列表
	 */
	@GetMapping("/ancestor/{username}")
	public R listAncestorUsers(@PathVariable String username) {
		return R.ok(userService.listAncestorUsers(username));
	}

	@PostMapping("/upload")
	public R upload(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws Exception {
		template.putObject(CommonConstants.BUCKET_NAME, file.getOriginalFilename(), file.getInputStream());
		return R.ok("upload success " + file.getOriginalFilename() + " " + file.getName());
	}

	@GetMapping("/test")
	public R<String> test() {
		return R.ok("test success");
	}

	@ResponseExcel(name = "模板测试excel", sheet = "sheetName")
	@GetMapping("/e1")
	public List<SysUser> e1() {
		List<SysUser> list = userService.list();
		return list;
	}

	private SmsClient smsClient;

	@GetMapping("sendSms")
	public R<Boolean> sendSms(String mobile){
		String code = RandomUtil.randomNumbers(Integer.parseInt(SecurityConstants.CODE_SIZE));
		this.smsClient.sendVerificationCode(code,mobile);
		return R.ok(Boolean.TRUE, code);
	}


}
