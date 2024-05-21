package br.com.fiap.gerenciamentopedidos.produto.application.gateway;

import br.com.fiap.gerenciamentopedidos.produto.application.exception.ProdutoNaoEncontradoException;
import br.com.fiap.gerenciamentopedidos.produto.domain.entity.ProdutoEntity;
import br.com.fiap.gerenciamentopedidos.produto.domain.usecases.repository.ProdutoRepository;
import br.com.fiap.gerenciamentopedidos.produto.infrastructure.db.mysql.repository.ProdutoDbRepository;
import br.com.fiap.gerenciamentopedidos.produto.infrastructure.lib.mapstruct.mapper.ProdutoMapper;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;


public class ProdutoDbGateway implements ProdutoRepository {

    private final ProdutoDbRepository produtoDbRepository;
    private final ProdutoMapper mapper;

    public ProdutoDbGateway(
            ProdutoDbRepository produtoDbRepository,
            ProdutoMapper mapper) {
        this.produtoDbRepository = produtoDbRepository;
        this.mapper = mapper;
    }


    @Override
    public List<ProdutoEntity> buscarProdutos() {
        return this.mapper.toProdutoEntityList(this.produtoDbRepository.findAll());
    }

    @Override
    public ProdutoEntity buscarProdutoPorId(UUID id) {
        return this.mapper.toProdutoEntity(this.produtoDbRepository.findById(id)
                .orElseThrow(ProdutoNaoEncontradoException::new));
    }

    @Override
    @Transactional
    public ProdutoEntity salvarProduto(ProdutoEntity produto) {
        return this.mapper.toProdutoEntity(this.produtoDbRepository.save(
                this.mapper.toProdutoDbEntity(produto)
        ));
    }

    @Override
    @Transactional
    public ProdutoEntity atualizarProduto(ProdutoEntity produto) {
        return this.mapper.toProdutoEntity(this.produtoDbRepository.save(
                this.mapper.toProdutoDbEntity(produto)
        ));
    }

//    @Override
//    @Transactional
//    public Boolean deletarProduto(UUID id) {
//        this.produtoDbRepository.deleteById(id);
//        return true;
//    }
}
