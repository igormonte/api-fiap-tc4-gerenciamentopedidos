package br.com.fiap.gerenciamentopedidos.trajeto.infrastructure.db.mongo.entity;

import br.com.fiap.gerenciamentopedidos.trajeto.domain.entity.Endereco;
import br.com.fiap.gerenciamentopedidos.trajeto.domain.entity.Status;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.UUID;


@Data
@Document("trajeto")
public class TrajetoDbEntity {

    @MongoId
    private UUID id;

    private String idPedido;

    private Status status;

    private String descricaoMateriaisEntrega;

    private Endereco enderecoEntrega;

}
