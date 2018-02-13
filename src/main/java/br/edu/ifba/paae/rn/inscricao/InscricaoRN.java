package br.edu.ifba.paae.rn.inscricao;

import br.edu.ifba.paae.dao.DAOFactory;
import br.edu.ifba.paae.dao.inscricao.InscricaoDAO;
import br.edu.ifba.paae.entidades.inscricao.Inscricao;

public class InscricaoRN {
    private InscricaoDAO inscricaoDAO;

    public InscricaoRN() {
        this.inscricaoDAO = DAOFactory.criarInscricaoDAO();
    }
    
    public Inscricao carregar(){
        return this.inscricaoDAO.carregar();
    }
    public void salvar(Inscricao inscricao){
        this.inscricaoDAO.salvar(inscricao);
    }
    public void atualizar(Boolean periodoInscricao){
        this.inscricaoDAO.Atualizar(periodoInscricao);
    }
    public void criarInscricao(){
        Inscricao inscricao = new Inscricao();
        inscricao.setPeriodoInscricao(Boolean.FALSE);
        salvar(inscricao);
    }
    
}
