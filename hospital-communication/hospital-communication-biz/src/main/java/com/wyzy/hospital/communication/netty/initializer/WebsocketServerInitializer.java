package com.wyzy.hospital.communication.netty.initializer;


import com.wyzy.hospital.communication.netty.handler.ChatHandler;
import com.wyzy.hospital.communication.netty.handler.HeartBeatHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;
import io.netty.handler.timeout.IdleStateHandler;

/**
 * @author aqie
 */
public class WebsocketServerInitializer  extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel channel) throws Exception {
        ChannelPipeline pipeline = channel.pipeline();
        // ======================= 支持http协议 ====================
        // 编解码
        pipeline.addLast(new HttpServerCodec());
        // 对大数据流写入支持
        pipeline.addLast(new ChunkedWriteHandler());
        // http message进行聚合，聚合成fullHttpRequest或 fullHttpResponse(netty编程几乎都会用到此handler)
        pipeline.addLast(new HttpObjectAggregator(1024 * 64));  // 消息长度

        // ====================== 增加心跳支持 start    ======================
        // 针对客户端，如果在1分钟时没有向服务端发送读写心跳(ALL)，则主动断开
        // 如果是读空闲或者写空闲，不处理
        pipeline.addLast(new IdleStateHandler(800, 1000, 1200));
        // 自定义的空闲状态检测
        pipeline.addLast(new HeartBeatHandler());
        // ====================== 增加心跳支持 end    ======================

        // =================== http Websocket====================

        /**
         *  websocket处理协议,及制定客户端访问路由
         *  会处理握手handshake(close ping pong ) ping + pong = 心跳
         *  对websocket 都是以frames传输,不同数据类型对应不同 frame
         */
        pipeline.addLast(new WebSocketServerProtocolHandler("/ws"));

        // 自定义处理类,
        pipeline.addLast(new ChatHandler());
    }
}
