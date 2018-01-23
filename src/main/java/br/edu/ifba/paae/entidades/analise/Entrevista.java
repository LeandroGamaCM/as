package br.edu.ifba.paae.entidades.analise;

import br.edu.ifba.paae.entidades.formulario.Aluno;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "entrevista")
public class Entrevista implements Serializable{

    private static final long serialVersionUID = 555343895612573351L;

    @Id
    @GeneratedValue(generator = "fk_entrevista_cod_aluno")
    @org.hibernate.annotations.GenericGenerator(name = "fk_entrevista_cod_aluno", 
            strategy = "foreign", parameters = @Parameter(name = "property", value = "aluno"))
    @Column(name = "cod_aluno")
    private Integer entrevista;

    @OneToOne(mappedBy = "entrevista")
    private Aluno aluno;
    
    private Float pontuacaoComposicaoFamiliar;
    private Float pontuacaoCondicaoEconomicaEstudante;
    private Float pontuacaoDespesaAnalise;
    private Float pontuacaoEntrevista;
    private Float pontuacaoEscolaOrigem;
    private Float pontuacaoEtnia;
    private Float pontuacaoGenero;
    private Float pontuacaoLocalResidenciaFamilia;
    private Float pontuacaoMoradiaEstudante;
    private Float pontuacaoMoradiaFamilia;
    private Float pontuacaoProgramaSocial;
    private Float pontuacaoRendaPerCapita;
    private Float pontuacaoRendaPrincipalOrigem;
    private Float pontuacaoSaude;
    private Float pontuacaoSituacaoOcupacional;
    
// Mudar pra aquele tipo de variavel no banco que supeorta muita coisa    
    private String observacoes;

// Getters e Setters

    public Integer getEntrevista() {
        return entrevista;
    }

    public void setEntrevista(Integer entrevista) {
        this.entrevista = entrevista;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Float getPontuacaoComposicaoFamiliar() {
        return pontuacaoComposicaoFamiliar;
    }

    public void setPontuacaoComposicaoFamiliar(Float pontuacaoComposicaoFamiliar) {
        this.pontuacaoComposicaoFamiliar = pontuacaoComposicaoFamiliar;
    }

    public Float getPontuacaoCondicaoEconomicaEstudante() {
        return pontuacaoCondicaoEconomicaEstudante;
    }

    public void setPontuacaoCondicaoEconomicaEstudante(Float pontuacaoCondicaoEconomicaEstudante) {
        this.pontuacaoCondicaoEconomicaEstudante = pontuacaoCondicaoEconomicaEstudante;
    }

    public Float getPontuacaoDespesaAnalise() {
        return pontuacaoDespesaAnalise;
    }

    public void setPontuacaoDespesaAnalise(Float pontuacaoDespesaAnalise) {
        this.pontuacaoDespesaAnalise = pontuacaoDespesaAnalise;
    }

    public Float getPontuacaoEntrevista() {
        return pontuacaoEntrevista;
    }

    public void setPontuacaoEntrevista(Float pontuacaoEntrevista) {
        this.pontuacaoEntrevista = pontuacaoEntrevista;
    }

    public Float getPontuacaoEscolaOrigem() {
        return pontuacaoEscolaOrigem;
    }

    public void setPontuacaoEscolaOrigem(Float pontuacaoEscolaOrigem) {
        this.pontuacaoEscolaOrigem = pontuacaoEscolaOrigem;
    }

    public Float getPontuacaoEtnia() {
        return pontuacaoEtnia;
    }

    public void setPontuacaoEtnia(Float pontuacaoEtnia) {
        this.pontuacaoEtnia = pontuacaoEtnia;
    }

    public Float getPontuacaoGenero() {
        return pontuacaoGenero;
    }

    public void setPontuacaoGenero(Float pontuacaoGenero) {
        this.pontuacaoGenero = pontuacaoGenero;
    }

    public Float getPontuacaoLocalResidenciaFamilia() {
        return pontuacaoLocalResidenciaFamilia;
    }

    public void setPontuacaoLocalResidenciaFamilia(Float pontuacaoLocalResidenciaFamilia) {
        this.pontuacaoLocalResidenciaFamilia = pontuacaoLocalResidenciaFamilia;
    }

    public Float getPontuacaoMoradiaEstudante() {
        return pontuacaoMoradiaEstudante;
    }

    public void setPontuacaoMoradiaEstudante(Float pontuacaoMoradiaEstudante) {
        this.pontuacaoMoradiaEstudante = pontuacaoMoradiaEstudante;
    }

    public Float getPontuacaoMoradiaFamilia() {
        return pontuacaoMoradiaFamilia;
    }

    public void setPontuacaoMoradiaFamilia(Float pontuacaoMoradiaFamilia) {
        this.pontuacaoMoradiaFamilia = pontuacaoMoradiaFamilia;
    }

    public Float getPontuacaoProgramaSocial() {
        return pontuacaoProgramaSocial;
    }

    public void setPontuacaoProgramaSocial(Float pontuacaoProgramaSocial) {
        this.pontuacaoProgramaSocial = pontuacaoProgramaSocial;
    }

    public Float getPontuacaoRendaPerCapita() {
        return pontuacaoRendaPerCapita;
    }

    public void setPontuacaoRendaPerCapita(Float pontuacaoRendaPerCapita) {
        this.pontuacaoRendaPerCapita = pontuacaoRendaPerCapita;
    }

    public Float getPontuacaoRendaPrincipalOrigem() {
        return pontuacaoRendaPrincipalOrigem;
    }

    public void setPontuacaoRendaPrincipalOrigem(Float pontuacaoRendaPrincipalOrigem) {
        this.pontuacaoRendaPrincipalOrigem = pontuacaoRendaPrincipalOrigem;
    }

    public Float getPontuacaoSaude() {
        return pontuacaoSaude;
    }

    public void setPontuacaoSaude(Float pontuacaoSaude) {
        this.pontuacaoSaude = pontuacaoSaude;
    }

    public Float getPontuacaoSituacaoOcupacional() {
        return pontuacaoSituacaoOcupacional;
    }

    public void setPontuacaoSituacaoOcupacional(Float pontuacaoSituacaoOcupacional) {
        this.pontuacaoSituacaoOcupacional = pontuacaoSituacaoOcupacional;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.entrevista);
        hash = 17 * hash + Objects.hashCode(this.aluno);
        hash = 17 * hash + Objects.hashCode(this.pontuacaoComposicaoFamiliar);
        hash = 17 * hash + Objects.hashCode(this.pontuacaoCondicaoEconomicaEstudante);
        hash = 17 * hash + Objects.hashCode(this.pontuacaoDespesaAnalise);
        hash = 17 * hash + Objects.hashCode(this.pontuacaoEntrevista);
        hash = 17 * hash + Objects.hashCode(this.pontuacaoEscolaOrigem);
        hash = 17 * hash + Objects.hashCode(this.pontuacaoEtnia);
        hash = 17 * hash + Objects.hashCode(this.pontuacaoGenero);
        hash = 17 * hash + Objects.hashCode(this.pontuacaoLocalResidenciaFamilia);
        hash = 17 * hash + Objects.hashCode(this.pontuacaoMoradiaEstudante);
        hash = 17 * hash + Objects.hashCode(this.pontuacaoMoradiaFamilia);
        hash = 17 * hash + Objects.hashCode(this.pontuacaoProgramaSocial);
        hash = 17 * hash + Objects.hashCode(this.pontuacaoRendaPerCapita);
        hash = 17 * hash + Objects.hashCode(this.pontuacaoRendaPrincipalOrigem);
        hash = 17 * hash + Objects.hashCode(this.pontuacaoSaude);
        hash = 17 * hash + Objects.hashCode(this.pontuacaoSituacaoOcupacional);
        hash = 17 * hash + Objects.hashCode(this.observacoes);
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
        final Entrevista other = (Entrevista) obj;
        if (!Objects.equals(this.observacoes, other.observacoes)) {
            return false;
        }
        if (!Objects.equals(this.entrevista, other.entrevista)) {
            return false;
        }
        if (!Objects.equals(this.aluno, other.aluno)) {
            return false;
        }
        if (!Objects.equals(this.pontuacaoComposicaoFamiliar, other.pontuacaoComposicaoFamiliar)) {
            return false;
        }
        if (!Objects.equals(this.pontuacaoCondicaoEconomicaEstudante, other.pontuacaoCondicaoEconomicaEstudante)) {
            return false;
        }
        if (!Objects.equals(this.pontuacaoDespesaAnalise, other.pontuacaoDespesaAnalise)) {
            return false;
        }
        if (!Objects.equals(this.pontuacaoEntrevista, other.pontuacaoEntrevista)) {
            return false;
        }
        if (!Objects.equals(this.pontuacaoEscolaOrigem, other.pontuacaoEscolaOrigem)) {
            return false;
        }
        if (!Objects.equals(this.pontuacaoEtnia, other.pontuacaoEtnia)) {
            return false;
        }
        if (!Objects.equals(this.pontuacaoGenero, other.pontuacaoGenero)) {
            return false;
        }
        if (!Objects.equals(this.pontuacaoLocalResidenciaFamilia, other.pontuacaoLocalResidenciaFamilia)) {
            return false;
        }
        if (!Objects.equals(this.pontuacaoMoradiaEstudante, other.pontuacaoMoradiaEstudante)) {
            return false;
        }
        if (!Objects.equals(this.pontuacaoMoradiaFamilia, other.pontuacaoMoradiaFamilia)) {
            return false;
        }
        if (!Objects.equals(this.pontuacaoProgramaSocial, other.pontuacaoProgramaSocial)) {
            return false;
        }
        if (!Objects.equals(this.pontuacaoRendaPerCapita, other.pontuacaoRendaPerCapita)) {
            return false;
        }
        if (!Objects.equals(this.pontuacaoRendaPrincipalOrigem, other.pontuacaoRendaPrincipalOrigem)) {
            return false;
        }
        if (!Objects.equals(this.pontuacaoSaude, other.pontuacaoSaude)) {
            return false;
        }
        if (!Objects.equals(this.pontuacaoSituacaoOcupacional, other.pontuacaoSituacaoOcupacional)) {
            return false;
        }
        return true;
    }
    
}
