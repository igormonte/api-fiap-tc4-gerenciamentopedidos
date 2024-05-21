package br.com.fiap.gerenciamentopedidos.application.gateway;

import br.com.fiap.gerenciamentopedidos.domain.entity.EnderecoEntity;
import br.com.fiap.gerenciamentopedidos.domain.usecases.repository.ClienteRepository;
import br.com.fiap.gerenciamentopedidos.infraestructure.gerenciamentopedidos.cliente.ClienteMessagingGateway;
import br.com.fiap.gerenciamentopedidos.infraestructure.gerenciamentopedidos.cliente.dto.ClienteResponseDto;
import br.com.fiap.gerenciamentopedidos.infraestructure.lib.mapstruct.mapper.EnderecoMapper;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;
import java.util.UUID;

@Slf4j
public class ClienteApiGateway implements ClienteRepository {

    private final ClienteMessagingGateway clienteMessagingGateway;

    private final EnderecoMapper enderecoMapper;

    public ClienteApiGateway(ClienteMessagingGateway clienteMessagingGateway, EnderecoMapper enderecoMapper) {
        this.clienteMessagingGateway = clienteMessagingGateway;
        this.enderecoMapper = enderecoMapper;
    }

    @Override
    public EnderecoEntity buscarEnderecoClientePorId(UUID id) {
        ClienteResponseDto clienteResponseDto = this.clienteMessagingGateway.buscarClientePorId(id).getBody();

        return this.enderecoMapper.toEnderecoEntity(Objects.requireNonNull(clienteResponseDto).endereco());

    }

    @Override
    public UUID verificaSeClienteExiste(UUID id) {
        return Objects.requireNonNull(this.clienteMessagingGateway.buscarClientePorId(id).getBody()).id();
    }
}
