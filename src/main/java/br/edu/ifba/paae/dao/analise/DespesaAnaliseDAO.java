package br.edu.ifba.paae.dao.analise;

import br.edu.ifba.paae.entidades.analise.DespesaAnalise;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class DespesaAnaliseDAO {
    private Session sessao;

    public void setSessao(Session sessao) {
        this.sessao = sessao;
    }
    
    public DespesaAnalise carregar(Integer codigo){
        return (DespesaAnalise) this.sessao.get(DespesaAnalise.class, codigo);
    }
    public List<DespesaAnalise> listar(){
        return this.sessao.createCriteria(DespesaAnalise.class).list();
    }
    public void salvar(DespesaAnalise despesaAnalise){
        sessao.saveOrUpdate(despesaAnalise);
    }
    public void excluir(DespesaAnalise despesaAnalise){
        sessao.delete(despesaAnalise);
    }        
    public DespesaAnalise buscarPorAspectoEmAvaliacao(String tipo){
        return (DespesaAnalise) this.sessao.createCriteria(DespesaAnalise.class).add(Restrictions.eq("tipo", tipo)).uniqueResult();
        
    }    
}
