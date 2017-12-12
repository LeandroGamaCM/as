package br.ifba.edu.as.bean;

import br.edu.ifba.as.entidades.formulario.Aluno;
import br.edu.ifba.as.rn.AlunoRN;
import javax.faces.bean.*;

@ManagedBean(name = "alunoBean")
@RequestScoped
public class AlunoBean {
    private Aluno aluno = new Aluno();

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public void salvar(){
        AlunoRN alunoRN = new AlunoRN();
        alunoRN.salvar(this.aluno);
    }
    
}
