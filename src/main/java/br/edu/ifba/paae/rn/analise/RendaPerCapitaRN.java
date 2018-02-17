package br.edu.ifba.paae.rn.analise;

import br.edu.ifba.paae.dao.DAOFactory;
import br.edu.ifba.paae.dao.analise.RendaPerCapitaDAO;
import br.edu.ifba.paae.entidades.analise.RendaPerCapita;
import java.util.ArrayList;
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
    public RendaPerCapita buscarPorLimite(Double limite){
        return this.rendaPerCapitaDAO.buscarPorLimite(limite);
    }
    public void definirPadroes(){
// Aqui inicializa o banco colocando todas os objetos pre-definidos  
        Double salario = 954.0;
        definir(salario);
    }    
    private void definir(Double salario){
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
        
        limite1.setLimite(Math.rint(salario*1.5*0.1));
        limite1.setSalario(salario);
        limite1.setPontuacao(30F);

        limite2.setLimite(Math.rint(salario*0.2*1.5));
        limite2.setSalario(salario);
        limite2.setPontuacao(27F);

        limite3.setLimite(Math.rint(salario*0.3*1.5));
        limite3.setSalario(salario);
        limite3.setPontuacao(24F);

        limite4.setLimite(Math.rint(salario*0.4*1.5));
        limite4.setSalario(salario);
        limite4.setPontuacao(21F);

        limite5.setLimite(Math.rint(salario*0.5*1.5));
        limite5.setSalario(salario);
        limite5.setPontuacao(15F);

        limite6.setLimite(Math.rint(salario*0.6*1.5));
        limite6.setSalario(salario);
        limite6.setPontuacao(9F);

        limite7.setLimite(Math.rint(salario*0.7*1.5));
        limite7.setSalario(salario);
        limite7.setPontuacao(6F);

        limite8.setLimite(Math.rint(salario*0.8*1.5));
        limite8.setSalario(salario);
        limite8.setPontuacao(3F);

        limite9.setLimite(Math.rint(salario*0.9*1.5));
        limite9.setSalario(salario);
        limite9.setPontuacao(2F);

        limite10.setLimite(Math.rint(salario*1.5));
        limite10.setSalario(salario);
        limite10.setPontuacao(1F);

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
            if(list.get(i).getPontuacao() != null && list.get(i).getPontuacao() > peso)
            peso = list.get(i).getPontuacao();
        }
        return peso;
    }
    public List<Double> listarLimites(){
        List<RendaPerCapita> rendaPerCapitas = listar();
        List<Double> limites = new ArrayList<>();
        int i;
        
        if(rendaPerCapitas != null){
            for(i=0; i<rendaPerCapitas.size(); i++){
                limites.add(rendaPerCapitas.get(i).getLimite());
            }            
        }
        return limites;
    }    
    public void editarSalario(Double salario){
        List<RendaPerCapita> rendaPerCapitas = listar();
        int i;

        if(rendaPerCapitas != null){
            for(i=0; i<rendaPerCapitas.size(); i++){
                RendaPerCapita rc = rendaPerCapitas.get(i);
                rc.setSalario(salario);
                rc.setLimite(Math.rint((salario*1.5*0.1*(i+1))));

                salvar(rc);
            }            
        }
    }
}
