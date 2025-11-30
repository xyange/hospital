package com.wyzy.hospital.tcm.kit;

/**
 * 方剂父级表
 *
 * @author hospital code generator
 * @date 2021-04-23 10:28:09
 */
public interface TcmRecipesuperKitService{

	/**
	 * 通过方剂父级id删除方剂父级表
	 * @param id id
	 * @return R
	 */
	boolean removeTcmRecipesuperById(Long id);
}
