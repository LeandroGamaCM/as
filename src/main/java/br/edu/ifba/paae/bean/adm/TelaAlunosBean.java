package br.edu.ifba.paae.bean.adm;

import br.edu.ifba.paae.entidades.formulario.Aluno;
import br.edu.ifba.paae.entidades.formulario.Turma;
import br.edu.ifba.paae.entidades.inscricao.PeriodoInscricao;
import br.edu.ifba.paae.entidades.usuario.Usuario;
import br.edu.ifba.paae.logica.AlunoTabela;
import br.edu.ifba.paae.logica.FormularioAluno;
import br.edu.ifba.paae.rn.formulario.AlunoRN;
import br.edu.ifba.paae.rn.formulario.TurmaRN;
import br.edu.ifba.paae.rn.inscricao.PeriodoInscricaoRN;
import br.edu.ifba.paae.rn.usuario.UsuarioRN;
import java.io.Serializable;
import java.time.LocalDateTime;
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
    private String pesquisa = "";
    private String filtroCurso = "todos";
    private String filtroModalidade = "todos";
    

    private List<Aluno> alunos;
    private List<FormularioAluno> formularioAlunos = new ArrayList<>();
    private Set<String> modalidades;
    private Set<String> cursos;
    private List<Turma> turmas;
    
    @PostConstruct
    public void init(){
        TurmaRN turmaRN = new TurmaRN();
        listarFichas();
        turmas = turmaRN.listar();
    }    
    
    public void preCadastro(){
        AlunoRN alunoRN = new AlunoRN();
        UsuarioRN usuarioRN = new UsuarioRN();
        
        Usuario usuario = usuarioRN.buscarPorLogin(novoAluno.getCpf());
        
        if(usuario == null){
            LocalDateTime now = LocalDateTime.now();
            PeriodoInscricaoRN periodoInscricaoRN = new PeriodoInscricaoRN();
            PeriodoInscricao periodoInscricao = periodoInscricaoRN.buscarPorAno(now.getYear());
            usuario = new Usuario();

            usuario.setAtivo(Boolean.FALSE);
            usuario.setLogin(novoAluno.getCpf());
//            usuario.getPermissao().add("ROLE_ADMINISTRADOR");
            usuarioRN.salvar(usuario);
 
            novoAluno.setUsuario(usuario);
            novoAluno.setStatus("Pré-cadastrado");
            novoAluno.setPeriodoInscricao(periodoInscricao);
            
            alunoRN.salvar(novoAluno);
// Mostrar mensagem Salvou!

            System.out.println("\tAluno pré-cadastrado");
        }else{ 
            System.out.println("\tEsse usuario já está cadastrado!");
// Mostrar mensagem Já existe esse usuario
        }
        novoAluno = new Aluno();
    }
    
    public void cadastrarTurma(){
        TurmaRN turmaRN = new TurmaRN();
        Turma verificaTurma = turmaRN.buscarTurma(novaTurma.getModalidade(), novaTurma.getCurso(), novaTurma.getNome());
        
        if(verificaTurma == null){
            turmaRN.salvar(novaTurma);
            System.out.println("Turma cadastrada");      
// Mostrar mensagem Salvou!            
        }else{
            System.out.println("Essa turma já está cadastrada");
// Mostrar mensagem já existe            
        }
        
        novaTurma = new Turma();
        turmas = turmaRN.listar();
    }

    public void excluirTurma(Turma turma){
        TurmaRN turmaRN = new TurmaRN();
        if(turma != null) {
            turmaRN.excluir(turma);
        }
        turmas = turmaRN.listar();
    }
    
    public void editarTurma(Turma turma) {
        TurmaRN turmaRN = new TurmaRN();
         
        if(turma != null) {
            System.out.println("Modalidade: " + turma.getModalidade());
            System.out.println("Curso: " + turma.getCurso());
            System.out.println("Turma: " + turma.getNome());
            Turma verificaTurma = turmaRN.buscarTurma(turma.getModalidade(), turma.getCurso(), turma.getNome());

            if(verificaTurma == null){
                turmaRN.salvar(turma);
                System.out.println("Dados alterados");      
    // Mostrar mensagem Salvou!            
            }else{
                System.out.println("Já existe uma turma com esses dados");
    // Mostrar mensagem já existe            
            }
        }
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
        formularioAlunos = new ArrayList<>();
        alunos = new ArrayList<>();
        int i;

        
        if(filtroModalidade == null || "todos".equals(filtroModalidade)){
            if(filtroCurso == null || "todos".equals(filtroCurso)){
                alunos = alunoRN.alunosAtuais(alunoRN.listar());
                if(alunos != null || !alunos.isEmpty()){
                    for(i = 0; i < alunos.size(); i++){
                        FormularioAluno formularioAluno = new FormularioAluno(alunos.get(i));
                        formularioAlunos.add(formularioAluno);
                    }
                }
            }else{
                alunos = alunoRN.alunosAtuais(alunoRN.listarPorCurso(filtroCurso));
                if(alunos != null || !alunos.isEmpty()){
                    for(i = 0; i < alunos.size(); i++){
                        FormularioAluno formularioAluno = new FormularioAluno(alunos.get(i));
                        formularioAlunos.add(formularioAluno);
                    }
                }                
            }
        }else{
            if(filtroCurso == null || "todos".equals(filtroCurso)){
                alunos = alunoRN.alunosAtuais(alunoRN.listarPorModalidade(filtroModalidade));
                if(alunos != null || !alunos.isEmpty()){
                    for(i = 0; i < alunos.size(); i++){
                        FormularioAluno formularioAluno = new FormularioAluno(alunos.get(i));
                        formularioAlunos.add(formularioAluno);
                    }
                }
            }else{
                alunos = alunoRN.alunosAtuais(alunoRN.listarPorModalidadeCurso(filtroModalidade, filtroCurso));
                if(alunos != null || !alunos.isEmpty()){
                    for(i = 0; i < alunos.size(); i++){
                        FormularioAluno formularioAluno = new FormularioAluno(alunos.get(i));
                        formularioAlunos.add(formularioAluno);
                    }
                }
            }            
        }

        changeToListarFichas();
    }

    public void buscar(){
        AlunoRN alunoRN = new AlunoRN();
        int i;
        formularioAlunos = new ArrayList<>();
        alunos = alunoRN.buscarCPFNomeRG(pesquisa);
        if(alunos != null || !alunos.isEmpty()){
            for(i = 0; i < alunos.size(); i++){
                FormularioAluno formularioAluno = new FormularioAluno(alunos.get(i));
                formularioAlunos.add(formularioAluno);
            }
        }           
        pesquisa = "";
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

    public List<FormularioAluno> getFormularioAlunos() {
        return formularioAlunos;
    }

    public void setFormularioAlunos(List<FormularioAluno> formularioAlunos) {
        this.formularioAlunos = formularioAlunos;
    }


}
