package br.edu.ifba.as.entidades.analise;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class RendaPerCapita implements Serializable {

    private static final long serialVersionUID = -6433321397718064935L;
    
    @Id
    @GeneratedValue
    private Integer id;
    
    private Double limite;
    private Integer pontuacao;

    
    public Integer getId() {
        return id;
    }

    public Double getLimite() {
        return limite;
    }

    public void setLimite(Double limite) {
        this.limite = limite;
    }

    public Integer getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(Integer pontuacao) {
        this.pontuacao = pontuacao;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.id);
        hash = 29 * hash + Objects.hashCode(this.limite);
        hash = 29 * hash + Objects.hashCode(this.pontuacao);
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
        final RendaPerCapita other = (RendaPerCapita) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.limite, other.limite)) {
            return false;
        }
        if (!Objects.equals(this.pontuacao, other.pontuacao)) {
            return false;
        }
        return true;
    }

}
