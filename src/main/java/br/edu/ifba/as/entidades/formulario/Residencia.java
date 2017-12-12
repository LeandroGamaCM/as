// Pertence a Aluno por hora
package br.edu.ifba.as.entidades.formulario;

import br.edu.ifba.as.entidades.enums.Cobertura;
import br.edu.ifba.as.entidades.enums.Piso;
import java.io.Serializable;
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
    

    

    
}
