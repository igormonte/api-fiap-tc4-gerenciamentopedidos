package br.com.fiap.gerenciamentopedidos.domain.usecases;

import br.com.fiap.gerenciamentopedidos.domain.entity.PedidoEntity;

import java.util.UUID;

public interface FinalizaPedidoUsecase {

    Boolean executar(UUID id);

}
