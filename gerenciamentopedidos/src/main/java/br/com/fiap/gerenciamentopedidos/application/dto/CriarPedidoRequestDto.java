package br.com.fiap.gerenciamentopedidos.application.dto;

import br.com.fiap.gerenciamentopedidos.domain.entity.ItemEntity;
import br.com.fiap.gerenciamentopedidos.domain.entity.StatusPedido;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record CriarPedidoRequestDto(
        @NotNull
        UUID idCliente,
        @NotNull
        List<ItemEntity>item) {
}
