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
    @GeneratedValue
    @Column(name = "cod_despesa")
    private Integer despesa;

    @ManyToOne
    @JoinColumn(name = "cod_familia")
    private Familia familia;
    
    @Column(name = "nome_despesa")
    private String nomeDespesa;
    @Column(name = "valor_despesa")
    private Double valorDespesa;


// Variáveis fixas
//    private Boolean aluguel;
//    @Column(name = "valor_aluguel")
//    private Double valorAluguel;
//
//    @Column(name = "mensalidade_escolar")
//    private Boolean mensalidadeEscolar;
//    @Column(name = "valor_mensalidade_escolar")
//    private Double valorMensalidadeEscolar;
//
//    private Boolean telefone;
//    @Column(name = "valor_telefone")
//    private Double valorTelefone;
//    
//    private Boolean internet;
//    @Column(name = "valor_internet")
//    private Double valorInternet;
//
//    private Boolean agua;
//    @Column(name = "valor_agua")
//    private Double valorAgua;
//
//    private Boolean medicamentos;
//    @Column(name = "valor_medicamentos")
//    private Double valorMedicamentos;
//
//    private Boolean luz;
//    @Column(name = "valor_luz")
//    private Double valorLuz;
//
//    @Column(name = "plano_saude")
//    private Boolean planoSaude;
//    @Column(name = "valor_plano_saude")
//    private Double valorPlanoSaude;
//
//    private Boolean financiamentos;
//    @Column(name = "valor_financiamentos")
//    private Double valorFinanciamentos;
//
//    private Boolean transporte;
//    @Column(name = "valor_transporte")
//    private Double valorTransporte;
//
//    @Column(name = "investimentos_educacao")
//    private Boolean investimentosEducacao;
//    @Column(name = "valor_investimentos_educacao")
//    private Double valorInvestimentosEducacao;
//
//    private Boolean outros;
//    @Column(name = "valor_outros")
//    private Double valorOutros;

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

    public String getNomeDespesa() {
        return nomeDespesa;
    }

    public void setNomeDespesa(String nomeDespesa) {
        this.nomeDespesa = nomeDespesa;
    }

    public Double getValorDespesa() {
        return valorDespesa;
    }

    public void setValorDespesa(Double valorDespesa) {
        this.valorDespesa = valorDespesa;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.despesa);
        hash = 79 * hash + Objects.hashCode(this.familia);
        hash = 79 * hash + Objects.hashCode(this.nomeDespesa);
        hash = 79 * hash + Objects.hashCode(this.valorDespesa);
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
        if (!Objects.equals(this.nomeDespesa, other.nomeDespesa)) {
            return false;
        }
        if (!Objects.equals(this.despesa, other.despesa)) {
            return false;
        }
        if (!Objects.equals(this.familia, other.familia)) {
            return false;
        }
        if (!Objects.equals(this.valorDespesa, other.valorDespesa)) {
            return false;
        }
        return true;
    }

}
