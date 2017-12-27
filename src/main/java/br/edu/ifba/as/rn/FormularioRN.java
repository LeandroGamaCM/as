package br.edu.ifba.as.rn;

import br.edu.ifba.as.dao.DAOFactory;
import br.edu.ifba.as.dao.FormularioDAO;
import br.edu.ifba.as.entidades.formulario.Formulario;
import java.util.List;

public class FormularioRN {
    private FormularioDAO formularioDAO;

    public FormularioRN() {
        this.formularioDAO = DAOFactory.criarFormularioDAO();
    }
    
    public void salvar(Formulario formulario){
        this.formularioDAO.salvar(formulario);
    }
    public void excluir(Formulario formulario){
        this.formularioDAO.excluir(formulario);
    }
    public Formulario buscarPorAluno(Integer codAluno){
        return this.formularioDAO.buscarPorAluno(codAluno);
    }
    public Formulario carregar(Integer codigo){
        return this.formularioDAO.carregar(codigo);
    }
    public List<Formulario> listar(){
        return this.formularioDAO.listar();
    }
            
}
