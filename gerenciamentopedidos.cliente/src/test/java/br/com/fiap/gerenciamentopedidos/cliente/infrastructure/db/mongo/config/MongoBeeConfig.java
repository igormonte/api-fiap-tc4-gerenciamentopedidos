package br.com.fiap.gerenciamentopedidos.cliente.infrastructure.db.mongo.config;

import com.github.mongobee.Mongobee;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.ConstructorBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("test")
@Configuration()
@ConfigurationProperties(prefix = "spring.data.mongodb")
public class MongoBeeConfig {

    private final String host;
    private final String port;
    private final String database;
    private final String username;
    private final String password;


    @ConstructorBinding
    public MongoBeeConfig(String host, String port, String database, String username, String password) {
        this.host = host;
        this.port = port;
        this.database = database;
        this.username = username;
        this.password = password;
    }

    @Bean
    public Mongobee mongobee(){
        Mongobee runner = new Mongobee(
                String.format("mongodb://%s:%s@%s:%s/%s",username, password, host, port, database));
        runner.setDbName(database);
        runner.setChangeLogsScanPackage(
                "br.com.fiap.gerenciamentopedidos.cliente.infrastructure.db.mongo.config");

        return runner;
    }

}
