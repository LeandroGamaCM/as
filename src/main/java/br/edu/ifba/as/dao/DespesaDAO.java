package br.edu.ifba.as.dao;

import br.edu.ifba.as.entidades.formulario.Despesa;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

public class DespesaDAO {
    private Session sessao;

    public void setSessao(Session sessao) {
        this.sessao = sessao;
    }

    public List<Despesa> buscarPorFamilia(Integer codFamilia){
        String hql = "select u from Despesa u where u.familia = :codFamilia";
        Query c = this.sessao.createQuery(hql);
        c.setString("codFamilia", codFamilia.toString());
        return c.list();
    }
    public Despesa carregar(Integer codigo){
        return (Despesa) this.sessao.get(Despesa.class, codigo);
    }
    public List<Despesa> listar(){
        return this.sessao.createCriteria(Despesa.class).list();
    }
    public void salvar(Despesa despesa){
        sessao.saveOrUpdate(despesa);
    }
    public void excluir(Despesa despesa){
        sessao.delete(despesa);
    }
    
}
