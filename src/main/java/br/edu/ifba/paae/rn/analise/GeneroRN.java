package br.edu.ifba.paae.rn.analise;

import br.edu.ifba.paae.dao.DAOFactory;
import br.edu.ifba.paae.dao.analise.GeneroDAO;
import br.edu.ifba.paae.entidades.analise.Genero;
import java.util.List;

public class GeneroRN {
    private GeneroDAO generoDAO;

    public GeneroRN() {
        this.generoDAO = DAOFactory.criarGeneroDAO();
    }
    
    public void salvar(Genero genero){
        this.generoDAO.salvar(genero);
    }
    public void excluir(Genero genero){
        this.generoDAO.excluir(genero);
    }
    public Genero carregar(Integer codigo){
        return this.generoDAO.carregar(codigo);
    }
    public List<Genero> listar(){
        return this.generoDAO.listar();
    }    
    public void definirPadroes(){
// Aqui inicializa o banco colocando todas os objetos pre-definidos 
        Genero mulherSolteira = new Genero();
        Genero mulherCasada = new Genero();
        
        mulherSolteira.setTipo("Mulher chefe de família, mãe solteira ou viúva");
        mulherSolteira.setPontuacao(1F);
        
        mulherCasada.setTipo("Mulher chefe de família com companheiro");
        mulherCasada.setPontuacao(0.5F);
        
        this.generoDAO.salvar(mulherSolteira);
        this.generoDAO.salvar(mulherCasada);
    }
    public Float getPeso(){
        int i = 0;
        Float peso = 0.0F;
        List<Genero> list = listar();
        for(i=0; i<list.size(); i++){
            if(list.get(i).getPontuacao() != null && list.get(i).getPontuacao() > peso)
            peso = list.get(i).getPontuacao();
        }
        return peso;
    }  
    public Genero buscarPorAspectoEmAvaliacao(String tipo){
        return this.generoDAO.buscarPorAspectoEmAvaliacao(tipo);
    }     
}
