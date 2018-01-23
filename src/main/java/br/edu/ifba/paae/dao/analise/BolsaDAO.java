package br.edu.ifba.paae.dao.analise;

import br.edu.ifba.paae.entidades.analise.Bolsa;
import java.util.List;
import org.hibernate.Session;

public class BolsaDAO{
    private Session sessao;

    public void setSessao(Session sessao) {
        this.sessao = sessao;
    }
    
    public Bolsa carregar(Integer codigo){
        return (Bolsa) this.sessao.get(Bolsa.class, codigo);
    }
    public List<Bolsa> listar(){
        return this.sessao.createCriteria(Bolsa.class).list();
    }
    public void salvar(Bolsa bolsa){
        sessao.saveOrUpdate(bolsa);
    }
    public void excluir(Bolsa bolsa){
        sessao.delete(bolsa);
    }    
    
}
