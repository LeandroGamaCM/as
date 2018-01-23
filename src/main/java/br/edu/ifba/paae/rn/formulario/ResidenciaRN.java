package br.edu.ifba.paae.rn.formulario;

import br.edu.ifba.paae.dao.DAOFactory;
import br.edu.ifba.paae.dao.formulario.ResidenciaDAO;
import br.edu.ifba.paae.entidades.formulario.Residencia;
import java.util.List;

public class ResidenciaRN {
    private ResidenciaDAO residenciaDAO;

    public ResidenciaRN() {
        this.residenciaDAO = DAOFactory.criarResidenciaDAO();
    }
    
    public void salvar(Residencia residencia){
        this.residenciaDAO.salvar(residencia);
    }
    public void excluir(Residencia residencia){
        this.residenciaDAO.excluir(residencia);
    }
    public Residencia buscarPorAluno(Integer codAluno){
        return this.residenciaDAO.buscarPorAluno(codAluno);
    }
    public Residencia carregar(Integer codigo){
        return this.residenciaDAO.carregar(codigo);
    }
    public List<Residencia> listar(){
        return this.residenciaDAO.listar();
    }
         
}
