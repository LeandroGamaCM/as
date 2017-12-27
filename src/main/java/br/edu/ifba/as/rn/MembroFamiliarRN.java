package br.edu.ifba.as.rn;

import br.edu.ifba.as.dao.DAOFactory;
import br.edu.ifba.as.dao.MembroFamiliarDAO;
import br.edu.ifba.as.entidades.formulario.MembroFamiliar;
import java.util.List;

public class MembroFamiliarRN {
    private MembroFamiliarDAO membroFamiliarDAO;

    public MembroFamiliarRN() {
        this.membroFamiliarDAO = DAOFactory.criarMembroFamiliarDAO();
    }
    
    public void salvar(MembroFamiliar membroFamiliar){
        this.membroFamiliarDAO.salvar(membroFamiliar);
    }
    public void excluir(MembroFamiliar membroFamiliar){
        this.membroFamiliarDAO.excluir(membroFamiliar);
    }
    public List<MembroFamiliar> buscarPorFamilia(Integer codFamilia){
        return this.membroFamiliarDAO.buscarPorFamilia(codFamilia);
    }
    public MembroFamiliar carregar(Integer codigo){
        return this.membroFamiliarDAO.carregar(codigo);
    }
    public List<MembroFamiliar> listar(){
        return this.membroFamiliarDAO.listar();
    }
             
}
