package com.fiap;

public class Transacao {
    private int idTransacao;
    private String dsTransacao;
    private int cdCarteira;

    public int getIdTransacao() {
        return idTransacao;
    }

    public void setIdTransacao(int idTransacao) {
        this.idTransacao = idTransacao;
    }

    public String getDsTransacao() {
        return dsTransacao;
    }

    public void setDsTransacao(String dsTransacao) {
        this.dsTransacao = dsTransacao;
    }

    public int getCdCarteira() {
        return cdCarteira;
    }

    public void setCdCarteira(int cdCarteira) {
        this.cdCarteira = cdCarteira;
    }
}
