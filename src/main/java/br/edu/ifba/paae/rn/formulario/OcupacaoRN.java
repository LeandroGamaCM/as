package br.edu.ifba.paae.rn.formulario;

import br.edu.ifba.paae.dao.DAOFactory;
import br.edu.ifba.paae.dao.formulario.OcupacaoDAO;
import br.edu.ifba.paae.entidades.formulario.Ocupacao;
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
