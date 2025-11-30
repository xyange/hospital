

package com.wyzy.hospital.daemon.quartz.mapper;

import com.wyzy.hospital.common.data.datascope.HospitalBaseMapper;
import com.wyzy.hospital.daemon.quartz.entity.SysJobLog;
import org.apache.ibatis.annotations.Mapper;

/**
 * 定时任务执行日志表
 *
 * @author frwcloud
 * @date 2019-01-27 13:40:20
 */
@Mapper
public interface SysJobLogMapper extends HospitalBaseMapper<SysJobLog> {

}
