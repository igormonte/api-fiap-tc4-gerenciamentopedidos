package br.com.fiap.gerenciamentopedidos.trajeto.infrastructure.configuration;

import br.com.fiap.gerenciamentopedidos.trajeto.application.controller.TrajetoApi;
import br.com.fiap.gerenciamentopedidos.trajeto.application.controller.TrajetoController;
import br.com.fiap.gerenciamentopedidos.trajeto.application.gateway.PedidoApiGateway;
import br.com.fiap.gerenciamentopedidos.trajeto.application.gateway.TrajetoDbGateway;
import br.com.fiap.gerenciamentopedidos.trajeto.domain.usecases.AlterarTrajetoUsecase;
import br.com.fiap.gerenciamentopedidos.trajeto.domain.usecases.ConsultaTrajetoUsecase;
import br.com.fiap.gerenciamentopedidos.trajeto.domain.usecases.CriarTrajetoUsecase;
import br.com.fiap.gerenciamentopedidos.trajeto.domain.usecases.repository.PedidoRepository;
import br.com.fiap.gerenciamentopedidos.trajeto.domain.usecases.repository.TrajetoRepository;
import br.com.fiap.gerenciamentopedidos.trajeto.infrastructure.db.mongo.repository.TrajetoDbRepository;
import br.com.fiap.gerenciamentopedidos.trajeto.infrastructure.gerenciamentopedidos.pedido.PedidoMessagingGateway;
import br.com.fiap.gerenciamentopedidos.trajeto.infrastructure.lib.mapstruct.mapper.TrajetoMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public TrajetoRepository getTrajetoRepository(
            TrajetoDbRepository trajetoDbRepository,
            TrajetoMapper mapper) {
        return new TrajetoDbGateway(
                trajetoDbRepository,
                mapper);
    }

    @Bean
    public PedidoRepository getPedidoRepository(
            PedidoMessagingGateway pedidoMessagingGateway) {
        return new PedidoApiGateway(
                pedidoMessagingGateway
        );
    }

}
