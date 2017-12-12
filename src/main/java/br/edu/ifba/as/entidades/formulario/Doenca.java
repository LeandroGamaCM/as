package br.edu.ifba.as.entidades.formulario;

import java.io.Serializable;
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


    public String getNomeDoenca() {
        return nomeDoenca;
    }

    public void setNomeDoenca(String nomeDoenca) {
        this.nomeDoenca = nomeDoenca;
    }
    
    
}
