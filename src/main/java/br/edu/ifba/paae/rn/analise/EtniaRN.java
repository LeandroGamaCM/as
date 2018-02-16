package br.edu.ifba.paae.rn.analise;

import br.edu.ifba.paae.dao.DAOFactory;
import br.edu.ifba.paae.dao.analise.EtniaDAO;
import br.edu.ifba.paae.entidades.analise.Etnia;
import java.util.List;

public class EtniaRN {
    private EtniaDAO etniaDAO;

    public EtniaRN() {
        this.etniaDAO = DAOFactory.criarEtniaDAO();
    }
    
    public void salvar(Etnia etnia){
        this.etniaDAO.salvar(etnia);
    }
    public void excluir(Etnia etnia){
        this.etniaDAO.excluir(etnia);
    }
    public Etnia carregar(Integer codigo){
        return this.etniaDAO.carregar(codigo);
    }
    public List<Etnia> listar(){
        return this.etniaDAO.listar();
    }    
    public void definirPadroes(){
// Aqui inicializa o banco colocando todas os objetos pre-definidos
        Etnia negroIndigena = new Etnia();
        Etnia pardo = new Etnia();
        Etnia brancoAmareloOutro = new Etnia();

        negroIndigena.setTipo("Negro ou Indígena");
        negroIndigena.setPontuacao(2F);
        
        pardo.setTipo("Pardo");
        pardo.setPontuacao(1F);
        
        brancoAmareloOutro.setTipo("Branco, amarelo ou outra");
        brancoAmareloOutro.setPontuacao(0.5F);
        
        this.etniaDAO.salvar(negroIndigena);
        this.etniaDAO.salvar(pardo);
        this.etniaDAO.salvar(brancoAmareloOutro);
        
    }
    public Float getPeso(){
        int i = 0;
        Float peso = 0.0F;
        List<Etnia> list = listar();
        for(i=0; i<list.size(); i++){
            if(list.get(i).getPontuacao() != null && list.get(i).getPontuacao() > peso)
            peso = list.get(i).getPontuacao();
        }
        return peso;
    }  
    public Etnia buscarPorAspectoEmAvaliacao(String tipo){
        return this.etniaDAO.buscarPorAspectoEmAvaliacao(tipo);
    }     
}
