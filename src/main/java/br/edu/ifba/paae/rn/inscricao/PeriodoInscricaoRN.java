package br.edu.ifba.paae.rn.inscricao;

import br.edu.ifba.paae.dao.DAOFactory;
import br.edu.ifba.paae.dao.inscricao.PeriodoInscricaoDAO;
import br.edu.ifba.paae.entidades.inscricao.PeriodoInscricao;
import java.util.List;

public class PeriodoInscricaoRN {
    private PeriodoInscricaoDAO periodoInscricaoDAO;

    public PeriodoInscricaoRN() {
        this.periodoInscricaoDAO = DAOFactory.criarPeriodoInscricaoDAO();
    }
    
    public void salvar(PeriodoInscricao periodoInscricao){
        this.periodoInscricaoDAO.salvar(periodoInscricao);
    }
    public void excluir(PeriodoInscricao periodoInscricao){
        this.periodoInscricaoDAO.excluir(periodoInscricao);
    }
    public PeriodoInscricao carregar(Integer codigo){
        return this.periodoInscricaoDAO.carregar(codigo);
    }
    public List<PeriodoInscricao> listar(){
        return this.periodoInscricaoDAO.listar();
    }
    public PeriodoInscricao buscarPorAno(Integer ano){
        return this.periodoInscricaoDAO.buscarPorAno(ano);
    }
    public PeriodoInscricao buscarPorAluno(Integer codAluno){
        return this.periodoInscricaoDAO.buscarPorAluno(codAluno);
    }
    
}
