package br.com.fiap.gerenciamentopedidos.cliente.application.controller;

import br.com.fiap.gerenciamentopedidos.cliente.application.dto.AtualizarClienteRequestDto;
import br.com.fiap.gerenciamentopedidos.cliente.application.dto.DeletarClienteRequestDto;
import br.com.fiap.gerenciamentopedidos.cliente.application.dto.SalvarClienteRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/cliente")
public interface ClienteApi {

    @GetMapping("")
    ResponseEntity<?> buscarClientes();

    @RequestMapping(value = "", method = RequestMethod.GET, params = "id")
    ResponseEntity<?> buscarClientePorId(@RequestParam UUID id);

    @RequestMapping(value = "", method = RequestMethod.GET, params = "email")
    ResponseEntity<?> buscarClientePorEmail(@RequestParam String email);

    @PostMapping("")
    ResponseEntity<?> salvarCliente(@Validated @RequestBody SalvarClienteRequestDto cliente);

    @PutMapping("")
    ResponseEntity<?> atualizarCliente(@Validated @RequestBody AtualizarClienteRequestDto cliente);

    @DeleteMapping("")
    ResponseEntity<?> deletarCliente(@Validated @RequestBody DeletarClienteRequestDto cliente);


}
