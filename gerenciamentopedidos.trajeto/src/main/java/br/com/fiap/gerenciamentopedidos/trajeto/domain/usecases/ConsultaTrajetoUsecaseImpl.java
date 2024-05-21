package br.com.fiap.gerenciamentopedidos.trajeto.domain.usecases;

import br.com.fiap.gerenciamentopedidos.trajeto.domain.entity.TrajetoEntity;
import br.com.fiap.gerenciamentopedidos.trajeto.domain.usecases.repository.TrajetoRepository;

import java.util.List;
import java.util.UUID;

public class ConsultaTrajetoUsecaseImpl implements ConsultaTrajetoUsecase {

    private final TrajetoRepository trajetoRepository;

    public ConsultaTrajetoUsecaseImpl(TrajetoRepository trajetoRepository) {
        this.trajetoRepository = trajetoRepository;
    }

    @Override
    public TrajetoEntity buscarPorId(UUID id) {
        return this.trajetoRepository.buscarTrajetoPorId(id);
    }
    @Override
    public List<TrajetoEntity> buscarTrajetos() {
        return this.trajetoRepository.buscarTrajetos();
    }

}
