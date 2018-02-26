package br.edu.ifba.paae.entidades.formulario;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "condicao_manutencao")
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
    @Column(name = "arquivo_renda_mae", length = 1048576)
    private byte[] arquivoRendaMae;
    @Column(name = "arquivo_renda_mae_nome")
    private String arquivoRendaMaeNome;
    
    @Column(name = "apenas_pai")
    private Boolean apenasPai;
    @Column(name = "arquivo_renda_pai", length = 1048576)
    private byte[] arquivoRendaPai;    
    @Column(name = "arquivo_renda_pai_nome")
    private String arquivoRendaPaiNome;
    
    private Boolean avos;
    @Column(name = "arquivo_Renda_avos", length = 1048576)
    private byte[] arquivoRendaAvos;      
    @Column(name = "arquivo_Renda_avos_nome")
    private String arquivoRendaAvosNome;    
    
    @Column(name = "outros_parentes")
    private Boolean outrosParentes;
    @Column(name = "arquivo_renda_parentes", length = 1048576)
    private byte[] arquivoRendaParentes;     
    @Column(name = "arquivo_renda_parentes_nome")
    private String arquivoRendaParentesNome;
    
    private String parentesco;
    
    @Column(name = "outros_meios")
    private Boolean outrosMeios;
    @Column(name = "arquivo_renda_outros_meios", length = 1048576)
    private byte[] arquivoRendaOutrosMeios;     
    @Column(name = "arquivo_renda_outros_meios_nome")
    private String arquivoRendaOutrosMeiosNome;    
    
    @Column(name = "nome_outros_meios")
    private String nomeOutrosMeios;
    
    @Column(name = "sustentado_por_ninguem")
    private Boolean sustentadoPorNinguem;

// Getters Setters

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

    public byte[] getArquivoRendaMae() {
        return arquivoRendaMae;
    }

    public void setArquivoRendaMae(byte[] arquivoRendaMae) {
        this.arquivoRendaMae = arquivoRendaMae;
    }

    public String getArquivoRendaMaeNome() {
        return arquivoRendaMaeNome;
    }

    public void setArquivoRendaMaeNome(String arquivoRendaMaeNome) {
        this.arquivoRendaMaeNome = arquivoRendaMaeNome;
    }

    public Boolean getApenasPai() {
        return apenasPai;
    }

    public void setApenasPai(Boolean apenasPai) {
        this.apenasPai = apenasPai;
    }

    public byte[] getArquivoRendaPai() {
        return arquivoRendaPai;
    }

    public void setArquivoRendaPai(byte[] arquivoRendaPai) {
        this.arquivoRendaPai = arquivoRendaPai;
    }

    public String getArquivoRendaPaiNome() {
        return arquivoRendaPaiNome;
    }

    public void setArquivoRendaPaiNome(String arquivoRendaPaiNome) {
        this.arquivoRendaPaiNome = arquivoRendaPaiNome;
    }

    public Boolean getAvos() {
        return avos;
    }

    public void setAvos(Boolean avos) {
        this.avos = avos;
    }

    public byte[] getArquivoRendaAvos() {
        return arquivoRendaAvos;
    }

    public void setArquivoRendaAvos(byte[] arquivoRendaAvos) {
        this.arquivoRendaAvos = arquivoRendaAvos;
    }

    public String getArquivoRendaAvosNome() {
        return arquivoRendaAvosNome;
    }

    public void setArquivoRendaAvosNome(String arquivoRendaAvosNome) {
        this.arquivoRendaAvosNome = arquivoRendaAvosNome;
    }

    public Boolean getOutrosParentes() {
        return outrosParentes;
    }

    public void setOutrosParentes(Boolean outrosParentes) {
        this.outrosParentes = outrosParentes;
    }

    public byte[] getArquivoRendaParentes() {
        return arquivoRendaParentes;
    }

    public void setArquivoRendaParentes(byte[] arquivoRendaParentes) {
        this.arquivoRendaParentes = arquivoRendaParentes;
    }

    public String getArquivoRendaParentesNome() {
        return arquivoRendaParentesNome;
    }

    public void setArquivoRendaParentesNome(String arquivoRendaParentesNome) {
        this.arquivoRendaParentesNome = arquivoRendaParentesNome;
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

    public byte[] getArquivoRendaOutrosMeios() {
        return arquivoRendaOutrosMeios;
    }

    public void setArquivoRendaOutrosMeios(byte[] arquivoRendaOutrosMeios) {
        this.arquivoRendaOutrosMeios = arquivoRendaOutrosMeios;
    }

    public String getArquivoRendaOutrosMeiosNome() {
        return arquivoRendaOutrosMeiosNome;
    }

    public void setArquivoRendaOutrosMeiosNome(String arquivoRendaOutrosMeiosNome) {
        this.arquivoRendaOutrosMeiosNome = arquivoRendaOutrosMeiosNome;
    }

    public String getNomeOutrosMeios() {
        return nomeOutrosMeios;
    }

    public void setNomeOutrosMeios(String nomeOutrosMeios) {
        this.nomeOutrosMeios = nomeOutrosMeios;
    }

    public Boolean getSustentadoPorNinguem() {
        return sustentadoPorNinguem;
    }

    public void setSustentadoPorNinguem(Boolean sustentadoPorNinguem) {
        this.sustentadoPorNinguem = sustentadoPorNinguem;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.condicaoManutencao);
        hash = 29 * hash + Objects.hashCode(this.aluno);
        hash = 29 * hash + Objects.hashCode(this.ambosPais);
        hash = 29 * hash + Objects.hashCode(this.apenasMae);
        hash = 29 * hash + Arrays.hashCode(this.arquivoRendaMae);
        hash = 29 * hash + Objects.hashCode(this.arquivoRendaMaeNome);
        hash = 29 * hash + Objects.hashCode(this.apenasPai);
        hash = 29 * hash + Arrays.hashCode(this.arquivoRendaPai);
        hash = 29 * hash + Objects.hashCode(this.arquivoRendaPaiNome);
        hash = 29 * hash + Objects.hashCode(this.avos);
        hash = 29 * hash + Arrays.hashCode(this.arquivoRendaAvos);
        hash = 29 * hash + Objects.hashCode(this.arquivoRendaAvosNome);
        hash = 29 * hash + Objects.hashCode(this.outrosParentes);
        hash = 29 * hash + Arrays.hashCode(this.arquivoRendaParentes);
        hash = 29 * hash + Objects.hashCode(this.arquivoRendaParentesNome);
        hash = 29 * hash + Objects.hashCode(this.parentesco);
        hash = 29 * hash + Objects.hashCode(this.outrosMeios);
        hash = 29 * hash + Arrays.hashCode(this.arquivoRendaOutrosMeios);
        hash = 29 * hash + Objects.hashCode(this.arquivoRendaOutrosMeiosNome);
        hash = 29 * hash + Objects.hashCode(this.nomeOutrosMeios);
        hash = 29 * hash + Objects.hashCode(this.sustentadoPorNinguem);
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
        if (!Objects.equals(this.arquivoRendaMaeNome, other.arquivoRendaMaeNome)) {
            return false;
        }
        if (!Objects.equals(this.arquivoRendaPaiNome, other.arquivoRendaPaiNome)) {
            return false;
        }
        if (!Objects.equals(this.arquivoRendaAvosNome, other.arquivoRendaAvosNome)) {
            return false;
        }
        if (!Objects.equals(this.arquivoRendaParentesNome, other.arquivoRendaParentesNome)) {
            return false;
        }
        if (!Objects.equals(this.parentesco, other.parentesco)) {
            return false;
        }
        if (!Objects.equals(this.arquivoRendaOutrosMeiosNome, other.arquivoRendaOutrosMeiosNome)) {
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
        if (!Arrays.equals(this.arquivoRendaMae, other.arquivoRendaMae)) {
            return false;
        }
        if (!Objects.equals(this.apenasPai, other.apenasPai)) {
            return false;
        }
        if (!Arrays.equals(this.arquivoRendaPai, other.arquivoRendaPai)) {
            return false;
        }
        if (!Objects.equals(this.avos, other.avos)) {
            return false;
        }
        if (!Arrays.equals(this.arquivoRendaAvos, other.arquivoRendaAvos)) {
            return false;
        }
        if (!Objects.equals(this.outrosParentes, other.outrosParentes)) {
            return false;
        }
        if (!Arrays.equals(this.arquivoRendaParentes, other.arquivoRendaParentes)) {
            return false;
        }
        if (!Objects.equals(this.outrosMeios, other.outrosMeios)) {
            return false;
        }
        if (!Arrays.equals(this.arquivoRendaOutrosMeios, other.arquivoRendaOutrosMeios)) {
            return false;
        }
        if (!Objects.equals(this.sustentadoPorNinguem, other.sustentadoPorNinguem)) {
            return false;
        }
        return true;
    }


    
}
