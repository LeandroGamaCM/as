// Obs -------------------------------------------------------------------------
// Despesa pertence ao pacote familia e o Id tem que mudar
package br.edu.ifba.as.entidades.formulario;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "despesa")
public class Despesa implements Serializable {
    private static final long serialVersionUID = 1176719091871813715L;

    @Id
    @GeneratedValue(generator = "fk_despesa_cod_aluno")
    @org.hibernate.annotations.GenericGenerator(name = "fk_despesa_cod_aluno", 
            strategy = "foreign", parameters = @org.hibernate.annotations.Parameter(name = "property", value = "familia"))
    @Column(name = "cod_familia")
    private Integer despesa;
    
    @OneToOne(mappedBy = "despesa")
    private Familia familia;
    
//    @Column(name = "nome_despesa")
//    private String nomeDespesa;
//    @Column(name = "valor_despesa")
//    private Double valorDespesa;


// Variáveis fixas
    private Boolean aluguel;
    @Column(name = "valor_aluguel")
    private Double valorAluguel;

    @Column(name = "mensalidade_escolar")
    private Boolean mensalidadeEscolar;
    @Column(name = "valor_mensalidade_escolar")
    private Double valorMensalidadeEscolar;

    private Boolean telefone;
    @Column(name = "valor_telefone")
    private Double valorTelefone;
    
    private Boolean endividamento;
    @Column(name = "valor_endividamento")
    private Double valorEndividamento;
    
    private Boolean internet;
    @Column(name = "valor_internet")
    private Double valorInternet;

    private Boolean agua;
    @Column(name = "valor_agua")
    private Double valorAgua;

    private Boolean medicamentos;
    @Column(name = "valor_medicamentos")
    private Double valorMedicamentos;

    private Boolean luz;
    @Column(name = "valor_luz")
    private Double valorLuz;

    @Column(name = "plano_saude")
    private Boolean planoSaude;
    @Column(name = "valor_plano_saude")
    private Double valorPlanoSaude;

    private Boolean financiamentos;
    @Column(name = "valor_financiamentos")
    private Double valorFinanciamentos;

    private Boolean transporte;
    @Column(name = "valor_transporte")
    private Double valorTransporte;

    @Column(name = "investimentos_educacao")
    private Boolean investimentosEducacao;
    @Column(name = "valor_investimentos_educacao")
    private Double valorInvestimentosEducacao;

    private Boolean outros;
    @Column(name = "valor_outros")
    private Double valorOutros;
    @Column(name = "nome_outros")
    private String nomeOutros;

    public Integer getDespesa() {
        return despesa;
    }

    public void setDespesa(Integer despesa) {
        this.despesa = despesa;
    }

    public Familia getFamilia() {
        return familia;
    }

    public void setFamilia(Familia familia) {
        this.familia = familia;
    }

    public Boolean getAluguel() {
        return aluguel;
    }

    public void setAluguel(Boolean aluguel) {
        this.aluguel = aluguel;
    }

    public Double getValorAluguel() {
        return valorAluguel;
    }

    public void setValorAluguel(Double valorAluguel) {
        this.valorAluguel = valorAluguel;
    }

    public Boolean getMensalidadeEscolar() {
        return mensalidadeEscolar;
    }

    public void setMensalidadeEscolar(Boolean mensalidadeEscolar) {
        this.mensalidadeEscolar = mensalidadeEscolar;
    }

    public Double getValorMensalidadeEscolar() {
        return valorMensalidadeEscolar;
    }

    public void setValorMensalidadeEscolar(Double valorMensalidadeEscolar) {
        this.valorMensalidadeEscolar = valorMensalidadeEscolar;
    }

    public Boolean getTelefone() {
        return telefone;
    }

    public void setTelefone(Boolean telefone) {
        this.telefone = telefone;
    }

    public Double getValorTelefone() {
        return valorTelefone;
    }

    public void setValorTelefone(Double valorTelefone) {
        this.valorTelefone = valorTelefone;
    }

    public Boolean getEndividamento() {
        return endividamento;
    }

    public void setEndividamento(Boolean endividamento) {
        this.endividamento = endividamento;
    }

    public Double getValorEndividamento() {
        return valorEndividamento;
    }

    public void setValorEndividamento(Double valorEndividamento) {
        this.valorEndividamento = valorEndividamento;
    }

    public Boolean getInternet() {
        return internet;
    }

    public void setInternet(Boolean internet) {
        this.internet = internet;
    }

    public Double getValorInternet() {
        return valorInternet;
    }

    public void setValorInternet(Double valorInternet) {
        this.valorInternet = valorInternet;
    }

    public Boolean getAgua() {
        return agua;
    }

    public void setAgua(Boolean agua) {
        this.agua = agua;
    }

    public Double getValorAgua() {
        return valorAgua;
    }

    public void setValorAgua(Double valorAgua) {
        this.valorAgua = valorAgua;
    }

    public Boolean getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(Boolean medicamentos) {
        this.medicamentos = medicamentos;
    }

    public Double getValorMedicamentos() {
        return valorMedicamentos;
    }

    public void setValorMedicamentos(Double valorMedicamentos) {
        this.valorMedicamentos = valorMedicamentos;
    }

    public Boolean getLuz() {
        return luz;
    }

    public void setLuz(Boolean luz) {
        this.luz = luz;
    }

    public Double getValorLuz() {
        return valorLuz;
    }

    public void setValorLuz(Double valorLuz) {
        this.valorLuz = valorLuz;
    }

    public Boolean getPlanoSaude() {
        return planoSaude;
    }

    public void setPlanoSaude(Boolean planoSaude) {
        this.planoSaude = planoSaude;
    }

    public Double getValorPlanoSaude() {
        return valorPlanoSaude;
    }

    public void setValorPlanoSaude(Double valorPlanoSaude) {
        this.valorPlanoSaude = valorPlanoSaude;
    }

    public Boolean getFinanciamentos() {
        return financiamentos;
    }

    public void setFinanciamentos(Boolean financiamentos) {
        this.financiamentos = financiamentos;
    }

    public Double getValorFinanciamentos() {
        return valorFinanciamentos;
    }

    public void setValorFinanciamentos(Double valorFinanciamentos) {
        this.valorFinanciamentos = valorFinanciamentos;
    }

    public Boolean getTransporte() {
        return transporte;
    }

    public void setTransporte(Boolean transporte) {
        this.transporte = transporte;
    }

    public Double getValorTransporte() {
        return valorTransporte;
    }

    public void setValorTransporte(Double valorTransporte) {
        this.valorTransporte = valorTransporte;
    }

    public Boolean getInvestimentosEducacao() {
        return investimentosEducacao;
    }

    public void setInvestimentosEducacao(Boolean investimentosEducacao) {
        this.investimentosEducacao = investimentosEducacao;
    }

    public Double getValorInvestimentosEducacao() {
        return valorInvestimentosEducacao;
    }

    public void setValorInvestimentosEducacao(Double valorInvestimentosEducacao) {
        this.valorInvestimentosEducacao = valorInvestimentosEducacao;
    }

    public Boolean getOutros() {
        return outros;
    }

    public void setOutros(Boolean outros) {
        this.outros = outros;
    }

    public Double getValorOutros() {
        return valorOutros;
    }

    public void setValorOutros(Double valorOutros) {
        this.valorOutros = valorOutros;
    }

    public String getNomeOutros() {
        return nomeOutros;
    }

    public void setNomeOutros(String nomeOutros) {
        this.nomeOutros = nomeOutros;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 11 * hash + Objects.hashCode(this.despesa);
        hash = 11 * hash + Objects.hashCode(this.familia);
        hash = 11 * hash + Objects.hashCode(this.aluguel);
        hash = 11 * hash + Objects.hashCode(this.valorAluguel);
        hash = 11 * hash + Objects.hashCode(this.mensalidadeEscolar);
        hash = 11 * hash + Objects.hashCode(this.valorMensalidadeEscolar);
        hash = 11 * hash + Objects.hashCode(this.telefone);
        hash = 11 * hash + Objects.hashCode(this.valorTelefone);
        hash = 11 * hash + Objects.hashCode(this.endividamento);
        hash = 11 * hash + Objects.hashCode(this.valorEndividamento);
        hash = 11 * hash + Objects.hashCode(this.internet);
        hash = 11 * hash + Objects.hashCode(this.valorInternet);
        hash = 11 * hash + Objects.hashCode(this.agua);
        hash = 11 * hash + Objects.hashCode(this.valorAgua);
        hash = 11 * hash + Objects.hashCode(this.medicamentos);
        hash = 11 * hash + Objects.hashCode(this.valorMedicamentos);
        hash = 11 * hash + Objects.hashCode(this.luz);
        hash = 11 * hash + Objects.hashCode(this.valorLuz);
        hash = 11 * hash + Objects.hashCode(this.planoSaude);
        hash = 11 * hash + Objects.hashCode(this.valorPlanoSaude);
        hash = 11 * hash + Objects.hashCode(this.financiamentos);
        hash = 11 * hash + Objects.hashCode(this.valorFinanciamentos);
        hash = 11 * hash + Objects.hashCode(this.transporte);
        hash = 11 * hash + Objects.hashCode(this.valorTransporte);
        hash = 11 * hash + Objects.hashCode(this.investimentosEducacao);
        hash = 11 * hash + Objects.hashCode(this.valorInvestimentosEducacao);
        hash = 11 * hash + Objects.hashCode(this.outros);
        hash = 11 * hash + Objects.hashCode(this.valorOutros);
        hash = 11 * hash + Objects.hashCode(this.nomeOutros);
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
        final Despesa other = (Despesa) obj;
        if (!Objects.equals(this.nomeOutros, other.nomeOutros)) {
            return false;
        }
        if (!Objects.equals(this.despesa, other.despesa)) {
            return false;
        }
        if (!Objects.equals(this.familia, other.familia)) {
            return false;
        }
        if (!Objects.equals(this.aluguel, other.aluguel)) {
            return false;
        }
        if (!Objects.equals(this.valorAluguel, other.valorAluguel)) {
            return false;
        }
        if (!Objects.equals(this.mensalidadeEscolar, other.mensalidadeEscolar)) {
            return false;
        }
        if (!Objects.equals(this.valorMensalidadeEscolar, other.valorMensalidadeEscolar)) {
            return false;
        }
        if (!Objects.equals(this.telefone, other.telefone)) {
            return false;
        }
        if (!Objects.equals(this.valorTelefone, other.valorTelefone)) {
            return false;
        }
        if (!Objects.equals(this.endividamento, other.endividamento)) {
            return false;
        }
        if (!Objects.equals(this.valorEndividamento, other.valorEndividamento)) {
            return false;
        }
        if (!Objects.equals(this.internet, other.internet)) {
            return false;
        }
        if (!Objects.equals(this.valorInternet, other.valorInternet)) {
            return false;
        }
        if (!Objects.equals(this.agua, other.agua)) {
            return false;
        }
        if (!Objects.equals(this.valorAgua, other.valorAgua)) {
            return false;
        }
        if (!Objects.equals(this.medicamentos, other.medicamentos)) {
            return false;
        }
        if (!Objects.equals(this.valorMedicamentos, other.valorMedicamentos)) {
            return false;
        }
        if (!Objects.equals(this.luz, other.luz)) {
            return false;
        }
        if (!Objects.equals(this.valorLuz, other.valorLuz)) {
            return false;
        }
        if (!Objects.equals(this.planoSaude, other.planoSaude)) {
            return false;
        }
        if (!Objects.equals(this.valorPlanoSaude, other.valorPlanoSaude)) {
            return false;
        }
        if (!Objects.equals(this.financiamentos, other.financiamentos)) {
            return false;
        }
        if (!Objects.equals(this.valorFinanciamentos, other.valorFinanciamentos)) {
            return false;
        }
        if (!Objects.equals(this.transporte, other.transporte)) {
            return false;
        }
        if (!Objects.equals(this.valorTransporte, other.valorTransporte)) {
            return false;
        }
        if (!Objects.equals(this.investimentosEducacao, other.investimentosEducacao)) {
            return false;
        }
        if (!Objects.equals(this.valorInvestimentosEducacao, other.valorInvestimentosEducacao)) {
            return false;
        }
        if (!Objects.equals(this.outros, other.outros)) {
            return false;
        }
        if (!Objects.equals(this.valorOutros, other.valorOutros)) {
            return false;
        }
        return true;
    }
    
}
