

package com.wyzy.hospital.daemon.elastic.job;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.context.XxlJobHelper;
import com.xxl.job.core.handler.annotation.XxlJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import static com.xxl.job.core.biz.model.ReturnT.SUCCESS;

/**
 * @author wyzy
 * @date 2019-09-18
 */
@Slf4j
@Component
public class DemoJob {

	@XxlJob("demoJobHandler")
	public ReturnT<String> demoJobHandler(String s) {
		XxlJobHelper.log("This is a demo job." + XxlJobHelper.getShardIndex());
		return SUCCESS;
	}

}