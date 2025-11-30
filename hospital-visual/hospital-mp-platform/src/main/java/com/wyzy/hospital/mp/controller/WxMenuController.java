
package com.wyzy.hospital.mp.controller;

import cn.hutool.json.JSONObject;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.common.log.annotation.SysLog;
import com.wyzy.hospital.mp.service.WxMenuService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * 微信菜单管理
 *
 * @author wyzy
 * @date 2019-03-27 20:45:18
 */
@RestController
@AllArgsConstructor
@RequestMapping("/wxmenu")
public class WxMenuController {

	private final WxMenuService wxMenuService;

	/**
	 * 通过appid查询微信菜单
	 * @param appId 公众号
	 * @return R
	 */
	@GetMapping("/{appId}")
	public R getById(@PathVariable("appId") String appId) {
		return wxMenuService.getByAppId(appId);
	}

	/**
	 * 新增微信菜单
	 * @param wxMenu 微信菜单列表
	 * @return R
	 */
	@SysLog("新增微信菜单")
	@PostMapping("/{appId}")
	@PreAuthorize("@pms.hasPermission('mp_wxmenu_add')")
	public R save(@RequestBody JSONObject wxMenu, @PathVariable String appId) {
		return R.ok(wxMenuService.save(wxMenu, appId));
	}

	/**
	 * 发布微信菜单
	 * @param appId 公众号
	 * @return R
	 */
	@SysLog("发布微信菜单")
	@PutMapping("/{appId}")
	@PreAuthorize("@pms.hasPermission('mp_wxmenu_push')")
	public R updateById(@PathVariable String appId) {
		return wxMenuService.push(appId);
	}

	@DeleteMapping("/{appId}")
	@PreAuthorize("@pms.hasPermission('mp_wxmenu_del')")
	public R delete(@PathVariable("appId") String appId) {
		return wxMenuService.delete(appId);
	}

}
