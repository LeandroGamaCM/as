package br.edu.ifba.as.logica.telaAluno;

import br.edu.ifba.as.entidades.formulario.Aluno;
import br.edu.ifba.as.entidades.formulario.Turma;
import br.edu.ifba.as.rn.AlunoRN;
import br.edu.ifba.as.rn.TurmaRN;
import java.util.Objects;

public class AlunoTabela {
    private Aluno aluno;
    private Turma turma;

    public AlunoTabela(Aluno aluno) {
        AlunoRN alunoRN = new AlunoRN();
        TurmaRN turmaRN = new TurmaRN();
        this.aluno = aluno;
        this.turma = turmaRN.buscarPorAluno(aluno.getAluno());
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 61 * hash + Objects.hashCode(this.aluno);
        hash = 61 * hash + Objects.hashCode(this.turma);
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
        final AlunoTabela other = (AlunoTabela) obj;
        if (!Objects.equals(this.aluno, other.aluno)) {
            return false;
        }
        if (!Objects.equals(this.turma, other.turma)) {
            return false;
        }
        return true;
    }
    
    
}
