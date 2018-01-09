package br.edu.ifba.as.rn.analise;

import br.edu.ifba.as.dao.DAOFactory;
import br.edu.ifba.as.dao.analise.EtniaDAO;
import br.edu.ifba.as.entidades.analise.Etnia;
import java.util.List;

public class EtniaRN {
    private EtniaDAO etniaDAO;

    public EtniaRN() {
        this.etniaDAO = DAOFactory.criarEtniaDAO();
    }
    
    public void salvar(Etnia etnia){
        this.etniaDAO.salvar(etnia);
    }
    public void excluir(Etnia etnia){
        this.etniaDAO.excluir(etnia);
    }
    public Etnia carregar(Integer codigo){
        return this.etniaDAO.carregar(codigo);
    }
    public List<Etnia> listar(){
        return this.etniaDAO.listar();
    }    
    public void definirPadroes(){
// Aqui inicializa o banco colocando todas os objetos pre-definidos       
    }
    
}
