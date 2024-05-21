package br.com.fiap.gerenciamentopedidos.infraestructure.mysql.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity(name = "endereco")
public class EnderecoDbEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column
    private String rua;

    @Column
    private Integer numero;

    @Column
    private String bairro;

    @Column
    private String cidade;

    @Column
    private String uf;

    @Column
    private String cep;

    public EnderecoDbEntity() {
        
    }

    public EnderecoDbEntity(
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
