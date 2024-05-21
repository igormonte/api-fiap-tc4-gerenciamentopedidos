package br.com.fiap.gerenciamentopedidos.domain.usecases;

import br.com.fiap.gerenciamentopedidos.domain.entity.PedidoEntity;
import br.com.fiap.gerenciamentopedidos.domain.usecases.repository.PedidoRepository;

import java.util.List;
import java.util.UUID;

public class ConsultarPedidoUsecaseImpl implements ConsultarPedidoUsecase {

    private final PedidoRepository pedidoRepository;

    public ConsultarPedidoUsecaseImpl(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @Override
    public PedidoEntity buscarPorId(UUID id) {
        return this.pedidoRepository.buscarPedidoPorId(id);
    }

    @Override
    public List<PedidoEntity> buscarPedidos() {
        return this.pedidoRepository.buscarPedidos();
    }
}
