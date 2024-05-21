package br.com.fiap.gerenciamentopedidos.trajeto.domain.usecases;

import br.com.fiap.gerenciamentopedidos.trajeto.domain.entity.Status;
import br.com.fiap.gerenciamentopedidos.trajeto.domain.entity.TrajetoEntity;
import br.com.fiap.gerenciamentopedidos.trajeto.domain.usecases.repository.TrajetoRepository;

public class CriarTrajetoUsecaseImpl implements CriarTrajetoUsecase {

    private final TrajetoRepository trajetoRepository;

    public CriarTrajetoUsecaseImpl(TrajetoRepository trajetoRepository) {
        this.trajetoRepository = trajetoRepository;
    }

    @Override
    public TrajetoEntity executar(TrajetoEntity trajeto) {
        trajeto.setStatus(Status.INICIADO);
        return this.trajetoRepository.atualizarTrajeto(trajeto);
    }

}
