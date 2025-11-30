
package com.wyzy.hospital.mp.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.mp.entity.WxMsg;
import com.wyzy.hospital.mp.service.WxMsgService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * 微信粉丝消息管理
 *
 * @author wyzy
 * @date 2019-03-27 20:45:27
 */
@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/wxfansmsg")
public class WxFansMsgController {

	private final WxMsgService wxMsgService;

	/**
	 * 分页查询
	 * @param page 分页对象
	 * @param msg 查询条件
	 */
	@GetMapping("/page")
	public R getWxMsgPage(Page page, WxMsg msg) {
		return R.ok(wxMsgService.page(page, Wrappers.query(msg)));
	}

	/**
	 * 通过id查询微信消息
	 * @param id id
	 * @return R
	 */
	@GetMapping("/{id}")
	public R getById(@PathVariable("id") Integer id) {
		return R.ok(wxMsgService.getById(id));
	}

	/**
	 * 新增微信消息
	 * @param wxMsg 微信消息
	 * @return R
	 */
	@PostMapping
	@PreAuthorize("@pms.hasPermission('mp_wxmsg_add')")
	public R save(@RequestBody WxMsg wxMsg) {
		return wxMsgService.saveAndPushMsg(wxMsg);
	}

	/**
	 * 修改微信消息
	 * @param wxMsg 微信消息
	 * @return R
	 */
	@PutMapping
	@PreAuthorize("@pms.hasPermission('mp_wxmsg_edit')")
	public R updateById(@RequestBody WxMsg wxMsg) {
		return R.ok(wxMsgService.updateById(wxMsg));
	}

	/**
	 * 通过id删除微信消息
	 * @param id id
	 * @return R
	 */
	@DeleteMapping("/{id}")
	@PreAuthorize("@pms.hasPermission('mp_wxmsg_del')")
	public R removeById(@PathVariable String id) {
		return R.ok(wxMsgService.removeById(id));
	}

}
