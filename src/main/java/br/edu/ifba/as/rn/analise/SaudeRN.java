package br.edu.ifba.as.rn.analise;

import br.edu.ifba.as.dao.DAOFactory;
import br.edu.ifba.as.dao.analise.SaudeDAO;
import br.edu.ifba.as.entidades.analise.Saude;
import java.util.List;

public class SaudeRN {
    private SaudeDAO saudeDAO;

    public SaudeRN() {
        this.saudeDAO = DAOFactory.criarSaudeDAO();
    }
    
    public void salvar(Saude saude){
        this.saudeDAO.salvar(saude);
    }
    public void excluir(Saude saude){
        this.saudeDAO.excluir(saude);
    }
    public Saude carregar(Integer codigo){
        return this.saudeDAO.carregar(codigo);
    }
    public List<Saude> listar(){
        return this.saudeDAO.listar();
    }    
    public void definirPadroes(){
// Aqui inicializa o banco colocando todas os objetos pre-definidos       
    }
    
}
