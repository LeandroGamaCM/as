package br.edu.ifba.paae.rn.analise;

import br.edu.ifba.paae.dao.DAOFactory;
import br.edu.ifba.paae.dao.analise.EscolaOrigemDAO;
import br.edu.ifba.paae.entidades.analise.EscolaOrigem;
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
        EscolaOrigem privadaSemBolsa = new EscolaOrigem();
    
        publica.setTipo("Pública");
        publica.setPontuacao(20F);
                
        privadaBolsa.setTipo("Privada com bolsa de estudo parcial ou integral");
        privadaBolsa.setPontuacao(10F);
        
        privadaSemBolsa.setTipo("Privada sem bolsa de estudo");
        privadaSemBolsa.setPontuacao(5F);
        
        this.escolaOrigemDAO.salvar(publica);
        this.escolaOrigemDAO.salvar(privadaBolsa);
        this.escolaOrigemDAO.salvar(privadaSemBolsa);
    }
    public Float getPeso(){
        int i = 0;
        Float peso = 0.0F;
        List<EscolaOrigem> list = listar();
        for(i=0; i<list.size(); i++){
            if(list.get(i).getPontuacao() != null && list.get(i).getPontuacao() > peso)
            peso = list.get(i).getPontuacao();
        }
        return peso;
    }    
    public EscolaOrigem buscarPorAspectoEmAvaliacao(String tipo){
        return this.escolaOrigemDAO.buscarPorAspectoEmAvaliacao(tipo);
    } 
}
