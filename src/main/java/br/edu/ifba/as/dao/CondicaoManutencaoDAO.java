package br.edu.ifba.as.dao;

import br.edu.ifba.as.entidades.formulario.CondicaoManutencao;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

public class CondicaoManutencaoDAO {
    private Session sessao;

    public void setSessao(Session sessao) {
        this.sessao = sessao;
    }

    public CondicaoManutencao buscarPorAluno(Integer codAluno){
        String hql = "select u from CondicaoManutencao u where u.condicaoManutencao = :codAluno";
        Query c = this.sessao.createQuery(hql);
        c.setString("codAluno", codAluno.toString());
        return (CondicaoManutencao) c.uniqueResult();
    }
    public CondicaoManutencao carregar(Integer codigo){
        return (CondicaoManutencao) this.sessao.get(CondicaoManutencao.class, codigo);
    }
    public List<CondicaoManutencao> listar(){
        return this.sessao.createCriteria(CondicaoManutencao.class).list();
    }
    public void salvar(CondicaoManutencao condicaoManutencao){
        sessao.saveOrUpdate(condicaoManutencao);
    }
    public void excluir(CondicaoManutencao condicaoManutencao){
        sessao.delete(condicaoManutencao);
    }


}
