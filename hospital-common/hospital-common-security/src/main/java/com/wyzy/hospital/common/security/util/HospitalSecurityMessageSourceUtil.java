package com.wyzy.hospital.common.security.util;

import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import java.util.Locale;

/**
 * @author wyzy
 * @date 2020/9/4
 * <p>
 * @see org.springframework.security.core.SpringSecurityMessageSource 框架自身异常处理，
 * 建议所有异常都使用此工具类型 避免无法复写 SpringSecurityMessageSource
 */
public class HospitalSecurityMessageSourceUtil extends ReloadableResourceBundleMessageSource {

	// ~ Constructors
	// ===================================================================================================

	public HospitalSecurityMessageSourceUtil() {
		setBasename("classpath:messages/messages");
		setDefaultLocale(Locale.CHINA);
	}

	// ~ Methods
	// ========================================================================================================

	public static MessageSourceAccessor getAccessor() {
		return new MessageSourceAccessor(new HospitalSecurityMessageSourceUtil());
	}

}