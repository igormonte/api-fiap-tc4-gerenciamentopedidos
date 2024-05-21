package br.com.fiap.gerenciamentopedidos.infraestructure.gerenciamentopedidos.produto.dto;

import java.math.BigDecimal;
import java.util.UUID;

public record ProdutoResponseDto (
    UUID id,
    String descricao,
    BigDecimal saldoQuantidade,
    BigDecimal precoUnitario){

}
