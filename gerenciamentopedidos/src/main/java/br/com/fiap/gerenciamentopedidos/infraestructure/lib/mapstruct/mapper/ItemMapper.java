package br.com.fiap.gerenciamentopedidos.infraestructure.lib.mapstruct.mapper;

import br.com.fiap.gerenciamentopedidos.domain.entity.ItemEntity;
import br.com.fiap.gerenciamentopedidos.infraestructure.gerenciamentopedidos.produto.dto.ProdutoResponseDto;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValueMappingStrategy;

import java.util.List;

@Mapper(
        componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValueIterableMappingStrategy = NullValueMappingStrategy.RETURN_NULL
)
public interface ItemMapper {

    @Mapping(target = "idProduto", source = "id")
    @Mapping(target = "nomeProduto", source = "descricao")
    @Mapping(target = "valor", source = "precoUnitario")
    @Mapping(target = "quantidade", ignore = true)
    @Mapping(target = "id", ignore = true)
    ItemEntity toItemEntity(ProdutoResponseDto produtoResponseDto);

}
