package br.com.fiap.gerenciamentopedidos.cliente.domain.entity;

import lombok.Data;

@Data
public class EnderecoTest {

    private String rua;
    private Integer numero;
    private String bairro;
    private String cidade;
    private String uf;
    private String cep;

}
