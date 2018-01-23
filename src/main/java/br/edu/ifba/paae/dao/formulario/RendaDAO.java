package br.edu.ifba.paae.dao.formulario;

import br.edu.ifba.paae.entidades.formulario.Renda;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

public class RendaDAO {
    private Session sessao;

    public void setSessao(Session sessao) {
        this.sessao = sessao;
    }

    public Renda buscarPorFamilia(Integer codFamilia){
        String hql = "select u from Renda u where u.familia = :codFamilia";
        Query c = this.sessao.createQuery(hql);
        c.setString("codFamilia", codFamilia.toString());
        return (Renda) c.uniqueResult();
    }
    public Renda carregar(Integer codigo){
        return (Renda) this.sessao.get(Renda.class, codigo);
    }
    public List<Renda> listar(){
        return this.sessao.createCriteria(Renda.class).list();
    }
    public void salvar(Renda renda){
        sessao.saveOrUpdate(renda);
    }
    public void excluir(Renda renda){
        sessao.delete(renda);
    }
        
}
