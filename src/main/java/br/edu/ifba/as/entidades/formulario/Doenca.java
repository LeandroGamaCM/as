package br.edu.ifba.as.entidades.formulario;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "doenca")
public class Doenca implements Serializable {
    private static final long serialVersionUID = -5599780096979180218L;


    @Id
    @GeneratedValue
    @Column(name = "cod_doenca")
    private Integer doenca;
    
    @ManyToOne
    @JoinColumn(name = "cod_membro_familiar")
    private MembroFamiliar membro_familiar;    
    
    @Column(name = "nome_doenca")
    private String nomeDoenca;

    public Integer getDoenca() {
        return doenca;
    }

    public void setDoenca(Integer doenca) {
        this.doenca = doenca;
    }

    public MembroFamiliar getMembro_familiar() {
        return membro_familiar;
    }

    public void setMembro_familiar(MembroFamiliar membro_familiar) {
        this.membro_familiar = membro_familiar;
    }

    public String getNomeDoenca() {
        return nomeDoenca;
    }

    public void setNomeDoenca(String nomeDoenca) {
        this.nomeDoenca = nomeDoenca;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 73 * hash + Objects.hashCode(this.doenca);
        hash = 73 * hash + Objects.hashCode(this.membro_familiar);
        hash = 73 * hash + Objects.hashCode(this.nomeDoenca);
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
        final Doenca other = (Doenca) obj;
        if (!Objects.equals(this.nomeDoenca, other.nomeDoenca)) {
            return false;
        }
        if (!Objects.equals(this.doenca, other.doenca)) {
            return false;
        }
        if (!Objects.equals(this.membro_familiar, other.membro_familiar)) {
            return false;
        }
        return true;
    }

}
