package br.edu.ifba.as.entidades.formulario;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "situacao_residencial")
public class SituacaoResidencial implements Serializable {
    private static final long serialVersionUID = -3551482452236353668L;

    @Id
    @GeneratedValue(generator = "fk_situacao_residencial_cod_aluno")
    @org.hibernate.annotations.GenericGenerator(name = "fk_situacao_residencial_cod_aluno", 
            strategy = "foreign", parameters = @org.hibernate.annotations.Parameter(name = "property", value = "aluno"))
    @Column(name = "cod_aluno")
    private Integer situacaoResidencial;
    
    @OneToOne(mappedBy = "situacao_residencial")
    private Aluno aluno;    

    @Column(name = "mora_com_quem_outro")
    private String moraComQuemOutro;
    
    @Column(name = "casa_quem_emprestou")
    private String casaQuemEmprestou;
    
    @Column(name = "casa_situacao_outro")
    private String casaSituacaoOutro;
    
    @Column(name = "acesso_internet_outro")
    private String acessoInternetOutro;
    
    @Column(name = "gasto_moradia")
    private Double gastoMoradia; 
    
    @Column(name = "valor_aluguel")
    private Double valorAluguel;
    
    @Column(name = "despesas_extra")
    private Double despesasExtra;

    @Column(name = "com_quem_mora")
    private String comQuemMora;
    
    @Column(name = "ituacao_casa")
    private String situacaoCasa;

    @Column(name = "acesso_internet")
    private String acessoInternet;
    
// Getters e Setters

    public Integer getSituacaoResidencial() {
        return situacaoResidencial;
    }

    public void setSituacaoResidencial(Integer situacaoResidencial) {
        this.situacaoResidencial = situacaoResidencial;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public String getMoraComQuemOutro() {
        return moraComQuemOutro;
    }

    public void setMoraComQuemOutro(String moraComQuemOutro) {
        this.moraComQuemOutro = moraComQuemOutro;
    }

    public String getCasaQuemEmprestou() {
        return casaQuemEmprestou;
    }

    public void setCasaQuemEmprestou(String casaQuemEmprestou) {
        this.casaQuemEmprestou = casaQuemEmprestou;
    }

    public String getCasaSituacaoOutro() {
        return casaSituacaoOutro;
    }

    public void setCasaSituacaoOutro(String casaSituacaoOutro) {
        this.casaSituacaoOutro = casaSituacaoOutro;
    }

    public String getAcessoInternetOutro() {
        return acessoInternetOutro;
    }

    public void setAcessoInternetOutro(String acessoInternetOutro) {
        this.acessoInternetOutro = acessoInternetOutro;
    }

    public Double getGastoMoradia() {
        return gastoMoradia;
    }

    public void setGastoMoradia(Double gastoMoradia) {
        this.gastoMoradia = gastoMoradia;
    }

    public Double getValorAluguel() {
        return valorAluguel;
    }

    public void setValorAluguel(Double valorAluguel) {
        this.valorAluguel = valorAluguel;
    }

    public Double getDespesasExtra() {
        return despesasExtra;
    }

    public void setDespesasExtra(Double despesasExtra) {
        this.despesasExtra = despesasExtra;
    }

    public String getComQuemMora() {
        return comQuemMora;
    }

    public void setComQuemMora(String comQuemMora) {
        this.comQuemMora = comQuemMora;
    }

    public String getSituacaoCasa() {
        return situacaoCasa;
    }

    public void setSituacaoCasa(String situacaoCasa) {
        this.situacaoCasa = situacaoCasa;
    }

    public String getAcessoInternet() {
        return acessoInternet;
    }

    public void setAcessoInternet(String acessoInternet) {
        this.acessoInternet = acessoInternet;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.situacaoResidencial);
        hash = 89 * hash + Objects.hashCode(this.aluno);
        hash = 89 * hash + Objects.hashCode(this.moraComQuemOutro);
        hash = 89 * hash + Objects.hashCode(this.casaQuemEmprestou);
        hash = 89 * hash + Objects.hashCode(this.casaSituacaoOutro);
        hash = 89 * hash + Objects.hashCode(this.acessoInternetOutro);
        hash = 89 * hash + Objects.hashCode(this.gastoMoradia);
        hash = 89 * hash + Objects.hashCode(this.valorAluguel);
        hash = 89 * hash + Objects.hashCode(this.despesasExtra);
        hash = 89 * hash + Objects.hashCode(this.comQuemMora);
        hash = 89 * hash + Objects.hashCode(this.situacaoCasa);
        hash = 89 * hash + Objects.hashCode(this.acessoInternet);
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
        final SituacaoResidencial other = (SituacaoResidencial) obj;
        if (!Objects.equals(this.moraComQuemOutro, other.moraComQuemOutro)) {
            return false;
        }
        if (!Objects.equals(this.casaQuemEmprestou, other.casaQuemEmprestou)) {
            return false;
        }
        if (!Objects.equals(this.casaSituacaoOutro, other.casaSituacaoOutro)) {
            return false;
        }
        if (!Objects.equals(this.acessoInternetOutro, other.acessoInternetOutro)) {
            return false;
        }
        if (!Objects.equals(this.comQuemMora, other.comQuemMora)) {
            return false;
        }
        if (!Objects.equals(this.situacaoCasa, other.situacaoCasa)) {
            return false;
        }
        if (!Objects.equals(this.acessoInternet, other.acessoInternet)) {
            return false;
        }
        if (!Objects.equals(this.situacaoResidencial, other.situacaoResidencial)) {
            return false;
        }
        if (!Objects.equals(this.aluno, other.aluno)) {
            return false;
        }
        if (!Objects.equals(this.gastoMoradia, other.gastoMoradia)) {
            return false;
        }
        if (!Objects.equals(this.valorAluguel, other.valorAluguel)) {
            return false;
        }
        if (!Objects.equals(this.despesasExtra, other.despesasExtra)) {
            return false;
        }
        return true;
    }


}
