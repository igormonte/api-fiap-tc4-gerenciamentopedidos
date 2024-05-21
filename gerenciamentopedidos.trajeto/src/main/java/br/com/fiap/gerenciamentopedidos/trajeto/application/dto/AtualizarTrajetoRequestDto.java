package br.com.fiap.gerenciamentopedidos.trajeto.application.dto;

import br.com.fiap.gerenciamentopedidos.trajeto.domain.entity.Endereco;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.UUID;

public record AtualizarTrajetoRequestDto(
        @NotNull
        UUID id,
        @NotNull
        String idPedido,
        @NotNull
        String descricaoMateriaisEntrega,
        @NotNull
        Endereco enderecoEntrega
) {
}
