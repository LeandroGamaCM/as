package br.edu.ifba.as.logica.telaAluno;

import br.edu.ifba.as.rn.TurmaRN;
import java.util.List;

public class ListaModalidades {
    private List<String> modalidades;

    public ListaModalidades() {
        TurmaRN turmaRN = new TurmaRN();
        this.modalidades = turmaRN.listarModalidades();
    }

    public List<String> getModalidades() {
        return modalidades;
    }

    public void setModalidades(List<String> modalidades) {
        this.modalidades = modalidades;
    }
    
    
}
