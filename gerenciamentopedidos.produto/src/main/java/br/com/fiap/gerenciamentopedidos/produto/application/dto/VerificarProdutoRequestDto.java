package br.com.fiap.gerenciamentopedidos.produto.application.dto;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.UUID;

public record VerificarProdutoRequestDto(

        @NotNull
        UUID id,
        @NotNull
        BigDecimal quantidade
) {
}
