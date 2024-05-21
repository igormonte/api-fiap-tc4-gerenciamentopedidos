package br.com.fiap.gerenciamentopedidos.produto.application.dto;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record DeletarProdutoRequestDto(
        @NotNull
        UUID id
) {
}
