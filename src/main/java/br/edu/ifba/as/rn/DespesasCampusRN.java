package br.edu.ifba.as.rn;

import br.edu.ifba.as.dao.DAOFactory;
import br.edu.ifba.as.dao.DespesasCampusDAO;
import br.edu.ifba.as.entidades.formulario.DespesasCampus;
import java.util.List;

public class DespesasCampusRN {
    private DespesasCampusDAO despesasCampusDAO;

    public DespesasCampusRN() {
        this.despesasCampusDAO = DAOFactory.criarDespesasCampusDAO();
    }
    
    public void salvar(DespesasCampus despesasCampus){
        this.despesasCampusDAO.salvar(despesasCampus);
    }
    public void excluir(DespesasCampus despesasCampus){
        this.despesasCampusDAO.excluir(despesasCampus);
    }
    public DespesasCampus buscarPorAluno(Integer codAluno){
        return this.despesasCampusDAO.buscarPorAluno(codAluno);
    }
    public DespesasCampus carregar(Integer codigo){
        return this.despesasCampusDAO.carregar(codigo);
    }
    public List<DespesasCampus> listar(){
        return this.despesasCampusDAO.listar();
    }
            
}
