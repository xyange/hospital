

package com.wyzy.hospital.common.job.annotation;

import com.wyzy.hospital.common.job.XxlJobAutoConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author wyzy
 * @date 2019-09-18
 * <p>
 * 开启支持XXL
 */
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import({ XxlJobAutoConfiguration.class })
public @interface EnableHospitalXxlJob {

}
