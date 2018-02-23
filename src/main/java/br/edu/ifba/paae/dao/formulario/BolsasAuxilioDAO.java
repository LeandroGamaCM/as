package br.edu.ifba.paae.dao.formulario;

import br.edu.ifba.paae.entidades.formulario.BolsasAuxilio;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

public class BolsasAuxilioDAO {
    private Session sessao;

    public void setSessao(Session sessao) {
        this.sessao = sessao;
    }

    public BolsasAuxilio buscarPorAluno(Integer codAluno){
        String hql = "select u from BolsasAuxilio u where u.bolsasAuxilio = :codAluno";
        Query c = this.sessao.createQuery(hql);
        c.setString("codAluno", codAluno.toString());
        return (BolsasAuxilio) c.uniqueResult();
    }
    public BolsasAuxilio carregar(Integer codigo){
        return (BolsasAuxilio) this.sessao.get(BolsasAuxilio.class, codigo);
    }
    public List<BolsasAuxilio> listar(){
        return this.sessao.createCriteria(BolsasAuxilio.class).list();
    }
    public void salvar(BolsasAuxilio bolsasAuxilio){
        sessao.saveOrUpdate(bolsasAuxilio);
    }
    public void excluir(BolsasAuxilio bolsasAuxilio){
        sessao.delete(bolsasAuxilio);
    }


}
