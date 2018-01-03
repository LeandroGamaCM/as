package br.edu.ifba.as.logica.telaAluno;

import br.edu.ifba.as.entidades.formulario.Aluno;
import br.edu.ifba.as.entidades.formulario.Turma;
import br.edu.ifba.as.rn.AlunoRN;
import java.util.List;

public class ListaAlunosInversa {
    private List<Aluno> alunos;
    private List<Turma> turmas;
    
    public ListaAlunosInversa() {
        AlunoRN alunoRN = new AlunoRN();
        int i;
        
        alunos = alunoRN.listar();
        
        if(alunos != null || !alunos.isEmpty()){
            for(i=0;i<alunos.size();i++){
                

            }
            
        }
    }
    
    
}
