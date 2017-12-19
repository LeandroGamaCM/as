package br.edu.ifba.as.entidades.formulario;

import br.edu.ifba.as.entidades.enums.Zona;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "residencia_familia")
public class ResidenciaFamilia implements Serializable {
    private static final long serialVersionUID = 4032813959422860430L;
    
    @Id
    @GeneratedValue(generator = "fk_residencia_familia_cod_aluno")
    @org.hibernate.annotations.GenericGenerator(name = "fk_residencia_familia_cod_aluno", 
            strategy = "foreign", parameters = @org.hibernate.annotations.Parameter(name = "property", value = "familia"))
    @Column(name = "cod_familia")
    private Integer residenciaFamilia;
    
    @OneToOne(mappedBy = "residencia_familia")
    private Familia familia;  

    @Column(name = "qtde_quartos")
    private Integer qtdeQuartos;

    @Column(name = "qtde_banheiros")
    private Integer qtdeBanheiros;

    @Column(name = "qtde_televisores")
    private Integer qtdeTelevisores;

    @Column(name = "qtde_geladeiras")
    private Integer qtdeGeladeiras;

    @Column(name = "qtde_computadores")
    private Integer qtdeComputadores;

    @Column(name = "qtde_maquinas_lavar")
    private Integer qtdeMaquinaLavar; 

    @Column(name = "qtde_automoveis")
    private Integer qtdeAutomoveis;

    @Column(name = "distancia_campus")
    private Float distanciaCampus;
    
    @Enumerated
    @Column(columnDefinition = "smallint")
    private Zona zona;

    public Integer getResidenciaFamilia() {
        return residenciaFamilia;
    }

    public void setResidenciaFamilia(Integer residenciaFamilia) {
        this.residenciaFamilia = residenciaFamilia;
    }

    public Familia getFamilia() {
        return familia;
    }

    public void setFamilia(Familia familia) {
        this.familia = familia;
    }

    public Integer getQtdeQuartos() {
        return qtdeQuartos;
    }

    public void setQtdeQuartos(Integer qtdeQuartos) {
        this.qtdeQuartos = qtdeQuartos;
    }

    public Integer getQtdeBanheiros() {
        return qtdeBanheiros;
    }

    public void setQtdeBanheiros(Integer qtdeBanheiros) {
        this.qtdeBanheiros = qtdeBanheiros;
    }

    public Integer getQtdeTelevisores() {
        return qtdeTelevisores;
    }

    public void setQtdeTelevisores(Integer qtdeTelevisores) {
        this.qtdeTelevisores = qtdeTelevisores;
    }

    public Integer getQtdeGeladeiras() {
        return qtdeGeladeiras;
    }

    public void setQtdeGeladeiras(Integer qtdeGeladeiras) {
        this.qtdeGeladeiras = qtdeGeladeiras;
    }

    public Integer getQtdeComputadores() {
        return qtdeComputadores;
    }

    public void setQtdeComputadores(Integer qtdeComputadores) {
        this.qtdeComputadores = qtdeComputadores;
    }

    public Integer getQtdeMaquinaLavar() {
        return qtdeMaquinaLavar;
    }

    public void setQtdeMaquinaLavar(Integer qtdeMaquinaLavar) {
        this.qtdeMaquinaLavar = qtdeMaquinaLavar;
    }

    public Integer getQtdeAutomoveis() {
        return qtdeAutomoveis;
    }

    public void setQtdeAutomoveis(Integer qtdeAutomoveis) {
        this.qtdeAutomoveis = qtdeAutomoveis;
    }

    public Float getDistanciaCampus() {
        return distanciaCampus;
    }

    public void setDistanciaCampus(Float distanciaCampus) {
        this.distanciaCampus = distanciaCampus;
    }

    public Zona getZona() {
        return zona;
    }

    public void setZona(Zona zona) {
        this.zona = zona;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.residenciaFamilia);
        hash = 97 * hash + Objects.hashCode(this.familia);
        hash = 97 * hash + Objects.hashCode(this.qtdeQuartos);
        hash = 97 * hash + Objects.hashCode(this.qtdeBanheiros);
        hash = 97 * hash + Objects.hashCode(this.qtdeTelevisores);
        hash = 97 * hash + Objects.hashCode(this.qtdeGeladeiras);
        hash = 97 * hash + Objects.hashCode(this.qtdeComputadores);
        hash = 97 * hash + Objects.hashCode(this.qtdeMaquinaLavar);
        hash = 97 * hash + Objects.hashCode(this.qtdeAutomoveis);
        hash = 97 * hash + Objects.hashCode(this.distanciaCampus);
        hash = 97 * hash + Objects.hashCode(this.zona);
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
        final ResidenciaFamilia other = (ResidenciaFamilia) obj;
        if (!Objects.equals(this.residenciaFamilia, other.residenciaFamilia)) {
            return false;
        }
        if (!Objects.equals(this.familia, other.familia)) {
            return false;
        }
        if (!Objects.equals(this.qtdeQuartos, other.qtdeQuartos)) {
            return false;
        }
        if (!Objects.equals(this.qtdeBanheiros, other.qtdeBanheiros)) {
            return false;
        }
        if (!Objects.equals(this.qtdeTelevisores, other.qtdeTelevisores)) {
            return false;
        }
        if (!Objects.equals(this.qtdeGeladeiras, other.qtdeGeladeiras)) {
            return false;
        }
        if (!Objects.equals(this.qtdeComputadores, other.qtdeComputadores)) {
            return false;
        }
        if (!Objects.equals(this.qtdeMaquinaLavar, other.qtdeMaquinaLavar)) {
            return false;
        }
        if (!Objects.equals(this.qtdeAutomoveis, other.qtdeAutomoveis)) {
            return false;
        }
        if (!Objects.equals(this.distanciaCampus, other.distanciaCampus)) {
            return false;
        }
        if (this.zona != other.zona) {
            return false;
        }
        return true;
    }
            

    
}
