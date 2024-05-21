package br.com.fiap.gerenciamentopedidos.infraestructure.gerenciamentopedidos.cliente;

import br.com.fiap.gerenciamentopedidos.infraestructure.gerenciamentopedidos.cliente.dto.ClienteResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.GatewayHeader;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;

import java.util.UUID;

@MessagingGateway
public interface ClienteMessagingGateway {
    @Gateway(requestChannel = "consultaCliente",
            requestTimeout = 5000,
            headers = @GatewayHeader(name = MessageHeaders.REPLY_CHANNEL,
            expression = "@nullChannel"))
    
    public ResponseEntity<ClienteResponseDto> buscarClientePorId(UUID id);

}
