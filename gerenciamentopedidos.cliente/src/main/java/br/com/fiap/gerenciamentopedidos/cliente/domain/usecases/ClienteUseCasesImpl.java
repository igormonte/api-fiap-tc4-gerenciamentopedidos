package br.com.fiap.gerenciamentopedidos.cliente.domain.usecases;

import br.com.fiap.gerenciamentopedidos.cliente.domain.entity.ClienteEntity;
import br.com.fiap.gerenciamentopedidos.cliente.domain.usecases.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

public class ClienteUseCasesImpl implements ClienteUseCases {

    private final ClienteRepository clienteRepository;

    public ClienteUseCasesImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public List<ClienteEntity> buscarClientes() {
        return this.clienteRepository.buscarClientes();
    }

    @Override
    public ClienteEntity buscarClientePorId(UUID id) {
        return this.clienteRepository.buscarClientePorId(id);
    }

    @Override
    public ClienteEntity buscarClientePorEmail(String email) {
        return this.clienteRepository.buscarClientePorEmail(email);
    }

    @Override
    public ClienteEntity salvarCliente(ClienteEntity cliente) {
        return this.clienteRepository.salvarCliente(cliente);
    }

    @Override
    public ClienteEntity atualizarCliente(ClienteEntity cliente) {

        ClienteEntity clienteSalvo = this.buscarClientePorId(cliente.getId());

        clienteSalvo.setEmail(cliente.getEmail());
        clienteSalvo.setTelefone(cliente.getTelefone());
        clienteSalvo.setEndereco(cliente.getEndereco());

        return this.clienteRepository.atualizarCliente(clienteSalvo);
    }

    @Override
    public Boolean deletarCliente(UUID id) {

        ClienteEntity clienteEntity = this.buscarClientePorId(id);

        return this.clienteRepository.deletarCliente(clienteEntity.getId());
    }
}
