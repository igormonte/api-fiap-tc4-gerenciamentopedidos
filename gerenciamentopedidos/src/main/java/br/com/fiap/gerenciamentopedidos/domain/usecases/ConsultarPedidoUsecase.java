package br.com.fiap.gerenciamentopedidos.domain.usecases;

import br.com.fiap.gerenciamentopedidos.domain.entity.PedidoEntity;

import java.util.List;
import java.util.UUID;

public interface ConsultarPedidoUsecase {

    public PedidoEntity buscarPorId(UUID id);
    public List<PedidoEntity> buscarPedidos();

}
