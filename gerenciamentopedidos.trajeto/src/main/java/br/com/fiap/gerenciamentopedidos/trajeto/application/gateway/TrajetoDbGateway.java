package br.com.fiap.gerenciamentopedidos.trajeto.application.gateway;

import br.com.fiap.gerenciamentopedidos.trajeto.application.exception.TrajetoNaoEncontradoException;
import br.com.fiap.gerenciamentopedidos.trajeto.domain.entity.TrajetoEntity;
import br.com.fiap.gerenciamentopedidos.trajeto.domain.usecases.repository.TrajetoRepository;
import br.com.fiap.gerenciamentopedidos.trajeto.infrastructure.db.mongo.repository.TrajetoDbRepository;
import br.com.fiap.gerenciamentopedidos.trajeto.infrastructure.lib.mapstruct.mapper.TrajetoMapper;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;


public class TrajetoDbGateway implements TrajetoRepository {

    private final TrajetoDbRepository trajetoDbRepository;
    private final TrajetoMapper mapper;

    public TrajetoDbGateway(
            TrajetoDbRepository trajetoDbRepository,
            TrajetoMapper mapper) {
        this.trajetoDbRepository = trajetoDbRepository;
        this.mapper = mapper;
    }


    @Override
    public List<TrajetoEntity> buscarTrajetos() {
        return this.mapper.toTrajetoEntityList(this.trajetoDbRepository.findAll());
    }

    @Override
    public TrajetoEntity buscarTrajetoPorId(UUID id) {
        return this.mapper.toTrajetoEntity(this.trajetoDbRepository.findById(id)
                .orElseThrow(TrajetoNaoEncontradoException::new));
    }

    @Override
    @Transactional
    public TrajetoEntity salvarTrajeto(TrajetoEntity trajeto) {
        return this.mapper.toTrajetoEntity(this.trajetoDbRepository.save(
                this.mapper.toTrajetoDbEntity(trajeto)
        ));
    }

    @Override
    @Transactional
    public TrajetoEntity atualizarTrajeto(TrajetoEntity trajeto) {
        return this.mapper.toTrajetoEntity(this.trajetoDbRepository.save(
                this.mapper.toTrajetoDbEntity(trajeto)
        ));
    }

//    @Override
//    @Transactional
//    public Boolean deletarTrajeto(UUID id) {
//        this.trajetoDbRepository.deleteById(id);
//        return true;
//    }
}
