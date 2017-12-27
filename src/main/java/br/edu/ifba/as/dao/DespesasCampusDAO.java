package br.edu.ifba.as.dao;

import br.edu.ifba.as.entidades.formulario.DespesasCampus;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

public class DespesasCampusDAO {
    private Session sessao;

    public void setSessao(Session sessao) {
        this.sessao = sessao;
    }

    public DespesasCampus buscarPorAluno(Integer codAluno){
        String hql = "select u from DespesasCampus u where u.despesasCampus = :codAluno";
        Query c = this.sessao.createQuery(hql);
        c.setString("codAluno", codAluno.toString());
        return (DespesasCampus) c.uniqueResult();
    }
    public DespesasCampus carregar(Integer codigo){
        return (DespesasCampus) this.sessao.get(DespesasCampus.class, codigo);
    }
    public List<DespesasCampus> listar(){
        return this.sessao.createCriteria(DespesasCampus.class).list();
    }
    public void salvar(DespesasCampus despesasCampus){
        sessao.saveOrUpdate(despesasCampus);
    }
    public void excluir(DespesasCampus despesasCampus){
        sessao.delete(despesasCampus);
    }


    
}
