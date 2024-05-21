package br.com.fiap.gerenciamentopedidos.produto.domain.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

public class ProdutoEntity {

    private UUID id;
    private String descricao;
    private String categoria;
    private UnidadeMedida unidadeMedida;
    private BigDecimal saldoQuantidade;
    private BigDecimal precoUnitario;
    private BigDecimal taxaAplicada;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public UnidadeMedida getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida(UnidadeMedida unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

    public BigDecimal getSaldoQuantidade() {
        return saldoQuantidade;
    }

    public void setSaldoQuantidade(BigDecimal saldoQuantidade) {
        this.saldoQuantidade = saldoQuantidade;
    }

    public BigDecimal getPrecoUnitario() {
        return precoUnitario.add(precoUnitario.multiply(
                taxaAplicada != null && taxaAplicada.doubleValue() != 0?
                        BigDecimal.valueOf(taxaAplicada.doubleValue()/100)
                        : BigDecimal.ZERO));
    }

    public void setPrecoUnitario(BigDecimal precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public BigDecimal getTaxaAplicada() {
        return taxaAplicada;
    }

    public void setTaxaAplicada(BigDecimal taxaAplicada) {

        if(taxaAplicada == null || taxaAplicada.compareTo(BigDecimal.ZERO) < 0) {
            this.taxaAplicada = BigDecimal.ONE;
        }

        this.taxaAplicada = taxaAplicada;
    }

    public Boolean verificarDisponibilidade(BigDecimal quantidade) {

        if(quantidade.compareTo(BigDecimal.ZERO) < 0 ) {
            throw new RuntimeException("Não pode ser baixada quantidade de um produto.");
        }

        if(saldoQuantidade.compareTo(quantidade) < 0) {
            throw new RuntimeException(
                    String.format("Não é possível baixar saldo, diferença de saldo: %f",
                            saldoQuantidade.subtract(quantidade).doubleValue()));
        }

        return true;

    }

    public Boolean baixarSaldo(BigDecimal quantidade) {

        if(!verificarDisponibilidade(quantidade)) {
            throw new RuntimeException("Estoque não disponível para a operação desejada.");
        }

        saldoQuantidade = saldoQuantidade.subtract(quantidade);

        return true;
    }

}
