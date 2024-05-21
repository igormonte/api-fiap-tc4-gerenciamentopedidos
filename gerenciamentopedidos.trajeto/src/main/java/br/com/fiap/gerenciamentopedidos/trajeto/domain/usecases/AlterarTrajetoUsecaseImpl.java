package br.com.fiap.gerenciamentopedidos.trajeto.domain.usecases;

import br.com.fiap.gerenciamentopedidos.trajeto.domain.entity.TrajetoEntity;
import br.com.fiap.gerenciamentopedidos.trajeto.domain.usecases.repository.TrajetoRepository;

public class AlterarTrajetoUsecaseImpl implements AlterarTrajetoUsecase {

    private final TrajetoRepository trajetoRepository;

    public AlterarTrajetoUsecaseImpl(
            TrajetoRepository trajetoRepository) {
        this.trajetoRepository = trajetoRepository;
    }

    public TrajetoEntity executar(TrajetoEntity trajeto) {

        TrajetoEntity trajetoSalvo = this.trajetoRepository.buscarTrajetoPorId(trajeto.getId());
        trajetoSalvo.setIdPedido(trajeto.getIdPedido());
        trajetoSalvo.setEnderecoEntrega(trajeto.getEnderecoEntrega());
        trajetoSalvo.setDescricaoMateriaisEntrega(trajeto.getDescricaoMateriaisEntrega());

        return this.trajetoRepository.atualizarTrajeto(trajetoSalvo);
    }

}
