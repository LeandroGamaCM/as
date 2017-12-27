package br.edu.ifba.as.rn;

import br.edu.ifba.as.dao.DAOFactory;
import br.edu.ifba.as.dao.DoencaDAO;
import br.edu.ifba.as.entidades.formulario.Doenca;
import java.util.List;

public class DoencaRN {
    private DoencaDAO doencaDAO;

    public DoencaRN() {
        this.doencaDAO = DAOFactory.criarDoencaDAO();
    }
    
    public void salvar(Doenca doenca){
        this.doencaDAO.salvar(doenca);
    }
    public void excluir(Doenca doenca){
        this.doencaDAO.excluir(doenca);
    }
    public List<Doenca> buscarPorMembroFamiliar(Integer codMembroFamiliar){
        return this.doencaDAO.buscarPorMembroFamiliar(codMembroFamiliar);
    }
    public Doenca carregar(Integer codigo){
        return this.doencaDAO.carregar(codigo);
    }
    public List<Doenca> listar(){
        return this.doencaDAO.listar();
    }    
}
