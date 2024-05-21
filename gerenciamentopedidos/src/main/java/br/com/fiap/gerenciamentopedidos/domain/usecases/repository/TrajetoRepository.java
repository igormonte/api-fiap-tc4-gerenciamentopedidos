package br.com.fiap.gerenciamentopedidos.domain.usecases.repository;

import br.com.fiap.gerenciamentopedidos.domain.entity.ItemEntity;
import br.com.fiap.gerenciamentopedidos.domain.entity.PedidoEntity;
import br.com.fiap.gerenciamentopedidos.domain.entity.StatusPedido;

import java.math.BigDecimal;
import java.util.UUID;

public interface TrajetoRepository {

    public StatusPedido buscarStatusTrajetoPorId(UUID id);
    public Boolean criaTrajeto(PedidoEntity pedido);

}
