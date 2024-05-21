package br.com.fiap.gerenciamentopedidos.infraestructure.gerenciamentopedidos.produto;

import br.com.fiap.gerenciamentopedidos.domain.entity.ItemEntity;
import br.com.fiap.gerenciamentopedidos.domain.usecases.repository.ProdutoRepository;
import br.com.fiap.gerenciamentopedidos.infraestructure.gerenciamentopedidos.produto.dto.BaixarProdutoRequestDto;
import br.com.fiap.gerenciamentopedidos.infraestructure.gerenciamentopedidos.produto.dto.ProdutoResponseDto;
import br.com.fiap.gerenciamentopedidos.infraestructure.gerenciamentopedidos.produto.dto.VerificarProdutoRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.GatewayHeader;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;

import java.math.BigDecimal;
import java.util.UUID;

@MessagingGateway
public interface ProdutoMessagingGateway {
    @Gateway(requestChannel = "consultaProduto",
            requestTimeout = 5000,
            headers = @GatewayHeader(name = MessageHeaders.REPLY_CHANNEL,
            expression = "@nullChannel"))
    
    public ResponseEntity<ProdutoResponseDto> buscarProdutoPorId(UUID id);

    
    @Gateway(requestChannel = "disponibilidadeProduto",
            requestTimeout = 5000,
            headers = @GatewayHeader(name = MessageHeaders.REPLY_CHANNEL,
                    expression = "@nullChannel"))
    public ResponseEntity<Boolean> verificarDisponibilidadeProduto(Message<VerificarProdutoRequestDto> verificarProdutoRequestDtoMessage);

    
    @Gateway(requestChannel = "baixaProduto",
            requestTimeout = 5000,

            headers = @GatewayHeader(name = MessageHeaders.REPLY_CHANNEL,
                    expression = "@nullChannel"))
    public ResponseEntity<Boolean> baixarProduto(Message<BaixarProdutoRequestDto> baixarProdutoRequestDtoMessage);
}
