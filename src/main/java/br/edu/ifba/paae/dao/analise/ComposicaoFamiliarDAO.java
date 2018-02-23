package br.edu.ifba.paae.dao.analise;

import br.edu.ifba.paae.entidades.analise.ComposicaoFamiliar;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class ComposicaoFamiliarDAO {
    private Session sessao;

    public void setSessao(Session sessao) {
        this.sessao = sessao;
    }
    
    public ComposicaoFamiliar carregar(Integer codigo){
        return (ComposicaoFamiliar) this.sessao.get(ComposicaoFamiliar.class, codigo);
    }
    public List<ComposicaoFamiliar> listar(){
        return this.sessao.createCriteria(ComposicaoFamiliar.class).list();
    }
    public void salvar(ComposicaoFamiliar composicaoFamiliar){
        sessao.saveOrUpdate(composicaoFamiliar);
    }
    public void excluir(ComposicaoFamiliar composicaoFamiliar){
        sessao.delete(composicaoFamiliar);
    }      
    public ComposicaoFamiliar buscarPorAspectoEmAvaliacao(String tipo){
        return (ComposicaoFamiliar) this.sessao.createCriteria(ComposicaoFamiliar.class).add(Restrictions.eq("tipo", tipo)).uniqueResult();
        
    }    
}
