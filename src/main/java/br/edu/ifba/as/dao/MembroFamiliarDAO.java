package br.edu.ifba.as.dao;

import br.edu.ifba.as.entidades.formulario.MembroFamiliar;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

public class MembroFamiliarDAO {
    private Session sessao;

    public void setSessao(Session sessao) {
        this.sessao = sessao;
    }

    public List<MembroFamiliar> buscarPorFamilia(Integer codFamilia){
        String hql = "select u from MembroFamiliar u where u.familia = :codFamilia";
        Query c = this.sessao.createQuery(hql);
        c.setString("codFamilia", codFamilia.toString());
        return c.list();
    }
    public MembroFamiliar carregar(Integer codigo){
        return (MembroFamiliar) this.sessao.get(MembroFamiliar.class, codigo);
    }
    public List<MembroFamiliar> listar(){
        return this.sessao.createCriteria(MembroFamiliar.class).list();
    }
    public void salvar(MembroFamiliar membroFamiliar){
        sessao.saveOrUpdate(membroFamiliar);
    }
    public void excluir(MembroFamiliar membroFamiliar){
        sessao.delete(membroFamiliar);
    }
    
}
