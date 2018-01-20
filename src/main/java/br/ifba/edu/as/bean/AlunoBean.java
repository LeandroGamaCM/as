package br.ifba.edu.as.bean;

import br.edu.ifba.as.entidades.analise.Bolsa;
import br.edu.ifba.as.entidades.enums.Zona;
import br.edu.ifba.as.entidades.formulario.*;
import br.edu.ifba.as.rn.*;
import br.edu.ifba.as.rn.analise.BolsaRN;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.PostConstruct;
import javax.faces.bean.*;
import org.primefaces.event.FlowEvent;

@ManagedBean(name = "alunoBean")
@SessionScoped
public class AlunoBean implements Serializable{
    private String estadoTela = "telaFormulario";
    
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
    
    private List<String> listaBolsas = new ArrayList<>();
    
    private String[] selectedDependentes;
    private String[] selectedSustentadores;
    private String[] selectedResidencia;
    private String[] selectedBolsasAuxilio;
    private String[] selectedImoveis;
    
    private List<MembroFamiliar> membrosFamiliares = new ArrayList<>();
    private List<Renda> rendas;
    private List<Despesa> despesas;
    
    private Set<String> turmas;
    private Set<String> cursos;
    private Set<String> modalidades;
    
    private boolean selectedModalidade = false;
    private boolean selectedCurso = false;        
    private boolean dependenteOutro = false;
    
    public String onFlowProcess(FlowEvent event) {
        return event.getNewStep();
    } 
    
    @PostConstruct
    public void init(){
        addMembroFamiliar();
        selecaoBolsa();
        TurmaRN turmaRN = new TurmaRN();
        System.out.println("\n\tAluno bean init");
        List<String> aux = turmaRN.listarModalidades();
        if(aux != null){
            modalidades = new HashSet<>(aux);        
        }
    }
// Controle de Tela
    public boolean isTelaFormulario(){
        return "telaFormulario".equals(this.estadoTela);
    }
    public void changeToFormulario(){
        this.estadoTela = "telaFormulario";
    }
    public boolean isTelaDados(){
        return "telaDados".equals(this.estadoTela);
    }
    public void changeToTelaDados(){
        this.estadoTela = "telaDados";
    }    
    
    
    public void salvar(){
        AlunoRN alunoRN = new AlunoRN();
        TurmaRN turmaRN = new TurmaRN();
        
        System.out.println("turma.getNome: " + turma.getNome());
        turma = turmaRN.buscarTurma(turma.getModalidade(), turma.getCurso(), turma.getNome());
        aluno.setTurma(turma);
                     
        alunoRN.salvar(this.aluno);

        salvarDependenciasAluno(aluno);
        
        System.out.println("salvou!");
    }
    
    public void salvarDependenciasAluno(Aluno aluno){
        // ATENÇÂO: A ordem dessas operações deve ser realizada exatamente do jeito que está! 
        BolsasAuxilioRN bolsasAuxilioRN = new BolsasAuxilioRN();
        CondicaoManutencaoRN condicaoManutencaoRN = new CondicaoManutencaoRN();
        ContaRN contaRN = new ContaRN();
        DependentesRN dependentesRN = new DependentesRN();
        DespesasCampusRN despesasCampusRN = new DespesasCampusRN();
        EnderecoRN enderecoRN = new EnderecoRN();
        FamiliaRN familiaRN = new FamiliaRN();
            ImovelRN imovelRN = new ImovelRN();
            DespesaRN despesaRN = new DespesaRN();
            DoencaRN doencaRN = new DoencaRN();
            RendaRN rendaRN = new RendaRN();
            ResidenciaFamiliaRN residenciaFamiliaRN = new ResidenciaFamiliaRN();
        FormularioRN formularioRN = new FormularioRN();
        InformacoesCurricularesRN informacoesCurricularesRN = new InformacoesCurricularesRN();
        OcupacaoRN ocupacaoRN = new OcupacaoRN();
        ResidenciaRN residenciaRN = new ResidenciaRN();
        SituacaoResidencialRN situacaoResidencialRN = new SituacaoResidencialRN();        

        familia.setAluno(aluno);
        familiaRN.salvar(familia);
        
        salvarMemmrosFamiliares();
        
        setProperties();

        bolsasAuxilioRN.salvar(bolsasAuxilio);
        contaRN.salvar(conta);
        condicaoManutencaoRN.salvar(condicaoManutencao);
        dependentesRN.salvar(dependentes);
        despesasCampusRN.salvar(despesasCampus);
        enderecoRN.salvar(endereco);
        formularioRN.salvar(formulario);
        informacoesCurricularesRN.salvar(informacoesCurriculares);
        ocupacaoRN.salvar(ocupacao);
        residenciaRN.salvar(residencia);
        situacaoResidencialRN.salvar(situacaoResidencial);  

        imovelRN.salvar(imovel);
        despesaRN.salvar(despesa);
        doencaRN.salvar(doenca);
        rendaRN.salvar(renda);
        residenciaFamiliaRN.salvar(residenciaFamilia);

    }
    
    public void salvarMemmrosFamiliares(){
        MembroFamiliarRN membroFamiliarRN = new MembroFamiliarRN();
        int i = 0;
        while(i < membrosFamiliares.size()){
            membroFamiliar = membrosFamiliares.get(i);
            membroFamiliar.setFamilia(familia);
            membroFamiliarRN.salvar(membroFamiliar);
            i++;
        }
    }
    
    public void excluir(){
        // Não é necessário apagar as dependências porque elas se apagam automaticamente por meio do cascate.delete
        AlunoRN alunoRN = new AlunoRN();
        alunoRN.excluir(alunoRN.buscarPorCPF(1111));
        System.out.println("Apagado!");
    }
    
    public void addMembroFamiliar(){
        MembroFamiliar novoMembroFamiliar = new MembroFamiliar();
        membrosFamiliares.add(novoMembroFamiliar);
    }
    
    public void selecaoBolsa(){
        BolsaRN bolsaRN = new BolsaRN();
        List<Bolsa> bolsas = bolsaRN.listar();
        if(bolsas != null){
            int i;
            for(i=0; i<bolsas.size(); i++){
                listaBolsas.add(bolsas.get(i).getNome());
            }
        }
    }
    
    public void selecaoModalidade(){
        TurmaRN turmaRN = new TurmaRN();
        List<String> aux = turmaRN.listarCursos(turma.getModalidade());
        if(aux != null){
            cursos = new HashSet<>(aux);
            selectedModalidade = true;
        }
    }
    public void selecaoCurso(){
        TurmaRN turmaRN = new TurmaRN();
        List<String> aux = turmaRN.listarTurmas(turma.getModalidade(), turma.getCurso());
        if(aux != null){
            turmas = new HashSet<>(aux);
            selectedCurso = true;
        }
    }
    
    public void setProperties(){
        setCondicaoManutencaoProperties();
        setBolsasAuxilioProperties();
        setResidenciaFamilaProperties();
        setDependentesProperties();
        
            bolsasAuxilio.setAluno(aluno);
            condicaoManutencao.setAluno(aluno);
            conta.setAluno(aluno);
            dependentes.setAluno(aluno);
            despesasCampus.setAluno(aluno);
            endereco.setAluno(aluno);
                imovel.setFamilia(familia);
                despesa.setFamilia(familia);
                renda.setFamilia(familia);
                residenciaFamilia.setFamilia(familia);
                doenca.setFamilia(familia);
            formulario.setAluno(aluno);
            informacoesCurriculares.setAluno(aluno);
            ocupacao.setAluno(aluno);
            residencia.setAluno(aluno);
            situacaoResidencial.setAluno(aluno);        
    }
    
    public void setCondicaoManutencaoProperties(){
        int i;
        condicaoManutencao.setAmbosPais(Boolean.FALSE);
        condicaoManutencao.setApenasPai(Boolean.FALSE);
        condicaoManutencao.setApenasMae(Boolean.FALSE);
        condicaoManutencao.setOutrosParentes(Boolean.FALSE);
        condicaoManutencao.setOutrosMeios(Boolean.FALSE);
        condicaoManutencao.setAvos(Boolean.FALSE);

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
        bolsasAuxilio.setMonitoria(Boolean.FALSE);
        bolsasAuxilio.setPibic(Boolean.FALSE);
        bolsasAuxilio.setPibicjr(Boolean.FALSE);
        bolsasAuxilio.setPibid(Boolean.FALSE);
        bolsasAuxilio.setProgramaExtensao(Boolean.FALSE);
        
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
    public void setImovelProperties(){
        int i;
        imovel.setCasaPraia(Boolean.FALSE);
        imovel.setApartamentos(Boolean.FALSE);
        imovel.setSalasComerciais(Boolean.FALSE);
        imovel.setLotes(Boolean.FALSE);
        imovel.setTerras(Boolean.FALSE);
        imovel.setSitios(Boolean.FALSE);
        imovel.setOutroImovel(Boolean.FALSE);

        if(selectedImoveis != null){
            for(i=0;i<selectedImoveis.length;i++){
                if("p".equals(selectedImoveis[i]))
                    imovel.setCasaPraia(Boolean.TRUE);
                if("a".equals(selectedImoveis[i]))
                    imovel.setApartamentos(Boolean.TRUE);
                if("sc".equals(selectedImoveis[i]))
                    imovel.setSalasComerciais(Boolean.TRUE);
                if("l".equals(selectedImoveis[i]))
                    imovel.setLotes(Boolean.TRUE);
                if("t".equals(selectedImoveis[i]))
                    imovel.setTerras(Boolean.TRUE);
                if("s".equals(selectedImoveis[i]))
                    imovel.setSitios(Boolean.TRUE);
                if("o".equals(selectedImoveis[i]))
                    imovel.setOutroImovel(Boolean.TRUE);
            }
        }
    }
    public void setResidenciaFamilaProperties(){
        int i;
        residencia.setRedeEsgoto(Boolean.FALSE);
        residencia.setFossa(Boolean.FALSE);
        residencia.setBanheiro(Boolean.FALSE);
        residencia.setChuveiro(Boolean.FALSE);
        residencia.setLuz(Boolean.FALSE);
        residencia.setAgua(Boolean.FALSE);

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
        dependentes.setCompanheiro(Boolean.FALSE);
        dependentes.setFilho(Boolean.FALSE);
        dependentes.setIdoso(Boolean.FALSE);
        dependentes.setOutro(Boolean.FALSE);

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

    public boolean selectedDependenteOutro(){
        int i;
        if(selectedDependentes != null){
            for(i=0;i<selectedDependentes.length;i++){
                if("o".equals(selectedDependentes[i]))
                    return true;
            }
        }
        return false;
    }
        
    public boolean verificaSelectedSustentadoresPM(){
        int i;
        if(selectedSustentadores != null){
            for(i=0;i<selectedSustentadores.length;i++){
                if("pm".equals(selectedSustentadores[i]))
                    return true;
            }
        }
            return false;
    }
    
    public boolean verificaSelectedSustentadoresP(){
        int i;
        if(selectedSustentadores != null){
            for(i=0;i<selectedSustentadores.length;i++){
                if("p".equals(selectedSustentadores[i]))
                    return true;
            }
        }
        return false;
    }
    public boolean verificaSelectedSustentadoresM(){
        int i;
        if(selectedSustentadores != null){
            for(i=0;i<selectedSustentadores.length;i++){
                if("m".equals(selectedSustentadores[i]))
                    return true;
            }
        }
        return false;
    }
    public boolean verificaSelectedSustentadoresN(){
        int i;
        if(selectedSustentadores != null){
            for(i=0;i<selectedSustentadores.length;i++){
                if("n".equals(selectedSustentadores[i]))
                    return true;
            }
        }
        return false;        
    }

    public boolean verificaSelectedSustentadoresOP(){
        int i;
        if(selectedSustentadores != null){
            for(i=0;i<selectedSustentadores.length;i++){
                if("op".equals(selectedSustentadores[i]))
                    return true;
            }
        }
        return false;        
    }

    public boolean verificaSelectedSustentadoresOM(){
        int i;
        if(selectedSustentadores != null){
            for(i=0;i<selectedSustentadores.length;i++){
                if("om".equals(selectedSustentadores[i]))
                    return true;
            }
        }
        return false;        
    }
    public boolean verificaMoraComOutro(){
        if(situacaoResidencial.getComQuemMora() == null){
            return false;
        }else{
            if(situacaoResidencial.getComQuemMora().equals("Outra Situação"))
                return true;
        }
        return false;
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

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
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

    public Set<String> getTurmas() {
        return turmas;
    }

    public void setTurmas(Set<String> turmas) {
        this.turmas = turmas;
    }

    public Set<String> getCursos() {
        return cursos;
    }

    public void setCursos(Set<String> cursos) {
        this.cursos = cursos;
    }

    public Set<String> getModalidades() {
        return modalidades;
    }

    public void setModalidades(Set<String> modalidades) {
        this.modalidades = modalidades;
    }

    public boolean isSelectedModalidade() {
        return selectedModalidade;
    }

    public void setSelectedModalidade(boolean selectedModalidade) {
        this.selectedModalidade = selectedModalidade;
    }

    public boolean isSelectedCurso() {
        return selectedCurso;
    }

    public void setSelectedCurso(boolean selectedCurso) {
        this.selectedCurso = selectedCurso;
    }

    public boolean isDependenteOutro() {
        return dependenteOutro;
    }

    public void setDependenteOutro(boolean dependenteOutro) {
        this.dependenteOutro = dependenteOutro;
    }

    public List<String> getListaBolsas() {
        return listaBolsas;
    }

    public void setListaBolsas(List<String> listaBolsas) {
        this.listaBolsas = listaBolsas;
    }

    public String[] getSelectedImoveis() {
        return selectedImoveis;
    }

    public void setSelectedImoveis(String[] selectedImoveis) {
        this.selectedImoveis = selectedImoveis;
    }



}
