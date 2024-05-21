package br.com.fiap.gerenciamentopedidos.produto.infrastructure.configuration;

import br.com.fiap.gerenciamentopedidos.produto.application.controller.ProdutoApi;
import br.com.fiap.gerenciamentopedidos.produto.application.controller.ProdutoController;
import br.com.fiap.gerenciamentopedidos.produto.application.gateway.ProdutoDbGateway;
import br.com.fiap.gerenciamentopedidos.produto.domain.usecases.*;
import br.com.fiap.gerenciamentopedidos.produto.domain.usecases.repository.ProdutoRepository;
import br.com.fiap.gerenciamentopedidos.produto.infrastructure.db.mysql.repository.ProdutoDbRepository;
import br.com.fiap.gerenciamentopedidos.produto.infrastructure.lib.mapstruct.mapper.ProdutoMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public ProdutoRepository getProdutoRepository(
            ProdutoDbRepository produtoDbRepository,
            ProdutoMapper mapper) {
        return new ProdutoDbGateway(
                produtoDbRepository,
                mapper);
    }

}
