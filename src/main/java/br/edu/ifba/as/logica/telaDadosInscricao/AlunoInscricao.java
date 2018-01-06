package br.edu.ifba.as.logica.telaDadosInscricao;

import br.edu.ifba.as.entidades.formulario.Aluno;
import br.edu.ifba.as.entidades.formulario.BolsasAuxilio;
import br.edu.ifba.as.entidades.formulario.CondicaoManutencao;
import br.edu.ifba.as.entidades.formulario.Conta;
import br.edu.ifba.as.entidades.formulario.Dependentes;
import br.edu.ifba.as.entidades.formulario.Despesa;
import br.edu.ifba.as.entidades.formulario.DespesasCampus;
import br.edu.ifba.as.entidades.formulario.Doenca;
import br.edu.ifba.as.entidades.formulario.Endereco;
import br.edu.ifba.as.entidades.formulario.Familia;
import br.edu.ifba.as.entidades.formulario.Formulario;
import br.edu.ifba.as.entidades.formulario.Imovel;
import br.edu.ifba.as.entidades.formulario.InformacoesCurriculares;
import br.edu.ifba.as.entidades.formulario.MembroFamiliar;
import br.edu.ifba.as.entidades.formulario.Ocupacao;
import br.edu.ifba.as.entidades.formulario.Renda;
import br.edu.ifba.as.entidades.formulario.Residencia;
import br.edu.ifba.as.entidades.formulario.ResidenciaFamilia;
import br.edu.ifba.as.entidades.formulario.SituacaoResidencial;
import br.edu.ifba.as.entidades.formulario.Turma;
import br.edu.ifba.as.entidades.usuario.Usuario;
import br.edu.ifba.as.rn.AlunoRN;
import br.edu.ifba.as.rn.BolsasAuxilioRN;
import br.edu.ifba.as.rn.CondicaoManutencaoRN;
import br.edu.ifba.as.rn.ContaRN;
import br.edu.ifba.as.rn.DependentesRN;
import br.edu.ifba.as.rn.DespesaRN;
import br.edu.ifba.as.rn.DespesasCampusRN;
import br.edu.ifba.as.rn.DoencaRN;
import br.edu.ifba.as.rn.EnderecoRN;
import br.edu.ifba.as.rn.FamiliaRN;
import br.edu.ifba.as.rn.FormularioRN;
import br.edu.ifba.as.rn.ImovelRN;
import br.edu.ifba.as.rn.InformacoesCurricularesRN;
import br.edu.ifba.as.rn.MembroFamiliarRN;
import br.edu.ifba.as.rn.OcupacaoRN;
import br.edu.ifba.as.rn.RendaRN;
import br.edu.ifba.as.rn.ResidenciaFamiliaRN;
import br.edu.ifba.as.rn.ResidenciaRN;
import br.edu.ifba.as.rn.SituacaoResidencialRN;
import br.edu.ifba.as.rn.TurmaRN;
import br.edu.ifba.as.rn.UsuarioRN;

public class AlunoInscricao {
    private Aluno aluno = new Aluno();
    private BolsasAuxilio bolsasAuxilio = new BolsasAuxilio();
    private CondicaoManutencao condicaoManutencao = new CondicaoManutencao();
    private Conta conta = new Conta();
    private Dependentes dependentes = new Dependentes();
    private Despesa despesa = new Despesa();
    private DespesasCampus despesasCampus = new DespesasCampus();
    private Doenca doenca = new Doenca();
    private Endereco endereco = new Endereco();
    private Familia familia = new Familia();
    private Formulario formulario = new Formulario();
    private Imovel imovel = new Imovel();
    private InformacoesCurriculares informacoesCurriculares = new InformacoesCurriculares();
    private MembroFamiliar membroFamiliar = new MembroFamiliar();
    private Ocupacao ocupacao = new Ocupacao();
    private Renda renda = new Renda();
    private Residencia residencia = new Residencia();
    private ResidenciaFamilia residenciaFamilia = new ResidenciaFamilia();
    private SituacaoResidencial situacaoResidencial = new SituacaoResidencial();
    private Turma turma = new Turma();
    private Usuario usuario = new Usuario();

    public AlunoInscricao(Aluno aluno) {
        AlunoRN alunoRN = new AlunoRN();
        BolsasAuxilioRN bolsasAuxilioRN = new BolsasAuxilioRN();
        CondicaoManutencaoRN condicaoManutencaoRN = new CondicaoManutencaoRN();
        ContaRN contaRN = new ContaRN();
        DependentesRN dependentesRN = new DependentesRN();
        DespesasCampusRN despesasCampusRN = new DespesasCampusRN();
        EnderecoRN enderecoRN = new EnderecoRN();
        FamiliaRN familiaRN = new FamiliaRN();
            ImovelRN imovelRN = new ImovelRN();
            DespesaRN despesaRN = new DespesaRN();
            MembroFamiliarRN membroFamiliarRN = new MembroFamiliarRN();
                DoencaRN doencaRN = new DoencaRN();
            RendaRN rendaRN = new RendaRN();
            ResidenciaFamiliaRN residenciaFamiliaRN = new ResidenciaFamiliaRN();
        FormularioRN formularioRN = new FormularioRN();
        InformacoesCurricularesRN informacoesCurricularesRN = new InformacoesCurricularesRN();
        OcupacaoRN ocupacaoRN = new OcupacaoRN();
        ResidenciaRN residenciaRN = new ResidenciaRN();
        SituacaoResidencialRN situacaoResidencialRN = new SituacaoResidencialRN();    
        TurmaRN turmaRN = new TurmaRN();
        UsuarioRN usuarioRN = new UsuarioRN();        
    }

    
    
    
    
// Getters e Setters
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public BolsasAuxilio getBolsasAuxilio() {
        return bolsasAuxilio;
    }

    public void setBolsasAuxilio(BolsasAuxilio bolsasAuxilio) {
        this.bolsasAuxilio = bolsasAuxilio;
    }

    public CondicaoManutencao getCondicaoManutencao() {
        return condicaoManutencao;
    }

    public void setCondicaoManutencao(CondicaoManutencao condicaoManutencao) {
        this.condicaoManutencao = condicaoManutencao;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public Dependentes getDependentes() {
        return dependentes;
    }

    public void setDependentes(Dependentes dependentes) {
        this.dependentes = dependentes;
    }

    public Despesa getDespesa() {
        return despesa;
    }

    public void setDespesa(Despesa despesa) {
        this.despesa = despesa;
    }

    public DespesasCampus getDespesasCampus() {
        return despesasCampus;
    }

    public void setDespesasCampus(DespesasCampus despesasCampus) {
        this.despesasCampus = despesasCampus;
    }

    public Doenca getDoenca() {
        return doenca;
    }

    public void setDoenca(Doenca doenca) {
        this.doenca = doenca;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
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

    public Imovel getImovel() {
        return imovel;
    }

    public void setImovel(Imovel imovel) {
        this.imovel = imovel;
    }

    public InformacoesCurriculares getInformacoesCurriculares() {
        return informacoesCurriculares;
    }

    public void setInformacoesCurriculares(InformacoesCurriculares informacoesCurriculares) {
        this.informacoesCurriculares = informacoesCurriculares;
    }

    public MembroFamiliar getMembroFamiliar() {
        return membroFamiliar;
    }

    public void setMembroFamiliar(MembroFamiliar membroFamiliar) {
        this.membroFamiliar = membroFamiliar;
    }

    public Ocupacao getOcupacao() {
        return ocupacao;
    }

    public void setOcupacao(Ocupacao ocupacao) {
        this.ocupacao = ocupacao;
    }

    public Renda getRenda() {
        return renda;
    }

    public void setRenda(Renda renda) {
        this.renda = renda;
    }

    public Residencia getResidencia() {
        return residencia;
    }

    public void setResidencia(Residencia residencia) {
        this.residencia = residencia;
    }

    public ResidenciaFamilia getResidenciaFamilia() {
        return residenciaFamilia;
    }

    public void setResidenciaFamilia(ResidenciaFamilia residenciaFamilia) {
        this.residenciaFamilia = residenciaFamilia;
    }

    public SituacaoResidencial getSituacaoResidencial() {
        return situacaoResidencial;
    }

    public void setSituacaoResidencial(SituacaoResidencial situacaoResidencial) {
        this.situacaoResidencial = situacaoResidencial;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }
    
    
}
