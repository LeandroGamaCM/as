package br.edu.ifba.as.dao;

import br.edu.ifba.as.entidades.analise.Entrevista;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

public class EntrevistaDAO {
    private Session sessao;

    public void setSessao(Session sessao) {
        this.sessao = sessao;
    }

    public Entrevista buscarPorAluno(Integer codAluno){
        String hql = "select u from Entrevista u where u.entrevista = :codAluno";
        Query c = this.sessao.createQuery(hql);
        c.setString("codAluno", codAluno.toString());
        return (Entrevista) c.uniqueResult();
    }
    public Entrevista carregar(Integer codigo){
        return (Entrevista) this.sessao.get(Entrevista.class, codigo);
    }
    public List<Entrevista> listar(){
        return this.sessao.createCriteria(Entrevista.class).list();
    }
    public void salvar(Entrevista entrevista){
        sessao.saveOrUpdate(entrevista);
    }
    public void excluir(Entrevista entrevista){
        sessao.delete(entrevista);
    }


}
