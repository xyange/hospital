

package com.wyzy.hospital.admin.mapper;

import com.wyzy.hospital.admin.api.entity.SysDeptRelation;
import com.wyzy.hospital.common.data.datascope.HospitalBaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author wyzy
 * @since 2018-02-12
 */
@Mapper
public interface SysDeptRelationMapper extends HospitalBaseMapper<SysDeptRelation> {

	/**
	 * 删除部门关系表数据
	 * @param id 部门ID
	 */
	void deleteDeptRelationsById(Integer id);

	/**
	 * 更改部分关系表数据
	 * @param deptRelation
	 */
	void updateDeptRelations(SysDeptRelation deptRelation);

}
