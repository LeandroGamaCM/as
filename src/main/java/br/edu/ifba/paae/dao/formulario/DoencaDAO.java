package br.edu.ifba.paae.dao.formulario;

import br.edu.ifba.paae.entidades.formulario.Doenca;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

public class DoencaDAO {
    private Session sessao;

    public void setSessao(Session sessao) {
        this.sessao = sessao;
    }

    public Doenca buscarPorFamilia(Integer codFamilia){
        String hql = "select u from Doenca u where u.doenca = :codFamilia";
        Query c = this.sessao.createQuery(hql);
        c.setString("codFamilia", codFamilia.toString());
        return (Doenca) c.uniqueResult();
    }
    public Doenca carregar(Integer codigo){
        return (Doenca) this.sessao.get(Doenca.class, codigo);
    }
    public List<Doenca> listar(){
        return this.sessao.createCriteria(Doenca.class).list();
    }
    public void salvar(Doenca doenca){
        sessao.saveOrUpdate(doenca);
    }
    public void excluir(Doenca doenca){
        sessao.delete(doenca);
    }
        
}
