package br.edu.ifba.paae.rn.formulario;

import br.edu.ifba.paae.dao.DAOFactory;
import br.edu.ifba.paae.dao.formulario.ImovelDAO;
import br.edu.ifba.paae.entidades.formulario.Imovel;
import java.util.List;

public class ImovelRN {
    private ImovelDAO imovelDAO;

    public ImovelRN() {
        this.imovelDAO = DAOFactory.criarImovelDAO();
    }
    
    public void salvar(Imovel imovel){
        this.imovelDAO.salvar(imovel);
    }
    public void excluir(Imovel imovel){
        this.imovelDAO.excluir(imovel);
    }
    public Imovel buscarPorFamilia(Integer codFamilia){
        return this.imovelDAO.buscarPorFamilia(codFamilia);
    }
    public Imovel carregar(Integer codigo){
        return this.imovelDAO.carregar(codigo);
    }
    public List<Imovel> listar(){
        return this.imovelDAO.listar();
    }
         
}
