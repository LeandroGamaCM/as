package br.edu.ifba.paae.bean.adm;

import br.edu.ifba.paae.entidades.analise.Entrevista;
import br.edu.ifba.paae.entidades.formulario.Aluno;
import br.edu.ifba.paae.entidades.formulario.Formulario;
import br.edu.ifba.paae.logica.FormularioAluno;
import br.edu.ifba.paae.rn.analise.EntrevistaRN;
import br.edu.ifba.paae.rn.analise.RendaPerCapitaRN;
import br.edu.ifba.paae.rn.formulario.AlunoRN;
import br.edu.ifba.paae.rn.formulario.FormularioRN;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.model.chart.PieChartModel;

@ManagedBean(name = "telaRelatoriosBean")
@ViewScoped
public class TelaRelatoriosBean implements Serializable{
    private static final long serialVersionUID = -4266294973616109853L;
    
    private List<Aluno> alunos = new ArrayList<>();
    private List<FormularioAluno> formularioAlunos = new ArrayList<>();

    private PieChartModel graficoPreferenciaBolsa;
    private PieChartModel graficoAlunos;
    private PieChartModel graficoRenda;

    private String estadoTela = "classificacao";

    @PostConstruct
    public void init() {        
        createGraficos();
        listarclassificao();
    }
    public void listarclassificao(){
        AlunoRN alunoRN = new AlunoRN();
        alunos = alunoRN.alunosAtuais(alunoRN.alunosInscritos());
        int i;
        formularioAlunos = new ArrayList<>();
        
        for(i=0; i<alunos.size(); i++){
            FormularioAluno formularioAluno = new FormularioAluno(alunos.get(i));
            formularioAlunos.add(formularioAluno);
        }        
    }

    private void createGraficos(){
        System.out.println("\tCriando graficos...");
        createGraficoPreferenciaBolsa();
        createGraficoAlunos();
        createGraficoRenda();
    }
    
    private void createGraficoAlunos(){
        graficoAlunos = new PieChartModel();
        AlunoRN alunoRN = new AlunoRN();
        int preCadastrados = 0;
        int cadastrados = 0;
        int inscricaoFeita = 0;
        int inscricaoPendente = 0;

        if(alunoRN.alunosAtuais(alunoRN.alunosCadastrados()) != null)
            cadastrados = alunoRN.alunosAtuais(alunoRN.alunosCadastrados()).size();
        
        if(alunoRN.alunosAtuais(alunoRN.alunosInscritos()) != null)
            inscricaoFeita = alunoRN.alunosAtuais(alunoRN.alunosInscritos()).size();
        
        if(alunoRN.alunosAtuais(alunoRN.listar()) != null){
            int i;
            List<Aluno> list = alunoRN.alunosAtuais(alunoRN.listar());

            preCadastrados = alunoRN.alunosAtuais(alunoRN.listar()).size() - cadastrados;
            
            for(i=0; i<list.size(); i++){
                if(list.get(i).getStatus() != null){
                    if(list.get(i).getStatus().equals("Inscrição pendente"))
                        inscricaoPendente++;                    
                }
            }
        }
        
        graficoAlunos.set("Pré-cadastrados", preCadastrados);
        graficoAlunos.set("Inscrição pendente", inscricaoPendente);
        graficoAlunos.set("Inscrição realizada", inscricaoFeita);
        
        graficoAlunos.setTitle("Status de Inscrições dos Alunos");
        graficoAlunos.setLegendPosition("w");
        
    }
    
    private void createGraficoPreferenciaBolsa(){
        graficoPreferenciaBolsa = new PieChartModel();
        AlunoRN alunoRN = new AlunoRN();
        FormularioRN formularioRN = new FormularioRN();
        Formulario formulario;
        List<Aluno> listAlunos = alunoRN.alunosAtuais(alunoRN.listar()); 
        
        int bolsaEstudo = 0;
        int auxilioMoradia = 0;
        int auxilioTransporte = 0;
        int auxilioAlimentacao = 0;
        int auxilioCopia = 0;
        int auxilioAquisicoes = 0;
        int pina = 0;
        
        if(listAlunos != null && !listAlunos.isEmpty()){
            for(Aluno aluno: listAlunos){
                formulario = formularioRN.buscarPorAluno(aluno.getAluno());
                if(formulario != null && formulario.getPrimeiraPreferencia() != null){
                    if(formulario.getPrimeiraPreferencia().equals("Bolsa de estudos"))
                        bolsaEstudo++;
                    if(formulario.getPrimeiraPreferencia().equals("Auxílio moradia"))
                        auxilioMoradia++;
                    if(formulario.getPrimeiraPreferencia().equals("Auxílio transporte"))
                        auxilioTransporte++;
                    if(formulario.getPrimeiraPreferencia().equals("Auxílio alimentação"))
                        auxilioAlimentacao++;
                    if(formulario.getPrimeiraPreferencia().equals("Auxílio cópia e impressao"))
                        auxilioCopia++;
                    if(formulario.getPrimeiraPreferencia().equals("Auxílio para aquisições e viagens"))
                        auxilioAquisicoes++;
                    if(formulario.getPrimeiraPreferencia().equals("Bolsa de projeto de incentivo a aprendizagem - PINA"))
                        pina++;
                }
            }
        }
        
        graficoPreferenciaBolsa.set("Bolsa de estudos", bolsaEstudo);
        graficoPreferenciaBolsa.set("Auxílio moradia", auxilioMoradia);
        graficoPreferenciaBolsa.set("Auxílio transporte", auxilioTransporte);
        graficoPreferenciaBolsa.set("Auxílio alimentação", auxilioAlimentacao);
        graficoPreferenciaBolsa.set("Auxílio cópia e impressão", auxilioCopia);
        graficoPreferenciaBolsa.set("Auxílio para aquisições e viagens", auxilioAquisicoes);
        graficoPreferenciaBolsa.set("Bolsa de projeto de incentivo a aprendizagem - PINA", pina);

        
        graficoPreferenciaBolsa.setTitle("Preferência de Bolsas");
        graficoPreferenciaBolsa.setLegendPosition("w");
    }
    
    private void createGraficoRenda(){
        graficoRenda = new PieChartModel();
        RendaPerCapitaRN rendaPerCapitaRN = new RendaPerCapitaRN();
        AlunoRN alunoRN = new AlunoRN();
        EntrevistaRN entrevistaRN = new EntrevistaRN();
        List<Aluno> listAlunos = alunoRN.alunosAtuais(alunoRN.listar());
        Entrevista entrevista;
        
        Double salarioMinimo = rendaPerCapitaRN.buscarSalario();
        
        int umQuarto = 0;
        int metade = 0;
        int um = 0;
        int dois = 0;
        int maisQueDois = 0;
        
        if(listAlunos != null && !listAlunos.isEmpty()){
            for(Aluno aluno : listAlunos){
                entrevista = entrevistaRN.buscarPorAluno(aluno.getAluno());
                if(entrevista != null && entrevista.getPontuacaoRendaPerCapita()!=null){
                    if(entrevista.getPontuacaoRendaPerCapita() < (salarioMinimo/4)){
                        umQuarto++;
                    }
                    if((entrevista.getPontuacaoRendaPerCapita() > (salarioMinimo/4)) && (entrevista.getPontuacaoRendaPerCapita() < (salarioMinimo/2))){
                        metade++;
                    }
                    if((entrevista.getPontuacaoRendaPerCapita() > (salarioMinimo/2)) && (entrevista.getPontuacaoRendaPerCapita() < (salarioMinimo))){
                        um++;
                    }
                    if((entrevista.getPontuacaoRendaPerCapita() > (salarioMinimo)) && (entrevista.getPontuacaoRendaPerCapita() < (salarioMinimo*2))){
                        dois++;
                    }
                    if((entrevista.getPontuacaoRendaPerCapita() > (salarioMinimo*2))){
                        maisQueDois++;
                    }                    
                }
            }
        }
        
        graficoRenda.set("Menos de 1/4 salário mínimo", umQuarto);
        graficoRenda.set("Entre 1/4 e 1/2 salário mínimo", metade);
        graficoRenda.set("Entre 1/2 e 1 salário mínimo", um);
        graficoRenda.set("Entre 1 e 2 salários mínimos", dois);
        graficoRenda.set("Mais de 2 salários mínimos", maisQueDois);
        
        graficoRenda.setTitle("Renda Per Capita dos discentes em quantidade de salários mínimos");
        graficoRenda.setLegendPosition("w");        
        
    }
    
// Controle de Tela
    public boolean isInformacoes(){
        return "informacoes".equals(this.estadoTela);
    }
    public void changeToInformacoes(){
        createGraficos();
        this.estadoTela = "informacoes";
    }
    
    public boolean isClassificacao(){
        return "classificacao".equals(this.estadoTela);
    }
    public void changeToClassificacao(){
        listarclassificao();
        this.estadoTela = "classificacao";
    }    
    
// Getters e Setters    
    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public List<FormularioAluno> getFormularioAlunos() {
        return formularioAlunos;
    }

    public void setFormularioAlunos(List<FormularioAluno> formularioAlunos) {
        this.formularioAlunos = formularioAlunos;
    }

    public PieChartModel getGraficoPreferenciaBolsa() {
        return graficoPreferenciaBolsa;
    }

    public PieChartModel getGraficoAlunos() {
        return graficoAlunos;
    }

    public void setGraficoAlunos(PieChartModel graficoAlunos) {
        this.graficoAlunos = graficoAlunos;
    }

    public String getEstadoTela() {
        return estadoTela;
    }

    public void setEstadoTela(String estadoTela) {
        this.estadoTela = estadoTela;
    }

    public PieChartModel getGraficoRenda() {
        return graficoRenda;
    }

    public void setGraficoRenda(PieChartModel graficoRenda) {
        this.graficoRenda = graficoRenda;
    }
    
}
