

package com.wyzy.hospital.common.gateway.annotation;

import com.wyzy.hospital.common.gateway.configuration.DynamicRouteAutoConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author wyzy
 * @date 2018/11/5
 * <p>
 * 开启pigx 动态路由
 */
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import(DynamicRouteAutoConfiguration.class)
public @interface EnableHospitalDynamicRoute {

}
