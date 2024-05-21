package br.com.fiap.gerenciamentopedidos.infraestructure.mysql.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Entity(name = "item")
public class ItemDbEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column()
    private UUID idProduto;

    @Column()
    private String nomeProduto;

    @Column()
    private BigDecimal quantidade;

    @Column()
    private BigDecimal valor;

}
