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
        EscolaOrigem publica = new EscolaOrigem();
        EscolaOrigem privadaBolsa = new EscolaOrigem();
        EscolaOrigem privataSemBolsa = new EscolaOrigem();
    
        publica.setTipo("Pública");
        privadaBolsa.setTipo("Privada com bolsa de estudo parcial ou integral");
        privataSemBolsa.setTipo("Privada sem bolsa de estudo");
        
        this.escolaOrigemDAO.salvar(publica);
        this.escolaOrigemDAO.salvar(privadaBolsa);
        this.escolaOrigemDAO.salvar(privataSemBolsa);
    }
    public Float getPeso(){
        int i = 0;
        Float peso = 0.0F;
        List<EscolaOrigem> list = listar();
        for(i=0; i<list.size(); i++){
            if(list.get(i).getPontuacao() != null)
            peso = peso + list.get(i).getPontuacao();
        }
        return peso;
    }    
    public EscolaOrigem buscarPorAspectoEmAvaliacao(String tipo){
        return this.escolaOrigemDAO.buscarPorAspectoEmAvaliacao(tipo);
    } 
}
