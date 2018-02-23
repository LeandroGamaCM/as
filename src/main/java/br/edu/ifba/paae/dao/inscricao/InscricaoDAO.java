package br.edu.ifba.paae.dao.inscricao;

import br.edu.ifba.paae.entidades.inscricao.Inscricao;
import org.hibernate.Session;

public class InscricaoDAO {
    private Session sessao;

    public void setSessao(Session sessao) {
        this.sessao = sessao;
    }
    
    public Inscricao carregar(){
        return (Inscricao) this.sessao.createCriteria(Inscricao.class).uniqueResult();
    }
    public void salvar(Inscricao inscricao){
        this.sessao.save(inscricao);
    }
    public void Atualizar(Boolean periodoInscricao){
        Inscricao inscricao = carregar();
        inscricao.setPeriodoInscricao(periodoInscricao);
        sessao.update(inscricao);
    }

}
