package br.ifba.edu.as.bean;

import br.edu.ifba.as.entidades.formulario.Aluno;
import br.edu.ifba.as.entidades.formulario.Turma;
import br.edu.ifba.as.entidades.usuario.Usuario;
import br.edu.ifba.as.rn.AlunoRN;
import br.edu.ifba.as.rn.TurmaRN;
import br.edu.ifba.as.rn.UsuarioRN;
import java.io.Serializable;
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
    private List<Aluno> alunos;
    private Set<Turma> turmas;
    
    private String estadoTela = "listarPorBolsa";
    private String pesquisa;
    private String filtroCurso;
    private String filtroAno;
    int i;
//    private ListaModalidades modalidades;
//    private List<ListaCursos> cursos = new ArrayList<>();
//    private List<List<ListaTurmas>> turmas = new ArrayList<>();
//    private List<List<List<ListaAlunos>>> alunos = new ArrayList<>();  // ??? Isso não deve ser bom
    
    @PostConstruct
    public void init(){
        AlunoRN alunoRN = new AlunoRN();
        alunos = alunoRN.listar();
        
        for(i=0;i<alunos.size();i++){
            TurmaRN turmaRN = new TurmaRN();
            turmas.add(alunos.get(i).getTurma());
        }
// Codigo para listar todos os alunos separados por modalidade/curso/turma
//        int i, j, k;
//        modalidades = new ListaModalidades();
//        
//        if(modalidades.getModalidades() == null || modalidades.getModalidades().isEmpty()){
//            
//        }else{
//            for(i=0; i<modalidades.getModalidades().size();i++){
//                ListaCursos listaCursos = new ListaCursos(modalidades.getModalidades().get(i));
//                cursos.add(listaCursos);
//            }
//            if(cursos == null || cursos.isEmpty()){
//                
////            }else{
////                for(i=0;i<cursos.size(); i++){
////                    List<ListaTurmas> listaListaTurmas = new ArrayList<>();
////                    for(j=0;j<cursos.get(i).getCursos().size();j++){
////                        ListaTurmas listaTurmas = new ListaTurmas(modalidades.getModalidades().get(j), cursos.get(i).getCursos().get(j));
////                        listaListaTurmas.add(listaTurmas);
////                    }
////                    turmas.add(listaListaTurmas);
////                }
////                if(turmas == null || turmas.isEmpty()){
////                    
////                }else{
////                    for(i=0; i<turmas.size(); i++){
////                        List<List<ListaAlunos>> listaListaListaAlunos = new ArrayList<>();
////                        
////                        for(j=0; j<turmas.get(i).size(); j++){
////                            List<ListaAlunos> listaListaAlunos = new ArrayList<>();
////                            String auxModalidade = turmas.get(i).get(j).getModalidade();
////                            String auxCurso = turmas.get(i).get(j).getCurso();
////                            
////                            for(k=0;k<turmas.get(i).get(j).getTurmas().size();k++){
////                                String auxTurma = turmas.get(i).get(j).getTurmas().get(k);
////                                TurmaRN turmaRN = new TurmaRN();
////                                Integer auxCodTurma = turmaRN.buscarTurma(auxModalidade, auxCurso, auxTurma).getTurma();
////
////                                ListaAlunos listaAlunos = new ListaAlunos(auxCodTurma);
////                                listaListaAlunos.add(listaAlunos);
////                            }
////                            listaListaListaAlunos.add(listaListaAlunos);
////                        }
////                        alunos.add(listaListaListaAlunos);
////                    }
////                }
//            }
//            
//        }
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

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public Set<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(Set<Turma> turmas) {
        this.turmas = turmas;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
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



}
