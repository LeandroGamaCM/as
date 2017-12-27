package br.edu.ifba.as.dao;

import br.edu.ifba.as.entidades.formulario.Residencia;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

public class ResidenciaDAO {
    private Session sessao;

    public void setSessao(Session sessao) {
        this.sessao = sessao;
    }

    public Residencia buscarPorAluno(Integer codAluno){
        String hql = "select u from Residencia u where u.residencia = :codAluno";
        Query c = this.sessao.createQuery(hql);
        c.setString("codAluno", codAluno.toString());
        return (Residencia) c.uniqueResult();
    }
    public Residencia carregar(Integer codigo){
        return (Residencia) this.sessao.get(Residencia.class, codigo);
    }
    public List<Residencia> listar(){
        return this.sessao.createCriteria(Residencia.class).list();
    }
    public void salvar(Residencia residencia){
        sessao.saveOrUpdate(residencia);
    }
    public void excluir(Residencia residencia){
        sessao.delete(residencia);
    }

    
}
