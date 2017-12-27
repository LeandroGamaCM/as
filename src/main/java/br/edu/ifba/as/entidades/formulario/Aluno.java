// Obs. ------------------------------------------------------------------------
// ATUALIZAR todos os equals e hash codes e getters e setteres

package br.edu.ifba.as.entidades.formulario;

import br.edu.ifba.as.entidades.analise.Bolsa;
import br.edu.ifba.as.entidades.enums.EstadoCivil;
import br.edu.ifba.as.entidades.enums.Sexo;
import br.edu.ifba.as.entidades.usuario.Usuario;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "aluno")
public class Aluno implements Serializable {
    private static final long serialVersionUID = 5907322760668102640L;

    @Id
    @GeneratedValue
    @Column(name = "cod_aluno")
    private Integer aluno;
    
    @Column(unique = true, updatable = false)
    private Integer cpf;

    @Column(unique = true, updatable = false)
    private Integer rg;
    
    @Column(unique = true)
    private String email;                
    
    private String nome;
    private String apelido;
    private Integer telefone;
    
    @Column(name = "data_nascimento", updatable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataNascimento;

    @Enumerated
    @Column(columnDefinition = "smallint")
    private Sexo sexo;

    @Enumerated
    @Column(columnDefinition = "smallint")
    private EstadoCivil estadoCivil;
        
// Relacionamentos
    @OneToOne(mappedBy = "aluno")
    private Usuario usuario;    
    
    @OneToOne(cascade = CascadeType.REMOVE)
    @PrimaryKeyJoinColumn(name = "cod_aluno")
    private BolsasAuxilio bolsas_auxilio;
    
    @OneToOne(cascade = CascadeType.REMOVE)
    @PrimaryKeyJoinColumn(name = "cod_aluno")
    private DespesasCampus despesas_campus;
    
    @OneToOne(cascade = CascadeType.REMOVE)
    @PrimaryKeyJoinColumn(name = "cod_aluno")
    private InformacoesCurriculares informacoes_curriculares;

    @OneToOne(cascade = CascadeType.REMOVE)
    @PrimaryKeyJoinColumn(name = "cod_aluno")
    private CondicaoManutencao condicao_manutencao;

    @OneToOne(cascade = CascadeType.REMOVE)
    @PrimaryKeyJoinColumn(name = "cod_aluno")
    private SituacaoResidencial situacao_residencial;

    @OneToOne(cascade = CascadeType.REMOVE)
    @PrimaryKeyJoinColumn(name = "cod_aluno")
    private Endereco endereco;
    
    @OneToOne(cascade = CascadeType.REMOVE)
    @PrimaryKeyJoinColumn(name = "cod_aluno")
    private Ocupacao ocupacao;
    
    @OneToOne(cascade = CascadeType.REMOVE)
    @PrimaryKeyJoinColumn(name = "cod_aluno")
    private Dependentes dependentes;

    @OneToOne(cascade = CascadeType.REMOVE)
    @PrimaryKeyJoinColumn(name = "cod_aluno")
    private Conta conta;

    @OneToOne(cascade = CascadeType.REMOVE)
    @PrimaryKeyJoinColumn(name = "cod_aluno")
    private Residencia residencia;

    @OneToOne(cascade = CascadeType.REMOVE)
    @PrimaryKeyJoinColumn(name = "cod_aluno")
    private Familia familia;

    @OneToOne(cascade = CascadeType.REMOVE)
    @PrimaryKeyJoinColumn(name = "cod_aluno")
    private Formulario formulario;
    
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "cod_bolsa")
    private Bolsa bolsa;

    public Integer getAluno() {
        return aluno;
    }

    public void setAluno(Integer aluno) {
        this.aluno = aluno;
    }

    public Integer getCpf() {
        return cpf;
    }

    public void setCpf(Integer cpf) {
        this.cpf = cpf;
    }

    public Integer getRg() {
        return rg;
    }

    public void setRg(Integer rg) {
        this.rg = rg;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public Integer getTelefone() {
        return telefone;
    }

    public void setTelefone(Integer telefone) {
        this.telefone = telefone;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public BolsasAuxilio getBolsas_auxilio() {
        return bolsas_auxilio;
    }

    public void setBolsas_auxilio(BolsasAuxilio bolsas_auxilio) {
        this.bolsas_auxilio = bolsas_auxilio;
    }

    public DespesasCampus getDespesas_campus() {
        return despesas_campus;
    }

    public void setDespesas_campus(DespesasCampus despesas_campus) {
        this.despesas_campus = despesas_campus;
    }

    public InformacoesCurriculares getInformacoes_curriculares() {
        return informacoes_curriculares;
    }

    public void setInformacoes_curriculares(InformacoesCurriculares informacoes_curriculares) {
        this.informacoes_curriculares = informacoes_curriculares;
    }

    public CondicaoManutencao getCondicao_manutencao() {
        return condicao_manutencao;
    }

    public void setCondicao_manutencao(CondicaoManutencao condicao_manutencao) {
        this.condicao_manutencao = condicao_manutencao;
    }

    public SituacaoResidencial getSituacao_residencial() {
        return situacao_residencial;
    }

    public void setSituacao_residencial(SituacaoResidencial situacao_residencial) {
        this.situacao_residencial = situacao_residencial;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Ocupacao getOcupacao() {
        return ocupacao;
    }

    public void setOcupacao(Ocupacao ocupacao) {
        this.ocupacao = ocupacao;
    }

    public Dependentes getDependentes() {
        return dependentes;
    }

    public void setDependentes(Dependentes dependentes) {
        this.dependentes = dependentes;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public Residencia getResidencia() {
        return residencia;
    }

    public void setResidencia(Residencia residencia) {
        this.residencia = residencia;
    }

    public Familia getFamilia() {
        return familia;
    }

    public void setFamilia(Familia familia) {
        this.familia = familia;
    }

    public Formulario getFormulario() {
        return formulario;
    }

    public void setFormulario(Formulario formulario) {
        this.formulario = formulario;
    }

    public Bolsa getBolsa() {
        return bolsa;
    }

    public void setBolsa(Bolsa bolsa) {
        this.bolsa = bolsa;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.aluno);
        hash = 37 * hash + Objects.hashCode(this.cpf);
        hash = 37 * hash + Objects.hashCode(this.rg);
        hash = 37 * hash + Objects.hashCode(this.email);
        hash = 37 * hash + Objects.hashCode(this.nome);
        hash = 37 * hash + Objects.hashCode(this.apelido);
        hash = 37 * hash + Objects.hashCode(this.telefone);
        hash = 37 * hash + Objects.hashCode(this.dataNascimento);
        hash = 37 * hash + Objects.hashCode(this.sexo);
        hash = 37 * hash + Objects.hashCode(this.estadoCivil);
        hash = 37 * hash + Objects.hashCode(this.usuario);
        hash = 37 * hash + Objects.hashCode(this.bolsas_auxilio);
        hash = 37 * hash + Objects.hashCode(this.despesas_campus);
        hash = 37 * hash + Objects.hashCode(this.informacoes_curriculares);
        hash = 37 * hash + Objects.hashCode(this.condicao_manutencao);
        hash = 37 * hash + Objects.hashCode(this.situacao_residencial);
        hash = 37 * hash + Objects.hashCode(this.endereco);
        hash = 37 * hash + Objects.hashCode(this.ocupacao);
        hash = 37 * hash + Objects.hashCode(this.dependentes);
        hash = 37 * hash + Objects.hashCode(this.conta);
        hash = 37 * hash + Objects.hashCode(this.residencia);
        hash = 37 * hash + Objects.hashCode(this.familia);
        hash = 37 * hash + Objects.hashCode(this.formulario);
        hash = 37 * hash + Objects.hashCode(this.bolsa);
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
        final Aluno other = (Aluno) obj;
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.apelido, other.apelido)) {
            return false;
        }
        if (!Objects.equals(this.aluno, other.aluno)) {
            return false;
        }
        if (!Objects.equals(this.cpf, other.cpf)) {
            return false;
        }
        if (!Objects.equals(this.rg, other.rg)) {
            return false;
        }
        if (!Objects.equals(this.telefone, other.telefone)) {
            return false;
        }
        if (!Objects.equals(this.dataNascimento, other.dataNascimento)) {
            return false;
        }
        if (this.sexo != other.sexo) {
            return false;
        }
        if (this.estadoCivil != other.estadoCivil) {
            return false;
        }
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        if (!Objects.equals(this.bolsas_auxilio, other.bolsas_auxilio)) {
            return false;
        }
        if (!Objects.equals(this.despesas_campus, other.despesas_campus)) {
            return false;
        }
        if (!Objects.equals(this.informacoes_curriculares, other.informacoes_curriculares)) {
            return false;
        }
        if (!Objects.equals(this.condicao_manutencao, other.condicao_manutencao)) {
            return false;
        }
        if (!Objects.equals(this.situacao_residencial, other.situacao_residencial)) {
            return false;
        }
        if (!Objects.equals(this.endereco, other.endereco)) {
            return false;
        }
        if (!Objects.equals(this.ocupacao, other.ocupacao)) {
            return false;
        }
        if (!Objects.equals(this.dependentes, other.dependentes)) {
            return false;
        }
        if (!Objects.equals(this.conta, other.conta)) {
            return false;
        }
        if (!Objects.equals(this.residencia, other.residencia)) {
            return false;
        }
        if (!Objects.equals(this.familia, other.familia)) {
            return false;
        }
        if (!Objects.equals(this.formulario, other.formulario)) {
            return false;
        }
        if (!Objects.equals(this.bolsa, other.bolsa)) {
            return false;
        }
        return true;
    }

}
