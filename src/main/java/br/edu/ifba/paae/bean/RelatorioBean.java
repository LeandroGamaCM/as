package br.edu.ifba.paae.bean;

import br.edu.ifba.paae.entidades.formulario.Aluno;
import br.edu.ifba.paae.logica.FormularioAluno;
import br.edu.ifba.paae.rn.formulario.AlunoRN;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class RelatorioBean {
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
    
    
    
}
