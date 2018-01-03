package br.edu.ifba.as.entidades.analise;

import br.edu.ifba.as.entidades.formulario.Aluno;
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
    
    private String bolsaDesignada;

// Mudar pra aquele tipo de variavel no banco que supeorta muita coisa    
    private String observacoes;

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

    public String getBolsaDesignada() {
        return bolsaDesignada;
    }

    public void setBolsaDesignada(String bolsaDesignada) {
        this.bolsaDesignada = bolsaDesignada;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.entrevista);
        hash = 97 * hash + Objects.hashCode(this.aluno);
        hash = 97 * hash + Objects.hashCode(this.bolsaDesignada);
        hash = 97 * hash + Objects.hashCode(this.observacoes);
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
        if (!Objects.equals(this.bolsaDesignada, other.bolsaDesignada)) {
            return false;
        }
        if (!Objects.equals(this.observacoes, other.observacoes)) {
            return false;
        }
        if (!Objects.equals(this.entrevista, other.entrevista)) {
            return false;
        }
        if (!Objects.equals(this.aluno, other.aluno)) {
            return false;
        }
        return true;
    }
    
    
    
}
