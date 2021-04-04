package com.red.geek.week03.gateway.outbound.netty4;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.util.CharsetUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NettyHttpClientOutboundHandler  extends ChannelInboundHandlerAdapter {
    
    @Override
    public void channelActive(ChannelHandlerContext ctx)
            throws Exception {
        log.info("channelActive");
    }
    
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg)
            throws Exception {
        try {
            FullHttpResponse response = (FullHttpResponse) msg;

            ByteBuf content = response.content();
            HttpHeaders headers = response.headers();

            log.info("content:" + System.getProperty("line.separator") + content.toString(CharsetUtil.UTF_8));
            log.info("headers:" + System.getProperty("line.separator") + headers.toString());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}