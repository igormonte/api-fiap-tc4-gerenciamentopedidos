package br.com.fiap.gerenciamentopedidos.application.gateway;

import br.com.fiap.gerenciamentopedidos.application.exception.PedidoNaoEncontradoException;
import br.com.fiap.gerenciamentopedidos.domain.entity.PedidoEntity;
import br.com.fiap.gerenciamentopedidos.domain.usecases.repository.PedidoRepository;
import br.com.fiap.gerenciamentopedidos.infraestructure.lib.mapstruct.mapper.PedidoMapper;
import br.com.fiap.gerenciamentopedidos.infraestructure.mysql.repository.PedidoDbRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;


public class PedidoDbGateway implements PedidoRepository {

    private final PedidoDbRepository pedidoDbRepository;
    private final PedidoMapper mapper;

    public PedidoDbGateway(
            PedidoDbRepository pedidoDbRepository,
            PedidoMapper mapper) {
        this.pedidoDbRepository = pedidoDbRepository;
        this.mapper = mapper;
    }


    @Override
    public List<PedidoEntity> buscarPedidos() {
        return this.mapper.toPedidoEntityList(this.pedidoDbRepository.findAll());
    }

    @Override
    public PedidoEntity buscarPedidoPorId(UUID id) {
        return this.mapper.toPedidoEntity(this.pedidoDbRepository.findById(id)
                .orElseThrow(PedidoNaoEncontradoException::new));
    }

    @Override
    @Transactional
    public PedidoEntity salvarPedido(PedidoEntity pedido) {
        return this.mapper.toPedidoEntity(this.pedidoDbRepository.save(
                this.mapper.toPedidoDbEntity(pedido)
        ));
    }

    @Override
    @Transactional
    public PedidoEntity atualizarPedido(PedidoEntity pedido) {
        return this.mapper.toPedidoEntity(this.pedidoDbRepository.save(
                this.mapper.toPedidoDbEntity(pedido)
        ));
    }

    @Override
    public Boolean deletaPedidoPorId(UUID id) {
        this.pedidoDbRepository.deleteById(id);
        return true;
    }

//    @Override
//    @Transactional
//    public Boolean deletarPedido(UUID id) {
//        this.pedidoDbRepository.deleteById(id);
//        return true;
//    }
}
