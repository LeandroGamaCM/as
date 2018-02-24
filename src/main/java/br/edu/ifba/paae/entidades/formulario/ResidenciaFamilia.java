package br.edu.ifba.paae.entidades.formulario;

import java.io.Serializable;
import java.util.Arrays;
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
    
    @Column(name = "arquivo_automovel", length = 1048576)
    private byte[] arquivoAutomovel;

    @Column(name = "arquivo_automovel_nome")
    private String arquivoAutomovelNome;
    
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

    @Column(name = "situacao_casa")
    private String situacaoCasa;    
    
    private String zona;

// Getters e Setters 

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

    public byte[] getArquivoAutomovel() {
        return arquivoAutomovel;
    }

    public void setArquivoAutomovel(byte[] arquivoAutomovel) {
        this.arquivoAutomovel = arquivoAutomovel;
    }

    public String getArquivoAutomovelNome() {
        return arquivoAutomovelNome;
    }

    public void setArquivoAutomovelNome(String arquivoAutomovelNome) {
        this.arquivoAutomovelNome = arquivoAutomovelNome;
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

    public String getSituacaoCasa() {
        return situacaoCasa;
    }

    public void setSituacaoCasa(String situacaoCasa) {
        this.situacaoCasa = situacaoCasa;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + Objects.hashCode(this.residenciaFamilia);
        hash = 19 * hash + Objects.hashCode(this.familia);
        hash = 19 * hash + Arrays.hashCode(this.arquivoAutomovel);
        hash = 19 * hash + Objects.hashCode(this.arquivoAutomovelNome);
        hash = 19 * hash + Objects.hashCode(this.qtdeQuartos);
        hash = 19 * hash + Objects.hashCode(this.qtdeBanheiros);
        hash = 19 * hash + Objects.hashCode(this.qtdeTelevisores);
        hash = 19 * hash + Objects.hashCode(this.qtdeGeladeiras);
        hash = 19 * hash + Objects.hashCode(this.qtdeComputadores);
        hash = 19 * hash + Objects.hashCode(this.qtdeMaquinaLavar);
        hash = 19 * hash + Objects.hashCode(this.qtdeAutomoveis);
        hash = 19 * hash + Objects.hashCode(this.distanciaCampus);
        hash = 19 * hash + Objects.hashCode(this.situacaoCasa);
        hash = 19 * hash + Objects.hashCode(this.zona);
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
        if (!Objects.equals(this.arquivoAutomovelNome, other.arquivoAutomovelNome)) {
            return false;
        }
        if (!Objects.equals(this.situacaoCasa, other.situacaoCasa)) {
            return false;
        }
        if (!Objects.equals(this.zona, other.zona)) {
            return false;
        }
        if (!Objects.equals(this.residenciaFamilia, other.residenciaFamilia)) {
            return false;
        }
        if (!Objects.equals(this.familia, other.familia)) {
            return false;
        }
        if (!Arrays.equals(this.arquivoAutomovel, other.arquivoAutomovel)) {
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
        return true;
    }
    
}
