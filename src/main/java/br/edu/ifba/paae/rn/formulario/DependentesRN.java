package br.edu.ifba.paae.rn.formulario;

import br.edu.ifba.paae.dao.DAOFactory;
import br.edu.ifba.paae.dao.formulario.DependentesDAO;
import br.edu.ifba.paae.entidades.formulario.Dependentes;
import java.util.List;

public class DependentesRN {
    private DependentesDAO dependentesDAO;

    public DependentesRN() {
        this.dependentesDAO = DAOFactory.criarDependentesDAO();
    }
    
    public void salvar(Dependentes dependentes){
        this.dependentesDAO.salvar(dependentes);
    }
    public void excluir(Dependentes dependentes){
        this.dependentesDAO.excluir(dependentes);
    }
    public Dependentes buscarPorAluno(Integer codAluno){
        return this.dependentesDAO.buscarPorAluno(codAluno);
    }
    public Dependentes carregar(Integer codigo){
        return this.dependentesDAO.carregar(codigo);
    }
    public List<Dependentes> listar(){
        return this.dependentesDAO.listar();
    }
            
}
