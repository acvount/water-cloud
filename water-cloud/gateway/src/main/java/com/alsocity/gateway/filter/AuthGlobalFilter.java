package com.alsocity.gateway.filter;


import cn.hutool.json.JSONObject;
import com.alsocity.common.core.exception.config.ExceptionType;
import com.alsocity.common.redis.util.RedisUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/**
 * @author : 小凡
 * @date : create in 2021/7/27 17:00
 * description :
 **/
@Component
public class AuthGlobalFilter implements GlobalFilter, Ordered {

    @Value("${swagger.service}")
    private ArrayList<String> swaggerPath;

    @Resource
    private RedisUtils redisUtils;

    private final static ArrayList<String> WHITE_LISTS = new ArrayList<String>() {{
        //设备获取有更新的参数
        add("/equipment-service/param/getEnabledByEid");
        //设备通电测试
        add("/equipment-service/equipment/electric");
    }};

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        if (!checkWhitelists(exchange)) {
            String token = exchange.getRequest().getHeaders().getFirst("X-IDENTITY");
            //是否有token
            if (!redisUtils.hasKey(token)) {
                return noTokenMono(exchange);
            } else {
                //token是否正确
                if (false) {
                    return invalidTokenMono(exchange);
                }
            }
        }
        return chain.filter(exchange);

    }

    @Override
    public int getOrder() {
        return -21;
    }

    private boolean checkWhitelists(ServerWebExchange exchange) {
        String currentPath = exchange.getRequest().getPath().toString();
        // Swagger docs
        for (String serverName : swaggerPath) {
            if (String.format("/%s/v2/api-docs", serverName).equals(currentPath)) {
                return true;
            }
        }

        //系统白名单
        return WHITE_LISTS.contains(currentPath);
    }

    /**
     * 无效的token
     */
    private Mono<Void> invalidTokenMono(ServerWebExchange exchange) {
        JSONObject json = new JSONObject();
        json.putOpt("code", ExceptionType.Token_Invalid.getCode());
        json.putOpt("msg", ExceptionType.Token_Invalid.getMessage());
        return buildReturnMono(json, exchange);
    }

    private Mono<Void> noTokenMono(ServerWebExchange exchange) {
        JSONObject json = new JSONObject();
        json.putOpt("code", ExceptionType.Token_Not_Found.getCode());
        json.putOpt("msg", ExceptionType.Token_Not_Found.getMessage());
        return buildReturnMono(json, exchange);
    }

    private Mono<Void> buildReturnMono(JSONObject json, ServerWebExchange exchange) {
        ServerHttpResponse response = exchange.getResponse();
        byte[] bits = json.toString().getBytes(StandardCharsets.UTF_8);
        DataBuffer buffer = response.bufferFactory().wrap(bits);
        response.setStatusCode(HttpStatus.UNAUTHORIZED);
        //指定编码，否则在浏览器中会中文乱码
        response.getHeaders().add("Content-Type", "text/plain;charset=UTF-8");
        return response.writeWith(Mono.just(buffer));
    }
}
