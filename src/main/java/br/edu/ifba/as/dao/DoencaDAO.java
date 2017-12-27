package br.edu.ifba.as.dao;

import br.edu.ifba.as.entidades.formulario.Doenca;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

public class DoencaDAO {
    private Session sessao;

    public void setSessao(Session sessao) {
        this.sessao = sessao;
    }

    public List<Doenca> buscarPorMembroFamiliar(Integer codMembroFamiliar){
        String hql = "select u from Doenca u where u.membro_familiar = :codMembroFamiliar";
        Query c = this.sessao.createQuery(hql);
        c.setString("codMembroFamiliar", codMembroFamiliar.toString());
        return c.list();
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
