package br.edu.ifba.as.logica.telaAluno;

import br.edu.ifba.as.rn.TurmaRN;
import java.util.ArrayList;
import java.util.List;

public class ListaCursos {
    private String modalidade;    
    private List<String> cursos;
    private List<ListaTurmas> turmas = new ArrayList<>(); 
    private int i;
    
    public ListaCursos(String modalidade) {
        this.modalidade = modalidade;
        TurmaRN turmaRN = new TurmaRN();
        cursos = turmaRN.listarCursos(this.modalidade);
        
        if(cursos == null || cursos.isEmpty()){
            
        }else{
            for(i=0; i<cursos.size();i++){
                ListaTurmas listaTurmas = new ListaTurmas(modalidade, cursos.get(i));
                this.turmas.add(listaTurmas);
            }
        }
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

    public List<ListaTurmas> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<ListaTurmas> turmas) {
        this.turmas = turmas;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }
    
    
}
