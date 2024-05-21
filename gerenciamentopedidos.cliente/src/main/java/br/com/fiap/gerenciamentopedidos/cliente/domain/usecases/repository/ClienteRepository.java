package br.com.fiap.gerenciamentopedidos.cliente.domain.usecases.repository;

import br.com.fiap.gerenciamentopedidos.cliente.domain.entity.ClienteEntity;

import java.util.List;
import java.util.UUID;

public interface ClienteRepository {

    List<ClienteEntity> buscarClientes();
    ClienteEntity buscarClientePorId(UUID id);
    ClienteEntity buscarClientePorEmail(String email);
    ClienteEntity salvarCliente(ClienteEntity cliente);
    ClienteEntity atualizarCliente(ClienteEntity cliente);
    Boolean deletarCliente(UUID id);

}
