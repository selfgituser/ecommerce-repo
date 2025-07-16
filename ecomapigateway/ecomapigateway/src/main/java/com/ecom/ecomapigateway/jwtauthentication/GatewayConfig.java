package com.ecom.ecomapigateway.jwtauthentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Autowired
    private JwtAuthenticationFilter JwtAuthenticationFilter;

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("userdetailsmicro", r -> r.path("/api/users/**")
                        .filters(f -> f.filter(JwtAuthenticationFilter))
                        .uri("lb://userdetailsmicro"))
                .route("cartdetailsmicro", r -> r.path("/api/cartitems/**")
                        .filters(f -> f.filter(JwtAuthenticationFilter))
                        .uri("lb://cartdetailsmicro"))
                .build();
    }
}
