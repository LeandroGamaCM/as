package br.ifba.edu.as.bean;

import br.edu.ifba.as.entidades.analise.Entrevista;
import br.edu.ifba.as.entidades.formulario.Aluno;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class TelaEntrevistaBean implements Serializable{

    private String estadoTela = "entrevistasFeitas";
    private String pesquisa;
    private String filtroCurso;
    private String filtroAno;    
    
    private List<Entrevista> entrevistas;
    private List<Aluno> alunos;
    
    @PostConstruct
    public void init(){
        
    }    
    
    public void buscar(){
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

    public String getFiltroAno() {
        return filtroAno;
    }

    public void setFiltroAno(String filtroAno) {
        this.filtroAno = filtroAno;
    }

    public List<Entrevista> getEntrevistas() {
        return entrevistas;
    }

    public void setEntrevistas(List<Entrevista> entrevistas) {
        this.entrevistas = entrevistas;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }
    
    
    
}
