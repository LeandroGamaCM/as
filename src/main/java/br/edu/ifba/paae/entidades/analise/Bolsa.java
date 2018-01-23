package br.edu.ifba.paae.entidades.analise;

import br.edu.ifba.paae.entidades.formulario.Aluno;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "bolsa")
public class Bolsa implements Serializable {
    private static final long serialVersionUID = 7002438588384815278L;

    @Id
    @GeneratedValue
    @Column(name = "cod_bolsa")
    private Integer bolsa;
    
    private String nome;
    private Double valor;
    private Integer qtddDistribuida;
    
    @OneToMany(mappedBy = "bolsa", fetch = FetchType.LAZY)
    private List<Aluno> alunos;

    public Integer getBolsa() {
        return bolsa;
    }

    public void setBolsa(Integer bolsa) {
        this.bolsa = bolsa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Integer getQtddDistribuida() {
        return qtddDistribuida;
    }

    public void setQtddDistribuida(Integer qtddDistribuida) {
        this.qtddDistribuida = qtddDistribuida;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.bolsa);
        hash = 67 * hash + Objects.hashCode(this.nome);
        hash = 67 * hash + Objects.hashCode(this.valor);
        hash = 67 * hash + Objects.hashCode(this.qtddDistribuida);
        hash = 67 * hash + Objects.hashCode(this.alunos);
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
        final Bolsa other = (Bolsa) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.bolsa, other.bolsa)) {
            return false;
        }
        if (!Objects.equals(this.valor, other.valor)) {
            return false;
        }
        if (!Objects.equals(this.qtddDistribuida, other.qtddDistribuida)) {
            return false;
        }
        if (!Objects.equals(this.alunos, other.alunos)) {
            return false;
        }
        return true;
    }

}
