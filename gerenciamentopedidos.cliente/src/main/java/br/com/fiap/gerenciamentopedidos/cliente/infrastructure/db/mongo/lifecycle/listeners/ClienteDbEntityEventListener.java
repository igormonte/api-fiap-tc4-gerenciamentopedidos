package br.com.fiap.gerenciamentopedidos.cliente.infrastructure.db.mongo.lifecycle.listeners;

import br.com.fiap.gerenciamentopedidos.cliente.infrastructure.db.mongo.ClienteDbEntity;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;

import java.util.UUID;

public class ClienteDbEntityEventListener extends AbstractMongoEventListener<ClienteDbEntity> {

    @Override
    public void onBeforeConvert(BeforeConvertEvent<ClienteDbEntity> event) {

        super.onBeforeConvert(event);
        ClienteDbEntity entity = event.getSource();

        if (entity.getId() == null) {
            entity.setId(UUID.randomUUID());
        }
    }
}