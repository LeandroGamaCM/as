package br.edu.ifba.paae.rn.formulario;

import br.edu.ifba.paae.dao.DAOFactory;
import br.edu.ifba.paae.dao.formulario.RendaDAO;
import br.edu.ifba.paae.entidades.formulario.Renda;
import java.util.List;

public class RendaRN {
    private RendaDAO rendaDAO;

    public RendaRN() {
        this.rendaDAO = DAOFactory.criarRendaDAO();
    }
    
    public void salvar(Renda renda){
        this.rendaDAO.salvar(renda);
    }
    public void excluir(Renda renda){
        this.rendaDAO.excluir(renda);
    }
    public Renda buscarPorFamilia(Integer codFamilia){
        return this.rendaDAO.buscarPorFamilia(codFamilia);
    }
    public Renda carregar(Integer codigo){
        return this.rendaDAO.carregar(codigo);
    }
    public List<Renda> listar(){
        return this.rendaDAO.listar();
    }
         
}
