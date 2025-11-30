

package com.wyzy.hospital.tcm.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wyzy.hospital.common.data.datascope.HospitalBaseMapper;
import com.wyzy.hospital.tcm.dto.TcmInternalDTO;
import com.wyzy.hospital.tcm.entity.TcmInternal;
import com.wyzy.hospital.tcm.vo.TcmSortListVO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 内科学表
 *
 * @author hospital code generator
 * @date 2021-04-24 08:44:38
 */
@Mapper
public interface TcmInternalMapper extends HospitalBaseMapper<TcmInternal> {

	/**
	 * 通过内科学二级分类IDinternalsuperId查询内科学表
	 * @param --internalsuperId id
	 * @return R
	 */
	List<TcmInternalDTO> selectAllByInternalsuperId(@Param("internalsuperId") Long internalsuperId);

	/**
	 * 通过Id查询内科学表
	 * @param --Id id
	 * @return R
	 */
	TcmInternalDTO getById(@Param("id") Long id);

	/**
	 * 分页查询
	 * @param --page 分页对象
	 * @param --tcmInternal 内科学表
	 * @return
	 */
	List<TcmInternalDTO> getTcmInternalPage(IPage<TcmInternalDTO> page);


	/**
	 * 根据名称查询
	 * @param diseaseName
	 * @return
	 */
	TcmInternal selectTcmInternalByName(@Param("diseaseName") String diseaseName);

	/**
	 * 通过name查询内科学表
	 * @param name name
	 * @return R
	 */
	TcmInternalDTO selectTcmInternalDTOByName(@Param("diseaseName") String name);

	/**
	 * 根据ID删除
	 * @param id
	 * @return
	 */
	@Delete("delete from tcm_internal where id = #{id}")
	int deleteTcmInternalById(@Param("id") Long id);

	/**
	 * 插入表，包含ID
	 * @param tcmInternal
	 * @return
	 */
	int insertTcmInternal(@Param("tcmInternal") TcmInternal tcmInternal);

	/**
	 * 上下线
	 * @param id
	 * @param isOnline
	 * @return
	 */
	int updateTcmInternalById(@Param("id") Long id,@Param("isOnline") Integer isOnline);

	/**
	 * 修改
	 * @param tcmInternal
	 * @return
	 */
	boolean updatePojoById(@Param("tcmInternal") TcmInternal tcmInternal);

	/**
	 * 查询加一级ID
	 * @return
	 */
	List<TcmInternalDTO> selectInternalOneTwoId();
}
