package br.edu.ifba.paae.rn.formulario;

import br.edu.ifba.paae.dao.DAOFactory;
import br.edu.ifba.paae.dao.formulario.CidadeDAO;
import br.edu.ifba.paae.entidades.formulario.Cidade;
import java.util.List;

public class CidadeRN {
    private CidadeDAO cidadeDAO;

    public CidadeRN() {
        this.cidadeDAO = DAOFactory.criarCidadeDAO();
    }
    
    public void salvar(Cidade cidade){
        this.cidadeDAO.salvar(cidade);
    }
    public Cidade carregar(Integer codigo){
        return this.cidadeDAO.carregar(codigo);
    }
    public List<Cidade> listar(){
        return this.cidadeDAO.listar();
    }
    public void definirPadroes(){
        System.out.println("\tPadroes de cidade");
        this.cidadeDAO.definirPadroes();
    }
}
