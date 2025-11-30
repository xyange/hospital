

package com.wyzy.hospital.admin.mapper;

import com.wyzy.hospital.admin.api.entity.SysTenant;
import com.wyzy.hospital.common.data.datascope.HospitalBaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 租户
 *
 * @author wyzy
 * @date 2019-05-15 15:55:41
 */
@Mapper
public interface SysTenantMapper extends HospitalBaseMapper<SysTenant> {

}
