package br.com.fiap.gerenciamentopedidos.produto.domain.usecases;

import br.com.fiap.gerenciamentopedidos.produto.domain.entity.ProdutoEntity;
import br.com.fiap.gerenciamentopedidos.produto.domain.usecases.repository.ProdutoRepository;

public class AlterarProdutoUsecaseImpl implements AlterarProdutoUsecase {

    private final ProdutoRepository produtoRepository;

    public AlterarProdutoUsecaseImpl(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public ProdutoEntity executar(ProdutoEntity produto) {
        return this.produtoRepository.atualizarProduto(produto);
    }

}
