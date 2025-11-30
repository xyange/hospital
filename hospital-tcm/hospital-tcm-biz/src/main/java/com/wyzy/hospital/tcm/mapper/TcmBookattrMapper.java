

package com.wyzy.hospital.tcm.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wyzy.hospital.common.data.datascope.HospitalBaseMapper;
import com.wyzy.hospital.tcm.dto.TcmBookattrDTO;
import com.wyzy.hospital.tcm.entity.TcmBookattr;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 医书属性表
 *
 * @author hospital code generator
 * @date 2021-05-20 09:51:02
 */
@Mapper
public interface TcmBookattrMapper extends HospitalBaseMapper<TcmBookattr> {
	/**
	 * 根据名字查询
	 */
	TcmBookattr selectByName(@Param("bookattrName") String bookattrName);

	/**
	 * 通过name查询医书属性表DTO
	 * @param name name
	 * @return R
	 */
	TcmBookattrDTO selectPojoDTOByName(@Param("name") String name);

	/**
	 * 查询所有分页
	 */
	List<TcmBookattrDTO> selectAll(@Param("type") Integer type, IPage<TcmBookattrDTO> page);

	/**
	 * 查看一级ID列表
	 */
	List<Integer> selectType();

	/**
	 * 查询所有
	 * @return
	 */
	List<TcmBookattr> selectTcmBookattrList();

	/**
	 * 根据Type查询
	 * @param type
	 * @return
	 */
	List<TcmBookattrDTO> selectTcmBookattrByType(Integer type);

	/**
	 * 删除
	 * @param id
	 * @return
	 */
	int deleteTcmBookattrBy(@Param("id") Long id);

	/**
	 * 添加数据包含ID
	 * @param tcmBookattr
	 * @return
	 */
	int insertTcmBookattr(@Param("tcmBookattr") TcmBookattr tcmBookattr);

	/**
	 * 修改
	 * @param tcmBookattr 医书属性表
	 * @return
	 */
	boolean updatePojoById(@Param("tcmBookattr") TcmBookattr tcmBookattr);
}
