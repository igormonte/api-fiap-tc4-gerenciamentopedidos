package br.com.fiap.gerenciamentopedidos.trajeto.infrastructure.db.mongo.listeners;

import br.com.fiap.gerenciamentopedidos.trajeto.infrastructure.db.mongo.entity.TrajetoDbEntity;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;

import java.util.UUID;

public class TrajetoDbEntityEventListener extends AbstractMongoEventListener<TrajetoDbEntity> {

    @Override
    public void onBeforeConvert(BeforeConvertEvent<TrajetoDbEntity> event) {

        super.onBeforeConvert(event);
        TrajetoDbEntity entity = event.getSource();

        if (entity.getId() == null) {
            entity.setId(UUID.randomUUID());
        }
    }
}