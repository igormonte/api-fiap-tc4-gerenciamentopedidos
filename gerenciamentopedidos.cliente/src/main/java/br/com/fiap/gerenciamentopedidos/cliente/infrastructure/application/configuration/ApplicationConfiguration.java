package br.com.fiap.gerenciamentopedidos.cliente.infrastructure.application.configuration;

import br.com.fiap.gerenciamentopedidos.cliente.application.controller.ClienteApi;
import br.com.fiap.gerenciamentopedidos.cliente.application.controller.ClienteController;
import br.com.fiap.gerenciamentopedidos.cliente.application.gateway.ClienteDbGateway;
import br.com.fiap.gerenciamentopedidos.cliente.domain.usecases.ClienteUseCases;
import br.com.fiap.gerenciamentopedidos.cliente.domain.usecases.repository.ClienteRepository;
import br.com.fiap.gerenciamentopedidos.cliente.infrastructure.db.mongo.ClienteDbRepository;
import br.com.fiap.gerenciamentopedidos.cliente.infrastructure.lib.mapstruct.mapper.ClienteMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public ClienteRepository getClienteRepository(
            ClienteDbRepository clienteDbRepository,
            ClienteMapper mapper) {
        return new ClienteDbGateway(
                clienteDbRepository,
                mapper);
    }

}
