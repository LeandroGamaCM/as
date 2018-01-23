package br.edu.ifba.paae.rn.formulario;

import br.edu.ifba.paae.dao.DAOFactory;
import br.edu.ifba.paae.dao.formulario.FamiliaDAO;
import br.edu.ifba.paae.entidades.formulario.Familia;
import java.util.List;

public class FamiliaRN {
    private FamiliaDAO familiaDAO;

    public FamiliaRN() {
        this.familiaDAO = DAOFactory.criarFamiliaDAO();
    }
    
    public void salvar(Familia familia){
        this.familiaDAO.salvar(familia);
    }
    public void excluir(Familia familia){
        this.familiaDAO.excluir(familia);
    }
    public Familia buscarPorAluno(Integer codAluno){
        return this.familiaDAO.buscarPorAluno(codAluno);
    }
    public Familia carregar(Integer codigo){
        return this.familiaDAO.carregar(codigo);
    }
    public List<Familia> listar(){
        return this.familiaDAO.listar();
    }
            
}
