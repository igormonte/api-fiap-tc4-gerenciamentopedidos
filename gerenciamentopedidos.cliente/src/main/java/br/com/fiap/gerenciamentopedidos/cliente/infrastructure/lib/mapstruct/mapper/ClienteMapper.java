package br.com.fiap.gerenciamentopedidos.cliente.infrastructure.lib.mapstruct.mapper;

import br.com.fiap.gerenciamentopedidos.cliente.application.dto.AtualizarClienteRequestDto;
import br.com.fiap.gerenciamentopedidos.cliente.application.dto.SalvarClienteRequestDto;
import br.com.fiap.gerenciamentopedidos.cliente.domain.entity.ClienteEntity;
import br.com.fiap.gerenciamentopedidos.cliente.infrastructure.db.mongo.ClienteDbEntity;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValueMappingStrategy;

import java.util.List;

@Mapper(
        componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValueIterableMappingStrategy = NullValueMappingStrategy.RETURN_NULL
)
public interface ClienteMapper {
    ClienteEntity toClienteEntity(SalvarClienteRequestDto salvarClienteRequestDto);
    ClienteEntity toClienteEntity(AtualizarClienteRequestDto atualizarClienteRequestDto);
    ClienteDbEntity toClienteDbEntity(ClienteEntity clienteEntity);
    ClienteEntity toClienteEntity(ClienteDbEntity clienteDbEntity);
    List<ClienteEntity> toClienteEntityList(List<ClienteDbEntity> clienteDbEntityList);
}
