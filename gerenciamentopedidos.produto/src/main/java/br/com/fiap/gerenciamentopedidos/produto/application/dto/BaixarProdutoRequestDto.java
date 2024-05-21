package br.com.fiap.gerenciamentopedidos.produto.application.dto;

import br.com.fiap.gerenciamentopedidos.produto.domain.entity.UnidadeMedida;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.UUID;

public record BaixarProdutoRequestDto(

        @NotNull
        UUID id,
        @NotNull
        BigDecimal quantidade
) {
}
