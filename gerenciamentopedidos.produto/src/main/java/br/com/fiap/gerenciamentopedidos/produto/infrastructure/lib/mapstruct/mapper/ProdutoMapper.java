package br.com.fiap.gerenciamentopedidos.produto.infrastructure.lib.mapstruct.mapper;

import br.com.fiap.gerenciamentopedidos.produto.application.dto.AtualizarProdutoRequestDto;
import br.com.fiap.gerenciamentopedidos.produto.application.dto.BaixarProdutoRequestDto;
import br.com.fiap.gerenciamentopedidos.produto.application.dto.SalvarProdutoRequestDto;
import br.com.fiap.gerenciamentopedidos.produto.application.dto.VerificarProdutoRequestDto;
import br.com.fiap.gerenciamentopedidos.produto.domain.entity.ProdutoEntity;
import br.com.fiap.gerenciamentopedidos.produto.infrastructure.db.mysql.entity.ProdutoDbEntity;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValueMappingStrategy;

import java.util.List;

@Mapper(
        componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValueIterableMappingStrategy = NullValueMappingStrategy.RETURN_NULL
)
public interface ProdutoMapper {
    ProdutoEntity toProdutoEntity(SalvarProdutoRequestDto salvarProdutoRequestDto);
    ProdutoEntity toProdutoEntity(AtualizarProdutoRequestDto atualizarProdutoRequestDto);
    ProdutoEntity toProdutoEntity(BaixarProdutoRequestDto baixarProdutoRequestDto);
    ProdutoEntity toProdutoEntity(VerificarProdutoRequestDto verificarProdutoRequestDto);
    ProdutoDbEntity toProdutoDbEntity(ProdutoEntity produtoEntity);
    ProdutoEntity toProdutoEntity(ProdutoDbEntity produtoDbEntity);
    List<ProdutoEntity> toProdutoEntityList(List<ProdutoDbEntity> produtoDbEntityList);
}
