package br.edu.ifba.paae.rn.formulario;

import br.edu.ifba.paae.dao.DAOFactory;
import br.edu.ifba.paae.dao.formulario.DoencaDAO;
import br.edu.ifba.paae.entidades.formulario.Doenca;
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
    public Doenca buscarPorFamilia(Integer codFamilia){
        return this.doencaDAO.buscarPorFamilia(codFamilia);
    }
    public Doenca carregar(Integer codigo){
        return this.doencaDAO.carregar(codigo);
    }
    public List<Doenca> listar(){
        return this.doencaDAO.listar();
    }    
}
