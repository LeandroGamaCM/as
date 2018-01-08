package br.edu.ifba.as.entidades.analise;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class RendaAnalise implements Serializable {

    private static final long serialVersionUID = -6433321397718064935L;
    
    @Id
    @GeneratedValue
    private Integer id;
    
    private Double valorMinimo;
    private Double valorMaximo;
    private Integer pontuacao;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getValorMinimo() {
        return valorMinimo;
    }

    public void setValorMinimo(Double valorMinimo) {
        this.valorMinimo = valorMinimo;
    }

    public Double getValorMaximo() {
        return valorMaximo;
    }

    public void setValorMaximo(Double valorMaximo) {
        this.valorMaximo = valorMaximo;
    }

    public Integer getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(Integer pontuacao) {
        this.pontuacao = pontuacao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.id);
        hash = 47 * hash + Objects.hashCode(this.valorMinimo);
        hash = 47 * hash + Objects.hashCode(this.valorMaximo);
        hash = 47 * hash + Objects.hashCode(this.pontuacao);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final RendaAnalise other = (RendaAnalise) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.valorMinimo, other.valorMinimo)) {
            return false;
        }
        if (!Objects.equals(this.valorMaximo, other.valorMaximo)) {
            return false;
        }
        if (!Objects.equals(this.pontuacao, other.pontuacao)) {
            return false;
        }
        return true;
    }
    
}
