// Obs: Não tem ENUM porque pode escolher mais de uma opção, então tem que ser boolean
package br.edu.ifba.as.entidades.formulario;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "codicao_manutencao")
public class CondicaoManutencao implements Serializable {
    private static final long serialVersionUID = 9132389850800664138L;
    
    @Id
    @GeneratedValue(generator = "fk_codicao_manutencao_cod_aluno")
    @org.hibernate.annotations.GenericGenerator(name = "fk_codicao_manutencao_cod_aluno",
            strategy = "foreign", parameters = @org.hibernate.annotations.Parameter(name = "property", value = "aluno"))
    @Column(name = "cod_aluno")
    private Integer condicaoManutencao;
    
    @OneToOne(mappedBy = "condicao_manutencao")
    private Aluno aluno;
    
    @Column(name = "ambos_pais")
    private Boolean ambosPais;
    
    @Column(name = "apenas_mae")
    private Boolean apenasMae;
    
    @Column(name = "apenas_pai")
    private Boolean apenasPai;
    
    private Boolean avos;
    
    @Column(name = "outros_parentes")
    private Boolean outrosParentes;
    
    private String parentesco;
    
    private Boolean outrosMeios;
    
    @Column(name = "nome_outros_meios")
    private String nomeOutrosMeios;

    public Integer getCondicaoManutencao() {
        return condicaoManutencao;
    }

    public void setCondicaoManutencao(Integer condicaoManutencao) {
        this.condicaoManutencao = condicaoManutencao;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public boolean isAmbosPais() {
        return ambosPais;
    }

    public void setAmbosPais(boolean ambosPais) {
        this.ambosPais = ambosPais;
    }

    public boolean isApenasMae() {
        return apenasMae;
    }

    public void setApenasMae(boolean apenasMae) {
        this.apenasMae = apenasMae;
    }

    public boolean isApenasPai() {
        return apenasPai;
    }

    public void setApenasPai(boolean apenasPai) {
        this.apenasPai = apenasPai;
    }

    public boolean isAvos() {
        return avos;
    }

    public void setAvos(boolean avos) {
        this.avos = avos;
    }

    public boolean isOutrosParentes() {
        return outrosParentes;
    }

    public void setOutrosParentes(boolean outrosParentes) {
        this.outrosParentes = outrosParentes;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    public boolean isOutrosMeios() {
        return outrosMeios;
    }

    public void setOutrosMeios(boolean outrosMeios) {
        this.outrosMeios = outrosMeios;
    }

    public String getNomeOutrosMeios() {
        return nomeOutrosMeios;
    }

    public void setNomeOutrosMeios(String nomeOutrosMeios) {
        this.nomeOutrosMeios = nomeOutrosMeios;
    }


    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.condicaoManutencao);
        hash = 23 * hash + Objects.hashCode(this.aluno);
        hash = 23 * hash + (this.ambosPais ? 1 : 0);
        hash = 23 * hash + (this.apenasMae ? 1 : 0);
        hash = 23 * hash + (this.apenasPai ? 1 : 0);
        hash = 23 * hash + (this.avos ? 1 : 0);
        hash = 23 * hash + (this.outrosParentes ? 1 : 0);
        hash = 23 * hash + Objects.hashCode(this.parentesco);
        hash = 23 * hash + Objects.hashCode(this.nomeOutrosMeios);
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
        final CondicaoManutencao other = (CondicaoManutencao) obj;
        if (this.ambosPais != other.ambosPais) {
            return false;
        }
        if (this.apenasMae != other.apenasMae) {
            return false;
        }
        if (this.apenasPai != other.apenasPai) {
            return false;
        }
        if (this.avos != other.avos) {
            return false;
        }
        if (this.outrosParentes != other.outrosParentes) {
            return false;
        }
        if (!Objects.equals(this.parentesco, other.parentesco)) {
            return false;
        }
        if (!Objects.equals(this.nomeOutrosMeios, other.nomeOutrosMeios)) {
            return false;
        }
        if (!Objects.equals(this.condicaoManutencao, other.condicaoManutencao)) {
            return false;
        }
        if (!Objects.equals(this.aluno, other.aluno)) {
            return false;
        }
        return true;
    }
    

}
