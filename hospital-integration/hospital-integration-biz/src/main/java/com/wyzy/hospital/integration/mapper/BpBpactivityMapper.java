

package com.wyzy.hospital.integration.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wyzy.hospital.common.data.datascope.HospitalBaseMapper;
import com.wyzy.hospital.integration.dto.BpBpactivityDTO;
import com.wyzy.hospital.integration.dto.BpIntegralDTO;
import com.wyzy.hospital.integration.entity.BpBpactivity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 积分活动表
 *
 * @author hospital code generator
 * @date 2021-05-08 16:09:33
 */
@Mapper
public interface BpBpactivityMapper extends HospitalBaseMapper<BpBpactivity> {

	/**
	 * 上线积分活动
	 * @param id 积分活动id
	 * @return R
	 */
	@Update("UPDATE bp_bpActivity SET fluctuate = 1 WHERE id = #{id}")
	boolean OnlineById(Long id);

	/**
	 * 下线积分活动
	 * @param id 积分活动id
	 * @return R
	 */
	@Update("UPDATE bp_bpActivity SET fluctuate = 0 WHERE id = #{id}")
	boolean OfflineById(Long id);

	/**
	 * 根据ID查询 上线状态 fluctuate
	 * @param id 积分活动id
	 * @return R
	 */
	@Select("select fluctuate from bp_bpActivity where id = #{id}")
	Integer selectBpactivityById(Long id);

	/**
	 * 分页查询
	 * @return
	 */
	@Select("select id,activityName,product_status,returnRates,returnMax,returnNumber,fluctuate,source,type from bp_bpActivity where type = 0 ORDER BY id DESC")
	List<BpBpactivityDTO> selectBpBpactivityPage(IPage<BpBpactivityDTO> page);
}
