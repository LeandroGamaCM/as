package br.edu.ifba.as.dao.analise;

import br.edu.ifba.as.entidades.analise.SituacaoOcupacional;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class SituacaoOcupacionalDAO {
    private Session sessao;

    public void setSessao(Session sessao) {
        this.sessao = sessao;
    }
    
    public SituacaoOcupacional carregar(Integer codigo){
        return (SituacaoOcupacional) this.sessao.get(SituacaoOcupacional.class, codigo);
    }
    public List<SituacaoOcupacional> listar(){
        return this.sessao.createCriteria(SituacaoOcupacional.class).list();
    }
    public void salvar(SituacaoOcupacional bolsa){
        sessao.saveOrUpdate(bolsa);
    }
    public void excluir(SituacaoOcupacional bolsa){
        sessao.delete(bolsa);
    }    
    public SituacaoOcupacional buscarPorAspectoEmAvaliacao(String tipo){
        return (SituacaoOcupacional) this.sessao.createCriteria(SituacaoOcupacional.class).add(Restrictions.eq("tipo", tipo)).uniqueResult();
    }     
}
