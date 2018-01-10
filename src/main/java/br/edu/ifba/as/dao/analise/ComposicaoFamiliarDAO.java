package br.edu.ifba.as.dao.analise;

import br.edu.ifba.as.entidades.analise.ComposicaoFamiliar;
import java.util.List;
import org.hibernate.Session;

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
}
