// PROBLEMA Turma: , como vai saber as turmas? ---------------------------------

package br.edu.ifba.as.entidades.formulario;

import br.edu.ifba.as.entidades.enums.Curso;
import br.edu.ifba.as.entidades.enums.OndeEstudou;
import br.edu.ifba.as.entidades.enums.Turno;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.*;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "informacoes_curriculares")
public class InformacoesCurriculares implements Serializable {

    private static final long serialVersionUID = -7293200050453865237L;
    
    @Id
    @GeneratedValue(generator = "fk_informacoes_curriculares_cod_aluno")
    @org.hibernate.annotations.GenericGenerator(name = "fk_informacoes_curriculares_cod_aluno", 
            strategy = "foreign", parameters = @Parameter(name = "property", value = "aluno"))
    @Column(name = "cod_aluno")
    private Integer informacoesCurriculares;
    
    @OneToOne(mappedBy = "informacoes_curriculares")
    private Aluno aluno;    
    
    @Enumerated
    @Column(columnDefinition = "smallint")
    private OndeEstudou ondeEstudou;
    
    @Column(name = "curso_preparatorio")
    private Boolean cursoPreparatorio;
    
    @Column(name = "interrupcao_estudos")
    private Boolean interrupcaoEstudos;
    
    @Column(name = "nome_curso_preparatorio")
    private String nomeCursoPreparatorio;
    
    @Column(name = "motivo_interrupcao")
    private String motivoInterrupcao;

    @Column(name = "data_interrupcao")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataInterrupcao;
    
    @Column(name = "tempo_interrupcao")
    private float tempoInterrupcao;

// Getters e Setters

    public Integer getInformacoesCurriculares() {
        return informacoesCurriculares;
    }

    public void setInformacoesCurriculares(Integer informacoesCurriculares) {
        this.informacoesCurriculares = informacoesCurriculares;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public OndeEstudou getOndeEstudou() {
        return ondeEstudou;
    }

    public void setOndeEstudou(OndeEstudou ondeEstudou) {
        this.ondeEstudou = ondeEstudou;
    }

    public Boolean getCursoPreparatorio() {
        return cursoPreparatorio;
    }

    public void setCursoPreparatorio(Boolean cursoPreparatorio) {
        this.cursoPreparatorio = cursoPreparatorio;
    }

    public Boolean getInterrupcaoEstudos() {
        return interrupcaoEstudos;
    }

    public void setInterrupcaoEstudos(Boolean interrupcaoEstudos) {
        this.interrupcaoEstudos = interrupcaoEstudos;
    }

    public String getNomeCursoPreparatorio() {
        return nomeCursoPreparatorio;
    }

    public void setNomeCursoPreparatorio(String nomeCursoPreparatorio) {
        this.nomeCursoPreparatorio = nomeCursoPreparatorio;
    }

    public String getMotivoInterrupcao() {
        return motivoInterrupcao;
    }

    public void setMotivoInterrupcao(String motivoInterrupcao) {
        this.motivoInterrupcao = motivoInterrupcao;
    }

    public Date getDataInterrupcao() {
        return dataInterrupcao;
    }

    public void setDataInterrupcao(Date dataInterrupcao) {
        this.dataInterrupcao = dataInterrupcao;
    }

    public float getTempoInterrupcao() {
        return tempoInterrupcao;
    }

    public void setTempoInterrupcao(float tempoInterrupcao) {
        this.tempoInterrupcao = tempoInterrupcao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.informacoesCurriculares);
        hash = 13 * hash + Objects.hashCode(this.aluno);
        hash = 13 * hash + Objects.hashCode(this.ondeEstudou);
        hash = 13 * hash + Objects.hashCode(this.cursoPreparatorio);
        hash = 13 * hash + Objects.hashCode(this.interrupcaoEstudos);
        hash = 13 * hash + Objects.hashCode(this.nomeCursoPreparatorio);
        hash = 13 * hash + Objects.hashCode(this.motivoInterrupcao);
        hash = 13 * hash + Objects.hashCode(this.dataInterrupcao);
        hash = 13 * hash + Float.floatToIntBits(this.tempoInterrupcao);
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
        final InformacoesCurriculares other = (InformacoesCurriculares) obj;
        if (Float.floatToIntBits(this.tempoInterrupcao) != Float.floatToIntBits(other.tempoInterrupcao)) {
            return false;
        }
        if (!Objects.equals(this.nomeCursoPreparatorio, other.nomeCursoPreparatorio)) {
            return false;
        }
        if (!Objects.equals(this.motivoInterrupcao, other.motivoInterrupcao)) {
            return false;
        }
        if (!Objects.equals(this.informacoesCurriculares, other.informacoesCurriculares)) {
            return false;
        }
        if (!Objects.equals(this.aluno, other.aluno)) {
            return false;
        }
        if (this.ondeEstudou != other.ondeEstudou) {
            return false;
        }
        if (!Objects.equals(this.cursoPreparatorio, other.cursoPreparatorio)) {
            return false;
        }
        if (!Objects.equals(this.interrupcaoEstudos, other.interrupcaoEstudos)) {
            return false;
        }
        if (!Objects.equals(this.dataInterrupcao, other.dataInterrupcao)) {
            return false;
        }
        return true;
    }

}
