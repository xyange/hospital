

package com.wyzy.hospital.admin.mapper;

import com.wyzy.hospital.admin.api.entity.SysRole;
import com.wyzy.hospital.common.data.datascope.HospitalBaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author wyzy
 * @since 2017-10-29
 */
@Mapper
public interface SysRoleMapper extends HospitalBaseMapper<SysRole> {

	/**
	 * 通过用户ID，查询角色信息
	 * @param userId
	 * @return
	 */
	List<SysRole> listRolesByUserId(Long userId);

}
