package br.edu.ifba.as.logica.telaAluno;

import br.edu.ifba.as.rn.TurmaRN;
import java.util.List;

public class ListaTurmas {
    private List<String> turmas;
    private String curso;
    private String modalidade;

    public ListaTurmas(String modalidade, String curso) {
        this.curso = curso;
        this.modalidade = modalidade;
        TurmaRN turmaRN = new TurmaRN();
        turmaRN.listarTurmas(this.modalidade, this.curso);
    }

    public List<String> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<String> turmas) {
        this.turmas = turmas;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }   

    public String getModalidade() {
        return modalidade;
    }

    public void setModalidade(String modalidade) {
        this.modalidade = modalidade;
    }
    
}
