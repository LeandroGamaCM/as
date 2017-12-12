// Obs. ------------------------------------------------------------------------
// COMO VAI SER O NEGÓCIO DA SENHA? 
// ATUALIZAR todos os equals e hash codes e getters e setteres

package br.edu.ifba.as.entidades.formulario;

import br.edu.ifba.as.entidades.analise.Bolsa;
import br.edu.ifba.as.entidades.enums.EstadoCivil;
import br.edu.ifba.as.entidades.enums.Sexo;
import java.io.Serializable;
import java.sql.Date;
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

// Pendentes -------------------------------------------------------------------
    private String senha;
    
    @Column(name = "data_nascimento", updatable = false)
    private Date dataNascimento;
// -----------------------------------------------------------------------------
    
    @Enumerated
    @Column(columnDefinition = "smallint")
    private Sexo sexo;

    @Enumerated
    @Column(columnDefinition = "smallint")
    private EstadoCivil estadoCivil;
    

    @OneToOne
    @PrimaryKeyJoinColumn(name = "cod_aluno")
    private BolsasAuxilio bolsas_auxilio;
    
    @OneToOne
    @PrimaryKeyJoinColumn(name = "cod_aluno")
    private DespesasCampus despesas_campus;
    
    @OneToOne
    @PrimaryKeyJoinColumn(name = "cod_aluno")
    private InformacoesCurriculares informacoes_curriculares;

    @OneToOne
    @PrimaryKeyJoinColumn(name = "cod_aluno")
    private CondicaoManutencao condicao_manutencao;

    @OneToOne
    @PrimaryKeyJoinColumn(name = "cod_aluno")
    private SituacaoResidencial situacao_residencial;

    @OneToOne
    @PrimaryKeyJoinColumn(name = "cod_aluno")
    private Endereco endereco;
    
    @OneToOne
    @PrimaryKeyJoinColumn(name = "cod_aluno")
    private Ocupacao ocupacao;
    
    @OneToOne
    @PrimaryKeyJoinColumn(name = "cod_aluno")
    private Dependentes dependentes;

    @OneToOne
    @PrimaryKeyJoinColumn(name = "cod_aluno")
    private Conta conta;

    @OneToOne
    @PrimaryKeyJoinColumn(name = "cod_aluno")
    private Residencia residencia;

    @OneToOne
    @PrimaryKeyJoinColumn(name = "cod_aluno")
    private Familia familia;

    @OneToOne
    @PrimaryKeyJoinColumn(name = "cod_aluno")
    private Formulario formulario;
    
    @ManyToOne
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
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
        hash = 89 * hash + Objects.hashCode(this.aluno);
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
        if (!Objects.equals(this.aluno, other.aluno)) {
            return false;
        }
        return true;
    }


    
}
