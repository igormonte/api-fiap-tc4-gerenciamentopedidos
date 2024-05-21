package br.com.fiap.gerenciamentopedidos.cliente.application.dto;

import br.com.fiap.gerenciamentopedidos.cliente.domain.entity.Endereco;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.UUID;

public record SalvarClienteRequestDto(
        @NotNull
        String nome,
        @NotNull
        String cpf,
        @NotNull
        LocalDate dataNascimento,
        @NotNull
        String email,
        @NotNull
        String telefone,
        @NotNull
        Endereco endereco) {
}
