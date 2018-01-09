package br.edu.ifba.as.rn.analise;

import br.edu.ifba.as.dao.DAOFactory;
import br.edu.ifba.as.dao.analise.SituacaoOcupacionalDAO;
import br.edu.ifba.as.entidades.analise.SituacaoOcupacional;
import java.util.List;

public class SituacaoOcupacionalRN {
    private SituacaoOcupacionalDAO situacaoOcupacionalDAO;

    public SituacaoOcupacionalRN() {
        this.situacaoOcupacionalDAO = DAOFactory.criarSituacaoOcupacionalDAO();
    }
    
    public void salvar(SituacaoOcupacional situacaoOcupacional){
        this.situacaoOcupacionalDAO.salvar(situacaoOcupacional);
    }
    public void excluir(SituacaoOcupacional situacaoOcupacional){
        this.situacaoOcupacionalDAO.excluir(situacaoOcupacional);
    }
    public SituacaoOcupacional carregar(Integer codigo){
        return this.situacaoOcupacionalDAO.carregar(codigo);
    }
    public List<SituacaoOcupacional> listar(){
        return this.situacaoOcupacionalDAO.listar();
    }    
    public void definirPadroes(){
// Aqui inicializa o banco colocando todas os objetos pre-definidos       
    }
    
}
