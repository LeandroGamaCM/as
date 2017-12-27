package br.edu.ifba.as.rn;

import br.edu.ifba.as.dao.DAOFactory;
import br.edu.ifba.as.dao.BolsasAuxilioDAO;
import br.edu.ifba.as.entidades.formulario.BolsasAuxilio;
import java.util.List;

public class BolsasAuxilioRN {
    private BolsasAuxilioDAO bolsasAuxilioDAO;

    public BolsasAuxilioRN() {
        this.bolsasAuxilioDAO = DAOFactory.criarBolsasAuxilioDAO();
    }
    
    public void salvar(BolsasAuxilio bolsasAuxilio){
        this.bolsasAuxilioDAO.salvar(bolsasAuxilio);
    }
    public void excluir(BolsasAuxilio bolsasAuxilio){
        this.bolsasAuxilioDAO.excluir(bolsasAuxilio);
    }
    public BolsasAuxilio buscarPorAluno(Integer codAluno){
        return this.bolsasAuxilioDAO.buscarPorAluno(codAluno);
    }
    public BolsasAuxilio carregar(Integer codigo){
        return this.bolsasAuxilioDAO.carregar(codigo);
    }
    public List<BolsasAuxilio> listar(){
        return this.bolsasAuxilioDAO.listar();
    }
            
}
