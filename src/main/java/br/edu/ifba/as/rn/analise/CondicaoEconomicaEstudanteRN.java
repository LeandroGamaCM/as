package br.edu.ifba.as.rn.analise;

import br.edu.ifba.as.dao.DAOFactory;
import br.edu.ifba.as.dao.analise.CondicaoEconomicaEstudanteDAO;
import br.edu.ifba.as.entidades.analise.CondicaoEconomicaEstudante;
import java.util.List;

public class CondicaoEconomicaEstudanteRN {
    private CondicaoEconomicaEstudanteDAO condicaoEconomicaEstudanteDAO;

    public CondicaoEconomicaEstudanteRN() {
        this.condicaoEconomicaEstudanteDAO = DAOFactory.criarCondicaoEconomicaEstudanteDAO();
    }
    
    public void salvar(CondicaoEconomicaEstudante condicaoEconomicaEstudante){
        this.condicaoEconomicaEstudanteDAO.salvar(condicaoEconomicaEstudante);
    }
    public void excluir(CondicaoEconomicaEstudante condicaoEconomicaEstudante){
        this.condicaoEconomicaEstudanteDAO.excluir(condicaoEconomicaEstudante);
    }
    public CondicaoEconomicaEstudante carregar(Integer codigo){
        return this.condicaoEconomicaEstudanteDAO.carregar(codigo);
    }
    public List<CondicaoEconomicaEstudante> listar(){
        return this.condicaoEconomicaEstudanteDAO.listar();
    }    
    public void definirPadroes(){
// Aqui inicializa o banco colocando todas os objetos pre-definidos       
    }
    
}
