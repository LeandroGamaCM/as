package br.edu.ifba.as.rn.analise;

import br.edu.ifba.as.dao.DAOFactory;
import br.edu.ifba.as.dao.analise.GeneroDAO;
import br.edu.ifba.as.entidades.analise.Genero;
import java.util.List;

public class GeneroRN {
    private GeneroDAO generoDAO;

    public GeneroRN() {
        this.generoDAO = DAOFactory.criarGeneroDAO();
    }
    
    public void salvar(Genero genero){
        this.generoDAO.salvar(genero);
    }
    public void excluir(Genero genero){
        this.generoDAO.excluir(genero);
    }
    public Genero carregar(Integer codigo){
        return this.generoDAO.carregar(codigo);
    }
    public List<Genero> listar(){
        return this.generoDAO.listar();
    }    
    public void definirPadroes(){
// Aqui inicializa o banco colocando todas os objetos pre-definidos       
    }
    
}
