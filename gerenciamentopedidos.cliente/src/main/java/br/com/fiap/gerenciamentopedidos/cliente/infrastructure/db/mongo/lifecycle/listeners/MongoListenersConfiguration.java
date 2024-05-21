package br.com.fiap.gerenciamentopedidos.cliente.infrastructure.db.mongo.lifecycle.listeners;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class MongoListenersConfiguration {
    @Bean
    public ClienteDbEntityEventListener getClienteDbEntityEventListener() {
        return new ClienteDbEntityEventListener();
    }

}
