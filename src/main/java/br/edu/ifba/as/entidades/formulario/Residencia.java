// Pertence a Aluno por hora
package br.edu.ifba.as.entidades.formulario;

import br.edu.ifba.as.entidades.enums.Cobertura;
import br.edu.ifba.as.entidades.enums.Piso;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "residencia")
public class Residencia implements Serializable {
    private static final long serialVersionUID = 2673495976497133404L;

    @Id
    @GeneratedValue(generator = "fk_residencia_cod_aluno")
    @org.hibernate.annotations.GenericGenerator(name = "fk_residencia_cod_aluno", 
            strategy = "foreign", parameters = @org.hibernate.annotations.Parameter(name = "property", value = "aluno"))
    @Column(name = "cod_aluno")
    private Integer residencia;
    
    @OneToOne(mappedBy = "residencia")
    private Aluno aluno;

    private Boolean acabamento;
    private Boolean redeEsgoto;
    private Boolean fossa;
    private Boolean banheiro;
    private Boolean chuveiro;
    private Boolean agua;
    private Boolean luz;
    private Integer qtdeComodos;
    
    @Enumerated
    @Column(columnDefinition = "smallint")
    private Piso piso;
    
    @Enumerated
    @Column(columnDefinition = "smallint")
    private Cobertura cobertura;

    public Integer getResidencia() {
        return residencia;
    }

    public void setResidencia(Integer residencia) {
        this.residencia = residencia;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Boolean getAcabamento() {
        return acabamento;
    }

    public void setAcabamento(Boolean acabamento) {
        this.acabamento = acabamento;
    }

    public Boolean getRedeEsgoto() {
        return redeEsgoto;
    }

    public void setRedeEsgoto(Boolean redeEsgoto) {
        this.redeEsgoto = redeEsgoto;
    }

    public Boolean getFossa() {
        return fossa;
    }

    public void setFossa(Boolean fossa) {
        this.fossa = fossa;
    }

    public Boolean getBanheiro() {
        return banheiro;
    }

    public void setBanheiro(Boolean banheiro) {
        this.banheiro = banheiro;
    }

    public Boolean getChuveiro() {
        return chuveiro;
    }

    public void setChuveiro(Boolean chuveiro) {
        this.chuveiro = chuveiro;
    }

    public Boolean getAgua() {
        return agua;
    }

    public void setAgua(Boolean agua) {
        this.agua = agua;
    }

    public Boolean getLuz() {
        return luz;
    }

    public void setLuz(Boolean luz) {
        this.luz = luz;
    }

    public Integer getQtdeComodos() {
        return qtdeComodos;
    }

    public void setQtdeComodos(Integer qtdeComodos) {
        this.qtdeComodos = qtdeComodos;
    }

    public Piso getPiso() {
        return piso;
    }

    public void setPiso(Piso piso) {
        this.piso = piso;
    }

    public Cobertura getCobertura() {
        return cobertura;
    }

    public void setCobertura(Cobertura cobertura) {
        this.cobertura = cobertura;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.residencia);
        hash = 67 * hash + Objects.hashCode(this.aluno);
        hash = 67 * hash + Objects.hashCode(this.acabamento);
        hash = 67 * hash + Objects.hashCode(this.redeEsgoto);
        hash = 67 * hash + Objects.hashCode(this.fossa);
        hash = 67 * hash + Objects.hashCode(this.banheiro);
        hash = 67 * hash + Objects.hashCode(this.chuveiro);
        hash = 67 * hash + Objects.hashCode(this.agua);
        hash = 67 * hash + Objects.hashCode(this.luz);
        hash = 67 * hash + Objects.hashCode(this.qtdeComodos);
        hash = 67 * hash + Objects.hashCode(this.piso);
        hash = 67 * hash + Objects.hashCode(this.cobertura);
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
        final Residencia other = (Residencia) obj;
        if (!Objects.equals(this.residencia, other.residencia)) {
            return false;
        }
        if (!Objects.equals(this.aluno, other.aluno)) {
            return false;
        }
        if (!Objects.equals(this.acabamento, other.acabamento)) {
            return false;
        }
        if (!Objects.equals(this.redeEsgoto, other.redeEsgoto)) {
            return false;
        }
        if (!Objects.equals(this.fossa, other.fossa)) {
            return false;
        }
        if (!Objects.equals(this.banheiro, other.banheiro)) {
            return false;
        }
        if (!Objects.equals(this.chuveiro, other.chuveiro)) {
            return false;
        }
        if (!Objects.equals(this.agua, other.agua)) {
            return false;
        }
        if (!Objects.equals(this.luz, other.luz)) {
            return false;
        }
        if (!Objects.equals(this.qtdeComodos, other.qtdeComodos)) {
            return false;
        }
        if (this.piso != other.piso) {
            return false;
        }
        if (this.cobertura != other.cobertura) {
            return false;
        }
        return true;
    }
    
}
