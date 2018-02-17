package br.edu.ifba.paae.bean.adm;

import br.edu.ifba.paae.entidades.formulario.Aluno;
import br.edu.ifba.paae.entidades.formulario.Turma;
import br.edu.ifba.paae.entidades.inscricao.PeriodoInscricao;
import br.edu.ifba.paae.entidades.usuario.Usuario;
import br.edu.ifba.paae.logica.FormularioAluno;
import br.edu.ifba.paae.logica.Mensagem;
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
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "telaAlunosBean")
@ViewScoped
public class TelaAlunosBean implements Serializable{
    private Mensagem mensagem = new Mensagem();
    private Aluno aluno = new Aluno();
    private Aluno novoAluno = new Aluno();
    private Turma turma = new Turma();
    private Turma novaTurma = new Turma();

    private PeriodoInscricao periodoInscricao;
    
    private String estadoTela = "telaAluno";
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
        PeriodoInscricaoRN periodoInscricaoRN = new PeriodoInscricaoRN();
        
        periodoInscricao = periodoInscricaoRN.last();
        listarFichas();
        turmas = turmaRN.listar();
    }    
    
    public void preCadastro(){
        AlunoRN alunoRN = new AlunoRN();
        UsuarioRN usuarioRN = new UsuarioRN();
        
        Usuario usuario = usuarioRN.buscarPorLogin(novoAluno.getCpf());
        
        if(usuario == null){
            usuario = new Usuario();

            usuario.setAtivo(Boolean.FALSE);
            usuario.setLogin(novoAluno.getCpf());
//            usuario.getPermissao().add("ROLE_ADMINISTRADOR");
            usuarioRN.salvar(usuario);
 
            novoAluno.setUsuario(usuario);
            novoAluno.setStatus("Pré-cadastrado");
            
            alunoRN.salvar(novoAluno);

            mensagem.addMensagem("Aluno pré-cadastrado!", FacesMessage.SEVERITY_INFO);
            System.out.println("\tAluno pré-cadastrado");
        }else{ 
            mensagem.addMensagem("Já existe um usuário com este CPF!", FacesMessage.SEVERITY_ERROR);
            System.out.println("\tEsse usuario já está cadastrado!");
        }
        novoAluno = new Aluno();
    }
    
    public void cadastrarTurma(){
        TurmaRN turmaRN = new TurmaRN();
        Turma verificaTurma = turmaRN.buscarTurma(novaTurma.getModalidade(), novaTurma.getCurso(), novaTurma.getNome());
        
        if(verificaTurma == null){
            turmaRN.salvar(novaTurma);
            mensagem.addMensagem("Turma cadastrada!", FacesMessage.SEVERITY_INFO);
            System.out.println("Turma cadastrada");      
        }else{
            mensagem.addMensagem("Esta turma já está cadastrada!", FacesMessage.SEVERITY_ERROR);            
            System.out.println("Essa turma já está cadastrada");
        }
        
        novaTurma = new Turma();
        turmas = turmaRN.listar();
    }

    public void excluirTurma(Turma turma){
        TurmaRN turmaRN = new TurmaRN();
        if(turma != null) {
            turmaRN.excluir(turma);
        }
        mensagem.addMensagem("Turma deletada!", FacesMessage.SEVERITY_INFO);
        turmas = turmaRN.listar();
    }
    
    public void editarTurma(Turma turma) {
        TurmaRN turmaRN = new TurmaRN();
         
        if(turma != null) {
            Turma verificaTurma = turmaRN.buscarTurma(turma.getModalidade(), turma.getCurso(), turma.getNome());

            if(verificaTurma == null){
                turmaRN.salvar(turma);
                mensagem.addMensagem("Dados alterados!", FacesMessage.SEVERITY_INFO);
                System.out.println("Dados alterados");
                
            }else{
                mensagem.addMensagem("Esta turma já está cadastrada!", FacesMessage.SEVERITY_ERROR);            
                System.out.println("Já existe uma turma com esses dados");
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
        changeToTelaPesquisar();
    }
    
// Controle de Tela
    public boolean isTelaAluno(){
        return "telaAluno".equals(this.estadoTela);
    }
    public void changeToTelaAluno(){
        this.estadoTela = "telaAluno";
        listarFichas();
    }
    
    public boolean isTelaTurma(){
        return "telaTurma".equals(this.estadoTela);
    }
    public void changeToTelaTurma(){
        TurmaRN turmaRN = new TurmaRN();
        
        this.estadoTela = "telaTurma";
        turmas = turmaRN.listar();        
    }
    
    public boolean isTelaPesquisar(){
        return "telaPesquisar".equals(this.estadoTela);
    }
    public void changeToTelaPesquisar(){
        this.estadoTela = "telaPesquisar";
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

    public Mensagem getMensagem() {
        return mensagem;
    }

    public void setMensagem(Mensagem mensagem) {
        this.mensagem = mensagem;
    }

    public PeriodoInscricao getPeriodoInscricao() {
        return periodoInscricao;
    }

    public void setPeriodoInscricao(PeriodoInscricao periodoInscricao) {
        this.periodoInscricao = periodoInscricao;
    }


}
