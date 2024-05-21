package br.com.fiap.gerenciamentopedidos.gateway.application.routes;



import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.UUID;

@Configuration
public class RoutesConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("pedido", r -> r.path("/pedido-service/**")
                        .filters(f -> f.stripPrefix(1))
                        .uri("http://localhost:8081"))
                .route("trajeto", r -> r.path("/trajeto-service/**")
                        .filters(f -> f.stripPrefix(1))
                        .uri("http://localhost:8082"))
                .route("produto", r -> r.path("/produto-service/**")
                        .filters(f -> f.stripPrefix(1))
                        .uri("http://localhost:8083"))
                .route("cliente", r -> r.path("/cliente-service/**")
                        .filters(f -> f.stripPrefix(1))
                        .uri("http://localhost:8084"))
                .build();
    }
}
