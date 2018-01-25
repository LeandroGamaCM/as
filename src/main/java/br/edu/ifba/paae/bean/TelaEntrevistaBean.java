package br.edu.ifba.paae.bean;

import br.edu.ifba.paae.entidades.formulario.Aluno;
import br.edu.ifba.paae.entidades.formulario.Turma;
import br.edu.ifba.paae.logica.AlunoTabela;
import br.edu.ifba.paae.rn.formulario.AlunoRN;
import br.edu.ifba.paae.rn.formulario.TurmaRN;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class TelaEntrevistaBean implements Serializable{

    private String estadoTela = "entrevistasFeitas";
    private String pesquisa = "";
    
    private String filtroCurso = "todos";
    private String filtroModalidade = "todos";
    

    private List<Aluno> alunos;
    private List<AlunoTabela> alunosTabela = new ArrayList<>();
    private Set<String> modalidades;
    private Set<String> cursos;
    private List<Turma> turmas;
    
    @PostConstruct
    public void init(){
        TurmaRN turmaRN = new TurmaRN();
        listarFichas();
        turmas = turmaRN.listar();
    }     
    public void listarFichas(){
        AlunoRN alunoRN = new AlunoRN();
        TurmaRN turmaRN = new TurmaRN();
        List<String> auxMod = turmaRN.listarModalidades();
        List<String> auxCur = turmaRN.listarCursos();
        if(auxMod != null){
            modalidades = new HashSet<>(auxMod);        
        }
        if(auxCur != null){
            cursos = new HashSet<>(auxCur);
        }
        alunosTabela = new ArrayList<>();
        alunos = new ArrayList<>();
        int i;

        
        if(filtroModalidade == null || "todos".equals(filtroModalidade)){
            if(filtroCurso == null || "todos".equals(filtroCurso)){
                alunos = alunoRN.listar();
                if(alunos != null || !alunos.isEmpty()){
                    for(i = 0; i < alunos.size(); i++){
                        AlunoTabela alunoTabela = new AlunoTabela(alunos.get(i));
                        alunosTabela.add(alunoTabela);
                    }
                }
            }else{
                alunos = alunoRN.listarPorCurso(filtroCurso);
                if(alunos != null || !alunos.isEmpty()){
                    for(i = 0; i < alunos.size(); i++){
                        AlunoTabela alunoTabela = new AlunoTabela(alunos.get(i));
                        alunosTabela.add(alunoTabela);
                    }
                }                
            }
        }else{
            if(filtroCurso == null || "todos".equals(filtroCurso)){
                alunos = alunoRN.listarPorModalidade(filtroModalidade);
                if(alunos != null || !alunos.isEmpty()){
                    for(i = 0; i < alunos.size(); i++){
                        AlunoTabela alunoTabela = new AlunoTabela(alunos.get(i));
                        alunosTabela.add(alunoTabela);
                    }
                }
            }else{
                alunos = alunoRN.listarPorModalidadeCurso(filtroModalidade, filtroCurso);
                if(alunos != null || !alunos.isEmpty()){
                    for(i = 0; i < alunos.size(); i++){
                        AlunoTabela alunoTabela = new AlunoTabela(alunos.get(i));
                        alunosTabela.add(alunoTabela);
                    }
                }
            }            
        }

    }
        
    
    public void buscar(){
        AlunoRN alunoRN = new AlunoRN();
        int i;
        alunosTabela = new ArrayList<>();
        alunos = alunoRN.buscarCPFNomeRG(pesquisa);
        if(alunos != null || !alunos.isEmpty()){
            for(i = 0; i < alunos.size(); i++){
                AlunoTabela alunoTabela = new AlunoTabela(alunos.get(i));
                alunosTabela.add(alunoTabela);
            }
        }           
        pesquisa = "";
        changeToPesquisar();
    }
    
// Controle de Tela    
    public boolean isEntrevistasFeitas(){
        return "entrevistasFeitas".equals(this.estadoTela);
    }
    public void changeToEntrevistasFeitas(){
        this.estadoTela = "entrevistasFeitas";
    }
    
    public boolean isEntrevistasNaoFeitas(){
        return "entrevistasNaoFeitas".equals(this.estadoTela);
    }
    public void changeToEntrevistasNaoFeitas(){
        this.estadoTela = "entrevistasNaoFeitas";
    }
        
    public boolean isPesquisar(){
        return "pesquisar".equals(this.estadoTela);
    }
    public void changeToPesquisar(){
        this.estadoTela = "pesquisar";
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

    public String getFiltroCurso() {
        return filtroCurso;
    }

    public void setFiltroCurso(String filtroCurso) {
        this.filtroCurso = filtroCurso;
    }

    public String getFiltroModalidade() {
        return filtroModalidade;
    }

    public void setFiltroModalidade(String filtroModalidade) {
        this.filtroModalidade = filtroModalidade;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public List<AlunoTabela> getAlunosTabela() {
        return alunosTabela;
    }

    public void setAlunosTabela(List<AlunoTabela> alunosTabela) {
        this.alunosTabela = alunosTabela;
    }

    public Set<String> getModalidades() {
        return modalidades;
    }

    public void setModalidades(Set<String> modalidades) {
        this.modalidades = modalidades;
    }

    public Set<String> getCursos() {
        return cursos;
    }

    public void setCursos(Set<String> cursos) {
        this.cursos = cursos;
    }

    public List<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }

    
    
    
}
