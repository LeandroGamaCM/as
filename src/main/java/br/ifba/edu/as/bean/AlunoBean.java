package br.ifba.edu.as.bean;

import br.edu.ifba.as.entidades.enums.*;
import br.edu.ifba.as.entidades.formulario.*;
import br.edu.ifba.as.rn.AlunoRN;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.*;
import org.primefaces.event.FlowEvent;

@ManagedBean(name = "alunoBean")
@ViewScoped // Ver diferença do RequestScoped ----------------------------------
public class AlunoBean implements Serializable{
    private Aluno aluno = new Aluno();
    private BolsasAuxilio bolsasAuxilio;
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
    
    private String[] selectedDependentes;
    private String[] selectedSustentadores;
    private String[] selectedResidencia;
    private String[] selectedBolsasAuxilio;
    private List<MembroFamiliar> membrosFamiliares;
    private List<Renda> rendas;
    private List<Despesa> despesas;

    public void salvar(){
       setDependentesProperties();
       setCondicaoManutencaoProperties();
//        AlunoRN alunoRN = new AlunoRN();
//        alunoRN.salvar(this.aluno);
        System.out.println(
//                "\nNome: " + aluno.getNome() + 
//                "\nSexo: " + aluno.getSexo() + 
//                "\nApelido: " + aluno.getApelido() + 
//                "\nDataNasc: " + aluno.getDataNascimento().toString() + 
//                "\nEstado Civil: " + aluno.getEstadoCivil() + 
//                "\nTem dependentes: " + dependentes.getPossuiDependente() +
//                "\nQuantos dependentes: " + dependentes.getQuantos() + 
//                "\nCompanheiro: " + dependentes.getCompanheiro() + 
//                "\nFilho: " + dependentes.getFilho() + 
//                "\nIdoso: " + dependentes.getIdoso() +
//                "\nOutro: " + dependentes.getOutro() +
//                "\tNome Outro: " + dependentes.getOutroDependente() +
//                "\nTurno: " + informacoesCurriculares.getTurno()+
//                "\nCurso: " + informacoesCurriculares.getCurso()+
//                "\nConta: " + conta.getPossuiConta()+
//                "\nBanco: " + conta.getNomeBanco()+
//                "\nCC: " + conta.getContaCorrente()+
//                "\nAgencia: " + conta.getAgencia()+
//                "\nOperacao: " + conta.getOperacao()+
                
//                "\nCurso Preparatorio: " + informacoesCurriculares.getCursoPreparatorio()+
//                "\nnome CP: " + informacoesCurriculares.getNomeCursoPreparatorio()+
//                "\nOnde Estudou" + informacoesCurriculares.getOndeEstudou()+
//                "\nInterrupcao Estudos: " + informacoesCurriculares.getInterrupcaoEstudos()+
//                "\nMotivo Int: " + informacoesCurriculares.getMotivoInterrupcao()+
//                "\nTempo Int: "+ informacoesCurriculares.getTempoInterrupcao()+
//                "\nQuando aconteceu: " + informacoesCurriculares.getDataInterrupcao().toString()+
//                "\nAceeso internet: " + situacaoResidencial.getAcessoInternet()+
//                "\nTrabalha: " + ocupacao.getPossuiTrabalho()+
//                "\nTipo Trabalho: " + ocupacao.getTrabalho()+
//                "\nProfissao: "+ ocupacao.getProfissao()+
//                "\nNome Empr: " + ocupacao.getNomeEmpregador()+
//                "\nTelefone Emp: " + ocupacao.getTelefoneEmpregador()+
//                "\nTempo Servico: "+ ocupacao.getTempoServico()+
//                "\nsalario: " + ocupacao.getSalarioMensal()
                
//                "\nSustentado por pais : " + condicaoManutencao.getAmbosPais() +
//                "\nSustentado por pai : " + condicaoManutencao.getApenasPai()+
//                "\nSustentado por mae : " + condicaoManutencao.getApenasMae()+
//                "\nSustentado por avo : " + condicaoManutencao.getAvos() +
//                "\nSustentado por otroParente : " + condicaoManutencao.getOutrosParentes() +
//                "\nSustentado por outro jeito : " + condicaoManutencao.getOutrosMeios() +
//                "\nParentesco: " + condicaoManutencao.getParentesco()+
//                "\noutro Meio: " + condicaoManutencao.getNomeOutrosMeios() +
//                "\n despesa alime: " + despesasCampus.getAlimentacao() +
//                "\n despesa trabs: " + despesasCampus.getTrabalhos() +
//                "\n despesa materisas: " + despesasCampus.getMateriaisEscolares() +
//                "\nCom quem mora: " + situacaoResidencial.getComQuemMora()+
//                "\nOutro parente: "+situacaoResidencial.getMoraComQuemOutro()+
//                "\ndespesas extrars: "+ situacaoResidencial.getDespesasExtra()+
//                "\nOnde reside: " + situacaoResidencial.getSituacaoCasa()+
//                "\nAluguel: "+ situacaoResidencial.getValorAluguel()+
//                "\nquem Emprestou: "+ situacaoResidencial.getCasaQuemEmprestou()
                residenciaFamilia.getZona()
        );

    }
    
    public String onFlowProcess(FlowEvent event) {
        return event.getNewStep();
      } 

    public void setCondicaoManutencaoProperties(){
        int i;
        if(selectedSustentadores != null){
            for(i=0;i<selectedSustentadores.length;i++){
                if("pm".equals(selectedSustentadores[i]))
                    condicaoManutencao.setAmbosPais(Boolean.TRUE);
                if("p".equals(selectedSustentadores[i]))
                    condicaoManutencao.setApenasPai(Boolean.TRUE);
                if("m".equals(selectedSustentadores[i]))
                    condicaoManutencao.setApenasMae(Boolean.TRUE);
                if("op".equals(selectedSustentadores[i]))
                    condicaoManutencao.setOutrosParentes(Boolean.TRUE);
                if("om".equals(selectedSustentadores[i]))
                    condicaoManutencao.setOutrosMeios(Boolean.TRUE);
                if("v".equals(selectedSustentadores[i]))
                    condicaoManutencao.setAvos(Boolean.TRUE);
            }
        }
    }
    
    public void setBolsasAuxilioProperties(){
        int i;
        if(selectedBolsasAuxilio != null){
            for(i=0;i<selectedBolsasAuxilio.length;i++){
                if("m".equals(selectedBolsasAuxilio[i]))
                    bolsasAuxilio.setMonitoria(Boolean.TRUE);
                if("c".equals(selectedBolsasAuxilio[i]))
                    bolsasAuxilio.setPibic(Boolean.TRUE);
                if("j".equals(selectedBolsasAuxilio[i]))
                    bolsasAuxilio.setPibicjr(Boolean.TRUE);
                if("d".equals(selectedBolsasAuxilio[i]))
                    bolsasAuxilio.setPibid(Boolean.TRUE);
                if("e".equals(selectedBolsasAuxilio[i]))
                    bolsasAuxilio.setProgramaExtensao(Boolean.TRUE);
            }
        }
    }
    public void setResidenciaFamilaProperties(){
        int i;
        if(selectedResidencia != null){
            for(i=0;i<selectedResidencia.length;i++){
                if("e".equals(selectedResidencia[i]))
                    residencia.setRedeEsgoto(Boolean.TRUE);
                if("f".equals(selectedResidencia[i]))
                    residencia.setFossa(Boolean.TRUE);
                if("b".equals(selectedResidencia[i]))
                    residencia.setBanheiro(Boolean.TRUE);
                if("c".equals(selectedResidencia[i]))
                    residencia.setChuveiro(Boolean.TRUE);
                if("l".equals(selectedResidencia[i]))
                    residencia.setLuz(Boolean.TRUE);
                if("a".equals(selectedResidencia[i]))
                    residencia.setAgua(Boolean.TRUE);
            }            
        }
        
    }
    
    
    public void setDependentesProperties(){
        int i;
        if(selectedDependentes != null){
            for(i=0;i<selectedDependentes.length;i++){
                if("c".equals(selectedDependentes[i]))
                    dependentes.setCompanheiro(Boolean.TRUE);
                if("f".equals(selectedDependentes[i]))
                    dependentes.setFilho(Boolean.TRUE);
                if("i".equals(selectedDependentes[i]))
                    dependentes.setIdoso(Boolean.TRUE);
                if("o".equals(selectedDependentes[i]))
                    dependentes.setOutro(Boolean.TRUE);
            }            
        }
    }
    
    
    
// Getters e Setters

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

    public String[] getSelectedDependentes() {
        return selectedDependentes;
    }

    public void setSelectedDependentes(String[] selectedDependentes) {
        this.selectedDependentes = selectedDependentes;
    }

    public String[] getSelectedSustentadores() {
        return selectedSustentadores;
    }

    public void setSelectedSustentadores(String[] selectedSustentadores) {
        this.selectedSustentadores = selectedSustentadores;
    }

    public String[] getSelectedResidencia() {
        return selectedResidencia;
    }

    public void setSelectedResidencia(String[] selectedResidencia) {
        this.selectedResidencia = selectedResidencia;
    }

    public String[] getSelectedBolsasAuxilio() {
        return selectedBolsasAuxilio;
    }

    public void setSelectedBolsasAuxilio(String[] selectedBolsasAuxilio) {
        this.selectedBolsasAuxilio = selectedBolsasAuxilio;
    }

    public List<MembroFamiliar> getMembrosFamiliares() {
        return membrosFamiliares;
    }

    public void setMembrosFamiliares(List<MembroFamiliar> membrosFamiliares) {
        this.membrosFamiliares = membrosFamiliares;
    }

    public List<Renda> getRendas() {
        return rendas;
    }

    public void setRendas(List<Renda> rendas) {
        this.rendas = rendas;
    }

    public List<Despesa> getDespesas() {
        return despesas;
    }

    public void setDespesas(List<Despesa> despesas) {
        this.despesas = despesas;
    }




    
}
