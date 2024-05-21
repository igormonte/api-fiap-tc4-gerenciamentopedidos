package br.com.fiap.gerenciamentopedidos.domain.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class ItemEntity {

    private UUID id;
    private UUID idProduto;
    private String nomeProduto;
    private BigDecimal quantidade;
    private BigDecimal valor;

    public BigDecimal getValorTotal() {
        return quantidade.multiply(valor);
    }

}
