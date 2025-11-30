

package com.wyzy.hospital.tcm.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wyzy.hospital.common.data.datascope.HospitalBaseMapper;
import com.wyzy.hospital.tcm.dto.TcmMeridiansDTO;
import com.wyzy.hospital.tcm.entity.TcmMeridians;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 经脉表
 *
 * @author hospital code generator
 * @date 2021-04-25 15:30:28
 */
@Mapper
public interface TcmMeridiansMapper extends HospitalBaseMapper<TcmMeridians> {

	/**
	 * 通过经络contextId查询经脉表信息
	 * @param --contextId id
	 * @return R
	 */
	TcmMeridiansDTO selectBycontextId(@Param("contextId") Long contextId,@Param("meridiansName") String meridiansName);

	/**
	 * 根据contextId查询所有
	 * @param contextId
	 * @return
	 */
	TcmMeridians selectAllBycontextId(@Param("contextId") Long contextId);

	/**
	 * 分页
	 * @param page
	 * @return
	 */
	List<TcmMeridians> getTcmMeridiansPage(IPage<TcmMeridians> page);

	/**
	 * 根据名字查询
	 * @param meridiansName
	 * @return
	 */
	TcmMeridians selectTcmMeridiansByName(@Param("meridiansName") String meridiansName);

	/**
	 * 通过name查询经脉表DTO
	 * @param name name
	 * @return R
	 */
	TcmMeridiansDTO selectTcmMeridiansDTOByName(@Param("meridiansName") String name);

	/**
	 * 根据ID删除
	 * @param meridiansId
	 * @return
	 */
	@Delete("Delete from tcm_meridians where meridians_id = #{meridiansId}")
	int deleteTcmMeridiansById(@Param("meridiansId") Long meridiansId);

	/**
	 * 插入数据及ID
	 * */
	int insertTcmMeridians(@Param("tcmMeridians") TcmMeridians tcmMeridians);

	/**
	 * 上线下线
	 * @param meridiansId
	 * @param isOnline
	 * @return
	 */
	int updateTcmMeridiansById(@Param("meridiansId") Long meridiansId,@Param("isOnline") Integer isOnline);

	/**
	 * 根据ID查询经脉信息
	 * @param meridiansId
	 * @return
	 */
	TcmMeridiansDTO selectTcmMeridiansById(@Param("meridiansId") Long meridiansId);

	/**
	 * 修改经脉表
	 * @param tcmMeridians 经脉表
	 * @return R
	 */
	boolean updatePojoById(@Param("tcmMeridians") TcmMeridians tcmMeridians);
}
