package br.com.fiap.gerenciamentopedidos.produto.infrastructure.db.mysql.repository;

import br.com.fiap.gerenciamentopedidos.produto.infrastructure.db.mysql.entity.ProdutoDbEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProdutoDbRepository extends JpaRepository<ProdutoDbEntity, UUID> {
}
