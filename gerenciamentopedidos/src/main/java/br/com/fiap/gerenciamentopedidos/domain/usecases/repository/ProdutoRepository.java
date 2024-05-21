package br.com.fiap.gerenciamentopedidos.domain.usecases.repository;

import br.com.fiap.gerenciamentopedidos.domain.entity.ItemEntity;

import java.math.BigDecimal;
import java.util.UUID;

public interface ProdutoRepository {

    public ItemEntity buscarProdutoPorId(UUID id);
    public Boolean verificarDisponibilidadeProduto(UUID idProduto, BigDecimal quantidade);
    public Boolean baixarProduto(UUID idProduto, BigDecimal quantidade);

}
