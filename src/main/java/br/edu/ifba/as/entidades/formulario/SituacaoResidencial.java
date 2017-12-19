package br.edu.ifba.as.entidades.formulario;

import br.edu.ifba.as.entidades.enums.AcessoInternet;
import br.edu.ifba.as.entidades.enums.ComQuemMora;
import br.edu.ifba.as.entidades.enums.SituacaoCasa;
import java.io.Serializable;
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

    @Enumerated
    @Column(columnDefinition = "smallint")
    private ComQuemMora comQuemMora;
    
    @Enumerated
    @Column(columnDefinition = "smallint")
    private SituacaoCasa situacaoCasa;

    @Enumerated
    @Column(columnDefinition = "smallint")
    private AcessoInternet acessoInternet;
    
    public Integer getSituacaoResidencial() {
        return situacaoResidencial;
    }

    public void setSituacaoResidencial(Integer situacaoResidencial) {
        this.situacaoResidencial = situacaoResidencial;
    }

    public ComQuemMora getComQuemMora() {
        return comQuemMora;
    }

    public void setComQuemMora(ComQuemMora comQuemMora) {
        this.comQuemMora = comQuemMora;
    }

    public SituacaoCasa getSituacaoCasa() {
        return situacaoCasa;
    }

    public void setSituacaoCasa(SituacaoCasa situacaoCasa) {
        this.situacaoCasa = situacaoCasa;
    }

    public AcessoInternet getAcessoInternet() {
        return acessoInternet;
    }

    public void setAcessoInternet(AcessoInternet acessoInternet) {
        this.acessoInternet = acessoInternet;
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
    
}
