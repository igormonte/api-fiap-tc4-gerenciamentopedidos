package br.com.fiap.gerenciamentopedidos.cliente.infrastructure.db.mongo;

import br.com.fiap.gerenciamentopedidos.cliente.domain.entity.ClienteEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ClienteDbRepository extends MongoRepository<ClienteDbEntity, UUID> {
    ClienteDbEntity findByEmail(String email);
}
