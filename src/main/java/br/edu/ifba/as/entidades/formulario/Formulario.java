package br.edu.ifba.as.entidades.formulario;

import br.edu.ifba.as.entidades.enums.Preferencia;
import java.io.Serializable;
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
    
    private Preferencia preferencia;
    
// Pendentes -------------------------------------------------------------------
// Ano pega o ano atual no automatico
    private int ano;
    
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

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.formulario);
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
        if (!Objects.equals(this.formulario, other.formulario)) {
            return false;
        }
        return true;
    }

    
}
