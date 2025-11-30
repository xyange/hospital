package com.wyzy.hospital.communication.netty;

import com.wyzy.hospital.communication.netty.initializer.WebsocketServerInitializer;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Author aqie
 * Date on 2021/4/29  17:43
 * @Function:
 */
@Component
@Slf4j
public class WebsocketServer {
	// 内部类
	private static class SingletonWSServer{
		static final WebsocketServer instance = new WebsocketServer();
	}

	public static WebsocketServer getInstance(){
		return SingletonWSServer.instance;
	}

	private EventLoopGroup mainGroup;
	private EventLoopGroup subGroup;

	private ServerBootstrap server;
	private ChannelFuture future;

	public WebsocketServer(){
		mainGroup = new NioEventLoopGroup();
		subGroup = new  NioEventLoopGroup();
		server = new ServerBootstrap();
		server.group(mainGroup, subGroup)
				.channel(NioServerSocketChannel.class)
				.childHandler(new WebsocketServerInitializer());

	}

	public void start() {
		// 不需要同步
		this.future = server.bind(8888);
		log.error("netty webSocket server 启动完毕... 监听8888端口");
	}
}
