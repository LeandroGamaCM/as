package br.edu.ifba.as.entidades.formulario;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "rendas")
public class Renda implements Serializable {
    private static final long serialVersionUID = -8022334389005626316L;
    
    @Id
    @GeneratedValue
    @Column(name = "cod_renda")
    private Integer renda;

    @ManyToOne
    @JoinColumn(name = "cod_familia")
    private Familia familia;
    
    @Column(name = "nome_renda")
    private String nomeRenda;
    @Column(name = "valor_renda")
    private Double valorRenda;

// Getters e Setters

    public Integer getRenda() {
        return renda;
    }

    public void setRenda(Integer renda) {
        this.renda = renda;
    }

    public Familia getFamilia() {
        return familia;
    }

    public void setFamilia(Familia familia) {
        this.familia = familia;
    }

    public String getNomeRenda() {
        return nomeRenda;
    }

    public void setNomeRenda(String nomeRenda) {
        this.nomeRenda = nomeRenda;
    }

    public Double getValorRenda() {
        return valorRenda;
    }

    public void setValorRenda(Double valorRenda) {
        this.valorRenda = valorRenda;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.renda);
        hash = 67 * hash + Objects.hashCode(this.familia);
        hash = 67 * hash + Objects.hashCode(this.nomeRenda);
        hash = 67 * hash + Objects.hashCode(this.valorRenda);
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
        final Renda other = (Renda) obj;
        if (!Objects.equals(this.nomeRenda, other.nomeRenda)) {
            return false;
        }
        if (!Objects.equals(this.renda, other.renda)) {
            return false;
        }
        if (!Objects.equals(this.familia, other.familia)) {
            return false;
        }
        if (!Objects.equals(this.valorRenda, other.valorRenda)) {
            return false;
        }
        return true;
    }
    
}
