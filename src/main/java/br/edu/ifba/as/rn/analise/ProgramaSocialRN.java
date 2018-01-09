package br.edu.ifba.as.rn.analise;

import br.edu.ifba.as.dao.DAOFactory;
import br.edu.ifba.as.dao.analise.ProgramaSocialDAO;
import br.edu.ifba.as.entidades.analise.ProgramaSocial;
import java.util.List;

public class ProgramaSocialRN {
    private ProgramaSocialDAO programaSocialDAO;

    public ProgramaSocialRN() {
        this.programaSocialDAO = DAOFactory.criarProgramaSocialDAO();
    }
    
    public void salvar(ProgramaSocial programaSocial){
        this.programaSocialDAO.salvar(programaSocial);
    }
    public void excluir(ProgramaSocial programaSocial){
        this.programaSocialDAO.excluir(programaSocial);
    }
    public ProgramaSocial carregar(Integer codigo){
        return this.programaSocialDAO.carregar(codigo);
    }
    public List<ProgramaSocial> listar(){
        return this.programaSocialDAO.listar();
    }    
    public void definirPadroes(){
// Aqui inicializa o banco colocando todas os objetos pre-definidos       
    }
    
}
