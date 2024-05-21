package br.com.fiap.gerenciamentopedidos.trajeto.domain.usecases;

import br.com.fiap.gerenciamentopedidos.trajeto.domain.entity.TrajetoEntity;

import java.util.List;
import java.util.UUID;

public interface ConsultaTrajetoUsecase {

    public TrajetoEntity buscarPorId(UUID id);
    public List<TrajetoEntity> buscarTrajetos();

}
