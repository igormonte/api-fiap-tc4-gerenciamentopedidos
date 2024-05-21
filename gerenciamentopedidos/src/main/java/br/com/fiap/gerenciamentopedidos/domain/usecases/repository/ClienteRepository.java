package br.com.fiap.gerenciamentopedidos.domain.usecases.repository;

import br.com.fiap.gerenciamentopedidos.domain.entity.EnderecoEntity;
import br.com.fiap.gerenciamentopedidos.domain.entity.ItemEntity;

import java.math.BigDecimal;
import java.util.UUID;

public interface ClienteRepository {

    public EnderecoEntity buscarEnderecoClientePorId(UUID id);

    UUID verificaSeClienteExiste(UUID idCliente);
}
