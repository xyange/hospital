
package com.wyzy.hospital.mp.service;

import cn.hutool.json.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wyzy.hospital.common.core.util.R;
import com.wyzy.hospital.mp.entity.WxMpMenu;

/**
 * 微信菜单业务
 *
 * @author wyzy
 * @date 2019-03-27 20:45:18
 */
public interface WxMenuService extends IService<WxMpMenu> {

	/**
	 * 新增微信公众号按钮
	 * @param wxMenus json
	 * @param appId 公众号信息
	 * @return
	 */
	Boolean save(JSONObject wxMenus, String appId);

	/**
	 * 发布到微信
	 * @param appId 公众号信息
	 * @return
	 */
	R push(String appId);

	/**
	 * 通过appid 查询菜单信息
	 * @param appId
	 * @return
	 */
	R getByAppId(String appId);

	/**
	 * 通过appid 删除菜单
	 * @param appId
	 * @return
	 */
	R delete(String appId);

}
