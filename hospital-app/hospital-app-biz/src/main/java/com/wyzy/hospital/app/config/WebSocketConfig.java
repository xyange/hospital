package com.wyzy.hospital.app.config;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.wyzy.hospital.common.core.constant.CommonConstants;
import com.wyzy.hospital.common.data.tenant.TenantContextHolder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.messaging.support.MessageHeaderAccessor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * @Author aqie
 * Date on 2021/5/22  16:51
 * @Function:
 */
@Slf4j
@Configuration
@RequiredArgsConstructor
@EnableWebSocketMessageBroker
public class WebSocketConfig  implements WebSocketMessageBrokerConfigurer {

	private final ResourceServerTokenServices tokenService;

	/**
	 * 注入一个ServerEndpointExporter,该Bean会自动注册使用@ServerEndpoint注解申明的websocket endpoint
	 */
	/*@Bean
	public ServerEndpointExporter serverEndpointExporter() {
		return new ServerEndpointExporter();
	}*/

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/ws").setAllowedOriginPatterns("*");
	}

	/*@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		//表示客户端订阅地址的前缀信息，也就是客户端接收服务端消息的地址的前缀信息
		registry.enableSimpleBroker("/topic");
		//指服务端接收地址的前缀，意思就是说客户端给服务端发消息的地址的前缀
		registry.setApplicationDestinationPrefixes("/app");
	}*/


	@Override
	public void configureClientInboundChannel(ChannelRegistration registration) {
		registration.interceptors(new ChannelInterceptor() {
			@Override
			public Message<?> preSend(Message<?> message, MessageChannel channel) {
				StompHeaderAccessor accessor = MessageHeaderAccessor.getAccessor(message, StompHeaderAccessor.class);

				// 判断是否首次连接请求
				if (StompCommand.CONNECT.equals(accessor.getCommand())) {

					// 处理租户
					String tenant = accessor.getFirstNativeHeader(CommonConstants.TENANT_ID);
					if (StrUtil.isNotBlank(tenant)) {
						TenantContextHolder.setTenantId(Integer.parseInt(tenant));

					}
					else {
						TenantContextHolder.setTenantId(CommonConstants.TENANT_ID_1);
					}

					// 验证令牌信息
					String tokens = accessor.getFirstNativeHeader("Authorization");
					log.info("webSocket token is {}", tokens);
					if (StrUtil.isBlank(tokens)) {
						return null;
					}

					OAuth2Authentication auth2Authentication = tokenService.loadAuthentication(tokens.split(" ")[1]);
					if (ObjectUtil.isNotNull(auth2Authentication)) {
						SecurityContextHolder.getContext().setAuthentication(auth2Authentication);
						accessor.setUser(auth2Authentication::getName);
						return message;
					}
					else {
						return null;
					}
				}
				// 不是首次连接，已经成功登陆
				return message;
			}
		});
	}

}
