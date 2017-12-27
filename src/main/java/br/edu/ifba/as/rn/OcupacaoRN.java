package br.edu.ifba.as.rn;

import br.edu.ifba.as.dao.DAOFactory;
import br.edu.ifba.as.dao.OcupacaoDAO;
import br.edu.ifba.as.entidades.formulario.Ocupacao;
import java.util.List;

public class OcupacaoRN {
    private OcupacaoDAO ocupacaoDAO;

    public OcupacaoRN() {
        this.ocupacaoDAO = DAOFactory.criarOcupacaoDAO();
    }
    
    public void salvar(Ocupacao ocupacao){
        this.ocupacaoDAO.salvar(ocupacao);
    }
    public void excluir(Ocupacao ocupacao){
        this.ocupacaoDAO.excluir(ocupacao);
    }
    public Ocupacao buscarPorAluno(Integer codAluno){
        return this.ocupacaoDAO.buscarPorAluno(codAluno);
    }
    public Ocupacao carregar(Integer codigo){
        return this.ocupacaoDAO.carregar(codigo);
    }
    public List<Ocupacao> listar(){
        return this.ocupacaoDAO.listar();
    }
         
}
