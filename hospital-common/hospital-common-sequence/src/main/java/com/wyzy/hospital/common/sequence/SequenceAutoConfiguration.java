

package com.wyzy.hospital.common.sequence;

import com.wyzy.hospital.common.sequence.builder.SnowflakeSeqBuilder;
import com.wyzy.hospital.common.sequence.properties.SequenceSnowflakeProperties;
import com.wyzy.hospital.common.sequence.sequence.Sequence;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author wyzy
 * @date 2019-05-26
 */
@Configuration
@ComponentScan("com.wyzy.hospital.common.sequence")
@ConditionalOnMissingBean(Sequence.class)
public class SequenceAutoConfiguration {

	/**
	 * snowflak 算法作为发号器实现
	 * @param properties
	 * @return
	 */
	@Bean
	@ConditionalOnBean(SequenceSnowflakeProperties.class)
	public Sequence snowflakeSequence(SequenceSnowflakeProperties properties) {
		return SnowflakeSeqBuilder.create().datacenterId(properties.getDatacenterId())
				.workerId(properties.getWorkerId()).build();
	}

}