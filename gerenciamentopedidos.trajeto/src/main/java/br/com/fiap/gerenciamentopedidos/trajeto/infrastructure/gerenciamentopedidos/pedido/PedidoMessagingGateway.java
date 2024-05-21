package br.com.fiap.gerenciamentopedidos.trajeto.infrastructure.gerenciamentopedidos.pedido;

import br.com.fiap.gerenciamentopedidos.trajeto.infrastructure.gerenciamentopedidos.pedido.dto.FinalizarPedidoRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.GatewayHeader;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;

import java.util.UUID;

@MessagingGateway
public interface PedidoMessagingGateway {

    @Gateway(requestChannel = "finalizaPedido",
            requestTimeout = 5000,
            headers = @GatewayHeader(name = MessageHeaders.REPLY_CHANNEL,
            expression = "@nullChannel"))
    public ResponseEntity<Boolean> finalizaPedido(Message<FinalizarPedidoRequestDto> pedido);

}
