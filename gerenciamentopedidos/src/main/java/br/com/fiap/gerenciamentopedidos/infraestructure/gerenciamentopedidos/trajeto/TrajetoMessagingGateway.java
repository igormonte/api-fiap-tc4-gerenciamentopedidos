package br.com.fiap.gerenciamentopedidos.infraestructure.gerenciamentopedidos.trajeto;

import br.com.fiap.gerenciamentopedidos.domain.entity.PedidoEntity;
import br.com.fiap.gerenciamentopedidos.domain.entity.StatusPedido;
import br.com.fiap.gerenciamentopedidos.infraestructure.gerenciamentopedidos.trajeto.dto.CriarTrajetoRequestDto;
import br.com.fiap.gerenciamentopedidos.infraestructure.gerenciamentopedidos.trajeto.dto.TrajetoResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.GatewayHeader;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;

import java.util.UUID;

@MessagingGateway
public interface TrajetoMessagingGateway {
    @Gateway(requestChannel = "consultaTrajeto",
            requestTimeout = 5000,
            headers = @GatewayHeader(name = MessageHeaders.REPLY_CHANNEL,
            expression = "@nullChannel"))
    public ResponseEntity<TrajetoResponseDto> buscarStatusTrajetoPorId(UUID id);

    @Gateway(requestChannel = "criaTrajeto",
            requestTimeout = 5000,
            headers = @GatewayHeader(name = MessageHeaders.REPLY_CHANNEL,
            expression = "@nullChannel"))
    public ResponseEntity<TrajetoResponseDto> criaTrajeto(Message<CriarTrajetoRequestDto> pedido);

}
