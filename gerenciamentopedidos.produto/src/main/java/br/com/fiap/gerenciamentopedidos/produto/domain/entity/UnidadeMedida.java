package br.com.fiap.gerenciamentopedidos.produto.domain.entity;

public enum UnidadeMedida {
    UN("UNIDADE"),
    CX("CAIXA"),
    SC("SACO"),
    G("GRAMA"),
    KG("KILOGRAMA"),
    T("TONELADA");

    private String valor;

    UnidadeMedida(String unidade) {
        this.valor = unidade;
    }

    String getValor() {
        return this.valor;
    }

}
