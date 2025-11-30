

package com.wyzy.hospital.codegen.mapper;

import java.util.List;
import java.util.Map;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wyzy.hospital.codegen.entity.ColumnEntity;
import com.wyzy.hospital.common.data.datascope.HospitalBaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * 代码生成器
 *
 * @author wyzy
 * @date 2018-07-30
 */
public interface GeneratorMapper extends HospitalBaseMapper<ColumnEntity> {

	/**
	 * 分页查询表格
	 * @param page 分页信息
	 * @param tableName 表名称
	 * @return
	 */
	IPage<Map<String, Object>> queryTable(Page page, @Param("tableName") String tableName);

	/**
	 * 查询表信息
	 * @param tableName 表名称
	 * @param dsName 数据源名称
	 * @return
	 */
	@DS("#last")
	Map<String, String> queryTable(@Param("tableName") String tableName, String dsName);

	/**
	 * 分页查询表分页信息
	 * @param page
	 * @param tableName
	 * @param dsName
	 * @return
	 */
	@DS("#last")
	IPage<ColumnEntity> selectTableColumn(Page page, @Param("tableName") String tableName,
			@Param("dsName") String dsName);

	/**
	 * 查询表全部列信息
	 * @param tableName
	 * @param dsName
	 * @return
	 */
	@DS("#last")
	List<ColumnEntity> selectTableColumn(@Param("tableName") String tableName, @Param("dsName") String dsName);

	/**
	 * 查询表全部列信息
	 * @param tableName 表名称
	 * @param dsName 数据源名称
	 * @return
	 */
	@DS("#last")
	List<Map<String, String>> selectMapTableColumn(@Param("tableName") String tableName, String dsName);

}
