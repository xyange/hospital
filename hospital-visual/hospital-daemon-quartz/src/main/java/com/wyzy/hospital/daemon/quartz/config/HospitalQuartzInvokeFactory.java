

package com.wyzy.hospital.daemon.quartz.config;

import com.wyzy.hospital.daemon.quartz.entity.SysJob;
import com.wyzy.hospital.daemon.quartz.event.SysJobEvent;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.quartz.Trigger;
import org.springframework.context.ApplicationEventPublisher;

/**
 * @author 郑健楠
 */
@Aspect
@Slf4j
@AllArgsConstructor
public class HospitalQuartzInvokeFactory {

	private final ApplicationEventPublisher publisher;

	@SneakyThrows
	void init(SysJob sysJob, Trigger trigger) {
		publisher.publishEvent(new SysJobEvent(sysJob, trigger));
	}

}
