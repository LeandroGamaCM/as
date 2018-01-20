// Duvida: Podde ter mais de um programa social?
package br.edu.ifba.as.entidades.formulario;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "familia")
public class Familia implements Serializable {
    private static final long serialVersionUID = -6669602436921306537L;

    private double rendaFamiliarTotal;

    @Id
    @GeneratedValue(generator = "fk_familia_cod_aluno")
    @GenericGenerator(name = "fk_familia_cod_aluno", strategy = "foreign",
            parameters = @org.hibernate.annotations.Parameter(name = "property", value = "aluno"))
    @Column(name = "cod_aluno")
    private Integer familia;
    
    @OneToOne(mappedBy = "familia")
    private Aluno aluno;
    
    @Column(name = "possui_programa_social")
    private Boolean possuiProgramaSocial;

    @Column(name = "possui_gestante")
    private Boolean possuiGestante;
    
    @Column(name = "outro_programa_social")
    private String outroProgramaSocial;
    
    @OneToOne(cascade = CascadeType.REMOVE)
    @PrimaryKeyJoinColumn(name = "cod_aluno")
    private Imovel imovel;
    
    @OneToMany(mappedBy = "familia", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<MembroFamiliar> membrosFamiliares;
    
    @OneToOne(cascade = CascadeType.REMOVE)
    @PrimaryKeyJoinColumn(name = "cod_aluno")
    private ResidenciaFamilia residencia_familia;

    @OneToOne(cascade = CascadeType.REMOVE)
    @PrimaryKeyJoinColumn(name = "cod_aluno")
    private Renda renda;

    @OneToOne(cascade = CascadeType.REMOVE)
    @PrimaryKeyJoinColumn(name = "cod_aluno")
    private Doenca doenca;

    @OneToOne(cascade = CascadeType.REMOVE)
    @PrimaryKeyJoinColumn(name = "cod_aluno")
    private Despesa despesa;
  
    @Column(name = "servico_saude")
    private String servicoSaude;
    
    @Column(name = "programa_social")
    private String programaSocial;
    
// Getters e Setters 

    public double getRendaFamiliarTotal() {
        return rendaFamiliarTotal;
    }

    public void setRendaFamiliarTotal(double rendaFamiliarTotal) {
        this.rendaFamiliarTotal = rendaFamiliarTotal;
    }

    public Integer getFamilia() {
        return familia;
    }

    public void setFamilia(Integer familia) {
        this.familia = familia;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Boolean getPossuiProgramaSocial() {
        return possuiProgramaSocial;
    }

    public void setPossuiProgramaSocial(Boolean possuiProgramaSocial) {
        this.possuiProgramaSocial = possuiProgramaSocial;
    }

    public Boolean getPossuiGestante() {
        return possuiGestante;
    }

    public void setPossuiGestante(Boolean possuiGestante) {
        this.possuiGestante = possuiGestante;
    }

    public String getOutroProgramaSocial() {
        return outroProgramaSocial;
    }

    public void setOutroProgramaSocial(String outroProgramaSocial) {
        this.outroProgramaSocial = outroProgramaSocial;
    }

    public Imovel getImovel() {
        return imovel;
    }

    public void setImovel(Imovel imovel) {
        this.imovel = imovel;
    }

    public List<MembroFamiliar> getMembrosFamiliares() {
        return membrosFamiliares;
    }

    public void setMembrosFamiliares(List<MembroFamiliar> membrosFamiliares) {
        this.membrosFamiliares = membrosFamiliares;
    }

    public ResidenciaFamilia getResidencia_familia() {
        return residencia_familia;
    }

    public void setResidencia_familia(ResidenciaFamilia residencia_familia) {
        this.residencia_familia = residencia_familia;
    }

    public Renda getRenda() {
        return renda;
    }

    public void setRenda(Renda renda) {
        this.renda = renda;
    }

    public Doenca getDoenca() {
        return doenca;
    }

    public void setDoenca(Doenca doenca) {
        this.doenca = doenca;
    }

    public Despesa getDespesa() {
        return despesa;
    }

    public void setDespesa(Despesa despesa) {
        this.despesa = despesa;
    }

    public String getServicoSaude() {
        return servicoSaude;
    }

    public void setServicoSaude(String servicoSaude) {
        this.servicoSaude = servicoSaude;
    }

    public String getProgramaSocial() {
        return programaSocial;
    }

    public void setProgramaSocial(String programaSocial) {
        this.programaSocial = programaSocial;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.rendaFamiliarTotal) ^ (Double.doubleToLongBits(this.rendaFamiliarTotal) >>> 32));
        hash = 97 * hash + Objects.hashCode(this.familia);
        hash = 97 * hash + Objects.hashCode(this.aluno);
        hash = 97 * hash + Objects.hashCode(this.possuiProgramaSocial);
        hash = 97 * hash + Objects.hashCode(this.possuiGestante);
        hash = 97 * hash + Objects.hashCode(this.outroProgramaSocial);
        hash = 97 * hash + Objects.hashCode(this.imovel);
        hash = 97 * hash + Objects.hashCode(this.membrosFamiliares);
        hash = 97 * hash + Objects.hashCode(this.residencia_familia);
        hash = 97 * hash + Objects.hashCode(this.renda);
        hash = 97 * hash + Objects.hashCode(this.doenca);
        hash = 97 * hash + Objects.hashCode(this.despesa);
        hash = 97 * hash + Objects.hashCode(this.servicoSaude);
        hash = 97 * hash + Objects.hashCode(this.programaSocial);
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
        final Familia other = (Familia) obj;
        if (Double.doubleToLongBits(this.rendaFamiliarTotal) != Double.doubleToLongBits(other.rendaFamiliarTotal)) {
            return false;
        }
        if (!Objects.equals(this.outroProgramaSocial, other.outroProgramaSocial)) {
            return false;
        }
        if (!Objects.equals(this.servicoSaude, other.servicoSaude)) {
            return false;
        }
        if (!Objects.equals(this.programaSocial, other.programaSocial)) {
            return false;
        }
        if (!Objects.equals(this.familia, other.familia)) {
            return false;
        }
        if (!Objects.equals(this.aluno, other.aluno)) {
            return false;
        }
        if (!Objects.equals(this.possuiProgramaSocial, other.possuiProgramaSocial)) {
            return false;
        }
        if (!Objects.equals(this.possuiGestante, other.possuiGestante)) {
            return false;
        }
        if (!Objects.equals(this.imovel, other.imovel)) {
            return false;
        }
        if (!Objects.equals(this.membrosFamiliares, other.membrosFamiliares)) {
            return false;
        }
        if (!Objects.equals(this.residencia_familia, other.residencia_familia)) {
            return false;
        }
        if (!Objects.equals(this.renda, other.renda)) {
            return false;
        }
        if (!Objects.equals(this.doenca, other.doenca)) {
            return false;
        }
        if (!Objects.equals(this.despesa, other.despesa)) {
            return false;
        }
        return true;
    }    
    
    
}
