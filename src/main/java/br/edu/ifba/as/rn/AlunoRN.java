package br.edu.ifba.as.rn;

import br.edu.ifba.as.dao.DAOFactory;
import br.edu.ifba.as.dao.AlunoDAO;
import br.edu.ifba.as.entidades.formulario.*;
import java.util.List;

public class AlunoRN {
    private AlunoDAO alunoDAO;

    public AlunoRN() {
        this.alunoDAO = DAOFactory.criarAlunoDAO();
    }
    
    public Aluno carregar(Integer codigo){
        return this.alunoDAO.carregar(codigo);
    }
    public Aluno buscarPorCPF(Integer valor){
        return this.alunoDAO.buscarPorCPF(valor);
    }    
    public void salvar(Aluno aluno){
        this.alunoDAO.salvar(aluno);
    } 
    public void excluir(Aluno aluno){
        this.alunoDAO.excluir(aluno);
    }
    public List<Aluno> listar(){
        return this.alunoDAO.listar();
    }
    public List<Aluno> buscarPorNome(String nome){
        return this.alunoDAO.buscarPorNome(nome);
    }
    public List<Aluno> buscarPorTurma(Integer codTurma){
        return this.alunoDAO.buscarPorTurma(codTurma);
    }

}
