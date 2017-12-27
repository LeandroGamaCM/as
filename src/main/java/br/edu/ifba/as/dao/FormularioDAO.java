package br.edu.ifba.as.dao;

import br.edu.ifba.as.entidades.formulario.Formulario;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

public class FormularioDAO {
    private Session sessao;

    public void setSessao(Session sessao) {
        this.sessao = sessao;
    }

    public Formulario buscarPorAluno(Integer codAluno){
        String hql = "select u from Formulario u where u.formulario = :codAluno";
        Query c = this.sessao.createQuery(hql);
        c.setString("codAluno", codAluno.toString());
        return (Formulario) c.uniqueResult();
    }
    public Formulario carregar(Integer codigo){
        return (Formulario) this.sessao.get(Formulario.class, codigo);
    }
    public List<Formulario> listar(){
        return this.sessao.createCriteria(Formulario.class).list();
    }
    public void salvar(Formulario formulario){
        sessao.saveOrUpdate(formulario);
    }
    public void excluir(Formulario formulario){
        sessao.delete(formulario);
    }


}
