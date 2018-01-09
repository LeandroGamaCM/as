package br.edu.ifba.as.rn.analise;

import br.edu.ifba.as.dao.DAOFactory;
import br.edu.ifba.as.dao.analise.RendaPrincipalOrigemDAO;
import br.edu.ifba.as.entidades.analise.RendaPrincipalOrigem;
import java.util.List;

public class RendaPrincipalOrigemRN {
    private RendaPrincipalOrigemDAO rendaPrincipalOrigemDAO;

    public RendaPrincipalOrigemRN() {
        this.rendaPrincipalOrigemDAO = DAOFactory.criarRendaPrincipalOrigemDAO();
    }
    
    public void salvar(RendaPrincipalOrigem rendaPrincipalOrigem){
        this.rendaPrincipalOrigemDAO.salvar(rendaPrincipalOrigem);
    }
    public void excluir(RendaPrincipalOrigem rendaPrincipalOrigem){
        this.rendaPrincipalOrigemDAO.excluir(rendaPrincipalOrigem);
    }
    public RendaPrincipalOrigem carregar(Integer codigo){
        return this.rendaPrincipalOrigemDAO.carregar(codigo);
    }
    public List<RendaPrincipalOrigem> listar(){
        return this.rendaPrincipalOrigemDAO.listar();
    }    
    public void definirPadroes(){
// Aqui inicializa o banco colocando todas os objetos pre-definidos       
    }
    
}
