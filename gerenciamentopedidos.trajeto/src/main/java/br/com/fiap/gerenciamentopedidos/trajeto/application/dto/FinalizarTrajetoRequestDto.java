package br.com.fiap.gerenciamentopedidos.trajeto.application.dto;

import br.com.fiap.gerenciamentopedidos.trajeto.domain.entity.Endereco;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record FinalizarTrajetoRequestDto(
        @NotNull
        UUID id
) {
}
