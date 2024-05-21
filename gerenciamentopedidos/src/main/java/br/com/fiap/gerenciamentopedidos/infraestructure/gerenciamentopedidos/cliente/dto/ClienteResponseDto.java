package br.com.fiap.gerenciamentopedidos.infraestructure.gerenciamentopedidos.cliente.dto;

import java.math.BigDecimal;
import java.util.UUID;

public record ClienteResponseDto(
    UUID id,
    EnderecoCliente endereco
){


    public record EnderecoCliente(


            UUID id,
            String rua,
            Integer numero,
            String bairro,
            String cidade,
            String uf,
            String cep
    ){}
}
