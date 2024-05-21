package br.com.fiap.gerenciamentopedidos.cliente.application.controller;

import br.com.fiap.gerenciamentopedidos.cliente.application.dto.AtualizarClienteRequestDto;
import br.com.fiap.gerenciamentopedidos.cliente.application.dto.DeletarClienteRequestDto;
import br.com.fiap.gerenciamentopedidos.cliente.application.dto.SalvarClienteRequestDto;
import br.com.fiap.gerenciamentopedidos.cliente.domain.usecases.ClienteUseCases;
import br.com.fiap.gerenciamentopedidos.cliente.infrastructure.lib.mapstruct.mapper.ClienteMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.UUID;

@Slf4j
@Controller
public class ClienteController implements ClienteApi {

    private final ClienteUseCases clienteUseCases;

    private final ClienteMapper mapper;

    public ClienteController(
            ClienteUseCases clienteUseCases,
            ClienteMapper mapper) {
        this.clienteUseCases = clienteUseCases;
        this.mapper = mapper;
    }

    @Override
    public ResponseEntity<?> buscarClientes() {
        return ResponseEntity.ok(this.clienteUseCases.buscarClientes());
    }

    @Override
    public ResponseEntity<?> buscarClientePorId(UUID id) {
        log.info(id.toString());
        return ResponseEntity.ok(this.clienteUseCases.buscarClientePorId(id));
    }

    @Override
    public ResponseEntity<?> buscarClientePorEmail(String email) {
        return ResponseEntity.ok(this.clienteUseCases.buscarClientePorEmail(email));
    }

    @Override
    public ResponseEntity<?> salvarCliente(SalvarClienteRequestDto cliente) {
        return new ResponseEntity<>(this.clienteUseCases.salvarCliente(
                this.mapper.toClienteEntity(cliente)), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> atualizarCliente(AtualizarClienteRequestDto cliente) {
        return ResponseEntity.ok(this.clienteUseCases.atualizarCliente(
                this.mapper.toClienteEntity(cliente)));
    }

    @Override
    public ResponseEntity<?> deletarCliente(DeletarClienteRequestDto cliente) {
        this.clienteUseCases.deletarCliente(cliente.id());
        return ResponseEntity.noContent().build();
    }
}
