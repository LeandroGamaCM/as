package br.ifba.edu.as.bean;

import br.edu.ifba.as.entidades.formulario.Aluno;
import br.edu.ifba.as.entidades.formulario.Turma;
import br.edu.ifba.as.entidades.usuario.Usuario;
import br.edu.ifba.as.logica.telaAluno.AlunoTabela;
import br.edu.ifba.as.rn.AlunoRN;
import br.edu.ifba.as.rn.TurmaRN;
import br.edu.ifba.as.rn.UsuarioRN;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "telaAlunosBean")
@ViewScoped
public class TelaAlunosBean implements Serializable{
    private Aluno aluno = new Aluno();
    private Aluno novoAluno = new Aluno();
    private Turma turma = new Turma();
    private Turma novaTurma = new Turma();

    
    private String estadoTela = "listarFichas";
    private String pesquisa;
    private String filtroCurso = "todos";
    private String filtroModalidade = "todos";
    
    private List<Turma> turmas;

    private List<Aluno> alunos;
    private List<AlunoTabela> alunosTabela = new ArrayList<>();
    private Set<String> modalidades;
    private Set<String> cursos;
    
    @PostConstruct
    public void init(){
        TurmaRN turmaRN = new TurmaRN();
        listarFichas();
        turmas = turmaRN.listar();
    }    
    
    public void preCadastro(){
        System.out.println("PreCadastro");
        System.out.println("Alno.cpf: " + novoAluno.getCpf());
        Usuario usuario = new Usuario();
        AlunoRN alunoRN = new AlunoRN();
        UsuarioRN usuarioRN = new UsuarioRN();
        
        usuario.setAtivo(Boolean.FALSE);
        usuarioRN.salvar(usuario);
        System.out.println("Salvou usuario");
        novoAluno.setUsuario(usuario);
        alunoRN.salvar(novoAluno);
        System.out.println("Aluno pré-cadastrado");
    }
    
    public void cadastrarTurma(){
        TurmaRN turmaRN = new TurmaRN();
        turmaRN.salvar(novaTurma);
        System.out.println("Turma cadastrada");        
    }

    public void excluirTurma(Turma turma){
        TurmaRN turmaRN = new TurmaRN();
        if(turma != null) {
            turmaRN.excluir(turma);
        }
    }
    
    public void editarTurma(Turma turma) {
        TurmaRN turmaRN = new TurmaRN();
         
        if(turma != null) {
            turmaRN.salvar(turma);
        }
    }
    
    public void listarFichas(){
        AlunoRN alunoRN = new AlunoRN();
        TurmaRN turmaRN = new TurmaRN();
        modalidades = new HashSet<>(turmaRN.listarModalidades());
        cursos = new HashSet<>(turmaRN.listarCursos());
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

        changeToListarFichas();
    }

    public void listarAlunosBolsa(){
        AlunoRN alunoRN = new AlunoRN();
        int i;
        alunosTabela = new ArrayList<>();
        alunos = alunoRN.listar();
        if(alunos != null || !alunos.isEmpty()){
            for(i = 0; i < alunos.size(); i++){
                AlunoTabela alunoTabela = new AlunoTabela(alunos.get(i));
                alunosTabela.add(alunoTabela);
            }
        }        
        changeToListarPorBolsa();
        
    }
    public void buscar(){
        changeToPesquisar();
        
    }
    
// Controle de Tela
    public boolean isPreCadastro(){
        return "preCadastro".equals(this.estadoTela);
    }
    public void changeToPreCadastro(){
        this.estadoTela = "preCadastro";
    }
    
    public boolean isListarFichas(){
        return "listarFichas".equals(this.estadoTela);
    }
    public void changeToListarFichas(){
        this.estadoTela = "listarFichas";
    }
    
    public boolean isListarPorBolsa(){
        return "listarPorBolsa".equals(this.estadoTela);
    }
    public void changeToListarPorBolsa(){
        this.estadoTela = "listarPorBolsa";
    }
    
    public boolean isPesquisar(){
        return "pesquisar".equals(this.estadoTela);
    }
    public void changeToPesquisar(){
        this.estadoTela = "pesquisar";
    }


// Getters e Setters

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Aluno getNovoAluno() {
        return novoAluno;
    }

    public void setNovoAluno(Aluno novoAluno) {
        this.novoAluno = novoAluno;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public Turma getNovaTurma() {
        return novaTurma;
    }

    public void setNovaTurma(Turma novaTurma) {
        this.novaTurma = novaTurma;
    }

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

    public List<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
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



}
