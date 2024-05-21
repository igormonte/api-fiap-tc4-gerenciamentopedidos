package br.com.fiap.gerenciamentopedidos.domain.usecases;

import br.com.fiap.gerenciamentopedidos.application.exception.PedidoNaoEncontradoException;
import br.com.fiap.gerenciamentopedidos.domain.entity.EnderecoEntity;
import br.com.fiap.gerenciamentopedidos.domain.entity.ItemEntity;
import br.com.fiap.gerenciamentopedidos.domain.entity.PedidoEntity;
import br.com.fiap.gerenciamentopedidos.domain.entity.StatusPedido;
import br.com.fiap.gerenciamentopedidos.domain.usecases.repository.ClienteRepository;
import br.com.fiap.gerenciamentopedidos.domain.usecases.repository.PedidoRepository;
import br.com.fiap.gerenciamentopedidos.domain.usecases.repository.ProdutoRepository;
import br.com.fiap.gerenciamentopedidos.domain.usecases.repository.TrajetoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Slf4j
public class FinalizarPedidoUsecaseImpl implements FinalizaPedidoUsecase {

    private final PedidoRepository pedidoRepository;

    public FinalizarPedidoUsecaseImpl(
            PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @Override
    @Transactional
    public Boolean executar(UUID id) {

        if(!this.verificaSePedidoExiste(id)) {
            throw new PedidoNaoEncontradoException();
        }

        PedidoEntity pedidoSalvo = this.pedidoRepository.buscarPedidoPorId(id);
        pedidoSalvo.setStatus(StatusPedido.FINALIZADO);

        pedidoSalvo = this.pedidoRepository.atualizarPedido(pedidoSalvo);
        return pedidoSalvo.isFinalizado();
    }

    Boolean verificaSePedidoExiste(UUID id) {

        PedidoEntity pedido = this.pedidoRepository.buscarPedidoPorId(id);

        if(pedido != null) {
            return true;
        }

        return false;

    }


}
