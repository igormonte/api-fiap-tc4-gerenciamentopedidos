package br.com.fiap.gerenciamentopedidos.produto.domain.usecases.repository;

import br.com.fiap.gerenciamentopedidos.produto.domain.entity.ProdutoEntity;

import java.util.List;
import java.util.UUID;

public interface ProdutoRepository {

    List<ProdutoEntity> buscarProdutos();
    ProdutoEntity buscarProdutoPorId(UUID id);
    ProdutoEntity salvarProduto(ProdutoEntity produto);
    ProdutoEntity atualizarProduto(ProdutoEntity produto);

}
