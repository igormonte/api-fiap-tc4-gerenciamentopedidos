package br.com.fiap.gerenciamentopedidos.infraestructure.mysql.entity;

import br.com.fiap.gerenciamentopedidos.domain.entity.EnderecoEntity;
import br.com.fiap.gerenciamentopedidos.domain.entity.StatusPedido;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Entity(name = "pedido")
public class PedidoDbEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column()
    private UUID idCliente;

    @Column()
    private LocalDateTime dataCriacao;

    @Column()
    private StatusPedido status;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "idPedido", referencedColumnName = "id")
    private List<ItemDbEntity> item;

    @OneToOne(cascade = CascadeType.ALL)
    private EnderecoDbEntity enderecoEntrega;

}
