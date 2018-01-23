package br.edu.ifba.paae.dao.formulario;

import br.edu.ifba.paae.entidades.formulario.Familia;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

public class FamiliaDAO {
    private Session sessao;

    public void setSessao(Session sessao) {
        this.sessao = sessao;
    }

    public Familia buscarPorAluno(Integer codAluno){
        String hql = "select u from Familia u where u.familia = :codAluno";
        Query c = this.sessao.createQuery(hql);
        c.setString("codAluno", codAluno.toString());
        return (Familia) c.uniqueResult();
    }
    public Familia carregar(Integer codigo){
        return (Familia) this.sessao.get(Familia.class, codigo);
    }
    public List<Familia> listar(){
        return this.sessao.createCriteria(Familia.class).list();
    }
    public void salvar(Familia familia){
        sessao.saveOrUpdate(familia);
    }
    public void excluir(Familia familia){
        sessao.delete(familia);
    }

    
}
