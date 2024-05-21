package br.com.fiap.gerenciamentopedidos.trajeto.infrastructure.gerenciamentopedidos.pedido;

import br.com.fiap.gerenciamentopedidos.trajeto.infrastructure.gerenciamentopedidos.pedido.dto.FinalizarPedidoRequestDto;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.http.dsl.Http;
import org.springframework.messaging.MessageChannel;
import org.springframework.validation.annotation.Validated;

@Slf4j
@Validated
@Configuration
@ConfigurationProperties(prefix = "gerenciamentopedidos.pedido")
public class PedidoConfig {

    @NotNull
    private String url;

    public void setUrl(String url) {
        this.url = url;
    }

    @Bean
    public MessageChannel finalizaPedido() {
        DirectChannel directChannel = new DirectChannel();
        directChannel.setFailover(false);
        return directChannel;
    }

    @Bean
    public IntegrationFlow finalizaPedidoFlow() {
        return IntegrationFlow.from("finalizaPedido")
                .handle(Http.outboundGateway(String.format("%s/finalizar",this.url))
                        .charset("UTF-8")
                        .extractResponseBody(false)
                        .expectedResponseType(Boolean.class)
                        .httpMethod(HttpMethod.PUT))
                .log().bridge()
                .get();
    }
}
