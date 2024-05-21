package br.com.fiap.gerenciamentopedidos.application.dto;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record FinalizarPedidoRequestDto(
    @NotNull
    UUID id
) {
}
