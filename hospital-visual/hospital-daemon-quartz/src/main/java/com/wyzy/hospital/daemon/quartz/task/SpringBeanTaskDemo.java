

package com.wyzy.hospital.daemon.quartz.task;

import com.wyzy.hospital.daemon.quartz.constants.HospitalQuartzEnum;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author 郑健楠
 */
@Slf4j
@Component("demo")
public class SpringBeanTaskDemo {

	/**
	 * 测试Spring Bean的演示方法
	 */
	@SneakyThrows
	public String demoMethod(String para) {
		log.info("测试于:{}，输入参数{}", LocalDateTime.now(), para);
		// todo 根据id 给指定
		return HospitalQuartzEnum.JOB_LOG_STATUS_SUCCESS.getType();
	}

}
