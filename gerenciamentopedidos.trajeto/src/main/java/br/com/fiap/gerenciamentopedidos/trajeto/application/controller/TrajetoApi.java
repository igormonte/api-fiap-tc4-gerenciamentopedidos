package br.com.fiap.gerenciamentopedidos.trajeto.application.controller;

import br.com.fiap.gerenciamentopedidos.trajeto.application.dto.AtualizarTrajetoRequestDto;
import br.com.fiap.gerenciamentopedidos.trajeto.application.dto.FinalizarTrajetoRequestDto;
import br.com.fiap.gerenciamentopedidos.trajeto.application.dto.SalvarTrajetoRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/trajeto")
public interface TrajetoApi {

    @GetMapping("")
    ResponseEntity<?> buscarTrajetos();

    @RequestMapping(value = "", method = RequestMethod.GET, params = "id")
    ResponseEntity<?> buscarTrajetoPorId(@RequestParam UUID id);

    @PostMapping("")
    ResponseEntity<?> salvarTrajeto(@Validated @RequestBody SalvarTrajetoRequestDto trajeto);

    @PutMapping("")
    ResponseEntity<?> atualizarTrajeto(@Validated @RequestBody AtualizarTrajetoRequestDto trajeto);

    @PostMapping("finalizar")
    ResponseEntity<?> finalizarTrajeto(@Validated @RequestBody FinalizarTrajetoRequestDto trajeto);

//    @DeleteMapping("")
//    ResponseEntity<?> deletarTrajeto(@Validated @RequestBody DeletarTrajetoRequestDto trajeto);


}
