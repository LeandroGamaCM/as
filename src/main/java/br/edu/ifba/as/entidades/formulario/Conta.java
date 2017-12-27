package br.edu.ifba.as.entidades.formulario;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "conta")
public class Conta implements Serializable {
    private static final long serialVersionUID = 7379169277678191659L;

    @Id
    @GeneratedValue(generator = "fk_conta_cod_aluno")
    @org.hibernate.annotations.GenericGenerator(name = "fk_conta_cod_aluno", 
            strategy = "foreign", parameters = @org.hibernate.annotations.Parameter(name = "property", value = "aluno"))
    @Column(name = "cod_aluno")
    private Integer conta;
 
    @OneToOne(mappedBy = "conta")
    private Aluno aluno;
    
    @Column(name = "conta_corrente")
    private Integer contaCorrente;
    
    @Column(name = "pussui_conta")
    private Boolean PossuiConta;
    
    @Column(name = "nome_banco")
    private String nomeBanco;
    
// Pendentes -------------------------------------------------------------------    
// Isso não deve ser Integer?
    private String operacao;
    private String agencia;
// -----------------------------------------------------------------------------

// Getters e Setters    
    public Integer getConta() {
        return conta;
    }

    public void setConta(Integer conta) {
        this.conta = conta;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Integer getContaCorrente() {
        return contaCorrente;
    }

    public void setContaCorrente(Integer contaCorrente) {
        this.contaCorrente = contaCorrente;
    }

    public Boolean getPossuiConta() {
        return PossuiConta;
    }

    public void setPossuiConta(Boolean PossuiConta) {
        this.PossuiConta = PossuiConta;
    }

    public String getNomeBanco() {
        return nomeBanco;
    }

    public void setNomeBanco(String nomeBanco) {
        this.nomeBanco = nomeBanco;
    }

    public String getOperacao() {
        return operacao;
    }

    public void setOperacao(String operacao) {
        this.operacao = operacao;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.conta);
        hash = 89 * hash + Objects.hashCode(this.aluno);
        hash = 89 * hash + Objects.hashCode(this.contaCorrente);
        hash = 89 * hash + Objects.hashCode(this.PossuiConta);
        hash = 89 * hash + Objects.hashCode(this.nomeBanco);
        hash = 89 * hash + Objects.hashCode(this.operacao);
        hash = 89 * hash + Objects.hashCode(this.agencia);
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
        final Conta other = (Conta) obj;
        if (!Objects.equals(this.nomeBanco, other.nomeBanco)) {
            return false;
        }
        if (!Objects.equals(this.operacao, other.operacao)) {
            return false;
        }
        if (!Objects.equals(this.agencia, other.agencia)) {
            return false;
        }
        if (!Objects.equals(this.conta, other.conta)) {
            return false;
        }
        if (!Objects.equals(this.aluno, other.aluno)) {
            return false;
        }
        if (!Objects.equals(this.contaCorrente, other.contaCorrente)) {
            return false;
        }
        if (!Objects.equals(this.PossuiConta, other.PossuiConta)) {
            return false;
        }
        return true;
    }
    
}
