package br.edu.ifba.paae.entidades.inscricao;

import br.edu.ifba.paae.entidades.formulario.Aluno;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "periodo_inscricao")
public class PeriodoInscricao implements Serializable {
    
    private static final long serialVersionUID = 1905847621930897664L;
 
    @Id
    @GeneratedValue
    @Column(name = "cod_periodo_inscricao")
    private Integer id;
    
    @Column(unique = true)
    private Integer ano;
    
    private Boolean ativado;
    
    @OneToMany(cascade = CascadeType.DETACH)
    @JoinColumn(name = "cod_periodo_inscricao")    
    private List<Aluno> alunos;    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Boolean getAtivado() {
        return ativado;
    }

    public void setAtivado(Boolean ativado) {
        this.ativado = ativado;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 11 * hash + Objects.hashCode(this.id);
        hash = 11 * hash + Objects.hashCode(this.ano);
        hash = 11 * hash + Objects.hashCode(this.ativado);
        hash = 11 * hash + Objects.hashCode(this.alunos);
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
        final PeriodoInscricao other = (PeriodoInscricao) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.ano, other.ano)) {
            return false;
        }
        if (!Objects.equals(this.ativado, other.ativado)) {
            return false;
        }
        if (!Objects.equals(this.alunos, other.alunos)) {
            return false;
        }
        return true;
    }
    
}
