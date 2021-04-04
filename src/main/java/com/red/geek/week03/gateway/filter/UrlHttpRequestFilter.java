package com.red.geek.week03.gateway.filter;

import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;

import static io.netty.handler.codec.http.HttpResponseStatus.FORBIDDEN;
import static io.netty.handler.codec.http.HttpVersion.HTTP_1_1;

/**
 * UrlHttpRequestFilter URL过滤器
 *
 * @author red
 * @class_name UrlHttpRequestFilter
 * @date 2021-04-04
 */
public class UrlHttpRequestFilter implements HttpRequestFilter{

    private static final String[] INVALID_URLS = {"/admin"};

    @Override
    public void filter(FullHttpRequest fullRequest, ChannelHandlerContext ctx) {
        for(String url : INVALID_URLS){
            if(fullRequest.uri().contains(url)){
                FullHttpResponse response = new DefaultFullHttpResponse(HTTP_1_1, FORBIDDEN);
                ctx.write(response).addListener(ChannelFutureListener.CLOSE);
                ctx.flush();
                ctx.close();
            }
        }
    }
}
