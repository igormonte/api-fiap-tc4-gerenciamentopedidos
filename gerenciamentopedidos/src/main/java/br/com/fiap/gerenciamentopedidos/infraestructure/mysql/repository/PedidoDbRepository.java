package br.com.fiap.gerenciamentopedidos.infraestructure.mysql.repository;

import br.com.fiap.gerenciamentopedidos.infraestructure.mysql.entity.PedidoDbEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PedidoDbRepository extends JpaRepository<PedidoDbEntity, UUID> {
}
