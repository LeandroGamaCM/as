// Duvida: Podde ter mais de um programa social?
package br.edu.ifba.as.entidades.formulario;

import br.edu.ifba.as.entidades.enums.ProgramaSocial;
import br.edu.ifba.as.entidades.enums.ServicoSaude;
import java.io.Serializable;
import java.util.List;
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
    
    @Column(name = "programa_sociais")
    private Boolean programaSociais;
    
    @Column(name = "outro_programa_social")
    private String outroProgramaSocial;
    
    @OneToOne
    @PrimaryKeyJoinColumn(name = "cod_aluno")
    private Despesa despesa;

    @OneToOne
    @PrimaryKeyJoinColumn(name = "cod_aluno")
    private Imovel imovel;
    
    @OneToMany(mappedBy = "familia", fetch = FetchType.LAZY)
    private List<MembroFamiliar> membrosFamiliares;
    
    @OneToOne
    @PrimaryKeyJoinColumn(name = "cod_aluno")
    private ResidenciaFamilia residencia_familia;
    
    @OneToMany(mappedBy = "familia", fetch = FetchType.LAZY)
    private List<Renda> rendas;
  
    @Enumerated
    @Column(columnDefinition = "smallint")
    private ServicoSaude servicoSaude;
    
    @Enumerated
    @Column(columnDefinition = "smallint")
    private ProgramaSocial programaSocial;

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

    public boolean isProgramaSociais() {
        return programaSociais;
    }

    public void setProgramaSociais(boolean programaSociais) {
        this.programaSociais = programaSociais;
    }

    public String getOutroProgramaSocial() {
        return outroProgramaSocial;
    }

    public void setOutroProgramaSocial(String outroProgramaSocial) {
        this.outroProgramaSocial = outroProgramaSocial;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + (int) (Double.doubleToLongBits(this.rendaFamiliarTotal) ^ (Double.doubleToLongBits(this.rendaFamiliarTotal) >>> 32));
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
        return true;
    }

    
}
