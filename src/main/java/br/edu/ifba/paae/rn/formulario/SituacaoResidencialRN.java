package br.edu.ifba.paae.rn.formulario;

import br.edu.ifba.paae.dao.DAOFactory;
import br.edu.ifba.paae.dao.formulario.SituacaoResidencialDAO;
import br.edu.ifba.paae.entidades.formulario.SituacaoResidencial;
import java.util.List;

public class SituacaoResidencialRN {
    private SituacaoResidencialDAO situacaoResidencialDAO;

    public SituacaoResidencialRN() {
        this.situacaoResidencialDAO = DAOFactory.criarSituacaoResidencialDAO();
    }
    
    public void salvar(SituacaoResidencial situacaoResidencial){
        this.situacaoResidencialDAO.salvar(situacaoResidencial);
    }
    public void excluir(SituacaoResidencial situacaoResidencial){
        this.situacaoResidencialDAO.excluir(situacaoResidencial);
    }
    public SituacaoResidencial buscarPorAluno(Integer codAluno){
        return this.situacaoResidencialDAO.buscarPorAluno(codAluno);
    }
    public SituacaoResidencial carregar(Integer codigo){
        return this.situacaoResidencialDAO.carregar(codigo);
    }
    public List<SituacaoResidencial> listar(){
        return this.situacaoResidencialDAO.listar();
    }
         
}
