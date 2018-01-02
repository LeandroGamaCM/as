package br.edu.ifba.as.entidades.formulario;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "formulario")
public class Formulario implements Serializable {
    private static final long serialVersionUID = -1537645181959996845L;

    @Id
    @GeneratedValue(generator = "fk_formulario_cod_aluno")
    @org.hibernate.annotations.GenericGenerator(name = "fk_formulario_cod_aluno", 
            strategy = "foreign", parameters = @org.hibernate.annotations.Parameter(name = "property", value = "aluno"))
    @Column(name = "cod_aluno")
    private Integer formulario;
    
    @OneToOne(mappedBy = "formulario")
    private Aluno aluno;
    
    private String esclarecimentos;

    @Column(name = "primeira_preferencia")
    private String primeiraPreferencia;

    @Column(name = "segunda_preferencia")
    private String segundaPreferencia;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "data_inscricao", updatable = false)
    private Date dataInscricao;
    
    
// Getters e Setters

    public Integer getFormulario() {
        return formulario;
    }

    public void setFormulario(Integer formulario) {
        this.formulario = formulario;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public String getEsclarecimentos() {
        return esclarecimentos;
    }

    public void setEsclarecimentos(String esclarecimentos) {
        this.esclarecimentos = esclarecimentos;
    }

    public String getPrimeiraPreferencia() {
        return primeiraPreferencia;
    }

    public void setPrimeiraPreferencia(String primeiraPreferencia) {
        this.primeiraPreferencia = primeiraPreferencia;
    }

    public String getSegundaPreferencia() {
        return segundaPreferencia;
    }

    public void setSegundaPreferencia(String segundaPreferencia) {
        this.segundaPreferencia = segundaPreferencia;
    }

    public Date getDataInscricao() {
        return dataInscricao;
    }

    public void setDataInscricao(Date dataInscricao) {
        this.dataInscricao = dataInscricao;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.formulario);
        hash = 83 * hash + Objects.hashCode(this.aluno);
        hash = 83 * hash + Objects.hashCode(this.esclarecimentos);
        hash = 83 * hash + Objects.hashCode(this.primeiraPreferencia);
        hash = 83 * hash + Objects.hashCode(this.segundaPreferencia);
        hash = 83 * hash + Objects.hashCode(this.dataInscricao);
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
        final Formulario other = (Formulario) obj;
        if (!Objects.equals(this.esclarecimentos, other.esclarecimentos)) {
            return false;
        }
        if (!Objects.equals(this.primeiraPreferencia, other.primeiraPreferencia)) {
            return false;
        }
        if (!Objects.equals(this.segundaPreferencia, other.segundaPreferencia)) {
            return false;
        }
        if (!Objects.equals(this.formulario, other.formulario)) {
            return false;
        }
        if (!Objects.equals(this.aluno, other.aluno)) {
            return false;
        }
        if (!Objects.equals(this.dataInscricao, other.dataInscricao)) {
            return false;
        }
        return true;
    }

}
