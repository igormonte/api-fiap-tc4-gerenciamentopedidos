package br.com.fiap.gerenciamentopedidos.trajeto.domain.usecases.repository;

import br.com.fiap.gerenciamentopedidos.trajeto.domain.entity.TrajetoEntity;

import java.util.List;
import java.util.UUID;

public interface TrajetoRepository {

    List<TrajetoEntity> buscarTrajetos();
    TrajetoEntity buscarTrajetoPorId(UUID id);
    TrajetoEntity salvarTrajeto(TrajetoEntity trajeto);
    TrajetoEntity atualizarTrajeto(TrajetoEntity trajeto);

}
