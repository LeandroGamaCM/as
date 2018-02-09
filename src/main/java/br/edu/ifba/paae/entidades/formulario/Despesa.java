package br.edu.ifba.paae.entidades.formulario;

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
    
    private Boolean aluguel;
    @Column(name = "valor_aluguel")
    private Double valorAluguel;
    @Column(name = "arquivo_despesa_aluguel")
    private String arquivoDespesaAluguel;
    
    @Column(name = "mensalidade_escolar")
    private Boolean mensalidadeEscolar;
    @Column(name = "valor_mensalidade_escolar")
    private Double valorMensalidadeEscolar;
    @Column(name = "arquivo_despesa_mensalidade_escolar")
    private String arquivoDespesaMensalidadeEscolar;
    
    private Boolean telefone;
    @Column(name = "valor_telefone")
    private Double valorTelefone;
    @Column(name = "arquivo_despesa_telefone")
    private String arquivoDespesaTelefone;
    
    private Boolean endividamento;
    @Column(name = "valor_endividamento")
    private Double valorEndividamento;
    @Column(name = "arquivo_despesa_endividamento")
    private String arquivoDespesaEndividamento;
    
    private Boolean internet;
    @Column(name = "valor_internet")
    private Double valorInternet;
    @Column(name = "arquivo_despesa_internet")
    private String arquivoDespesaInternet;

    private Boolean agua;
    @Column(name = "valor_agua")
    private Double valorAgua;
    @Column(name = "arquivo_despesa_agua")
    private String arquivoDespesaAgua;

    private Boolean medicamentos;
    @Column(name = "valor_medicamentos")
    private Double valorMedicamentos;
    @Column(name = "arquivo_despesa_medicamentos")
    private String arquivoDespesaMedicamentos;

    private Boolean luz;
    @Column(name = "valor_luz")
    private Double valorLuz;
    @Column(name = "arquivo_despesa_luz")
    private String arquivoDespesaLuz;

    @Column(name = "plano_saude")
    private Boolean planoSaude;
    @Column(name = "valor_plano_saude")
    private Double valorPlanoSaude;
    @Column(name = "arquivo_despesa_plano_saude")
    private String arquivoDespesaPlanoSaude;

    private Boolean financiamentos;
    @Column(name = "valor_financiamentos")
    private Double valorFinanciamentos;
    @Column(name = "arquivo_despesa_financiamentos")
    private String arquivoDespesaFinanciamentos;

    private Boolean transporte;
    @Column(name = "valor_transporte")
    private Double valorTransporte;
    @Column(name = "arquivo_despesa_transporte")
    private String arquivoDespesaTransporte;

    @Column(name = "investimentos_educacao")
    private Boolean investimentosEducacao;
    @Column(name = "valor_investimentos_educacao")
    private Double valorInvestimentosEducacao;
    @Column(name = "arquivo_despesa_investimentos_educacao")
    private String arquivoDespesaInvestimentosEducacao;

    private Boolean outros;
    @Column(name = "valor_outros")
    private Double valorOutros;
    @Column(name = "nome_outros")
    private String nomeOutros;
    @Column(name = "arquivo_despesa_outros")
    private String arquivoDespesaOutros;
    
// Getters e Setters

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

    public String getArquivoDespesaAluguel() {
        return arquivoDespesaAluguel;
    }

    public void setArquivoDespesaAluguel(String arquivoDespesaAluguel) {
        this.arquivoDespesaAluguel = arquivoDespesaAluguel;
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

    public String getArquivoDespesaMensalidadeEscolar() {
        return arquivoDespesaMensalidadeEscolar;
    }

    public void setArquivoDespesaMensalidadeEscolar(String arquivoDespesaMensalidadeEscolar) {
        this.arquivoDespesaMensalidadeEscolar = arquivoDespesaMensalidadeEscolar;
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

    public String getArquivoDespesaTelefone() {
        return arquivoDespesaTelefone;
    }

    public void setArquivoDespesaTelefone(String arquivoDespesaTelefone) {
        this.arquivoDespesaTelefone = arquivoDespesaTelefone;
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

    public String getArquivoDespesaEndividamento() {
        return arquivoDespesaEndividamento;
    }

    public void setArquivoDespesaEndividamento(String arquivoDespesaEndividamento) {
        this.arquivoDespesaEndividamento = arquivoDespesaEndividamento;
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

    public String getArquivoDespesaInternet() {
        return arquivoDespesaInternet;
    }

    public void setArquivoDespesaInternet(String arquivoDespesaInternet) {
        this.arquivoDespesaInternet = arquivoDespesaInternet;
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

    public String getArquivoDespesaAgua() {
        return arquivoDespesaAgua;
    }

    public void setArquivoDespesaAgua(String arquivoDespesaAgua) {
        this.arquivoDespesaAgua = arquivoDespesaAgua;
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

    public String getArquivoDespesaMedicamentos() {
        return arquivoDespesaMedicamentos;
    }

    public void setArquivoDespesaMedicamentos(String arquivoDespesaMedicamentos) {
        this.arquivoDespesaMedicamentos = arquivoDespesaMedicamentos;
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

    public String getArquivoDespesaLuz() {
        return arquivoDespesaLuz;
    }

    public void setArquivoDespesaLuz(String arquivoDespesaLuz) {
        this.arquivoDespesaLuz = arquivoDespesaLuz;
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

    public String getArquivoDespesaPlanoSaude() {
        return arquivoDespesaPlanoSaude;
    }

    public void setArquivoDespesaPlanoSaude(String arquivoDespesaPlanoSaude) {
        this.arquivoDespesaPlanoSaude = arquivoDespesaPlanoSaude;
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

    public String getArquivoDespesaFinanciamentos() {
        return arquivoDespesaFinanciamentos;
    }

    public void setArquivoDespesaFinanciamentos(String arquivoDespesaFinanciamentos) {
        this.arquivoDespesaFinanciamentos = arquivoDespesaFinanciamentos;
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

    public String getArquivoDespesaTransporte() {
        return arquivoDespesaTransporte;
    }

    public void setArquivoDespesaTransporte(String arquivoDespesaTransporte) {
        this.arquivoDespesaTransporte = arquivoDespesaTransporte;
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

    public String getArquivoDespesaInvestimentosEducacao() {
        return arquivoDespesaInvestimentosEducacao;
    }

    public void setArquivoDespesaInvestimentosEducacao(String arquivoDespesaInvestimentosEducacao) {
        this.arquivoDespesaInvestimentosEducacao = arquivoDespesaInvestimentosEducacao;
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

    public String getArquivoDespesaOutros() {
        return arquivoDespesaOutros;
    }

    public void setArquivoDespesaOutros(String arquivoDespesaOutros) {
        this.arquivoDespesaOutros = arquivoDespesaOutros;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.despesa);
        hash = 47 * hash + Objects.hashCode(this.familia);
        hash = 47 * hash + Objects.hashCode(this.aluguel);
        hash = 47 * hash + Objects.hashCode(this.valorAluguel);
        hash = 47 * hash + Objects.hashCode(this.arquivoDespesaAluguel);
        hash = 47 * hash + Objects.hashCode(this.mensalidadeEscolar);
        hash = 47 * hash + Objects.hashCode(this.valorMensalidadeEscolar);
        hash = 47 * hash + Objects.hashCode(this.arquivoDespesaMensalidadeEscolar);
        hash = 47 * hash + Objects.hashCode(this.telefone);
        hash = 47 * hash + Objects.hashCode(this.valorTelefone);
        hash = 47 * hash + Objects.hashCode(this.arquivoDespesaTelefone);
        hash = 47 * hash + Objects.hashCode(this.endividamento);
        hash = 47 * hash + Objects.hashCode(this.valorEndividamento);
        hash = 47 * hash + Objects.hashCode(this.arquivoDespesaEndividamento);
        hash = 47 * hash + Objects.hashCode(this.internet);
        hash = 47 * hash + Objects.hashCode(this.valorInternet);
        hash = 47 * hash + Objects.hashCode(this.arquivoDespesaInternet);
        hash = 47 * hash + Objects.hashCode(this.agua);
        hash = 47 * hash + Objects.hashCode(this.valorAgua);
        hash = 47 * hash + Objects.hashCode(this.arquivoDespesaAgua);
        hash = 47 * hash + Objects.hashCode(this.medicamentos);
        hash = 47 * hash + Objects.hashCode(this.valorMedicamentos);
        hash = 47 * hash + Objects.hashCode(this.arquivoDespesaMedicamentos);
        hash = 47 * hash + Objects.hashCode(this.luz);
        hash = 47 * hash + Objects.hashCode(this.valorLuz);
        hash = 47 * hash + Objects.hashCode(this.arquivoDespesaLuz);
        hash = 47 * hash + Objects.hashCode(this.planoSaude);
        hash = 47 * hash + Objects.hashCode(this.valorPlanoSaude);
        hash = 47 * hash + Objects.hashCode(this.arquivoDespesaPlanoSaude);
        hash = 47 * hash + Objects.hashCode(this.financiamentos);
        hash = 47 * hash + Objects.hashCode(this.valorFinanciamentos);
        hash = 47 * hash + Objects.hashCode(this.arquivoDespesaFinanciamentos);
        hash = 47 * hash + Objects.hashCode(this.transporte);
        hash = 47 * hash + Objects.hashCode(this.valorTransporte);
        hash = 47 * hash + Objects.hashCode(this.arquivoDespesaTransporte);
        hash = 47 * hash + Objects.hashCode(this.investimentosEducacao);
        hash = 47 * hash + Objects.hashCode(this.valorInvestimentosEducacao);
        hash = 47 * hash + Objects.hashCode(this.arquivoDespesaInvestimentosEducacao);
        hash = 47 * hash + Objects.hashCode(this.outros);
        hash = 47 * hash + Objects.hashCode(this.valorOutros);
        hash = 47 * hash + Objects.hashCode(this.nomeOutros);
        hash = 47 * hash + Objects.hashCode(this.arquivoDespesaOutros);
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
        if (!Objects.equals(this.arquivoDespesaAluguel, other.arquivoDespesaAluguel)) {
            return false;
        }
        if (!Objects.equals(this.arquivoDespesaMensalidadeEscolar, other.arquivoDespesaMensalidadeEscolar)) {
            return false;
        }
        if (!Objects.equals(this.arquivoDespesaTelefone, other.arquivoDespesaTelefone)) {
            return false;
        }
        if (!Objects.equals(this.arquivoDespesaEndividamento, other.arquivoDespesaEndividamento)) {
            return false;
        }
        if (!Objects.equals(this.arquivoDespesaInternet, other.arquivoDespesaInternet)) {
            return false;
        }
        if (!Objects.equals(this.arquivoDespesaAgua, other.arquivoDespesaAgua)) {
            return false;
        }
        if (!Objects.equals(this.arquivoDespesaMedicamentos, other.arquivoDespesaMedicamentos)) {
            return false;
        }
        if (!Objects.equals(this.arquivoDespesaLuz, other.arquivoDespesaLuz)) {
            return false;
        }
        if (!Objects.equals(this.arquivoDespesaPlanoSaude, other.arquivoDespesaPlanoSaude)) {
            return false;
        }
        if (!Objects.equals(this.arquivoDespesaFinanciamentos, other.arquivoDespesaFinanciamentos)) {
            return false;
        }
        if (!Objects.equals(this.arquivoDespesaTransporte, other.arquivoDespesaTransporte)) {
            return false;
        }
        if (!Objects.equals(this.arquivoDespesaInvestimentosEducacao, other.arquivoDespesaInvestimentosEducacao)) {
            return false;
        }
        if (!Objects.equals(this.nomeOutros, other.nomeOutros)) {
            return false;
        }
        if (!Objects.equals(this.arquivoDespesaOutros, other.arquivoDespesaOutros)) {
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
