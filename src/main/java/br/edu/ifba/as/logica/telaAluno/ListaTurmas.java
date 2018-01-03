package br.edu.ifba.as.logica.telaAluno;

import br.edu.ifba.as.rn.TurmaRN;
import java.util.ArrayList;
import java.util.List;

public class ListaTurmas {
    
    private String modalidade;
    private String curso;
    private List<String> turmas;
    private List<ListaAlunos> alunos = new ArrayList<>();
    private Integer codTurma;
    private int i;

    public ListaTurmas(String modalidade, String curso) {
        this.curso = curso;
        this.modalidade = modalidade;
        TurmaRN turmaRN = new TurmaRN();
        turmas = turmaRN.listarTurmas(this.modalidade, this.curso);
        
        if(turmas == null || turmas.isEmpty()){
            
        }else{
            for(i=0; i<turmas.size();i++){
                codTurma = turmaRN.buscarTurma(modalidade, curso, turmas.get(i)).getTurma();
                ListaAlunos listaAlunos = new ListaAlunos(codTurma);
                this.alunos.add(listaAlunos);
            }
        }        
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

    public List<ListaAlunos> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<ListaAlunos> alunos) {
        this.alunos = alunos;
    }
    
}
