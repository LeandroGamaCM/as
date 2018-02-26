package br.edu.ifba.paae.bean.adm;

import br.edu.ifba.paae.entidades.formulario.Aluno;
import br.edu.ifba.paae.entidades.inscricao.PeriodoInscricao;
import br.edu.ifba.paae.logica.ArquivoUtil;
import br.edu.ifba.paae.logica.FormularioAluno;
import br.edu.ifba.paae.logica.Mensagem;
import br.edu.ifba.paae.rn.analise.EntrevistaRN;
import br.edu.ifba.paae.rn.formulario.AlunoRN;
import br.edu.ifba.paae.rn.inscricao.PeriodoInscricaoRN;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

@ManagedBean(name = "telaEntrevistaBean")
@ViewScoped
public class TelaEntrevistaBean implements Serializable{
    private static final long serialVersionUID = 6180598576873456073L;

    private String estadoTela = "entrevistasFeitas";
    private String pesquisa = "";
    PeriodoInscricao periodoInscricao;
    
    private List<FormularioAluno> formularioAlunos = new ArrayList<>();
    private FormularioAluno formularioAluno;
    private Mensagem mensagem = new Mensagem();
    private StreamedContent streamedContent;    
    private Aluno aluno;
    
    @PostConstruct
    public void init(){
        PeriodoInscricaoRN periodoInscricaoRN = new PeriodoInscricaoRN();

        periodoInscricao = periodoInscricaoRN.last();
        listarEntrevistasFeitas();
    }     
    
    public void listarEntrevistasFeitas(){
        listarEntrevistas(true);
    }
    public void listarEntrevistasNaoFeitas(){
        listarEntrevistas(false);
    }
    private void listarEntrevistas(boolean tipo){
        AlunoRN alunoRN = new AlunoRN();

        List<Aluno> alunos;
        formularioAlunos = new ArrayList<>();
        
        if(tipo){
            System.out.println("\tListar entrevistas feitas");
            alunos = alunoRN.alunosAtuais(alunoRN.alunosEntrevistados());
        }else{
            System.out.println("\tListar entrevistas NÃO feitas");
            alunos = alunoRN.alunosAtuais(alunoRN.alunosNAOEntrevistados());
        }

        if(alunos != null && !alunos.isEmpty()){
            System.out.println("alunos.size:"+ alunos.size());
            for (Aluno a : alunos) {
                formularioAluno = new FormularioAluno(a);
                formularioAlunos.add(formularioAluno);                
            }
        }       
    }
// Na busca permitir que mostre os alunos de todos os anos e coloca um campo 'ano' na tabela
    public void buscar(){
        AlunoRN alunoRN = new AlunoRN();
        int i;
        List<Aluno> alunos = alunoRN.buscarCPFNomeRG(pesquisa);
        System.out.println("\tPesquisa: " + pesquisa);
        formularioAlunos = new ArrayList<>();
        
        if(alunos != null && !alunos.isEmpty()){
            for(i = 0; i < alunos.size(); i++){
                if(alunos.get(i).getStatus() != null && alunos.get(i).getStatus().equals("Inscrição realizada")){
                    FormularioAluno formAluno = new FormularioAluno(alunos.get(i));
                    formularioAlunos.add(formAluno);                    
                }
            }
        }           
        pesquisa = "";
        changeToPesquisar();
    }
  
    public void salvarEntrevista(){
        EntrevistaRN entrevistaRN = new EntrevistaRN();
        if(formularioAluno.getEntrevista() != null){
            formularioAluno.getEntrevista().setStatus("Feita");
            entrevistaRN.salvar(formularioAluno.getEntrevista());
        }
        deleteFiles();
        changeToEntrevistasNaoFeitas();
    }

    public void downloadArquivo(String nome,  byte[] contents){
        System.out.println("Nome arquivo: " + nome);
        if(nome != null && contents != null){
            try {
                File file = ArquivoUtil.escrever(nome, contents);
                InputStream inputStream = new FileInputStream(file);

                streamedContent = new DefaultStreamedContent(inputStream, Files.probeContentType(file.toPath()), file.getName());        
            } catch (IOException ex) {
                mensagem.addMensagem("Erro. Este arquivo está corrompido!", FacesMessage.SEVERITY_ERROR);
                System.out.println("Mensagem: erro no Download");
            }            
        }else{
            mensagem.addMensagem("Erro. Este não existe!", FacesMessage.SEVERITY_ERROR);
            System.out.println("Arquivo Nulo");
        }
        
    }
    
    public void deleteFiles(){
        ArquivoUtil arquivoUtil = new ArquivoUtil();
        arquivoUtil.deletarFiles();
    }
        
// Controle de Tela    
    public boolean isEntrevistasFeitas(){
        return "entrevistasFeitas".equals(this.estadoTela);
    }
    public void changeToEntrevistasFeitas(){
        listarEntrevistasFeitas();
        this.estadoTela = "entrevistasFeitas";
    }
    
    public boolean isEntrevistasNaoFeitas(){
        return "entrevistasNaoFeitas".equals(this.estadoTela);
    }
    public void changeToEntrevistasNaoFeitas(){
        listarEntrevistasNaoFeitas();
        this.estadoTela = "entrevistasNaoFeitas";
    }
        
    public boolean isPesquisar(){
        return "pesquisar".equals(this.estadoTela);
    }
    public void changeToPesquisar(){
        this.estadoTela = "pesquisar";
    }
        
    public boolean isEntrevistarAluno(){
        return "entrevistarAluno".equals(this.estadoTela);
    }
    public void changeToEntrevistarAluno(Aluno aluno){
        this.formularioAluno = new FormularioAluno(aluno);
        this.estadoTela = "entrevistarAluno";
    }
    public boolean isVerEntrevista(){
        return "verEntrevista".equals(this.estadoTela);
    }
    public void changeToVerEntrevista(Aluno aluno){
        this.formularioAluno = new FormularioAluno(aluno);
        this.estadoTela = "verEntrevista";
    }

    
// Getters e Setters

    public String getEstadoTela() {
        return estadoTela;
    }

    public void setEstadoTela(String estadoTela) {
        this.estadoTela = estadoTela;
    }

    public String getPesquisa() {
        return pesquisa;
    }

    public void setPesquisa(String pesquisa) {
        this.pesquisa = pesquisa;
    }

    public List<FormularioAluno> getFormularioAlunos() {
        return formularioAlunos;
    }

    public void setFormularioAlunos(List<FormularioAluno> formularioAlunos) {
        this.formularioAlunos = formularioAlunos;
    }

    public FormularioAluno getFormularioAluno() {
        return formularioAluno;
    }

    public void setFormularioAluno(FormularioAluno formularioAluno) {
        this.formularioAluno = formularioAluno;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public PeriodoInscricao getPeriodoInscricao() {
        return periodoInscricao;
    }

    public void setPeriodoInscricao(PeriodoInscricao periodoInscricao) {
        this.periodoInscricao = periodoInscricao;
    }

    public StreamedContent getStreamedContent() {
        return streamedContent;
    }

    public void setStreamedContent(StreamedContent streamedContent) {
        this.streamedContent = streamedContent;
    }


    
    
}
