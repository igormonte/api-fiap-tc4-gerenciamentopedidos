package br.com.fiap.gerenciamentopedidos.cliente.application.dto;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record DeletarClienteRequestDto(
        @NotNull
        UUID id
) {
}
