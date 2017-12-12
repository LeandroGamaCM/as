package br.edu.ifba.as.entidades.formulario;

import java.io.Serializable;
import java.util.List;
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
    
    @OneToMany(mappedBy = "membro_familiar", fetch = FetchType.LAZY)
    private List<Doenca> doencas;
    
    private String nome;
    private String parentesco;
    private String escolaridade;
    private Double salario;
    private Integer idade;

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
    
    
}
