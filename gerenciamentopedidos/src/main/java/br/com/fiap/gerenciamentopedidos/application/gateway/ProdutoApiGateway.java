package br.com.fiap.gerenciamentopedidos.application.gateway;

import br.com.fiap.gerenciamentopedidos.domain.entity.ItemEntity;
import br.com.fiap.gerenciamentopedidos.domain.usecases.repository.ProdutoRepository;
import br.com.fiap.gerenciamentopedidos.infraestructure.gerenciamentopedidos.produto.ProdutoMessagingGateway;
import br.com.fiap.gerenciamentopedidos.infraestructure.gerenciamentopedidos.produto.dto.BaixarProdutoRequestDto;
import br.com.fiap.gerenciamentopedidos.infraestructure.gerenciamentopedidos.produto.dto.VerificarProdutoRequestDto;
import br.com.fiap.gerenciamentopedidos.infraestructure.lib.mapstruct.mapper.ItemMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.support.MessageBuilder;

import java.math.BigDecimal;
import java.util.UUID;

@Slf4j
public class ProdutoApiGateway implements ProdutoRepository {

    private final ProdutoMessagingGateway produtoMessagingGateway;
    private final ItemMapper itemMapper;

    public ProdutoApiGateway(ProdutoMessagingGateway produtoMessagingGateway, ItemMapper itemMapper) {
        this.produtoMessagingGateway = produtoMessagingGateway;
        this.itemMapper = itemMapper;
    }

    @Override
    public ItemEntity buscarProdutoPorId(UUID id) {
        return this.itemMapper.toItemEntity(
                produtoMessagingGateway.buscarProdutoPorId(id).getBody());
    }

    @Override
    public Boolean verificarDisponibilidadeProduto(UUID idProduto, BigDecimal quantidade) {
        ResponseEntity<Boolean> response =  produtoMessagingGateway.verificarDisponibilidadeProduto(
                MessageBuilder.withPayload(
                        new VerificarProdutoRequestDto(idProduto, quantidade)
                ).build()
        );

        return response.getBody();
    }

    public Boolean baixarProduto(UUID idProduto, BigDecimal quantidade) {
        ResponseEntity<Boolean> response =  produtoMessagingGateway.baixarProduto(
                MessageBuilder.withPayload(
                        new BaixarProdutoRequestDto(idProduto, quantidade)
                ).build()
        );
        return response.getBody();
    }
}
