package br.edu.ifba.as.rn;

import br.edu.ifba.as.dao.DAOFactory;
import br.edu.ifba.as.dao.FamiliaDAO;
import br.edu.ifba.as.entidades.formulario.Familia;
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
