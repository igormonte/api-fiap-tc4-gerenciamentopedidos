package br.com.fiap.gerenciamentopedidos.trajeto.application.gateway;

import br.com.fiap.gerenciamentopedidos.trajeto.domain.usecases.repository.PedidoRepository;
import br.com.fiap.gerenciamentopedidos.trajeto.infrastructure.gerenciamentopedidos.pedido.PedidoMessagingGateway;
import br.com.fiap.gerenciamentopedidos.trajeto.infrastructure.gerenciamentopedidos.pedido.dto.FinalizarPedidoRequestDto;
import org.springframework.integration.support.MessageBuilder;

public class PedidoApiGateway implements PedidoRepository {

    private final PedidoMessagingGateway pedidoMessagingGateway;

    public PedidoApiGateway(PedidoMessagingGateway pedidoMessagingGateway) {
        this.pedidoMessagingGateway = pedidoMessagingGateway;
    }

    @Override
    public Boolean finalizaPedido(String idPedido) {
        return this.pedidoMessagingGateway.finalizaPedido(
                MessageBuilder.withPayload(
                        new FinalizarPedidoRequestDto(idPedido)
                ).build()
        ).getBody();
    }
}
