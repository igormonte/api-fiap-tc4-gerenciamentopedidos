package br.com.fiap.gerenciamentopedidos.cliente.domain.usecases;

import br.com.fiap.gerenciamentopedidos.cliente.domain.entity.ClienteEntity;

import java.util.List;
import java.util.UUID;

public interface ClienteUseCases {

    List<ClienteEntity> buscarClientes();
    ClienteEntity buscarClientePorId(UUID id);
    ClienteEntity buscarClientePorEmail(String email);
    ClienteEntity salvarCliente(ClienteEntity cliente);
    ClienteEntity atualizarCliente(ClienteEntity cliente);
    Boolean deletarCliente(UUID id);
    
}
