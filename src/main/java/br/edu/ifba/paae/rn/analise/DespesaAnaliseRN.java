package br.edu.ifba.paae.rn.analise;

import br.edu.ifba.paae.dao.DAOFactory;
import br.edu.ifba.paae.dao.analise.DespesaAnaliseDAO;
import br.edu.ifba.paae.entidades.analise.DespesaAnalise;
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
        DespesaAnalise endividamento = new DespesaAnalise();
        DespesaAnalise saude = new DespesaAnalise();
        DespesaAnalise educacao = new DespesaAnalise();
        DespesaAnalise energia = new DespesaAnalise();
        DespesaAnalise agua = new DespesaAnalise();
        DespesaAnalise outros = new DespesaAnalise();
        
        endividamento.setTipo("Endividamento (financiamento, consórcio, crédito e/ou 1 empréstimo)");
        endividamento.setPontuacao(1F);
        
        saude.setTipo("Saúde ");
        saude.setPontuacao(2F);
        
        educacao.setTipo("Educação");
        educacao.setPontuacao(2F);
        
        energia.setTipo("Energia");
        energia.setPontuacao(0.6F);
        
        agua.setTipo("Água");
        agua.setPontuacao(0.6F);
        
        outros.setTipo("Outro(s) de relevância");
        outros.setPontuacao(0.8F);
        
        this.despesaAnaliseDAO.salvar(endividamento);
        this.despesaAnaliseDAO.salvar(saude);
        this.despesaAnaliseDAO.salvar(educacao);
        this.despesaAnaliseDAO.salvar(energia);
        this.despesaAnaliseDAO.salvar(agua);
        this.despesaAnaliseDAO.salvar(outros);
    }
    public Float getPeso(){
        int i = 0;
        Float peso = 0.0F;
        List<DespesaAnalise> list = listar();
        for(i=0; i<list.size(); i++){
            if(list.get(i).getPontuacao() != null)
            peso = peso + list.get(i).getPontuacao();
        }
        return peso;
    }    
    public DespesaAnalise buscarPorAspectoEmAvaliacao(String tipo){
        return this.despesaAnaliseDAO.buscarPorAspectoEmAvaliacao(tipo);
    }     
}
