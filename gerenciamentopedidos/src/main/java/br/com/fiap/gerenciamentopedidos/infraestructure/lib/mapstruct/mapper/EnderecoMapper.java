package br.com.fiap.gerenciamentopedidos.infraestructure.lib.mapstruct.mapper;

import br.com.fiap.gerenciamentopedidos.application.dto.CriarPedidoRequestDto;
import br.com.fiap.gerenciamentopedidos.domain.entity.EnderecoEntity;
import br.com.fiap.gerenciamentopedidos.domain.entity.PedidoEntity;
import br.com.fiap.gerenciamentopedidos.domain.usecases.repository.TrajetoRepository;
import br.com.fiap.gerenciamentopedidos.infraestructure.gerenciamentopedidos.cliente.dto.ClienteResponseDto;
import br.com.fiap.gerenciamentopedidos.infraestructure.gerenciamentopedidos.trajeto.dto.CriarTrajetoRequestDto;
import br.com.fiap.gerenciamentopedidos.infraestructure.mysql.entity.EnderecoDbEntity;
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
public interface EnderecoMapper {
    EnderecoEntity toEnderecoEntity(EnderecoDbEntity enderecoDbEntity);
    EnderecoEntity toEnderecoEntity(ClienteResponseDto.EnderecoCliente enderecoCliente);
    CriarTrajetoRequestDto.EnderecoEntrega toEnderecoEntrega(EnderecoEntity enderecoEntity);
    List<PedidoEntity> toPedidoEntityList(List<PedidoDbEntity> pedidoDbEntityList);
}
