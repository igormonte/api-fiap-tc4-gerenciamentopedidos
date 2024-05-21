package br.com.fiap.gerenciamentopedidos.application.controller;

import br.com.fiap.gerenciamentopedidos.application.dto.CriarPedidoRequestDto;
import br.com.fiap.gerenciamentopedidos.application.dto.FinalizarPedidoRequestDto;
import br.com.fiap.gerenciamentopedidos.domain.usecases.ConsultarPedidoUsecase;
import br.com.fiap.gerenciamentopedidos.domain.usecases.CriarPedidoUsecase;
import br.com.fiap.gerenciamentopedidos.domain.usecases.FinalizaPedidoUsecase;
import br.com.fiap.gerenciamentopedidos.infraestructure.lib.mapstruct.mapper.PedidoMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.UUID;

@Controller
public class PedidoController implements PedidoApi {
    private final CriarPedidoUsecase criarPedidoUsecase;
    private final ConsultarPedidoUsecase consultarPedidoUsecase;
    private final FinalizaPedidoUsecase finalizaPedidoUsecase;
    private final PedidoMapper mapper;

    public PedidoController(
            CriarPedidoUsecase criarPedidoUsecase,
            ConsultarPedidoUsecase consultarPedidoUsecase,
            FinalizaPedidoUsecase finalizaPedidoUsecase,
            PedidoMapper mapper) {
        this.criarPedidoUsecase = criarPedidoUsecase;
        this.consultarPedidoUsecase = consultarPedidoUsecase;
        this.finalizaPedidoUsecase = finalizaPedidoUsecase;
        this.mapper = mapper;
    }

    @Override
    public ResponseEntity<?> buscarPedidos() {
        return ResponseEntity.ok(this.consultarPedidoUsecase.buscarPedidos());
    }

    @Override
    public ResponseEntity<?> buscarPedidoPorId(UUID id) {
        return ResponseEntity.ok(this.consultarPedidoUsecase.buscarPorId(id));
    }

    @Override
    public ResponseEntity<?> criarPedido(CriarPedidoRequestDto pedido) {
        return new ResponseEntity<>(this.criarPedidoUsecase.executar(
                this.mapper.toPedidoEntity(pedido)), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> finalizaPedido(FinalizarPedidoRequestDto finalizarPedidoRequestDto) {
        return new ResponseEntity<>(this.finalizaPedidoUsecase.executar(
                finalizarPedidoRequestDto.id()
        ), HttpStatus.CREATED);
    }

}
