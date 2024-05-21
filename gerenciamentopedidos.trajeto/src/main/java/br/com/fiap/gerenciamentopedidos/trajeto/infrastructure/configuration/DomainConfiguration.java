package br.com.fiap.gerenciamentopedidos.trajeto.infrastructure.configuration;

import br.com.fiap.gerenciamentopedidos.trajeto.domain.usecases.*;
import br.com.fiap.gerenciamentopedidos.trajeto.domain.usecases.repository.PedidoRepository;
import br.com.fiap.gerenciamentopedidos.trajeto.domain.usecases.repository.TrajetoRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DomainConfiguration {

    @Bean
    public AlterarTrajetoUsecase getAlterarTrajetoUsecase (TrajetoRepository trajetoRepository){
        return new AlterarTrajetoUsecaseImpl(trajetoRepository);
    }
    @Bean
    public ConsultaTrajetoUsecase getConsultaTrajetoUsecase (TrajetoRepository trajetoRepository){
        return new ConsultaTrajetoUsecaseImpl(trajetoRepository);
    }
    @Bean
    public CriarTrajetoUsecase getCriarTrajetoUsecase (TrajetoRepository trajetoRepository){
        return new CriarTrajetoUsecaseImpl(trajetoRepository);
    }
    @Bean
    public FinalizarTrajetoUsecase getFinalizarTrajetoUsecase (
            TrajetoRepository trajetoRepository,
            PedidoRepository pedidoRepository){
        return new FinalizarTrajetoUsecaseImpl(trajetoRepository, pedidoRepository);
    }

}
