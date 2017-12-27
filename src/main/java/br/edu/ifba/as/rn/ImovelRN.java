package br.edu.ifba.as.rn;

import br.edu.ifba.as.dao.DAOFactory;
import br.edu.ifba.as.dao.ImovelDAO;
import br.edu.ifba.as.entidades.formulario.Imovel;
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
