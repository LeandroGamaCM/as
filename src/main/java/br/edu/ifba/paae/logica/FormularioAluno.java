package br.edu.ifba.paae.logica;

import br.edu.ifba.paae.entidades.analise.Entrevista;
import br.edu.ifba.paae.entidades.formulario.Aluno;
import br.edu.ifba.paae.entidades.formulario.BolsasAuxilio;
import br.edu.ifba.paae.entidades.formulario.CondicaoManutencao;
import br.edu.ifba.paae.entidades.formulario.Conta;
import br.edu.ifba.paae.entidades.formulario.Dependentes;
import br.edu.ifba.paae.entidades.formulario.Despesa;
import br.edu.ifba.paae.entidades.formulario.DespesasCampus;
import br.edu.ifba.paae.entidades.formulario.Doenca;
import br.edu.ifba.paae.entidades.formulario.Endereco;
import br.edu.ifba.paae.entidades.formulario.Familia;
import br.edu.ifba.paae.entidades.formulario.Formulario;
import br.edu.ifba.paae.entidades.formulario.Imovel;
import br.edu.ifba.paae.entidades.formulario.InformacoesCurriculares;
import br.edu.ifba.paae.entidades.formulario.MembroFamiliar;
import br.edu.ifba.paae.entidades.formulario.Ocupacao;
import br.edu.ifba.paae.entidades.formulario.Renda;
import br.edu.ifba.paae.entidades.formulario.Residencia;
import br.edu.ifba.paae.entidades.formulario.ResidenciaFamilia;
import br.edu.ifba.paae.entidades.formulario.SituacaoResidencial;
import br.edu.ifba.paae.entidades.formulario.Turma;
import br.edu.ifba.paae.entidades.inscricao.PeriodoInscricao;
import br.edu.ifba.paae.entidades.usuario.Usuario;
import br.edu.ifba.paae.rn.formulario.AlunoRN;
import br.edu.ifba.paae.rn.formulario.BolsasAuxilioRN;
import br.edu.ifba.paae.rn.formulario.CondicaoManutencaoRN;
import br.edu.ifba.paae.rn.formulario.ContaRN;
import br.edu.ifba.paae.rn.formulario.DependentesRN;
import br.edu.ifba.paae.rn.formulario.DespesaRN;
import br.edu.ifba.paae.rn.formulario.DespesasCampusRN;
import br.edu.ifba.paae.rn.formulario.DoencaRN;
import br.edu.ifba.paae.rn.formulario.EnderecoRN;
import br.edu.ifba.paae.rn.formulario.FamiliaRN;
import br.edu.ifba.paae.rn.formulario.FormularioRN;
import br.edu.ifba.paae.rn.formulario.ImovelRN;
import br.edu.ifba.paae.rn.formulario.InformacoesCurricularesRN;
import br.edu.ifba.paae.rn.formulario.MembroFamiliarRN;
import br.edu.ifba.paae.rn.formulario.OcupacaoRN;
import br.edu.ifba.paae.rn.formulario.RendaRN;
import br.edu.ifba.paae.rn.formulario.ResidenciaFamiliaRN;
import br.edu.ifba.paae.rn.formulario.ResidenciaRN;
import br.edu.ifba.paae.rn.formulario.SituacaoResidencialRN;
import br.edu.ifba.paae.rn.formulario.TurmaRN;
import br.edu.ifba.paae.rn.usuario.UsuarioRN;
import br.edu.ifba.paae.rn.analise.EntrevistaRN;
import br.edu.ifba.paae.rn.inscricao.PeriodoInscricaoRN;
import java.util.ArrayList;
import java.util.List;

public class FormularioAluno {

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
    private List<MembroFamiliar> membroFamiliars = new ArrayList<>();
    private Ocupacao ocupacao = new Ocupacao();
    private Renda renda = new Renda();
    private Residencia residencia = new Residencia();
    private ResidenciaFamilia residenciaFamilia = new ResidenciaFamilia();
    private SituacaoResidencial situacaoResidencial = new SituacaoResidencial();
    private Turma turma = new Turma();
    private Usuario usuario = new Usuario();
    private Entrevista entrevista = new Entrevista();
    private PeriodoInscricao periodoInscricao = new PeriodoInscricao();
    
    public FormularioAluno(Aluno aluno) {
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
        EntrevistaRN entrevistaRN = new EntrevistaRN();
        PeriodoInscricaoRN periodoInscricaoRN = new PeriodoInscricaoRN();
        
        this.aluno = aluno;
        this.bolsasAuxilio = bolsasAuxilioRN.buscarPorAluno(aluno.getAluno());
        this.condicaoManutencao = condicaoManutencaoRN.buscarPorAluno(aluno.getAluno());
        this.conta = contaRN.buscarPorAluno(aluno.getAluno());
        this.dependentes = dependentesRN.buscarPorAluno(aluno.getAluno());
        this.despesa = despesaRN.buscarPorFamilia(aluno.getAluno());
        this.despesasCampus = despesasCampusRN.buscarPorAluno(aluno.getAluno());
        this.doenca = doencaRN.buscarPorFamilia(aluno.getAluno());
        this.endereco = enderecoRN.buscarPorAluno(aluno.getAluno());
        this.familia = familiaRN.buscarPorAluno(aluno.getAluno());
        this.formulario = formularioRN.buscarPorAluno(aluno.getAluno());
        this.imovel = imovelRN.buscarPorFamilia(aluno.getAluno());
        this.informacoesCurriculares = informacoesCurricularesRN.buscarPorAluno(aluno.getAluno());
        this.membroFamiliars = membroFamiliarRN.buscarPorFamilia(aluno.getAluno());
        this.ocupacao = ocupacaoRN.buscarPorAluno(aluno.getAluno());
        this.renda = rendaRN.buscarPorFamilia(aluno.getAluno());
        this.residencia = residenciaRN.buscarPorAluno(aluno.getAluno());
        this.residenciaFamilia = residenciaFamiliaRN.buscarPorFamilia(aluno.getAluno());
        this.situacaoResidencial = situacaoResidencialRN.buscarPorAluno(aluno.getAluno());
        this.turma = turmaRN.buscarPorAluno(aluno.getAluno());
        this.usuario = usuarioRN.buscarPorAluno(aluno.getAluno());
        this.entrevista = entrevistaRN.buscarPorAluno(aluno.getAluno());
        this.periodoInscricao = periodoInscricaoRN.buscarPorAluno(aluno.getAluno());
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

    public List<MembroFamiliar> getMembroFamiliars() {
        return membroFamiliars;
    }

    public void setMembroFamiliars(List<MembroFamiliar> membroFamiliars) {
        this.membroFamiliars = membroFamiliars;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Entrevista getEntrevista() {
        return entrevista;
    }

    public void setEntrevista(Entrevista entrevista) {
        this.entrevista = entrevista;
    }

    public PeriodoInscricao getPeriodoInscricao() {
        return periodoInscricao;
    }

    public void setPeriodoInscricao(PeriodoInscricao periodoInscricao) {
        this.periodoInscricao = periodoInscricao;
    }
    
}
