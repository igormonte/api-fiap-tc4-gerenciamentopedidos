package br.com.fiap.gerenciamentopedidos.trajeto.domain.usecases;

import br.com.fiap.gerenciamentopedidos.trajeto.domain.entity.Status;
import br.com.fiap.gerenciamentopedidos.trajeto.domain.entity.TrajetoEntity;
import br.com.fiap.gerenciamentopedidos.trajeto.domain.usecases.repository.PedidoRepository;
import br.com.fiap.gerenciamentopedidos.trajeto.domain.usecases.repository.TrajetoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Slf4j
public class FinalizarTrajetoUsecaseImpl implements FinalizarTrajetoUsecase {

    private final TrajetoRepository trajetoRepository;
    private final PedidoRepository pedidoRepository;

    public FinalizarTrajetoUsecaseImpl(
            TrajetoRepository trajetoRepository, PedidoRepository pedidoRepository) {
        this.trajetoRepository = trajetoRepository;
        this.pedidoRepository = pedidoRepository;
    }

    @Transactional
    public TrajetoEntity executar(UUID id) {

        TrajetoEntity trajetoSalvo = this.trajetoRepository.buscarTrajetoPorId(id);
        trajetoSalvo.setStatus(Status.FINALIZADO);
        trajetoSalvo = this.trajetoRepository.atualizarTrajeto(trajetoSalvo);

        if(!trajetoSalvo.getStatus().equals(Status.FINALIZADO)) {
            throw new RuntimeException("Houve um problema ao salvar o novo status.");
        }

        log.info(trajetoSalvo.toString());

        this.pedidoRepository.finalizaPedido(trajetoSalvo.getIdPedido());

        return trajetoSalvo;

    }

}
