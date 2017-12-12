package br.edu.ifba.as.entidades.formulario;

import br.edu.ifba.as.entidades.enums.Zona;
import java.io.Serializable;
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
    
    
}
