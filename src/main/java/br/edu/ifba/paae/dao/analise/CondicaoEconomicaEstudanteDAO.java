package br.edu.ifba.paae.dao.analise;

import br.edu.ifba.paae.entidades.analise.CondicaoEconomicaEstudante;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class CondicaoEconomicaEstudanteDAO {
    private Session sessao;

    public void setSessao(Session sessao) {
        this.sessao = sessao;
    }
    
    public CondicaoEconomicaEstudante carregar(Integer codigo){
        return (CondicaoEconomicaEstudante) this.sessao.get(CondicaoEconomicaEstudante.class, codigo);
    }
    public List<CondicaoEconomicaEstudante> listar(){
        return this.sessao.createCriteria(CondicaoEconomicaEstudante.class).list();
    }
    public void salvar(CondicaoEconomicaEstudante condicaoEconomicaEstudante){
        sessao.saveOrUpdate(condicaoEconomicaEstudante);
    }
    public void excluir(CondicaoEconomicaEstudante condicaoEconomicaEstudante){
        sessao.delete(condicaoEconomicaEstudante);
    }    
    public CondicaoEconomicaEstudante buscarPorAspectoEmAvaliacao(String tipo){
        return (CondicaoEconomicaEstudante) this.sessao.createCriteria(CondicaoEconomicaEstudante.class).add(Restrictions.eq("tipo", tipo)).uniqueResult();
        
    }    
}
