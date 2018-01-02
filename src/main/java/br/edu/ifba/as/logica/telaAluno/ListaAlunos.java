package br.edu.ifba.as.logica.telaAluno;

import br.edu.ifba.as.entidades.formulario.Aluno;
import br.edu.ifba.as.rn.AlunoRN;
import br.edu.ifba.as.rn.TurmaRN;
import java.util.List;

public class ListaAlunos {
    private List<Aluno> alunos;
    private String turma;

    public ListaAlunos(Integer CodTurma) {
        TurmaRN turmaRN = new TurmaRN();
        turma = turmaRN.carregar(CodTurma).getNome();
        AlunoRN alunoRN = new AlunoRN();
        alunos = alunoRN.buscarPorTurma(CodTurma);
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }
    
    
}
