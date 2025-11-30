package com.wyzy.hospital.admin.config;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @Author aqie
 * Date on 2021/5/22  8:36
 * @Function:
 */
// @Configuration
public class Webconfig extends WebMvcConfigurationSupport {
    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
