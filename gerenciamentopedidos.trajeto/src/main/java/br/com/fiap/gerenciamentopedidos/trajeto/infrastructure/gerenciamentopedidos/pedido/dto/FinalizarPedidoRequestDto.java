package br.com.fiap.gerenciamentopedidos.trajeto.infrastructure.gerenciamentopedidos.pedido.dto;

import jakarta.validation.constraints.NotNull;

public record FinalizarPedidoRequestDto(
    @NotNull
    String id
) {
}
