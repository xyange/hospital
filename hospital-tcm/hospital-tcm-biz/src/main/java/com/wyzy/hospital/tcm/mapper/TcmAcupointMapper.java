

package com.wyzy.hospital.tcm.mapper;

import com.wyzy.hospital.common.data.datascope.HospitalBaseMapper;
import com.wyzy.hospital.tcm.dto.TcmAcupointDTO;
import com.wyzy.hospital.tcm.entity.TcmAcupoint;
import com.wyzy.hospital.tcm.vo.TcmSortListVO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 穴位表
 *
 * @author hospital code generator
 * @date 2021-04-23 16:29:07
 */
@Mapper
public interface TcmAcupointMapper extends HospitalBaseMapper<TcmAcupoint> {

	/**
	 * 根据经络ID查询经脉数据表是否存在值
	 * @param contextId
	 * @return
	 */
	List<TcmAcupointDTO> selectByContextId(@Param("contextId") Long contextId);



	/**
	 * 通过id查询穴位表
	 * @param acupointId id
	 * @return R
	 */
	TcmAcupointDTO getById(@Param("acupointId") Long acupointId);

	/**
	 * APP查询经络腧穴:两级分类及数据表，三层
	 * @param --type 类型:1 经络分类, 2 中药分类, 3 内科分类表，4 医书经典
	 * @return R
	 */
	List<TcmSortListVO> selectAcupointTcmSortListAPP();

	/**
	 * 查询经络腧穴:两级分类及数据表，三层
	 * @param --type 类型:1 经络分类, 2 中药分类, 3 内科分类表，4 医书经典
	 * @return R
	 */
	List<TcmSortListVO> selectAcupointTcmSortList();

	/**
	 * 根据名称查询实体类忽略上下线
	 * @param acupointName
	 * @return
	 */
	@Select("select acupoint_id,acupoint_name,context_id," +
			"acupoint_picture,location,anatomy,Indications," +
			"operation,del_flag,create_time,update_time " +
			"from tcm_acupoint where acupoint_name = #{acupointName}")
	TcmAcupoint getTcmAcupointByName(@Param("acupointName") String acupointName);

	/**
	 * 根据名称查询DTO类忽略上下线
	 * @param acupointName
	 * @return
	 */
	TcmAcupointDTO getTcmAcupointDTOByName(@Param("acupointName") String acupointName);

	/**
	 * 真删除
	 * @param acupointId
	 * @return
	 */
	@Delete("DELETE FROM tcm_acupoint WHERE acupoint_id = #{acupointId}")
	int deleteTcmAcupointById(Long acupointId);

	/**
	 * 包含ID新增
	 * @param tcmAcupoint
	 * @return
	 */
	int insertTcmAcupoint(@Param("tcmAcupoint") TcmAcupoint tcmAcupoint);

	/**
	 * 上下线
	 * @param acupointId
	 * @param isOnline
	 * @return
	 */
	int updateTcmAcupointById(@Param("acupointId") Long acupointId,@Param("isOnline") Integer isOnline);

	/**
	 * 查询所有
	 * @return
	 */
	List<TcmAcupointDTO> selectAll();

	/**
	 * 修改
	 * @param tcmAcupoint
	 * @return
	 */
	boolean updatePojoById(@Param("tcmAcupoint") TcmAcupoint tcmAcupoint);
}
