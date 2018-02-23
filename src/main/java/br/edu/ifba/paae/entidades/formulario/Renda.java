package br.edu.ifba.paae.entidades.formulario;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "rendas")
public class Renda implements Serializable {
    private static final long serialVersionUID = -8022334389005626316L;
    
    @Id
    @GeneratedValue(generator = "fk_despesa_cod_aluno")
    @org.hibernate.annotations.GenericGenerator(name = "fk_despesa_cod_aluno", 
            strategy = "foreign", parameters = @org.hibernate.annotations.Parameter(name = "property", value = "familia"))
    @Column(name = "cod_familia")
    private Integer renda;
    
    @OneToOne(mappedBy = "renda")
    private Familia familia;
    
    // Variáveis fixas
    private Boolean aluguel;
    @Column(name = "valor_aluguel")
    private Double valorAluguel;
    
    @Column(name = "pensao_morte")
    private Boolean pensaoMorte;
    @Column(name = "valor_pensao_morte")
    private Double valorPensaoMorte;

    @Column(name = "pensao_alimenticia")
    private Boolean pensaoAlimenticia;
    @Column(name = "valor_pensao_alimenticia")
    private Double valorPensaoAlimenticia;
    
    private Boolean ajuda;
    @Column(name = "valor_ajuda")
    private Double valorAjuda;
    
    private Boolean outros;
    @Column(name = "valor_outros")
    private Double valorOutros;
    @Column(name = "nome_outros")
    private String nomeOutros;
    
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

    public Boolean getAluguel() {
        return aluguel;
    }

    public void setAluguel(Boolean aluguel) {
        this.aluguel = aluguel;
    }

    public Double getValorAluguel() {
        return valorAluguel;
    }

    public void setValorAluguel(Double valorAluguel) {
        this.valorAluguel = valorAluguel;
    }

    public Boolean getPensaoMorte() {
        return pensaoMorte;
    }

    public void setPensaoMorte(Boolean pensaoMorte) {
        this.pensaoMorte = pensaoMorte;
    }

    public Double getValorPensaoMorte() {
        return valorPensaoMorte;
    }

    public void setValorPensaoMorte(Double valorPensaoMorte) {
        this.valorPensaoMorte = valorPensaoMorte;
    }

    public Boolean getPensaoAlimenticia() {
        return pensaoAlimenticia;
    }

    public void setPensaoAlimenticia(Boolean pensaoAlimenticia) {
        this.pensaoAlimenticia = pensaoAlimenticia;
    }

    public Double getValorPensaoAlimenticia() {
        return valorPensaoAlimenticia;
    }

    public void setValorPensaoAlimenticia(Double valorPensaoAlimenticia) {
        this.valorPensaoAlimenticia = valorPensaoAlimenticia;
    }

    public Boolean getAjuda() {
        return ajuda;
    }

    public void setAjuda(Boolean ajuda) {
        this.ajuda = ajuda;
    }

    public Double getValorAjuda() {
        return valorAjuda;
    }

    public void setValorAjuda(Double valorAjuda) {
        this.valorAjuda = valorAjuda;
    }

    public Boolean getOutros() {
        return outros;
    }

    public void setOutros(Boolean outros) {
        this.outros = outros;
    }

    public Double getValorOutros() {
        return valorOutros;
    }

    public void setValorOutros(Double valorOutros) {
        this.valorOutros = valorOutros;
    }

    public String getNomeOutros() {
        return nomeOutros;
    }

    public void setNomeOutros(String nomeOutros) {
        this.nomeOutros = nomeOutros;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.renda);
        hash = 41 * hash + Objects.hashCode(this.familia);
        hash = 41 * hash + Objects.hashCode(this.aluguel);
        hash = 41 * hash + Objects.hashCode(this.valorAluguel);
        hash = 41 * hash + Objects.hashCode(this.pensaoMorte);
        hash = 41 * hash + Objects.hashCode(this.valorPensaoMorte);
        hash = 41 * hash + Objects.hashCode(this.pensaoAlimenticia);
        hash = 41 * hash + Objects.hashCode(this.valorPensaoAlimenticia);
        hash = 41 * hash + Objects.hashCode(this.ajuda);
        hash = 41 * hash + Objects.hashCode(this.valorAjuda);
        hash = 41 * hash + Objects.hashCode(this.outros);
        hash = 41 * hash + Objects.hashCode(this.valorOutros);
        hash = 41 * hash + Objects.hashCode(this.nomeOutros);
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
        if (!Objects.equals(this.nomeOutros, other.nomeOutros)) {
            return false;
        }
        if (!Objects.equals(this.renda, other.renda)) {
            return false;
        }
        if (!Objects.equals(this.familia, other.familia)) {
            return false;
        }
        if (!Objects.equals(this.aluguel, other.aluguel)) {
            return false;
        }
        if (!Objects.equals(this.valorAluguel, other.valorAluguel)) {
            return false;
        }
        if (!Objects.equals(this.pensaoMorte, other.pensaoMorte)) {
            return false;
        }
        if (!Objects.equals(this.valorPensaoMorte, other.valorPensaoMorte)) {
            return false;
        }
        if (!Objects.equals(this.pensaoAlimenticia, other.pensaoAlimenticia)) {
            return false;
        }
        if (!Objects.equals(this.valorPensaoAlimenticia, other.valorPensaoAlimenticia)) {
            return false;
        }
        if (!Objects.equals(this.ajuda, other.ajuda)) {
            return false;
        }
        if (!Objects.equals(this.valorAjuda, other.valorAjuda)) {
            return false;
        }
        if (!Objects.equals(this.outros, other.outros)) {
            return false;
        }
        if (!Objects.equals(this.valorOutros, other.valorOutros)) {
            return false;
        }
        return true;
    }

}
