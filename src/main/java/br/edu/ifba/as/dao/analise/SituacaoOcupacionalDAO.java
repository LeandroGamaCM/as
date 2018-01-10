package br.edu.ifba.as.dao.analise;

import br.edu.ifba.as.entidades.analise.SituacaoOcupacional;
import java.util.List;
import org.hibernate.Session;

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
    
}
