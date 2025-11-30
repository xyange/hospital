

package com.wyzy.hospital.tcm.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wyzy.hospital.common.data.datascope.HospitalBaseMapper;
import com.wyzy.hospital.tcm.dto.TcmCmDTO;
import com.wyzy.hospital.tcm.entity.TcmCm;
import com.wyzy.hospital.tcm.vo.TcmSortListVO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 中药表
 *
 * @author hospital code generator
 * @date 2021-04-24 08:44:46
 */
@Mapper
public interface TcmCmMapper extends HospitalBaseMapper<TcmCm> {
	/**
	 * 根据中药二级分类ID查询 中药表信息
	 * @param secondlevelId
	 * @return
	 */
	List<TcmCmDTO> getAllBySecondlevelId(@Param("secondlevelId") Long secondlevelId);

	/**
	 * 通过Id查询中药表
	 * @param --onelevelId id
	 * @return R
	 */
	TcmCmDTO getById(@Param("id") Long id);

	/**
	 * 分页查询
	 * @param --page 分页对象
	 * @param --tcmCm 中药表
	 * @return
	 */
	List<TcmCmDTO> selectAll(IPage<TcmCmDTO> page);

	/**
	 * 根据中药名字查询tcmCm
	 * @param chinamedicineName
	 * @return
	 */
	TcmCm selectTcmCmByName(@Param("chinamedicineName") String chinamedicineName);

	/**
	 * 通过name查询中药DTO
	 * @param name id
	 * @return R
	 */
	TcmCmDTO selectTcmCmDTOByName(@Param("chinamedicineName") String name);

	/**
	 * 上下线
	 * @param id
	 * @param isOnline
	 * @return
	 */
	int updateTcmCmById(@Param("id") Long id,@Param("isOnline") Integer isOnline);

	/**
	 * 修改中药表
	 * @param tcmCm 中药表
	 * @return R
	 */
	boolean updatePojoById(@Param("tcmCm") TcmCm tcmCm);

	/**
	 * 查询所有
	 * @return
	 */
	List<TcmCmDTO> selectCmOneTwoId();

}
