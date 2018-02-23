package br.edu.ifba.paae.rn.formulario;

import br.edu.ifba.paae.dao.DAOFactory;
import br.edu.ifba.paae.dao.formulario.CondicaoManutencaoDAO;
import br.edu.ifba.paae.entidades.formulario.CondicaoManutencao;
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
