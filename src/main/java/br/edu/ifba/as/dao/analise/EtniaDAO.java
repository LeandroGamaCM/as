package br.edu.ifba.as.dao.analise;

import br.edu.ifba.as.entidades.analise.Etnia;
import java.util.List;
import org.hibernate.Session;

public class EtniaDAO {
    private Session sessao;

    public void setSessao(Session sessao) {
        this.sessao = sessao;
    }
    
    public Etnia carregar(Integer codigo){
        return (Etnia) this.sessao.get(Etnia.class, codigo);
    }
    public List<Etnia> listar(){
        return this.sessao.createCriteria(Etnia.class).list();
    }
    public void salvar(Etnia etnia){
        sessao.saveOrUpdate(etnia);
    }
    public void excluir(Etnia etnia){
        sessao.delete(etnia);
    }        
  
}
