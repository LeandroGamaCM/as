package br.edu.ifba.paae.entidades.formulario;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;
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
    
    @Column(name = "arquivo_imovel", length = 1048576)
    private byte[] arquivoImovel;
    
    @Column(name = "arquivo_imovel_nome")
    private String arquivoImovelNome;
    
    private Float hectares;
    
    @Column(name = "outro_imovel")
    private String nomeOutroImovel;
    
    @Column(name = "possui_imovel")
    private Boolean possuiImovel;
        
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

    
// Getters e Setters

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

    public byte[] getArquivoImovel() {
        return arquivoImovel;
    }

    public void setArquivoImovel(byte[] arquivoImovel) {
        this.arquivoImovel = arquivoImovel;
    }

    public String getArquivoImovelNome() {
        return arquivoImovelNome;
    }

    public void setArquivoImovelNome(String arquivoImovelNome) {
        this.arquivoImovelNome = arquivoImovelNome;
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

    public Boolean getPossuiImovel() {
        return possuiImovel;
    }

    public void setPossuiImovel(Boolean possuiImovel) {
        this.possuiImovel = possuiImovel;
    }

    public Boolean getTerras() {
        return terras;
    }

    public void setTerras(Boolean terras) {
        this.terras = terras;
    }

    public Boolean getLotes() {
        return lotes;
    }

    public void setLotes(Boolean lotes) {
        this.lotes = lotes;
    }

    public Boolean getFazendas() {
        return fazendas;
    }

    public void setFazendas(Boolean fazendas) {
        this.fazendas = fazendas;
    }

    public Boolean getSitios() {
        return sitios;
    }

    public void setSitios(Boolean sitios) {
        this.sitios = sitios;
    }

    public Boolean getApartamentos() {
        return apartamentos;
    }

    public void setApartamentos(Boolean apartamentos) {
        this.apartamentos = apartamentos;
    }

    public Boolean getOutroImovel() {
        return outroImovel;
    }

    public void setOutroImovel(Boolean outroImovel) {
        this.outroImovel = outroImovel;
    }

    public Boolean getCasaPraia() {
        return casaPraia;
    }

    public void setCasaPraia(Boolean casaPraia) {
        this.casaPraia = casaPraia;
    }

    public Boolean getSalasComerciais() {
        return salasComerciais;
    }

    public void setSalasComerciais(Boolean salasComerciais) {
        this.salasComerciais = salasComerciais;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.imovel);
        hash = 53 * hash + Objects.hashCode(this.familia);
        hash = 53 * hash + Arrays.hashCode(this.arquivoImovel);
        hash = 53 * hash + Objects.hashCode(this.arquivoImovelNome);
        hash = 53 * hash + Objects.hashCode(this.hectares);
        hash = 53 * hash + Objects.hashCode(this.nomeOutroImovel);
        hash = 53 * hash + Objects.hashCode(this.possuiImovel);
        hash = 53 * hash + Objects.hashCode(this.terras);
        hash = 53 * hash + Objects.hashCode(this.lotes);
        hash = 53 * hash + Objects.hashCode(this.fazendas);
        hash = 53 * hash + Objects.hashCode(this.sitios);
        hash = 53 * hash + Objects.hashCode(this.apartamentos);
        hash = 53 * hash + Objects.hashCode(this.outroImovel);
        hash = 53 * hash + Objects.hashCode(this.casaPraia);
        hash = 53 * hash + Objects.hashCode(this.salasComerciais);
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
        final Imovel other = (Imovel) obj;
        if (!Objects.equals(this.arquivoImovelNome, other.arquivoImovelNome)) {
            return false;
        }
        if (!Objects.equals(this.nomeOutroImovel, other.nomeOutroImovel)) {
            return false;
        }
        if (!Objects.equals(this.imovel, other.imovel)) {
            return false;
        }
        if (!Objects.equals(this.familia, other.familia)) {
            return false;
        }
        if (!Arrays.equals(this.arquivoImovel, other.arquivoImovel)) {
            return false;
        }
        if (!Objects.equals(this.hectares, other.hectares)) {
            return false;
        }
        if (!Objects.equals(this.possuiImovel, other.possuiImovel)) {
            return false;
        }
        if (!Objects.equals(this.terras, other.terras)) {
            return false;
        }
        if (!Objects.equals(this.lotes, other.lotes)) {
            return false;
        }
        if (!Objects.equals(this.fazendas, other.fazendas)) {
            return false;
        }
        if (!Objects.equals(this.sitios, other.sitios)) {
            return false;
        }
        if (!Objects.equals(this.apartamentos, other.apartamentos)) {
            return false;
        }
        if (!Objects.equals(this.outroImovel, other.outroImovel)) {
            return false;
        }
        if (!Objects.equals(this.casaPraia, other.casaPraia)) {
            return false;
        }
        if (!Objects.equals(this.salasComerciais, other.salasComerciais)) {
            return false;
        }
        return true;
    }
    
}
