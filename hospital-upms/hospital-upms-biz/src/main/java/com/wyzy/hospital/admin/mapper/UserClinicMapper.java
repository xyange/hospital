

package com.wyzy.hospital.admin.mapper;

import com.wyzy.hospital.common.data.datascope.HospitalBaseMapper;
import com.wyzy.hospital.admin.api.entity.UserClinic;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户诊所关系表
 *
 * @author songM
 * @date 2021-05-17 16:26:18
 */
@Mapper
public interface UserClinicMapper extends HospitalBaseMapper<UserClinic> {

}
