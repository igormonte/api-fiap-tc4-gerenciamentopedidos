package br.com.fiap.gerenciamentopedidos.domain.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
public class PedidoEntity {

    private UUID id;

    private UUID idCliente;

    private LocalDateTime dataCriacao;

    private StatusPedido status;

    private List<ItemEntity> item;

    private EnderecoEntity enderecoEntrega;

    public String itemsToString() {
        return String.join(",", item.stream().map(ItemEntity::getNomeProduto).toList());
    }

    BigDecimal getValorTotal() {
        return item.stream()
                .map(ItemEntity::getValorTotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public Boolean isFinalizado() {
        return this.status.equals(StatusPedido.FINALIZADO);
    }
}
