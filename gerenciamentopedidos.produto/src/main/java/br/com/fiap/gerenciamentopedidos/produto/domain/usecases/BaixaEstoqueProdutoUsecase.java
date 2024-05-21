package br.com.fiap.gerenciamentopedidos.produto.domain.usecases;

import br.com.fiap.gerenciamentopedidos.produto.domain.entity.ProdutoEntity;

import java.math.BigDecimal;
import java.util.UUID;

public interface BaixaEstoqueProdutoUsecase {

    Boolean executar(UUID id, BigDecimal quantidade);

}
