package br.com.fiap.gerenciamentopedidos.produto.domain.usecases;

import java.math.BigDecimal;
import java.util.UUID;

public interface VerificaDisponibilidadeProdutoUsecase {

    Boolean executar(UUID id, BigDecimal quantidade);

}
