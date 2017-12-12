// PROBLEMA Turma: , como vai saber as turmas? ---------------------------------

package br.edu.ifba.as.entidades.formulario;

import br.edu.ifba.as.entidades.enums.Curso;
import br.edu.ifba.as.entidades.enums.OndeEstudou;
import br.edu.ifba.as.entidades.enums.Turno;
import java.io.Serializable;
import java.util.Date;
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
    
    @Enumerated
    @Column(columnDefinition = "smallint")
    private Turno turno;

    @Enumerated
    @Column(columnDefinition = "smallint")
    private Curso curso;
    
    @Column(name = "curso_preparatorio")
    private Boolean cursoPreparatorio;
    
    @Column(name = "interrupcao_estudos")
    private Boolean interrupcaoEstudos;
    
    @Column(name = "nome_curso_preparatorio")
    private String nomeCursoPreparatorio;
    
    @Column(name = "motivo_interrupcao")
    private String motivoInterrupcao;

// DATA ------------------------------------------------------------------------    
    @Column(name = "data_interrupcao")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataInterrupcao;
    
    @Column(name = "tempo_interrupcao")
    private float tempoInterrupcao;



    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public boolean isCursoPreparatorio() {
        return cursoPreparatorio;
    }

    public void setCursoPreparatorio(boolean cursoPreparatorio) {
        this.cursoPreparatorio = cursoPreparatorio;
    }

    public boolean isInterrupcaoEstudos() {
        return interrupcaoEstudos;
    }

    public void setInterrupcaoEstudos(boolean interrupcaoEstudos) {
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

    
}
