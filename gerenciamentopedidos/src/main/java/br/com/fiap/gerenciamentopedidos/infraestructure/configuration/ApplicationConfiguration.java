package br.com.fiap.gerenciamentopedidos.infraestructure.configuration;

import br.com.fiap.gerenciamentopedidos.application.gateway.ClienteApiGateway;
import br.com.fiap.gerenciamentopedidos.application.gateway.PedidoDbGateway;
import br.com.fiap.gerenciamentopedidos.application.gateway.ProdutoApiGateway;
import br.com.fiap.gerenciamentopedidos.application.gateway.TrajetoApiGateway;
import br.com.fiap.gerenciamentopedidos.domain.usecases.repository.ClienteRepository;
import br.com.fiap.gerenciamentopedidos.domain.usecases.repository.PedidoRepository;
import br.com.fiap.gerenciamentopedidos.domain.usecases.repository.ProdutoRepository;
import br.com.fiap.gerenciamentopedidos.domain.usecases.repository.TrajetoRepository;
import br.com.fiap.gerenciamentopedidos.infraestructure.gerenciamentopedidos.cliente.ClienteMessagingGateway;
import br.com.fiap.gerenciamentopedidos.infraestructure.gerenciamentopedidos.produto.ProdutoMessagingGateway;
import br.com.fiap.gerenciamentopedidos.infraestructure.gerenciamentopedidos.trajeto.TrajetoMessagingGateway;
import br.com.fiap.gerenciamentopedidos.infraestructure.lib.mapstruct.mapper.EnderecoMapper;
import br.com.fiap.gerenciamentopedidos.infraestructure.lib.mapstruct.mapper.ItemMapper;
import br.com.fiap.gerenciamentopedidos.infraestructure.lib.mapstruct.mapper.PedidoMapper;
import br.com.fiap.gerenciamentopedidos.infraestructure.mysql.repository.PedidoDbRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public ProdutoRepository getProdutoRepository(ProdutoMessagingGateway produtoMessagingGateway, ItemMapper itemMapper) {
        return new ProdutoApiGateway(produtoMessagingGateway, itemMapper);
    }


    @Bean
    public TrajetoRepository getTrajetoRepository(
            TrajetoMessagingGateway trajetoMessagingGateway,
            EnderecoMapper enderecoMapper) {
        return new TrajetoApiGateway(
                trajetoMessagingGateway,
                enderecoMapper);
    }
    @Bean
    public ClienteRepository getClienteRepository(
            ClienteMessagingGateway clienteMessagingGateway,
            EnderecoMapper enderecoMapper
    ) {
        return new ClienteApiGateway(
                clienteMessagingGateway,
                enderecoMapper);
    }

    @Bean
    public PedidoRepository getPedidoRepository(
            PedidoDbRepository pedidoDbRepository,
            PedidoMapper mapper) {
        return new PedidoDbGateway(
                pedidoDbRepository,
                mapper);
    }

}
