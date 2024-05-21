package br.com.fiap.gerenciamentopedidos.trajeto.application.dto;

import br.com.fiap.gerenciamentopedidos.trajeto.domain.entity.Endereco;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record SalvarTrajetoRequestDto(
        @NotNull
        String idPedido,
        @NotNull
        String descricaoMateriaisEntrega,
        @NotNull
        Endereco enderecoEntrega) {
}
