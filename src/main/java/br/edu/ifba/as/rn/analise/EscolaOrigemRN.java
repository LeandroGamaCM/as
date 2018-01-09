package br.edu.ifba.as.rn.analise;

import br.edu.ifba.as.dao.DAOFactory;
import br.edu.ifba.as.dao.analise.EscolaOrigemDAO;
import br.edu.ifba.as.entidades.analise.EscolaOrigem;
import java.util.List;

public class EscolaOrigemRN {
    private EscolaOrigemDAO escolaOrigemDAO;

    public EscolaOrigemRN() {
        this.escolaOrigemDAO = DAOFactory.criarEscolaOrigemDAO();
    }
    
    public void salvar(EscolaOrigem escolaOrigem){
        this.escolaOrigemDAO.salvar(escolaOrigem);
    }
    public void excluir(EscolaOrigem escolaOrigem){
        this.escolaOrigemDAO.excluir(escolaOrigem);
    }
    public EscolaOrigem carregar(Integer codigo){
        return this.escolaOrigemDAO.carregar(codigo);
    }
    public List<EscolaOrigem> listar(){
        return this.escolaOrigemDAO.listar();
    }    
    public void definirPadroes(){
// Aqui inicializa o banco colocando todas os objetos pre-definidos       
    }
    
}
