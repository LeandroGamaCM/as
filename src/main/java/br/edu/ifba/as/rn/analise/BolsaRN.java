package br.edu.ifba.as.rn.analise;

import br.edu.ifba.as.dao.DAOFactory;
import br.edu.ifba.as.dao.analise.BolsaDAO;
import br.edu.ifba.as.entidades.analise.Bolsa;
import java.util.List;

public class BolsaRN {
    private BolsaDAO bolsaDAO;

    public BolsaRN() {
        this.bolsaDAO = DAOFactory.criarBolsaDAO();
    }
    
    public void salvar(Bolsa bolsa){
        this.bolsaDAO.salvar(bolsa);
    }
    public void excluir(Bolsa bolsa){
        this.bolsaDAO.excluir(bolsa);
    }
    public Bolsa carregar(Integer codigo){
        return this.bolsaDAO.carregar(codigo);
    }
    public List<Bolsa> listar(){
        return this.bolsaDAO.listar();
    }    
    public void definirPadroes(){
// Aqui inicializa o banco colocando todas os objetos pre-definidos       
    }
}
