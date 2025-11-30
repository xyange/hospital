

package com.wyzy.hospital.daemon.quartz.config;

import com.wyzy.hospital.daemon.quartz.constants.HospitalQuartzEnum;
import com.wyzy.hospital.daemon.quartz.entity.SysJob;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author 郑健楠
 *
 * <p>
 * 动态任务工厂
 */
@Slf4j
@DisallowConcurrentExecution
public class HospitalQuartzFactory implements Job {

	@Autowired
	private HospitalQuartzInvokeFactory pigxQuartzInvokeFactory;

	@Override
	@SneakyThrows
	public void execute(JobExecutionContext jobExecutionContext) {
		SysJob sysJob = (SysJob) jobExecutionContext.getMergedJobDataMap()
				.get(HospitalQuartzEnum.SCHEDULE_JOB_KEY.getType());
		pigxQuartzInvokeFactory.init(sysJob, jobExecutionContext.getTrigger());
	}

}
