package br.com.fiap.gerenciamentopedidos.produto.domain.usecases;

import br.com.fiap.gerenciamentopedidos.produto.domain.entity.ProdutoEntity;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public interface ConsultaProdutoUsecase {

    public ProdutoEntity buscarPorId(UUID id);
    public List<ProdutoEntity> buscarProdutos();

}
