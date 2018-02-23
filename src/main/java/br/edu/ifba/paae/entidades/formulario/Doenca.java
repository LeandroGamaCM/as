package br.edu.ifba.paae.entidades.formulario;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "doenca")
public class Doenca implements Serializable {
    private static final long serialVersionUID = -5599780096979180218L;

    @Id
    @GeneratedValue(generator = "fk_doenca_cod_aluno")
    @org.hibernate.annotations.GenericGenerator(name = "fk_doenca_cod_aluno", 
            strategy = "foreign", parameters = @org.hibernate.annotations.Parameter(name = "property", value = "familia"))
    @Column(name = "cod_familia")
    private Integer doenca;
       
    @OneToOne(mappedBy = "doenca")
    private Familia familia;
    
    @Column(name = "arquivo_doenca")
    private String arquivoDoenca;
    
    @Column(name = "possui_doenca")
    private Boolean possuiDoenca;
    
    private String doente;
    private String doencas;
    private String tratamento;


// Getters e Setters

    public Integer getDoenca() {
        return doenca;
    }

    public void setDoenca(Integer doenca) {
        this.doenca = doenca;
    }

    public Familia getFamilia() {
        return familia;
    }

    public void setFamilia(Familia familia) {
        this.familia = familia;
    }

    public String getArquivoDoenca() {
        return arquivoDoenca;
    }

    public void setArquivoDoenca(String arquivoDoenca) {
        this.arquivoDoenca = arquivoDoenca;
    }

    public Boolean getPossuiDoenca() {
        return possuiDoenca;
    }

    public void setPossuiDoenca(Boolean possuiDoenca) {
        this.possuiDoenca = possuiDoenca;
    }

    public String getDoente() {
        return doente;
    }

    public void setDoente(String doente) {
        this.doente = doente;
    }

    public String getDoencas() {
        return doencas;
    }

    public void setDoencas(String doencas) {
        this.doencas = doencas;
    }

    public String getTratamento() {
        return tratamento;
    }

    public void setTratamento(String tratamento) {
        this.tratamento = tratamento;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.doenca);
        hash = 17 * hash + Objects.hashCode(this.familia);
        hash = 17 * hash + Objects.hashCode(this.arquivoDoenca);
        hash = 17 * hash + Objects.hashCode(this.possuiDoenca);
        hash = 17 * hash + Objects.hashCode(this.doente);
        hash = 17 * hash + Objects.hashCode(this.doencas);
        hash = 17 * hash + Objects.hashCode(this.tratamento);
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
        final Doenca other = (Doenca) obj;
        if (!Objects.equals(this.arquivoDoenca, other.arquivoDoenca)) {
            return false;
        }
        if (!Objects.equals(this.doente, other.doente)) {
            return false;
        }
        if (!Objects.equals(this.doencas, other.doencas)) {
            return false;
        }
        if (!Objects.equals(this.tratamento, other.tratamento)) {
            return false;
        }
        if (!Objects.equals(this.doenca, other.doenca)) {
            return false;
        }
        if (!Objects.equals(this.familia, other.familia)) {
            return false;
        }
        if (!Objects.equals(this.possuiDoenca, other.possuiDoenca)) {
            return false;
        }
        return true;
    }
    
}
