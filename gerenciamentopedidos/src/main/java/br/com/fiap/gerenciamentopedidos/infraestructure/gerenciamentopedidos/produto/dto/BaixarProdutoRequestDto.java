package br.com.fiap.gerenciamentopedidos.infraestructure.gerenciamentopedidos.produto.dto;

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
