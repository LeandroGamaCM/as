package br.edu.ifba.as.entidades.formulario;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "dependentes")
public class Dependentes implements Serializable {
    private static final long serialVersionUID = -5000468527155631421L;

    @Id
    @GeneratedValue(generator = "fk_dependentes_cod_aluno")
    @GenericGenerator(name = "fk_dependentes_cod_aluno", strategy = "foreign",
            parameters = @org.hibernate.annotations.Parameter(name = "property", value = "aluno"))
    @Column(name = "cod_aluno")
    private Integer dependentes;
    
    @OneToOne(mappedBy = "dependentes")
    private Aluno aluno;
    
    @Column(name = "possui_dependente")
    private Boolean possuiDependente;
    
    @Column(name = "outro_dependente")
    private String outroDependente;
    
    private Boolean filho;
    private Boolean companheiro;
    private Boolean idoso;
    private Boolean outro;

    public Integer getDependentes() {
        return dependentes;
    }

    public void setDependentes(Integer dependentes) {
        this.dependentes = dependentes;
    }

    public boolean isPossuiDependente() {
        return possuiDependente;
    }

    public void setPossuiDependente(boolean possuiDependente) {
        this.possuiDependente = possuiDependente;
    }

    public String getOutroDependente() {
        return outroDependente;
    }

    public void setOutroDependente(String outroDependente) {
        this.outroDependente = outroDependente;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.dependentes);
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
        final Dependentes other = (Dependentes) obj;
        if (!Objects.equals(this.dependentes, other.dependentes)) {
            return false;
        }
        return true;
    }
    
    
}
