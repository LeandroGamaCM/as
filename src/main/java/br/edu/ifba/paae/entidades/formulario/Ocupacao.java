package br.edu.ifba.paae.entidades.formulario;

import java.io.Serializable;
import java.util.Arrays;
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
    
    @Column(name = "arquivo_ocupacao", length = 1048576)
    private byte[] arquivoOcupacao;
    
    @Column(name = "arquivo_ocupacao_nome")
    private String arquivoOcupacaoNome;
    
    private String trabalho;
    
    @Column(name = "situacao_ocupacional")
    private String situacaoOcupacional;

    @Column(name = "telefone_empregador")
    private String telefoneEmpregador;

    private String profissao;

    @Column(name = "nome_empregador")
    private String nomeEmpregador;
    
    @Column(name = "possui_estagio")
    private Boolean possuiEstagio;

    @Column(name = "instituicao_estagio")
    private String instiruicaoEstagio;
    
    @Column(name = "salario_mensal")
    private Double salarioMensal;
    

    @Column(name = "tempo_servico")
    private String tempoServico;

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

    public byte[] getArquivoOcupacao() {
        return arquivoOcupacao;
    }

    public void setArquivoOcupacao(byte[] arquivoOcupacao) {
        this.arquivoOcupacao = arquivoOcupacao;
    }

    public String getArquivoOcupacaoNome() {
        return arquivoOcupacaoNome;
    }

    public void setArquivoOcupacaoNome(String arquivoOcupacaoNome) {
        this.arquivoOcupacaoNome = arquivoOcupacaoNome;
    }

    public String getTrabalho() {
        return trabalho;
    }

    public void setTrabalho(String trabalho) {
        this.trabalho = trabalho;
    }

    public String getSituacaoOcupacional() {
        return situacaoOcupacional;
    }

    public void setSituacaoOcupacional(String situacaoOcupacional) {
        this.situacaoOcupacional = situacaoOcupacional;
    }

    public String getTelefoneEmpregador() {
        return telefoneEmpregador;
    }

    public void setTelefoneEmpregador(String telefoneEmpregador) {
        this.telefoneEmpregador = telefoneEmpregador;
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

    public Boolean getPossuiEstagio() {
        return possuiEstagio;
    }

    public void setPossuiEstagio(Boolean possuiEstagio) {
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

    public String getTempoServico() {
        return tempoServico;
    }

    public void setTempoServico(String tempoServico) {
        this.tempoServico = tempoServico;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.ocupacao);
        hash = 79 * hash + Objects.hashCode(this.aluno);
        hash = 79 * hash + Arrays.hashCode(this.arquivoOcupacao);
        hash = 79 * hash + Objects.hashCode(this.arquivoOcupacaoNome);
        hash = 79 * hash + Objects.hashCode(this.trabalho);
        hash = 79 * hash + Objects.hashCode(this.situacaoOcupacional);
        hash = 79 * hash + Objects.hashCode(this.telefoneEmpregador);
        hash = 79 * hash + Objects.hashCode(this.profissao);
        hash = 79 * hash + Objects.hashCode(this.nomeEmpregador);
        hash = 79 * hash + Objects.hashCode(this.possuiEstagio);
        hash = 79 * hash + Objects.hashCode(this.instiruicaoEstagio);
        hash = 79 * hash + Objects.hashCode(this.salarioMensal);
        hash = 79 * hash + Objects.hashCode(this.tempoServico);
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
        if (!Objects.equals(this.arquivoOcupacaoNome, other.arquivoOcupacaoNome)) {
            return false;
        }
        if (!Objects.equals(this.trabalho, other.trabalho)) {
            return false;
        }
        if (!Objects.equals(this.situacaoOcupacional, other.situacaoOcupacional)) {
            return false;
        }
        if (!Objects.equals(this.telefoneEmpregador, other.telefoneEmpregador)) {
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
        if (!Objects.equals(this.tempoServico, other.tempoServico)) {
            return false;
        }
        if (!Objects.equals(this.ocupacao, other.ocupacao)) {
            return false;
        }
        if (!Objects.equals(this.aluno, other.aluno)) {
            return false;
        }
        if (!Arrays.equals(this.arquivoOcupacao, other.arquivoOcupacao)) {
            return false;
        }
        if (!Objects.equals(this.possuiEstagio, other.possuiEstagio)) {
            return false;
        }
        if (!Objects.equals(this.salarioMensal, other.salarioMensal)) {
            return false;
        }
        return true;
    }
    
}
