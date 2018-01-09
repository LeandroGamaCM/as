package br.edu.ifba.as.entidades.analise;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Etinia implements Serializable {
    
    private static final long serialVersionUID = 7267587698198734844L;
 
    @Id
    @GeneratedValue
    private String tipo;
    private Integer pontuacao;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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
        hash = 61 * hash + Objects.hashCode(this.tipo);
        hash = 61 * hash + Objects.hashCode(this.pontuacao);
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
        final Etinia other = (Etinia) obj;
        if (!Objects.equals(this.tipo, other.tipo)) {
            return false;
        }
        if (!Objects.equals(this.pontuacao, other.pontuacao)) {
            return false;
        }
        return true;
    }
    
    
}
