package com.fiap;
 
import java.time.LocalDate;

public class Transacao {
    private double valor;
    // hierarquia possivel
    private String descricao;
    private LocalDate data;

    // Construtor padrão
    public Transacao() {
        // Inicializa a data como a data atual
        this.data = LocalDate.now();
    }

    // Métodos setters para definir os valores dos atributos
    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    // Métodos getters para obter os valores dos atributos
    public double getValor() {
        return valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDate getData() {
        return data;
    }
}
