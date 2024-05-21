package br.com.fiap.gerenciamentopedidos.cliente.infrastructure.db.mongo.config;

import com.github.mongobee.changeset.ChangeLog;
import com.github.mongobee.changeset.ChangeSet;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.time.LocalDate;

@ChangeLog
public class ChangeLogs {

    @ChangeSet(order = "001", id = "cliente1", author = "testeIntegracao")
    public void insertData(MongoDatabase db) {
        MongoCollection<Document> mycollection = db.getCollection("cliente");
        Document doc = new Document("nome", "Juscelino Rodrigues da Silva")
                .append("cpf", "725.862.340-06")
                .append("dataNascimento", LocalDate.of(1990,3,5))
                .append("email", "juscelino.silva@exemplo.com.br")
                .append("telefone", "19999999999")                ;
        mycollection.insertOne(doc);
    }

    @ChangeSet(order = "002", id = "cliente2", author = "testeIntegracao")
    public void insertData2(MongoDatabase db) {
        MongoCollection<Document> mycollection = db.getCollection("cliente");
        Document doc = new Document("nome", "Paulo Rodrigues da Silva")
                .append("cpf", "906.160.940-27")
                .append("dataNascimento", LocalDate.of(1981,5,23))
                .append("email", "paulo.silva@exemplo.com.br")
                .append("telefone", "19999999999")                ;
        mycollection.insertOne(doc);
    }
}
