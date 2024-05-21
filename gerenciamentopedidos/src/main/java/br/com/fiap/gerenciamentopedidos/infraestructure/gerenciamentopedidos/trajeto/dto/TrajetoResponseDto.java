package br.com.fiap.gerenciamentopedidos.infraestructure.gerenciamentopedidos.trajeto.dto;

import br.com.fiap.gerenciamentopedidos.domain.entity.StatusPedido;

import java.util.UUID;

public record TrajetoResponseDto(
    UUID id,
    StatusPedido status
){
}
