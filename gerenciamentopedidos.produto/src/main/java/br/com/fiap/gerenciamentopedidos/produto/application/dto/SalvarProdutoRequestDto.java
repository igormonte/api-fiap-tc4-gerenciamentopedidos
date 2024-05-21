package br.com.fiap.gerenciamentopedidos.produto.application.dto;

import br.com.fiap.gerenciamentopedidos.produto.domain.entity.UnidadeMedida;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public record SalvarProdutoRequestDto(

        @NotNull
        String descricao,
        @NotNull
        String categoria,
        @NotNull
        UnidadeMedida unidadeMedida,
        @NotNull
        BigDecimal saldoQuantidade,
        @NotNull
        BigDecimal precoUnitario,
        @NotNull
        BigDecimal taxaAplicada) {
}
