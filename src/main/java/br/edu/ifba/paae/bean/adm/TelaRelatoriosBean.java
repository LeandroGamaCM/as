package br.edu.ifba.paae.bean.adm;

import br.edu.ifba.paae.entidades.formulario.Aluno;
import br.edu.ifba.paae.entidades.formulario.Formulario;
import br.edu.ifba.paae.logica.FormularioAluno;
import br.edu.ifba.paae.rn.formulario.AlunoRN;
import br.edu.ifba.paae.rn.formulario.FormularioRN;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.annotation.PostConstruct;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.model.chart.PieChartModel;

@ManagedBean(name = "relatorioBean")
@ViewScoped
public class TelaRelatoriosBean implements Serializable{
    private static final long serialVersionUID = -4266294973616109853L;
    
    private List<Aluno> alunos = new ArrayList<>();
    private List<FormularioAluno> formularioAlunos = new ArrayList<>();

    private PieChartModel graficoPreferenciaBolsa;
    private PieChartModel graficoAlunos;
    
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
        FormularioRN formularioRN = new FormularioRN();
        List<Formulario> formularios = formularioRN.listar();
        int i;
        List<Formulario> formulariosDoAno = new ArrayList<>();
        
        int bolsaEstudo = 0;
        int auxilioMoradia = 0;
        int auxilioTransporte = 0;
        int auxilioAlimentacao = 0;
        int auxilioCopia = 0;
        int auxilioAquisicoes = 0;
        int pina = 0;
        
        if(formularios != null){
            Calendar cal = Calendar.getInstance();
            for(i=0; i<formularios.size(); i++){
                if(formularios.get(i).getDataInscricao().getYear() == cal.getTime().getYear()){
                    formulariosDoAno.add(formularios.get(i));
                }
            }
        }
        if(formulariosDoAno != null || !formulariosDoAno.isEmpty()){
            for(i=0; i<formulariosDoAno.size(); i++){
                if(formulariosDoAno.get(i).getPrimeiraPreferencia() != null){
                    if(formulariosDoAno.get(i).getPrimeiraPreferencia().equals("Bolsa de estudos"))
                        bolsaEstudo++;
                    if(formulariosDoAno.get(i).getPrimeiraPreferencia().equals("Auxílio moradia"))
                        auxilioMoradia++;
                    if(formulariosDoAno.get(i).getPrimeiraPreferencia().equals("Auxílio transporte"))
                        auxilioTransporte++;
                    if(formulariosDoAno.get(i).getPrimeiraPreferencia().equals("Auxílio alimentação"))
                        auxilioAlimentacao++;
                    if(formulariosDoAno.get(i).getPrimeiraPreferencia().equals("Auxílio cópia e impressao"))
                        auxilioCopia++;
                    if(formulariosDoAno.get(i).getPrimeiraPreferencia().equals("Auxílio para aquisições e viagens"))
                        auxilioAquisicoes++;
                    if(formulariosDoAno.get(i).getPrimeiraPreferencia().equals("Bolsa de projeto de incentivo a aprendizagem - PINA"))
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
    
}
