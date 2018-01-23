package br.edu.ifba.paae.logica;

public class Parametro {
    private String categoria;
    private String aspectoAvaliacao;
    private Float pontuacao;
    private Float peso;

    
    public Float getPeso() {
        return peso;
    }

    public void setPeso(Float peso) {
        this.peso = peso;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Float getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(Float pontuacao) {
        this.pontuacao = pontuacao;
    }

    public String getAspectoAvaliacao() {
        return aspectoAvaliacao;
    }

    public void setAspectoAvaliacao(String aspectoAvaliacao) {
        this.aspectoAvaliacao = aspectoAvaliacao;
    }
    
    
    
}
