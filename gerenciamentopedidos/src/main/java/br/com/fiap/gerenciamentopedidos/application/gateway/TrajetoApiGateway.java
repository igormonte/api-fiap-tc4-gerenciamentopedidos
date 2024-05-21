package br.com.fiap.gerenciamentopedidos.application.gateway;

import br.com.fiap.gerenciamentopedidos.domain.entity.PedidoEntity;
import br.com.fiap.gerenciamentopedidos.domain.entity.StatusPedido;
import br.com.fiap.gerenciamentopedidos.domain.usecases.repository.TrajetoRepository;
import br.com.fiap.gerenciamentopedidos.infraestructure.gerenciamentopedidos.trajeto.TrajetoMessagingGateway;
import br.com.fiap.gerenciamentopedidos.infraestructure.gerenciamentopedidos.trajeto.dto.CriarTrajetoRequestDto;
import br.com.fiap.gerenciamentopedidos.infraestructure.gerenciamentopedidos.trajeto.dto.TrajetoResponseDto;
import br.com.fiap.gerenciamentopedidos.infraestructure.lib.mapstruct.mapper.EnderecoMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.support.MessageBuilder;

import java.util.UUID;

@Slf4j
public class TrajetoApiGateway implements TrajetoRepository {

    private final TrajetoMessagingGateway trajetoMessagingGateway;

    private final EnderecoMapper enderecoMapper;

    public TrajetoApiGateway(TrajetoMessagingGateway trajetoMessagingGateway,
                             EnderecoMapper enderecoMapper) {
        this.trajetoMessagingGateway = trajetoMessagingGateway;
        this.enderecoMapper = enderecoMapper;
    }

    @Override
    public StatusPedido buscarStatusTrajetoPorId(UUID id) {
        TrajetoResponseDto trajetoResponseDto =
                trajetoMessagingGateway.buscarStatusTrajetoPorId(id).getBody();

        return trajetoResponseDto.status();

    }

    @Override
    public Boolean criaTrajeto(PedidoEntity pedido) {
        ResponseEntity<TrajetoResponseDto> response =  trajetoMessagingGateway.criaTrajeto(
                MessageBuilder.withPayload(
                        new CriarTrajetoRequestDto(pedido.getId().toString(),
                            pedido.itemsToString(),
                            this.enderecoMapper.toEnderecoEntrega(pedido.getEnderecoEntrega())
                        )
                ).build()
        );
        return response.hasBody();
    }
}
