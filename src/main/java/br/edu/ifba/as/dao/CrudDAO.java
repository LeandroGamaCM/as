package br.edu.ifba.as.dao;


import br.edu.ifba.as.util.HibernateUtil;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import org.hibernate.*;

public abstract class CrudDAO<E> {
    private Session sessao = HibernateUtil.getSessionFactory().openSession();
    private Transaction trasacao;

    Class classe = (Class)( (ParameterizedType) getClass().getGenericSuperclass() ).getActualTypeArguments()[0];    
    
    public CrudDAO() {
    }
    
    public void salvar(E entidade){
        trasacao = sessao.beginTransaction();
        sessao.save(entidade);
        this.trasacao.commit();        
    }
    public void atualizar(E entidade){
        trasacao = sessao.beginTransaction();
        sessao.update(entidade);
        trasacao.commit();
    }
    public void excluir(E entidade){
        trasacao = sessao.beginTransaction();
        sessao.delete(entidade);
        trasacao.commit();
    }
    public List<E> listar(){
        trasacao = sessao.beginTransaction();
        Query consulta = sessao.createQuery("from " + classe.getName());
        System.out.println(classe.getName());
        trasacao.commit();
        return consulta.list();
    }
    public E buscar(int valor){
        // VER ESSE 'PARÂMETRO'. O 'codigo' deve ser a chave primária para todas as entidades
        trasacao = sessao.beginTransaction();
        Query consulta = sessao.createQuery("from " + classe.getName() + " where codigo = :parametro");
        consulta.setInteger("parametro", valor);
        trasacao.commit();
        return (E) consulta.uniqueResult();
    }
}
