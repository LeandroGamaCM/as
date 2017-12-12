// Obs: pode ser mais de um. Sem ENUM
package br.edu.ifba.as.entidades.formulario;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "imovel")
public class Imovel implements Serializable {
    private static final long serialVersionUID = 272842551137568837L;

    @Id
    @GeneratedValue(generator = "fk_imovel_cod_aluno")
    @org.hibernate.annotations.GenericGenerator(name = "fk_imovel_cod_aluno", 
            strategy = "foreign", parameters = @org.hibernate.annotations.Parameter(name = "property", value = "familia"))
    @Column(name = "cod_familia")
    private Integer imovel;
    
    @OneToOne(mappedBy = "imovel")
    private Familia familia;
    
    private Float hectares;
    
    @Column(name = "outro_imovel")
    private String nomeOutroImovel;
    
    private Boolean terras;
    private Boolean lotes;
    private Boolean fazendas;
    private Boolean sitios;
    private Boolean apartamentos;
    private Boolean outroImovel;
    @Column(name = "casa_praia")
    private Boolean casaPraia;
    @Column(name = "salas_comerciais")
    private Boolean salasComerciais;

    
    public Integer getImovel() {
        return imovel;
    }

    public void setImovel(Integer imovel) {
        this.imovel = imovel;
    }

    public Familia getFamilia() {
        return familia;
    }

    public void setFamilia(Familia familia) {
        this.familia = familia;
    }

    public Float getHectares() {
        return hectares;
    }

    public void setHectares(Float hectares) {
        this.hectares = hectares;
    }

    public String getNomeOutroImovel() {
        return nomeOutroImovel;
    }

    public void setNomeOutroImovel(String nomeOutroImovel) {
        this.nomeOutroImovel = nomeOutroImovel;
    }

    public boolean isTerras() {
        return terras;
    }

    public void setTerras(boolean terras) {
        this.terras = terras;
    }

    public boolean isLotes() {
        return lotes;
    }

    public void setLotes(boolean lotes) {
        this.lotes = lotes;
    }

    public boolean isFazendas() {
        return fazendas;
    }

    public void setFazendas(boolean fazendas) {
        this.fazendas = fazendas;
    }

    public boolean isSitios() {
        return sitios;
    }

    public void setSitios(boolean sitios) {
        this.sitios = sitios;
    }

    public boolean isApartamentos() {
        return apartamentos;
    }

    public void setApartamentos(boolean apartamentos) {
        this.apartamentos = apartamentos;
    }

    public boolean isOutroImovel() {
        return outroImovel;
    }

    public void setOutroImovel(boolean outroImovel) {
        this.outroImovel = outroImovel;
    }

    public boolean isCasaPraia() {
        return casaPraia;
    }

    public void setCasaPraia(boolean casaPraia) {
        this.casaPraia = casaPraia;
    }

    public boolean isSalasComerciais() {
        return salasComerciais;
    }

    public void setSalasComerciais(boolean salasComerciais) {
        this.salasComerciais = salasComerciais;
    }
    
    
}
