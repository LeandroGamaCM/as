package br.edu.ifba.as.rn;

import br.edu.ifba.as.dao.DAOFactory;
import br.edu.ifba.as.dao.RendaDAO;
import br.edu.ifba.as.entidades.formulario.Renda;
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
    public List<Renda> buscarPorFamilia(Integer codFamilia){
        return this.rendaDAO.buscarPorFamilia(codFamilia);
    }
    public Renda carregar(Integer codigo){
        return this.rendaDAO.carregar(codigo);
    }
    public List<Renda> listar(){
        return this.rendaDAO.listar();
    }
         
}
