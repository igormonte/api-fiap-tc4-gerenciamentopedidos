package br.com.fiap.gerenciamentopedidos.domain.usecases;

import br.com.fiap.gerenciamentopedidos.domain.entity.PedidoEntity;

public interface CriarPedidoUsecase {

    PedidoEntity executar(PedidoEntity pedido);

}
