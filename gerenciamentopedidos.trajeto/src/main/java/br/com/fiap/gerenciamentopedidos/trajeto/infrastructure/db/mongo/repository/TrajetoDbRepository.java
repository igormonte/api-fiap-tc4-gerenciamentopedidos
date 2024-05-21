package br.com.fiap.gerenciamentopedidos.trajeto.infrastructure.db.mongo.repository;

import br.com.fiap.gerenciamentopedidos.trajeto.infrastructure.db.mongo.entity.TrajetoDbEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TrajetoDbRepository extends MongoRepository<TrajetoDbEntity, UUID> {
}
