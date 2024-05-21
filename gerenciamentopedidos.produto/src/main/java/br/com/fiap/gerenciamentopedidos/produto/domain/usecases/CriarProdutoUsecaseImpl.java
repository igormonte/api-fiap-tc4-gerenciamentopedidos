package br.com.fiap.gerenciamentopedidos.produto.domain.usecases;

import br.com.fiap.gerenciamentopedidos.produto.domain.entity.ProdutoEntity;
import br.com.fiap.gerenciamentopedidos.produto.domain.usecases.repository.ProdutoRepository;

public class CriarProdutoUsecaseImpl implements CriarProdutoUsecase {

    private final ProdutoRepository produtoRepository;

    public CriarProdutoUsecaseImpl(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public ProdutoEntity executar(ProdutoEntity produto) {
        return this.produtoRepository.atualizarProduto(produto);
    }

}
