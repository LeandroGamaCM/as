package br.edu.ifba.paae.rn.analise;

import br.edu.ifba.paae.dao.DAOFactory;
import br.edu.ifba.paae.dao.analise.RendaPerCapitaDAO;
import br.edu.ifba.paae.entidades.analise.RendaPerCapita;
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
    public Double buscarSalario(){
        return this.rendaPerCapitaDAO.buscarSalario();
    }
    public void definirPadroes(){
// Aqui inicializa o banco colocando todas os objetos pre-definidos  
        Double salario = 954.0;
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
        
        limite1.setLimite("Até R$ " + String.valueOf(salario*1.5*0.1));
        limite1.setSalario(salario);

        limite2.setLimite("Até R$ " + String.valueOf(salario*0.2*1.5));
        limite2.setSalario(salario);

        limite3.setLimite("Até R$ " + String.valueOf(salario*0.3*1.5));
        limite3.setSalario(salario);

        limite4.setLimite("Até R$ " + String.valueOf(salario*0.4*1.5));
        limite4.setSalario(salario);

        limite5.setLimite("Até R$ " + String.valueOf(salario*0.5*1.5));
        limite5.setSalario(salario);

        limite6.setLimite("Até R$ " + String.valueOf(salario*0.6*1.5));
        limite6.setSalario(salario);

        limite7.setLimite("Até R$ " + String.valueOf(salario*0.7*1.5));
        limite7.setSalario(salario);

        limite8.setLimite("Até R$ " + String.valueOf(salario*0.8*1.5));
        limite8.setSalario(salario);

        limite9.setLimite("Até R$ " + String.valueOf(salario*0.9*1.5));
        limite9.setSalario(salario);

        limite10.setLimite("Até R$ " + String.valueOf(salario*1.5));
        limite10.setSalario(salario);

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
    public void editarSalario(Double salario){
        salario += salario*0.5;
        List<RendaPerCapita> rendaPerCapitas = listar();
        int i;
        
        for(i=0; i<rendaPerCapitas.size(); i++){
            RendaPerCapita rendaPerCapita = rendaPerCapitas.get(i);
            rendaPerCapita.setLimite("Até R$ " + String.valueOf(salario*0.1 * i));
            salvar(rendaPerCapita);
        }
    }
}
