package br.com.fiap.gerenciamentopedidos.produto.infrastructure.db.mysql.entity;

import br.com.fiap.gerenciamentopedidos.produto.domain.entity.UnidadeMedida;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Entity(name = "produto")
public class ProdutoDbEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column()
    private String descricao;

    @Column()
    private String categoria;

    @Column()
    private UnidadeMedida unidadeMedida;

    @Column()
    private BigDecimal saldoQuantidade;

    @Column()
    private BigDecimal precoUnitario;

    @Column()
    private BigDecimal taxaAplicada;


}
