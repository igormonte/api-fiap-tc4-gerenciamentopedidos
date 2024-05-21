package br.com.fiap.gerenciamentopedidos.cliente.infrastructure.db.mongo;

import br.com.fiap.gerenciamentopedidos.cliente.domain.entity.Endereco;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Document("cliente")
public class ClienteDbEntity {

    @MongoId
    private UUID id;
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private String email;
    private String telefone;
    private Endereco endereco;

}
