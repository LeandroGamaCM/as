package br.edu.ifba.as.rn.analise;

import br.edu.ifba.as.dao.DAOFactory;
import br.edu.ifba.as.dao.analise.MoradiaFamiliaDAO;
import br.edu.ifba.as.entidades.analise.MoradiaFamilia;
import java.util.List;

public class MoradiaFamiliaRN {
    private MoradiaFamiliaDAO moradiaFamiliaDAO;

    public MoradiaFamiliaRN() {
        this.moradiaFamiliaDAO = DAOFactory.criarMoradiaFamiliaDAO();
    }
    
    public void salvar(MoradiaFamilia moradiaFamilia){
        this.moradiaFamiliaDAO.salvar(moradiaFamilia);
    }
    public void excluir(MoradiaFamilia moradiaFamilia){
        this.moradiaFamiliaDAO.excluir(moradiaFamilia);
    }
    public MoradiaFamilia carregar(Integer codigo){
        return this.moradiaFamiliaDAO.carregar(codigo);
    }
    public List<MoradiaFamilia> listar(){
        return this.moradiaFamiliaDAO.listar();
    }    
    public void definirPadroes(){
// Aqui inicializa o banco colocando todas os objetos pre-definidos       
        MoradiaFamilia alugado = new MoradiaFamilia();
        MoradiaFamilia cedido = new MoradiaFamilia();
        MoradiaFamilia financiado = new MoradiaFamilia();
        MoradiaFamilia proprio = new MoradiaFamilia();

        alugado.setTipo("Alugado");
        cedido.setTipo("Cedido");
        financiado.setTipo("Financiado");
        proprio.setTipo("próprio");
        
        this.moradiaFamiliaDAO.salvar(alugado);
        this.moradiaFamiliaDAO.salvar(cedido);
        this.moradiaFamiliaDAO.salvar(financiado);
        this.moradiaFamiliaDAO.salvar(proprio);
    }

    
    
}
