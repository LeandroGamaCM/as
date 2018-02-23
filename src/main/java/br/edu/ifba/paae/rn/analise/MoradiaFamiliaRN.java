package br.edu.ifba.paae.rn.analise;

import br.edu.ifba.paae.dao.DAOFactory;
import br.edu.ifba.paae.dao.analise.MoradiaFamiliaDAO;
import br.edu.ifba.paae.entidades.analise.MoradiaFamilia;
import java.util.List;

public class MoradiaFamiliaRN {
    private MoradiaFamiliaDAO moradiaFamiliaDAO;

    public MoradiaFamiliaRN() {
        this.moradiaFamiliaDAO = DAOFactory.criarMoradiaFamiliaDAO();
    }
    
    public void salvar(MoradiaFamilia moradiaFamilia){
        this.moradiaFamiliaDAO.salvar(moradiaFamilia);
    }
    public void excluir(MoradiaFamilia moradiaFamilia){
        this.moradiaFamiliaDAO.excluir(moradiaFamilia);
    }
    public MoradiaFamilia carregar(Integer codigo){
        return this.moradiaFamiliaDAO.carregar(codigo);
    }
    public List<MoradiaFamilia> listar(){
        return this.moradiaFamiliaDAO.listar();
    }    
    public void definirPadroes(){
// Aqui inicializa o banco colocando todas os objetos pre-definidos       
        MoradiaFamilia alugado = new MoradiaFamilia();
        MoradiaFamilia cedido = new MoradiaFamilia();
        MoradiaFamilia financiado = new MoradiaFamilia();
        MoradiaFamilia proprio = new MoradiaFamilia();

        alugado.setTipo("Alugado");
        alugado.setPontuacao(3F);
        
        cedido.setTipo("Cedido");
        cedido.setPontuacao(2F);
        
        financiado.setTipo("Financiado");
        financiado.setPontuacao(1F);
        
        proprio.setTipo("Próprio");
        proprio.setPontuacao(0.5F);      
        
        this.moradiaFamiliaDAO.salvar(alugado);
        this.moradiaFamiliaDAO.salvar(cedido);
        this.moradiaFamiliaDAO.salvar(financiado);
        this.moradiaFamiliaDAO.salvar(proprio);
    }
    public Float getPeso(){
        int i = 0;
        Float peso = 0.0F;
        List<MoradiaFamilia> list = listar();
        for(i=0; i<list.size(); i++){
            if(list.get(i).getPontuacao() != null && list.get(i).getPontuacao() > peso)
            peso = list.get(i).getPontuacao();
        }
        return peso;
    }
    public MoradiaFamilia buscarPorAspectoEmAvaliacao(String tipo){
        return this.moradiaFamiliaDAO.buscarPorAspectoEmAvaliacao(tipo);
    }     
    
}
