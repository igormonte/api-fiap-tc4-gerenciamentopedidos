package br.com.fiap.gerenciamentopedidos.infraestructure.configuration;

import br.com.fiap.gerenciamentopedidos.domain.usecases.*;
import br.com.fiap.gerenciamentopedidos.domain.usecases.repository.ClienteRepository;
import br.com.fiap.gerenciamentopedidos.domain.usecases.repository.PedidoRepository;
import br.com.fiap.gerenciamentopedidos.domain.usecases.repository.ProdutoRepository;
import br.com.fiap.gerenciamentopedidos.domain.usecases.repository.TrajetoRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DomainConfiguration {

    @Bean
    public ConsultarPedidoUsecase getConsultaPedidoUsecase (PedidoRepository pedidoRepository){
        return new ConsultarPedidoUsecaseImpl(pedidoRepository);
    }

    @Bean
    public FinalizaPedidoUsecase getFinalizaPedidoUsecase(PedidoRepository pedidoRepository) {
        return new FinalizarPedidoUsecaseImpl(pedidoRepository);
    }

    @Bean
    public CriarPedidoUsecase getCriarPedidoUsecase (
            PedidoRepository pedidoRepository,
            ProdutoRepository produtoRepository,
            TrajetoRepository trajetoRepository,
            ClienteRepository clienteRepository){
        return new CriarPedidoUsecaseImpl(
                pedidoRepository,
                produtoRepository,
                trajetoRepository,
                clienteRepository);
    }

}
