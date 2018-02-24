package br.edu.ifba.paae.entidades.formulario;

import java.io.Serializable;
import java.util.Arrays;
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
    @Column(name = "arquivo_despesa_aluguel", length = 1048576)
    private byte[] arquivoDespesaAluguel;    
    @Column(name = "arquivo_despesa_aluguel_nome")
    private String arquivoDespesaAluguelNome;
    
    @Column(name = "mensalidade_escolar")
    private Boolean mensalidadeEscolar;
    @Column(name = "valor_mensalidade_escolar")
    private Double valorMensalidadeEscolar;
    @Column(name = "arquivo_despesa_mensalidade_escolar", length = 1048576)
    private byte[] arquivoDespesaMensalidadeEscolar;
    @Column(name = "arquivo_despesa_mensalidade_escolar_nome")
    private String arquivoDespesaMensalidadeEscolarNome;
    
    private Boolean telefone;
    @Column(name = "valor_telefone")
    private Double valorTelefone;
    @Column(name = "arquivo_despesa_telefone", length = 1048576)
    private byte[] arquivoDespesaTelefone;
    @Column(name = "arquivo_despesa_telefone_nome")
    private String arquivoDespesaTelefoneNome;
    
    private Boolean endividamento;
    @Column(name = "valor_endividamento")
    private Double valorEndividamento;
    @Column(name = "arquivo_despesa_endividamento", length = 1048576)
    private byte[] arquivoDespesaEndividamento;
    @Column(name = "arquivo_despesa_endividamento_nome")
    private String arquivoDespesaEndividamentoNome;
    
    private Boolean internet;
    @Column(name = "valor_internet")
    private Double valorInternet;
    @Column(name = "arquivo_despesa_internet", length = 1048576)
    private byte[] arquivoDespesaInternet;    
    @Column(name = "arquivo_despesa_internet_nome")
    private String arquivoDespesaInternetNome;

    private Boolean agua;
    @Column(name = "valor_agua")
    private Double valorAgua;
    @Column(name = "arquivo_despesa_agua", length = 1048576)
    private byte[] arquivoDespesaAgua;    
    @Column(name = "arquivo_despesa_agua_nome")
    private String arquivoDespesaAguaNome;

    private Boolean medicamentos;
    @Column(name = "valor_medicamentos")
    private Double valorMedicamentos;
    @Column(name = "arquivo_despesa_medicamentos", length = 1048576)
    private byte[] arquivoDespesaMedicamentos;
    @Column(name = "arquivo_despesa_medicamentos_nome")
    private String arquivoDespesaMedicamentosNome;

    private Boolean luz;
    @Column(name = "valor_luz")
    private Double valorLuz;
    @Column(name = "arquivo_despesa_luz", length = 1048576)
    private byte[] arquivoDespesaLuz;
    @Column(name = "arquivo_despesa_luz_nome")
    private String arquivoDespesaLuzNome;

    @Column(name = "plano_saude")
    private Boolean planoSaude;
    @Column(name = "valor_plano_saude")
    private Double valorPlanoSaude;
    @Column(name = "arquivo_despesa_plano_saude", length = 1048576)
    private byte[] arquivoDespesaPlanoSaude;    
    @Column(name = "arquivo_despesa_plano_saude_nome")
    private String arquivoDespesaPlanoSaudeNome;

    private Boolean financiamentos;
    @Column(name = "valor_financiamentos")
    private Double valorFinanciamentos;
    @Column(name = "arquivo_despesa_financiamentos", length = 1048576)
    private byte[] arquivoDespesaFinanciamentos;
    @Column(name = "arquivo_despesa_financiamentos_nome")
    private String arquivoDespesaFinanciamentosNome;

    private Boolean transporte;
    @Column(name = "valor_transporte")
    private Double valorTransporte;
    @Column(name = "arquivo_despesa_transporte", length = 1048576)
    private byte[] arquivoDespesaTransporte;    
    @Column(name = "arquivo_despesa_transporte_nome")
    private String arquivoDespesaTransporteNome;

    @Column(name = "investimentos_educacao")
    private Boolean investimentosEducacao;
    @Column(name = "valor_investimentos_educacao")
    private Double valorInvestimentosEducacao;
    @Column(name = "arquivo_despesa_investimentos_educacao", length = 1048576)
    private byte[] arquivoDespesaInvestimentosEducacao;
    @Column(name = "arquivo_despesa_investimentos_educacao_nome")
    private String arquivoDespesaInvestimentosEducacaoNome;

    private Boolean outros;
    @Column(name = "valor_outros")
    private Double valorOutros;
    @Column(name = "nome_outros")
    private String nomeOutros;
    @Column(name = "arquivo_despesa_outros", length = 1048576)
    private byte[] arquivoDespesaOutros;
    @Column(name = "arquivo_despesa_outros_nome")
    private String arquivoDespesaOutrosNome;
    
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

    public byte[] getArquivoDespesaAluguel() {
        return arquivoDespesaAluguel;
    }

    public void setArquivoDespesaAluguel(byte[] arquivoDespesaAluguel) {
        this.arquivoDespesaAluguel = arquivoDespesaAluguel;
    }

    public String getArquivoDespesaAluguelNome() {
        return arquivoDespesaAluguelNome;
    }

    public void setArquivoDespesaAluguelNome(String arquivoDespesaAluguelNome) {
        this.arquivoDespesaAluguelNome = arquivoDespesaAluguelNome;
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

    public byte[] getArquivoDespesaMensalidadeEscolar() {
        return arquivoDespesaMensalidadeEscolar;
    }

    public void setArquivoDespesaMensalidadeEscolar(byte[] arquivoDespesaMensalidadeEscolar) {
        this.arquivoDespesaMensalidadeEscolar = arquivoDespesaMensalidadeEscolar;
    }

    public String getArquivoDespesaMensalidadeEscolarNome() {
        return arquivoDespesaMensalidadeEscolarNome;
    }

    public void setArquivoDespesaMensalidadeEscolarNome(String arquivoDespesaMensalidadeEscolarNome) {
        this.arquivoDespesaMensalidadeEscolarNome = arquivoDespesaMensalidadeEscolarNome;
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

    public byte[] getArquivoDespesaTelefone() {
        return arquivoDespesaTelefone;
    }

    public void setArquivoDespesaTelefone(byte[] arquivoDespesaTelefone) {
        this.arquivoDespesaTelefone = arquivoDespesaTelefone;
    }

    public String getArquivoDespesaTelefoneNome() {
        return arquivoDespesaTelefoneNome;
    }

    public void setArquivoDespesaTelefoneNome(String arquivoDespesaTelefoneNome) {
        this.arquivoDespesaTelefoneNome = arquivoDespesaTelefoneNome;
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

    public byte[] getArquivoDespesaEndividamento() {
        return arquivoDespesaEndividamento;
    }

    public void setArquivoDespesaEndividamento(byte[] arquivoDespesaEndividamento) {
        this.arquivoDespesaEndividamento = arquivoDespesaEndividamento;
    }

    public String getArquivoDespesaEndividamentoNome() {
        return arquivoDespesaEndividamentoNome;
    }

    public void setArquivoDespesaEndividamentoNome(String arquivoDespesaEndividamentoNome) {
        this.arquivoDespesaEndividamentoNome = arquivoDespesaEndividamentoNome;
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

    public byte[] getArquivoDespesaInternet() {
        return arquivoDespesaInternet;
    }

    public void setArquivoDespesaInternet(byte[] arquivoDespesaInternet) {
        this.arquivoDespesaInternet = arquivoDespesaInternet;
    }

    public String getArquivoDespesaInternetNome() {
        return arquivoDespesaInternetNome;
    }

    public void setArquivoDespesaInternetNome(String arquivoDespesaInternetNome) {
        this.arquivoDespesaInternetNome = arquivoDespesaInternetNome;
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

    public byte[] getArquivoDespesaAgua() {
        return arquivoDespesaAgua;
    }

    public void setArquivoDespesaAgua(byte[] arquivoDespesaAgua) {
        this.arquivoDespesaAgua = arquivoDespesaAgua;
    }

    public String getArquivoDespesaAguaNome() {
        return arquivoDespesaAguaNome;
    }

    public void setArquivoDespesaAguaNome(String arquivoDespesaAguaNome) {
        this.arquivoDespesaAguaNome = arquivoDespesaAguaNome;
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

    public byte[] getArquivoDespesaMedicamentos() {
        return arquivoDespesaMedicamentos;
    }

    public void setArquivoDespesaMedicamentos(byte[] arquivoDespesaMedicamentos) {
        this.arquivoDespesaMedicamentos = arquivoDespesaMedicamentos;
    }

    public String getArquivoDespesaMedicamentosNome() {
        return arquivoDespesaMedicamentosNome;
    }

    public void setArquivoDespesaMedicamentosNome(String arquivoDespesaMedicamentosNome) {
        this.arquivoDespesaMedicamentosNome = arquivoDespesaMedicamentosNome;
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

    public byte[] getArquivoDespesaLuz() {
        return arquivoDespesaLuz;
    }

    public void setArquivoDespesaLuz(byte[] arquivoDespesaLuz) {
        this.arquivoDespesaLuz = arquivoDespesaLuz;
    }

    public String getArquivoDespesaLuzNome() {
        return arquivoDespesaLuzNome;
    }

    public void setArquivoDespesaLuzNome(String arquivoDespesaLuzNome) {
        this.arquivoDespesaLuzNome = arquivoDespesaLuzNome;
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

    public byte[] getArquivoDespesaPlanoSaude() {
        return arquivoDespesaPlanoSaude;
    }

    public void setArquivoDespesaPlanoSaude(byte[] arquivoDespesaPlanoSaude) {
        this.arquivoDespesaPlanoSaude = arquivoDespesaPlanoSaude;
    }

    public String getArquivoDespesaPlanoSaudeNome() {
        return arquivoDespesaPlanoSaudeNome;
    }

    public void setArquivoDespesaPlanoSaudeNome(String arquivoDespesaPlanoSaudeNome) {
        this.arquivoDespesaPlanoSaudeNome = arquivoDespesaPlanoSaudeNome;
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

    public byte[] getArquivoDespesaFinanciamentos() {
        return arquivoDespesaFinanciamentos;
    }

    public void setArquivoDespesaFinanciamentos(byte[] arquivoDespesaFinanciamentos) {
        this.arquivoDespesaFinanciamentos = arquivoDespesaFinanciamentos;
    }

    public String getArquivoDespesaFinanciamentosNome() {
        return arquivoDespesaFinanciamentosNome;
    }

    public void setArquivoDespesaFinanciamentosNome(String arquivoDespesaFinanciamentosNome) {
        this.arquivoDespesaFinanciamentosNome = arquivoDespesaFinanciamentosNome;
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

    public byte[] getArquivoDespesaTransporte() {
        return arquivoDespesaTransporte;
    }

    public void setArquivoDespesaTransporte(byte[] arquivoDespesaTransporte) {
        this.arquivoDespesaTransporte = arquivoDespesaTransporte;
    }

    public String getArquivoDespesaTransporteNome() {
        return arquivoDespesaTransporteNome;
    }

    public void setArquivoDespesaTransporteNome(String arquivoDespesaTransporteNome) {
        this.arquivoDespesaTransporteNome = arquivoDespesaTransporteNome;
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

    public byte[] getArquivoDespesaInvestimentosEducacao() {
        return arquivoDespesaInvestimentosEducacao;
    }

    public void setArquivoDespesaInvestimentosEducacao(byte[] arquivoDespesaInvestimentosEducacao) {
        this.arquivoDespesaInvestimentosEducacao = arquivoDespesaInvestimentosEducacao;
    }

    public String getArquivoDespesaInvestimentosEducacaoNome() {
        return arquivoDespesaInvestimentosEducacaoNome;
    }

    public void setArquivoDespesaInvestimentosEducacaoNome(String arquivoDespesaInvestimentosEducacaoNome) {
        this.arquivoDespesaInvestimentosEducacaoNome = arquivoDespesaInvestimentosEducacaoNome;
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

    public byte[] getArquivoDespesaOutros() {
        return arquivoDespesaOutros;
    }

    public void setArquivoDespesaOutros(byte[] arquivoDespesaOutros) {
        this.arquivoDespesaOutros = arquivoDespesaOutros;
    }

    public String getArquivoDespesaOutrosNome() {
        return arquivoDespesaOutrosNome;
    }

    public void setArquivoDespesaOutrosNome(String arquivoDespesaOutrosNome) {
        this.arquivoDespesaOutrosNome = arquivoDespesaOutrosNome;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.despesa);
        hash = 23 * hash + Objects.hashCode(this.familia);
        hash = 23 * hash + Objects.hashCode(this.aluguel);
        hash = 23 * hash + Objects.hashCode(this.valorAluguel);
        hash = 23 * hash + Arrays.hashCode(this.arquivoDespesaAluguel);
        hash = 23 * hash + Objects.hashCode(this.arquivoDespesaAluguelNome);
        hash = 23 * hash + Objects.hashCode(this.mensalidadeEscolar);
        hash = 23 * hash + Objects.hashCode(this.valorMensalidadeEscolar);
        hash = 23 * hash + Arrays.hashCode(this.arquivoDespesaMensalidadeEscolar);
        hash = 23 * hash + Objects.hashCode(this.arquivoDespesaMensalidadeEscolarNome);
        hash = 23 * hash + Objects.hashCode(this.telefone);
        hash = 23 * hash + Objects.hashCode(this.valorTelefone);
        hash = 23 * hash + Arrays.hashCode(this.arquivoDespesaTelefone);
        hash = 23 * hash + Objects.hashCode(this.arquivoDespesaTelefoneNome);
        hash = 23 * hash + Objects.hashCode(this.endividamento);
        hash = 23 * hash + Objects.hashCode(this.valorEndividamento);
        hash = 23 * hash + Arrays.hashCode(this.arquivoDespesaEndividamento);
        hash = 23 * hash + Objects.hashCode(this.arquivoDespesaEndividamentoNome);
        hash = 23 * hash + Objects.hashCode(this.internet);
        hash = 23 * hash + Objects.hashCode(this.valorInternet);
        hash = 23 * hash + Arrays.hashCode(this.arquivoDespesaInternet);
        hash = 23 * hash + Objects.hashCode(this.arquivoDespesaInternetNome);
        hash = 23 * hash + Objects.hashCode(this.agua);
        hash = 23 * hash + Objects.hashCode(this.valorAgua);
        hash = 23 * hash + Arrays.hashCode(this.arquivoDespesaAgua);
        hash = 23 * hash + Objects.hashCode(this.arquivoDespesaAguaNome);
        hash = 23 * hash + Objects.hashCode(this.medicamentos);
        hash = 23 * hash + Objects.hashCode(this.valorMedicamentos);
        hash = 23 * hash + Arrays.hashCode(this.arquivoDespesaMedicamentos);
        hash = 23 * hash + Objects.hashCode(this.arquivoDespesaMedicamentosNome);
        hash = 23 * hash + Objects.hashCode(this.luz);
        hash = 23 * hash + Objects.hashCode(this.valorLuz);
        hash = 23 * hash + Arrays.hashCode(this.arquivoDespesaLuz);
        hash = 23 * hash + Objects.hashCode(this.arquivoDespesaLuzNome);
        hash = 23 * hash + Objects.hashCode(this.planoSaude);
        hash = 23 * hash + Objects.hashCode(this.valorPlanoSaude);
        hash = 23 * hash + Arrays.hashCode(this.arquivoDespesaPlanoSaude);
        hash = 23 * hash + Objects.hashCode(this.arquivoDespesaPlanoSaudeNome);
        hash = 23 * hash + Objects.hashCode(this.financiamentos);
        hash = 23 * hash + Objects.hashCode(this.valorFinanciamentos);
        hash = 23 * hash + Arrays.hashCode(this.arquivoDespesaFinanciamentos);
        hash = 23 * hash + Objects.hashCode(this.arquivoDespesaFinanciamentosNome);
        hash = 23 * hash + Objects.hashCode(this.transporte);
        hash = 23 * hash + Objects.hashCode(this.valorTransporte);
        hash = 23 * hash + Arrays.hashCode(this.arquivoDespesaTransporte);
        hash = 23 * hash + Objects.hashCode(this.arquivoDespesaTransporteNome);
        hash = 23 * hash + Objects.hashCode(this.investimentosEducacao);
        hash = 23 * hash + Objects.hashCode(this.valorInvestimentosEducacao);
        hash = 23 * hash + Arrays.hashCode(this.arquivoDespesaInvestimentosEducacao);
        hash = 23 * hash + Objects.hashCode(this.arquivoDespesaInvestimentosEducacaoNome);
        hash = 23 * hash + Objects.hashCode(this.outros);
        hash = 23 * hash + Objects.hashCode(this.valorOutros);
        hash = 23 * hash + Objects.hashCode(this.nomeOutros);
        hash = 23 * hash + Arrays.hashCode(this.arquivoDespesaOutros);
        hash = 23 * hash + Objects.hashCode(this.arquivoDespesaOutrosNome);
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
        if (!Objects.equals(this.arquivoDespesaAluguelNome, other.arquivoDespesaAluguelNome)) {
            return false;
        }
        if (!Objects.equals(this.arquivoDespesaMensalidadeEscolarNome, other.arquivoDespesaMensalidadeEscolarNome)) {
            return false;
        }
        if (!Objects.equals(this.arquivoDespesaTelefoneNome, other.arquivoDespesaTelefoneNome)) {
            return false;
        }
        if (!Objects.equals(this.arquivoDespesaEndividamentoNome, other.arquivoDespesaEndividamentoNome)) {
            return false;
        }
        if (!Objects.equals(this.arquivoDespesaInternetNome, other.arquivoDespesaInternetNome)) {
            return false;
        }
        if (!Objects.equals(this.arquivoDespesaAguaNome, other.arquivoDespesaAguaNome)) {
            return false;
        }
        if (!Objects.equals(this.arquivoDespesaMedicamentosNome, other.arquivoDespesaMedicamentosNome)) {
            return false;
        }
        if (!Objects.equals(this.arquivoDespesaLuzNome, other.arquivoDespesaLuzNome)) {
            return false;
        }
        if (!Objects.equals(this.arquivoDespesaPlanoSaudeNome, other.arquivoDespesaPlanoSaudeNome)) {
            return false;
        }
        if (!Objects.equals(this.arquivoDespesaFinanciamentosNome, other.arquivoDespesaFinanciamentosNome)) {
            return false;
        }
        if (!Objects.equals(this.arquivoDespesaTransporteNome, other.arquivoDespesaTransporteNome)) {
            return false;
        }
        if (!Objects.equals(this.arquivoDespesaInvestimentosEducacaoNome, other.arquivoDespesaInvestimentosEducacaoNome)) {
            return false;
        }
        if (!Objects.equals(this.nomeOutros, other.nomeOutros)) {
            return false;
        }
        if (!Objects.equals(this.arquivoDespesaOutrosNome, other.arquivoDespesaOutrosNome)) {
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
        if (!Arrays.equals(this.arquivoDespesaAluguel, other.arquivoDespesaAluguel)) {
            return false;
        }
        if (!Objects.equals(this.mensalidadeEscolar, other.mensalidadeEscolar)) {
            return false;
        }
        if (!Objects.equals(this.valorMensalidadeEscolar, other.valorMensalidadeEscolar)) {
            return false;
        }
        if (!Arrays.equals(this.arquivoDespesaMensalidadeEscolar, other.arquivoDespesaMensalidadeEscolar)) {
            return false;
        }
        if (!Objects.equals(this.telefone, other.telefone)) {
            return false;
        }
        if (!Objects.equals(this.valorTelefone, other.valorTelefone)) {
            return false;
        }
        if (!Arrays.equals(this.arquivoDespesaTelefone, other.arquivoDespesaTelefone)) {
            return false;
        }
        if (!Objects.equals(this.endividamento, other.endividamento)) {
            return false;
        }
        if (!Objects.equals(this.valorEndividamento, other.valorEndividamento)) {
            return false;
        }
        if (!Arrays.equals(this.arquivoDespesaEndividamento, other.arquivoDespesaEndividamento)) {
            return false;
        }
        if (!Objects.equals(this.internet, other.internet)) {
            return false;
        }
        if (!Objects.equals(this.valorInternet, other.valorInternet)) {
            return false;
        }
        if (!Arrays.equals(this.arquivoDespesaInternet, other.arquivoDespesaInternet)) {
            return false;
        }
        if (!Objects.equals(this.agua, other.agua)) {
            return false;
        }
        if (!Objects.equals(this.valorAgua, other.valorAgua)) {
            return false;
        }
        if (!Arrays.equals(this.arquivoDespesaAgua, other.arquivoDespesaAgua)) {
            return false;
        }
        if (!Objects.equals(this.medicamentos, other.medicamentos)) {
            return false;
        }
        if (!Objects.equals(this.valorMedicamentos, other.valorMedicamentos)) {
            return false;
        }
        if (!Arrays.equals(this.arquivoDespesaMedicamentos, other.arquivoDespesaMedicamentos)) {
            return false;
        }
        if (!Objects.equals(this.luz, other.luz)) {
            return false;
        }
        if (!Objects.equals(this.valorLuz, other.valorLuz)) {
            return false;
        }
        if (!Arrays.equals(this.arquivoDespesaLuz, other.arquivoDespesaLuz)) {
            return false;
        }
        if (!Objects.equals(this.planoSaude, other.planoSaude)) {
            return false;
        }
        if (!Objects.equals(this.valorPlanoSaude, other.valorPlanoSaude)) {
            return false;
        }
        if (!Arrays.equals(this.arquivoDespesaPlanoSaude, other.arquivoDespesaPlanoSaude)) {
            return false;
        }
        if (!Objects.equals(this.financiamentos, other.financiamentos)) {
            return false;
        }
        if (!Objects.equals(this.valorFinanciamentos, other.valorFinanciamentos)) {
            return false;
        }
        if (!Arrays.equals(this.arquivoDespesaFinanciamentos, other.arquivoDespesaFinanciamentos)) {
            return false;
        }
        if (!Objects.equals(this.transporte, other.transporte)) {
            return false;
        }
        if (!Objects.equals(this.valorTransporte, other.valorTransporte)) {
            return false;
        }
        if (!Arrays.equals(this.arquivoDespesaTransporte, other.arquivoDespesaTransporte)) {
            return false;
        }
        if (!Objects.equals(this.investimentosEducacao, other.investimentosEducacao)) {
            return false;
        }
        if (!Objects.equals(this.valorInvestimentosEducacao, other.valorInvestimentosEducacao)) {
            return false;
        }
        if (!Arrays.equals(this.arquivoDespesaInvestimentosEducacao, other.arquivoDespesaInvestimentosEducacao)) {
            return false;
        }
        if (!Objects.equals(this.outros, other.outros)) {
            return false;
        }
        if (!Objects.equals(this.valorOutros, other.valorOutros)) {
            return false;
        }
        if (!Arrays.equals(this.arquivoDespesaOutros, other.arquivoDespesaOutros)) {
            return false;
        }
        return true;
    }

    
    
}
