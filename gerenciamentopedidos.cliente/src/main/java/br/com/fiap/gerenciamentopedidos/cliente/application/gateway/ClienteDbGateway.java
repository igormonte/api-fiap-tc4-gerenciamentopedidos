package br.com.fiap.gerenciamentopedidos.cliente.application.gateway;

import br.com.fiap.gerenciamentopedidos.cliente.application.exception.ClienteNaoEncontradoException;
import br.com.fiap.gerenciamentopedidos.cliente.domain.entity.ClienteEntity;
import br.com.fiap.gerenciamentopedidos.cliente.domain.usecases.repository.ClienteRepository;
import br.com.fiap.gerenciamentopedidos.cliente.infrastructure.db.mongo.ClienteDbRepository;
import br.com.fiap.gerenciamentopedidos.cliente.infrastructure.lib.mapstruct.mapper.ClienteMapper;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;


public class ClienteDbGateway implements ClienteRepository {

    private final ClienteDbRepository clienteDbRepository;
    private final ClienteMapper mapper;

    public ClienteDbGateway(
            ClienteDbRepository clienteDbRepository,
            ClienteMapper mapper) {
        this.clienteDbRepository = clienteDbRepository;
        this.mapper = mapper;
    }


    @Override
    public List<ClienteEntity> buscarClientes() {
        return this.mapper.toClienteEntityList(this.clienteDbRepository.findAll());
    }

    @Override
    public ClienteEntity buscarClientePorId(UUID id) {
        return this.mapper.toClienteEntity(this.clienteDbRepository.findById(id)
                .orElseThrow(ClienteNaoEncontradoException::new));
    }

    @Override
    public ClienteEntity buscarClientePorEmail(String email) {
        return this.mapper.toClienteEntity(this.clienteDbRepository.findByEmail(email));
    }

    @Override
    @Transactional
    public ClienteEntity salvarCliente(ClienteEntity cliente) {
        return this.mapper.toClienteEntity(this.clienteDbRepository.save(
                this.mapper.toClienteDbEntity(cliente)
        ));
    }

    @Override
    @Transactional
    public ClienteEntity atualizarCliente(ClienteEntity cliente) {
        return this.mapper.toClienteEntity(this.clienteDbRepository.save(
                this.mapper.toClienteDbEntity(cliente)
        ));
    }

    @Override
    @Transactional
    public Boolean deletarCliente(UUID id) {
        this.clienteDbRepository.deleteById(id);
        return true;
    }
}
