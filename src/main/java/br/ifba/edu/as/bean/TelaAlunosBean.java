package br.ifba.edu.as.bean;

import br.edu.ifba.as.entidades.formulario.*;
import br.edu.ifba.as.entidades.usuario.Usuario;
import br.edu.ifba.as.rn.AlunoRN;
import br.edu.ifba.as.rn.TurmaRN;
import br.edu.ifba.as.rn.UsuarioRN;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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
    
    private String estadoTela = "listarPorBolsa";
    private String pesquisa;
    private String filtroCurso;
    private String filtroAno;
    private List<Aluno> alunos;
    
    @PostConstruct
    public void init(){
        AlunoRN alunoRN = new AlunoRN();
        alunos = alunoRN.listar();
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

//        List<TurmaRN> turmasRNs = new ArrayList<>();
//        
//        List<Turma> turmas = new ArrayList<>();
//        List<String> nomes = new ArrayList<>();
//        List<String> cursos = new ArrayList<>();
//        List<String> modalidades = new ArrayList<>();
//        int i, j, k, l, m;
//        nomes.add("1º ano a");
//        nomes.add("1º ano b");
//        nomes.add("2º ano");
//        nomes.add("3º ano");
//        nomes.add("4º ano");
//        nomes.add("1º Semestre");
//        nomes.add("2º Semestre");
//        nomes.add("3º Semestre");
//        nomes.add("4º Semestre");
//        
//        cursos.add("Informática");
//        cursos.add("Biocombustíveis");
//        cursos.add("Eletromecânica");
//        cursos.add("ADS");
//        
//        modalidades.add("Integrado");
//        modalidades.add("Subsuquente");
//        modalidades.add("Superior");
//        
//        for(k=0;k<2;k++){
//            for(j=0;j<3;j++){            
//                for(i=0;i<5;i++){            
//                    turma.setModalidade(modalidades.get(k));
//                    turma.setCurso(cursos.get(j));
//                    turma.setNome(nomes.get(i));
//
//                    turmas.add(turma);
//                }
//            }
//        }
//        for(i=4;i<9;i++){
//            turma.setModalidade(modalidades.get(2));
//            turma.setCurso(cursos.get(3));
//            turma.setNome(nomes.get(i));
//
//            turmas.add(turma);
//            
//        }
//        for(i=0;i<34;i++){
//            turmasRNs.add(i, turmaRN);
//        }
//
//        for(i=0;i<34;i++){
//            turmasRNs.get(i).salvar(turmas.get(i));
//        }
//
//        System.out.println("Cadastrou tudo");
        
    }

    public void listarFichas(){
        changeToListarFichas();
        
    }
    public void listarAlunosBolsa(){
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

    public String getFiltroAno() {
        return filtroAno;
    }

    public void setFiltroAno(String filtroAno) {
        this.filtroAno = filtroAno;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public Aluno getNovoAluno() {
        return novoAluno;
    }

    public void setNovoAluno(Aluno novoAluno) {
        this.novoAluno = novoAluno;
    }

    public Turma getNovaTurma() {
        return novaTurma;
    }

    public void setNovaTurma(Turma novaTurma) {
        this.novaTurma = novaTurma;
    }


}
