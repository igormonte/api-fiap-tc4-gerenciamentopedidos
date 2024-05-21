package br.com.fiap.gerenciamentopedidos.trajeto.application.controller;

import br.com.fiap.gerenciamentopedidos.trajeto.application.dto.AtualizarTrajetoRequestDto;
import br.com.fiap.gerenciamentopedidos.trajeto.application.dto.FinalizarTrajetoRequestDto;
import br.com.fiap.gerenciamentopedidos.trajeto.application.dto.SalvarTrajetoRequestDto;
import br.com.fiap.gerenciamentopedidos.trajeto.domain.usecases.AlterarTrajetoUsecase;
import br.com.fiap.gerenciamentopedidos.trajeto.domain.usecases.ConsultaTrajetoUsecase;
import br.com.fiap.gerenciamentopedidos.trajeto.domain.usecases.CriarTrajetoUsecase;
import br.com.fiap.gerenciamentopedidos.trajeto.domain.usecases.FinalizarTrajetoUsecase;
import br.com.fiap.gerenciamentopedidos.trajeto.infrastructure.lib.mapstruct.mapper.TrajetoMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.UUID;

@Controller
public class TrajetoController implements TrajetoApi {
    private final CriarTrajetoUsecase criarTrajetoUsecase;
    private final AlterarTrajetoUsecase alterarTrajetoUsecase;
    private final FinalizarTrajetoUsecase finalizarTrajetoUsecase;
    private final ConsultaTrajetoUsecase consultaTrajetoUsecase;
    private final TrajetoMapper mapper;

    public TrajetoController(
            CriarTrajetoUsecase criarTrajetoUsecase,
            AlterarTrajetoUsecase alterarTrajetoUsecase,
            FinalizarTrajetoUsecase finalizarTrajetoUsecase,
            ConsultaTrajetoUsecase consultaTrajetoUsecase,
            TrajetoMapper mapper) {
        this.criarTrajetoUsecase = criarTrajetoUsecase;
        this.alterarTrajetoUsecase = alterarTrajetoUsecase;
        this.finalizarTrajetoUsecase = finalizarTrajetoUsecase;
        this.consultaTrajetoUsecase = consultaTrajetoUsecase;
        this.mapper = mapper;
    }

    @GetMapping("")
    @Override
    public ResponseEntity<?> buscarTrajetos() {
        return ResponseEntity.ok(this.consultaTrajetoUsecase.buscarTrajetos());
    }

    @Override
    public ResponseEntity<?> buscarTrajetoPorId(UUID id) {
        return ResponseEntity.ok(this.consultaTrajetoUsecase.buscarPorId(id));
    }

    @Override
    public ResponseEntity<?> salvarTrajeto(SalvarTrajetoRequestDto trajeto) {
        return new ResponseEntity<>(this.criarTrajetoUsecase.executar(
                this.mapper.toTrajetoEntity(trajeto)), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> atualizarTrajeto(AtualizarTrajetoRequestDto trajeto) {
        return ResponseEntity.ok(this.alterarTrajetoUsecase.executar(
                this.mapper.toTrajetoEntity(trajeto)));
    }
    @Override
    public ResponseEntity<?> finalizarTrajeto(FinalizarTrajetoRequestDto trajeto) {
        return ResponseEntity.ok(this.finalizarTrajetoUsecase.executar(
                trajeto.id()));
    }
//
//    @Override
//    public ResponseEntity<?> deletarTrajeto(DeletarTrajetoRequestDto trajeto) {
//        this.trajetoUseCases.deletarTrajeto(trajeto.id());
//        return ResponseEntity.noContent().build();
//    }
}
