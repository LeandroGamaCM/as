package br.edu.ifba.paae.dao.inscricao;

import br.edu.ifba.paae.entidades.inscricao.PeriodoInscricao;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

public class PeriodoInscricaoDAO {
    private Session sessao;

    public void setSessao(Session sessao) {
        this.sessao = sessao;
    }

    public PeriodoInscricao carregar(Integer codigo){
        return (PeriodoInscricao) this.sessao.get(PeriodoInscricao.class, codigo);
    }
    public List<PeriodoInscricao> listar(){
        return this.sessao.createCriteria(PeriodoInscricao.class).list();
    }
    public void salvar(PeriodoInscricao periodoInscricao){
        sessao.saveOrUpdate(periodoInscricao);
    }
    public void excluir(PeriodoInscricao periodoInscricao){
        sessao.delete(periodoInscricao);
    }
    public PeriodoInscricao buscarPorAno(Integer ano){
        String hql = "select p from PeriodoInscricao p where p.ano = :ano";
        Query c = this.sessao.createQuery(hql);
        c.setString("ano", ano.toString());
        return (PeriodoInscricao) c.uniqueResult();        
    }
    public PeriodoInscricao buscarPorAluno(Integer codAluno){
        String hql = "select p from PeriodoInscricao p, Aluno a where p.id = a.periodoInscricao AND a.aluno = :codAluno";
        Query c = this.sessao.createQuery(hql);
        c.setString("codAluno", codAluno.toString());
        return (PeriodoInscricao) c.uniqueResult();  
    }
}
