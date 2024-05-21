package br.com.fiap.gerenciamentopedidos.infraestructure.gerenciamentopedidos.produto;

import br.com.fiap.gerenciamentopedidos.domain.entity.ItemEntity;
import br.com.fiap.gerenciamentopedidos.infraestructure.gerenciamentopedidos.produto.dto.ProdutoResponseDto;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.http.dsl.Http;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.validation.annotation.Validated;

@Slf4j
@Validated
@Configuration
@ConfigurationProperties(prefix = "gerenciamentopedidos.produto")
public class ProdutoConfig {

    @NotNull
    private String url;

    public void setUrl(String url) {
        this.url = url;
    }

    @Bean
    public MessageChannel consultaProduto() {
        DirectChannel directChannel = new DirectChannel();
        directChannel.setFailover(false);
        return directChannel;
    }

    @Bean
    public MessageChannel baixaProduto() {
        DirectChannel directChannel = new DirectChannel();
        directChannel.setFailover(false);
        return directChannel;
    }

    @Bean
    public MessageChannel disponibilidadeProduto() {
        DirectChannel directChannel = new DirectChannel();
        directChannel.setFailover(false);
        return directChannel;
    }

    @Bean
    public IntegrationFlow consultaProdutoFlow() {
        return IntegrationFlow.from("consultaProduto")
                .handle(
                    Http.outboundGateway( h-> String.format("%s?id={id}",this.url))
                        .uriVariable("id", Message::getPayload)
                        .charset("UTF-8")
                        .extractResponseBody(false)
                        .expectedResponseType(ProdutoResponseDto.class)
                        .httpMethod(HttpMethod.GET))
                .log().bridge()
                .get();
    }
    @Bean
    public IntegrationFlow baixaProdutoFlow() {
        log.info(String.format("%s/baixar",this.url));
        return IntegrationFlow.from("baixaProduto")
                .handle(Http.outboundGateway(String.format("%s/baixar",this.url))
                    .charset("UTF-8")
                    .extractResponseBody(false)
                    .expectedResponseType(Boolean.class)
                    .httpMethod(HttpMethod.PUT))
                .log().bridge()
                .get();
    }
    @Bean
    public IntegrationFlow disponibilidadeProdutoFlow() {
        return IntegrationFlow.from("disponibilidadeProduto")
                .handle(
                    Http.outboundGateway(String.format("%s/disponibilidade",this.url))
                        .charset("UTF-8")
                        .extractResponseBody(false)
                        .expectedResponseType(Boolean.class)
                        .httpMethod(HttpMethod.POST))
                .log().bridge()
                .get();
    }

}
