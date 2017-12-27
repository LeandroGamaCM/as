package br.edu.ifba.as.rn;

import br.edu.ifba.as.dao.DAOFactory;
import br.edu.ifba.as.dao.CondicaoManutencaoDAO;
import br.edu.ifba.as.entidades.formulario.CondicaoManutencao;
import java.util.List;

public class CondicaoManutencaoRN {
    private CondicaoManutencaoDAO condicaoManutencaoDAO;

    public CondicaoManutencaoRN() {
        this.condicaoManutencaoDAO = DAOFactory.criarCondicaoManutencaoDAO();
    }
    
    public void salvar(CondicaoManutencao condicaoManutencao){
        this.condicaoManutencaoDAO.salvar(condicaoManutencao);
    }
    public void excluir(CondicaoManutencao condicaoManutencao){
        this.condicaoManutencaoDAO.excluir(condicaoManutencao);
    }
    public CondicaoManutencao buscarPorAluno(Integer codAluno){
        return this.condicaoManutencaoDAO.buscarPorAluno(codAluno);
    }
    public CondicaoManutencao carregar(Integer codigo){
        return this.condicaoManutencaoDAO.carregar(codigo);
    }
    public List<CondicaoManutencao> listar(){
        return this.condicaoManutencaoDAO.listar();
    }
            
}
