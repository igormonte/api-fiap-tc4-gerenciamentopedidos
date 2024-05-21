package br.com.fiap.gerenciamentopedidos.trajeto.domain.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class TrajetoEntity {

    private UUID id;

    private String idPedido;

    private Status status;

    private String descricaoMateriaisEntrega;

    private Endereco enderecoEntrega;

}
