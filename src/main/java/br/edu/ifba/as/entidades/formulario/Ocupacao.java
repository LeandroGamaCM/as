// Pendentes -------------------------------------------------------------------
// tempoServico em anos
package br.edu.ifba.as.entidades.formulario;

import java.io.Serializable;
import java.util.Objects;
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
    
    private String trabalho;

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

// Getters e Setters

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

    public String getTrabalho() {
        return trabalho;
    }

    public void setTrabalho(String trabalho) {
        this.trabalho = trabalho;
    }

    public Integer getTelefoneEmpregador() {
        return telefoneEmpregador;
    }

    public void setTelefoneEmpregador(Integer telefoneEmpregador) {
        this.telefoneEmpregador = telefoneEmpregador;
    }

    public Boolean getPossuiTrabalho() {
        return possuiTrabalho;
    }

    public void setPossuiTrabalho(Boolean possuiTrabalho) {
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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.ocupacao);
        hash = 37 * hash + Objects.hashCode(this.aluno);
        hash = 37 * hash + Objects.hashCode(this.trabalho);
        hash = 37 * hash + Objects.hashCode(this.telefoneEmpregador);
        hash = 37 * hash + Objects.hashCode(this.possuiTrabalho);
        hash = 37 * hash + Objects.hashCode(this.profissao);
        hash = 37 * hash + Objects.hashCode(this.nomeEmpregador);
        hash = 37 * hash + (this.possuiEstagio ? 1 : 0);
        hash = 37 * hash + Objects.hashCode(this.instiruicaoEstagio);
        hash = 37 * hash + Objects.hashCode(this.salarioMensal);
        hash = 37 * hash + Objects.hashCode(this.tempoServico);
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
        final Ocupacao other = (Ocupacao) obj;
        if (this.possuiEstagio != other.possuiEstagio) {
            return false;
        }
        if (!Objects.equals(this.trabalho, other.trabalho)) {
            return false;
        }
        if (!Objects.equals(this.profissao, other.profissao)) {
            return false;
        }
        if (!Objects.equals(this.nomeEmpregador, other.nomeEmpregador)) {
            return false;
        }
        if (!Objects.equals(this.instiruicaoEstagio, other.instiruicaoEstagio)) {
            return false;
        }
        if (!Objects.equals(this.ocupacao, other.ocupacao)) {
            return false;
        }
        if (!Objects.equals(this.aluno, other.aluno)) {
            return false;
        }
        if (!Objects.equals(this.telefoneEmpregador, other.telefoneEmpregador)) {
            return false;
        }
        if (!Objects.equals(this.possuiTrabalho, other.possuiTrabalho)) {
            return false;
        }
        if (!Objects.equals(this.salarioMensal, other.salarioMensal)) {
            return false;
        }
        if (!Objects.equals(this.tempoServico, other.tempoServico)) {
            return false;
        }
        return true;
    }

}
