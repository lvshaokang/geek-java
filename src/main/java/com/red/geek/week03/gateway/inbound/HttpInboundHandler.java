package com.red.geek.week03.gateway.inbound;

import com.red.geek.week03.gateway.filter.HeaderHttpRequestFilter;
import com.red.geek.week03.gateway.filter.HttpRequestFilter;
import com.red.geek.week03.gateway.filter.UrlHttpRequestFilter;
import com.red.geek.week03.gateway.outbound.okhttp.OkhttpOutboundHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.util.ReferenceCountUtil;
import lombok.extern.slf4j.Slf4j;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import java.util.List;

//@Slf4j
public class HttpInboundHandler extends ChannelInboundHandlerAdapter {

//    private static Logger logger = LoggerFactory.getLogger(HttpInboundHandler.class);
    private final List<String> proxyServer;
    private OkhttpOutboundHandler handler;
    private HttpRequestFilter filter = new HeaderHttpRequestFilter();
    private HttpRequestFilter urlRequestFilter = new UrlHttpRequestFilter();
    
    public HttpInboundHandler(List<String> proxyServer) {
        this.proxyServer = proxyServer;
//        this.handler = new HttpOutboundHandler(this.proxyServer);
        this.handler = new OkhttpOutboundHandler(this.proxyServer);
    }
    
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        ctx.flush();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        try {
            FullHttpRequest fullRequest = (FullHttpRequest) msg;
            String uri = fullRequest.uri();
//            log.info("接收到的请求url为{}", uri);
            urlRequestFilter.filter(fullRequest, ctx);
            handler.handle(fullRequest, ctx, filter);
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            ReferenceCountUtil.release(msg);
        }
    }
}
