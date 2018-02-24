package br.edu.ifba.paae.rn.inscricao;

import br.edu.ifba.paae.dao.DAOFactory;
import br.edu.ifba.paae.dao.inscricao.PeriodoInscricaoDAO;
import br.edu.ifba.paae.entidades.inscricao.PeriodoInscricao;
import java.time.LocalDateTime;
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
    public PeriodoInscricao last(){
        List<PeriodoInscricao> list = listar();
        PeriodoInscricao periodoInscricao;
        
        if(list != null && !list.isEmpty()){
            periodoInscricao = list.get(0);
            
            for (PeriodoInscricao pi : list) {
                if(pi.getAno() > periodoInscricao.getAno()){
                    periodoInscricao.setAno(pi.getAno());
                }
            }
            return periodoInscricao;
        }
        
        return null;
    }
    
    public void criarPrimeiro(){
        PeriodoInscricao periodoInscricao = new PeriodoInscricao();
        LocalDateTime now = LocalDateTime.now();
        
        periodoInscricao.setAno(now.getYear());
        periodoInscricao.setAtivado(Boolean.FALSE);
        
        salvar(periodoInscricao);
    }
}
