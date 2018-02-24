package br.edu.ifba.paae.entidades.formulario;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "membro_familiar")
public class MembroFamiliar implements Serializable {
    private static final long serialVersionUID = 7256953979726571062L;

    @Id
    @GeneratedValue
    @Column(name = "cod_membro_familiar")
    private Integer membroFamiliar;
    
    @ManyToOne
    @JoinColumn(name = "cod_familia")
    private Familia familia;
    
    @Column(name = "arquivo_renda", length = 1048576)
    private byte[] arquivoRenda;
    @Column(name = "arquivo_renda_nome")
    private String arquivoRendaNome;
    
    private String nome;
    private String parentesco;
    private String escolaridade;
    private Double salario;
    private Integer idade;
    private String sexo;
    @Column(name = "situacao_ocupacional")
    private String situacaoOcupacional;

// Getters e Setters

    public Integer getMembroFamiliar() {
        return membroFamiliar;
    }

    public void setMembroFamiliar(Integer membroFamiliar) {
        this.membroFamiliar = membroFamiliar;
    }

    public Familia getFamilia() {
        return familia;
    }

    public void setFamilia(Familia familia) {
        this.familia = familia;
    }

    public byte[] getArquivoRenda() {
        return arquivoRenda;
    }

    public void setArquivoRenda(byte[] arquivoRenda) {
        this.arquivoRenda = arquivoRenda;
    }

    public String getArquivoRendaNome() {
        return arquivoRendaNome;
    }

    public void setArquivoRendaNome(String arquivoRendaNome) {
        this.arquivoRendaNome = arquivoRendaNome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    public String getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(String escolaridade) {
        this.escolaridade = escolaridade;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getSituacaoOcupacional() {
        return situacaoOcupacional;
    }

    public void setSituacaoOcupacional(String situacaoOcupacional) {
        this.situacaoOcupacional = situacaoOcupacional;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.membroFamiliar);
        hash = 53 * hash + Objects.hashCode(this.familia);
        hash = 53 * hash + Arrays.hashCode(this.arquivoRenda);
        hash = 53 * hash + Objects.hashCode(this.arquivoRendaNome);
        hash = 53 * hash + Objects.hashCode(this.nome);
        hash = 53 * hash + Objects.hashCode(this.parentesco);
        hash = 53 * hash + Objects.hashCode(this.escolaridade);
        hash = 53 * hash + Objects.hashCode(this.salario);
        hash = 53 * hash + Objects.hashCode(this.idade);
        hash = 53 * hash + Objects.hashCode(this.sexo);
        hash = 53 * hash + Objects.hashCode(this.situacaoOcupacional);
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
        final MembroFamiliar other = (MembroFamiliar) obj;
        if (!Objects.equals(this.arquivoRendaNome, other.arquivoRendaNome)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.parentesco, other.parentesco)) {
            return false;
        }
        if (!Objects.equals(this.escolaridade, other.escolaridade)) {
            return false;
        }
        if (!Objects.equals(this.sexo, other.sexo)) {
            return false;
        }
        if (!Objects.equals(this.situacaoOcupacional, other.situacaoOcupacional)) {
            return false;
        }
        if (!Objects.equals(this.membroFamiliar, other.membroFamiliar)) {
            return false;
        }
        if (!Objects.equals(this.familia, other.familia)) {
            return false;
        }
        if (!Arrays.equals(this.arquivoRenda, other.arquivoRenda)) {
            return false;
        }
        if (!Objects.equals(this.salario, other.salario)) {
            return false;
        }
        if (!Objects.equals(this.idade, other.idade)) {
            return false;
        }
        return true;
    }

}
