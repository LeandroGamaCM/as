package br.edu.ifba.as.rn.analise;

import br.edu.ifba.as.dao.DAOFactory;
import br.edu.ifba.as.dao.analise.MoradiaEstudanteDAO;
import br.edu.ifba.as.entidades.analise.MoradiaEstudante;
import java.util.List;

public class MoradiaEstudanteRN {
    private MoradiaEstudanteDAO moradiaEstudanteDAO;

    public MoradiaEstudanteRN() {
        this.moradiaEstudanteDAO = DAOFactory.criarMoradiaEstudanteDAO();
    }
    
    public void salvar(MoradiaEstudante moradiaEstudante){
        this.moradiaEstudanteDAO.salvar(moradiaEstudante);
    }
    public void excluir(MoradiaEstudante moradiaEstudante){
        this.moradiaEstudanteDAO.excluir(moradiaEstudante);
    }
    public MoradiaEstudante carregar(Integer codigo){
        return this.moradiaEstudanteDAO.carregar(codigo);
    }
    public List<MoradiaEstudante> listar(){
        return this.moradiaEstudanteDAO.listar();
    }    
    public void definirPadroes(){
// Aqui inicializa o banco colocando todas os objetos pre-definidos    
        MoradiaEstudante alugado = new MoradiaEstudante();
        MoradiaEstudante cedido = new MoradiaEstudante();
        MoradiaEstudante financiado = new MoradiaEstudante();
        MoradiaEstudante proprio = new MoradiaEstudante();

        alugado.setTipo("Alugado");
        cedido.setTipo("Cedido");
        financiado.setTipo("Financiado");
        proprio.setTipo("próprio");
        
        this.moradiaEstudanteDAO.salvar(alugado);
        this.moradiaEstudanteDAO.salvar(cedido);
        this.moradiaEstudanteDAO.salvar(financiado);
        this.moradiaEstudanteDAO.salvar(proprio);
    }
    
}
