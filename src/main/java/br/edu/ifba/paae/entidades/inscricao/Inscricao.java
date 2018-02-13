package br.edu.ifba.paae.entidades.inscricao;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Inscricao implements Serializable {
    
    private static final long serialVersionUID = 7215480693707276912L;
    
    @Id
    @GeneratedValue
    private Integer id;
    private Boolean periodoInscricao;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getPeriodoInscricao() {
        return periodoInscricao;
    }

    public void setPeriodoInscricao(Boolean periodoInscricao) {
        this.periodoInscricao = periodoInscricao;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.id);
        hash = 17 * hash + Objects.hashCode(this.periodoInscricao);
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
        final Inscricao other = (Inscricao) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.periodoInscricao, other.periodoInscricao)) {
            return false;
        }
        return true;
    }
    
}
