package br.edu.ifba.paae.dao.analise;

import br.edu.ifba.paae.entidades.analise.Saude;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class SaudeDAO {
    private Session sessao;

    public void setSessao(Session sessao) {
        this.sessao = sessao;
    }
    
    public Saude carregar(Integer codigo){
        return (Saude) this.sessao.get(Saude.class, codigo);
    }
    public List<Saude> listar(){
        return this.sessao.createCriteria(Saude.class).list();
    }
    public void salvar(Saude saude){
        sessao.saveOrUpdate(saude);
    }
    public void excluir(Saude saude){
        sessao.delete(saude);
    }    
    public Saude buscarPorAspectoEmAvaliacao(String tipo){
        return (Saude) this.sessao.createCriteria(Saude.class).add(Restrictions.eq("tipo", tipo)).uniqueResult();
    }
}
