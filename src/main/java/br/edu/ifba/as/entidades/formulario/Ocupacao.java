// Pendentes -------------------------------------------------------------------
// tempoServico em anos
package br.edu.ifba.as.entidades.formulario;

import br.edu.ifba.as.entidades.enums.Trabalho;
import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "ocupacao")
public class Ocupacao implements Serializable {
    private static final long serialVersionUID = 4689830156998464707L;

    @Id
    @GeneratedValue(generator = "fk_ocupacao_cod_aluno")
    @org.hibernate.annotations.GenericGenerator(name = "fk_ocupacao_cod_aluno", 
            strategy = "foreign", parameters = @org.hibernate.annotations.Parameter(name = "property", value = "aluno"))
    @Column(name = "cod_aluno")
    private Integer ocupacao;
    
    @OneToOne(mappedBy = "ocupacao")
    private Aluno aluno;
    
    @Enumerated
    @Column(columnDefinition = "smallint")
    private Trabalho trabalho;

    @Column(name = "telefone_empregador")
    private Integer telefoneEmpregador;
    
    @Column(name = "possui_trabalho")
    private Boolean possuiTrabalho;

    private String profissao;

    @Column(name = "nome_empregador")
    private String nomeEmpregador;
    
    @Column(name = "possui_estagio")
    private boolean possuiEstagio;

    @Column(name = "instituicao_estagio")
    private String instiruicaoEstagio;
    
    @Column(name = "salario_mensal")
    private Double salarioMensal;
    

    @Column(name = "tempo_servico")
    private Float tempoServico;

    public Integer getOcupacao() {
        return ocupacao;
    }

    public void setOcupacao(Integer ocupacao) {
        this.ocupacao = ocupacao;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Integer getTelefoneEmpregador() {
        return telefoneEmpregador;
    }

    public void setTelefoneEmpregador(Integer telefoneEmpregador) {
        this.telefoneEmpregador = telefoneEmpregador;
    }

    public boolean isPossuiTrabalho() {
        return possuiTrabalho;
    }

    public void setPossuiTrabalho(boolean possuiTrabalho) {
        this.possuiTrabalho = possuiTrabalho;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public String getNomeEmpregador() {
        return nomeEmpregador;
    }

    public void setNomeEmpregador(String nomeEmpregador) {
        this.nomeEmpregador = nomeEmpregador;
    }

    public boolean isPossuiEstagio() {
        return possuiEstagio;
    }

    public void setPossuiEstagio(boolean possuiEstagio) {
        this.possuiEstagio = possuiEstagio;
    }

    public String getInstiruicaoEstagio() {
        return instiruicaoEstagio;
    }

    public void setInstiruicaoEstagio(String instiruicaoEstagio) {
        this.instiruicaoEstagio = instiruicaoEstagio;
    }

    public Double getSalarioMensal() {
        return salarioMensal;
    }

    public void setSalarioMensal(Double salarioMensal) {
        this.salarioMensal = salarioMensal;
    }

    public Float getTempoServico() {
        return tempoServico;
    }

    public void setTempoServico(Float tempoServico) {
        this.tempoServico = tempoServico;
    }


}
