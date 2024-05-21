package br.com.fiap.gerenciamentopedidos.application.controller;

import br.com.fiap.gerenciamentopedidos.application.dto.CriarPedidoRequestDto;
import br.com.fiap.gerenciamentopedidos.application.dto.FinalizarPedidoRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/pedido")
public interface PedidoApi {

    @GetMapping("")
    ResponseEntity<?> buscarPedidos();

    @RequestMapping(value = "", method = RequestMethod.GET, params = "id")
    ResponseEntity<?> buscarPedidoPorId(@RequestParam UUID id);

    @PostMapping("")
    ResponseEntity<?> criarPedido(@Validated @RequestBody CriarPedidoRequestDto pedido);

    @PutMapping("/finalizar")
    ResponseEntity<?> finalizaPedido(@Validated @RequestBody FinalizarPedidoRequestDto finalizarPedidoRequestDto);


}
