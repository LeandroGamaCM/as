package br.edu.ifba.as.entidades.analise;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class EscolaOrigem implements Serializable {
    
    private static final long serialVersionUID = 5812011160764247755L;
    
    @Id
    @GeneratedValue
    private Integer id;

    private String tipo;
    private Float pontuacao;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Float getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(Float pontuacao) {
        this.pontuacao = pontuacao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.id);
        hash = 23 * hash + Objects.hashCode(this.tipo);
        hash = 23 * hash + Objects.hashCode(this.pontuacao);
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
        final EscolaOrigem other = (EscolaOrigem) obj;
        if (!Objects.equals(this.tipo, other.tipo)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.pontuacao, other.pontuacao)) {
            return false;
        }
        return true;
    }
    
}
