

package com.wyzy.hospital.app.mapper;

import com.wyzy.hospital.app.api.entity.UserTask;
import com.wyzy.hospital.common.data.datascope.HospitalBaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户用药计划表
 *
 * @author aqie
 * @date 2021-05-28 14:59:31
 */
@Mapper
public interface UserTaskMapper extends HospitalBaseMapper<UserTask> {

}
