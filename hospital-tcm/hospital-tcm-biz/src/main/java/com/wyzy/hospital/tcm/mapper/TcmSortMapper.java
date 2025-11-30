

package com.wyzy.hospital.tcm.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wyzy.hospital.common.data.datascope.HospitalBaseMapper;
import com.wyzy.hospital.tcm.dto.TcmSortDTO;
import com.wyzy.hospital.tcm.entity.TcmSort;
import com.wyzy.hospital.tcm.vo.TcmSortListVO;
import com.wyzy.hospital.tcm.vo.TcmSortVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 中医模块分类表
 *
 * @author hospital code generator
 * @date 2021-04-22 09:09:23
 */
@Mapper
public interface TcmSortMapper extends HospitalBaseMapper<TcmSort> {

	/**
	 * 根据type查询一级分类列表
	 * @param type --类型:1 经络分类, 2 中药分类, 3 内科分类表，4 医书经典
	 * @return
	 */
	@Select("select sort_id,superior_id,sort_name,type," +
			"create_time,update_time,del_flag,introduce " +
			"from tcm_sort where superior_id = 0 AND del_flag = 0 " +
			"and type = #{type} ORDER BY sort_id DESC")
	List<TcmSortDTO> selectTcmSortOneList(@Param("type") Integer type);

	/**
	 * 根据一级分类ID查询二级列表
	 * @param superiorId
	 * @return
	 */
	@Select("select sort_id,superior_id,sort_name,type," +
			"create_time,update_time,del_flag,introduce " +
			"from tcm_sort where del_flag = 0 " +
			"and superior_id = #{superiorId} ORDER BY sort_id DESC")
	List<TcmSortDTO> selectTcmSortTwoList(@Param("superiorId") Long superiorId);

	/**
	 * 根据一级分类ID查询二级分类列表
	 * @param sortId
	 * @return
	 */
	@Select("select sort_id,superior_id,sort_name,type," +
			"del_flag,create_time,update_time,introduce " +
			"from tcm_sort where del_flag = 0 AND superior_id = #{superiorId} ORDER BY sort_id DESC")
	List<TcmSort> selectTcmSortListBySuperiorId(@Param("superiorId") Long sortId);

	/**
	 * 根据分类ID集合，查询内科学表数据表列表
	 * @param list
	 */
	List<TcmSortVO> selectInternalTcmSortVOBySortIdList(@Param("list") List list);

	/**
	 * 根据分类ID集合，查询中药表数据表列表
	 * @param list
	 */
	List<TcmSortVO> selectCmTcmSortVOBySortIdList(@Param("list") List list);

	/**
	 * 根据姓名查询TcmSort
	 * @param sortName
	 * @return
	 */
	TcmSort selectTcmSortByName(@Param("sortName") String sortName);

	/**
	 * 修改中医模块分类表
	 * @param tcmSort 中医模块分类表
	 * @return R
	 */
	boolean updatePojoById(@Param("tcmSort") TcmSort tcmSort);

	/**
	 * 查询所有分页
	 * @param
	 * @return
	 */
	List<TcmSort> selectTcmSortAll();
}
