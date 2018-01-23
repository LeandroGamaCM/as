package br.edu.ifba.paae.dao.analise;

import br.edu.ifba.paae.entidades.analise.EscolaOrigem;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class EscolaOrigemDAO {
    private Session sessao;

    public void setSessao(Session sessao) {
        this.sessao = sessao;
    }
    
    public EscolaOrigem carregar(Integer codigo){
        return (EscolaOrigem) this.sessao.get(EscolaOrigem.class, codigo);
    }
    public List<EscolaOrigem> listar(){
        return this.sessao.createCriteria(EscolaOrigem.class).list();
    }
    public void salvar(EscolaOrigem escolaOrigem){
        sessao.saveOrUpdate(escolaOrigem);
    }
    public void excluir(EscolaOrigem escolaOrigem){
        sessao.delete(escolaOrigem);
    }    
    public EscolaOrigem buscarPorAspectoEmAvaliacao(String tipo){
        return (EscolaOrigem) this.sessao.createCriteria(EscolaOrigem.class).add(Restrictions.eq("tipo", tipo)).uniqueResult();
        
    }
}
