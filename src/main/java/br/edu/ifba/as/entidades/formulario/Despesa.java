// Obs -------------------------------------------------------------------------
// Despesa pertence ao pacote familia e o Id tem que mudar
package br.edu.ifba.as.entidades.formulario;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "despesa")
public class Despesa implements Serializable {
    private static final long serialVersionUID = 1176719091871813715L;

    @Id
    @GeneratedValue(generator = "fk_despesa_cod_aluno")
    @GenericGenerator(name = "fk_despesa_cod_aluno", strategy = "foreign",
            parameters = @org.hibernate.annotations.Parameter(name = "property", value = "familia"))
    @Column(name = "cod_familia")
    private Integer despesa;
    
    @OneToOne(mappedBy = "despesa")
    private Familia familia;
    
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

    public boolean isAluguel() {
        return aluguel;
    }

    public void setAluguel(boolean aluguel) {
        this.aluguel = aluguel;
    }

    public Double getValorAluguel() {
        return valorAluguel;
    }

    public void setValorAluguel(Double valorAluguel) {
        this.valorAluguel = valorAluguel;
    }

    public boolean isMensalidadeEscolar() {
        return mensalidadeEscolar;
    }

    public void setMensalidadeEscolar(boolean mensalidadeEscolar) {
        this.mensalidadeEscolar = mensalidadeEscolar;
    }

    public Double getValorMensalidadeEscolar() {
        return valorMensalidadeEscolar;
    }

    public void setValorMensalidadeEscolar(Double valorMensalidadeEscolar) {
        this.valorMensalidadeEscolar = valorMensalidadeEscolar;
    }

    public boolean isTelefone() {
        return telefone;
    }

    public void setTelefone(boolean telefone) {
        this.telefone = telefone;
    }

    public Double getValorTelefone() {
        return valorTelefone;
    }

    public void setValorTelefone(Double valorTelefone) {
        this.valorTelefone = valorTelefone;
    }

    public boolean isInternet() {
        return internet;
    }

    public void setInternet(boolean internet) {
        this.internet = internet;
    }

    public Double getValorInternet() {
        return valorInternet;
    }

    public void setValorInternet(Double valorInternet) {
        this.valorInternet = valorInternet;
    }

    public boolean isAgua() {
        return agua;
    }

    public void setAgua(boolean agua) {
        this.agua = agua;
    }

    public Double getValorAgua() {
        return valorAgua;
    }

    public void setValorAgua(Double valorAgua) {
        this.valorAgua = valorAgua;
    }

    public boolean isMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(boolean medicamentos) {
        this.medicamentos = medicamentos;
    }

    public Double getValorMedicamentos() {
        return valorMedicamentos;
    }

    public void setValorMedicamentos(Double valorMedicamentos) {
        this.valorMedicamentos = valorMedicamentos;
    }

    public boolean isLuz() {
        return luz;
    }

    public void setLuz(boolean luz) {
        this.luz = luz;
    }

    public Double getValorLuz() {
        return valorLuz;
    }

    public void setValorLuz(Double valorLuz) {
        this.valorLuz = valorLuz;
    }

    public boolean isPlanoSaude() {
        return planoSaude;
    }

    public void setPlanoSaude(boolean planoSaude) {
        this.planoSaude = planoSaude;
    }

    public Double getValorPlanoSaude() {
        return valorPlanoSaude;
    }

    public void setValorPlanoSaude(Double valorPlanoSaude) {
        this.valorPlanoSaude = valorPlanoSaude;
    }

    public boolean isFinanciamentos() {
        return financiamentos;
    }

    public void setFinanciamentos(boolean financiamentos) {
        this.financiamentos = financiamentos;
    }

    public Double getValorFinanciamentos() {
        return valorFinanciamentos;
    }

    public void setValorFinanciamentos(Double valorFinanciamentos) {
        this.valorFinanciamentos = valorFinanciamentos;
    }

    public boolean isTransporte() {
        return transporte;
    }

    public void setTransporte(boolean transporte) {
        this.transporte = transporte;
    }

    public Double getValorTransporte() {
        return valorTransporte;
    }

    public void setValorTransporte(Double valorTransporte) {
        this.valorTransporte = valorTransporte;
    }

    public boolean isInvestimentosEducacao() {
        return investimentosEducacao;
    }

    public void setInvestimentosEducacao(boolean investimentosEducacao) {
        this.investimentosEducacao = investimentosEducacao;
    }

    public Double getValorInvestimentosEducacao() {
        return valorInvestimentosEducacao;
    }

    public void setValorInvestimentosEducacao(Double valorInvestimentosEducacao) {
        this.valorInvestimentosEducacao = valorInvestimentosEducacao;
    }

    public boolean isOutros() {
        return outros;
    }

    public void setOutros(boolean outros) {
        this.outros = outros;
    }

    public Double getValorOutros() {
        return valorOutros;
    }

    public void setValorOutros(Double valorOutros) {
        this.valorOutros = valorOutros;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 11 * hash + Objects.hashCode(this.despesa);
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
        if (!Objects.equals(this.despesa, other.despesa)) {
            return false;
        }
        return true;
    }
}
