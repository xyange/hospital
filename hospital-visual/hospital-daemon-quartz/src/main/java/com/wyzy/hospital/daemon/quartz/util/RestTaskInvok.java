

package com.wyzy.hospital.daemon.quartz.util;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;
import com.wyzy.hospital.common.core.constant.CommonConstants;
import com.wyzy.hospital.daemon.quartz.entity.SysJob;
import com.wyzy.hospital.daemon.quartz.exception.TaskException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 定时任务rest反射实现
 *
 * @author 郑健楠
 */
@Slf4j
@AllArgsConstructor
@Component("restTaskInvok")
public class RestTaskInvok implements ITaskInvok {

	@Override
	public void invokMethod(SysJob sysJob) throws TaskException {
		try {
			HttpRequest request = HttpUtil.createGet(sysJob.getExecutePath());
			if (sysJob.getTenantId() != null) {
				request.header(CommonConstants.TENANT_ID, sysJob.getTenantId().toString());
			}
			request.execute();
		}
		catch (Exception e) {
			e.printStackTrace();
			log.error("定时任务restTaskInvok异常,执行任务：{}", sysJob.getExecutePath());
			throw new TaskException("定时任务restTaskInvok业务执行失败,任务：" + sysJob.getExecutePath());
		}
	}

}
