package com.heima.gatewa.fliter;

import com.alibaba.nacos.common.utils.StringUtils;
import com.heima.utils.common.AppJwtUtil;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
@Slf4j
@Component
public class Authorizefliter implements Ordered , GlobalFilter {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();
        log.info("ip: {}",request.getRemoteAddress());
        if (request.getURI().getPath().contains("/login")) {

            return chain.filter(exchange);
        }
        try {
            String token = request.getHeaders().getFirst("token");
            if (StringUtils.isAllBlank(token))
            {
                response.setStatusCode(HttpStatus.UNAUTHORIZED);
                return  response.setComplete();
            }
            Claims claimsBody = AppJwtUtil.getClaimsBody(token);
            int result = AppJwtUtil.verifyToken(claimsBody);
            if (result==1||result==2)
            {
                response.setStatusCode(HttpStatus.UNAUTHORIZED);
                return  response.setComplete();
            }
        }catch (Exception e)
        {
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            return  response.setComplete();
        }


return chain.filter(exchange);

    }


    @Override
    public int getOrder() {
        return 0;
    }
}
