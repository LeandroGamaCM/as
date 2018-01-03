package br.edu.ifba.as.logica.telaAluno;

import br.edu.ifba.as.rn.TurmaRN;
import java.util.ArrayList;
import java.util.List;

public class ListaModalidades {
    private List<String> modalidades;
    private List<ListaCursos> cursos = new ArrayList<>();
    private int i;
    

    public ListaModalidades() {
        TurmaRN turmaRN = new TurmaRN();
        this.modalidades = turmaRN.listarModalidades();

        if(modalidades == null || modalidades.isEmpty()){
            
        }else{
            for(i=0; i<modalidades.size();i++){
                ListaCursos listaCursos = new ListaCursos(modalidades.get(i));
                this.cursos.add(listaCursos);
            }
        }
    }

    public List<String> getModalidades() {
        return modalidades;
    }

    public void setModalidades(List<String> modalidades) {
        this.modalidades = modalidades;
    }

    public List<ListaCursos> getCursos() {
        return cursos;
    }

    public void setCursos(List<ListaCursos> cursos) {
        this.cursos = cursos;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }
    
    
}
