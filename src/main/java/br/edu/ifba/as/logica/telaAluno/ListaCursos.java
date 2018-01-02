package br.edu.ifba.as.logica.telaAluno;

import br.edu.ifba.as.rn.TurmaRN;
import java.util.List;

public class ListaCursos {
    private List<String> cursos;
    private String modalidade;    
    
    public ListaCursos(String modalidade) {
        this.modalidade = modalidade;
        TurmaRN turmaRN = new TurmaRN();
        cursos = turmaRN.listarCursos(this.modalidade);
    }

    public List<String> getCursos() {
        return cursos;
    }

    public void setCursos(List<String> cursos) {
        this.cursos = cursos;
    }

    public String getModalidade() {
        return modalidade;
    }

    public void setModalidade(String modalidade) {
        this.modalidade = modalidade;
    }
    
}
