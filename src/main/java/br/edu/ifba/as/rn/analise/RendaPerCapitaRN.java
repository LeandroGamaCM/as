package br.edu.ifba.as.rn.analise;

import br.edu.ifba.as.dao.DAOFactory;
import br.edu.ifba.as.dao.analise.RendaPerCapitaDAO;
import br.edu.ifba.as.entidades.analise.RendaPerCapita;
import java.util.List;

public class RendaPerCapitaRN {
    private RendaPerCapitaDAO rendaPerCapitaDAO;

    public RendaPerCapitaRN() {
        this.rendaPerCapitaDAO = DAOFactory.criarRendaPerCapitaDAO();
    }
    
    public void salvar(RendaPerCapita rendaPerCapita){
        this.rendaPerCapitaDAO.salvar(rendaPerCapita);
    }
    public void excluir(RendaPerCapita rendaPerCapita){
        this.rendaPerCapitaDAO.excluir(rendaPerCapita);
    }
    public RendaPerCapita carregar(Integer codigo){
        return this.rendaPerCapitaDAO.carregar(codigo);
    }
    public List<RendaPerCapita> listar(){
        return this.rendaPerCapitaDAO.listar();
    }    
    public void definirPadroes(){
// Aqui inicializa o banco colocando todas os objetos pre-definidos  
        RendaPerCapita limite1 = new RendaPerCapita();
        RendaPerCapita limite2 = new RendaPerCapita();
        RendaPerCapita limite3 = new RendaPerCapita();
        RendaPerCapita limite4 = new RendaPerCapita();
        RendaPerCapita limite5 = new RendaPerCapita();
        RendaPerCapita limite6 = new RendaPerCapita();
        RendaPerCapita limite7 = new RendaPerCapita();
        RendaPerCapita limite8 = new RendaPerCapita();
        RendaPerCapita limite9 = new RendaPerCapita();
        RendaPerCapita limite10 = new RendaPerCapita();
        
        limite1.setLimite(0.0);
        limite2.setLimite(0.0);
        limite3.setLimite(0.0);
        limite4.setLimite(0.0);
        limite5.setLimite(0.0);
        limite6.setLimite(0.0);
        limite7.setLimite(0.0);
        limite8.setLimite(0.0);
        limite9.setLimite(0.0);
        limite10.setLimite(0.0);

        this.rendaPerCapitaDAO.salvar(limite1);
        this.rendaPerCapitaDAO.salvar(limite2);
        this.rendaPerCapitaDAO.salvar(limite3);
        this.rendaPerCapitaDAO.salvar(limite4);
        this.rendaPerCapitaDAO.salvar(limite5);
        this.rendaPerCapitaDAO.salvar(limite6);
        this.rendaPerCapitaDAO.salvar(limite7);
        this.rendaPerCapitaDAO.salvar(limite8);
        this.rendaPerCapitaDAO.salvar(limite9);
        this.rendaPerCapitaDAO.salvar(limite10);
    }
    public Float getPeso(){
        int i = 0;
        Float peso = 0.0F;
        List<RendaPerCapita> list = listar();
        for(i=0; i<list.size(); i++){
            if(list.get(i).getPontuacao() != null)
            peso = peso + list.get(i).getPontuacao();
        }
        return peso;
    }
    public RendaPerCapita buscarPorAspectoEmAvaliacao(String tipo){
        return this.rendaPerCapitaDAO.buscarPorAspectoEmAvaliacao(tipo);
    }    
}
