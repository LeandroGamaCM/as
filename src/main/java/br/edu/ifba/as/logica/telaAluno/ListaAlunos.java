package br.edu.ifba.as.logica.telaAluno;

import br.edu.ifba.as.entidades.formulario.Aluno;
import br.edu.ifba.as.rn.AlunoRN;
import java.util.List;

public class ListaAlunos {
    private List<Aluno> alunos;

    public ListaAlunos(Integer CodTurma) {
        AlunoRN alunoRN = new AlunoRN();
        alunos = alunoRN.buscarPorTurma(CodTurma);
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }
    
}
