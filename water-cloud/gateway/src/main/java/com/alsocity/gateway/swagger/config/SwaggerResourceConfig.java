package com.alsocity.gateway.swagger.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author : 小凡
 * @date : create in 2021/7/23 14:10
 * description :
 **/

@Component
public class SwaggerResourceConfig implements SwaggerResourcesProvider {

    /**
     * swagger2默认的url后缀
     */
    private static final String SWAGGER2URL = "/v2/api-docs";

    /**
     * 网关应用名称
     * 配置集成的服务，名称与gateway中route的Path一致，用于拼接路径访问后端服务的swagger路径
     * 如：swagger.serivces = rider,user
     */
    @Value("${swagger.service}")
    private List<String> swaggerServices;

    @Override
    public List<SwaggerResource> get() {
        List<SwaggerResource> resources = new ArrayList<>();
        // 记录已经添加过的server，存在同一个应用注册了多个服务在nacos上
        Set<String> dealed = new HashSet<>();
        swaggerServices.forEach(instance -> {
            // 拼接url，样式为/service/v2/api-info，当网关调用这个接口时，会自动通过负载均衡寻找对应的主机
            String url = String.format("/%s%s", instance, SWAGGER2URL);
            if (!dealed.contains(url)) {
                dealed.add(url);
                SwaggerResource swaggerResource = new SwaggerResource();
                swaggerResource.setUrl(url);
                swaggerResource.setName(instance);
                resources.add(swaggerResource);
            }
        });
        return resources;
    }

}
