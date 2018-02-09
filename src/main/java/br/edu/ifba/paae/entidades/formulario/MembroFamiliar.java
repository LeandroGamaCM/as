package br.edu.ifba.paae.entidades.formulario;

import java.io.Serializable;
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

    @Column(name = "arquivo_renda")
    private String arquivoRenda;
    
    private String nome;
    private String parentesco;
    private String escolaridade;
    private Double salario;
    private Integer idade;

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

    public String getArquivoRenda() {
        return arquivoRenda;
    }

    public void setArquivoRenda(String arquivoRenda) {
        this.arquivoRenda = arquivoRenda;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.membroFamiliar);
        hash = 37 * hash + Objects.hashCode(this.familia);
        hash = 37 * hash + Objects.hashCode(this.arquivoRenda);
        hash = 37 * hash + Objects.hashCode(this.nome);
        hash = 37 * hash + Objects.hashCode(this.parentesco);
        hash = 37 * hash + Objects.hashCode(this.escolaridade);
        hash = 37 * hash + Objects.hashCode(this.salario);
        hash = 37 * hash + Objects.hashCode(this.idade);
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
        if (!Objects.equals(this.arquivoRenda, other.arquivoRenda)) {
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
        if (!Objects.equals(this.membroFamiliar, other.membroFamiliar)) {
            return false;
        }
        if (!Objects.equals(this.familia, other.familia)) {
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
