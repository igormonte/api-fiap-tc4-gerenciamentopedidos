package br.com.fiap.gerenciamentopedidos.infraestructure.lib.mapstruct.mapper;

import br.com.fiap.gerenciamentopedidos.application.dto.CriarPedidoRequestDto;
import br.com.fiap.gerenciamentopedidos.domain.entity.PedidoEntity;
import br.com.fiap.gerenciamentopedidos.infraestructure.mysql.entity.PedidoDbEntity;
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
public interface PedidoMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "dataCriacao", ignore = true)
    PedidoEntity toPedidoEntity(CriarPedidoRequestDto criarPedidoRequestDto);
//    PedidoEntity toPedidoEntity(AtualizarPedidoRequestDto atualizarPedidoRequestDto);
    PedidoDbEntity toPedidoDbEntity(PedidoEntity pedidoEntity);
    PedidoEntity toPedidoEntity(PedidoDbEntity pedidoDbEntity);
    List<PedidoEntity> toPedidoEntityList(List<PedidoDbEntity> pedidoDbEntityList);
}
