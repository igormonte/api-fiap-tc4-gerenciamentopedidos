package br.com.fiap.gerenciamentopedidos.infraestructure.gerenciamentopedidos.trajeto.dto;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record CriarTrajetoRequestDto(
@NotNull
String idPedido,
@NotNull
String descricaoMateriaisEntrega,
@NotNull
EnderecoEntrega enderecoEntrega) {

public record EnderecoEntrega(
        UUID id,
        String rua,
        Integer numero,
        String bairro,
        String cidade,
        String uf,
        String cep
){}
}
