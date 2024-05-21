package br.com.fiap.gerenciamentopedidos.trajeto.infrastructure.lib.mapstruct.mapper;

import br.com.fiap.gerenciamentopedidos.trajeto.application.dto.AtualizarTrajetoRequestDto;
import br.com.fiap.gerenciamentopedidos.trajeto.application.dto.SalvarTrajetoRequestDto;
import br.com.fiap.gerenciamentopedidos.trajeto.domain.entity.TrajetoEntity;
import br.com.fiap.gerenciamentopedidos.trajeto.infrastructure.db.mongo.entity.TrajetoDbEntity;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValueMappingStrategy;

import java.util.List;

@Mapper(
        componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValueIterableMappingStrategy = NullValueMappingStrategy.RETURN_NULL
)
public interface TrajetoMapper {
    TrajetoEntity toTrajetoEntity(SalvarTrajetoRequestDto salvarTrajetoRequestDto);
    TrajetoEntity toTrajetoEntity(AtualizarTrajetoRequestDto atualizarTrajetoRequestDto);
    TrajetoDbEntity toTrajetoDbEntity(TrajetoEntity trajetoEntity);
    TrajetoEntity toTrajetoEntity(TrajetoDbEntity trajetoDbEntity);
    List<TrajetoEntity> toTrajetoEntityList(List<TrajetoDbEntity> trajetoDbEntityList);
}
