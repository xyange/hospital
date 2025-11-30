

package com.wyzy.hospital.daemon.quartz.util;

import com.wyzy.hospital.daemon.quartz.entity.SysJob;
import com.wyzy.hospital.daemon.quartz.exception.TaskException;

/**
 * 定时任务反射实现接口类
 *
 * @author 郑健楠
 */
public interface ITaskInvok {

	/**
	 * 执行反射方法
	 * @param sysJob 配置类
	 * @throws TaskException
	 */
	void invokMethod(SysJob sysJob) throws TaskException;

}
