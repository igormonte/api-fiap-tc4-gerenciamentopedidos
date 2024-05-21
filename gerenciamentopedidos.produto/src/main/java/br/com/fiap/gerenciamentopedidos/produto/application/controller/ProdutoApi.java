package br.com.fiap.gerenciamentopedidos.produto.application.controller;

import br.com.fiap.gerenciamentopedidos.produto.application.dto.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/produto")
public interface ProdutoApi {

    @GetMapping("")
    ResponseEntity<?> buscarProdutos();

    @RequestMapping(value = "", method = RequestMethod.GET, params = "id")
    ResponseEntity<?> buscarProdutoPorId(@RequestParam UUID id);

    @PostMapping("")
    ResponseEntity<?> salvarProduto(@Validated @RequestBody SalvarProdutoRequestDto produto);

    @PutMapping("")
    ResponseEntity<?> atualizarProduto(@Validated @RequestBody AtualizarProdutoRequestDto produto);

    @PutMapping("/baixar")
    ResponseEntity<?> baixarProduto(@Validated @RequestBody BaixarProdutoRequestDto produto);

    @PostMapping("/disponibilidade")
    ResponseEntity<?> verificarProduto(@Validated @RequestBody VerificarProdutoRequestDto produto);

//    @DeleteMapping("")
//    ResponseEntity<?> deletarProduto(@Validated @RequestBody DeletarProdutoRequestDto produto);


}
