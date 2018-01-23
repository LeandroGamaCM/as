package br.edu.ifba.paae.dao.formulario;

import br.edu.ifba.paae.entidades.formulario.SituacaoResidencial;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

public class SituacaoResidencialDAO {
    private Session sessao;

    public void setSessao(Session sessao) {
        this.sessao = sessao;
    }

    public SituacaoResidencial buscarPorAluno(Integer codAluno){
        String hql = "select u from SituacaoResidencial u where u.situacaoResidencial = :codAluno";
        Query c = this.sessao.createQuery(hql);
        c.setString("codAluno", codAluno.toString());
        return (SituacaoResidencial) c.uniqueResult();
    }
    public SituacaoResidencial carregar(Integer codigo){
        return (SituacaoResidencial) this.sessao.get(SituacaoResidencial.class, codigo);
    }
    public List<SituacaoResidencial> listar(){
        return this.sessao.createCriteria(SituacaoResidencial.class).list();
    }
    public void salvar(SituacaoResidencial situacaoResidencial){
        sessao.saveOrUpdate(situacaoResidencial);
    }
    public void excluir(SituacaoResidencial situacaoResidencial){
        sessao.delete(situacaoResidencial);
    }

    
}
