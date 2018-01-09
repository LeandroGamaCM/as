package br.edu.ifba.as.rn.analise;

import br.edu.ifba.as.dao.DAOFactory;
import br.edu.ifba.as.dao.analise.DespesaAnaliseDAO;
import br.edu.ifba.as.entidades.analise.DespesaAnalise;
import java.util.List;

public class DespesaAnaliseRN {
    private DespesaAnaliseDAO despesaAnaliseDAO;

    public DespesaAnaliseRN() {
        this.despesaAnaliseDAO = DAOFactory.criarDespesaAnaliseDAO();
    }
    
    public void salvar(DespesaAnalise despesaAnalise){
        this.despesaAnaliseDAO.salvar(despesaAnalise);
    }
    public void excluir(DespesaAnalise despesaAnalise){
        this.despesaAnaliseDAO.excluir(despesaAnalise);
    }
    public DespesaAnalise carregar(Integer codigo){
        return this.despesaAnaliseDAO.carregar(codigo);
    }
    public List<DespesaAnalise> listar(){
        return this.despesaAnaliseDAO.listar();
    }    
    public void definirPadroes(){
// Aqui inicializa o banco colocando todas os objetos pre-definidos       
    }
    
}
