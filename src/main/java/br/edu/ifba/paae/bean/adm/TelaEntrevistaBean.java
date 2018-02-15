package br.edu.ifba.paae.bean.adm;

import br.edu.ifba.paae.entidades.formulario.Aluno;
import br.edu.ifba.paae.logica.FormularioAluno;
import br.edu.ifba.paae.rn.analise.EntrevistaRN;
import br.edu.ifba.paae.rn.formulario.AlunoRN;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "telaEntrevistaBean")
@ViewScoped
public class TelaEntrevistaBean implements Serializable{

    private String estadoTela = "entrevistasFeitas";
    private String pesquisa = "";
    
    private List<FormularioAluno> formularioAlunos = new ArrayList<>();
    private FormularioAluno formularioAluno;

    private Aluno aluno;
    
    @PostConstruct
    public void init(){
        listarEntrevistas(true);

    }     
    public void listarEntrevistas(boolean tipo){
        AlunoRN alunoRN = new AlunoRN();
        int i;

        formularioAlunos = new ArrayList<>();
        
        if(tipo){
            List<Aluno> alunos = alunoRN.alunosAtuais(alunoRN.alunosEntrevistados());
            
            if(alunos != null || !alunos.isEmpty()){
                for(i = 0; i < alunos.size(); i++){
                    formularioAluno = new FormularioAluno(alunos.get(i));
                    formularioAlunos.add(formularioAluno);
                }
            }            
        }
        if(!tipo){
            List<Aluno> alunos = alunoRN.alunosAtuais(alunoRN.alunosNAOEntrevistados());
            System.out.println("Entrevistas NÂO feitas");
            if(alunos != null || !alunos.isEmpty()){
                System.out.println("alunos.size:"+ alunos.size());
                for(i = 0; i < alunos.size(); i++){
                    formularioAluno = new FormularioAluno(alunos.get(i));
                    formularioAlunos.add(formularioAluno);
                }
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

        changeToEntrevistasNaoFeitas();
    }

// Controle de Tela    
    public boolean isEntrevistasFeitas(){
        return "entrevistasFeitas".equals(this.estadoTela);
    }
    public void changeToEntrevistasFeitas(){
        listarEntrevistas(true);
        this.estadoTela = "entrevistasFeitas";
    }
    
    public boolean isEntrevistasNaoFeitas(){
        return "entrevistasNaoFeitas".equals(this.estadoTela);
    }
    public void changeToEntrevistasNaoFeitas(){
        listarEntrevistas(false);
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


    
    
}
