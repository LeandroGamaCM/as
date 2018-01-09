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
        DespesaAnalise endividamento1 = new DespesaAnalise();
        DespesaAnalise endividamento2 = new DespesaAnalise();
        DespesaAnalise saude = new DespesaAnalise();
        DespesaAnalise educacao = new DespesaAnalise();
        DespesaAnalise energia = new DespesaAnalise();
        DespesaAnalise agua = new DespesaAnalise();
        DespesaAnalise outros = new DespesaAnalise();
        
        endividamento1.setTipo("Endividamento (financiamento, consórcio, crédito e/ou 1 empréstimo)");
        endividamento2.setTipo("Endividamento (a partir de 2 empréstimos)");
        saude.setTipo("Saúde ");
        educacao.setTipo("Educação");
        energia.setTipo("Energia");
        agua.setTipo("Água");
        outros.setTipo("Outro(s) de relevância");
        
        this.despesaAnaliseDAO.salvar(endividamento1);
        this.despesaAnaliseDAO.salvar(endividamento2);
        this.despesaAnaliseDAO.salvar(saude);
        this.despesaAnaliseDAO.salvar(educacao);
        this.despesaAnaliseDAO.salvar(energia);
        this.despesaAnaliseDAO.salvar(agua);
        this.despesaAnaliseDAO.salvar(outros);
    }
    
}
