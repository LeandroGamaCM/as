package br.edu.ifba.as.entidades.formulario;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "bolsas_auxilio")
public class BolsasAuxilio implements Serializable {
    private static final long serialVersionUID = 4459533419932124028L;

    @Id
    @GeneratedValue(generator = "fk_bolsas_auxilio_cod_aluno")
    @org.hibernate.annotations.GenericGenerator(name = "fk_bolsas_auxilio_cod_aluno", 
            strategy = "foreign", parameters = @org.hibernate.annotations.Parameter(name = "property", value = "aluno"))
    @Column(name = "cod_aluno")
    private Integer bolsaAuxilio;
    
    @OneToOne(mappedBy = "bolsas_auxilio")
    private Aluno aluno;    
    
    @Column(name = "programa_extensao")
    private Boolean programaExtensao;

    private Boolean pibid;
    private Boolean monitoria;
    private Boolean pibic;
    private Boolean pibicjr;

    public Integer getBolsaAuxilio() {
        return bolsaAuxilio;
    }

    public void setBolsaAuxilio(Integer bolsaAuxilio) {
        this.bolsaAuxilio = bolsaAuxilio;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Boolean getProgramaExtensao() {
        return programaExtensao;
    }

    public void setProgramaExtensao(Boolean programaExtensao) {
        this.programaExtensao = programaExtensao;
    }

    public Boolean getPibid() {
        return pibid;
    }

    public void setPibid(Boolean pibid) {
        this.pibid = pibid;
    }

    public Boolean getMonitoria() {
        return monitoria;
    }

    public void setMonitoria(Boolean monitoria) {
        this.monitoria = monitoria;
    }

    public Boolean getPibic() {
        return pibic;
    }

    public void setPibic(Boolean pibic) {
        this.pibic = pibic;
    }

    public Boolean getPibicjr() {
        return pibicjr;
    }

    public void setPibicjr(Boolean pibicjr) {
        this.pibicjr = pibicjr;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.bolsaAuxilio);
        hash = 79 * hash + Objects.hashCode(this.aluno);
        hash = 79 * hash + Objects.hashCode(this.programaExtensao);
        hash = 79 * hash + Objects.hashCode(this.pibid);
        hash = 79 * hash + Objects.hashCode(this.monitoria);
        hash = 79 * hash + Objects.hashCode(this.pibic);
        hash = 79 * hash + Objects.hashCode(this.pibicjr);
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
        final BolsasAuxilio other = (BolsasAuxilio) obj;
        if (!Objects.equals(this.bolsaAuxilio, other.bolsaAuxilio)) {
            return false;
        }
        if (!Objects.equals(this.aluno, other.aluno)) {
            return false;
        }
        if (!Objects.equals(this.programaExtensao, other.programaExtensao)) {
            return false;
        }
        if (!Objects.equals(this.pibid, other.pibid)) {
            return false;
        }
        if (!Objects.equals(this.monitoria, other.monitoria)) {
            return false;
        }
        if (!Objects.equals(this.pibic, other.pibic)) {
            return false;
        }
        if (!Objects.equals(this.pibicjr, other.pibicjr)) {
            return false;
        }
        return true;
    }

    
}
