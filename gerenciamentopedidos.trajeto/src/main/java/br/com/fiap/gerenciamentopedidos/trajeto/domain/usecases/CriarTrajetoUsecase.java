package br.com.fiap.gerenciamentopedidos.trajeto.domain.usecases;

import br.com.fiap.gerenciamentopedidos.trajeto.domain.entity.TrajetoEntity;

public interface CriarTrajetoUsecase {

    public TrajetoEntity executar(TrajetoEntity trajeto);

}
