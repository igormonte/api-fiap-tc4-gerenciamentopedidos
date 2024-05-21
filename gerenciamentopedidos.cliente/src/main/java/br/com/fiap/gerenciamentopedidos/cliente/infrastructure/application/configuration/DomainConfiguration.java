package br.com.fiap.gerenciamentopedidos.cliente.infrastructure.application.configuration;

import br.com.fiap.gerenciamentopedidos.cliente.domain.usecases.ClienteUseCases;
import br.com.fiap.gerenciamentopedidos.cliente.domain.usecases.ClienteUseCasesImpl;
import br.com.fiap.gerenciamentopedidos.cliente.domain.usecases.repository.ClienteRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class DomainConfiguration {

    @Bean
    public ClienteUseCases getClienteUseCases(ClienteRepository clienteRepository){
        return new ClienteUseCasesImpl(clienteRepository);
    }

}
