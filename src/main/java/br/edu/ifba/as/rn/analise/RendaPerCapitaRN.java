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
    
}
