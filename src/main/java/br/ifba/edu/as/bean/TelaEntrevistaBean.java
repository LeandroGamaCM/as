package br.ifba.edu.as.bean;

import br.edu.ifba.as.entidades.formulario.Aluno;
import br.edu.ifba.as.logica.telaEntrevista.FormularioAluno;
import br.edu.ifba.as.rn.AlunoRN;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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
    
    private List<Aluno> alunos = new ArrayList<>();
    private List<FormularioAluno> formularioAlunos = new ArrayList<>();
    
    @PostConstruct
    public void init(){        
        AlunoRN alunoRN = new AlunoRN();
        alunos = alunoRN.listar();
        int i;
        
        for(i=0; i<alunos.size(); i++){
            FormularioAluno formularioAluno = new FormularioAluno(alunos.get(i));
            formularioAlunos.add(formularioAluno);
        }
        
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.estadoTela);
        hash = 97 * hash + Objects.hashCode(this.pesquisa);
        hash = 97 * hash + Objects.hashCode(this.filtroCurso);
        hash = 97 * hash + Objects.hashCode(this.filtroAno);
        hash = 97 * hash + Objects.hashCode(this.alunos);
        hash = 97 * hash + Objects.hashCode(this.formularioAlunos);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TelaEntrevistaBean other = (TelaEntrevistaBean) obj;
        if (!Objects.equals(this.estadoTela, other.estadoTela)) {
            return false;
        }
        if (!Objects.equals(this.pesquisa, other.pesquisa)) {
            return false;
        }
        if (!Objects.equals(this.filtroCurso, other.filtroCurso)) {
            return false;
        }
        if (!Objects.equals(this.filtroAno, other.filtroAno)) {
            return false;
        }
        if (!Objects.equals(this.alunos, other.alunos)) {
            return false;
        }
        if (!Objects.equals(this.formularioAlunos, other.formularioAlunos)) {
            return false;
        }
        return true;
    }

    
    
    
}
