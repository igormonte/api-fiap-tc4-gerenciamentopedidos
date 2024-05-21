package br.com.fiap.gerenciamentopedidos.produto.domain.usecases;

import br.com.fiap.gerenciamentopedidos.produto.application.exception.ProdutoNaoEncontradoException;
import br.com.fiap.gerenciamentopedidos.produto.domain.entity.ProdutoEntity;
import br.com.fiap.gerenciamentopedidos.produto.domain.usecases.repository.ProdutoRepository;

import java.math.BigDecimal;
import java.util.UUID;

public class VerificaDisponibilidadeProdutoUsecaseImpl implements VerificaDisponibilidadeProdutoUsecase {


    private final ProdutoRepository produtoRepository;

    public VerificaDisponibilidadeProdutoUsecaseImpl(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public Boolean executar(UUID id, BigDecimal quantidade) {

        ProdutoEntity produto = this.produtoRepository.buscarProdutoPorId(id);

        if(produto == null) {
            throw new ProdutoNaoEncontradoException();
        }

        return produto.verificarDisponibilidade(quantidade);
    }

}
