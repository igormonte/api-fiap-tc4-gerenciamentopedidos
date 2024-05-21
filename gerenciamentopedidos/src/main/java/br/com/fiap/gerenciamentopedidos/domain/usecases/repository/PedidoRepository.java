package br.com.fiap.gerenciamentopedidos.domain.usecases.repository;

import br.com.fiap.gerenciamentopedidos.domain.entity.PedidoEntity;

import java.util.List;
import java.util.UUID;

public interface PedidoRepository {

    List<PedidoEntity> buscarPedidos();
    PedidoEntity buscarPedidoPorId(UUID id);
    PedidoEntity salvarPedido(PedidoEntity pedido);
    PedidoEntity atualizarPedido(PedidoEntity pedido);
    Boolean deletaPedidoPorId(UUID id);

}
