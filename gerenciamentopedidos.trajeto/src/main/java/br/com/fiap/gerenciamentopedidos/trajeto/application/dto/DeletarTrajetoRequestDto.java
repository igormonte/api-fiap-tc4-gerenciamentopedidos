package br.com.fiap.gerenciamentopedidos.trajeto.application.dto;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record DeletarTrajetoRequestDto(
        @NotNull
        UUID id
) {
}
