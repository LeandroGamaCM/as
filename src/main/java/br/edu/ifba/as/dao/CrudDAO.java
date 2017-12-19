package br.edu.ifba.as.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import org.hibernate.*;

public abstract class CrudDAO<E> {
    private Session sessao;

    public void setSessao(Session sessao) {
        this.sessao = sessao;
    }

    Class classe = (Class)( (ParameterizedType) getClass().getGenericSuperclass() ).getActualTypeArguments()[0];    
    
    public CrudDAO() {
    }
    
    public void salvar(E entidade){
        sessao.save(entidade);
    }
    public void atualizar(E entidade){
        sessao.update(entidade);
    }
    public void excluir(E entidade){
        sessao.delete(entidade);
    }
    public List<E> listar(){
        Query consulta = sessao.createQuery("from " + classe.getName());
        return consulta.list();
    }
    public E buscar(int valor){
        // VER ESSE 'PARÂMETRO'. O 'codigo' deve ser a chave primária para todas as entidades
        Query consulta = sessao.createQuery("from " + classe.getName() + " where codigo = :parametro");
        consulta.setInteger("parametro", valor);
        return (E) consulta.uniqueResult();
    }
}
