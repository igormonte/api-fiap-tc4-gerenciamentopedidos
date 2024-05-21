package br.com.fiap.gerenciamentopedidos.produto.domain.usecases;

import br.com.fiap.gerenciamentopedidos.produto.domain.entity.ProdutoEntity;
import br.com.fiap.gerenciamentopedidos.produto.domain.usecases.repository.ProdutoRepository;

import java.util.List;
import java.util.UUID;

public class ConsultaProdutoUsecaseImpl implements ConsultaProdutoUsecase {

    private final ProdutoRepository produtoRepository;

    public ConsultaProdutoUsecaseImpl(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public ProdutoEntity buscarPorId(UUID id) {
        return this.produtoRepository.buscarProdutoPorId(id);
    }
    @Override
    public List<ProdutoEntity> buscarProdutos() {
        return this.produtoRepository.buscarProdutos();
    }

}
