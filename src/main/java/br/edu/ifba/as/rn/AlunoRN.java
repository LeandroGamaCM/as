package br.edu.ifba.as.rn;

import br.edu.ifba.as.dao.DAOFactory;
import br.edu.ifba.as.dao.AlunoDAO;
import br.edu.ifba.as.entidades.formulario.Aluno;
import java.util.List;

public class AlunoRN {
    private AlunoDAO alunoDAO;

    public AlunoRN() {
        this.alunoDAO = DAOFactory.criarAlunoDAO();
    }
    
    public Aluno carregar(Integer codigo){
        return this.alunoDAO.carregar(codigo);
    }
    // MUDAR O SENTIDO DESSA BUSCA ---------------------------------------------
    public Aluno buscar(Integer valor){
        return this.alunoDAO.buscar(valor);
    }
    
    public void salvar(Aluno aluno){
        Integer codigo = aluno.getAluno();
        if(codigo == null || codigo == 0){
            this.alunoDAO.salvar(aluno);
        }else{
            this.alunoDAO.atualizar(aluno);
        }
    } 
    public void excluir(Aluno aluno){
        this.alunoDAO.excluir(aluno);
    }
    public List<Aluno> listar(){
        return this.alunoDAO.listar();
    }
    
    
    
}
