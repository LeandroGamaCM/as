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

    public boolean isProgramaExtensao() {
        return programaExtensao;
    }

    public void setProgramaExtensao(boolean programaExtensao) {
        this.programaExtensao = programaExtensao;
    }

    public boolean isPibid() {
        return pibid;
    }

    public void setPibid(boolean pibid) {
        this.pibid = pibid;
    }

    public boolean isMonitoria() {
        return monitoria;
    }

    public void setMonitoria(boolean monitoria) {
        this.monitoria = monitoria;
    }

    public boolean isPibic() {
        return pibic;
    }

    public void setPibic(boolean pibic) {
        this.pibic = pibic;
    }

    public boolean isPibicjr() {
        return pibicjr;
    }

    public void setPibicjr(boolean pibicjr) {
        this.pibicjr = pibicjr;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.bolsaAuxilio);
        hash = 97 * hash + (this.programaExtensao ? 1 : 0);
        hash = 97 * hash + (this.pibid ? 1 : 0);
        hash = 97 * hash + (this.monitoria ? 1 : 0);
        hash = 97 * hash + (this.pibic ? 1 : 0);
        hash = 97 * hash + (this.pibicjr ? 1 : 0);
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
        if (this.programaExtensao != other.programaExtensao) {
            return false;
        }
        if (this.pibid != other.pibid) {
            return false;
        }
        if (this.monitoria != other.monitoria) {
            return false;
        }
        if (this.pibic != other.pibic) {
            return false;
        }
        if (this.pibicjr != other.pibicjr) {
            return false;
        }
        if (!Objects.equals(this.bolsaAuxilio, other.bolsaAuxilio)) {
            return false;
        }
        return true;
    }
    
}
