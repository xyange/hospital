package com.wyzy.hospital.common.sequence.properties;

/**
 * @author wyzy
 * @date 2019-05-26
 */

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author wyzy
 * @date 2019/5/26
 * <p>
 * 发号器Redis配置属性
 */
@Data
@Component
@ConfigurationProperties(prefix = "hospital.xsequence.redis")
public class SequenceRedisProperties extends BaseSequenceProperties {

}