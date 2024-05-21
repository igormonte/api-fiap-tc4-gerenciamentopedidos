package br.com.fiap.gerenciamentopedidos.produto.domain.usecases;

import br.com.fiap.gerenciamentopedidos.produto.domain.entity.ProdutoEntity;

public interface CriarProdutoUsecase {

    public ProdutoEntity executar(ProdutoEntity produto);

}
