

package com.wyzy.hospital.common.core.constant;

/**
 * @author wyzy
 * @date 2017/10/29
 */
public interface CommonConstants {

	/**
	 * header 中租户ID
	 */
	String TENANT_ID = "TENANT-ID";

	/**
	 * header 中版本信息
	 */
	String VERSION = "VERSION";

	/**
	 * 会员租户ID
	 */
	Integer TENANT_ID_1 = 1;

	String TENANT_ID_1_DEFAULT_PASSWORD = "123456";

	/**
	 * 后台管理租户id
	 */
	Integer TENANT_ID_ADMIN = 2;

	/**
	 * 医生租户id
	 */
	Integer TENANT_ID_DOCTOR = 3;

	/**
	 * 删除
	 */
	String STATUS_DEL = "1";

	/**
	 * 正常
	 */
	String STATUS_NORMAL = "0";

	/**
	 * 锁定
	 */
	String STATUS_LOCK = "9";

	/**
	 * 菜单树根节点
	 */
	Integer MENU_TREE_ROOT_ID = -1;

	/**
	 * 编码
	 */
	String UTF8 = "UTF-8";

	/**
	 * 前端工程名
	 */
	String FRONT_END_PROJECT = "hospital-ui";

	/**
	 * 后端工程名
	 */
	String BACK_END_PROJECT = "hospital";

	/**
	 * 公共参数
	 */
	String PIG_PUBLIC_PARAM_KEY = "PIG_PUBLIC_PARAM_KEY";

	/**
	 * 成功标记
	 */
	Integer SUCCESS = 0;

	/**
	 * 失败标记
	 */
	Integer FAIL = 1;

	/**
	 * 默认存储bucket
	 */
	String BUCKET_NAME = "hospital";

	/**
	 * 滑块验证码
	 */
	String IMAGE_CODE_TYPE = "blockPuzzle";

	/**
	 * 验证码开关
	 */
	String CAPTCHA_FLAG = "captcha_flag";

	/**
	 * 密码传输是否加密
	 */
	String ENC_FLAG = "enc_flag";

	/**
	 * eg 是否 收藏
	 */
	Integer TRUE = 1;

	Integer FALSE = 0;

	/**
	 * app患者端权限标识符
	 */
	String PATIENT_APP = "'app'";

	/**
	 * 网络请求 状态码 成功
	 */
	int SUCCESS_CODE = 200;

}
