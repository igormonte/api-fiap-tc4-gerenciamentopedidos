package br.com.fiap.gerenciamentopedidos.trajeto.infrastructure.db.mongo.listeners;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class MongoListenersConfiguration {
    @Bean
    public TrajetoDbEntityEventListener getClienteDbEntityEventListener() {
        return new TrajetoDbEntityEventListener();
    }

}
