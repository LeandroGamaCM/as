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
    private Integer quantos;

    public Integer getQuantos() {
        return quantos;
    }

    public void setQuantos(Integer quantos) {
        this.quantos = quantos;
    }

    public Integer getDependentes() {
        return dependentes;
    }

    public void setDependentes(Integer dependentes) {
        this.dependentes = dependentes;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Boolean getPossuiDependente() {
        return possuiDependente;
    }

    public void setPossuiDependente(Boolean possuiDependente) {
        this.possuiDependente = possuiDependente;
    }

    public String getOutroDependente() {
        return outroDependente;
    }

    public void setOutroDependente(String outroDependente) {
        this.outroDependente = outroDependente;
    }

    public Boolean getFilho() {
        return filho;
    }

    public void setFilho(Boolean filho) {
        this.filho = filho;
    }

    public Boolean getCompanheiro() {
        return companheiro;
    }

    public void setCompanheiro(Boolean companheiro) {
        this.companheiro = companheiro;
    }

    public Boolean getIdoso() {
        return idoso;
    }

    public void setIdoso(Boolean idoso) {
        this.idoso = idoso;
    }

    public Boolean getOutro() {
        return outro;
    }

    public void setOutro(Boolean outro) {
        this.outro = outro;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.dependentes);
        hash = 71 * hash + Objects.hashCode(this.aluno);
        hash = 71 * hash + Objects.hashCode(this.possuiDependente);
        hash = 71 * hash + Objects.hashCode(this.outroDependente);
        hash = 71 * hash + Objects.hashCode(this.filho);
        hash = 71 * hash + Objects.hashCode(this.companheiro);
        hash = 71 * hash + Objects.hashCode(this.idoso);
        hash = 71 * hash + Objects.hashCode(this.outro);
        hash = 71 * hash + Objects.hashCode(this.quantos);
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
        if (!Objects.equals(this.outroDependente, other.outroDependente)) {
            return false;
        }
        if (!Objects.equals(this.dependentes, other.dependentes)) {
            return false;
        }
        if (!Objects.equals(this.aluno, other.aluno)) {
            return false;
        }
        if (!Objects.equals(this.possuiDependente, other.possuiDependente)) {
            return false;
        }
        if (!Objects.equals(this.filho, other.filho)) {
            return false;
        }
        if (!Objects.equals(this.companheiro, other.companheiro)) {
            return false;
        }
        if (!Objects.equals(this.idoso, other.idoso)) {
            return false;
        }
        if (!Objects.equals(this.outro, other.outro)) {
            return false;
        }
        if (!Objects.equals(this.quantos, other.quantos)) {
            return false;
        }
        return true;
    }


}
