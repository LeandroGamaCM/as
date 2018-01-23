package br.edu.ifba.paae.rn.formulario;

import br.edu.ifba.paae.dao.DAOFactory;
import br.edu.ifba.paae.dao.formulario.DespesaDAO;
import br.edu.ifba.paae.entidades.formulario.Despesa;
import java.util.List;

public class DespesaRN {
    private DespesaDAO despesaDAO;

    public DespesaRN() {
        this.despesaDAO = DAOFactory.criarDespesaDAO();
    }
    
    public void salvar(Despesa despesa){
        this.despesaDAO.salvar(despesa);
    }
    public void excluir(Despesa despesa){
        this.despesaDAO.excluir(despesa);
    }
    public Despesa buscarPorFamilia(Integer codFamilia){
        return this.despesaDAO.buscarPorFamilia(codFamilia);
    }
    public Despesa carregar(Integer codigo){
        return this.despesaDAO.carregar(codigo);
    }
    public List<Despesa> listar(){
        return this.despesaDAO.listar();
    }
            
}
