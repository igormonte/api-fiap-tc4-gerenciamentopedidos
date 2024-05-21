package br.com.fiap.gerenciamentopedidos.produto.infrastructure.configuration;

import br.com.fiap.gerenciamentopedidos.produto.domain.usecases.*;
import br.com.fiap.gerenciamentopedidos.produto.domain.usecases.repository.ProdutoRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DomainConfiguration {

    @Bean
    public AlterarProdutoUsecase getAlterarProdutoUsecase (ProdutoRepository produtoRepository){
        return new AlterarProdutoUsecaseImpl(produtoRepository);
    }
    @Bean
    public BaixaEstoqueProdutoUsecase getBaixaEstoqueProdutoUsecase (ProdutoRepository produtoRepository){
        return new BaixaEstoqueProdutoUsecaseImpl(produtoRepository);
    }
    @Bean
    public ConsultaProdutoUsecase getConsultaProdutoUsecase (ProdutoRepository produtoRepository){
        return new ConsultaProdutoUsecaseImpl(produtoRepository);
    }
    @Bean
    public CriarProdutoUsecase getCriarProdutoUsecase (ProdutoRepository produtoRepository){
        return new CriarProdutoUsecaseImpl(produtoRepository);
    }
    @Bean
    public VerificaDisponibilidadeProdutoUsecase getVerificaDisponibilidadeProdutoUsecase (ProdutoRepository produtoRepository){
        return new VerificaDisponibilidadeProdutoUsecaseImpl(produtoRepository);
    }

}
