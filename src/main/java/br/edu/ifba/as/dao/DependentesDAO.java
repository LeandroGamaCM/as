package br.edu.ifba.as.dao;

import br.edu.ifba.as.entidades.formulario.Dependentes;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

public class DependentesDAO {
    private Session sessao;

    public void setSessao(Session sessao) {
        this.sessao = sessao;
    }

    public Dependentes buscarPorAluno(Integer codAluno){
        String hql = "select u from Dependentes u where u.dependentes = :codAluno";
        Query c = this.sessao.createQuery(hql);
        c.setString("codAluno", codAluno.toString());
        return (Dependentes) c.uniqueResult();
    }
    public Dependentes carregar(Integer codigo){
        return (Dependentes) this.sessao.get(Dependentes.class, codigo);
    }
    public List<Dependentes> listar(){
        return this.sessao.createCriteria(Dependentes.class).list();
    }
    public void salvar(Dependentes dependentes){
        sessao.saveOrUpdate(dependentes);
    }
    public void excluir(Dependentes dependentes){
        sessao.delete(dependentes);
    }

    
}
