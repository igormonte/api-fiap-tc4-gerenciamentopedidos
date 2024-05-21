package br.com.fiap.gerenciamentopedidos.cliente.domain.entity;

import lombok.Data;

import java.util.UUID;

@Data
public class Endereco {

    private String rua;
    private Integer numero;
    private String bairro;
    private String cidade;
    private String uf;
    private String cep;

    public Endereco(
        String rua,
        Integer numero,
        String bairro,
        String cidade,
        String uf,
        String cep
    ) {

        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.cep = cep;
    }

}
