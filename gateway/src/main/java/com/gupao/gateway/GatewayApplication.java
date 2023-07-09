package com.gupao.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class GatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

    //gateway主要做路由功能，另外也可以做 鉴权/限流 等

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        RouteLocatorBuilder.Builder routes = builder.routes();
        return routes
                .route(r -> r.path("/seckill/**").uri("lb://seckill-service"))
                .route(r -> r.path("/order/**").uri("lb://order-service"))
                .route(r -> r.path("/commodity/**").uri("lb://commodity-service"))
                .route(r -> r.path("/pay/**").uri("lb://pay-service"))
                .build();
    }
}
