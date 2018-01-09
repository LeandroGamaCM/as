package br.edu.ifba.as.rn.analise;

import br.edu.ifba.as.dao.DAOFactory;
import br.edu.ifba.as.dao.analise.EntrevistaDAO;
import br.edu.ifba.as.entidades.analise.Entrevista;
import java.util.List;

public class EntrevistaRN {
    private EntrevistaDAO entrevistaDAO;

    public EntrevistaRN() {
        this.entrevistaDAO = DAOFactory.criarEntrevistaDAO();
    }
    
    public void salvar(Entrevista entrevista){
        this.entrevistaDAO.salvar(entrevista);
    }
    public void excluir(Entrevista entrevista){
        this.entrevistaDAO.excluir(entrevista);
    }
    public Entrevista buscarPorAluno(Integer codAluno){
        return this.entrevistaDAO.buscarPorAluno(codAluno);
    }
    public Entrevista carregar(Integer codigo){
        return this.entrevistaDAO.carregar(codigo);
    }
    public List<Entrevista> listar(){
        return this.entrevistaDAO.listar();
    }
        
    
}
