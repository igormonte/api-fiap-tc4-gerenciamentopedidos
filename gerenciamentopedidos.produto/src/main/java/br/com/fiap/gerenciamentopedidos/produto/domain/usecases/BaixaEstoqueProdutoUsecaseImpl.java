package br.com.fiap.gerenciamentopedidos.produto.domain.usecases;

import br.com.fiap.gerenciamentopedidos.produto.application.exception.ProdutoNaoEncontradoException;
import br.com.fiap.gerenciamentopedidos.produto.domain.entity.ProdutoEntity;
import br.com.fiap.gerenciamentopedidos.produto.domain.usecases.repository.ProdutoRepository;

import java.math.BigDecimal;
import java.util.UUID;

public class BaixaEstoqueProdutoUsecaseImpl implements BaixaEstoqueProdutoUsecase {

    private final ProdutoRepository produtoRepository;

    public BaixaEstoqueProdutoUsecaseImpl(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public Boolean executar(UUID id, BigDecimal quantidade) {

        ProdutoEntity produto = this.produtoRepository.buscarProdutoPorId(id);

        if(produto == null) {
            throw new ProdutoNaoEncontradoException();
        }

        produto.baixarSaldo(quantidade);

        return this.produtoRepository.atualizarProduto(produto) != null;
    }

}
