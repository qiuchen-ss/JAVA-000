package io.github.kimmking.gateway.filter;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;

public class HttpUrlFilterHandler extends ChannelInboundHandlerAdapter implements HttpRequestFilter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        FullHttpRequest req = (FullHttpRequest) msg;
        System.out.println(req.uri());
        filter(req, ctx);
    }

    @Override
    public void filter(FullHttpRequest req, ChannelHandlerContext ctx) {
        if (req.uri().contains("geekbang") ) {
            System.out.println("接受到有效的请求");
            ctx.fireChannelRead(req);
        } else {
            System.out.println("接受到无效的请求");
            FullHttpResponse response = null;
        }
    }
}
