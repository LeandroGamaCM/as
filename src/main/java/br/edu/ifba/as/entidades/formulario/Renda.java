package br.edu.ifba.as.entidades.formulario;

import java.io.Serializable;
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

    
    
    
}
