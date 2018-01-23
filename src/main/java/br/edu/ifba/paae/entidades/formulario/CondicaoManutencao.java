// Obs: Não tem ENUM porque pode escolher mais de uma opção, então tem que ser boolean
package br.edu.ifba.paae.entidades.formulario;

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

    public Boolean getAmbosPais() {
        return ambosPais;
    }

    public void setAmbosPais(Boolean ambosPais) {
        this.ambosPais = ambosPais;
    }

    public Boolean getApenasMae() {
        return apenasMae;
    }

    public void setApenasMae(Boolean apenasMae) {
        this.apenasMae = apenasMae;
    }

    public Boolean getApenasPai() {
        return apenasPai;
    }

    public void setApenasPai(Boolean apenasPai) {
        this.apenasPai = apenasPai;
    }

    public Boolean getAvos() {
        return avos;
    }

    public void setAvos(Boolean avos) {
        this.avos = avos;
    }

    public Boolean getOutrosParentes() {
        return outrosParentes;
    }

    public void setOutrosParentes(Boolean outrosParentes) {
        this.outrosParentes = outrosParentes;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    public Boolean getOutrosMeios() {
        return outrosMeios;
    }

    public void setOutrosMeios(Boolean outrosMeios) {
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
        hash = 17 * hash + Objects.hashCode(this.condicaoManutencao);
        hash = 17 * hash + Objects.hashCode(this.aluno);
        hash = 17 * hash + Objects.hashCode(this.ambosPais);
        hash = 17 * hash + Objects.hashCode(this.apenasMae);
        hash = 17 * hash + Objects.hashCode(this.apenasPai);
        hash = 17 * hash + Objects.hashCode(this.avos);
        hash = 17 * hash + Objects.hashCode(this.outrosParentes);
        hash = 17 * hash + Objects.hashCode(this.parentesco);
        hash = 17 * hash + Objects.hashCode(this.outrosMeios);
        hash = 17 * hash + Objects.hashCode(this.nomeOutrosMeios);
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
        if (!Objects.equals(this.ambosPais, other.ambosPais)) {
            return false;
        }
        if (!Objects.equals(this.apenasMae, other.apenasMae)) {
            return false;
        }
        if (!Objects.equals(this.apenasPai, other.apenasPai)) {
            return false;
        }
        if (!Objects.equals(this.avos, other.avos)) {
            return false;
        }
        if (!Objects.equals(this.outrosParentes, other.outrosParentes)) {
            return false;
        }
        if (!Objects.equals(this.outrosMeios, other.outrosMeios)) {
            return false;
        }
        return true;
    }
    
}
