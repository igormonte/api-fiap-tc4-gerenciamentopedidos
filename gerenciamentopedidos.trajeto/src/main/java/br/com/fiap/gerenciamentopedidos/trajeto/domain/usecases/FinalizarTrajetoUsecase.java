package br.com.fiap.gerenciamentopedidos.trajeto.domain.usecases;

import br.com.fiap.gerenciamentopedidos.trajeto.domain.entity.TrajetoEntity;

import java.util.UUID;

public interface FinalizarTrajetoUsecase {

    public TrajetoEntity executar(UUID id);

}
