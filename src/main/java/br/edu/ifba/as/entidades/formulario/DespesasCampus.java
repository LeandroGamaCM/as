package br.edu.ifba.as.entidades.formulario;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "despesas_campus")
public class DespesasCampus implements Serializable {
    private static final long serialVersionUID = 1222823142607639503L;

    @Id
    @GeneratedValue(generator = "fk_despesas_campus_cod_aluno")
    @GenericGenerator(name = "fk_despesas_campus_cod_aluno", strategy = "foreign",
            parameters = @org.hibernate.annotations.Parameter(name = "property", value = "aluno"))
    @Column(name = "cod_aluno")
    private Integer despesasCampus;
    
    @OneToOne(mappedBy = "despesas_campus")
    private Aluno aluno;
    
    private Double alimentacao;
    private Double trabalhos;
    private Double materiaisEscolares;

    public Integer getDespesasCampus() {
        return despesasCampus;
    }

    public void setDespesasCampus(Integer despesasCampus) {
        this.despesasCampus = despesasCampus;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Double getAlimentacao() {
        return alimentacao;
    }

    public void setAlimentacao(Double alimentacao) {
        this.alimentacao = alimentacao;
    }

    public Double getTrabalhos() {
        return trabalhos;
    }

    public void setTrabalhos(Double trabalhos) {
        this.trabalhos = trabalhos;
    }

    public Double getMateriaisEscolares() {
        return materiaisEscolares;
    }

    public void setMateriaisEscolares(Double materiaisEscolares) {
        this.materiaisEscolares = materiaisEscolares;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + Objects.hashCode(this.despesasCampus);
        hash = 13 * hash + Objects.hashCode(this.aluno);
        hash = 13 * hash + Objects.hashCode(this.alimentacao);
        hash = 13 * hash + Objects.hashCode(this.trabalhos);
        hash = 13 * hash + Objects.hashCode(this.materiaisEscolares);
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
        final DespesasCampus other = (DespesasCampus) obj;
        if (!Objects.equals(this.despesasCampus, other.despesasCampus)) {
            return false;
        }
        if (!Objects.equals(this.aluno, other.aluno)) {
            return false;
        }
        if (!Objects.equals(this.alimentacao, other.alimentacao)) {
            return false;
        }
        if (!Objects.equals(this.trabalhos, other.trabalhos)) {
            return false;
        }
        if (!Objects.equals(this.materiaisEscolares, other.materiaisEscolares)) {
            return false;
        }
        return true;
    }

}
