package br.com.fiap.gerenciamentopedidos.produto.application.controller;

import br.com.fiap.gerenciamentopedidos.produto.application.dto.AtualizarProdutoRequestDto;
import br.com.fiap.gerenciamentopedidos.produto.application.dto.BaixarProdutoRequestDto;
import br.com.fiap.gerenciamentopedidos.produto.application.dto.SalvarProdutoRequestDto;
import br.com.fiap.gerenciamentopedidos.produto.application.dto.VerificarProdutoRequestDto;
import br.com.fiap.gerenciamentopedidos.produto.domain.usecases.*;
import br.com.fiap.gerenciamentopedidos.produto.infrastructure.lib.mapstruct.mapper.ProdutoMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.UUID;

@Slf4j
@Controller
public class ProdutoController implements ProdutoApi {
    private final CriarProdutoUsecase criarProdutoUsecase;
    private final AlterarProdutoUsecase alterarProdutoUsecase;
    private final BaixaEstoqueProdutoUsecase baixaEstoqueProdutoUsecase;
    private final ConsultaProdutoUsecase consultaProdutoUsecase;
    private final VerificaDisponibilidadeProdutoUsecase verificaDisponibilidadeProdutoUsecase;
    private final ProdutoMapper mapper;

    public ProdutoController(
            CriarProdutoUsecase criarProdutoUsecase,
            AlterarProdutoUsecase alterarProdutoUsecase,
            BaixaEstoqueProdutoUsecase baixaEstoqueProdutoUsecase,
            ConsultaProdutoUsecase consultaProdutoUsecase,
            VerificaDisponibilidadeProdutoUsecase verificaDisponibilidadeProdutoUsecase,
            ProdutoMapper mapper) {
        this.criarProdutoUsecase = criarProdutoUsecase;
        this.alterarProdutoUsecase = alterarProdutoUsecase;
        this.baixaEstoqueProdutoUsecase = baixaEstoqueProdutoUsecase;
        this.consultaProdutoUsecase = consultaProdutoUsecase;
        this.verificaDisponibilidadeProdutoUsecase = verificaDisponibilidadeProdutoUsecase;
        this.mapper = mapper;
    }

    @Override
    public ResponseEntity<?> buscarProdutos() {
        return ResponseEntity.ok(this.consultaProdutoUsecase.buscarProdutos());
    }

    @Override
    public ResponseEntity<?> buscarProdutoPorId(UUID id) {
        return ResponseEntity.ok(this.consultaProdutoUsecase.buscarPorId(id));
    }

    @Override
    public ResponseEntity<?> salvarProduto(SalvarProdutoRequestDto produto) {
        return new ResponseEntity<>(this.criarProdutoUsecase.executar(
                this.mapper.toProdutoEntity(produto)), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> atualizarProduto(AtualizarProdutoRequestDto produto) {
        return ResponseEntity.ok(this.alterarProdutoUsecase.executar(
                this.mapper.toProdutoEntity(produto)));
    }

    @Override
    public ResponseEntity<?> baixarProduto(BaixarProdutoRequestDto produto) {
        return ResponseEntity.ok(
                this.baixaEstoqueProdutoUsecase.executar(produto.id(), produto.quantidade())
        );
    }

    @Override
    public ResponseEntity<?> verificarProduto(VerificarProdutoRequestDto produto) {

        log.info(produto.toString());
        return ResponseEntity.ok(this.verificaDisponibilidadeProdutoUsecase.executar(
                produto.id(), produto.quantidade())
        );
    }
//
//    @Override
//    public ResponseEntity<?> deletarProduto(DeletarProdutoRequestDto produto) {
//        this.produtoUseCases.deletarProduto(produto.id());
//        return ResponseEntity.noContent().build();
//    }
}
