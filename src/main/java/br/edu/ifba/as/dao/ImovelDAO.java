package br.edu.ifba.as.dao;

import br.edu.ifba.as.entidades.formulario.Imovel;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

public class ImovelDAO {
    private Session sessao;

    public void setSessao(Session sessao) {
        this.sessao = sessao;
    }

    public Imovel buscarPorFamilia(Integer codFamilia){
        String hql = "select u from Imovel u where u.imovel = :codFamilia";
        Query c = this.sessao.createQuery(hql);
        c.setString("codFamilia", codFamilia.toString());
        return (Imovel) c.uniqueResult();
    }
    public Imovel carregar(Integer codigo){
        return (Imovel) this.sessao.get(Imovel.class, codigo);
    }
    public List<Imovel> listar(){
        return this.sessao.createCriteria(Imovel.class).list();
    }
    public void salvar(Imovel imovel){
        sessao.saveOrUpdate(imovel);
    }
    public void excluir(Imovel imovel){
        sessao.delete(imovel);
    }


}
